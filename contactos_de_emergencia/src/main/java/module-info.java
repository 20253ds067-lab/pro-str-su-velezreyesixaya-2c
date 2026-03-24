module com.example.contactos_de_emergencia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contactos_de_emergencia to javafx.fxml;
    exports com.example.contactos_de_emergencia;

    opens com.example.contactos_de_emergencia.controllers to javafx.fxml;
    exports com.example.contactos_de_emergencia.controllers;

    exports com.example.contactos_de_emergencia.models;
}