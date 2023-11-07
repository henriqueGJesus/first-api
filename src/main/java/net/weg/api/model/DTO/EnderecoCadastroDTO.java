package net.weg.api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCadastroDTO {
    private String rua,bairro;
    private Integer numero;
}
