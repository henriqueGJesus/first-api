package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.CarroService;
import net.weg.api.service.ClienteService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;

@Route(value ="/meus-seguros", layout = NavbarApp.class)
public class MeusSeguros extends VerticalLayout {
    public MeusSeguros(SeguroService seguroService,
                       SeguradoraService seguradoraService,
                       CarroService carroService, ClienteService clienteService) {

        Dialog dialog = new Dialog();
        dialog.add(new CadastroSeguro(seguroService,seguradoraService,carroService,clienteService, dialog));
        HorizontalLayout horizontalLayout= new HorizontalLayout();
        horizontalLayout.add(new H1("Meus Seguros"),new Button("Novo Seguro", e -> dialog.open()));

        Grid grid= new Grid<>(Seguro.class);
        grid.setItems(seguroService.buscarTodos());
        add(horizontalLayout,grid);
    }
}
