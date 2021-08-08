package co.edu.uniquindio.prestamoobjeto.controller;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.prestamoobjeto.Aplicacion;
import co.edu.uniquindio.prestamoobjeto.exception.ClienteExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.ClienteNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.ClientePertencePrestamoException;
import co.edu.uniquindio.prestamoobjeto.exception.DatosInvalidosException;
import co.edu.uniquindio.prestamoobjeto.exception.DetalleNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.EmpleadoExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.EmpleadoNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.EmpleadoPertenecePrestamoException;
import co.edu.uniquindio.prestamoobjeto.exception.ObjetoExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.ObjetoNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.PrestamoExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.PrestamoNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.SinCantidadDisponibleException;
import co.edu.uniquindio.prestamoobjeto.model.Cliente;
import co.edu.uniquindio.prestamoobjeto.model.DetallePrestamo;
import co.edu.uniquindio.prestamoobjeto.model.Empleado;
import co.edu.uniquindio.prestamoobjeto.model.Objeto;
import co.edu.uniquindio.prestamoobjeto.model.Prestamo;
import co.edu.uniquindio.prestamoobjeto.model.TipoDocumento;
import co.edu.uniquindio.prestamoobjeto.model.TipoEmpleado;
import co.edu.uniquindio.prestamoobjeto.model.TipoObjeto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
/**
 * Esta clase representa el controlador de la interfaz
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona Brayan Felipe Tangarife Rios
 *
 */

public class EmpresaPrestamoObjetosController {


	Aplicacion aplicacion;

	ObservableList<Cliente> listaClientesData = FXCollections.observableArrayList();
	ObservableList<Empleado> listaEmpleadosData = FXCollections.observableArrayList();
	ObservableList<Objeto> listaObjetosData = FXCollections.observableArrayList();
	ObservableList<Prestamo> listaPrestamosData = FXCollections.observableArrayList();
	ObservableList<Cliente> listaDocumentoClienteData = FXCollections.observableArrayList();
	ObservableList<Empleado> listaDocumentoEmpleadoData = FXCollections.observableArrayList();
	ObservableList<DetallePrestamo> listaDetallePrestamoData = FXCollections.observableArrayList();

	Cliente clienteSeleccionado;
	Empleado empleadoSeleccionado;
	Objeto objetoSeleccionado;
	Prestamo prestamoSeleccionado;
	DetallePrestamo detalleSeleccionado;

	  @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TableView<Prestamo> tableInfPrestamo;

	    @FXML
	    private TextField txtNombreObjeto;

	    @FXML
	    private TableColumn<Objeto, String> columnNombreObjeto;

	    @FXML
	    private TextField txtValorUnitarioObjeto;

	    @FXML
	    private Button btnNuevoDetallePrestamo;

	    @FXML
	    private Button btnEliminarPrestamo;

	    @FXML
	    private TextField txtApellidoCliente;

	    @FXML
	    private Button btnAgregarCliente;

	    @FXML
	    private TextField txtAniosExperienciaEmpleado;

	    @FXML
	    private TextField txtDepartamentoEmpleado;

	    @FXML
	    private TextField txtApellidoEmpleado;

	    @FXML
	    private ComboBox<TipoObjeto> comboTipoObjeto;

	    @FXML
	    private TextField txtCodigoObjeto;

	    @FXML
	    private TableView<Prestamo> tableCodigoPrestamoDetalle;

	    @FXML
	    private TableColumn<Prestamo, String> columnCodigoPrestamoInf;

	    @FXML
	    private TableColumn<Empleado, String> columnDireccionEmpleados;

	    @FXML
	    private TableColumn<Objeto, String> columnDescripcionObjeto;

	    @FXML
	    private Button btnActualizarTablaObjeto;

	    @FXML
	    private ComboBox<TipoDocumento> comboTipoDocumentoCliente;

	    @FXML
	    private Button btnNuevoObjeto;

	    @FXML
	    private ComboBox<String> comboGeneroCliente;

	    @FXML
	    private ComboBox<TipoEmpleado> comboTipoEmpleado;

	    @FXML
	    private Label labelDiasTranscurridosPrestamo;

	    @FXML
	    private Button btnActualizarPrestamo;

	    @FXML
	    private TextField txtNombreEmpleado;

	    @FXML
	    private TextField txtCorreoCliente;

	    @FXML
	    private TableView<DetallePrestamo> tableDetallePrestamo;

	    @FXML
	    private Label labelDiasMora;

	    @FXML
	    private TableColumn<Empleado, String> columnApellidoEmpleados;

	    @FXML
	    private TableColumn<Cliente, String> columnNombreCliente;

	    @FXML
	    private TextField txtCiudadEmpleado;

	    @FXML
	    private ImageView imageObjeto;

	    @FXML
	    private TextField txtDireccionEmpleado;

	    @FXML
	    private TableView<Objeto> tableInfObjeto;

	    @FXML
	    private TextField txtUnidadesDisponiblesObjeto;

	    @FXML
	    private TableColumn<Empleado, String> columnDocumentoEmpleado;

	    @FXML
	    private TableColumn<Objeto, String> columnCodigoObjeto;

	    @FXML
	    private TextField txtDocumentoClientePrestamo;

	    @FXML
	    private TableColumn<Objeto, String> columnEstadoObjeto;

	    @FXML
	    private TableColumn<DetallePrestamo, String> columnCodigoPrestamoDetalle;

	    @FXML
	    private Button btnAgregarEmpleado;

	    @FXML
	    private TableView<DetallePrestamo> tableUnidadesPrestadasInf;

	    @FXML
	    private Button btnActualizarCliente;

	    @FXML
	    private Button btnAgregarObjeto;

	    @FXML
	    private TableColumn<DetallePrestamo, String> columnUnidadesObjetoInf;

	    @FXML
	    private Button btnEliminarEmpleados;

	    @FXML
	    private Button btnEliminarDetallePrestamo;

	    @FXML
	    private Label labelDiasSolicitadosPreestamo;

	    @FXML
	    private TextField txtProfesionCliente;

	    @FXML
	    private TableView<Empleado> tableEmpleados;

	    @FXML
	    private TextField txtColorObjeto;

	    @FXML
	    private TableView<Objeto> tableCodigoObjetoDetalle;

	    @FXML
	    private TableView<Prestamo> tablePrestamo;

	    @FXML
	    private TableView<Cliente> tableDocumentoClientePrestamo;

	    @FXML
	    private TableView<Empleado> tableDocumentoEmpleadoPrestamo;

	    @FXML
	    private Button btnAgregarPrestamo;

	    @FXML
	    private TableColumn<Cliente, String> columnDocumentoCliente;

	    @FXML
	    private TableColumn<Cliente, String> columnDocumentoClientePrestamoInf;

	    @FXML
	    private TableColumn<Empleado, String> columnDocumentoEmpleadoPrestamoInf;

	    @FXML
	    private TextField txtPaisCliente;

	    @FXML
	    private ComboBox<String> comboFiltrar;

	    @FXML
	    private ComboBox<TipoDocumento> comboTipoDocumentoEmpleado;

	    @FXML
	    private DatePicker dateFechaEntregaPrestamo;

	    @FXML
	    private Label labelValorPrestamo;

	    @FXML
	    private TableView<Cliente> tableClientes;

	    @FXML
	    private TableColumn<Cliente, String> columnDireccionCliente;

