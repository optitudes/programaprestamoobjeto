package co.edu.uniquindio.prestamoobjeto.model;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import co.edu.uniquindio.prestamoobjeto.exception.ClienteExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.ClienteNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.ClientePertencePrestamoException;
import co.edu.uniquindio.prestamoobjeto.exception.DetalleNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.EmpleadoExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.EmpleadoNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.EmpleadoPertenecePrestamoException;
import co.edu.uniquindio.prestamoobjeto.exception.ObjetoExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.ObjetoNoDisponibleException;
import co.edu.uniquindio.prestamoobjeto.exception.ObjetoNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.PrestamoNoEncontradoException;
import co.edu.uniquindio.prestamoobjeto.exception.SinCantidadDisponibleException;
import co.edu.uniquindio.prestamoobjeto.exception.PrestamoExisteException;
import co.edu.uniquindio.prestamoobjeto.exception.SinEmpleadosRegistradosException;
import co.edu.uniquindio.prestamoobjeto.exception.SinObjetosPrestadosException;
import co.edu.uniquindio.prestamoobjeto.exception.SinObjetosRegistradosException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Esta clase representa la empresa, la cual es el centro del
 * programa
 * universidad del quindio
 * ingenieria de sistemas y computacion
 * @author Juan Sebastian Rojas Juan Pablo Cardona Brayan Felipe Tangarife Rios
 *
 */
public class Empresa {

	/**
	 * Atributos de la clase
	 */
	private String nombre;
	private String nit;

	private ArrayList<Cliente>  listaClientes;
	private ArrayList<Empleado> listaEmpleados;
	private ArrayList<Prestamo> listaPrestamos;
	private ArrayList<Objeto>   listaObjetos;
	/**
	 * metodo constructor de la clase empresa
	 * @param nombre
	 * @param nit
	 * @param numeroClientes
	 * @param numeroEmpleados
	 * @param numeroPrestamos
	 * @param numeroObjetos
	 */
	public Empresa(String nombre, String nit)
	{
		this.nombre = nombre;
		this.nit = nit;
		this.listaClientes =new ArrayList<>();
		this.listaEmpleados=new ArrayList<>();
		this.listaPrestamos=new ArrayList<>();
		this.listaObjetos  =new ArrayList<>();

	}


