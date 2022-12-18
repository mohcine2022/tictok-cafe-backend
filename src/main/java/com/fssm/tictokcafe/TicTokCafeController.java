package com.fssm.tictokcafe;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TicTokCafeController {

    private final CommandeRepository commandeRepository;
    private final ServeurRepository serveurRepository;
    private final ConsommationRepository consommationRepository;
    private final TableRepository tableRepository;

    public TicTokCafeController(CommandeRepository commandeRepository, ServeurRepository serveurRepository, ConsommationRepository consommationRepository, TableRepository tableRepository) {
        this.commandeRepository = commandeRepository;
        this.serveurRepository = serveurRepository;
        this.consommationRepository = consommationRepository;
        this.tableRepository = tableRepository;
    }


    @GetMapping("/consommations")
    public List<Consommation> listeConsommations() {
        return consommationRepository.findAll();
    }

    @GetMapping("/commandes")
    public List<Commande> listeCommandes() {
        return commandeRepository.findAll();
    }

    @GetMapping("/tables")
    public List<Table> listeTables() {
        return tableRepository.findAll();
    }

    @GetMapping("/serveurs")
    public List<Serveur> listeServeurs() {
        return serveurRepository.findAll();
    }

    @PostMapping("/serveurs")
    public Serveur createSrveur(@RequestBody Serveur serveur) {
        return serveurRepository.save(serveur);
    }

    @PostMapping("/commandes")
    public Commande createCommande(@RequestBody Commande commande) {

        double total = commande.getLignes().stream().mapToDouble(ligne -> {
            Optional<Consommation> consommation = consommationRepository.findById(ligne.getConsommation().getId());
            return consommation.map(value -> (value.getPrixUnitaire() != null ? value.getPrixUnitaire(): 0) * (ligne.getQuantite() != null ? ligne.getQuantite(): 0)).orElse(0.0);

        }).sum();

        commande.getLignes().forEach(ligne -> {
            Optional<Consommation> consommation = consommationRepository.findById(ligne.getConsommation().getId());
            consommation.ifPresent(value -> ligne.setMontantLigne((value.getPrixUnitaire() != null ? value.getPrixUnitaire() : 0) * (ligne.getQuantite() != null ? ligne.getQuantite() : 1)));
        });

        commande.setMontantTotal(total);

        return commandeRepository.save(commande);
    }

    @PostMapping("/tables")
    public Table createTable(@RequestBody Table table) {
        return tableRepository.save(table);
    }

    @PostMapping("/consommations")
    public Consommation createConsommation(@RequestBody Consommation consommation) {
        return consommationRepository.save(consommation);
    }

}
