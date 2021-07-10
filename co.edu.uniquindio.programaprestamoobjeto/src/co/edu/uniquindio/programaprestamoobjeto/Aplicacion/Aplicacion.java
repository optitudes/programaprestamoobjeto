package co.edu.uniquindio.programaprestamoobjeto.Aplicacion;

import java.util.Scanner;

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
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinCupoObjetoException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinCupoPrestamoException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinEmpleadosRegistradosException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinObjetosPrestadosException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinObjetosRegistradosException;
import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinPrestamosRegistradosException;
import co.edu.uniquindio.programaprestamoobjeto.model.Empresa;
import co.edu.uniquindio.programaprestamoobjeto.model.Prestamo;
import co.edu.uniquindio.programaprestamoobjeto.model.TipoObjeto;

public class Aplicacion {

	public static void main(String[] args) {

		Empresa empresa=new Empresa("Le empresé","1221");
		Prestamo   prestamoAux=null;
		TipoObjeto tipoObjetoAux=null;

		String documento;
		String nombre;
		String genero;
		String codigo;
		String codigoAux;
		String codigoAux2;
		String estado;
		String ciudadResidencia;
		String correo;
		String mensaje="";
		String aniosExperiencia;

		double precioAlquiler;
		double valor;

		int    unidadesDisponibles;
		int    diasTranscurridos;
		int    diasSolicitados;
		int    unidadesPrestadas;
		int    tipoDocumento;
		int    tipoObjeto;
		int    opcion,opcion1,opcion2,cantidadObjetosRegistrados;
		int    tamanioArreglos;

		boolean clienteEncontrado;
		boolean empleadoEncontrado;
		boolean objetoEncontrado;



		do{
			mostrarMenu();
			opcion = leerEntero("Elija la opcion:");
			try {
				switch(opcion){
				case 1 :
					do {
					mostrarMenuEmpleados();
					opcion1 = leerEntero("Elija la opcion:");
					switch(opcion1)
					{
						case 1:
							empresa=crearEmpleado(empresa);
							break;
						case 2:
							mostrarEmpleado(empresa);
							break;
						case 3:
							empresa.imprimirEmpleadosRegistrados();
							codigoAux=leerString("Ingrese el código del empleado a actualizar :");
							nombre = leerString("Ingrese el nuevo nombre del empleado: ");
							codigo = leerString("Ingrese el  nuevo codigo del empleado: ");
							correo = leerString("Ingrese el  nuevo correo del empleado: ");
							aniosExperiencia = leerString("Ingrese los  nuevos años de experiencia: ");
							empresa.actualizarEmpleado(codigoAux,nombre,codigo,correo,aniosExperiencia);
							break;
						case 4:
							empresa.imprimirEmpleadosRegistrados();

							codigo=leerString("Ingrese el código del empleado a eliminar :");
							empresa.eliminarEmpleado(codigo);
							break;
					}


					}while(opcion1!=5);
					break;
				case 2:
					do {
						mostrarMenuClientes();
						opcion1 = leerEntero("Elija la opcion:");
						switch(opcion1)
						{
							case 1:
								empresa=crearCliente(empresa);
								break;
							case 2:
								mostrarCliente(empresa);

								break;
							case 3:
								empresa=actualizarClienteRegistrado(empresa);

								break;
							case 4:
								empresa=eliminarCliente(empresa);
								break;
						}
						}while(opcion1!=5);
						break;

				case 3:
					do{
						mostrarMenuCase3();
						opcion1 = leerEntero("Elija la opcion:");

						switch(opcion1){
						case 1:
							nombre=leerString("Ingrese el nombre del objeto a crear :");
							codigo=leerString("Ingrese el código del objeto a crear :");
							unidadesDisponibles=validarNumeroNatural("Ingrese la cantidad de unidades disponibles :");
							estado=validarEstadoObjeto("Ingrese el estado del objeto \n1. Disponible\n2. No disponible\n--->:");
							precioAlquiler=validarPrecio("Ingrese el precio del alquiler  :");
							tipoObjeto=validarEntradaEntero(1, 3, "Ingrese el tipo de objeto"+
									"\n1: Electrodomestico.\n2: Muebles.\n3: Construccion ");
							empresa.crearObjeto(nombre,codigo,unidadesDisponibles,estado,precioAlquiler,tipoObjeto);

							break;
						case 2:
	                        empresa.imprimirObjetosDisponibles();
							codigo=leerString("Ingrese el código del objeto :");
							empresa.consultarDatosObjeto(codigo);
							break;
						case 3:
	                        empresa.imprimirObjetosDisponibles();

							nombre=leerString("Ingrese el nombre del objeto al que desea hallar la "+
											  "cantidad de prestamos en el que está incluido :");
							empresa.calcularCantidadPrestamos(nombre);
							break;
						case 4:
							empresa.imprimirTotalUnidadesPrestadasPorObjeto();
							break;
						case 5:
							empresa.imprimirObjetosDisponibles();
							codigoAux=leerString("Ingrese el código del objeto a actualizar :");
							nombre=leerString("Ingrese el nuevo nombre para el objeto :");
							codigo=leerString("Ingrese el nuevo código para el objeto :");
							unidadesDisponibles=validarNumeroNatural("Ingrese la  nueva cantidad de unidades disponibles :");
							estado=validarEstadoObjeto("Ingrese el estado del objeto \n1. Disponible\n2. No disponible\n--->:");
							tipoObjeto=validarEntradaEntero(1, 3, "Ingrese el tipo de objeto"+
									"\n1: Electrodomestico.\n2: Muebles.\n3: Construccion ");
							precioAlquiler=validarPrecio("Ingrese el precio del alquiler  :");
							empresa.actualizarObjeto(nombre,codigo,unidadesDisponibles,estado,precioAlquiler,codigoAux,tipoObjeto);
							break;
						}

					}while (opcion1 != 6);
					break;
				case 4:
					do{
						mostrarMenuCase4();
						opcion1 = leerEntero("Elija la opcion:");
						switch(opcion1){
						case 1:
							diasTranscurridos = 0;
	                        valor =0;
	                        empresa.imprimirClientesRegistrados();
	                        documento=leerString("Ingrese el código del cliente que solicitará el prestamo :");
	                        empresa.validarCliente(documento);
	                        empresa.imprimirEmpleadosRegistrados();
	                        codigoAux=leerString("Ingrese el código del empleado que realizará el prestamo :");
	                        empresa.validarEmpleado(codigoAux);
	                        empresa.imprimirObjetosDisponibles();
	                        codigoAux2=leerString("Ingrese el código del objeto del cual solicitará prestamo :");
	                        empresa.validarExistenciaObjeto(codigoAux2);
	                        empresa.validarDisponibilidadObjeto(codigoAux2);
	                        codigo = leerString("Ingrese el codigo del prestamo: ");
	                        diasSolicitados = leerEntero("Ingrese los dias que desea solicitar el prestamo: ");
	                        empresa.imprimirDisponiblidadCantidad(codigoAux2);
	                        unidadesPrestadas = validarNumeroNatural("Ingrese la cantidad del objeto: ");
	                        empresa.inicializarPrestamo(documento,codigoAux,codigoAux2,codigo, diasSolicitados, diasTranscurridos, valor,
	                        					  unidadesPrestadas);
							break;
						case 2:
							empresa.imprimirObjetosDisponibles();
							codigo=leerString("Ingrese el código del objeto del cual adicionará el prestamo  :");
	                        empresa.validarExistenciaObjeto(codigo);
	                        empresa.validarDisponibilidadObjeto(codigo);
	                        empresa.imprimirPrestamosRegistrados();
	                        codigoAux=leerString("Ingrese el codigo del prestamo al cual desea adicionar un objeto :");
	                        empresa.validarPrestamo(codigoAux);
	                        empresa.imprimirDisponiblidadCantidad(codigo);
	                        unidadesPrestadas=validarNumeroNatural("Ingrese la cantidad del ojeto a adicionar al prestamo :");
	                        empresa.adicionarObjetoPrestamo(codigo,codigoAux,unidadesPrestadas);

							break;
						case 3:
							empresa.imprimirPrestamosRegistrados();
	                        codigo=leerString("Ingrese el codigo del prestamo que desea entregar :");
	                        empresa.validarPrestamo(codigo);
	                        diasTranscurridos=validarNumeroNatural("Ingrese la cantidad de dias transcurridos :");
	                        empresa.entregaPrestamo(codigo,diasTranscurridos);

							break;
						case 4:
							empresa.imprimirPrestamosRegistrados();
	                        codigo=leerString("Ingrese el codigo del prestamo al cual desea adicionar un objeto :");
	                        empresa.validarPrestamo(codigo);
	                        empresa.imprimirDatosPrestamo(codigo);
							break;
						case 5:
	                        empresa.imprimirCantidadPrestamosEmpleados();
							break;
						}
					}while (opcion1 != 6);
					break;
				case 5:
					do{
						mostrarMenuCase5();

						opcion1 = leerEntero("Elija la opcion:");
						switch(opcion1){
						case 1:
							empresa.mostrarDatosEmpleadoMasUnidadesPrestadas();
							break;
						case 2:
							empresa.imprimirTotalDineroEmpresa();
							break;
						case 3:
							empresa.imprimirTotalPagarEmpleados();
							break;

						}
					}while (opcion1 != 4);
					break;
				case 6:
					do{
						mostrarMenuCase6();

						opcion1 = leerEntero("Elija la opcion:");
						switch(opcion1){
						case 1:
							empresa.imprimirObjetosDisponibles();
							codigo=leerString("Ingrese el código del objeto del prestamo  :");
	                        empresa.validarExistenciaObjeto(codigo);
							mensaje=empresa.consultarEmpleadoPrestamoObjeto(codigo);
							imprimirVentana(mensaje);

							break;
						case 2:
							prestamoAux=empresa.devolverPrestamoEmpleadoRango();
							imprimirVentana(prestamoAux.toString());

							break;
						case 3:
							tipoObjetoAux=empresa.consultarTipoObjetoMasPrestado();
							imprimirVentana(tipoObjetoAux.toString());
							break;
						case 4:
							tipoObjeto=validarEntradaEntero(1, 3, "Ingrese el tipo de objeto"+
									"\n1: Electrodomestico.\n2: Muebles.\n3: Construccion ");
							tipoObjetoAux=definirTipoObjeto(tipoObjeto);
							unidadesPrestadas=empresa.consultarNumeroUnidadesPrestadas(tipoObjetoAux);
							imprimirVentana(unidadesPrestadas+"");
						case 5:
							empresa.imprimirClientesRegistrados();
	                        documento=leerString("Ingrese el código del cliente que solicitará el prestamo :");
	                        codigoAux=leerString("Ingrese la ciudad del cliente");
	                        mensaje=empresa.devolverObjetosPrestamoCliente(documento, codigoAux);
	                        imprimirVentana(mensaje);
							break;


						}
					}while (opcion1 != 7);
					break;

				}
			}

			catch (SinCupoObjetoException | ObjetoNoEncontradoException |SinObjetosRegistradosException
					| SinClientesRegistradosException | ClienteNoEncontradoException |
					 SinEmpleadosRegistradosException | EmpleadoNoEncontradoException | SinCupoPrestamoException | SinCupoDetallePrestamo
					| SinCantidadDisponibleException | ObjetoNoDisponibleException | PrestamoNoEncontradoException | SinObjetosPrestadosException
					| SinPrestamosRegistradosException | EmpleadoExisteException | ClienteExisteException e) {
				imprimirVentanaError(e.getMessage());
			}
		}while (opcion != 6);

	}

