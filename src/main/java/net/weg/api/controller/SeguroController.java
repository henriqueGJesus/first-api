package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/seguro")
public class SeguroController {

    private SeguroService seguroService;

    @GetMapping("/{id}")
    public Seguro buscarUsuario(@PathVariable Integer id, @PathVariable Integer seguradoraId){
        return seguroService.buscarUm(seguradoraId,id);
    }

    @GetMapping
    public Collection<Seguro> buscarTodos(){
        return seguroService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id, @PathVariable Integer seguradoraId){
        seguroService.deletar(seguradoraId,id);
    }

    @PostMapping
    public void inserir(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.salvar(seguroCadastroDTO);
    }

    @PutMapping
    public void atualizar(@RequestBody SeguroCadastroDTO seguroCadastroDTO) {
        seguroService.salvar(seguroCadastroDTO);
    }
}