	/**
	 * Metodo get del Nombre de la clase empresa
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo set del Nombre de la clase empresa
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo get del Nit de la clase empresa
	 * @return
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * Metodo set del Nit de la clase empresa
	 * @param nit
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * Metodo set de la listas Clientes de la clase empresa
	 * @param listaClientes
	 */
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * Metodo set de la listas Empleados de la clase empresa
	 * @param listaEmpleados
	 */
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	/**
	 * Metodo set de la listas Prestamos de la clase empresa
	 * @param listaPrestamos
	 */
	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}


	/**
	 * Metodo set de la listas Objetos de la clase empresa
	 * @param listaObjetos
	 */
	public void setListaObjetos(ArrayList<Objeto> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}

	/**
	 * Metodo get del arraylist lista empleados
	 * @return listaEmpleados
	 */
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	/**
	 * Metodo get del arraylist lista prestamos
	 * @return listaPrestamos
	 */
	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	/**
	 * Metodo get del arraylist lista objetos
	 * @return listaObjetos
	 */
	public ArrayList<Objeto> getListaObjetos() {
		return listaObjetos;
	}

	/**
	 * metodo toString de la clase empresa
	 */
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", nit=" + nit + ", listaClientes=" + listaClientes + ", listaEmpleados="
				+ listaEmpleados + ", listaPrestamos=" + listaPrestamos + ", listaObjetos=" + listaObjetos + "]";
	}

	/**
	 * metodo que crea un cliente, si el cliente ya existe lo informa .
	 * @param documento
	 * @param nombre
	 * @param genero
	 * @param ciudadResidencia
	 * @param tipoDocumento
	 * @throws SinCupoClientesException
	 * @throws ClienteExisteException
	 */
	public Cliente crearCliente(String documento, String apellido,String telResidencia, String telCelular, String nombre, String genero,
			String ciudadResidencia, String departamento, String pais, String profesion, String correo,
			String tipoDocumento,String direccion)
	{

		Cliente clienteAux=null;

		clienteAux= new Cliente(apellido, documento,telResidencia, telCelular, nombre, genero, ciudadResidencia,
				departamento,  pais,  profesion,  correo, tipoDocumento, direccion);
		listaClientes.add(clienteAux);
		return clienteAux;
	}

	/**
	 * metodo que busca la posicion de un cliente usando su codigo
	 * si el cliente no es encontrado se retorna -1
	 * @param documento
	 * @return posicion
	 */
	private int obtenerPosicionCliente(String documento) {
		int      posicion=-1;
		String   documentoCliente="";
		boolean  encontrado=false;
		Cliente clienteAux=null;

		for (int i=0;i<listaClientes.size() && !encontrado; i++) {
			clienteAux=listaClientes.get(i);

			if(clienteAux!=null)
			{
				documentoCliente=clienteAux.getDocumento();
				if(documentoCliente.equalsIgnoreCase(documento))
				{
					posicion=i;
					encontrado=true;
				}
			}

		}
		return posicion;
	}

	/**
	 * metodo que busca la posicion de un prestamo usando su codigo
	 * si el prestamo no es encontrado se retorna -1
	 * @param codigo
	 * @return posicion
	 */
	private int obtenerPosicionPrestamo(String codigo) {
		int      posicion=-1;
		String   codigoPrestamo="";
		boolean  encontrado=false;
		Prestamo prestamoAux=null;

		for (int i=0;i<listaPrestamos.size() && !encontrado; i++) {
			prestamoAux=listaPrestamos.get(i);

			if(prestamoAux!=null)
			{
				codigoPrestamo=prestamoAux.getCodigo();
				if(codigoPrestamo.equalsIgnoreCase(codigo))
				{
					posicion=i;
					encontrado=true;
				}
			}

		}
		return posicion;
	}
	/**
	 * Metodo para crear el objeto,si todos los Empleados ya han sido creados los
	 * informa  o si ya ha sido registrado
	 * ese mismo empleado genera la Exception
	 * @param nombre
	 * @param codigo
	 * @param descripcion
	 * @param color
	 * @param unidadesDisponiblesAux
	 * @param valorUnitarioAux
	 * @param pesoAux
	 * @param tipoObjeto
	 * @param foto
	 * @return
	 * @throws ObjetoExisteException
	 */
	public Objeto crearObjeto(String nombre, String codigo, String descripcion, String color,
			int unidadesDisponiblesAux, double valorUnitarioAux, double pesoAux, TipoObjeto tipoObjeto, Image foto) throws ObjetoExisteException {

		int posicion;
		Objeto objeto=null;
		posicion=obtenerPosicionObjeto(codigo);

		if(posicion==-1)
		{
			objeto= new Objeto(nombre, codigo, descripcion, color, unidadesDisponiblesAux, valorUnitarioAux, pesoAux
					          , tipoObjeto, foto);
			listaObjetos.add(objeto);
			return objeto;
		}
		else
		{
			throw new ObjetoExisteException("El objeto con la identificacionn "+codigo
					                          +" ya existe en la posicion :"+ ++posicion);
		}
	}

/**
 * MEtodo de crear prestamo
 * @param codigoPrestamo
 * @param documentoEmpleado
 * @param documentoCliente
 * @param fechaEntrega
 * @return prestamo
 * @throws EmpleadoNoEncontradoException
 * @throws ClienteNoEncontradoException
 */
