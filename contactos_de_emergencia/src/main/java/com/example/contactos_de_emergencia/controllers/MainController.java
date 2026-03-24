package com.example.contactos_de_emergencia.controllers;

import com.example.contactos_de_emergencia.models.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cmbParentesco;
    @FXML private ListView<Contacto> listaContactosView;
    @FXML private Label lblMensaje;


    private ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();

    private String[] arregloParentescos = {
            "Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    public void initialize() {
        cmbParentesco.getItems().addAll(arregloParentescos);
        listaContactosView.setItems(listaContactos);
    }


    @FXML
    public void agregarContacto() {
        if (!validarCampos()) return;

        String nombre = txtNombre.getText().trim();
        if (buscarPorNombre(nombre) != null) {
            mostrarMensaje("Ya existe un contacto con ese nombre", true);
            return;
        }

        Contacto nuevo = new Contacto(nombre, txtTelefono.getText().trim(), cmbParentesco.getValue());
        listaContactos.add(nuevo);
        limpiarCampos();
        mostrarMensaje("Contacto agregado correctamente", false);
    }

    @FXML
    public void buscarContacto() {
        String nombreABuscar = txtNombre.getText().trim();
        if (nombreABuscar.isEmpty()) {
            mostrarMensaje("Escribe un nombre para buscar", true);
            return;
        }

        Contacto encontrado = buscarPorNombre(nombreABuscar);
        if (encontrado != null) {
            txtTelefono.setText(encontrado.getTelefono());
            cmbParentesco.setValue(encontrado.getParentesco());
            mostrarMensaje("Contacto encontrado", false);
        } else {
            mostrarMensaje("No se encontro el contacto.", true);
            limpiarCamposBasicos();
        }
    }

    @FXML
    public void actualizarContacto() {
        String nombre = txtNombre.getText().trim();
        Contacto existente = buscarPorNombre(nombre);

        if (existente == null) {
            mostrarMensaje("Primero busca un contacto por nombre para actualizar", true);
            return;
        }

        if (validarCampos()) {
            existente.setTelefono(txtTelefono.getText().trim());
            existente.setParentesco(cmbParentesco.getValue());
            listaContactosView.refresh();
            mostrarMensaje("Contacto actualizado correctamente", false);
            limpiarCampos();
        }
    }

    @FXML
    public void eliminarContacto() {
        String nombre = txtNombre.getText().trim();
        Contacto existente = buscarPorNombre(nombre);

        if (existente != null) {
            listaContactos.remove(existente);
            limpiarCampos();
            mostrarMensaje("Contacto eliminado", false);
        } else {
            mostrarMensaje("No se encontro el contacto para eliminar", true);
        }
    }

    @FXML
    public void limpiarCampos() {
        txtNombre.clear();
        limpiarCamposBasicos();
        lblMensaje.setText("");
    }

    private void limpiarCamposBasicos() {
        txtTelefono.clear();
        cmbParentesco.setValue(null);
    }

    private Contacto buscarPorNombre(String nombre) {
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    private boolean validarCampos() {
        if (txtNombre.getText().trim().isEmpty()) {
            mostrarMensaje("El nombre no puede estar vacio", true);
            return false;
        }
        String tel = txtTelefono.getText().trim();
        if (tel.isEmpty() || !tel.matches("\\d{10}")) {
            mostrarMensaje("El telefono debe tener exactamente 10 dígitos numericos", true);
            return false;
        }
        if (cmbParentesco.getValue() == null) {
            mostrarMensaje("Debes seleccionar un parentesco", true);
            return false;
        }
        return true;
    }

    private void mostrarMensaje(String mensaje, boolean esError) {
        lblMensaje.setText(mensaje);
    }
}