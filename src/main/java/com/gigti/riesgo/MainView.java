package com.gigti.riesgo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route
@PWA(name = "App de Riesgo PsicoSocial", shortName = "Riesgo", description = "Aplicación para medir riesgo PsicoSocial dentro de organizaciones", enableInstallPrompt = true)
@Theme(value = Lumo.class)
@PageTitle(value = "Vista Princiapl")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends AppLayout implements RouterLayout, BeforeEnterObserver {

    private Button menu_ingresar;

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed
     *                bean.
     */
    public MainView() {

        this.setDrawerOpened(true);
        createHeader();
        this.setPrimarySection(Section.DRAWER);
    }

    private void createHeader() {
        H4 appTitle = new H4("App de Riesgo PsicoSocial");
        appTitle.addClassName("logo");
        //appTitle.getElement().setAttribute("font-size", "1em");
        appTitle.getElement().setAttribute("margin", "2px");

        menu_ingresar = new Button("Admin", new Icon(VaadinIcon.USER));
        menu_ingresar.addThemeVariants(ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_ICON);
        // menu_salir.addClickListener(listener -> signOut());
        menu_ingresar.setClassName("menubutton");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), appTitle, menu_ingresar);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER); //
        header.setWidth("100%");
        header.addClassName("header");
        header.expand(appTitle);
        addToNavbar(header);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent arg0) {
        // TODO Auto-generated method stub

    }

}
