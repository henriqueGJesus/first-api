package net.weg.api.repository;

import net.weg.api.model.Habilitacao;
import net.weg.api.model.Seguradora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguradoraRepository extends JpaRepository<Seguradora,Integer> {
}
