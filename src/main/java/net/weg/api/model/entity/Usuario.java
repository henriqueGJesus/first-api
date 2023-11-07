package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    private Integer idade;
    @Column(unique = true)
    private String nome;
    private String sobrenome;
    @Column(nullable = false)
    private String senha;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;

    @Override
    public String toString() {
        return  nome + "" + sobrenome;
    }
}
