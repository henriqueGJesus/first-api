package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.service.CarroService;


public class CadastroCarro extends FormLayout {
    private final CarroService carroService;
    public CadastroCarro(CarroService carroService, Dialog dialog) {
        this.carroService = carroService;
        TextField placa = new TextField("Placa");
        TextField modelo = new TextField("Modelo");
        TextField cor = new TextField("Cor");
        TextField marca = new TextField("Marca");
        IntegerField ano = new IntegerField("Ano");
        NumberField preco = new NumberField("Preço");

        Button cancelButton = new Button("Cancelar", event -> dialog.close());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        dialog.getFooter().add(cancelButton);

        Button saveButton = new Button("Salvar", event -> {
            CarroCadastroDTO carroCadastroDTO = new CarroCadastroDTO(placa.getValue(), marca.getValue(), cor.getValue(), modelo.getValue(), preco.getValue(), ano.getValue());
                try {
                    carroService.cadastrar(carroCadastroDTO);
                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }finally {
                    dialog.close();
                }

        });
        saveButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        dialog.getFooter().add(saveButton);

        add(placa, modelo, cor, marca, ano, preco);
    }
}
