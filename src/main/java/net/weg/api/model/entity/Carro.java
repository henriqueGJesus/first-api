package net.weg.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import net.weg.api.model.DTO.CarroCadastroDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private String marca;
    private String cor;
    private String modelo;
    private double preco;
    private Integer ano;
    @OneToOne(mappedBy = "carro")
    @JsonIgnore
    private Seguro seguro;

    public Carro(CarroCadastroDTO carroDTO) {
        this.ano= carroDTO.getAno();
        this.cor= carroDTO.getCor();
        this.marca= carroDTO.getMarca();
        this.preco= carroDTO.getPreco();
        this.modelo= carroDTO.getModelo();

    }

    @Override
    public String toString() {
        return ""+ marca+ " - "+ modelo + " - ("+placa+")";
    }
}
