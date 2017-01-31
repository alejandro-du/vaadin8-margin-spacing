package com.example;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

public class WebConfig {

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false, widgetset = "com.vaadin.v7.Vaadin7WidgetSet")
    public static class MyUIServlet extends VaadinServlet {
    }

    @WebServlet(urlPatterns = "/vaadin7/*", name = "My7UIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = My7UI.class, productionMode = false, widgetset = "com.vaadin.v7.Vaadin7WidgetSet")
    public static class My7UIServlet extends VaadinServlet {
    }

}
