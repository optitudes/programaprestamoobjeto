package co.edu.uniquindio.programaprestamoobjeto.model;
import java.lang.reflect.Array;
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
	public void crearObjeto(String nombre, String codigo, String descripción, String color,String estado,
			int unidadesDisponibles, double valorUnitario, double peso, double valorAlquiler, int tipoObjeto) {

		 Objeto  objetoAux;
		 int     posicion;
		 objetoAux=new Objeto(nombre, codigo, descripción, color, estado, unidadesDisponibles, valorUnitario, peso, tipoObjeto);
		 listaObjetos.add(objetoAux);
		 posicion=listaObjetos.size()-1;
		 imprimirVentana("Objeto :"+listaObjetos.get(posicion).getNombre()+" creado con éxito");
	}
	/**
	 * Metodo que consulta los datos de un objeto mediante el codigo se invoca verificarCodigo(codigo)
	 * para ver si coinside con el codigo de cada objeto
	 * @param codigo
	 * @throws ObjetoNoEncontradoException
	 */
	public void consultarDatosObjeto (String codigo) throws ObjetoNoEncontradoException{
		boolean objetoEncontrado=false;
		Objeto objetoAux;
		
		for(int i=0;i<listaObjetos.size() && !objetoEncontrado;i++)
		{
			objetoAux=listaObjetos.get(i);
			if(objetoAux!=null)
			{
				if(objetoAux.verificarCodigo(codigo))
				{
					imprimirVentana(objetoAux.toString());
					objetoEncontrado=true;
				}
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
			for(Prestamo prestamoAux: listaPrestamos)
			{
				pertenecePrestamo=prestamoAux.verificarPertenciaPrestamo(nombre);
				if(pertenecePrestamo==true)
					cantidadDePrestamos++;
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
		
		for(Objeto objetoAux: listaObjetos)
		{
			existeObjeto=objetoAux.verificarExistencia(codigoObjetoBuscar);
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
		
		for(Objeto objetoAux: listaObjetos)
		{
			existeObjeto=objetoAux.verificarExistenciaNombre(nombreObjetoBuscar);
			if(existeObjeto==true)
				return existeObjeto;
		}
		return existeObjeto;
	}
	
	/**
	 * método que genera un string con el nombre del objeto y
	 * la cantidad total de unidades prestadas del mismo
	 * @param nombreObjeto1
	 * @param totalObjeto1
	 * @return resultado
	 */
	private String generarMensajeUnidadesPrestadas(String nombreObjeto, int totalObjeto) {
		String resultado="\n-> ";
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
		if(listaObjetos.size()==0)
			throw new SinObjetosRegistradosException("No hay objetos registrados.");
		for(Objeto objetoAux: listaObjetos)
		{
			mensaje+=posicion+". nombre :"+objetoAux.getNombre()+" codigo :"+objetoAux.getCodigo()+"\n";
			posicion++;
		}
		imprimirVentana(mensaje);
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
	public void actualizarObjeto(String codigoAux,String nombre, String codigo, String descripción, String color,String estado,
			int unidadesDisponibles, double valorUnitario, double peso, double valorAlquiler, int tipoObjeto) throws ObjetoNoEncontradoException {
		
		String codigoObjeto;
		Objeto objetoAux;
		boolean actualizacionExitosa=false;
		
		for(int i=0;i<listaObjetos.size() && !actualizacionExitosa;i++)
		{
			codigoObjeto=listaObjetos.get(i).getCodigo();
			if(codigoObjeto.equals(codigoAux))
			{
				if(!verificarExitenciaObjeto(codigo))
				{
					objetoAux= new Objeto(nombre, codigoObjeto, descripción, color, estado, unidadesDisponibles, valorUnitario, peso, tipoObjeto); 
					listaObjetos.set(i, objetoAux);
					imprimirVentana(listaObjetos.get(i).toString()+"\n"
						 	        + "¡Actualización exitosa!");
					actualizacionExitosa=true;
				}
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

	public void crearPrestamo(String codigoPrestamo,int diasSolicitados,int diasTranscurridos,double valor,
							 int unidadesPrestadas,Cliente clienteAux, Empleado empleadoAux,
							 Objeto objetoAux)throws ObjetoNoEncontradoException, PrestamoNoEncontradoException
	{
		Prestamo prestamoAux;
		String codigoObjeto;
		String codigoPrestamoaUX;
		boolean error = true;

		prestamoAux= new Prestamo(codigoPrestamo, null, null, valor, valor, clienteAux, empleadoAux);
		listaPrestamos.add(prestamoAux);
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
										 PrestamoNoEncontradoException {
		Prestamo prestamoAux=null;
		int      diasSolicitados;
		int      diasTranscurridos;
		int      unidadesDisponibles;
		double   valor;
		String   codigoObjeto;
			int posicion;
			posicion=obtenerPosicionPrestamo(codigoPrestamo);
			if(posicion==-1)
			{
				empleadoAux= new Empleado(aniosExperiencia, nombre, aniosExperiencia, aniosExperiencia,
						codigoAux, nombre, codigo, aniosExperiencia, correo, posicion, posicion);
				listaEmpleados.set(posicion, empleadoAux);
				imprimirVentana("El empleado "+listaEmpleados.get(posicion).getNombre()+
						" ha sido actualizado con exito.");
			}
			else
			{
				throw new EmpleadoNoEncontradoException("El empleado no ha sido encontrado...");
			}

}
		prestamoAux=obtenerPrestamo(codigoPrestamo);
		valor=prestamoAux.getValor();
		unidadesDisponibles=objetoAux.getUnidadesDisponibles();


		if(unidadesDisponibles>=unidadesPrestadas==true)
		{
			prestamoAux.crearOActualizarDetallePrestamo(unidadesPrestadas,valor,objetoAux);
			prestamoAux.actualizarValorPrestamo();
			reducirUnidadesDisponiblesObjeto(objetoAux,unidadesPrestadas);
			codigoObjeto=objetoAux.getCodigo();
			objetoAux=obtenerObjeto(codigoObjeto);
			setObjetoDetallePrestamo(codigoPrestamo,objetoAux);
			
			imprimirVentana("Prestamo :"+prestamoAux.getCodigo()+" creado o actualizado con éxito");
		}
		else
		{
			throw new SinCantidadDisponibleException("La cantidad del objeto solicitada"
					+" exede la existente, por tanto se "
					+"ha negado la operacion...");
		}
		return prestamoAux;
	}
	private void setObjetoDetallePrestamo(String codigoPrestamoBuscar, Objeto objetoAux) throws PrestamoNoEncontradoException {
		boolean seteoCompleto=false;
		String codigoPrestamo="";
		for(int i=0;i<listaPrestamos.size() && !seteoCompleto;i++)
		{
			codigoPrestamo=listaPrestamos.get(i).getCodigo();
			if(codigoPrestamo.equals(codigoPrestamoBuscar))
			{
				listaPrestamos.get(i).setObjetoDetallePrestamo(objetoAux);
				imprimirVentana("El objeto se ha seteado con exito!");
				seteoCompleto=true;
			}
		}
		if(seteoCompleto==false)
			throw new PrestamoNoEncontradoException("el código no pertenece a ningún"
													+ " prestamo registrado... ");
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
	 * @throws SinCantidadDisponibleException 
	 */
	private void reducirUnidadesDisponiblesObjeto(Objeto objetoAux, int unidadesPrestadas) throws SinCantidadDisponibleException {

		boolean estadoAux;

		String  codigoObjetoBuscar;
		String  codigoObjeto;

		int     unidadesDisponibles;
		int     unidadesTotales;

		boolean reduccionCompleta=false;
		boolean objetoEncontrado=false;
		codigoObjetoBuscar=objetoAux.getCodigo();
		
		for(int i=0;i<listaObjetos.size() && !objetoEncontrado;i++)
		{
			codigoObjeto=listaObjetos.get(i).getCodigo();
			if(codigoObjeto.equals(codigoObjetoBuscar))
			{
				unidadesDisponibles=listaObjetos.get(i).getUnidadesDisponibles();
				if(unidadesDisponibles>=unidadesPrestadas)
				{
					unidadesTotales=unidadesDisponibles-unidadesPrestadas;
					listaObjetos.get(i).setUnidadesDisponibles(unidadesTotales);
					estadoAux=validarEstado(unidadesTotales);
					listaObjetos.get(i).setEstado(estadoAux);
					reduccionCompleta=true;
				}
				objetoEncontrado=true;
			}
		}
		
		if(reduccionCompleta==false)
			throw new SinCantidadDisponibleException("El objeto no tiene suficientes unidades"
										  + " para prestar o reducir.");
	
	}
	/**
	 * método que valida el estado de un objeto, si es mayor
	 * a cero retorna "disponible" sino retorna "no diponible"
	 * @param unidadesTotales
	 * @return
	 */
	private boolean validarEstado(int unidadesTotales) {
		boolean resultado;
		if(unidadesTotales>0)
		{
			resultado=true;
		}
		else
		{
			resultado=false;
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
	 * sea igual al documento de algún cliente registrado, si el 
	 * cliente está registrado este metodo no hace nada, pero si
	 * no está registrado genera una exepcion 
	 * @param documentoAux
	 * @throws ClienteNoEncontradoException
	 */
	public void validarCliente(String documentoAux) throws ClienteNoEncontradoException {

		Cliente clienteAux;

		String documentoCliente;
		boolean error=true;

		for(int i=0;i<listaClientes.size() && error;i++)
		{
			clienteAux=listaClientes.get(i);
			documentoCliente=clienteAux.getDocumento();
			if(documentoCliente.equals(documentoAux))
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
    public void validarEmpleado(String documentoAux) throws EmpleadoNoEncontradoException
    {
    	String documentoEmpleado;
    	boolean error=true;

    	Empleado empleadoAux;

    	for(int i=0;i<listaEmpleados.size() && error;i++)
    	{
    		empleadoAux=listaEmpleados.get(i);
			documentoEmpleado=empleadoAux.getDocumento();
			if(documentoEmpleado.equals(documentoAux))
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
											EmpleadoNoEncontradoException,ObjetoNoEncontradoException,
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
	 * método que obtiene y retorna un empleado basandose en su documento
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
	 * método que obtiene y retorna un cliente basandose en su identificación.
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
		boolean estadoAux;

		objetoAux=obtenerObjeto(codigoObjetoBuscar);
		estadoAux=objetoAux.isEstado();
		return estadoAux;
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
		
		for(Prestamo prestamoAux:listaPrestamos)
		{
			codigoPrestamo=prestamoAux.getCodigo();
			nombreEmpleado=prestamoAux.getNombreEmpleado();
			nombreCliente =prestamoAux.getNombreCliente();
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

         for(Prestamo prestamoAux:listaPrestamos)
         {
        	 codigoPrestamo=prestamoAux.getCodigo();
             if(codigoPrestamo.equals(codigoPrestamoBuscar))
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
										, SinCantidadDisponibleException, PrestamoNoEncontradoException {
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

		boolean estadoAux;

		String  codigoObjetoBuscar;
		String  codigoObjeto;

		Objeto objetoAux2;

		int     unidadesDisponibles;
		int     unidadesTotales;

		boolean incrementoCompleto=false;
		codigoObjetoBuscar=objetoAux.getCodigo();
		
		for(int i=0;i<listaObjetos.size() && incrementoCompleto==false;i++)
		{
			objetoAux2=listaObjetos.get(i);
			codigoObjeto=objetoAux2.getCodigo();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{

				unidadesDisponibles=objetoAux2.getUnidadesDisponibles();
				unidadesTotales=unidadesDisponibles+unidadesPrestadas;
				objetoAux2.setUnidadesDisponibles(unidadesTotales);
				estadoAux=validarEstado(unidadesTotales);
				objetoAux2.setEstado(estadoAux);
				listaObjetos.set(i, objetoAux2);
				incrementoCompleto=true;
		}
		}

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
 * encuentra al empleado usando el códigoAux.
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
		empleadoAux= new Empleado(aniosExperiencia, nombre, aniosExperiencia, aniosExperiencia,
				                  codigoAux, nombre, codigo, aniosExperiencia, correo, posicion, posicion);
		listaEmpleados.set(posicion, empleadoAux);
		imprimirVentana("El empleado "+listaEmpleados.get(posicion).getNombre()+
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
		listaEmpleados.remove(posicion);
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