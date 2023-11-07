package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class  Cliente extends Usuario{

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Carro> carros;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Habilitacao habilitacao;

    @Override
    public String toString() {
        return super.toString();
    }
}
