package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.CarroEdicaoDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Service
public class CarroService {


    private final CarroRepository carroRepository;

    public Carro cadastrar(CarroCadastroDTO carroDTO) throws Exception {
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO, carro);
        return salvar(carro);
    }

    @PutMapping
    public Carro editar(@RequestBody CarroEdicaoDTO carroAtualizadoDTO) throws Exception {
        if (!carroRepository.existsById(carroAtualizadoDTO.getId())) {
            throw new Exception("Não foi encontrado nenhum carro com esse id");
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroAtualizadoDTO, carro);
        return salvar(carro);
    }

    private Carro salvar(Carro carro) throws Exception {
        if (carroRepository.existsByPlaca(carro.getPlaca())) {
            throw new Exception("Há um carro com a placa: " + carro.getPlaca());
        }
        return carroRepository.save(carro);
    }

    public void deletar(Integer id) {
        carroRepository.deleteById(id);
    }


    public Carro buscarUm(Integer id) {
        return carroRepository.findById(id).get();
    }

    public Collection<Carro> buscarTodos() {
        return carroRepository.findAll();
    }

    public List<Carro> buscarModelo(String modelo) {
        return carroRepository.findByModelo(modelo);
    }

    public Collection<Carro> buscarCarrosSeguradora(Integer id) throws Exception {
        if (carroRepository.existsById(id)) {
            return carroRepository.findBySeguro_SeguradoraId(id);
        }
        throw new Exception();
    }
}