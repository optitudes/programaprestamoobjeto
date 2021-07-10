package co.edu.uniquindio.programaprestamoobjeto.model;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import co.edu.uniquindio.programaprestamoobjeto.excepciones.ClienteExisteException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.ClienteNoEncontradoException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.EmpleadoExisteException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.EmpleadoNoEncontradoException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.ObjetoNoDisponibleException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.ObjetoNoEncontradoException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.PrestamoNoEncontradoException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinCantidadDisponibleException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinClientesRegistradosException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinCupoDetallePrestamo;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinCupoEmpleadoException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinCupoObjetoException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinCupoPrestamoException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinEmpleadosRegistradosException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinObjetosPrestadosException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinObjetosRegistradosException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinPrestamosRegistradosException;

/**
 * Esta clase representa la empresa, la cual es el centro del
 * programa
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 *
 */
public class Empresa {
	private String nombre;
	private String nit;

	private ArrayList<Cliente>  listaClientes;

	private ArrayList<Empleado> listaEmpleados;

	private ArrayList<Prestamo> listaPrestamos;

	private ArrayList<Objeto>   listaObjetos;
	/**
	 * método constructor de la clase empresa
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
	 *
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getNit() {
		return nit;
	}



	public void setNit(String nit) {
		this.nit = nit;
	}



	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}



	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}



	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}



	public void setListaObjetos(ArrayList<Objeto> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}




	/**
	 * método toString de la clase empresa
	 */
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", nit=" + nit + ", listaClientes=" + listaClientes + ", listaEmpleados="
				+ listaEmpleados + ", listaPrestamos=" + listaPrestamos + ", listaObjetos=" + listaObjetos + "]";
	}

	/**
	 * método que crea un cliente, si el cliente ya existe lo informa .
	 * @param documento
	 * @param nombre
	 * @param genero
	 * @param ciudadResidencia
	 * @param tipoDocumento
	 * @throws SinCupoClientesException
	 * @throws ClienteExisteException
	 */
	public void crearCliente(String documento, String telResidencia, String telCelular, String nombre, String genero,
			String ciudadResidencia, String departamento, String pais, String profesion, String correo,
			int tipoDocumento,String direccion) throws  ClienteExisteException
	{
		int posicion;
		Cliente clienteAux=null;

		clienteAux= new Cliente(documento,telResidencia, telCelular, nombre, genero, ciudadResidencia,
				departamento,  pais,  profesion,  correo, tipoDocumento, direccion);
		listaClientes.add(clienteAux);
		posicion=listaClientes.size()-1;
		imprimirVentana("El cliente :"+listaClientes.get(posicion).getNombre()+" ha sido creado con exito.");
	}



	/**
	 * método que busca la posicion de un cliente usando su codigo
	 * si el cliente no es encontrado se retorna -1
	 * @param documento
	 * @return
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
	 * método que busca la posicion de un prestamo usando su codigo
	 * si el prestamo no es encontrado se retorna -1
	 * @param codigo
	 * @return posicion
	 */
	private int obtenerPosicionPrestamo(String codigo) {
		int      posicion=-1;
		String   codigoPrestamo="";
		boolean  encontrado=false;
		Prestamo prestamoAux=null;

		for (int i=0;i<listaPrestamos.length && !encontrado; i++) {
			prestamoAux=listaPrestamos[i];

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
	 * m�todo que sirve para imprimir un mensaje por ventana
	 * @param mensaje
	 */
	public static void imprimirVentana(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	/**
	 * m�todo que imprime un error por ventana
	 * @param mensaje
	 */
	public static void imprimirVentanaError(String mensaje)
	{
		JOptionPane.showMessageDialog(null,mensaje,"ERROR!",JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * m�todo que imprime una advertencia por ventana
	 */
	public static void imprimirVentanaAdvertencia(String mensaje)
	{
		JOptionPane.showMessageDialog(null,mensaje,"Advertencia!",JOptionPane.WARNING_MESSAGE);
	}
	/**
	 * método que crea un objeto, si todos los objetos ya han sido creados genera
	 * la excepción SinCupoObjeto
	 * @param nombre
	 * @param codigo
	 * @param unidadesDisponibles
	 * @param estado
	 * @param precioAlquiler
	 * @param tipoObjeto
	 * @throws SinCupoObjetoException
	 */
	public void crearObjeto(String nombre, String codigo, int unidadesDisponibles, String estado,
			double precioAlquiler, int tipoObjeto) throws SinCupoObjetoException {
		if(objeto1==null)
		{
			objeto1=new Objeto(nombre,codigo,estado,unidadesDisponibles,precioAlquiler,null);
			objeto1.definirTipoObjeto(tipoObjeto);
			imprimirVentana("Objeto :"+objeto1.getNombre()+" creado con éxito");
		}
		else
		{
			if(objeto2==null)
			{
				objeto2=new Objeto(nombre,codigo,estado,unidadesDisponibles,precioAlquiler,null);
				objeto2.definirTipoObjeto(tipoObjeto);
				imprimirVentana("Objeto :"+objeto2.getNombre()+" creado con éxito");
			}
			else
			{
				if(objeto3==null)
				{
					objeto3=new Objeto(nombre,codigo,estado,unidadesDisponibles,precioAlquiler,null);
					objeto3.definirTipoObjeto(tipoObjeto);
					imprimirVentana("Objeto :"+objeto3.getNombre()+" creado con éxito");
				}
				else
				{
					throw new SinCupoObjetoException("No hay cupos disponibles para crear más objetos.");

				}
			}
		}
	}
	/**
	 * Metodo que consulta los datos de un objeto mediante el codigo se invoca verificarCodigo(codigo)
	 * para ver si coinside con el codigo de cada objeto
	 * @param codigo
	 * @throws ObjetoNoEncontradoException
	 */
	public void consultarDatosObjeto (String codigo) throws ObjetoNoEncontradoException{
		boolean objetoEncontrado=false;
		if(objeto1!=null)
		{
			if(objeto1.verificarCodigo(codigo)==true) {
				imprimirVentana(objeto1.toString());
				objetoEncontrado=true;
			}
		}
		if(objeto2!=null)
		{
			if(objeto2.verificarCodigo(codigo)==true){
				imprimirVentana(objeto2.toString());
				objetoEncontrado=true;
			}
		}
		if(objeto3!=null)
		{
			if(objeto3.verificarCodigo(codigo)==true){
				imprimirVentana(objeto3.toString());
				objetoEncontrado=true;
			}
		}
		if(objetoEncontrado==false)
		{
			throw new ObjetoNoEncontradoException("No hay ningun objeto con ese codigo");

		}
	}
	/**
     * Metodo para crear el empleado
     * @param nombre (inf del empleado)
     * @param codigo (inf del empleado)
     * @param correo (inf del empleado)
     * @param aniosExperiencia (inf del empleado)
	 * @throws EmpleadoExisteException
     * @throws SinCupoEmpleadoException (inf del empleado)
     */
	public void crearEmpleado(String documento, String nombre, String telResidencia, String telCelular, String direccion,
			String ciudadResidencia, String departamento, String pais, String correo, int tipoDocumento,
			int tipoEmpleado) throws EmpleadoExisteException
    {
		int posicion;
		Empleado empleadoAux=null;
		posicion=obtenerPosicionEmpleado(documento);

		if(posicion==-1)
		{
			empleadoAux= new Empleado(documento, nombre, telResidencia, telCelular, direccion,
						ciudadResidencia, departamento, pais, correo, tipoDocumento, tipoEmpleado);
			listaEmpleados.add(empleadoAux);
			imprimirVentana("El empleado "+listaEmpleados.get(posicion).getNombre()+
							" ha sido creado con exito.");
		}
		else
		{
			throw new EmpleadoExisteException("El empleado con la identificación "+documento
					                          +" ya existe en la posicion :"+ ++posicion);
		}
    }
	/**
	 * método que busca la posicion de un empleado usando su codigo
	 * si el empleado no es encontrado se retorna -1
	 * @param codigo
	 * @return
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
	 * método que calcula he imprime el número de prestamos en el que está
	 * un objeto, ignorando la cantidad de unidades prestadas
	 * @param nombre
	 * @throws ObjetoNoEncontradoException
	 */
	public void calcularCantidadPrestamos(String nombre) throws ObjetoNoEncontradoException {
		int cantidadDePrestamos=0;
		boolean existeObjeto=false;
		boolean pertenecePrestamo=false;
		existeObjeto=verificarExitenciaObjetoNombre(nombre);
		if(existeObjeto==true)
		{
			if(prestamo1!=null)
			{
				pertenecePrestamo=prestamo1.verificarPertenciaPrestamo(nombre);
				if(pertenecePrestamo==true)
				{
					cantidadDePrestamos++;
				}
			}
			if(prestamo2!=null)
			{
				pertenecePrestamo=prestamo2.verificarPertenciaPrestamo(nombre);
				if(pertenecePrestamo==true)
				{
					cantidadDePrestamos++;
				}
			}
			if(prestamo3!=null)
			{
				pertenecePrestamo=prestamo3.verificarPertenciaPrestamo(nombre);
				if(pertenecePrestamo==true)
				{
					cantidadDePrestamos++;
				}
			}
			imprimirCantidadPrestamosObjeto(cantidadDePrestamos);

		}
		else
		{
			throw new ObjetoNoEncontradoException("El nombre del objeto ingresado no coincide con el de "+
												  " ningún objeto registrado...");
		}


	}
	/**método que imprime la cantidad de prestamos en los que
	 * se encuentra un objeto
	 *
	 * @param cantidadDePrestamos
	 */
	private void imprimirCantidadPrestamosObjeto(int cantidadDePrestamos) {
		if(cantidadDePrestamos==0)
		{
			imprimirVentana("El objeto no se encuentra en ningún prestamo");
		}
		else
		{
			imprimirVentana("El objeto se encuentra en :"+cantidadDePrestamos+" prestamos.");
		}
	}
	/**
	 * funcion que verifica si un objeto existe usando su codigo
	 * retorna true si extiste o false si no existe
	 * @param nombre
	 * @return existeObjeto
	 */
	private boolean verificarExitenciaObjeto(String codigoObjetoBuscar) {
		boolean existeObjeto=false;

		if(objeto1!=null)
		{
			existeObjeto=objeto1.verificarExistencia(codigoObjetoBuscar);
			if(existeObjeto==true)
				return existeObjeto;
		}
		if(objeto2!=null)
		{
			existeObjeto=objeto2.verificarExistencia(codigoObjetoBuscar);
			if(existeObjeto==true)
				return existeObjeto;
		}
		if(objeto2!=null)
		{
			existeObjeto=objeto2.verificarExistencia(codigoObjetoBuscar);
			if(existeObjeto==true)
				return existeObjeto;
		}

		return existeObjeto;
	}
	/**
	 * funcion que verifica si un objeto existe usando su nombre
	 * retorna true si extiste o false si no existe
	 * @param nombre
	 * @return existeObjeto
	 */
	private boolean verificarExitenciaObjetoNombre(String nombreObjetoBuscar) {
		boolean existeObjeto=false;

		if(objeto1!=null)
		{
			existeObjeto=objeto1.verificarExistenciaNombre(nombreObjetoBuscar);
			if(existeObjeto==true)
				return existeObjeto;
		}
		if(objeto2!=null)
		{
			existeObjeto=objeto2.verificarExistenciaNombre(nombreObjetoBuscar);
			if(existeObjeto==true)
				return existeObjeto;
		}
		if(objeto2!=null)
		{
			existeObjeto=objeto2.verificarExistenciaNombre(nombreObjetoBuscar);
			if(existeObjeto==true)
				return existeObjeto;
		}

		return false;
	}
	/**
	 * método que imprime la cantidad total de unidades prestadas
	 * por cada objeto
	 */
	public void imprimirTotalUnidadesPrestadasPorObjeto() {
		int totalObjeto1=0;
		int totalObjeto2=0;
		int totalObjeto3=0;
		String nombreObjeto1="";
		String nombreObjeto2="";
		String nombreObjeto3="";
		String respuesta="";

		if(objeto1!=null)
			nombreObjeto1=objeto1.getNombre();
		if(objeto2!=null)
			nombreObjeto2=objeto2.getNombre();
		if(objeto3!=null)
			nombreObjeto3=objeto3.getNombre();
		if(!nombreObjeto1.isEmpty())
		{
			if(prestamo1!=null)
			{
				totalObjeto1+=prestamo1.obtenerCantidadUnidadesPrestadas(nombreObjeto1);
			}
			if(prestamo2!=null)
			{
				totalObjeto1+=prestamo2.obtenerCantidadUnidadesPrestadas(nombreObjeto1);
			}
			if(prestamo3!=null)
			{
				totalObjeto1+=prestamo3.obtenerCantidadUnidadesPrestadas(nombreObjeto1);
			}
			respuesta+=generarMensajeUnidadesPrestadas(nombreObjeto1,totalObjeto1);
		}
		if(!nombreObjeto2.isEmpty())
		{
			if(prestamo1!=null)
			{
				totalObjeto2+=prestamo1.obtenerCantidadUnidadesPrestadas(nombreObjeto2);
			}
			if(prestamo2!=null)
			{
				totalObjeto2+=prestamo2.obtenerCantidadUnidadesPrestadas(nombreObjeto2);
			}
			if(prestamo3!=null)
			{
				totalObjeto2+=prestamo3.obtenerCantidadUnidadesPrestadas(nombreObjeto2);
			}
			respuesta+=generarMensajeUnidadesPrestadas(nombreObjeto2,totalObjeto2);

		}
		if(!nombreObjeto3.isEmpty())
		{
			if(prestamo1!=null)
			{
				totalObjeto3+=prestamo1.obtenerCantidadUnidadesPrestadas(nombreObjeto3);
			}
			if(prestamo2!=null)
			{
				totalObjeto3+=prestamo2.obtenerCantidadUnidadesPrestadas(nombreObjeto3);
			}
			if(prestamo3!=null)
			{
				totalObjeto3+=prestamo3.obtenerCantidadUnidadesPrestadas(nombreObjeto3);
			}
			respuesta+=generarMensajeUnidadesPrestadas(nombreObjeto3,totalObjeto3);
		}
		imprimirVentana(respuesta);
	}
	/**
	 * método que genera un string con el nombre del objeto y
	 * la cantidad total de unidades prestadas del mismo
	 * @param nombreObjeto1
	 * @param totalObjeto1
	 * @return resultado
	 */
	private String generarMensajeUnidadesPrestadas(String nombreObjeto, int totalObjeto) {
		String resultado="";
		resultado=nombreObjeto+" posee :"+totalObjeto+" cantidades prestadas.\n";
		return resultado;
	}
	/**
	 * método que imprime por consola los datos de los objetos disponibles
	 * si no hay ningún objeto disponible se activará la excepcion
	 * SinObjetosRegistradosException
	 * @throws SinObjetosRegistradosException
	 */
	public void imprimirObjetosDisponibles() throws SinObjetosRegistradosException {
		String mensaje="";
		int posicion=1;
		if(objeto1!=null || objeto2!=null || objeto3!=null )
		{
			if(objeto1!=null)
			{
				mensaje+=posicion+". nombre :"+objeto1.getNombre()+" codigo :"+objeto1.getCodigo()+"\n";
				posicion++;
			}
			if(objeto2!=null)
			{
				mensaje+=posicion+". nombre :"+objeto2.getNombre()+" codigo :"+objeto2.getCodigo()+"\n";
				posicion++;
			}
			if(objeto3!=null)
			{
				mensaje+=posicion+". nombre :"+objeto3.getNombre()+" codigo :"+objeto3.getCodigo()+"\n";
				posicion++;
			}
			imprimirVentana(mensaje);
		}
		else
		{
			throw new SinObjetosRegistradosException("No hay objetos registrados.");
		}
	}
	/**
	 * método que reemplaza un objeto por otro, de no encontrar el objeto a reemplazar
	 * se generará ObjetoNoEncontradoException
	 * @param nombre
	 * @param codigo
	 * @param unidadesDisponibles
	 * @param estado
	 * @param precioAlquiler
	 * @param codigoAux
	 * @param tipoObjeto
	 * @throws ObjetoNoEncontradoException
	 */
	public void actualizarObjeto(String nombre, String codigo, int unidadesDisponibles, String estado,
			double precioAlquiler, String codigoAux, int tipoObjeto) throws ObjetoNoEncontradoException {
		String codigoObjeto;
		boolean actualizacionExitosa=false;

		if(objeto1!=null)
		{
			codigoObjeto=objeto1.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoAux))
			{
				objeto1=new Objeto(nombre,codigo,estado,unidadesDisponibles,precioAlquiler,null);
				objeto1.definirTipoObjeto(tipoObjeto);
				imprimirVentana("Actualización exitosa!");
				actualizacionExitosa=true;
			}
		}
		if(objeto2!=null && actualizacionExitosa==false)
		{
			codigoObjeto=objeto2.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoAux))
			{
				objeto2=new Objeto(nombre,codigo,estado,unidadesDisponibles,precioAlquiler,null);
				objeto2.definirTipoObjeto(tipoObjeto);
				imprimirVentana("Actualización exitosa!");
				actualizacionExitosa=true;
			}
		}
		if(objeto3!=null&& actualizacionExitosa==false)
		{
			codigoObjeto=objeto3.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoAux))
			{
				objeto3=new Objeto(nombre,codigo,estado,unidadesDisponibles,precioAlquiler,null);
				objeto3.definirTipoObjeto(tipoObjeto);
				imprimirVentana("Actualización exitosa!");
				actualizacionExitosa=true;
			}
		}
		if(actualizacionExitosa==false)
		{
			throw new ObjetoNoEncontradoException("No hay ningun objeto con ese codigo");
		}
	}
	 /**
     * Método para crear un prestamo
     * @param codigo (Inf. del prestamo)
     * @param diasSolicitados (Inf. del prestamo)
     * @param diasTranscurridos (Inf. del prestamo)
     * @param valor (Inf. del prestamo)
     * @param unidadesPrestadas (Inf. del prestamo)
	 * @throws SinCupoDetallePrestamo
	 * @throws SinCantidadDisponibleException
	 * @throws ObjetoNoEncontradoException
	 * @throws PrestamoNoEncontradoException
     * @throws SinCupoPrestamo (ya que solo se pueden crear 3 prestamos)
     */

	public void crearPrestamo(String codigo,int diasSolicitados,int diasTranscurridos,double valor,
							 int unidadesPrestadas,Cliente clienteAux, Empleado empleadoAux,
							 Objeto objetoAux)throws SinCupoPrestamoException, SinCupoDetallePrestamo, SinCantidadDisponibleException, ObjetoNoEncontradoException, PrestamoNoEncontradoException
	{
		String codigoObjeto;
		String codigoPrestamo;
		boolean error = true;

		if(prestamo1==null){

			prestamo1= new Prestamo(codigo, diasSolicitados, diasTranscurridos, valor,clienteAux,empleadoAux);
			codigoPrestamo=prestamo1.getCodigo();
			prestamo1=crearOActualizarDetallePrestamo(codigoPrestamo,unidadesPrestadas,objetoAux);
			error=false;

		}
		else
		{
			if(prestamo2==null){

				prestamo2= new Prestamo(codigo, diasSolicitados, diasTranscurridos, valor,clienteAux,empleadoAux);
				codigoPrestamo=prestamo2.getCodigo();
				prestamo2=crearOActualizarDetallePrestamo(codigoPrestamo,unidadesPrestadas,objetoAux);
				error=false;
			}
			else
			{
				if(prestamo3==null){

					prestamo3= new Prestamo(codigo, diasSolicitados, diasTranscurridos, valor,clienteAux,empleadoAux);
					codigoPrestamo=prestamo3.getCodigo();
					prestamo3=crearOActualizarDetallePrestamo(codigoPrestamo,unidadesPrestadas,objetoAux);
					error=false;
				}
			}
		}
		if(error==true)
			throw new SinCupoPrestamoException("No hay cupos disponibles para crear más Prestamos");
    }
	/**
	 * método que crea un detalle Prestamo
	 * @param codigoPrestamo
	 * @param diasTranscurridos
	 * @param diasSolicitados
	 * @param objetoAux
	 * @param valor
	 * @param unidadesPrestadas
	 * @param error
	 * @param codigoObjeto
	 * @throws SinCantidadDisponibleException
	 * @throws ObjetoNoEncontradoException
	 * @throws SinCupoDetallePrestamo
	 * @throws PrestamoNoEncontradoException
	 */
	private Prestamo crearOActualizarDetallePrestamo(String codigoPrestamo, int unidadesPrestadas,Objeto objetoAux)
										throws SinCantidadDisponibleException,ObjetoNoEncontradoException,
										SinCupoDetallePrestamo, PrestamoNoEncontradoException {
		Prestamo prestamoAux=null;
		int      diasSolicitados;
		int      diasTranscurridos;
		int      unidadesDisponibles;
		double   valor;
		String   codigoObjeto;

		prestamoAux=obtenerPrestamo(codigoPrestamo);
		valor=prestamoAux.getValor();
		diasSolicitados=prestamoAux.getDiasSolicitados();
		diasTranscurridos=prestamoAux.getDiasTranscurridos();
		unidadesDisponibles=objetoAux.getUnidadesDisponibles();


		if(unidadesDisponibles>=unidadesPrestadas==true)
		{
			prestamoAux.crearOActualizarDetallePrestamo(unidadesPrestadas,valor,objetoAux);
			valor = prestamoAux.calcularValor(diasSolicitados,diasTranscurridos);
			setValorPrestamo(codigoPrestamo,valor);
			reducirUnidadesDisponiblesObjeto(objetoAux,unidadesPrestadas);
			codigoObjeto=objetoAux.getCodigo();
			objetoAux=obtenerObjeto(codigoObjeto);
			setObjetoDetallePrestamo(codigoPrestamo,objetoAux);
			imprimirVentana("Prestamo :"+prestamo1.getCodigo()+" creado o actualizado con éxito");
		}
		else
		{
			throw new SinCantidadDisponibleException("La cantidad del objeto solicitada"
					+" exede la existente, por tanto se "
					+"ha negado la operacion...");
		}
		return prestamoAux;
	}
	private void setObjetoDetallePrestamo(String codigoPrestamoBuscar, Objeto objetoAux) {
		String codigoPrestamo="";
		if(prestamo1!=null)
		{
			codigoPrestamo=prestamo1.getCodigo();
			if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
			{
				prestamo1.setObjetoDetallePrestamo(objetoAux);
			}
		}
		if(prestamo2!=null)
		{
			codigoPrestamo=prestamo2.getCodigo();
			if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
			{
				prestamo2.setObjetoDetallePrestamo(objetoAux);
			}
		}
		if(prestamo3!=null)
		{
			codigoPrestamo=prestamo3.getCodigo();
			if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
			{
				prestamo3.setObjetoDetallePrestamo(objetoAux);
			}
		}
	}
	/**
	 * método que setea el valor a un prestamo registrado
	 * @param codigoPrestamo
	 * @param valor
	 */
	private void setValorPrestamo(String codigoPrestamoBuscar, double valor) {
		String codigoPrestamo="";
		if(prestamo1!=null)
		{
			codigoPrestamo=prestamo1.getCodigo();
			if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
			{
				prestamo1.setValor(valor);
			}
		}
		if(prestamo2!=null)
		{
			codigoPrestamo=prestamo2.getCodigo();
			if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
			{
				prestamo2.setValor(valor);
			}
		}
		if(prestamo3!=null)
		{
			codigoPrestamo=prestamo3.getCodigo();
			if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
			{
				prestamo3.setValor(valor);
			}
		}
	}
	/**
	 * método que obtiene un prestamo usando su código
	 * si el prestamo no es encontrado se genera un
	 * PrestamoNoEncontradoException
	 * @param codigoPrestamoBuscar
	 * @return prestamoAux
	 * @throws PrestamoNoEncontradoException
	 */
	private Prestamo obtenerPrestamo(String codigoPrestamoBuscar) throws PrestamoNoEncontradoException {
		Prestamo prestamoAux=null;
		String   codigoPrestamo;
		int posicion;
		posicion=obtenerPosicionPrestamo(codigoPrestamoBuscar);
		if(posicion!=-1)
		{
			prestamoAux=listaPrestamos[posicion];
			return prestamoAux;
		}
		else
		{
			throw new PrestamoNoEncontradoException("El código ingresado no coincide con ningún "+
					"prestamo registrado");
		}

	}
	/**
	 * método que disminuye la cantidad de unidades disponibles
	 * de un objeto en la clase empresa
	 * @param objetoAux
	 * @param unidadesPrestadas
	 */
	private void reducirUnidadesDisponiblesObjeto(Objeto objetoAux, int unidadesPrestadas) {

		String  estadoAux;

		String  codigoObjetoBuscar;
		String  codigoObjeto;

		int     unidadesDisponibles;
		int     unidadesTotales;

		boolean reduccionCompleta=false;
		codigoObjetoBuscar=objetoAux.getCodigo();

		if(objeto1!=null && reduccionCompleta==false)
		{
			codigoObjeto=objeto1.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{

				unidadesDisponibles=objeto1.getUnidadesDisponibles();
				if(unidadesDisponibles>=unidadesPrestadas)
				{
					unidadesTotales=unidadesDisponibles-unidadesPrestadas;
					objeto1.setUnidadesDispobles(unidadesTotales);
					estadoAux=validarEstado(unidadesTotales);
					objeto1.setEstado(estadoAux);
					reduccionCompleta=true;
				}

			}
		}
		if(objeto2!=null && reduccionCompleta==false)
		{
			codigoObjeto=objeto2.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{
				unidadesDisponibles=objeto2.getUnidadesDisponibles();
				if(unidadesDisponibles>=unidadesPrestadas)
				{
					unidadesTotales=unidadesDisponibles-unidadesPrestadas;
					objeto2.setUnidadesDispobles(unidadesTotales);
					estadoAux=validarEstado(unidadesTotales);
					objeto2.setEstado(estadoAux);
					reduccionCompleta=true;
				}

			}
		}
		if(objeto3!=null && reduccionCompleta==false)
		{
			codigoObjeto=objeto3.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{
				unidadesDisponibles=objeto3.getUnidadesDisponibles();
				if(unidadesDisponibles>=unidadesPrestadas)
				{
					unidadesTotales=unidadesDisponibles-unidadesPrestadas;
					objeto3.setUnidadesDispobles(unidadesTotales);
					estadoAux=validarEstado(unidadesTotales);
					objeto3.setEstado(estadoAux);
					reduccionCompleta=true;
				}
			}
		}

	}
	/**
	 * método que valida el estado de un objeto, si es mayor
	 * a cero retorna "disponible" sino retorna "no diponible"
	 * @param unidadesTotales
	 * @return
	 */
	private String validarEstado(int unidadesTotales) {
		String resultado;
		if(unidadesTotales>0)
		{
			resultado="disponible";
		}
		else
		{
			resultado="no disponible";
		}
		return resultado;
	}
	/**
	 * método que imprime  los clientes registrados, los imprime enumerados con sus nombres y codigos
	 * @throws SinClientesRegistradosException
	 */
	public void imprimirClientesRegistrados() throws SinClientesRegistradosException {
		String datosClientes="";
    	String mensaje="---Clientes registrados---\n";

    	int posicion=1;

    	for (Cliente clienteAux : listaClientes) {
			datosClientes+=posicion+" Nombre: "+clienteAux.getNombre()+" Documento :"+clienteAux.getDocumento()+"\n";
			posicion++;
		}

    	if(listaClientes.size() == 0)
    	{
    		throw new SinClientesRegistradosException("No hay clientes registrados.");
    	}
    	else
    	{
    		mensaje+=datosClientes;
    		imprimirVentana(mensaje);
    	}
	}
	/**
	 * método que verifica que el documento ingresado como parametro
	 * sea igual al documento de algún cliente registrado
	 * @param documentoAux
	 * @throws ClienteNoEncontradoException
	 */
	public void validarCliente(String documentoAux) throws ClienteNoEncontradoException {
		String documentoObjeto;
		boolean error=true;

		if(cliente1!=null)
		{
			documentoObjeto=cliente1.getDocumento();
			if(documentoObjeto.equalsIgnoreCase(documentoAux))
				error=false;
		}
		if(cliente2!=null)
		{
			documentoObjeto=cliente2.getDocumento();
			if(documentoObjeto.equalsIgnoreCase(documentoAux))
				error=false;
		}
		if(error==true)
			throw new ClienteNoEncontradoException("El documento ingresado no pertenece a ninguno de los"+
													" clientes registrados");

	}
	/**
	 * método que valida si un objeto existe o no, si existe no hace nada, pero si no
	 * existe imprime una exepción
	 * @param codigoAux
	 * @throws ObjetoNoEncontradoException
	 */
	public void validarExistenciaObjeto(String codigoAux) throws ObjetoNoEncontradoException {
		boolean existeElObjeto=false;
		existeElObjeto=verificarExitenciaObjeto(codigoAux);
		if(existeElObjeto==false)
		{
			throw new ObjetoNoEncontradoException("El objeto no coincide con ningún objeto registrado");
		}
	}
	/**
     * metodo que imprime  los empleados registrados, los imprime enumerados con sus nombres y codigos
     * @throws SinEmpleadosRegistradosException
     */
    public void imprimirEmpleadosRegistrados() throws SinEmpleadosRegistradosException
    {
    	String datosEmpleado="";
    	String mensaje="---Empleados registrados---\n";

    	int posicion=1;

    	for (Empleado empleadoAux : listaEmpleados) {
			datosEmpleado+=posicion+" Nombre: "+empleadoAux.getNombre()+" Documento :"+empleadoAux.getDocumento()+"\n";
			posicion++;
		}

    	if(listaEmpleados.size() == 0)
    	{
    		throw new SinEmpleadosRegistradosException("No hay empleados registrados.");
    	}
    	else
    	{
    		mensaje+=datosEmpleado;
    		imprimirVentana(mensaje);
    	}

    }
    /**
     * método que verifica que el codigo ingresado como parametro
     * sea igual al codigo de algún empleado registrado
     * @param codigoAux
     * @throws EmpleadoNoEncontradoException
     */
    public void validarEmpleado(String codigoAux) throws EmpleadoNoEncontradoException
    {
         String documentoObjeto;
            boolean error=true;

            if(empleado1!=null)
            {
                documentoObjeto=empleado1.getCodigo();
                if(documentoObjeto.equalsIgnoreCase(codigoAux))
                    error=false;
            }
            if(empleado2!=null)
            {
                documentoObjeto=empleado2.getCodigo();
                if(documentoObjeto.equalsIgnoreCase(codigoAux))
                    error=false;
            }
            if(error==true)
                throw new EmpleadoNoEncontradoException("El codigo ingresado no pertenece a ninguno de los"+
                                                        " empleados registrados");

     }
    /**
     * método que toma las identificaciones del cliente, empleado, objeto y los
     * datos necesarios para crear un prestamo
     * @param documento
     * @param codigoAux
     * @param codigoAux2
     * @param codigo
     * @param diasSolicitados
     * @param diasTranscurridos
     * @param valor
     * @param unidadesPrestadas
     * @throws ClienteNoEncontradoException
     * @throws EmpleadoNoEncontradoException
     * @throws SinCupoDetallePrestamo
     * @throws SinCupoPrestamoException
     * @throws ObjetoNoEncontradoException
     * @throws SinCantidadDisponibleException
     * @throws PrestamoNoEncontradoException
     */
	public void inicializarPrestamo(String documentoCliente, String codigoEmpleado, String codigoObjeto, String codigoPrestamo,
									int diasSolicitados, int diasTranscurridos, double valor, int unidadesPrestadas) throws ClienteNoEncontradoException,
											EmpleadoNoEncontradoException, SinCupoPrestamoException, SinCupoDetallePrestamo, ObjetoNoEncontradoException,
											SinCantidadDisponibleException, PrestamoNoEncontradoException {
		Cliente  clienteAux =null;
		Empleado empleadoAux=null;
		Objeto   objetoAux  =null;

		clienteAux=obtenerCliente(documentoCliente);
		empleadoAux=obtenerEmpleado(codigoEmpleado);
		objetoAux=obtenerObjeto(codigoObjeto);

		crearPrestamo(codigoPrestamo,diasSolicitados,diasTranscurridos,valor,unidadesPrestadas,clienteAux,empleadoAux,
				 	 objetoAux);



	}
	private Objeto obtenerObjeto(String codigoObjetoBuscar) throws ObjetoNoEncontradoException {
		Objeto objetoAux=null;
		String codigoObjeto;

		if(objeto1!=null)
		{
			codigoObjeto=objeto1.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{
				objetoAux=objeto1;
				return objetoAux;
			}
		}
		if(objeto2!=null)
		{
			codigoObjeto=objeto2.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{
				objetoAux=objeto2;
				return objetoAux;
			}
		}
		if(objeto3!=null)
		{
			codigoObjeto=objeto3.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{
				objetoAux=objeto3;
				return objetoAux;
			}
		}
		throw new ObjetoNoEncontradoException("El codigo ingresado no coincide con el de ningún "+
												"objeto registrado...");
	}
	/**
	 * étodo que obtiene y retorna un empleado basandose en su código.
	 * si el empleado no es encontrado se genera un EmpleadoNoEncontradoException
	 * @param codigoEmpleado
	 * @return
	 * @throws EmpleadoNoEncontradoException
	 */
	private Empleado obtenerEmpleado(String codigoEmpleadoBuscar) throws EmpleadoNoEncontradoException {
		Empleado empleadoAux=null;
		String codigoEmpleado;

		if(empleado1!=null)
		{
			codigoEmpleado=empleado1.getCodigo();
			if(codigoEmpleado.equalsIgnoreCase(codigoEmpleadoBuscar))
			{
				empleadoAux=empleado1;
				return empleadoAux;
			}
		}
		if(empleado2!=null)
		{
			codigoEmpleado=empleado2.getCodigo();
			if(codigoEmpleado.equalsIgnoreCase(codigoEmpleadoBuscar))
			{
				empleadoAux=empleado2;
				return empleadoAux;
			}
		}
		if(empleado3!=null)
		{
			codigoEmpleado=empleado3.getCodigo();
			if(codigoEmpleado.equalsIgnoreCase(codigoEmpleadoBuscar))
			{
				empleadoAux=empleado3;
				return empleadoAux;
			}
		}
		throw new EmpleadoNoEncontradoException("El documento ingresado no coincide con el de ningún "+
												"cliente registrado...");
	}
	/**
	 * método que obtiene y retorna un cliente basandose en su identificación.
	 * si el cliente no es encontrado se genera un ClienteNoEncontradoException
	 * @param documentoCliente
	 * @return
	 * @throws ClienteNoEncontradoException
	 */
	private Cliente obtenerCliente(String documentoClienteBuscar) throws ClienteNoEncontradoException {
		Cliente clienteAux=null;
		String documentoCliente;

		if(cliente1!=null)
		{
			documentoCliente=cliente1.getDocumento();
			if(documentoCliente.equalsIgnoreCase(documentoClienteBuscar))
			{
				clienteAux=cliente1;
				return clienteAux;
			}
		}
		if(cliente2!=null)
		{
			documentoCliente=cliente2.getDocumento();
			if(documentoCliente.equalsIgnoreCase(documentoClienteBuscar))
			{
				clienteAux=cliente2;
				return clienteAux;
			}
		}
		throw new ClienteNoEncontradoException("El documento ingresado no coincide con el de ningún "+
												"cliente registrado...");
	}
	/**
	 * método que valida si un objeto está o no disponible
	 * basandose en su código
	 * @param codigoAux2
	 * @throws ObjetoNoDisponibleException
	 * @throws ObjetoNoEncontradoException
	 */
	public void validarDisponibilidadObjeto(String codigoObjetoBuscar) throws ObjetoNoDisponibleException, ObjetoNoEncontradoException {
		boolean objetoDisponible=false;
		objetoDisponible=verificarDisponibilidadObjeto(codigoObjetoBuscar);
		if(objetoDisponible==false)
		{
			throw new ObjetoNoDisponibleException("El objeto no posee unidades disponibles...");
		}
	}
	/**
	 * método que verifica si un objeto está o no disponible
	 * usando su código
	 * @param codigoObjetoBuscar
	 * @return
	 * @throws ObjetoNoEncontradoException
	 */
	private boolean verificarDisponibilidadObjeto(String codigoObjetoBuscar) throws ObjetoNoEncontradoException {
		Objeto objetoAux=null;
		String estadoAux;
		boolean objetoDisponible=false;

		objetoAux=obtenerObjeto(codigoObjetoBuscar);
		estadoAux=objetoAux.getEstado();
		if(estadoAux.equalsIgnoreCase("disponible"))
		{
			objetoDisponible=true;
		}
		return objetoDisponible;
	}
	/**
     * Metodo para imprimir la cantidad disponible de un objeto
     * @param codigoObjeto
     * @throws ObjetoNoEncontradoException
     */
    public void imprimirDisponiblidadCantidad(String codigoObjeto) throws ObjetoNoEncontradoException {
        Objeto objetoAux = null;

        objetoAux = obtenerObjeto(codigoObjeto);

        imprimirVentana("Las unidades Disponibles del objeto son: "+objetoAux.getUnidadesDisponibles());
    }
    /**
     * método que imprime el código de los prestamos registrados, el nombre del cliente y del empleado
     */
	public void imprimirPrestamosRegistrados() {
		String mensaje="";
		String codigoPrestamo="";
		String nombreEmpleado="";
		String nombreCliente="";

		int    posicion=1;

		if(prestamo1!=null)
		{
			codigoPrestamo=prestamo1.getCodigo();
			nombreEmpleado=prestamo1.getNombreEmpleado();
			nombreCliente =prestamo1.getNombreCliente();
			mensaje+=posicion+".codido prestamo: "+codigoPrestamo+" empleado: "+nombreEmpleado+" nombreCliente: "
					 +nombreCliente+"\n";
			posicion++;
		}
		if(prestamo2!=null)
		{
			codigoPrestamo=prestamo2.getCodigo();
			nombreEmpleado=prestamo2.getNombreEmpleado();
			nombreCliente =prestamo2.getNombreCliente();
			mensaje+=posicion+".codido prestamo: "+codigoPrestamo+" empleado: "+nombreEmpleado+" nombreCliente: "
					 +nombreCliente+"\n";
			posicion++;
		}
		if(prestamo3!=null)
		{
			codigoPrestamo=prestamo3.getCodigo();
			nombreEmpleado=prestamo3.getNombreEmpleado();
			nombreCliente =prestamo3.getNombreCliente();
			mensaje+=posicion+".codido prestamo: "+codigoPrestamo+" empleado: "+nombreEmpleado+" nombreCliente: "
					 +nombreCliente+"\n";
			posicion++;
		}
		imprimirVentana(mensaje);
	}
	/**
	 * método que valida si un prestamo existe o no, si existe no hace nada, pero si no
	 * existe imprime una exepción
	 * @param codigoPrestamoBuscar
	 * @throws PrestamoNoEncontradoException
	 */
	public void validarPrestamo(String codigoPrestamoBuscar) throws PrestamoNoEncontradoException {
		 String codigoPrestamo;
         boolean error=true;

         if(prestamo1!=null)
         {
        	 codigoPrestamo=prestamo1.getCodigo();
             if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
                 error=false;
         }
         if(prestamo2!=null)
         {
        	 codigoPrestamo=prestamo2.getCodigo();
             if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
                 error=false;
         }
         if(prestamo3!=null)
         {
        	 codigoPrestamo=prestamo3.getCodigo();
             if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
                 error=false;
         }
         if(error==true)
             throw new PrestamoNoEncontradoException("El codigo ingresado no pertenece a ninguno de los"+
                                                     " prestamos registrados");

	}
	/**
	 * método que adiciona un objeto a un prestamo registrado
	 * @param codigoObjeto
	 * @param codigoPrestamo
	 * @param unidadesPrestadas
	 * @throws ObjetoNoEncontradoException
	 * @throws SinCantidadDisponibleException
	 * @throws SinCupoDetallePrestamo
	 * @throws PrestamoNoEncontradoException
	 */
	public void adicionarObjetoPrestamo(String codigoObjeto, String codigoPrestamo, int unidadesPrestadas) throws ObjetoNoEncontradoException
										, SinCantidadDisponibleException, SinCupoDetallePrestamo, PrestamoNoEncontradoException {
		Objeto objetoAux=null;
		objetoAux=obtenerObjeto(codigoObjeto);
		crearOActualizarDetallePrestamo(codigoPrestamo, unidadesPrestadas, objetoAux);

	}
	/**
	 * método para imprimir los datos de un prestamos
	 * @param codigo
	 * @throws PrestamoNoEncontradoException
	 */
	public void imprimirDatosPrestamo(String codigoPrestamo) throws PrestamoNoEncontradoException {
		String mensaje="";
		Prestamo prestamoAux=null;
		prestamoAux=obtenerPrestamo(codigoPrestamo);
		mensaje=prestamoAux.toString();
		imprimirVentana(mensaje);
	}
	public void entregaPrestamo(String codigoPrestamo, int diasTranscurridos) throws PrestamoNoEncontradoException
								, ObjetoNoEncontradoException {
		String mensaje="";

		Objeto objetoAux1=null;
		Objeto objetoAux2=null;

		Prestamo prestamoAux=null;

		int      diasSolicitados;
		int      unidadesPrestadasDetalle1=0;
		int      unidadesPrestadasDetalle2=0;
		int      numeroDetallePrestamo=1;

		String   codigoObjeto1="";
		String   codigoObjeto2="";

		double costo;
		prestamoAux=obtenerPrestamo(codigoPrestamo);

		diasSolicitados=prestamoAux.getDiasSolicitados();

		unidadesPrestadasDetalle1=prestamoAux.getunidadesPrestadasDetalle(numeroDetallePrestamo);
		codigoObjeto1=prestamoAux.obtenerCodigoObjeto(numeroDetallePrestamo);
		numeroDetallePrestamo++;
		unidadesPrestadasDetalle2=prestamoAux.getunidadesPrestadasDetalle(numeroDetallePrestamo);
		codigoObjeto2=prestamoAux.obtenerCodigoObjeto(numeroDetallePrestamo);
		costo=prestamoAux.calcularValor(diasSolicitados, diasTranscurridos);
		setValorPrestamo(codigoPrestamo, costo);
		if(!codigoObjeto1.isEmpty())
		{
			objetoAux1=obtenerObjeto(codigoObjeto1);
			incrementarUnidadesDisponiblesObjeto(objetoAux1,unidadesPrestadasDetalle1);
			codigoObjeto1=objetoAux1.getCodigo();
			objetoAux1=obtenerObjeto(codigoObjeto1);
			setObjetoDetallePrestamo(codigoPrestamo, objetoAux1);


		}
		if(!codigoObjeto2.isEmpty())
		{
			objetoAux2=obtenerObjeto(codigoObjeto2);
			incrementarUnidadesDisponiblesObjeto(objetoAux2,unidadesPrestadasDetalle2);
			codigoObjeto2=objetoAux2.getCodigo();
			objetoAux2=obtenerObjeto(codigoObjeto2);
			prestamoAux.setObjetoDetallePrestamo(objetoAux2);
			setObjetoDetallePrestamo(codigoPrestamo, objetoAux2);
		}

		setDiasTranscurridosPrestamo(codigoPrestamo,diasTranscurridos);
		prestamoAux=obtenerPrestamo(codigoPrestamo);

		costo=prestamoAux.getValor();
		mensaje=prestamoAux.toString();
		imprimirVentana(mensaje);

	}
	/**
	 * método que setea la cantidad de dias transcurridos a un prestamo
	 * @param codigoPrestamo
	 * @param valor
	 */
	private void setDiasTranscurridosPrestamo(String codigoPrestamoBuscar, int diasTranscurridos) {
		String codigoPrestamo="";
		if(prestamo1!=null)
		{
			codigoPrestamo=prestamo1.getCodigo();
			if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
			{
				prestamo1.setDiasTranscurridos(diasTranscurridos);
			}
		}
		if(prestamo2!=null)
		{
			codigoPrestamo=prestamo2.getCodigo();
			if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
			{
				prestamo2.setDiasTranscurridos(diasTranscurridos);
			}
		}
		if(prestamo3!=null)
		{
			codigoPrestamo=prestamo3.getCodigo();
			if(codigoPrestamo.equalsIgnoreCase(codigoPrestamoBuscar))
			{
				prestamo3.setDiasTranscurridos(diasTranscurridos);
			}
		}
	}
	/**
	 * método que aumenta la cantidad de unidades disponibles, tambien
	 * actualiza el estado del objeto
	 * de un objeto en la clase empresa
	 * @param objetoAux
	 * @param unidadesPrestadas
	 */
	private void incrementarUnidadesDisponiblesObjeto(Objeto objetoAux, int unidadesPrestadas) {

		String  estadoAux;

		String  codigoObjetoBuscar;
		String  codigoObjeto;

		int     unidadesDisponibles;
		int     unidadesTotales;

		boolean incrementoCompleto=false;
		codigoObjetoBuscar=objetoAux.getCodigo();

		if(objeto1!=null && incrementoCompleto==false)
		{
			codigoObjeto=objeto1.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{

				unidadesDisponibles=objeto1.getUnidadesDisponibles();
				unidadesTotales=unidadesDisponibles+unidadesPrestadas;
				objeto1.setUnidadesDispobles(unidadesTotales);
				estadoAux=validarEstado(unidadesTotales);
				objeto1.setEstado(estadoAux);
				incrementoCompleto=true;

			}
		}
		if(objeto2!=null && incrementoCompleto==false)
		{
			codigoObjeto=objeto2.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{
				unidadesDisponibles=objeto2.getUnidadesDisponibles();
				unidadesTotales=unidadesDisponibles+unidadesPrestadas;
				objeto2.setUnidadesDispobles(unidadesTotales);
				estadoAux=validarEstado(unidadesTotales);
				objeto2.setEstado(estadoAux);
				incrementoCompleto=true;

			}
		}
		if(objeto3!=null && incrementoCompleto==false)
		{
			codigoObjeto=objeto3.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{
				unidadesDisponibles=objeto3.getUnidadesDisponibles();

				unidadesTotales=unidadesDisponibles+unidadesPrestadas;
				objeto3.setUnidadesDispobles(unidadesTotales);
				estadoAux=validarEstado(unidadesTotales);
				objeto3.setEstado(estadoAux);
				incrementoCompleto=true;

			}
		}

	}
	/**
	 * método que imprime la el nombre y la cantidad de prestamos
	 * de cada empleado registrado
	 * @throws SinEmpleadosRegistradosException
	 */
	public void imprimirCantidadPrestamosEmpleados() throws SinEmpleadosRegistradosException {
		int cantidadPrestamosEmpleado1;
		int cantidadPrestamosEmpleado2;
		int cantidadPrestamosEmpleado3;
		int posicion=1;
		String nombreEmpleado1="";
		String nombreEmpleado2="";
		String nombreEmpleado3="";
		String mensaje="";


		if(empleado1!=null)
		{
			nombreEmpleado1=empleado1.getNombre();
		}
		if(empleado2!=null)
		{
			nombreEmpleado2=empleado2.getNombre();
		}
		if(empleado3!=null)
		{
			nombreEmpleado3=empleado3.getNombre();
		}

		if(!nombreEmpleado1.isEmpty())
		{
			cantidadPrestamosEmpleado1=obtenerCantidadPrestamosEmpleado(nombreEmpleado1);
			mensaje+=posicion+" nombre Empleado: "+nombreEmpleado1+" cantidad de prestamos a los que pertenece :"+
					 cantidadPrestamosEmpleado1+"\n";
			posicion++;
		}
		if(!nombreEmpleado2.isEmpty())
		{
			cantidadPrestamosEmpleado2=obtenerCantidadPrestamosEmpleado(nombreEmpleado2);
			mensaje+=posicion+" nombre Empleado: "+nombreEmpleado2+" cantidad de prestamos a los que pertenece :"+
					 cantidadPrestamosEmpleado2+"\n";
			posicion++;
		}
		if(!nombreEmpleado3.isEmpty())
		{
			cantidadPrestamosEmpleado3=obtenerCantidadPrestamosEmpleado(nombreEmpleado3);
			mensaje+=posicion+" nombre Empleado: "+nombreEmpleado3+" cantidad de prestamos a los que pertenece :"+
					 cantidadPrestamosEmpleado3+"\n";
		}

		if(mensaje.isEmpty())
			throw new SinEmpleadosRegistradosException("No hay empleados registrados...");
		imprimirVentana(mensaje);




	}
	/**
	 * método que obtiene la cantiddad de prestamos a los que pertenece
	 * un empleado
	 * @param nombreEmpleado
	 * @return
	 */
	private int obtenerCantidadPrestamosEmpleado(String nombreEmpleado) {
		int cantidadPrestamos=0;
		boolean pertenecePrestamo=false;
		if(prestamo1!=null)
		{
			pertenecePrestamo=prestamo1.verificarEmpleadoNombre(nombreEmpleado);
			if(pertenecePrestamo==true)
			{
				cantidadPrestamos++;
				pertenecePrestamo=false;
			}
		}
		if(prestamo2!=null)
		{
			pertenecePrestamo=prestamo2.verificarEmpleadoNombre(nombreEmpleado);
			if(pertenecePrestamo==true)
			{
				cantidadPrestamos++;
				pertenecePrestamo=false;
			}
		}
		if(prestamo3!=null)
		{
			pertenecePrestamo=prestamo3.verificarEmpleadoNombre(nombreEmpleado);
			if(pertenecePrestamo==true)
			{
				cantidadPrestamos++;
				pertenecePrestamo=false;
			}
		}
		return cantidadPrestamos;
	}
	public void mostrarDatosEmpleadoMasUnidadesPrestadas() throws SinEmpleadosRegistradosException, SinObjetosPrestadosException {
		int cantidadUnidadesPrestadasEmpleado1=0;
		int cantidadUnidadesPrestadasEmpleado2=0;
		int cantidadUnidadesPrestadasEmpleado3=0;


		String codigoEmpleado1="";
		String codigoEmpleado2="";
		String codigoEmpleado3="";
		String mensaje="";

		Empleado empleadoAux=null;
		if(empleado1==null && empleado2==null && empleado3==null)
			throw new SinEmpleadosRegistradosException("No hay empleados registrados...");

		if(empleado1!=null)
		{
			codigoEmpleado1=empleado1.getCodigo();
		}
		if(empleado2!=null)
		{
			codigoEmpleado2=empleado2.getCodigo();
		}
		if(empleado3!=null)
		{
			codigoEmpleado3=empleado3.getCodigo();
		}

		if(!codigoEmpleado1.isEmpty())
		{
			cantidadUnidadesPrestadasEmpleado1=obtenerCantidadUnidadesPrestadas(codigoEmpleado1);
		}
		if(!codigoEmpleado2.isEmpty())
		{
			cantidadUnidadesPrestadasEmpleado2=obtenerCantidadUnidadesPrestadas(codigoEmpleado2);
		}
		if(!codigoEmpleado3.isEmpty())
		{
			cantidadUnidadesPrestadasEmpleado3=obtenerCantidadUnidadesPrestadas(codigoEmpleado3);
		}

		if(cantidadUnidadesPrestadasEmpleado1==0 && cantidadUnidadesPrestadasEmpleado2==0 && cantidadUnidadesPrestadasEmpleado3==0)
		{
			throw new SinObjetosPrestadosException("Ningún empleado posee objetos prestados");
		}
		else
		{
			empleadoAux=obtenerEmpleadoMasUnidadesPrestadas(cantidadUnidadesPrestadasEmpleado1,cantidadUnidadesPrestadasEmpleado2,
															cantidadUnidadesPrestadasEmpleado3);
			mensaje=empleadoAux.toString();
			imprimirVentana(mensaje);
		}
	}
	/**
	 *
	 * @param cantidadUnidadesPrestadasEmpleado1
	 * @param cantidadUnidadesPrestadasEmpleado2
	 * @param cantidadUnidadesPrestadasEmpleado3
	 * @return
	 */
	private Empleado obtenerEmpleadoMasUnidadesPrestadas(int cantidadUnidadesPrestadasEmpleado1,
			int cantidadUnidadesPrestadasEmpleado2, int cantidadUnidadesPrestadasEmpleado3) {
		Empleado empleadoAux=null;
		if(cantidadUnidadesPrestadasEmpleado1>cantidadUnidadesPrestadasEmpleado2 && cantidadUnidadesPrestadasEmpleado1>cantidadUnidadesPrestadasEmpleado3)
		{
			empleadoAux=empleado1;
			return empleadoAux;
		}
		else
		{
			if(cantidadUnidadesPrestadasEmpleado2>cantidadUnidadesPrestadasEmpleado3)
			{
				empleadoAux=empleado2;
				return empleado2;
			}
			else
			{
				empleadoAux=empleado3;
				return empleadoAux;
			}
		}
	}
	/**
	 * método que obtiene la cantidad de objetos prestados
	 * por un empleado
	 * @param codigoEmpleado
	 * @return cantidadObjetos
	 */
	private int obtenerCantidadUnidadesPrestadas(String codigoEmpleado) {
		int cantidadObjetos=0;
		int numeroDetallePrestamo;
		boolean pertenecePrestamo=false;
		if(prestamo1!=null)
		{
			pertenecePrestamo=prestamo1.verificarEmpleadoCodigo(codigoEmpleado);
			if(pertenecePrestamo==true)
			{
				numeroDetallePrestamo=1;
				cantidadObjetos+=prestamo1.getunidadesPrestadasDetalle(numeroDetallePrestamo);
				numeroDetallePrestamo++;
				cantidadObjetos+=prestamo1.getunidadesPrestadasDetalle(numeroDetallePrestamo);
				pertenecePrestamo=false;
			}
		}
		if(prestamo2!=null)
		{

			pertenecePrestamo=prestamo2.verificarEmpleadoCodigo(codigoEmpleado);
			if(pertenecePrestamo==true)
			{
				numeroDetallePrestamo=1;
				cantidadObjetos+=prestamo2.getunidadesPrestadasDetalle(numeroDetallePrestamo);
				numeroDetallePrestamo++;
				cantidadObjetos+=prestamo2.getunidadesPrestadasDetalle(numeroDetallePrestamo);
				pertenecePrestamo=false;
			}
		}
		if(prestamo3!=null)
		{
			pertenecePrestamo=prestamo3.verificarEmpleadoCodigo(codigoEmpleado);
			if(pertenecePrestamo==true)
			{
				numeroDetallePrestamo=1;
				cantidadObjetos+=prestamo3.getunidadesPrestadasDetalle(numeroDetallePrestamo);
				numeroDetallePrestamo++;
				cantidadObjetos+=prestamo3.getunidadesPrestadasDetalle(numeroDetallePrestamo);
				pertenecePrestamo=false;
			}
		}

		return cantidadObjetos;
	}
	/**
	 * método que imprime el total de dinero con el que
	 * cuenta la empresa
	 * @throws SinPrestamosRegistradosException
	 */
	public void imprimirTotalDineroEmpresa() throws SinPrestamosRegistradosException {
		double totalDinero=0;
		String mensaje="";

		if(prestamo1==null && prestamo2==null && prestamo3==null)
			throw new SinPrestamosRegistradosException("No hay prestamos registrados...");
		if(prestamo1!=null)
		{
			totalDinero+=prestamo1.getValor();
		}
		if(prestamo2!=null)
		{
			totalDinero+=prestamo2.getValor();
		}
		if(prestamo3!=null)
		{
			totalDinero+=prestamo3.getValor();
		}
		mensaje+="El dinero recaudado  de la empresa es :"+totalDinero;
		imprimirVentana(mensaje);
	}
	public void imprimirTotalPagarEmpleados() throws SinEmpleadosRegistradosException, EmpleadoNoEncontradoException {
		double totalPagar=0;
		String codigoEmpleado1="";
		String codigoEmpleado2="";
		String codigoEmpleado3="";
		String mensaje="";

		Empleado empleadoAux=null;
		if(empleado1==null && empleado2==null && empleado3==null)
			throw new SinEmpleadosRegistradosException("No hay empleados a los cuales pagar el sueldo...");

		if(empleado1!=null)
		{
			codigoEmpleado1=empleado1.getCodigo();
		}
		if(empleado2!=null)
		{
			codigoEmpleado2=empleado2.getCodigo();
		}
		if(empleado3!=null)
		{
			codigoEmpleado3=empleado3.getCodigo();
		}

		if(!codigoEmpleado1.isEmpty())
		{
			totalPagar+=obtenerSalarioEmpleado(codigoEmpleado1);
		}
		if(!codigoEmpleado2.isEmpty())
		{
			totalPagar+=obtenerSalarioEmpleado(codigoEmpleado2);
		}
		if(!codigoEmpleado3.isEmpty())
		{
			totalPagar+=obtenerSalarioEmpleado(codigoEmpleado3);
		}
		mensaje+="El total a pagar a los empleados es de :"+totalPagar;
		imprimirVentana(mensaje);
	}
	private double obtenerSalarioEmpleado(String codigoEmpleado) throws EmpleadoNoEncontradoException {
		Empleado empleadoAux=null;
		double salarioEmpleado=0;
		double valorPrestamo=0;
		int    aniosExperiencia=0;
		double bonificacion=0;
		boolean pertenecePrestamo=false;
		empleadoAux=obtenerEmpleado(codigoEmpleado);
		aniosExperiencia=empleadoAux.getAniosExperiencia();

		if(prestamo1!=null)
		{
			pertenecePrestamo=prestamo1.verificarEmpleadoCodigo(codigoEmpleado);
			if(pertenecePrestamo==true)
			{
				valorPrestamo=prestamo1.getValor();
				bonificacion=(valorPrestamo*0.02)*aniosExperiencia;
				salarioEmpleado+=(valorPrestamo*0.2)+bonificacion;
				pertenecePrestamo=false;
			}
		}
		if(prestamo2!=null)
		{
			pertenecePrestamo=prestamo2.verificarEmpleadoCodigo(codigoEmpleado);
			if(pertenecePrestamo==true)
			{
				valorPrestamo=prestamo2.getValor();
				bonificacion=(valorPrestamo*0.02)*aniosExperiencia;
				salarioEmpleado+=(valorPrestamo*0.2)+bonificacion;
				pertenecePrestamo=false;
			}
		}
		if(prestamo3!=null)
		{
			pertenecePrestamo=prestamo3.verificarEmpleadoCodigo(codigoEmpleado);
			if(pertenecePrestamo==true)
			{
				valorPrestamo=prestamo3.getValor();
				bonificacion=(valorPrestamo*0.02)*aniosExperiencia;
				salarioEmpleado+=(valorPrestamo*0.2)+bonificacion;
				pertenecePrestamo=false;
			}
		}


		return salarioEmpleado;
	}
	/**Punto 1
     * Metodo que consulta la informacion del empelado que
     * haya realizado un prestamo de un objeto dado el codigo objeto
     * @param codigoObjeto
	 * @throws SinPrestamosRegistradosException
	 * @throws ObjetoNoEncontradoException
     * @throws EmpleadoNoPrestamo
     */
    public String consultarEmpleadoPrestamoObjeto(String codigoObjeto) throws SinPrestamosRegistradosException, ObjetoNoEncontradoException   {

         // variable para guardar la informacion del empleado
        //  usar el metodo toString() para devolver la informacion del empleado
        String empleado = "";
        Empleado empleadoEncontrado = null;

        if(prestamo1==null && prestamo2==null && prestamo3==null)
        	throw new  SinPrestamosRegistradosException("No hay prestamos registrados...");
        if(prestamo1!=null)
        {
        	empleadoEncontrado=prestamo1.consultarEmpleadoPrestamoObjeto(codigoObjeto);
        	if(empleadoEncontrado!=null)
        	{
        		empleado=empleadoEncontrado.toString();
        		return empleado;
        	}
        }
        if(prestamo2!=null)
        {
        	empleadoEncontrado=prestamo2.consultarEmpleadoPrestamoObjeto(codigoObjeto);
        	if(empleadoEncontrado!=null)
        	{
        		empleado=empleadoEncontrado.toString();
        		return empleado;
        	}
        }
        if(prestamo3!=null)
        {
        	empleadoEncontrado=prestamo3.consultarEmpleadoPrestamoObjeto(codigoObjeto);
        	if(empleadoEncontrado!=null)
        	{
        		empleado=empleadoEncontrado.toString();
        		return empleado;
        	}
        }
        throw new ObjetoNoEncontradoException("El codigo del objeto ingresado no perteenece a ningún prestamo...");
    }





    /** Punto 2
     * Este metodo devuelve el préstamo que contenga la cantidad de unidades prestadas
     *  de  un objeto en un rango mayor igual a 5 unidades y menor
     *   a 15 unidades realizado por un empleado con anios experiencia mayor igual a 2.
     * @return prestamo que cumpla con las condiciones
     */
    public Prestamo devolverPrestamoEmpleadoRango(){

        Prestamo prestamo = null;
        boolean  prestamoEncontrado=false;

        if(prestamo1!=null)
        {
        	prestamoEncontrado=prestamo1.verificarPrestamoEmpleadoRango();
        	if(prestamoEncontrado==true)
        	{
        		prestamo=prestamo1;
            	return prestamo;
        	}

        }
        if(prestamo2!=null)
        {
        	prestamoEncontrado=prestamo2.verificarPrestamoEmpleadoRango();
        	if(prestamoEncontrado==true)
        	{
        		prestamo=prestamo2;
            	return prestamo;
        	}

        }
        if(prestamo3!=null)
        {
        	prestamoEncontrado=prestamo3.verificarPrestamoEmpleadoRango();
        	if(prestamoEncontrado==true)
        	{
        		prestamo=prestamo3;
            	return prestamo;
        	}

        }
        return prestamo;
    }

    //    punto 3a.    Consultar cual es el tipo de objeto que ha sido prestado
    //    más veces en la empresa, según sus unidades prestadas.
   /**
    * Este metodo consulta las unidades prestadas total
    * de un tipo de objeto en todos los prestamo de la empresa
    * y luego compara cual es mayor y retorna el tipo al cual sea mayor.
    * @return
    */
   public TipoObjeto consultarTipoObjetoMasPrestado(){
	   TipoObjeto tipoMayor = null;

       int unidadesPrestadasTipoElectrodomesticos=0;
       int unidadesPrestadasTipoMuebles=0;
       int unidadesPrestadasTipoConstruccion=0;


       if(prestamo1!=null)
       {
    	   unidadesPrestadasTipoElectrodomesticos+=prestamo1.consultarUnidadesPrestadas(TipoObjeto.ELECTRODOMESTICOS);
    	   unidadesPrestadasTipoMuebles+=prestamo1.consultarUnidadesPrestadas(TipoObjeto.MUEBLES);
    	   unidadesPrestadasTipoConstruccion+=prestamo1.consultarUnidadesPrestadas(TipoObjeto.CONSTRUCCION);
       }
       if(prestamo2!=null)
       {
    	   unidadesPrestadasTipoElectrodomesticos+=prestamo2.consultarUnidadesPrestadas(TipoObjeto.ELECTRODOMESTICOS);
    	   unidadesPrestadasTipoMuebles+=prestamo2.consultarUnidadesPrestadas(TipoObjeto.MUEBLES);
    	   unidadesPrestadasTipoConstruccion+=prestamo2.consultarUnidadesPrestadas(TipoObjeto.CONSTRUCCION);
       }
       if(prestamo3!=null)
       {
    	   unidadesPrestadasTipoElectrodomesticos+=prestamo3.consultarUnidadesPrestadas(TipoObjeto.ELECTRODOMESTICOS);
    	   unidadesPrestadasTipoMuebles+=prestamo3.consultarUnidadesPrestadas(TipoObjeto.MUEBLES);
    	   unidadesPrestadasTipoConstruccion+=prestamo3.consultarUnidadesPrestadas(TipoObjeto.CONSTRUCCION);
       }




       if(unidadesPrestadasTipoElectrodomesticos>=unidadesPrestadasTipoMuebles && unidadesPrestadasTipoElectrodomesticos>=unidadesPrestadasTipoConstruccion)
       {
    	   tipoMayor=TipoObjeto.ELECTRODOMESTICOS;
    	   return tipoMayor;
       }
       else
       {
    	   if(unidadesPrestadasTipoMuebles>=unidadesPrestadasTipoConstruccion)
    	   {
    		   tipoMayor=TipoObjeto.MUEBLES;
    		   return tipoMayor;
    	   }
    	   else
    	   {
    		   tipoMayor=TipoObjeto.CONSTRUCCION;
    		   return tipoMayor;
    	   }
       }
   }
 //punto 3.b segundo metodo
   /**
    * Este metodo consulta en los prestamos cual es
    * la cantidad total de unidades prestadas de un objeto por el tipo de objeto
    * @param tipoObjeto : es el tipo de objeto para consultar las unidades del prestamo
    * @return
    */

   public int consultarNumeroUnidadesPrestadas(TipoObjeto tipoObjeto){

       int unidadesPrestadasTotal = 0;
       if(prestamo1!=null)
       {
    	   unidadesPrestadasTotal=prestamo1.consultarUnidadesPrestadas(tipoObjeto);
       }
       if(prestamo2!=null)
       {
    	   unidadesPrestadasTotal=prestamo1.consultarUnidadesPrestadas(tipoObjeto);
       }
       if(prestamo3!=null)
       {
    	   unidadesPrestadasTotal=prestamo1.consultarUnidadesPrestadas(tipoObjeto);
       }

       return unidadesPrestadasTotal;
   }


