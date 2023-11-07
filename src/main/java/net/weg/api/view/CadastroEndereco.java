package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.DTO.EnderecoCadastroDTO;
import net.weg.api.model.entity.Endereco;

public class CadastroEndereco extends FormLayout {
    private TextField rua = new TextField("Rua");
    private TextField bairro = new TextField("Bairro");
    private IntegerField numero = new IntegerField("Número");
    private Button salvar;
    private Button cancelar;

     CadastroEndereco(Grid<EnderecoCadastroDTO> enderecoGrid, Dialog dialog) {
        salvar = new Button("Salvar", buttonClickEvent -> {
            enderecoGrid.getListDataView().addItem(new EnderecoCadastroDTO(rua.getValue(),bairro.getValue(),numero.getValue()));
            dialog.close();
        });
        cancelar = new Button("Cancelar", event -> dialog.close());
        dialog.getFooter().add(cancelar,salvar);
        add(rua,bairro,numero);
    }
}
