package co.edu.uniquindio.prestamoobjeto;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.crypto.spec.DESKeySpec;

import co.edu.uniquindio.prestamoobjeto.controller.EmpresaPrestamoObjetosController;
import co.edu.uniquindio.prestamoobjeto.model.Cliente;
import co.edu.uniquindio.prestamoobjeto.model.DetallePrestamo;
import co.edu.uniquindio.prestamoobjeto.model.Empleado;
import co.edu.uniquindio.prestamoobjeto.exception.ClienteExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.ClienteNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.ClientePertencePrestamoException;
import co.edu.uniquindio.prestamoobjeto.exception.DetalleNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.EmpleadoExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.EmpleadoNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.EmpleadoPertenecePrestamoException;
import co.edu.uniquindio.prestamoobjeto.exception.ObjetoExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.ObjetoNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.PrestamoExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.PrestamoNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.SinCantidadDisponibleException;
import co.edu.uniquindio.prestamoobjeto.model.Empresa;
import co.edu.uniquindio.prestamoobjeto.model.Objeto;
import co.edu.uniquindio.prestamoobjeto.model.Prestamo;
import co.edu.uniquindio.prestamoobjeto.model.TipoObjeto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * Esta clase representa la aplicacion del programa
 * universidad del quindio
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona Brayan Felipe Tangarife Rios
 *
 */
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

	/**
	 * Metodo que muestra la ventana pricipal
	 */
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
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que obtiene la lista de clientes
	 * @return lista de clientes
	 */
	public ArrayList<Cliente> obtenerClientes() {
		return empresa.getListaClientes();
	}

	/**
	 * Metodo que crea un cliente y recibe los datos por parametro
	 * @param documento
	 * @param telResidencia
	 * @param telCelular
	 * @param nombre
	 * @param genero
	 * @param ciudadResidencia
	 * @param departamento
	 * @param pais
	 * @param profesion
	 * @param correo
	 * @param tipoDocumento
	 * @param direccion
	 * @param direccion
	 * @return cliente en caso tal de que si se cree
	 * @throws ClienteExisteException
	 */
	public Cliente crearCliente(String apellido, String documento, String telResidencia, String telCelular, String nombre, String genero,
			String ciudadResidencia, String departamento, String pais, String profesion, String correo,
			String tipoDocumento,String direccion) throws ClienteExisteException {

		boolean existeCliente;
		Cliente cliente = null;

		existeCliente=empresa.validarCliente(documento);
		if (existeCliente==false) {
			cliente = empresa.crearCliente(documento, apellido, telResidencia, telCelular, nombre, genero, ciudadResidencia,
					departamento, pais, profesion, correo, tipoDocumento, direccion);
		}
		else{
			throw new ClienteExisteException("El documento del cliente ingresado ya se escuentra registrado");
		}


		return cliente;
	}

	/**
	 * Metodo que crea un cliente y recibe los datos por parametro
	 * @param codigoPrestamo
	 * @param documentoEmpleado
	 * @param documentoCliente
	 * @param fechaEntrega
	 * @return
	 * @throws PrestamoExisteException
	 * @throws ClienteNoEncontradoException
	 * @throws EmpleadoNoEncontradoException
	 */
	public Prestamo crearPrestamo(String codigoPrestamo, String documentoEmpleado, String documentoCliente,
			LocalDate fechaEntrega) throws PrestamoExisteException, EmpleadoNoEncontradoException, ClienteNoEncontradoException {

		boolean existePrestamo;
		Prestamo prestamoAux = null;

		existePrestamo=empresa.validarPrestamo(codigoPrestamo);
		if (existePrestamo==false) {
			prestamoAux = empresa.crearPrestamo(codigoPrestamo,documentoEmpleado,documentoCliente,fechaEntrega);
			return prestamoAux;
		}
		else{
			throw new PrestamoExisteException("El documento del empleado ingresado ya se escuentra registrado");
		}
	}

	/**
	 * Metodo que crea un empleado recibiendo los datos por parametros
	 * @param nombre
	 * @param apellido
	 * @param documento
	 * @param direccion
	 * @param ciudad
	 * @param departamento
	 * @param aniosExperienciaAux
	 * @param pais
	 * @param telResidencia
	 * @param telCelular
	 * @param correo
	 * @param tipoDocumento
	 * @param tipoEmpleado
	 * @return Empleado creado en caso tal de que todo esté correcto
	 * @throws EmpleadoNoEncontradoException
	 * @throws EmpleadoExisteException
	 */
	public Empleado crearEmpleado(String nombre, String apellido, String documento, String direccion, String ciudad,
			String departamento, int aniosExperienciaAux, String pais, String telResidencia, String telCelular,
			String correo, String tipoDocumento, String tipoEmpleado) throws EmpleadoNoEncontradoException, EmpleadoExisteException {

		boolean existeEmpleado;
		Empleado empleado = null;

		existeEmpleado=empresa.validarEmpleado(documento);
		if (existeEmpleado==false) {
			empleado = empresa.crearEmpleado(nombre, apellido, documento, direccion, ciudad, departamento,
                    aniosExperienciaAux, pais, telResidencia, telCelular,correo, tipoDocumento,
                    tipoEmpleado);
			return empleado;
		}
		else{
			throw new EmpleadoExisteException("El documento del empleado ingresado ya se escuentra registrado");
		}
	}

	/**
	 * MEtodo que crea un detalle prestamos
	 * recibiendo los datos por parametors
	 * @param codigoPrestamoDetalle
	 * @param codigoObjetoDetalle
	 * @param unidadesPrestadasAux
	 * @return detallePrestamo
	 * @throws ObjetoNoEncontradoException
	 * @throws SinCantidadDisponibleException
	 * @throws PrestamoNoEncontradoException
	 */