// punto 4
 /**
  *     Devolver los objetos que han sido prestados por un cliente
  * dado su numero de documento y la ciudad de residencia
  * y el prestamo tenga un valor de préstamo entre 10000 y 200000. (1.0)
  */

 public String devolverObjetosPrestamoCliente(String documentoCliente, String ciudadCliente){

     String objetos = "";

     double valorPrestamo=0;

     boolean clienteCorrecto=false;
     boolean prestamoCorrecto=false;

     if(prestamo1!=null)
     {
    	 clienteCorrecto=prestamo1.verificarCliente(documentoCliente, ciudadCliente);
    	if(clienteCorrecto==true)
    	{
    		valorPrestamo=prestamo1.getValor();
    		prestamoCorrecto=prestamo1.verificarValorPrestamoRango(valorPrestamo);
    		if(prestamoCorrecto==true)
    		{
    			objetos=prestamo1.obtenerObjetosPrestados();
    			return objetos;
    		}
    	}
     }

     if(prestamo2!=null)
     {
    	 clienteCorrecto=prestamo2.verificarCliente(documentoCliente, ciudadCliente);
    	if(clienteCorrecto==true)
    	{
    		valorPrestamo=prestamo2.getValor();
    		prestamoCorrecto=prestamo2.verificarValorPrestamoRango(valorPrestamo);
    		if(prestamoCorrecto==true)
    		{
    			objetos=prestamo2.obtenerObjetosPrestados();
    			return objetos;
    		}
    	}
     }
     if(prestamo3!=null)
     {
    	 clienteCorrecto=prestamo3.verificarCliente(documentoCliente, ciudadCliente);
    	if(clienteCorrecto==true)
    	{
    		valorPrestamo=prestamo3.getValor();
    		prestamoCorrecto=prestamo3.verificarValorPrestamoRango(valorPrestamo);
    		if(prestamoCorrecto==true)
    		{
    			objetos=prestamo3.obtenerObjetosPrestados();
    			return objetos;
    		}
    	}
     }

     return objetos;
 }

