package net.weg.api.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;

@AllArgsConstructor
@Data

public class SeguroCadastroDTO {
    private Double valor;
    private String nome;
    private String descricao;
    private Double valorFranquia;
    private Seguradora seguradora;

    private Carro carro;

    private Cliente cliente;
}
