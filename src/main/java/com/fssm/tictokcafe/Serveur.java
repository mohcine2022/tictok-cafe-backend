package com.fssm.tictokcafe;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@javax.persistence.Table(name = "serveur")
public class Serveur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_serveur")
    private Integer id;

    @Column(name = "nom")
    private String nom;
}