/**
 * método que retorna el toString de un empleado usando su código
 * si el empleado no es encontrado se genera la excepción
 * EmpleadoNoEncontradoException
 * @param codigo
 * @throws EmpleadoNoEncontradoException
 */
public void mostrarEmpleado(String documento) throws EmpleadoNoEncontradoException {

	int posicion;

	String datosEmpleado="";
	Empleado empleadoAux=null;
	posicion=obtenerPosicionEmpleado(documento);

	if(posicion!=-1)
	{
		datosEmpleado+=listaEmpleados.get(posicion).toString();
		imprimirVentana(datosEmpleado);
	}
	else
	{
		throw new EmpleadoNoEncontradoException("El empleado no ha sido encontrado...");
	}
}
/**
 * método que actualiza los datos de un empleado, el método
 * encuantra al empleado usando el códigoAux.
 * Si el empleado a actualizar no es encontrado, se genera
 * un EmpleadoNoEncontradoException
 * @param codigoAux
 * @param nombre2
 * @param codigo
 * @param correo
 * @param aniosExperiencia
 * @throws EmpleadoNoEncontradoException
 */
public void actualizarEmpleado(String codigoAux, String nombre, String codigo, String correo,
		String aniosExperiencia) throws EmpleadoNoEncontradoException {
	int posicion;
	Empleado empleadoAux=null;
	posicion=obtenerPosicionEmpleado(codigoAux);

	if(posicion!=-1)
	{
		empleadoAux= new Empleado(nombre,codigo,correo,aniosExperiencia);
		listaEmpleados[posicion]=empleadoAux;
		imprimirVentana("El empleado "+listaEmpleados[posicion].getNombre()+
				" ha sido actualizado con exito.");
	}
	else
	{
		throw new EmpleadoNoEncontradoException("El empleado no ha sido encontrado...");
	}

}
/**
 * método que elimina un empleado, se busca al empleado usando el
 * codigo ingresado como parametro, si el empleado no es encontrado
 * se genera un EmpleadoNoEncontradoException
 * @param codigo
 * @throws EmpleadoNoEncontradoException
 */