public Prestamo crearPrestamo(String codigoPrestamo, String documentoEmpleado, String documentoCliente,
		LocalDate fechaEntrega) throws EmpleadoNoEncontradoException, ClienteNoEncontradoException {

		Prestamo prestamo=null;
		Empleado empleadoAux=null;
		Cliente  clienteAux=null;


		empleadoAux=obtenerEmpleado(documentoCliente);
		clienteAux=obtenerCliente(documentoCliente);
		prestamo=new Prestamo(codigoPrestamo,fechaEntrega, clienteAux, empleadoAux);
		prestamo.actualizarDatos();
		listaPrestamos.add(prestamo);
		return prestamo;
}


	/**
     * Metodo para crear el empleado,si todos los Empleados ya han sido creados los
     * informa  o si ya ha sido registrado
     * ese mismo empleado genera la Exception EmpleadoExisteException
     * @param nombre (inf del empleado)
     * @param codigo (inf del empleado)
     * @param correo (inf del empleado)
     * @param aniosExperiencia (inf del empleado)
	 * @throws EmpleadoExisteException
     * @throws SinCupoEmpleadoException (inf del empleado)
     */
	public Empleado crearEmpleado(String nombre, String apellido, String documento, String direccion, String ciudad,
			String departamento, int aniosExperienciaAux, String pais, String telResidencia, String telCelular,
			String correo, String tipoDocumento, String tipoEmpleado) throws EmpleadoExisteException
    {
		int posicion;
		Empleado empleadoAux=null;
		posicion=obtenerPosicionEmpleado(documento);

		if(posicion==-1)
		{
			empleadoAux= new Empleado(nombre, apellido, documento, direccion, ciudad, departamento,
									  aniosExperienciaAux, pais, telResidencia, telCelular,correo, tipoDocumento,
									  tipoEmpleado);
			listaEmpleados.add(empleadoAux);
			return empleadoAux;
		}
		else
		{
			throw new EmpleadoExisteException("El empleado con la identificación "+documento
					                          +" ya existe en la posicion :"+ ++posicion);
		}
    }