public DetallePrestamo crearDetallePrestamo(String codigoPrestamoDetalle, String codigoObjetoDetalle,
		int unidadesPrestadasAux) throws ObjetoNoEncontradoException, SinCantidadDisponibleException, PrestamoNoEncontradoException {
			DetallePrestamo detallePrestamoAux=null;
			detallePrestamoAux = empresa.crearDetallePrestamo(codigoPrestamoDetalle,codigoObjetoDetalle,unidadesPrestadasAux);
			return detallePrestamoAux;
}

/**
 * MEtodo que crea un objeto recibiendo los atributos por parametros
 * @param nombre
 * @param codigo
 * @param descripcion
 * @param color
 * @param unidadesDisponiblesAux
 * @param valorUnitarioAux
 * @param pesoAux
 * @param tipoObjeto
 * @param foto
 * @return Objeto
 * @throws ObjetoExisteException
 */
public Objeto crearObjeto(String nombre, String codigo, String descripcion, String color, int unidadesDisponiblesAux,
		double valorUnitarioAux, double pesoAux, TipoObjeto tipoObjeto, Image foto) throws ObjetoExisteException {

	boolean existeObjeto;
	Objeto objeto = null;

	existeObjeto=empresa.validarObjeto(codigo);
	if (existeObjeto==false) {
		objeto = empresa.crearObjeto(nombre,codigo,descripcion,color,unidadesDisponiblesAux,valorUnitarioAux
    						 		                , pesoAux, tipoObjeto, foto);
		return objeto;
	}
	else{
		throw new ObjetoExisteException("El documento del empleado ingresado ya se escuentra registrado");
	}
}
	/**
	 * metodo que elimina un cliente usando su documento como identificador
	 * @param documento
	 * @throws ClienteNoEncontradoException
	 * @throws ClientePertencePrestamoException
	 */
	public void eliminarCliente(String documento) throws ClienteNoEncontradoException, ClientePertencePrestamoException {

		empresa.eliminarCliente(documento);
	}

	/**
	 * Metodo que actualiza un cliente con los valores mandados por parametro
	 * @param documentoActual
	 * @param nombre
	 * @param apellido
	 * @param documento
	 * @param direccion
	 * @param ciudad
	 * @param departamento
	 * @param genero
	 * @param pais
	 * @param telResidencia
	 * @param telCelular
	 * @param profesion
	 * @param correo
	 * @param tipoDocumento
	 * @return mensaje del cual dice si fue actualizado o no
	 * @throws ClienteNoEncontradoException
	 */
	public String actualizarCliente(String documentoActual, String nombre, String apellido,
			String documento, String direccion, String ciudad, String departamento, String genero,
			String pais, String telResidencia,String telCelular,String profesion, String correo,
			String tipoDocumento) throws ClienteNoEncontradoException {

		String mensaje="";
		mensaje = empresa.actualizarCliente(documentoActual, nombre, apellido, documento, direccion, ciudad, departamento, genero,
											pais, telResidencia,telCelular, profesion, correo,tipoDocumento);
		return mensaje;
	}
	/**
	 * Metodo que actualiza un Empleado con los valores mandados por parametro
	 * @param documentoActual
	 * @param nombre
	 * @param apellido
	 * @param documento
	 * @param direccion
	 * @param ciudad
	 * @param departamento
	 * @param aniosExperienciaAux
	 * @param pais
	 * @param telResidencia
	 * @param telCelular
	 * @param correo
	 * @param tipoDocumento
	 * @param tipoEmpleado
	 * @return
	 * @throws EmpleadoNoEncontradoException
	 */
	public String actualizarEmpleado(String documentoActual, String nombre, String apellido,
			String documento, String direccion, String ciudad, String departamento, int aniosExperienciaAux,
			String pais, String telResidencia,String telCelular,String correo, String tipoDocumento,
			String tipoEmpleado ) throws EmpleadoNoEncontradoException {

		String mensaje="";
		mensaje = empresa.actualizarEmpleado(documentoActual, nombre, apellido, documento, direccion, ciudad, departamento,
											aniosExperienciaAux, pais, telResidencia, telCelular,correo, tipoDocumento,
											tipoEmpleado);
		return mensaje;
	}