public void eliminarEmpleado(String codigo) throws EmpleadoNoEncontradoException {
	int posicion;
	Empleado empleadoAux=null;
	posicion=obtenerPosicionEmpleado(codigo);

	if(posicion!=-1)
	{
		listaEmpleados[posicion]=null;
		imprimirVentana("El empleado con el código :"+codigo+
				" ha sido eliminado con exito.");
	}
	else
	{
		throw new EmpleadoNoEncontradoException("El empleado no ha sido encontrado...");
	}

}

/**
 * método que retorna el toString de un cliente usando su documento
 * si el cliente no es encontrado se genera la excepción
 * ClienteNoEncontradoException
 * @param documento
 * @throws ClienteNoEncontradoException
 */
public void mostrarCliente(String documento) throws ClienteNoEncontradoException {
	int posicion;

	String datosCliente="";
	Cliente clienteAux=null;
	posicion=obtenerPosicionCliente(documento);

	if(posicion!=-1)
	{
		datosCliente+=listaClientes.get(posicion).toString();
		imprimirVentana(datosCliente);
	}
	else
	{
		throw new ClienteNoEncontradoException("El cliente no ha sido encontrado...");
	}

}
/**
 * método que actualiza los datos de un cliente, el método
 * encuentra al cliente usando el códigoAux.
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
 * @throws ClienteNoEncontradoException
 */
