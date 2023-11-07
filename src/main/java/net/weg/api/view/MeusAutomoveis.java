package net.weg.api.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;

@Route(value ="/meus-autos", layout = NavbarApp.class)
public class MeusAutomoveis extends VerticalLayout {


    public MeusAutomoveis(CarroService carroService) {
        Dialog dialog = new Dialog();
        dialog.add(new CadastroCarro(carroService, dialog));
        HorizontalLayout horizontalLayout= new HorizontalLayout();
        horizontalLayout.add(new H1("Meus Automóveis"),new Button("Novo Carro",e -> dialog.open()));

        add(horizontalLayout);
        Grid grid= new Grid(Carro.class);
        grid.setItems(carroService.buscarTodos());
        add(grid);
    }


}
