package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.CarroEdicaoDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {


    private CarroService carroService;

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarUsuario(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(carroService.buscarUm(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("seguradora/{id}")
    public ResponseEntity<Collection<Carro>> buscarCarrosSeguradora(@PathVariable Integer id) {
        try {
            return new ResponseEntity<Collection<Carro>>(carroService.buscarCarrosSeguradora(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public Collection<Carro> buscarTodos() {
        return carroService.buscarTodos();
    }

    @GetMapping("/modelo")
    public List<Carro> buscarmodelo(@RequestParam String modelo) {
        return carroService.buscarModelo(modelo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        carroService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Carro> inserir(@RequestBody CarroCadastroDTO carroDTO) {
        try {
            return new ResponseEntity<Carro>(carroService.cadastrar(carroDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Carro> atualizar(@RequestBody CarroEdicaoDTO carroAtualizadoDTO) {
        try {
            return new ResponseEntity<Carro>(carroService.editar(carroAtualizadoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Carro>(HttpStatus.CONFLICT);
        }
    }
}
          