/**
 * metodo que busca la posicion de un objeto usando su codigo
	 * si el objeto no es encontrado se retorna -1
 * @param codigo
 * @return posicion
 */
	private int obtenerPosicionObjeto(String codigo) {

		int      posicion=-1;
		String   codigoObjeto="";
		boolean  encontrado=false;
		Objeto objetoAux=null;

		for (int i=0;i<listaObjetos.size() && !encontrado; i++) {
			objetoAux=listaObjetos.get(i);

			if(objetoAux!=null)
			{
				codigoObjeto=objetoAux.getCodigo();
				if(codigoObjeto.equalsIgnoreCase(codigo))
				{
					posicion=i;
					encontrado=true;
				}
			}

		}
		return posicion;
	}


	/**
	 * metodo que busca la posicion de un empleado usando su codigo
	 * si el empleado no es encontrado se retorna -1
	 * @param codigo
	 * @return posicion
	 */
	private int obtenerPosicionEmpleado(String documento) {

		int      posicion=-1;
		String   documentoEmpleado="";
		boolean  encontrado=false;
		Empleado empleadoAux=null;

		for (int i=0;i<listaEmpleados.size() && !encontrado; i++) {
			empleadoAux=listaEmpleados.get(i);

			if(empleadoAux!=null)
			{
				documentoEmpleado=empleadoAux.getDocumento();
				if(documentoEmpleado.equalsIgnoreCase(documento))
				{
					posicion=i;
					encontrado=true;
				}
			}

		}
		return posicion;
	}

	/**
	 * metodo que obtiene y retorna un empleado basandose en su documento
	 * si el empleado no es encontrado se genera un EmpleadoNoEncontradoException
	 * @param codigoEmpleado
	 * @return empleadoAux
	 * @throws EmpleadoNoEncontradoException
	 */
	private Empleado obtenerEmpleado(String documentoEmpleadoBuscar) throws EmpleadoNoEncontradoException {
		String documentoEmpleado;

		for(Empleado empleadoAux:listaEmpleados)
		{
			documentoEmpleado=empleadoAux.getDocumento();
			if(documentoEmpleado.equals(documentoEmpleadoBuscar))
				return empleadoAux;

		}
		throw new EmpleadoNoEncontradoException("El documento ingresado no coincide con el de ningún "+
												"cliente registrado...");
	}

	/**
	 * metodo que obtiene y retorna un cliente basandose en su identificación.
	 * si el cliente no es encontrado se genera un ClienteNoEncontradoException
	 * @param documentoCliente
	 * @return clienteAux
	 * @throws ClienteNoEncontradoException
	 */
	private Cliente obtenerCliente(String documentoClienteBuscar) throws ClienteNoEncontradoException {
		String documentoCliente;


		for(Cliente clienteAux:listaClientes)
		{
			documentoCliente=clienteAux.getDocumento();
			if(documentoCliente.equals(documentoClienteBuscar))
				return clienteAux;

		}
		throw new ClienteNoEncontradoException("El documento ingresado no coincide con el de ningún "+
												"cliente registrado...");
	}

	/**
	 * metodo que elimina un empleado, se busca al empleado usando el
	 * codigo ingresado como parametro, si el empleado no es encontrado
	 * se genera un EmpleadoNoEncontradoException
	 * @param codigo
	 * @throws EmpleadoNoEncontradoException
	 */
	public void eliminarEmpleado(String documento) throws EmpleadoNoEncontradoException, EmpleadoPertenecePrestamoException {
		int posicion;
		Empleado empleadoAux=null;
		posicion=obtenerPosicionEmpleado(documento);
		if(verificarExistenciaPrestamoEmpleado(documento))
			throw new EmpleadoPertenecePrestamoException("El empleado pertenece a un prestamo"
					+" por tanto no puede borrarse");

		if(posicion!=-1)
		{
			listaEmpleados.remove(posicion);
		}
		else
		{
			throw new EmpleadoNoEncontradoException("El empleado no ha sido encontrado...");
		}

	}

	/**
	 * metodo que actualiza los datos de un cliente, el metodo
	 * encuentra al cliente usando el codigoAux.
	 * Si el cliente a actualizar no es encontrado, se genera
	 * un ClienteNoEncontradoException
	 * @param codigoAux
	 * @param documento
	 * @param nombre
	 * @param genero
	 * @param ciudadResidencia
	 * @param correo
	 * @param profesion
	 * @param pais
	 * @param departamento
	 * @param ciudadResidencia2
	 * @param tipoDocumento
	 * @param direccion
	 * @param tipoDocumento2
	 * @param correo
	 * @throws ClienteNoEncontradoException
	 */
	public String actualizarCliente(String documentoActual, String nombre, String apellido, String documento, String direccion,
			String ciudad, String departamento, String genero, String pais, String telResidencia, String telCelular, String profesion,
			String correo, String tipoDocumento) throws ClienteNoEncontradoException {
		int posicion;
		Cliente clienteAux=null;
		posicion=obtenerPosicionCliente(documentoActual);

		if(posicion!=-1)
		{
			clienteAux= new Cliente(apellido, documento, telResidencia, telCelular, nombre, genero, ciudad, departamento,
					pais, profesion, correo, tipoDocumento, direccion);

			listaClientes.get(posicion).actualizarDatos(clienteAux);
			return "El cliente "+listaClientes.get(posicion).getNombre()+
					" ha sido actualizado con exito.";
		}
		else
		{
			throw new ClienteNoEncontradoException("El cliente no ha sido encontrado");
		}

	}


	/**
	 * metodo que actualiza los datos de un emoleado, el metodo
	 * encuentra al empleado usando el documentoActual.
	 * Si el empleado a actualizar no es encontrado, se genera
	 * un EmpleadoNoEncontradoException
	 * @param documentoActual
	 * @param nombre
	 * @param apellido
	 * @param documento
	 * @param direccion
	 * @param ciudad
	 * @param departamento
	 * @param aniosExperiencia
	 * @param pais
	 * @param telResidencia
	 * @param telCelular
	 * @param correo
	 * @param tipoDocumento
	 * @param tipoEmpleado
	 * @return
	 */
	public String actualizarEmpleado(String documentoActual, String nombre, String apellido,
			String documento, String direccion, String ciudad, String departamento, int aniosExperiencia,
			String pais, String telResidencia,String telCelular,String correo, String tipoDocumento,
			String tipoEmpleado) throws  EmpleadoNoEncontradoException {

		int posicion;
		Empleado empleadoAux=null;
		posicion=obtenerPosicionEmpleado(documentoActual);

		if(posicion!=-1)
		{
			empleadoAux= new Empleado(nombre, apellido, documento, direccion, ciudad, departamento,
										aniosExperiencia, pais, telResidencia, telCelular, correo, tipoDocumento, tipoEmpleado);

			listaEmpleados.get(posicion).actualizar(empleadoAux);
			return "El empleado"+listaEmpleados.get(posicion).getNombre()+
					" ha sido actualizado con exito.";
		}
		else
		{
			throw new EmpleadoNoEncontradoException("El empleado no ha sido encontrado");
		}

	}

