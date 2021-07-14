package co.edu.uniquindio.prestamoobjetos.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.prestamoobjetos.Aplicacion;
import co.edu.uniquindio.prestamoobjetos.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmpresaPrestamoObjetosController {



	Aplicacion aplicacion;
	ObservableList<Cliente> listaClientesData = FXCollections.observableArrayList();

	Cliente clienteSeleccionado;



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtDireccion;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableColumn<Cliente, String> columnDocumento;

    @FXML
    private TableColumn<Cliente, String> columnApellido;

    @FXML
    private TableColumn<Cliente, String> columnNombre;

    @FXML
    private Button btnAgregar;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TableColumn<Cliente, String> columnDireccion;

    @FXML
    private TableView<Cliente> tableClientes;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtApellido;

    @FXML
    private Button btnActualizar;

    @FXML
    void nuevoClienteAction(ActionEvent event) {
    	nuevoCliente();
    }



	@FXML
    void agregarClienteAction(ActionEvent event) {
		agregarCliente();
    }





	@FXML
    void actualizarClienteAction(ActionEvent event) {
		actualizarCliente();
    }



	@FXML
    void eliminarClienteAction(ActionEvent event) {
    	eliminarCliente();
    }



	@FXML
    void initialize() {
    	this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	this.columnDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
    	this.columnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

    	tableClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

    		clienteSeleccionado = newSelection;
    		mostrarInformacionCliente(clienteSeleccionado);
    	});
    }



	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		tableClientes.getItems().clear();
		tableClientes.setItems(getListaClientesData());

	}

	public ObservableList<Cliente> getListaClientesData() {

		listaClientesData.addAll(aplicacion.obtenerClientes());
		return listaClientesData;
	}

	private void mostrarInformacionCliente(Cliente clienteSeleccionado) {


		if(clienteSeleccionado != null){
			txtNombre.setText(clienteSeleccionado.getNombre());
			txtApellido.setText(clienteSeleccionado.getApellido());
			txtDocumento.setText(clienteSeleccionado.getDocumento());
			txtDireccion.setText(clienteSeleccionado.getDireccion());
		}
	}

    private void nuevoCliente() {
    	txtNombre.setText("Ingrese el nombre");
		txtApellido.setText("Ingrese el apellido");
		txtDocumento.setText("Ingrese el documento");
		txtDireccion.setText("Ingrese la dirección");
	}

	private void limpiarCamposTexto() {
    	txtNombre.setText("");
		txtApellido.setText("");
		txtDocumento.setText("");
		txtDireccion.setText("");
	}

    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
	}

	private boolean mostrarMensajeConfirmacion(String mensaje) {

	   	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("Confirmación");
    	alert.setHeaderText(null);
    	alert.setContentText(mensaje);

    	Optional<ButtonType> action = alert.showAndWait();

    	if(action.get() == ButtonType.OK){
    		return true;
    	}else{
    		return false;
    	}
	}


	private boolean datosValidos(String nombre, String apellido, String documento, String direccion) {

		String mensaje = "";

		if(nombre == null || nombre.equals(""))
			mensaje += "El nombre es invalido \n";

		if(apellido == null || apellido.equals(""))
			mensaje += "El apellido es invalido \n";

		if(documento == null || documento.equals(""))
			mensaje += "El documento es invalido \n";

		if(direccion == null || direccion.equals(""))
			mensaje += "La direccion es invalida \n";

		if(mensaje.equals("")){
			return true;
		}else{
			mostrarMensaje("Información cliente", "Datos invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}



    private void agregarCliente() {

    	//1. Capturar los datos de los campos de texto
    	String nombre = txtNombre.getText();
    	String apellido = txtApellido.getText();
    	String documento = txtDocumento.getText();
    	String direccion = txtDireccion.getText();

    	//2. Validar la información
    	if(datosValidos(nombre, apellido, documento, direccion) == true){

    		//3. Registrar el cliente
    		Cliente cliente = null;

    		cliente = aplicacion.crearCliente(nombre, apellido, documento, direccion);

    		if(cliente != null){
    			listaClientesData.add(cliente);
    			limpiarCamposTexto();
    			mostrarMensaje("Notificación cliente", "Cliente registrado", "El cliente se ha registrado con éxtio", AlertType.INFORMATION);
    		}else{
    			mostrarMensaje("Notificación cliente", "Cliente no registrado", "El cliente con docuemnto "+documento+" ya se encuentra registrado", AlertType.ERROR);
    		}
    	}
	}


    private void eliminarCliente() {

    	boolean flagClienteEliminado = false;

    	if(clienteSeleccionado != null){


    		if(mostrarMensajeConfirmacion("¿Esta seguro de eliminar al cliente?") == true){

    			flagClienteEliminado = aplicacion.eliminarCliente(clienteSeleccionado.getDocumento());

        		if(flagClienteEliminado == true){

        			listaClientesData.remove(clienteSeleccionado);
        			clienteSeleccionado = null;
        			tableClientes.getSelectionModel().clearSelection();
        			limpiarCamposTexto();
        			mostrarMensaje("Notificación cliente", "Cliente eliminado", "Cliente eliminado con éxito", AlertType.INFORMATION);
        		}else{
        			mostrarMensaje("Notificación cliente", "Cliente no eliminado", "El Cliente no se logro eliminar", AlertType.ERROR);
        		}
    		}

    	}else{
    		mostrarMensaje("Notificación cliente", "Cliente no seleccionado", "Debe seleccionar un cliente", AlertType.WARNING);
    	}

	}


    private void actualizarCliente() {

    	//1. Capturar los datos de los campos de texto
    	String nombre = txtNombre.getText();
    	String apellido = txtApellido.getText();
    	String documento = txtDocumento.getText();
    	String direccion = txtDireccion.getText();

    	boolean flagClienteActualizado = false;

    	if(clienteSeleccionado != null){
        	//2. Validar la información
        	if(datosValidos(nombre, apellido, documento, direccion) == true){


        		flagClienteActualizado = aplicacion.actualizarCliente(clienteSeleccionado.getDocumento(), nombre, apellido, documento, direccion);

        		if(flagClienteActualizado == true){
        			tableClientes.refresh();
        			mostrarMensaje("Notificación cliente", "Cliente actualizado", "El cliente se ha actualizado con éxtio", AlertType.INFORMATION);
        		}else{
        			mostrarMensaje("Notificación cliente", "Cliente no actualizado", "El cliente no se puede actualizar", AlertType.ERROR);
        		}
        	}
    	}else{
    		mostrarMensaje("Notificación cliente", "Cliente no seleccionado", "Debe seleccionar un cliente", AlertType.WARNING);
    	}




	}











}

