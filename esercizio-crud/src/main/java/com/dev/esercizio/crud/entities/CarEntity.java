package com.dev.esercizio.crud.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Car")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class CarEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String modelName;
    @Column
    private String type;

}