	/**
	 * Metodo que imprime un empleado dado su documento
	 * si no es encontrado retorna una excepcion
	 * @param empresaAux
	 * @throws SinEmpleadosRegistradosException
	 * @throws EmpleadoNoEncontradoException
	 */
	private static void mostrarEmpleado(Empresa empresaAux) throws SinEmpleadosRegistradosException, EmpleadoNoEncontradoException {
		String documento;

		empresaAux.imprimirEmpleadosRegistrados();

		documento=leerString("Ingrese el documento del empleado a mostrar :");
		empresaAux.mostrarEmpleado(documento);

	}

	/**
	 * Metodo para crear un Empleado
	 * @param empresaAux
	 * @return
	 * @throws EmpleadoExisteException
	 */
	private static Empresa crearEmpleado(Empresa empresaAux) throws EmpleadoExisteException {
		String documento;
		String nombre;
		String telResidencia;
		String telCelular;
		String direccion;
		String ciudadResidencia;
		String departamento;
		String pais;
		String correo;
		int tipoDocumento;
		int tipoEmpleado;

		documento = leerString("Ingrese el n�mero de documento: ");
		nombre = leerString("Ingrese el nombre del empleado: ");
		telResidencia = leerString("Ingrese el telefono de residencia: ");
		telCelular = leerString("Ingrese el telefono celular: ");
		direccion = leerString("Ingrese la direcci�n: ");
		ciudadResidencia = leerString("Ingrese la ciudad de residencia: ");
		departamento = leerString("Ingrese el departamento: ");
		pais = leerString("Ingrese el departamento :");
		correo = leerString("Ingrese el correo del empleado: ");
		tipoDocumento = validarEntradaEntero(1, 3, "Ingrese el tipo de documento"+
										"\n1: Cedula.\n2:Pasaporte.\n3:Cedula "+
										"extranjera.");

		tipoEmpleado = validarEntradaEntero(1, 3, "Ingrese el tipo de Empleado"+
				"\n1: Tipo1.\n2:Tipo2.\n3:Tipo3.");
		empresaAux.crearEmpleado(documento, nombre, telResidencia, telCelular, direccion,
				                ciudadResidencia, departamento, pais, correo, tipoDocumento, tipoEmpleado);
		return empresaAux;
	}
	private static Empresa eliminarCliente(Empresa empresaAux) throws SinClientesRegistradosException, ClienteNoEncontradoException {
		String documento;

		empresaAux.imprimirClientesRegistrados();

		documento=leerString("Ingrese el documento del cliente a eliminar :");
		empresaAux.eliminarCliente(documento);
		return empresaAux;
	}
	private static Empresa actualizarClienteRegistrado(Empresa empresaAux) throws ClienteNoEncontradoException,
																				SinClientesRegistradosException {
		String documento;
		String nombre;
		String telResidencia;
		String telCelular;
		String direccion;
		String ciudadResidencia;
		String departamento;
		String pais;
		String profesion;
		String correo;
		String genero;
		int    tipoDocumento;

		empresaAux.imprimirClientesRegistrados();
		documento=leerString("Ingrese el documento del cliente :");
		telResidencia=leerString("Ingrese el telefono :");
		telCelular=leerString("Ingrese el telefono movil :");
		nombre=leerString("Ingrese el nombre del cliente :");
		genero=leerGenero("Ingrese el genero del cliente\n1: Masculino\n2: Femenino");
		direccion=leerString("Ingrese su direccion :");
		ciudadResidencia=leerString("Ingrese la ciudad de residencia del cliente :");
		departamento=leerString("Ingrese el departamento :");
		pais=leerString("Ingrese el pais :");
		profesion=leerString("Ingrese su profesion :");
		correo=leerString("Ingrese su correo :");
		tipoDocumento=validarEntradaEntero(1, 3, "Ingrese el tipo de documento"+
										"\n1: Cedula.\n2:Pasaporte.\n3:Cedula "+
										"extranjera.");
		empresaAux.actualizarCliente(documento,telResidencia, telCelular, nombre, genero, ciudadResidencia,
							departamento,  pais,  profesion,  correo, tipoDocumento,direccion);
		return empresaAux;
	}
	private static void mostrarCliente(Empresa empresaAux) throws SinClientesRegistradosException, ClienteNoEncontradoException {
		String documento;

		empresaAux.imprimirClientesRegistrados();

		documento=leerString("Ingrese el documento del cliente a mostrar :");
		empresaAux.mostrarCliente(documento);

	}
	private static Empresa crearCliente(Empresa empresa) throws ClienteExisteException {
		String documento;
		String nombre;
		String telResidencia;
		String telCelular;
		String direccion;
		String ciudadResidencia;
		String departamento;
		String pais;
		String profesion;
		String correo;
		String genero;
		int    tipoDocumento;


		documento=leerString("Ingrese el documento del cliente :");
		empresa.verificarClienteRegistrado(documento);
		telResidencia=leerString("Ingrese el telefono :");
		telCelular=leerString("Ingrese el telefono móvil :");
		nombre=leerString("Ingrese el nombre del cliente :");
		genero=leerGenero("Ingrese el genero del cliente\n1: Masculino\n2: Femenino");
		direccion=leerString("Ingrese su direccion :");
		ciudadResidencia=leerString("Ingrese la ciudad de residencia del cliente :");
		departamento=leerString("Ingrese el departamento :");
		pais=leerString("Ingrese el pais :");
		profesion=leerString("Ingrese su profesion :");
		correo=leerString("Ingrese su correo :");
		tipoDocumento=validarEntradaEntero(1, 3, "Ingrese el tipo de documento"+
										"\n1: Cedula.\n2:Pasaporte.\n3:Cedula "+
										"extranjera.");
		empresa.crearCliente(documento,telResidencia, telCelular, nombre, genero, ciudadResidencia,
							departamento,  pais,  profesion,  correo, tipoDocumento,direccion);
		return empresa;
	}
	/**
	 * método que define el tipo del documento y lo setea
	 * @param tipoDocumento
	 */
	public static TipoObjeto definirTipoObjeto(int tipoObjeto) {
		TipoObjeto tipoObjetoAux=null;
		if(tipoObjeto==TipoObjeto.ELECTRODOMESTICOS.getNumTipo())
		{
			tipoObjetoAux=TipoObjeto.ELECTRODOMESTICOS;
			return tipoObjetoAux;
		}
		else
		{
			if(tipoObjeto==TipoObjeto.MUEBLES.getNumTipo())
			{
				tipoObjetoAux=TipoObjeto.MUEBLES;
				return tipoObjetoAux;
			}
			else
			{
				tipoObjetoAux=TipoObjeto.CONSTRUCCION;
				return tipoObjetoAux;
			}

		}


	}

/**
 * método para validar la entrada de un double y asegurarse de que
 * ésta sea un valor positivo, una vez asegurado esto se retorna
 * el precio.
 * @param mensaje
 * @return precio
 */
private static double validarPrecio(String mensaje) {
		double precio;
		do {
		precio=leerDouble(mensaje);
		if(precio<0)
			imprimirVentanaError("el precio debe ser un valor positivo");
		}while(precio<0);
		return precio;
	}


/**
 * métoddo que valida el estado de un objeto, si es 1 el objeto
 * estará disponible, si es 2 el objeto no estará disponible
 * @param mensaje
 * @return
 */
private static String validarEstadoObjeto(String mensaje) {
		String estado;
		int    eleccion;
		eleccion=validarEntradaEntero(1, 2, mensaje);
		if(eleccion==1)
		{
			estado="disponible";
			return estado;
		}
		else
		{
			estado="no disponible";
			return estado;
		}
	}



/**
 * método que valida si un número entero es natural o no
 * (es decir, positivo)
 * @param string
 * @return resultado
 */
	private static int validarNumeroNatural(String mensaje) {
		int resultado;
		do {
			resultado=leerEntero(mensaje);
			if(resultado<0)
				imprimirVentanaError("El número debe ser un entero positivo...");
		}while(resultado<0);
		return resultado;
	}



/**
 * imprime el menú principal
 */
	private static void mostrarMenu() {
		System.out.println("1-Administrar empleados.");
		System.out.println("2-Administrar clientes.");
		System.out.println("3-Administrar objectos.");
		System.out.println("4-Administrar prestamos.");
		System.out.println("5-Reportes.");
		System.out.println("6-Salir.");

	}
/**
 * imprime el menú crud de empleados
 */
	private static void mostrarMenuEmpleados() {
		System.out.println("1-Crear empleado.");
		System.out.println("2-Mostrar empleado.");
		System.out.println("3-Actualizar empleado.");
		System.out.println("4-Eliminar empleado.");
		System.out.println("5-menú principal.");
	}
	/**
	 * imprime el menú crud de empleados
	 */
	private static void mostrarMenuClientes() {
		System.out.println("1-Crear cliente.");
		System.out.println("2-Mostrar cliente.");
		System.out.println("3-Actualizar cliente.");
		System.out.println("4-Eliminar cliente.");
		System.out.println("5-menú principal.");
	}

