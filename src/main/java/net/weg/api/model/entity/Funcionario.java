package net.weg.api.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario extends Usuario {

    private Double salario;
    private Integer matricula;
    private String cargo;
}
