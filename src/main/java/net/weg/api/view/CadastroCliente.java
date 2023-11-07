package net.weg.api.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.EnderecoCadastroDTO;
import net.weg.api.model.DTO.UsuarioCadastroDTO;
import net.weg.api.model.entity.Endereco;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

@Route(value ="/teste", layout = NavbarApp.class)
public class CadastroCliente extends FormLayout {
    private TextField  nome = new TextField("Nome");
    private TextField  sobrenome = new TextField("Sobrenome");
    private TextField usuario = new TextField("Username");
    private PasswordField senha = new PasswordField("Senha");
    private PasswordField confirmacaoSenha = new PasswordField("Confirme sua senha");
    private IntegerField idade = new IntegerField("Idade");
    private Grid<EnderecoCadastroDTO> gridEnderecos = new Grid<>(EnderecoCadastroDTO.class);
    private Dialog cadastroEndereco = new Dialog();
    private ClienteService clienteService;
    private Button novoEndereco;
    private Button salvar;
    private Button cancelar;


    public CadastroCliente(ClienteService clienteService) {
        this.clienteService=clienteService;
        cadastroEndereco.add(new CadastroEndereco(gridEnderecos,cadastroEndereco));

        novoEndereco = new Button("Novo endereço", event -> cadastroEndereco.open());
        Notification notification= new Notification();
        notification.setDuration(3000);

                salvar = new Button("Salvar", event -> {
                    Set<Endereco> enderecos = new HashSet<>();
                    try {
                        if(!senha.getValue().equals(confirmacaoSenha.getValue())){
                            throw new RuntimeException();
                        }

                        gridEnderecos.getListDataView().getItems().forEach(
                                enderecoCadastroDTO -> {
                                    Endereco endereco = new Endereco();
                                    BeanUtils.copyProperties(enderecoCadastroDTO, endereco);
                                    enderecos.add(endereco);
                                }
                        );
                        clienteService.salvar(
                                new UsuarioCadastroDTO(nome.getValue(),sobrenome.getValue(),usuario.getValue(), senha.getValue(), idade.getValue(), enderecos));
                            notification.setText("Cadastrado com sucesso");
                            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                    }catch (Exception exception){
                        notification.setText("Erro no cadastro do Usario");
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    }finally {
                        notification.open();
                    }
                });

                cancelar = new Button("Cancelar", e -> new UI().navigate("/"));


        add(sobrenome,nome,usuario, senha, confirmacaoSenha,idade, gridEnderecos, cadastroEndereco,salvar,cancelar, novoEndereco);
    }
}