/**
 * Metodo que actualiza un objeto
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
 * @return mensaje de si fue creado
 * @throws ObjetoNoEncontradoException
 */
	public String actualizarObjeto(String codigoActual, String nombre, String codigo, String descripcion, String color,
			int unidadesDisponibles, double valorUnitario, double peso, TipoObjeto tipoObjeto, Image foto) throws ObjetoNoEncontradoException {

		int posicion;
		Objeto objetoAux=null;
		posicion=obtenerPosicionObjeto(codigoActual);

		if(posicion!=-1)
		{
			objetoAux= new Objeto(nombre, codigo, descripcion, color, unidadesDisponibles, valorUnitario, peso, tipoObjeto, foto);

			listaObjetos.get(posicion).actualizar(objetoAux);
			return "El objeto"+listaObjetos.get(posicion).getNombre()+
					" ha sido actualizado con exito.";
		}
		else
		{
			throw new ObjetoNoEncontradoException("El objeto no ha sido encontrado");
		}
	}

/*+
 * MEtodo que actualiza un prestamo
 */
public String actualizarPrestamo(String codigoActual, String codigoPrestamo, String documentoEmpleado,
		String documentoCliente, LocalDate fechaEntrega) throws EmpleadoNoEncontradoException, ClienteNoEncontradoException, PrestamoNoEncontradoException {

	int posicion;
	Empleado empleadoAux=null;
	Cliente clienteAux=null;
	Prestamo prestamoAux=null;
	empleadoAux=obtenerEmpleado(documentoEmpleado);
	clienteAux=obtenerCliente(documentoCliente);
	posicion=obtenerPosicionObjeto(codigoActual);

	if(posicion!=-1)
	{

		prestamoAux = new Prestamo(codigoPrestamo, fechaEntrega, clienteAux, empleadoAux);
		prestamoAux.actualizarDatos();
		listaPrestamos.get(posicion).actualizar(prestamoAux);
		return "El prestamo"+listaPrestamos.get(posicion).getCodigo()+
				" ha sido actualizado con exito.";
	}
	else
	{
		throw new PrestamoNoEncontradoException("El objeto no ha sido encontrado");
	}
}





