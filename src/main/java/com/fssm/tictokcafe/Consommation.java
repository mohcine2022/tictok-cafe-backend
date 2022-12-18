package com.fssm.tictokcafe;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@javax.persistence.Table(name = "consommation")
public class Consommation {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "prix_unitaire")
    private Double prixUnitaire;
}