/**
 * metodo que actualiza un objeto usando los valores
 * ingresados por parametro
 * @param codigoActual
 * @param nombre
 * @param codigo
 * @param descripcion
 * @param color
 * @param unidadesDisponibles
 * @param valorUnitario
 * @param peso
 * @param tipoObjeto
 * @param foto
 * @return
 * @throws ObjetoNoEncontradoException
 */
	public String actualizarObjeto(String codigoActual, String nombre, String codigo, String descripcion, String color,
			int unidadesDisponibles, double valorUnitario, double peso, TipoObjeto tipoObjeto, Image foto) throws ObjetoNoEncontradoException {
		String mensaje="";
		mensaje = empresa.actualizarObjeto(codigoActual, nombre, codigo, descripcion, color, unidadesDisponibles,
											valorUnitario,peso, tipoObjeto, foto);
		return mensaje;
	}
	public String actualizarPrestamo(String codigoActual, String codigoPrestamo, String documentoEmpleado,
			String documentoCliente, LocalDate fechaEntrega) throws EmpleadoNoEncontradoException, ClienteNoEncontradoException, PrestamoNoEncontradoException {
		String mensaje="";
		mensaje=empresa.actualizarPrestamo(codigoActual,codigoPrestamo,documentoEmpleado,documentoCliente,fechaEntrega);
		return mensaje;
	}

	/**
	 * Metodo que obtiene la lista de Empleados
	 * @return listaEmpleados
	 */
	public ArrayList<Empleado> obtenerEmpleados() {

		return empresa.getListaEmpleados();
	}

	/**
	 * metodo que verifica si un objeto está registrado
	 * en almenos un prestamo
	 * @param codigo
	 * @return existe(true si pertenece, false de lo contrario)
	 * **/
	public boolean verificarObjeto(String codigo) {
		return empresa.verificarObjetoPrestamo(codigo);
	}

	/**
	 * metodo que elimina un empleado usando su documento
	 * @param documento
	 * @throws EmpleadoPertenecePrestamoException
	 * @throws EmpleadoNoEncontradoException
	 */
	public void eliminarEmpleado(String documento) throws EmpleadoNoEncontradoException, EmpleadoPertenecePrestamoException {
		empresa.eliminarEmpleado(documento);

	}
	/**
	 * metodo que elimina un objeto usando su codigo
	 * @param codigo
	 * @throws ObjetoNoEncontradoException
	 */
	public void eliminarObjeto(String codigo) throws ObjetoNoEncontradoException {
		empresa.eliminarObjeto(codigo);
	}


public Window getPrimaryStage() {
	return primaryStage;
}
/**
 * Metodo que toma la lista de objetos
 * @return listaObjetos
 */
public ArrayList<Objeto> obtenerObjetos() {

	return empresa.getListaObjetos();
}
/**
 * MEtodo que toma la lista de prestamos
 * @return ListaPrestamos
 */
public ArrayList<Prestamo> obtenerPrestamos() {
	return empresa.getListaPrestamos();
}
/**
 * MEtodo que toma la lista de detalle prestamo
 * @return listaDEtallePrestamo
 */
public ArrayList<DetallePrestamo> obtenerDetalles() {
	return empresa.obtenerDetallePrestamos();
}




}