/**
 * metodo que elimina un objeto usando su codigo
 * @param codigo
 * @throws ObjetoNoEncontradoException
 */
	public void eliminarObjeto(String codigo) throws ObjetoNoEncontradoException {
		int posicion;
		Objeto objetoAux=null;
		posicion=obtenerPosicionObjeto(codigo);

		if(posicion!=-1)
		{
			listaObjetos.remove(posicion);
		}
		else
		{
			throw new ObjetoNoEncontradoException("El objeto no ha sido encontrado...");
		}

	}


	/**
	 * metodo que elimina un empleado, se busca al empleado usando el
	 * codigo ingresado como parametro, si el empleado no es encontrado
	 * se genera un EmpleadoNoEncontradoException
	 * @param documento
	 * @throws ClienteNoEncontradoException
	 */
	public void eliminarCliente(String documento) throws ClienteNoEncontradoException,ClientePertencePrestamoException {
		int posicion;
		Cliente clienteAux=null;
		if(verificarExistenciaPrestamoCliente(documento))
			throw new ClientePertencePrestamoException("El cliente pertenece a un prestamo"
					+" por tanto no puede borrarse");
		posicion=obtenerPosicionCliente(documento);

		if(posicion!=-1)
		{
			listaClientes.remove(posicion);
		}
		else
		{
			throw new ClienteNoEncontradoException("El cliente no ha sido encontrado...");
		}
	}

	/**
	 * Metodo que verifica si un empleado pertenece algun prestamo
	 * @param documento
	 * @return true si pertenece y false de lo contrario retorna false
	 */
	private boolean verificarExistenciaPrestamoEmpleado(String documento) {
		boolean existeEmpleado=false;

		for ( Prestamo prestamoAux: listaPrestamos) {

			if(prestamoAux.verificarExistenciaCliente(documento))
			{
				existeEmpleado=true;
				return existeEmpleado;
			}
		}

		return existeEmpleado;
	}


	/**
	 * metodo que verifica si un cliente est� registrado en almenos
	 * un prestamo usando su codigo de documento
	 * @param documento
	 * @return existeCliente(true si existe en almenos un prestamo, false de lo contrario)
	 */
	private boolean verificarExistenciaPrestamoCliente(String documento) {

		boolean existeCliente=false;

		for ( Prestamo prestamoAux: listaPrestamos) {

			if(prestamoAux.verificarExistenciaCliente(documento))
			{
				existeCliente=true;
				return existeCliente;
			}
		}

		return existeCliente;

	}
	/**
	 * metodo que verifica que el documento ingresado como parametro
	 * sea igual al documento de algun cliente registrado
	 * @param documentoAux
	 * @return existe(true si existe, false de lo contrario)
	 * @throws ClienteNoEncontradoException
	 */
	public boolean validarCliente(String documentoAux)  {

		Cliente clienteAux;

		String documentoCliente;
		boolean existe=false;

		for(int i=0;i<listaClientes.size() && !existe;i++)
		{
			clienteAux=listaClientes.get(i);
			documentoCliente=clienteAux.getDocumento();
			if(documentoCliente.equals(documentoAux))
				existe=true;
		}

		return existe;
	}
	 /**
     * metodo que verifica que el codigo ingresado como parametro
     * sea igual al codigo de algunn empleado registrado
     * @param codigoAux
     * @return existe()true si existe, false de lo contrario
     * @throws EmpleadoNoEncontradoException
     */
    public boolean validarEmpleado(String documentoAux) throws EmpleadoNoEncontradoException
    {
    	String documentoEmpleado;
    	boolean existe=false;

    	Empleado empleadoAux;

    	for(int i=0;i<listaEmpleados.size();i++)
    	{
    		empleadoAux=listaEmpleados.get(i);
			documentoEmpleado=empleadoAux.getDocumento();
			if(documentoEmpleado.equals(documentoAux))
				existe=true;
				return existe;
    	}
    	return existe;
    }
    /**
     * metodo que verifica que el codigo ingresado como parametro
     * sea igual al codigo de algunn objeto registrado
     * @param codigoAux
     * @return existe(true si los codigos son iguales, false de lo contrario)
     */
	public boolean validarObjeto(String codigoAux) {


		String codigoObjeto;
    	boolean existe=false;

    	Objeto objetoAux;

    	for(int i=0;i<listaObjetos.size();i++)
    	{
    		objetoAux=listaObjetos.get(i);
			codigoObjeto=objetoAux.getCodigo();
			if(codigoObjeto.equals(codigoAux))
				existe=true;
				return existe;
    	}
    	return existe;
	}
	/**
	 * metodo que verifica que el codigo ingresado como parametro
     * sea igual al codigo de prestamo objeto registrado
	 * @param codigoPrestamoAux
	 * @return existe(true si existe, false de lo contrario)
	 */
	public boolean validarPrestamo(String codigoPrestamoAux) {
		boolean existe=false;

		for (Prestamo prestamo : listaPrestamos) {
			existe=prestamo.verificarCodigo(codigoPrestamoAux);
			if(existe==true)
				return existe;
		}


		return existe;
	}

	/**
	 * MEtodo get del arraylist lista clientes
	 * @return listaClientes
	 */
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