	private static void mostrarMenuCase3() {
		System.out.println("1-Crear objeto");
		System.out.println("2-Consultar los datos de un objeto dado su código");
		System.out.println("3-Consultar dado el nombre del objeto la cantidad de préstamos en el cual está incluido");
		System.out.println("4-Consultar la cantidad total de unidades prestadas de cada objeto");
		System.out.println("5-Reemplazar un objeto por otro");
		System.out.println("6-Menú anterior");

	}
	private static void mostrarMenuCase4() {
		System.out.println("1-Crear Préstamo");
		System.out.println("2-Adicionar objeto al préstamo");
		System.out.println("3-Entregar Préstamo");
		System.out.println("4-Consultar datos de un préstamo dado su código");
		System.out.println("5-Mostrar la cantidad de préstamos realizados por cada empleado");
		System.out.println("6-Menú anterior");
	}
	private static void mostrarMenuCase5() {
		System.out.println("1-Mostrar datos del empleado con más unidades prestadas");
		System.out.println("2-Total de dinero recaudado por la empresa");
		System.out.println("3-Total de dinero a pagar a los empleados");
		System.out.println("4-Menú anterior");
	}
	private static void mostrarMenuCase6() {
		System.out.println("1-Devolver la información del empleado que ha realizado un préstamo de un objeto dado el código del objeto");
		System.out.println("2-Devolver el préstamo que contenga la cantidad de unidades prestadas de un objeto en un rango mayor igual"+
							"a 5 unidades y menor a 15 unidades realizado por un empleado con aniosExperiencia mayor igual a 2");
		System.out.println("3-Consultar cual es el tipo de objeto que ha sido prestado\n"
				+ "     //    más veces en la empresa");
		System.out.println("4-consulta en los prestamos cual es\n"
				+ "     * la cantidad total de unidades prestadas de un objeto por el tipo de objeto");
		System.out.println("5-Devolver los objetos de tipo electrodomésticos que han sido prestados\n "
				+ "por un cliente dado el documento del Cliente y la ciudad de residencia, estos préstamos\n "
				+ "deben tener un valor dentro del rango mayor a 10000 y menor a 200000\n");
		System.out.println("6-menú anterior");



	}

