package co.edu.uniquindio.prestamoobjetos;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.prestamoobjetos.controller.EmpresaPrestamoObjetosController;
import co.edu.uniquindio.prestamoobjetos.model.Cliente;
import co.edu.uniquindio.prestamoobjetos.model.Empresa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	private Stage primaryStage;

	Empresa empresa = new Empresa("Mis Prestamos", "1022");


	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Prestamo de Objetos");
		mostrarVentanaPrincipal();

	}

	public static void main(String[] args) {
		launch(args);
	}


	private void mostrarVentanaPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/EmpresaPrestamoObjetosView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			EmpresaPrestamoObjetosController empresaPrestamoObjetosController = loader.getController();
			empresaPrestamoObjetosController.setAplicacion(this);


			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Cliente> obtenerClientes() {
		return empresa.getListaClientes();
	}

	public Cliente crearCliente(String nombre, String apellido, String documento, String direccion) {

		Cliente cliente = null;

		cliente = empresa.crearCliente(nombre, apellido, documento, direccion);

		return cliente;
	}

	public boolean eliminarCliente(String documento) {

		return empresa.eliminarCliente(documento);
	}

	public boolean actualizarCliente(String documentoActual, String nombre, String apellido, String documento,String direccion) {

		return empresa.actualizarCliente(documentoActual, nombre, apellido, documento, direccion);
	}



}