	    @FXML
	    private TableColumn<Cliente, String> columnDocumentoClientePrestamo;

	    @FXML
	    private TextField txtPaisEmpleado;

	    @FXML
	    private TextField txtDocumentoCliente;

	    @FXML
	    private TextField txtCodigoPrestamo;

	    @FXML
	    private TableColumn<Empleado, String> columnNombreEmpleados;

	    @FXML
	    private Label labelEstadoPrestamo;

	    @FXML
	    private Button btnNuevoCliente;

	    @FXML
	    private TextField txtTelCelularCliente;

	    @FXML
	    private TextField txtCodigoObjetoDetalle;

	    @FXML
	    private TableColumn<DetallePrestamo, String> columnUnidPrestadasDetalle;

	    @FXML
	    private Label labelDocCliente;

	    @FXML
	    private TextField txtDepartamentoCliente;

	    @FXML
	    private TextField txtTelResidenciaEmpleado;

	    @FXML
	    private Button btnSeleccionarFoto;

	    @FXML
	    private Button btnEliminarObjeto;

	    @FXML
	    private Label labelDocEmpleado;

	    @FXML
	    private Button btnActualizarEmpleado;

	    @FXML
	    private TextField txtTelResidenciaCliente;

	    @FXML
	    private Button btnEliminarCliente;

	    @FXML
	    private Button btnAgregarDetallePrestamo;

	    @FXML
	    private TableColumn<Prestamo, String> columnCodigoPrestamo;

	    @FXML
	    private TableColumn<Cliente, String> columnApellidoCliente;

	    @FXML
	    private TableColumn<Prestamo, String> columnFechaEntrega;

	    @FXML
	    private Label labelSubTotal;

	    @FXML
	    private TextField txtTelCelularEmpleado;

	    @FXML
	    private Label labelFechaPrestamo;

	    @FXML
	    private Button btnNuevoEmpleado;

	    @FXML
	    private TableColumn<Objeto, String> columnCodigoObjetoDetalle;

	    @FXML
	    private TextField txtCiudadCliente;

	    @FXML
	    private TextField txtDescripcionObjeto;

	    @FXML
	    private TableColumn<TipoObjeto, String> columnTipoObjetoInf;

	    @FXML
	    private TextField txtDireccionCliente;

	    @FXML
	    private Button btnActualizarObjeto;

	    @FXML
	    private TextField txtPesoObjeto;

	    @FXML
	    private TextField txtCodigoPrestamoDetalle;

	    @FXML
	    private Label labelEstadoObjeto;

	    @FXML
	    private Label labelUnidadesPrestadas;


	    @FXML
	    private TextField txtNombreCliente;

	    @FXML
	    private TableView<Objeto> tableObjetos;

	    @FXML
	    private TextField txtUnidadesPrestadasDetalle;

	    @FXML
	    private TextField txtCorreoEmpleado;

	    @FXML
	    private TableColumn<DetallePrestamo, String> columnSubtotalDetalle;

	    @FXML
	    private Label labelDiasRestantes;

	    @FXML
	    private Button btnNuevoPrestamo;

	    @FXML
	    private TextField txtDocumentoEmpleadoPrestamo;

	    @FXML
	    private Label labelValorTotalObjeto;

	    @FXML
	    private TextField txtDocumentoEmpleado;

	    @FXML
	    private TableColumn<Objeto, String> columnCodigoObjetoInf;

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
	    void nuevoEmpleadoAction(ActionEvent event) {
	    	nuevoEmpleado();

	    }


		@FXML
	    void agregarEmpleadoAction(ActionEvent event) {
			agregarEmpleado();
	    }


		@FXML
	    void actualizarEmpleadoAction(ActionEvent event) {
			actualizarEmpleado();
	    }


		@FXML
	    void eliminarEmpleadoAction(ActionEvent event) {
			eliminarEmpleado();
	    }

		@FXML
	    void nuevoObjetoAction(ActionEvent event) {
			nuevoObjeto();
	    }


		@FXML
	    void agregarObjetoAction(ActionEvent event) {
			agregarObjeto();
	    }


		@FXML
	    void actualizarObjetoAction(ActionEvent event) {
			actualizarObjeto();
	    }


		@FXML
	    void seleccionarFotoAction(ActionEvent event) {
	    	FileChooser fileChooser = new FileChooser();
	        fileChooser.setTitle("Buscar Imagen");

	        fileChooser.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("All Images", "*.*"),
	                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	                new FileChooser.ExtensionFilter("PNG", "*.png")
	        );

	        File imgFile = fileChooser.showOpenDialog(aplicacion.getPrimaryStage());

