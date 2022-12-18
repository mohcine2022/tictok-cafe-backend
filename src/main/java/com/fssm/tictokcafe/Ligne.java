package com.fssm.tictokcafe;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ligne")
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_consommation")
    private Consommation consommation;

//    @ManyToOne
//    @JoinColumn(name = "id_commande")
//    @JsonIgnore
//    private Commande commande;


    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "montant_ligne")
    private Double montantLigne;
}
