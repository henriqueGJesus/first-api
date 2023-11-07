package net.weg.api.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;


public class NavbarApp extends AppLayout {
    public NavbarApp() {
        H1 title = new H1("Segura, aí");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("left", "var(--lumo-space-l)").set("margin", "0")
                .set("position", "absolute");

        Tabs tabs = getTabs();

        addToNavbar(title, tabs);
    }

    private Tabs getTabs() {
        Tabs tabs = new Tabs();
        tabs.getStyle().set("margin", "auto");
        tabs.add(createTab("Início", Inicio.class),
                createTab("Meus Carros", MeusAutomoveis.class),
                createTab("Meus Seguros", MeusSeguros.class),
                createTab("Seguradoras"),
                createTab("Perfil")
               );
        return tabs;
    }

    private Tab createTab(String viewName) {
        RouterLink link = new RouterLink();
        link.add(viewName);
        // Demo has no routes
        // link.setRoute(viewClass.java);
        link.setTabIndex(-1);

        return new Tab(link);
    }
    private Tab createTab(String viewName, Class clase) {
        RouterLink link = new RouterLink();
        link.add(viewName);
        link.setRoute(clase);
        link.setTabIndex(-1);

        return new Tab(link);
    }
}