	        if (imgFile != null) {
	            Image image = new Image("file:" + imgFile.getAbsolutePath());
	            imageObjeto.setImage(image);
	        }
	    }

	    @FXML
	    void eliminarObjetoAction(ActionEvent event) {
	    	eliminarObjeto();
	    }


		@FXML
	    void actualizarTablaAction(ActionEvent event) {

	    }

	    @FXML
	    void nuevoPrestamoAction(ActionEvent event) {
	    	nuevoPrestamo();
	    }


		@FXML
	    void agregarPrestamoAction(ActionEvent event) {
			agregarPrestamo();
	    }


		@FXML
	    void actualizarPrestamoAction(ActionEvent event) {
			actualizarPrestamo();
	    }



	    @FXML
	    void nuevoDetallePrestamoAction(ActionEvent event) {
	    	nuevoDetallePrestamo();
	    }



		@FXML
	    void agregarDetallePrestamoAction(ActionEvent event) {
			agregarDetallePrestamo();
	    }

	    @FXML
	    void initialize() {
	    	this.columnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
	    	this.columnApellidoCliente.setCellValueFactory(new PropertyValueFactory<>("apellido"));
	    	this.columnDocumentoCliente.setCellValueFactory(new PropertyValueFactory<>("documento"));
	    	this.columnDireccionCliente.setCellValueFactory(new PropertyValueFactory<>("direccion"));

	    	this.columnNombreEmpleados.setCellValueFactory(new PropertyValueFactory<>("nombre"));
	    	this.columnApellidoEmpleados.setCellValueFactory(new PropertyValueFactory<>("apellido"));
	    	this.columnDocumentoEmpleado.setCellValueFactory(new PropertyValueFactory<>("documento"));
	    	this.columnDireccionEmpleados.setCellValueFactory(new PropertyValueFactory<>("direccion"));

	    	this.columnNombreObjeto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
	    	this.columnCodigoObjeto.setCellValueFactory(new PropertyValueFactory<>("codigo"));
	    	this.columnDescripcionObjeto.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
	    	this.columnEstadoObjeto.setCellValueFactory(new PropertyValueFactory<>("estado"));

	    	this.columnCodigoPrestamo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
	    	this.columnFechaEntrega.setCellValueFactory(new PropertyValueFactory<>("fechaEntrega"));

	    	tableClientes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

	    		clienteSeleccionado = newSelection;

	    		mostrarInformacionCliente(clienteSeleccionado);

	    	});

	    	tableEmpleados.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

	    		empleadoSeleccionado = newSelection;

	    		mostrarInformacionEmpleado(empleadoSeleccionado);

	    	});

	    	tableObjetos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

	    		objetoSeleccionado = newSelection;

	    		mostrarInformacionObjeto(objetoSeleccionado);

	    	});

	    	tablePrestamo.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

	    		prestamoSeleccionado = newSelection;

	    		mostrarInformacionPrestamo(prestamoSeleccionado);

	    	});

	    	tableDetallePrestamo.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{

	    		detalleSeleccionado = newSelection;

	    		mostrarInformacionDetalle(detalleSeleccionado);

	    	});

	    	comboGeneroCliente.getItems().addAll("Masculino", "Femenino");
	    	comboTipoDocumentoCliente.getItems().addAll(TipoDocumento.CEDULA, TipoDocumento.CEDULA_EXTRANJERA,
	    												TipoDocumento.PASAPORTE);
	    	comboTipoDocumentoEmpleado.getItems().addAll(TipoDocumento.CEDULA, TipoDocumento.CEDULA_EXTRANJERA,
					TipoDocumento.PASAPORTE);
	    	comboTipoEmpleado.getItems().addAll(TipoEmpleado.ADMINISTRADOR, TipoEmpleado.OFICINISTA);
	    	comboTipoObjeto.getItems().addAll(TipoObjeto.CONSTRUCCION, TipoObjeto.ELECTRODOMESTICOS,
	    										TipoObjeto.MUEBLES);
	    	comboFiltrar.getItems().addAll("Todos","Disponibles", "Agotados");
	    }

	    /**
	     * Metodo que muestra la informacion señalada en la casillas de textos
	     * @param detalleSeleccionado
	     */
	    private void mostrarInformacionDetalle(DetallePrestamo detalleSeleccionado) {
	    	txtCodigoPrestamoDetalle.setText(prestamoSeleccionado.getCodigo());
	    	txtCodigoObjetoDetalle.setText(detalleSeleccionado.getCodigoObjeto());
	    	txtUnidadesPrestadasDetalle.setText(""+detalleSeleccionado.getUnidadesPrestadas());
	    	labelSubTotal.setText(""+detalleSeleccionado.getSubTotal());

		}

	    /**
	     * Metodo que muestra la informacion señalada en la casillas de textos
	     * @param prestamoSeleccionado
	     */
		private void mostrarInformacionPrestamo(Prestamo prestamoSeleccionado) {
	    	txtCodigoPrestamo.setText             (prestamoSeleccionado.getCodigo());
	    	txtDocumentoEmpleadoPrestamo.setText  (prestamoSeleccionado.obtenerDocumentoEmpleado());
	    	txtDocumentoClientePrestamo.setText   (prestamoSeleccionado.obtenerDocumentoCliente());
	    	dateFechaEntregaPrestamo.setValue     (prestamoSeleccionado.getFechaEntrega());
	    	labelFechaPrestamo.setText            (""+prestamoSeleccionado.getFechaPrestamo());
	    	labelEstadoPrestamo.setText           (prestamoSeleccionado.getEstado());
	    	labelDiasTranscurridosPrestamo.setText(""+prestamoSeleccionado.getDiasTranscurridos());
	    	labelDiasSolicitadosPreestamo.setText (""+prestamoSeleccionado.getDiasTranscurridos());
	    	labelValorPrestamo.setText            (""+prestamoSeleccionado.getValor());


		}

		/**
		 * Metodo que muestra la informacion señalada en la casillas de textos
		 * @param objetoSeleccionado
		 */
		private void mostrarInformacionObjeto(Objeto objetoSeleccionado) {

	    	txtNombreObjeto.setText             (objetoSeleccionado.getNombre());
        	txtCodigoObjeto.setText             (objetoSeleccionado.getCodigo());
        	txtValorUnitarioObjeto.setText      (""+objetoSeleccionado.getValorUnitario());
        	comboTipoObjeto.setValue            (objetoSeleccionado.getTipoObjeto());
        	imageObjeto.setImage                (objetoSeleccionado.getFoto());
        	txtColorObjeto.setText              (objetoSeleccionado.getColor());
        	txtPesoObjeto.setText               (""+objetoSeleccionado.getPeso());
        	txtUnidadesDisponiblesObjeto.setText(""+objetoSeleccionado.getUnidadesDisponibles());
        	txtDescripcionObjeto.setText        (objetoSeleccionado.getDescripcion());
        	labelEstadoObjeto.setText           (""+objetoSeleccionado.getEstado());
        	labelUnidadesPrestadas.setText      (""+objetoSeleccionado.getUnidadesPrestadas());



		}

		/**
		 * Metodo que muestra la informacion señalada en la casillas de textos
		 * @param empleadoSeleccionado
		 */
		private void mostrarInformacionEmpleado(Empleado empleadoSeleccionado) {
	    	if(empleadoSeleccionado != null){

            	txtNombreEmpleado.setText               (empleadoSeleccionado.getNombre());
            	txtApellidoEmpleado.setText             (empleadoSeleccionado.getApellido());
            	txtDocumentoEmpleado.setText            (empleadoSeleccionado.getDocumento());
            	txtDireccionEmpleado.setText            (empleadoSeleccionado.getDireccion());
            	txtCiudadEmpleado.setText               (empleadoSeleccionado.getCiudadResidencia());
            	txtDepartamentoEmpleado.setText         (empleadoSeleccionado.getApellido());
            	txtAniosExperienciaEmpleado.setText     (""+empleadoSeleccionado.getAniosExperiencia());
            	txtPaisEmpleado.setText                 (empleadoSeleccionado.getPais());
            	txtTelResidenciaEmpleado.setText        (empleadoSeleccionado.getTelResidencia());
            	txtTelCelularEmpleado.setText           (empleadoSeleccionado.getTelCelular());
            	txtCorreoEmpleado.setText               (empleadoSeleccionado.getCorreo());
            	comboTipoDocumentoEmpleado.setValue     (empleadoSeleccionado.getTipoDocumento());
            	comboTipoEmpleado.setValue              (empleadoSeleccionado.getTipoEmpleado());
        	}

		}

		/**
	     * Metodo que muestra la informacion selecionada del cliente
	     * @param clienteSeleccionado
	     */
    	private void mostrarInformacionCliente(Cliente clienteSeleccionado) {


        	if(clienteSeleccionado != null){

            	txtNombreCliente.setText               (clienteSeleccionado.getNombre());
            	txtApellidoCliente.setText             (clienteSeleccionado.getApellido());
            	txtDocumentoCliente.setText            (clienteSeleccionado.getDocumento());
            	txtDireccionCliente.setText            (clienteSeleccionado.getDireccion());
            	txtCiudadCliente.setText               (clienteSeleccionado.getCiudadRecidencia());
            	txtDepartamentoCliente.setText         (clienteSeleccionado.getDepartamento());
            	comboGeneroCliente.setValue            (clienteSeleccionado.getGenero());
            	txtPaisCliente.setText                 (clienteSeleccionado.getPais());
            	txtTelResidenciaCliente.setText        (clienteSeleccionado.getTelResidencia());
            	txtTelCelularCliente.setText           (clienteSeleccionado.getTelCelular());
            	txtProfesionCliente.setText            (clienteSeleccionado.getProfesion());
            	txtCorreoCliente.setText               (clienteSeleccionado.getCorreo());
            	comboTipoDocumentoCliente.setValue     (clienteSeleccionado.getTipoDocumento());
    	}
    	}


    	/**
    	 * Metodo que setea la aplicacion
    	 * @param aplicacion
    	 */
    	public void setAplicacion(Aplicacion aplicacion) {
    		this.aplicacion = aplicacion;

    		tableClientes.getItems().clear();
    		tableClientes.setItems(getListaClientesData());

    		tableEmpleados.getItems().clear();
    		tableEmpleados.setItems(getListaEmpleadosData());

    		tableObjetos.getItems().clear();
    		tableObjetos.setItems(getListaObjetosData());

    		tablePrestamo.getItems().clear();
    		tablePrestamo.setItems(getListaPrestamosData());

    		tableDetallePrestamo.getItems().clear();
    		tableDetallePrestamo.setItems(getListaDetallesData());

    	}

    	/**
    	 * Metodo get de la lista de detalles del obserbable
    	 * donde se almacenara el arraylist
    	 * @return listaDetallePrestamoData
    	 */
    	private ObservableList<DetallePrestamo> getListaDetallesData() {
    		listaDetallePrestamoData.addAll(aplicacion.obtenerDetalles());
			return listaDetallePrestamoData;
		}

    	/**
    	 * Metodo get de la lista de prestamos del obserbable
    	 * donde se almacenara el arraylist
    	 * @return listaPrestamosData
    	 */
		private ObservableList<Prestamo> getListaPrestamosData() {
			listaPrestamosData.addAll(aplicacion.obtenerPrestamos());
			return listaPrestamosData;
		}

		/**
		 * Metodo ger de la lista de objetos del obserbables
		 * donde se almacenara el arraylist
		 * @return listaObjetosData
		 */
		private ObservableList<Objeto> getListaObjetosData() {
    		listaObjetosData.addAll(aplicacion.obtenerObjetos());
    		return listaObjetosData;
		}

		/**
    	 * metodo get del observable listaEmpleadosData
    	 * @return listaEmpleadosData
    	 */
    	private ObservableList<Empleado> getListaEmpleadosData() {

    		listaEmpleadosData.addAll(aplicacion.obtenerEmpleados());
    		return listaEmpleadosData;
    	}

    	/**
    	 * metodo get del observable listaClientesData
    	 * @return listaClientesData
    	 */
    	public ObservableList<Cliente> getListaClientesData() {

    		listaClientesData.addAll(aplicacion.obtenerClientes());
    		return listaClientesData;
    	}
    	/**
    	 * metodo que indica lo que debe llenarse en los campos de texto
    	 */
        private void nuevoDetallePrestamo() {
        	txtCodigoPrestamoDetalle.setText("Ingrese el codigo del prestamo");
        	txtCodigoObjetoDetalle.setText   ("Ingrese el codigo del objeto");
        	txtUnidadesPrestadasDetalle.setText("Ingrese las unidades prestadas");

    		}
    	/**
    	 * Metodo que expresa en los campos de textos una guia de la imformacion requerida
    	 * para la creación de un cliente
    	 */
    	private void nuevoCliente() {
    		txtNombreCliente.setText       ("Ingrese el nombre");
    		txtApellidoCliente.setText     ("Ingrese el apellido");
    		txtDocumentoCliente.setText    ("Ingrese el documento");
    		txtDireccionCliente.setText    ("Ingrese la dirección");
    		txtCiudadCliente.setText       ("Ingrese la cuidad");
    		txtDepartamentoCliente.setText ("Ingrese el departamento");
    		txtPaisCliente.setText         ("Ingrese el pais");
    		txtTelResidenciaCliente.setText("Ingrese el telefono de residencia");
    		txtTelCelularCliente.setText   ("Ingrese el telefono celular");
    		txtProfesionCliente.setText    ("Ingrese la profesion");
    		txtCorreoCliente.setText       ("Ingrese el correo");

    	}
    	/**
    	 * metodo que expresa en los campos de textos una guia de la informacion requerida
    	 * para la creación de un empleado
    	 */
    	private void nuevoEmpleado() {

    		txtNombreEmpleado.setText          ("Ingrese el nombre");
    		txtApellidoEmpleado.setText        ("Ingrese el apellido");
    		txtDocumentoEmpleado.setText       ("Ingrese el documento");
    		txtDireccionEmpleado.setText       ("Ingrese la direccion");
    		txtCiudadEmpleado.setText          ("Ingrese la ciudad");
    		txtDepartamentoEmpleado.setText    ("Ingrese el departamento");
    		txtAniosExperienciaEmpleado.setText("Ingrese los años de experiencia");
    		txtPaisEmpleado.setText            ("Ingrese el pais");
    		txtTelResidenciaEmpleado.setText   ("Ingrese el telefono de residencia");
    		txtTelCelularEmpleado.setText      ("Ingrese el telefono celular");
    		txtCorreoEmpleado.setText          ("Ingrese el correo");


    	}

    	/**
    	 * MEtodo que expresa en los campos de textos una guia de la informacion requerida
    	 * para la creacion del empleado
    	 */
	    private void nuevoObjeto() {

	    	txtNombreObjeto.setText             ("Ingrese el nombre del objeto");
	    	txtCodigoObjeto.setText             ("Ingrese el codigo");
	    	txtValorUnitarioObjeto.setText      ("Ingrese el valor unitario");
	    	txtColorObjeto.setText              ("Ingrese el color del objeto");
	    	txtPesoObjeto.setText               ("Ingrese el peso del objeto(kg)");
	    	txtUnidadesDisponiblesObjeto.setText("Ingrese las unidades disponibles");
	    	txtDescripcionObjeto.setText        ("Ingrese la descripcion del objeto");



		}

	    /**
    	 * MEtodo que expresa en los campos de textos una guia de la informacion requerida
    	 * para la creacion del empleado
    	 */
	    private void nuevoPrestamo() {
	    	txtCodigoPrestamo.setText("Ingrese el codigo del prestamo");
	    	txtDocumentoEmpleadoPrestamo.setText("Ingrese el documento del empleado");
	    	txtDocumentoClientePrestamo.setText("Ingrese el documento del cliente");
		}

	    /**
	     * Metodo que limpia el campo de texto el momento de crear un objeto
	     */
		private void limpiarCamposTextoObjeto() {
			txtNombreObjeto.setText             ("");
	    	txtCodigoObjeto.setText             ("");
	    	txtValorUnitarioObjeto.setText      ("");
	    	txtColorObjeto.setText              ("");
	    	txtPesoObjeto.setText               ("");
	    	txtUnidadesDisponiblesObjeto.setText("");
	    	txtDescripcionObjeto.setText        ("");
	    	imageObjeto.setImage                (null);
	    	comboTipoObjeto.setValue            (null);
		}
    	/**
    	 * Metodo que limpia los campos de textos del tab del cliente
    	 */
    	private void limpiarCamposTextoCliente() {
    		txtNombreCliente.setText          ("");
    		txtApellidoCliente.setText        ("");
    		txtDocumentoCliente.setText       ("");
    		txtDireccionCliente.setText       ("");
    		txtCiudadCliente.setText          ("");
    		txtDepartamentoCliente.setText    ("");
    		txtPaisCliente.setText            ("");
    		txtTelResidenciaCliente.setText   ("");
    		txtTelCelularCliente.setText      ("");
    		txtProfesionCliente.setText       ("");
    		txtCorreoCliente.setText          ("");
    		comboGeneroCliente.setValue       ("");
    		comboTipoDocumentoCliente.setValue(null);
    	}

    	/**
    	 * Metodo que limpia las casillas de texto del tab Empleado
    	 */
    	private void limpiarCamposTextoEmpleado() {
    		txtNombreEmpleado.setText          ("");
    		txtApellidoEmpleado.setText        ("");
    		txtDocumentoEmpleado.setText       ("");
    		txtDireccionEmpleado.setText       ("");
    		txtCiudadEmpleado.setText          ("");
    		txtDepartamentoEmpleado.setText    ("");
    		txtAniosExperienciaEmpleado.setText("");
    		txtPaisEmpleado.setText            ("");
    		txtTelResidenciaEmpleado.setText   ("");
    		txtTelCelularEmpleado.setText      ("");
    		txtCorreoEmpleado.setText          ("");
    		comboTipoDocumentoEmpleado.setValue(null);
    		comboTipoEmpleado.setValue         (null);

    	}
    	/**
    	 * Metodo que limpia las casillas de texto del tab Prestamo
    	 */
    	private void limpiarCamposTextoPrestamo() {
    		txtCodigoPrestamo.setText             ("");
	    	txtDocumentoEmpleadoPrestamo.setText  ("");
	    	txtDocumentoClientePrestamo.setText   ("");
	    	dateFechaEntregaPrestamo.setValue     (null);
	    	labelFechaPrestamo.setText            ("");
	    	labelEstadoPrestamo.setText           ("");
	    	labelDiasTranscurridosPrestamo.setText("");
	    	labelDiasSolicitadosPreestamo.setText ("");
	    	labelValorPrestamo.setText            ("");

		}

    	/**
    	 * MEtodo que muestra mensaje por ventana segun el tipo dado
    	 * @param titulo
    	 * @param header
    	 * @param contenido
    	 * @param alertType
    	 */
    	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

    		Alert alert = new Alert(alertType);
    		alert.setTitle(titulo);
    		alert.setHeaderText(header);
    		alert.setContentText(contenido);
    		alert.showAndWait();
    	}

    	/**
    	 * Metodo solicita al usuario confirmar una accion
    	 * @param mensaje
    	 * @return boolean
    	 */
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


    	/**
    	 * Metodo que valida los datos ingresados mandados por parametro
    	 * @param nombre
    	 * @param apellido
    	 * @param documento
    	 * @param direccion
    	 * @param ciudad
    	 * @param departamento
    	 * @param genero
    	 * @param pais
    	 * @param telResidencia
    	 * @param correo
    	 * @param tipoDocumento
    	 * @return true si son validos false de lo contrario
    	 * @throws DatosInvalidosException (Se genera en caso tal de que no sean validos)
    	 */
    	private boolean datosValidosCliente(String nombre, String apellido, String documento, String direccion,
    			String ciudad, String departamento, String genero, String pais,
    			String telResidencia, String correo, String tipoDocumento) throws DatosInvalidosException {

    		String mensaje = "";

    		if(nombre == null || nombre.equals(""))
    			mensaje += "El nombre es invalido \n";

    		if(apellido == null || apellido.equals(""))
    			mensaje += "El apellido es invalido \n";

    		if(documento == null || documento.equals(""))
    			mensaje += "El documento es invalido \n";

    		if(direccion == null || direccion.equals(""))
    			mensaje += "La direccion es invalida \n";

    		if(ciudad == null || ciudad.equals(""))
    			mensaje += "La ciudad es invalida \n";

    		if(departamento == null || departamento.equals(""))
    			mensaje += "El departamento es invalido \n";

    		if(genero == null || genero.equals(""))
    			mensaje += "El genero es invalido \n";

    		if(pais == null || pais.equals(""))
    			mensaje += "El pais es invalido \n";

    		if(telResidencia == null || telResidencia.equals(""))
    			mensaje += "El telefono de residencia es invalido \n";

    		if(correo == null || correo.equals(""))
    			mensaje += "El correo es invalido \n";

    		if(tipoDocumento == null || tipoDocumento.equals(""))
    			mensaje += "El tipo de documento es invalido \n";

    		if(mensaje.equals("")){
    			return true;
    		}else{
    			throw new DatosInvalidosException(mensaje);
    		}
    	}

    	/**
    	 * MEtodo que valida los datos de los objetos recibidos por parametros
    	 * @param codigo
    	 * @param nombre
    	 * @param color
    	 * @param peso
    	 * @param foto
    	 * @param tipoObjeto
    	 * @param valorUnitario
    	 * @param unidadesDisponibles
    	 * @return true si son correctos, false de lo contrario
    	 * @throws DatosInvalidosException
    	 */
    	private boolean validarDatosObjeto(String codigo, String nombre, String color, String peso, Image foto,
				TipoObjeto tipoObjeto, String valorUnitario, String unidadesDisponibles) throws DatosInvalidosException {

    		double doubleAux;
    		int    intAux;

    		String mensaje = "";

    		if(nombre == null || nombre.equals(""))
    			mensaje += "El nombre es invalido \n";


    		if(codigo == null || codigo.equals("")){
    			mensaje += "El codigo es invalido \n";
    		}else{
    			if(aplicacion.verificarObjeto(codigo)){
    				mensaje+="El objeto no puede actualizarse"
    						+ "ya que pertenece a un prestamo";
    			}
    		}


    		if(color == null || color.equals(""))
    			mensaje += "El color es invalido \n";

    		if(peso == null || peso.equals(""))
    		{
    			mensaje += "El peso es invalido \n";
    		}else{
    			doubleAux=Double.parseDouble(peso);
    			if(doubleAux<0)
        			mensaje += "El peso no puede ser negativo \n";
    		}



    		if(foto == null )
    			mensaje += "La foto es invalida \n";

    		if(tipoObjeto == null)
    			mensaje += "El tipo de objeto es invalido \n";


    		if(valorUnitario == null || valorUnitario.equals("")){
    			mensaje += "El valor unitario es invalido \n";
    		}else{
    			doubleAux=Double.parseDouble(valorUnitario);
    			if(doubleAux<0)
        			mensaje += "El valor unitario no puede ser negativo \n";
    		}


    		if(unidadesDisponibles == null || unidadesDisponibles.equals("")){
    			mensaje += "Las unidades disponibles son invalidas \n";
    		}else{
    			intAux=Integer.parseInt(unidadesDisponibles);
    			if(intAux<0)
        			mensaje += "las unidades disponibles no pueden ser negativas \n";
    		}
    		if(mensaje.equals("")){
    			return true;
    		}else{
    			throw new DatosInvalidosException(mensaje);
    		}

		}

    	/**
    	 * Metodo que valida los datos del detalle de prestamo
    	 * @param codigoPrestamoDetalle
    	 * @param codigoObjetoDetalle
    	 * @param unidadesPrestadas
    	 * @return true si son correctos false de lo contrario
    	 * @throws DatosInvalidosException
    	 */
    	private boolean validarDatosDetallePrestamo(String codigoPrestamoDetalle, String codigoObjetoDetalle,
				String unidadesPrestadas) throws DatosInvalidosException {
    		String mensaje="";
    		int unidadesAux;
    		if(codigoPrestamoDetalle == null || codigoPrestamoDetalle.equals(""))
    			mensaje += "El codigo del prestamoa es invalido \n";

    		if(codigoObjetoDetalle == null || codigoObjetoDetalle.equals(""))
    			mensaje += "El codigo del objeto es invalido \n";

    		if(unidadesPrestadas == null || unidadesPrestadas.equals("")){
    			mensaje += "El tipo de documento es invalido \n";
    		}else{
    			unidadesAux=Integer.parseInt(unidadesPrestadas);
    			if(unidadesAux<0)
        			mensaje += "Las unidades prestadas no pueden ser negativas \n";
    		}
    		if(mensaje.equals("")){
    			return true;
    		}else{
    			throw new DatosInvalidosException(mensaje);
    		}
    	}



    	/**
    	 * Metodo que valida los datos ingresados por el usuario
    	 * @param nombre
    	 * @param apellido
    	 * @param documento
    	 * @param direccion
    	 * @param ciudad
    	 * @param departamento
    	 * @param pais
    	 * @param telResidencia
    	 * @param correo
    	 * @param tipoDocumento
    	 * @return boolean true si son correctos y false de lo contrario
    	 * @throws DatosInvalidosException
    	 */
    	private boolean validarDatosEmpleado(String nombre, String apellido, String documento, String direccion,
    			String ciudad, String departamento, String pais, String telResidencia, String correo,
    			String tipoDocumento) throws DatosInvalidosException {



    		String mensaje = "";

    		if(nombre == null || nombre.equals(""))
    			mensaje += "El nombre es invalido \n";

    		if(apellido == null || apellido.equals(""))
    			mensaje += "El apellido es invalido \n";

    		if(documento == null || documento.equals(""))
    			mensaje += "El documento es invalido \n";

    		if(direccion == null || direccion.equals(""))
    			mensaje += "La direccion es invalida \n";

    		if(ciudad == null || ciudad.equals(""))
    			mensaje += "La ciudad es invalida \n";

    		if(departamento == null || departamento.equals(""))
    			mensaje += "El departamento es invalido \n";

    		if(pais == null || pais.equals(""))
    			mensaje += "El pais es invalido \n";

    		if(telResidencia == null || telResidencia.equals(""))
    			mensaje += "El telefono de residencia es invalido \n";

    		if(correo == null || correo.equals(""))
    			mensaje += "El correo es invalido \n";

    		if(tipoDocumento == null || tipoDocumento.equals(""))
    			mensaje += "El tipo de documento es invalido \n";

    		if(mensaje.equals("")){
    			return true;
    		}else{
    			throw new DatosInvalidosException(mensaje);
    		}
    	}
    	/**
    	 * MEtodo que valida los datos del prestamo
    	 * @param codigoPrestamo
    	 * @param documentoEmpleado
    	 * @param documentoCliente
    	 * @param fechaEntrega
    	 * @return true si son correctos y false de lo contrario
    	 * @throws DatosInvalidosException
    	 */
        private boolean validarDatosPrestamo(String codigoPrestamo, String documentoEmpleado, String documentoCliente
        									, LocalDate fechaEntrega) throws DatosInvalidosException {

    		String mensaje = "";

    		if(codigoPrestamo == null || codigoPrestamo.equals(""))
    			mensaje += "El codigo es invalido \n";

    		if(documentoEmpleado == null || documentoEmpleado.equals(""))
    			mensaje += "El documento del empleado es invalido \n";

    		if(documentoCliente == null || documentoCliente.equals(""))
    			mensaje += "El documento del cliente  es invalido \n";

    		if(fechaEntrega == null )
    			mensaje += "La fecha es invalida \n";

    		if(mensaje.equals("")){
    			return true;
    		}else{
    			throw new DatosInvalidosException(mensaje);
    		}
        }
        /**
         * MEtodo que agrega un detalle prestamo
         */
        private void agregarDetallePrestamo() {
        	String codigoPrestamoDetalle= txtCodigoPrestamoDetalle.getText();
        	String codigoObjetoDetalle= txtCodigoObjetoDetalle.getText();
        	String unidadesPrestadas= txtUnidadesPrestadasDetalle.getText();


        	try {
        		if(validarDatosDetallePrestamo(codigoPrestamoDetalle,codigoObjetoDetalle,unidadesPrestadas) == true){

        			DetallePrestamo detallePrestamo = null;
        			int unidadesPrestadasAux=Integer.parseInt(unidadesPrestadas);

        			detallePrestamo= aplicacion.crearDetallePrestamo(codigoPrestamoDetalle,codigoObjetoDetalle,unidadesPrestadasAux);

        			listaDetallePrestamoData.add(detallePrestamo);
        			limpiarCamposTextoPrestamo();
        			mostrarMensaje("Notificación prestamo", "Prestamo registrado", "El prestamo se ha registrado con éxtio", AlertType.INFORMATION);
        		}
        	} catch (DatosInvalidosException  | ObjetoNoEncontradoException | SinCantidadDisponibleException  | PrestamoNoEncontradoException   e ) {
        		mostrarMensaje("Error", "Objeto no registrado", e.getMessage(), AlertType.ERROR);
        	}



        }

        /**
         * Metodo que agrega un prestamo
         */
	    private void agregarPrestamo() {

	    	String codigoPrestamo=txtCodigoPrestamo.getText();
	    	String documentoEmpleado=txtDocumentoEmpleadoPrestamo.getText();
	    	String documentoCliente=txtDocumentoClientePrestamo.getText();

	    	LocalDate fechaEntrega=dateFechaEntregaPrestamo.getValue();


	    	try {
    			if(validarDatosPrestamo(codigoPrestamo,documentoEmpleado,documentoCliente,fechaEntrega) == true){

    				Prestamo prestamo = null;

    				prestamo= aplicacion.crearPrestamo(codigoPrestamo,documentoEmpleado,documentoCliente,fechaEntrega);

    				listaPrestamosData.add(prestamo);
    				limpiarCamposTextoPrestamo();
    				mostrarMensaje("Notificación prestamo", "Prestamo registrado", "El prestamo se ha registrado con éxtio", AlertType.INFORMATION);
    			}
    		} catch (DatosInvalidosException | PrestamoExisteException | EmpleadoNoEncontradoException | ClienteNoEncontradoException   e ) {
    			mostrarMensaje("Error", "Objeto no registrado", e.getMessage(), AlertType.ERROR);
    		}



		}


	    /**
	     * Metodo que agrega un objeto
	     */
		private void agregarObjeto() {

	    	String nombre=txtNombreObjeto.getText();
	    	String color=txtColorObjeto.getText();
	    	String codigo=txtCodigoObjeto.getText();
	    	String peso=txtPesoObjeto.getText();
	    	String valorUnitario=txtValorUnitarioObjeto.getText();
	    	String unidadesDisponibles=txtUnidadesDisponiblesObjeto.getText();
	    	TipoObjeto tipoObjeto=comboTipoObjeto.getValue();
	    	String descripcion=txtDescripcionObjeto.getText();
	    	Image foto=imageObjeto.getImage();


	    	try {
    			if(validarDatosObjeto(codigo, nombre, color, peso, foto, tipoObjeto, valorUnitario, unidadesDisponibles) == true){

    				Objeto objeto = null;

    				double pesoAux=Double.parseDouble(peso);
    				double valorUnitarioAux=Double.parseDouble(valorUnitario);
    				int    unidadesDisponiblesAux=Integer.parseInt(unidadesDisponibles);


    				objeto= aplicacion.crearObjeto(nombre,codigo,descripcion,color,unidadesDisponiblesAux,valorUnitarioAux
    						 		                , pesoAux, tipoObjeto, foto);

    				listaObjetosData.add(objeto);
    				limpiarCamposTextoObjeto();
    				mostrarMensaje("Notificación objeto", "Objeto registrado", "El objeto se ha registrado con éxtio", AlertType.INFORMATION);
    			}
    		} catch (DatosInvalidosException|NumberFormatException | ObjetoExisteException   e ) {
    			mostrarMensaje("Error", "Objeto no registrado", e.getMessage(), AlertType.ERROR);
    		}


		}



		/**
    	 * Metodo que agrega un cliente ingresado
    	 */
    	private void agregarCliente() {

    		String nombre        = txtNombreCliente.getText();
    		String apellido      = txtApellidoCliente.getText();
    		String documento     = txtDocumentoCliente.getText();
    		String direccion     = txtDireccionCliente.getText();
    		String ciudad        = txtCiudadCliente.getText();
    		String departamento  = txtDepartamentoCliente.getText();
    		String genero        = comboGeneroCliente.getValue();
    		String pais          = txtPaisCliente.getText();
    		String telResidencia = txtTelResidenciaCliente.getText();
    		String telCelular    = txtTelCelularCliente.getText();
    		String profesion     = txtProfesionCliente.getText();
    		String correo        = txtCorreoCliente.getText();
    		String tipoDocumento = ""+comboTipoDocumentoCliente.getValue();

    		try {
    			if(datosValidosCliente(nombre, apellido, documento, direccion, ciudad, departamento, genero, pais, telResidencia,
    					correo, tipoDocumento) == true){

    				Cliente cliente = null;


    				cliente = aplicacion.crearCliente(apellido, documento, telResidencia, telCelular, nombre, genero, ciudad,
    						departamento, pais, profesion, correo, tipoDocumento, direccion);

    				listaClientesData.add(cliente);
    				limpiarCamposTextoCliente();
    				mostrarMensaje("Notificación cliente", "Cliente registrado", "El cliente se ha registrado con éxtio", AlertType.INFORMATION);
    			}
    		} catch (DatosInvalidosException |ClienteExisteException e ) {
    			mostrarMensaje("Error", "Cliente no registrado", e.getMessage(), AlertType.ERROR);
    		}
    	}


    	/**
    	 * Metodo que agrega un empleado
    	 */
    	private void agregarEmpleado() {
    		String nombre          =txtNombreEmpleado.getText();
    		String apellido        =txtApellidoEmpleado.getText();
    		String documento       =txtDocumentoEmpleado.getText();
    		String direccion       =txtDireccionEmpleado.getText();
    		String ciudad          =txtCiudadEmpleado.getText();
    		String departamento    =txtDepartamentoEmpleado.getText();;
    		String aniosExperiencia=txtAniosExperienciaEmpleado.getText();
    		String pais            =txtPaisEmpleado.getText();
    		String telResidencia   =txtTelResidenciaEmpleado.getText();
    		String telCelular      =txtTelCelularEmpleado.getText();
    		String correo          =txtCorreoEmpleado.getText();
    		String tipoDocumento   =""+comboTipoDocumentoEmpleado.getValue();
    		String tipoEmpleado    =""+comboTipoEmpleado.getValue();


    		try {
    			if(validarDatosEmpleado(nombre, apellido, documento, direccion, ciudad, departamento, pais, telResidencia,
    					correo, tipoDocumento) == true){

    				int aniosExperienciaAux=Integer.parseInt(aniosExperiencia);
    				Empleado empleado = null;


    				empleado = aplicacion.crearEmpleado(nombre, apellido, documento, direccion, ciudad, departamento,
    						aniosExperienciaAux, pais, telResidencia, telCelular,correo, tipoDocumento,
    						tipoEmpleado);

    				listaEmpleadosData.add(empleado);
    				limpiarCamposTextoEmpleado();
    				mostrarMensaje("Notificación empleado", "Empleado registrado", "El Empleado se ha registrado con éxtio", AlertType.INFORMATION);
    			}
    		} catch (DatosInvalidosException |EmpleadoExisteException |NumberFormatException | EmpleadoNoEncontradoException e ) {
    			mostrarMensaje("Error", "Cliente no registrado", e.getMessage(), AlertType.ERROR);;
    		}
    	}


    	/**
    	 * MEtodo que elimina un objeto
    	 */
        private void eliminarObjeto() {

    		if(objetoSeleccionado != null){

    			if(mostrarMensajeConfirmacion("¿Esta seguro de eliminar al objeto?") == true){

    				try {
    					if(!aplicacion.verificarObjeto(objetoSeleccionado.getCodigo()))
    					{
    						aplicacion.eliminarObjeto(objetoSeleccionado.getCodigo());

    						listaObjetosData.remove(objetoSeleccionado);
    						objetoSeleccionado = null;
    						tableObjetos.getSelectionModel().clearSelection();
    						limpiarCamposTextoObjeto();
    						mostrarMensaje("Notificación objeto", "Objeto eliminado", "Objeto eliminado con éxito", AlertType.INFORMATION);
    					}else{
    						mostrarMensaje("Notificación Objeto", "Objeto eliminacion", "El objeto no se puede eliminar ya que"
    										+ " pertenece a un prestamo", AlertType.INFORMATION);

    					}
    				}catch ( ObjetoNoEncontradoException e) {
    					mostrarMensaje("Notificación Objeto", "Objeto no eliminado", e.getMessage(), AlertType.ERROR);
    				}
    			}
    		}else{
    			mostrarMensaje("Notificación Objeto", "OBjeto no seleccionado", "Debe seleccionar un Objeto", AlertType.WARNING);
    		}

    		}

    	/**
    	 * Metodo que elimina un cliente
    	 */
    	private void eliminarCliente() {

    		if(clienteSeleccionado != null){

    			if(mostrarMensajeConfirmacion("¿Esta seguro de eliminar al cliente?") == true){

    				try {
    					aplicacion.eliminarCliente(clienteSeleccionado.getDocumento());

    					listaClientesData.remove(clienteSeleccionado);
    					clienteSeleccionado = null;
    					tableClientes.getSelectionModel().clearSelection();
    					limpiarCamposTextoCliente();
    					mostrarMensaje("Notificación cliente", "Cliente eliminado", "Cliente eliminado con éxito", AlertType.INFORMATION);
    				}catch (ClienteNoEncontradoException | ClientePertencePrestamoException e) {
    					mostrarMensaje("Notificación cliente", "Cliente no eliminado", e.getMessage(), AlertType.ERROR);
    				}
    			}
    		}else{
				mostrarMensaje("Notificación cliente", "Cliente no seleccionado", "Debe seleccionar un cliente", AlertType.WARNING);
			}
    	}

    	/**
    	 * metodo que elimina un empleadoo
    	 */
	    private void eliminarEmpleado() {

	    	if(empleadoSeleccionado != null){

    			if(mostrarMensajeConfirmacion("¿Esta seguro de eliminar al empleado?") == true){

    				try {
    					aplicacion.eliminarEmpleado(empleadoSeleccionado.getDocumento());

    					listaEmpleadosData.remove(empleadoSeleccionado);
    					empleadoSeleccionado = null;
    					tableEmpleados.getSelectionModel().clearSelection();
    					limpiarCamposTextoEmpleado();
    					mostrarMensaje("Notificación Empleado", "Empleado eliminado", "Empleado eliminado con éxito", AlertType.INFORMATION);
    				}catch (EmpleadoNoEncontradoException | EmpleadoPertenecePrestamoException e) {
    					mostrarMensaje("Notificación empleado", "Empleado no eliminado", e.getMessage(), AlertType.ERROR);
    				}
    			}
    		}else{
				mostrarMensaje("Notificación Empleado", "Empleado no seleccionado", "Debe seleccionar un empleado", AlertType.WARNING);
			}

		}

	    /**
	     * Metod que actualiza un prestamo
	     */
	    private void actualizarPrestamo() {
	    	String codigoPrestamo=txtCodigoPrestamo.getText();
	    	String documentoEmpleado=txtDocumentoEmpleadoPrestamo.getText();
	    	String documentoCliente=txtDocumentoClientePrestamo.getText();

	    	LocalDate fechaEntrega=dateFechaEntregaPrestamo.getValue();


	    	try {
    			if(validarDatosPrestamo(codigoPrestamo,documentoEmpleado,documentoCliente,fechaEntrega) == true){

    				String mensajePrestamoActualizado = "";

    				mensajePrestamoActualizado= aplicacion.actualizarPrestamo(prestamoSeleccionado.getCodigo(),codigoPrestamo,
    																			documentoEmpleado,documentoCliente,fechaEntrega);

    				limpiarCamposTextoPrestamo();
    				tableClientes.refresh();
					mostrarMensaje("Notificación cliente", "Cliente actualizado", mensajePrestamoActualizado, AlertType.INFORMATION);
					}
    		} catch (DatosInvalidosException  | EmpleadoNoEncontradoException | ClienteNoEncontradoException | PrestamoNoEncontradoException   e ) {
    			mostrarMensaje("Error", "Objeto no registrado", e.getMessage(), AlertType.ERROR);
    		}
		}

	    /**
	     * Metodo que actualiza un objeto
	     */
	    private void actualizarObjeto() {
	    	String nombre=txtNombreObjeto.getText();
	    	String color=txtColorObjeto.getText();
	    	String codigo=txtCodigoObjeto.getText();
	    	String peso=txtPesoObjeto.getText();
	    	String valorUnitario=txtValorUnitarioObjeto.getText();
	    	String unidadesDisponibles=txtUnidadesDisponiblesObjeto.getText();
	    	TipoObjeto tipoObjeto=comboTipoObjeto.getValue();
	    	String descripcion=txtDescripcionObjeto.getText();
	    	Image foto=imageObjeto.getImage();


	    	try {
    			if(validarDatosObjeto(codigo, nombre, color, peso, foto, tipoObjeto, valorUnitario, unidadesDisponibles) == true){

    				String mensajeObjetoActualizado = "";

    				double pesoAux=Double.parseDouble(peso);
    				double valorUnitarioAux=Double.parseDouble(valorUnitario);
    				int    unidadesDisponiblesAux=Integer.parseInt(unidadesDisponibles);


    				mensajeObjetoActualizado= aplicacion.actualizarObjeto(objetoSeleccionado.getCodigo(),nombre,codigo,descripcion,color,
    																	unidadesDisponiblesAux,valorUnitarioAux, pesoAux, tipoObjeto, foto);

    				tableClientes.refresh();
					mostrarMensaje("Notificación cliente", "Cliente actualizado", mensajeObjetoActualizado, AlertType.INFORMATION);
				}
    		} catch (DatosInvalidosException|NumberFormatException  | ObjetoNoEncontradoException   e ) {
    			mostrarMensaje("Error", "Objeto no registrado", e.getMessage(), AlertType.ERROR);
    		}

		}
    	/**
    	 * Metodo que actualiza al cliente
    	 */
    	private void actualizarCliente() {

    		String nombre        = txtNombreCliente.getText();
    		String apellido      = txtApellidoCliente.getText();
    		String documento     = txtDocumentoCliente.getText();
    		String direccion     = txtDireccionCliente.getText();
    		String ciudad        = txtCiudadCliente.getText();
    		String departamento  = txtDepartamentoCliente.getText();
    		String genero        = comboGeneroCliente.getTypeSelector();
    		String pais          = txtPaisCliente.getText();
    		String telResidencia = txtTelResidenciaCliente.getText();
    		String telCelular    = txtTelCelularCliente.getText();
    		String profesion     = txtProfesionCliente.getText();
    		String correo        = txtCorreoCliente.getText();
    		String tipoDocumento = comboTipoDocumentoCliente.getTypeSelector();

    		String mensajeClienteActualizado = "";

    		if(clienteSeleccionado != null){
    			try {
    				if(datosValidosCliente(nombre, apellido, documento, direccion, ciudad, departamento, genero, pais,
    						telResidencia, correo, tipoDocumento) == true){


    					mensajeClienteActualizado=aplicacion.actualizarCliente(clienteSeleccionado.getDocumento(), nombre, apellido,
    							documento, direccion, ciudad, departamento, genero,
    							pais, telResidencia,telCelular,profesion, correo,
    							tipoDocumento);

    					tableClientes.refresh();
    					mostrarMensaje("Notificación cliente", "Cliente actualizado", mensajeClienteActualizado, AlertType.INFORMATION);
    				}else{

    				}
    			}catch (DatosInvalidosException | ClienteNoEncontradoException e) {
    				mostrarMensaje("Notificación cliente", "Cliente no actualizado", e.getMessage(), AlertType.ERROR);
    			}
    		} else{
    			mostrarMensaje("Notificación cliente", "Cliente no seleccionado", "Debe seleccionar un cliente", AlertType.WARNING);
    		}
    	}

    	/**
    	 * Metodo que actualiza un empleado
    	 */
	    private void actualizarEmpleado() {

	    	String nombre          =txtNombreEmpleado.getText();
    		String apellido        =txtApellidoEmpleado.getText();
    		String documento       =txtDocumentoEmpleado.getText();
    		String direccion       =txtDireccionEmpleado.getText();
    		String ciudad          =txtCiudadEmpleado.getText();
    		String departamento    =txtDepartamentoEmpleado.getText();;
    		String aniosExperiencia=txtAniosExperienciaEmpleado.getText();
    		String pais            =txtPaisEmpleado.getText();
    		String telResidencia   =txtTelResidenciaEmpleado.getText();
    		String telCelular      =txtTelCelularEmpleado.getText();
    		String correo          =txtCorreoEmpleado.getText();
    		String tipoDocumento   =""+comboTipoDocumentoEmpleado.getValue();
    		String tipoEmpleado    =""+comboTipoEmpleado.getValue();

    		if(empleadoSeleccionado != null){
    			try {
    				if(validarDatosEmpleado(nombre, apellido, documento, direccion, ciudad, departamento, pais, telResidencia,
        					correo, tipoDocumento) == true){

    					int aniosExperienciaAux=Integer.parseInt(aniosExperiencia);
    					String mensajeEmpleadoActualizado="";

    					mensajeEmpleadoActualizado=aplicacion.actualizarEmpleado(empleadoSeleccionado.getDocumento(),nombre, apellido, documento, direccion, ciudad, departamento,
        																		aniosExperienciaAux, pais, telResidencia, telCelular,correo, tipoDocumento,
        																		tipoEmpleado);

    					tableEmpleados.refresh();
    					mostrarMensaje("Notificación empleado", "Empleado actualizado", mensajeEmpleadoActualizado, AlertType.INFORMATION);
    				}else{

    				}
    			}catch (DatosInvalidosException | EmpleadoNoEncontradoException  e) {
    				mostrarMensaje("Notificación Empleado", "Empleado no actualizado", e.getMessage(), AlertType.ERROR);
    			}
    		} else{
    			mostrarMensaje("Notificación Empleado", "Empleado no seleccionado", "Debe seleccionar un empleado", AlertType.WARNING);
    		}

		}
}

