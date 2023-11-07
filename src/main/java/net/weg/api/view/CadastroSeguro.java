package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.model.entity.Usuario;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

public class CadastroSeguro extends FormLayout {
    private final SeguroService seguroService;

     CadastroSeguro(SeguroService seguroService,
                    SeguradoraService seguradoraService,
                    CarroService carroService, ClienteService clienteService, Dialog dialog) {

        this.seguroService = seguroService;
         NumberField valor = new NumberField("Valor");
         TextField nome = new TextField("Nome");
         TextField descricao= new TextField("Descrição");
         NumberField valorFranquia= new NumberField("Valor da franquia");

         Select<Seguradora> seguradoraSelect = new Select<>();
         seguradoraSelect.setLabel("Seguradora");
         seguradoraSelect.setItems(seguradoraService.buscarTodos());
         seguradoraSelect.setItemLabelGenerator(Seguradora::getNome);

         Select<Carro> carroSelect = new Select<>();
         carroSelect.setLabel("Carro");
         carroSelect.setItemLabelGenerator(carro -> {
             return carro.getModelo()+" Placa: "+carro.getPlaca();
         });
         carroSelect.setItems(carroService.buscarTodos());

         Select<Cliente> clienteSelect = new Select<>();
         clienteSelect.setLabel("Cliente");
         clienteSelect.setItemLabelGenerator(cliente -> {
             return cliente.getNome()+" "+cliente.getSobrenome();
         });
         clienteSelect.setItems(clienteService.buscarTodos());


         Button cancelButton = new Button("Cancelar", event -> dialog.close());
         cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
         dialog.getFooter().add(cancelButton);

         Button saveButton = new Button("Salvar", event -> {
             SeguroCadastroDTO seguroCadastroDTO = new SeguroCadastroDTO(valor.getValue(),nome.getValue(),descricao.getValue(),
                     valorFranquia.getValue(),seguradoraSelect.getValue(),carroSelect.getValue(),clienteSelect.getValue());

             try {
                 seguroService.salvar(seguroCadastroDTO);
             } catch (Exception exception) {
                 throw new RuntimeException(exception.getMessage());
             }finally {
                 dialog.close();
             }

         });
         saveButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

         dialog.getFooter().add(saveButton);

         add(valor,valorFranquia,nome,seguradoraSelect,carroSelect,clienteSelect,descricao);
    }
}
