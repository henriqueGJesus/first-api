package net.weg.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Seguro {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    //Primeiro Exemplo de como criar uma chave composta

//    Segundo exemplo de criar uma chave composta
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer seguroId;
//    @Id
//    private Integer seguradoraIdClass;
    @EmbeddedId
    private SeguroId id =new SeguroId();
    private Double valor;
    private String nome;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
    @MapsId("seguradoraId")
    private Seguradora seguradora;
    @OneToOne
    @EqualsAndHashCode.Exclude
    private Carro carro;
    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
}
