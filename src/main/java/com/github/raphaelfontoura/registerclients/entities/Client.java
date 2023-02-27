package com.github.raphaelfontoura.registerclients.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "tb_client")
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String cpf;
        private Double income;
        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private Instant birthDate;
        private Integer children;
}