public void actualizarCliente(String documento, String telResidencia, String telCelular, String nombre, String genero,
		String ciudadResidencia, String departamento, String pais, String profesion, String correo,
		int tipoDocumento,String direccion) throws ClienteNoEncontradoException {
	int posicion;
	Cliente clienteAux=null;
	posicion=obtenerPosicionCliente(documento);

	if(posicion!=-1)
	{
		clienteAux= new Cliente(documento,telResidencia, telCelular, nombre, genero, ciudadResidencia,
				departamento,  pais,  profesion,  correo, tipoDocumento,direccion);
		listaClientes.set(posicion, clienteAux);
		imprimirVentana("El cliente "+listaClientes.get(posicion).getNombre()+
				" ha sido actualizado con exito.");
	}
	else
	{
		throw new ClienteNoEncontradoException("El cliente no ha sido encontrado...");
	}

}
/**
 * método que elimina un empleado, se busca al empleado usando el
 * codigo ingresado como parametro, si el empleado no es encontrado
 * se genera un EmpleadoNoEncontradoException
 * @param documento
 * @throws ClienteNoEncontradoException
 */
public void eliminarCliente(String documento) throws ClienteNoEncontradoException {
	int posicion;
	Cliente clienteAux=null;
	posicion=obtenerPosicionCliente(documento);

	if(posicion!=-1)
	{
		listaClientes.remove(posicion);
		imprimirVentana("El cliente con el documento :"+documento+
				" ha sido eliminado con exito.");
	}
	else
	{
		throw new ClienteNoEncontradoException("El cliente no ha sido encontrado...");
	}

}

