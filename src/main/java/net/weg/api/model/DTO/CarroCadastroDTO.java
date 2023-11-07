package net.weg.api.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.entity.Seguro;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroCadastroDTO {
    private String placa;
    private String marca;
    private String cor;
    private String modelo;
    private double preco;
    private Integer ano;
    @OneToOne(mappedBy = "carro")
    @JsonIgnore
    private Seguro seguro;

    public CarroCadastroDTO(String placa, String marca, String cor, String modelo, double preco, Integer ano) {
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.preco = preco;
        this.ano = ano;
    }
}
