package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        TextField username = new TextField();
        username.setPlaceholder("Username");
        username.setWidth("100%");
        PasswordField password = new PasswordField();
        password.setPlaceholder("Password");
        password.setWidth("100%");
        Label forgot = new Label("Forgot password? <a>Click here to restore</a>", ContentMode.HTML);
        Button signin = new Button("Sign in");
        signin.addStyleName(ValoTheme.BUTTON_PRIMARY);
        signin.addStyleName(ValoTheme.BUTTON_HUGE);

        Label loginOptions = new Label("<i>You can also sign in with your social account:</i>", ContentMode.HTML);
        Button facebook = new Button("Facebook", FontAwesome.FACEBOOK);
        Button twitter = new Button("Twitter", FontAwesome.TWITTER);
        Button google = new Button("Google", FontAwesome.GOOGLE);
        Label openIdLabel = new Label("<i>Or use your OpenID to sign in:</i>", ContentMode.HTML);
        TextField openId = new TextField();
        openId.setPlaceholder("Open Id");
        openId.setWidth("100%");
        Button go = new Button("Go");
        go.addStyleName(ValoTheme.BUTTON_PRIMARY);
        Label warning = new Label("<i>You may want to disable pop up blockers to sign in with above sites.</i>", ContentMode.HTML);
        warning.addStyleName(ValoTheme.LABEL_TINY);

        HorizontalLayout sites = new HorizontalLayout(facebook, twitter, google);

        CssLayout openIdLayout = new CssLayout(openId, go);
        openIdLayout.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        VerticalLayout left = new VerticalLayout(username, password, forgot, signin);
        VerticalLayout right = new VerticalLayout(loginOptions, sites, openIdLabel, openIdLayout, warning);

        HorizontalSplitPanel form = new HorizontalSplitPanel(left, right);
        form.setSplitPosition(352, Unit.PIXELS);

        Panel panel = new Panel("Sign in", form);

        VerticalLayout main = new VerticalLayout(panel);
        setContent(main);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