	/**
	 * m�todo que sirve para leer un entero por consola, usa la exepci�n de
	 * formato en caso de que el usuario ingrese o una linea vac�a o un car�cter que no sea
	 * un n�mero.
	 * @param mensaje
	 * @return dato
	 */
	private static int leerEntero(String mensaje)
	{
		int dato=0;
		String captura="";
		System.out.print(mensaje);
		Scanner teclado= new Scanner(System.in);
		captura=teclado.nextLine();
		try
		{
			dato=Integer.parseInt(captura);
			return dato;
		}
		catch(NumberFormatException e)
		{
			dato=0;
			imprimirVentanaError("Error de formato, ingrese el número nuevamente.");
			return dato;
		}
	}
	/**
	 * m�todo que sirve para leer un double por consola, usa la exepci�n de formato
	 * para evitar errores de lectura ocasionados por la entrada de cadenas vac�as o
	 * car�cteres diferentes a numeros
	 * @param mensaje
	 * @return dato
	 */
	public static double leerDouble(String mensaje)
	{
		double dato=0;
		String captura="";
		System.out.print(mensaje);
		Scanner teclado=new Scanner(System.in);
		captura=teclado.nextLine();
		try
		{
			dato=Double.parseDouble(captura);
			return dato;
		}
		catch(NumberFormatException e)
		{
			dato=0;
			imprimirVentanaError("Error de formato, ingrese el número nuevamente.");
			return dato;
		}
	}
	/**
	 * m�todo que sirve para leer un string por consola y verificar mediante una bandera
	 * si el string est� o no vac�o
	 * @param mensaje
	 * @return captura
	 */
	public static String leerString(String mensaje)
	{
		boolean cadenaVacia;
		String captura="";
		Scanner teclado= new Scanner(System.in);
		do
		{
			System.out.print(mensaje);
			captura=teclado.nextLine();
			System.out.println("");
			cadenaVacia=captura.isEmpty();
			if(cadenaVacia==true)
			{
				imprimirVentanaError("La cadena est� vac�a.");
			}
		}while(cadenaVacia==true);
		return captura;
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
	 * m�todo para validar una entrada entera entre un rango mayor al primer parametro y menor al segundo parametro
	 * es el mensaje que se le imprimir� al usuario para la solicitud del valor entero
	 * @param limInferior
	 * @param mensaje
	 * @return opcion
	 */
	private static int validarEntradaEntero(int limInferior,int limSuperior,String mensaje)
	{
		int opcion=0;
		opcion=leerEntero(mensaje);
		while(opcion<limInferior || opcion>limSuperior ||opcion==0)
		{
			if(opcion!=0)
			{
				imprimirVentanaError("El numero no es valido, ingrese valores entre :"+limInferior+" y "+limSuperior);
			}
			opcion=leerEntero(mensaje);
		}
		return opcion;
	}
	/**
	 * método cuya función es asignar un genero entre femenino y masculino
	 * dependiendo de la elección del usuario
	 * @param mensaje
	 * @return genero
	 */
	private static String leerGenero(String mensaje) {
		String genero="";
		int opcion;
		do {
			opcion=leerEntero(mensaje);
			if(opcion!=1 && opcion!=2)
				imprimirVentanaError("Elija un número entre el 1 y 2");
		}while(opcion!=1 && opcion!=2);
		if(opcion==1)
		{
			genero="Masculino";
		}
		else
		{
			genero="Femenino";
		}
		return genero;
	}

	}
