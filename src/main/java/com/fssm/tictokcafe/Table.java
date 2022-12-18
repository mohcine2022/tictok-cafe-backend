package com.fssm.tictokcafe;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@javax.persistence.Table(name = "table_cafe")
public class Table {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_table")
    private Integer id;


    @Column(name = "numero_table")
    private String numeroTable;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_serveur")
    private Serveur serveur;

}