public String obtenerObjetosPrestadosPrecioMayor(double precioMayor)
{
	String objetosPrestados="";
	String auxiliar="";
	for(int i=0;i<listaPrestamos.length;i++)
	{
		if(listaPrestamos!=null)
		{
			auxiliar=listaPrestamos[i].obtenerObjetosPrestadosPrecioMayor(precioMayor);
			if(!auxiliar.isEmpty())
			{
				objetosPrestados+=auxiliar;
			}
		}
	}
	return objetosPrestados;
}
/**
 * método que calcula la cantidad de unidades prestadas de un prestamo,
 *
 * @param codigo
 * @return cantidadUnidadesPrestadas
 * @throws PrestamoNoEncontradoException
 * @throws SinObjetosPrestadosException
 */
public int retornarCantidadUnidadesPrestadas(String codigo) throws PrestamoNoEncontradoException, SinObjetosPrestadosException
{
	int cantidadUnidadesPrestadas=0;
	Prestamo prestamoAux=null;
	prestamoAux=obtenerPrestamo(codigo);
	cantidadUnidadesPrestadas=prestamoAux.obtenerCantidadUnidadesPrestadas();
	if(cantidadUnidadesPrestadas==0)
	{
		throw new SinObjetosPrestadosException("El prestamo no posee objetos prestados...");
	}


return cantidadUnidadesPrestadas;
}


public void verificarClienteRegistrado(String documento) throws ClienteExisteException {
	int posicion=-1;
	posicion=obtenerPosicionCliente(documento);
	if(posicion!=-1)
	{
		throw new ClienteExisteException("El empleado con la identificación "+documento
					                          +" ya existe en la posicion :"+ ++posicion);
	}
}
}