package net.weg.api.repository;

import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
    List<Carro> findByModelo (String modelo);

    List<Carro> findBySeguro (Seguro seguro);

    List<Carro> findBySeguro_SeguradoraId(Integer id);

    Boolean existsByPlaca(String placa);
}
