package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.UsuarioCadastroDTO;
import net.weg.api.model.entity.Cliente;
import net.weg.api.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/{id}")
    public Cliente buscarUsuario(@PathVariable Integer id){
        return clienteService.buscarUm(id);
    }

    @GetMapping
    public Collection<Cliente> buscarTodos(){
        return clienteService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        clienteService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO){

        clienteService.salvar(usuarioCadastroDTO);
    }

    @PutMapping
    public void atualizar(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO){
        clienteService.salvar(usuarioCadastroDTO);
    }

}