/**
 * metodo que verifica si un objeto est� registrado
 * en almenos un prestamo
 * @param codigo
 * @return existe(true si pertenece, false de lo contrario)
 */
	public boolean verificarObjetoPrestamo(String codigo) {

    	boolean existe=false;
    	for (Prestamo prestamoAux : listaPrestamos) {
    		existe=prestamoAux.verificarExistenciaObjeto(codigo);
    		if(existe==true)
    			return existe;
		}
    	return existe;

	}

/**
 * metodo que crea un detalle de prestamo
 * @param codigoPrestamoDetalle
 * @param codigoObjetoDetalle
 * @param unidadesPrestadasAux
 * @return
 * @throws ObjetoNoEncontradoException
 * @throws SinCantidadDisponibleException
 * @throws DetalleNoEncontradoException
 * @throws PrestamoNoEncontradoException
 */
public DetallePrestamo crearDetallePrestamo(String codigoPrestamoDetalle, String codigoObjetoDetalle,
		int unidadesPrestadasAux) throws ObjetoNoEncontradoException, SinCantidadDisponibleException, PrestamoNoEncontradoException {
	boolean realizado=false;
	String codigoPrestamo="";
	Objeto objetoAux=null;
	objetoAux=obtenerObjeto(codigoObjetoDetalle);
	for (int i = 0; i < listaPrestamos.size() && !realizado; i++) {
		codigoPrestamo=listaPrestamos.get(i).getCodigo();
		if(codigoPrestamo.equals(codigoPrestamoDetalle)){
			reducirUnidadesObjeto(codigoObjetoDetalle,unidadesPrestadasAux);
			listaPrestamos.get(i).agregarDetalle(objetoAux,unidadesPrestadasAux);
			realizado=true;
		}
	}
	throw new PrestamoNoEncontradoException("El prestamo no fue encontrado");
}

/**
 * MEtodo que reduce las unidades disponibles de un objeto
 * @param codigoObjetoDetalle
 * @param unidadesPrestadasAux
 * @throws SinCantidadDisponibleException
 */
private void reducirUnidadesObjeto(String codigoObjetoDetalle, int unidadesPrestadasAux) throws SinCantidadDisponibleException {

	boolean realizado=false;
	String codigoObjeto="";

	for (int i = 0; i < listaObjetos.size() && !realizado; i++) {
		codigoObjeto=listaObjetos.get(i).getCodigo();
		if(codigoObjeto.equals(codigoObjetoDetalle)){
			listaObjetos.get(i).reducirUnidades(unidadesPrestadasAux);
			realizado=true;
		}
	}

}


/**
 * Metodo que obtiene un objeto dado su codigo
 * @param codigoObjetoBuscar
 * @return objeto
 * @throws ObjetoNoEncontradoException
 */
private Objeto obtenerObjeto(String codigoObjetoBuscar) throws ObjetoNoEncontradoException {
	String codigoObjeto;

	for(Objeto objetoAux:listaObjetos)
	{
		codigoObjeto=objetoAux.getCodigo();
		if(codigoObjeto.equals(codigoObjetoBuscar))
			return objetoAux;
	}

	throw new ObjetoNoEncontradoException("El codigo ingresado no coincide con el de ningún "+
											"objeto registrado...");
}

/**
 * Metodo que obtine la lista de los detalles prestamos
 * @return listaDetalleprestamo
 */
public ArrayList<DetallePrestamo> obtenerDetallePrestamos() {
	ArrayList<DetallePrestamo> listaDetallesPrestamoAux=new ArrayList<>();
	for (Prestamo prestamo : listaPrestamos) {
		listaDetallesPrestamoAux.addAll(prestamo.getListaDetallesPrestamos());
	}
	return listaDetallesPrestamoAux;
}




}