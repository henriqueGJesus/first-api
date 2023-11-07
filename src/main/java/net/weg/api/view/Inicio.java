package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Carro;

@Route(value ="/inicio", layout = NavbarApp.class)
public class Inicio extends VerticalLayout {
    public Inicio() {
        HorizontalLayout horizontalLayout= new HorizontalLayout();
        horizontalLayout.add(new H1("Inicio"));
        add(horizontalLayout);


    }
}
