package com.fssm.tictokcafe;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@javax.persistence.Table(name = "commande")
public class Commande {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "heure")
    private LocalTime heure;

    @Column(name = "montant_total")
    private Double montantTotal;

    @ManyToOne
    @JoinColumn(name = "id_table")
    private Table table;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ligne> lignes;
}
