package co.edu.uniquindio.programaprestamoobjeto.model;

import co.edu.uniquindio.programaprestamoobjeto.excepciones.SinCupoDetallePrestamo;

/**
 * esta clase representa el prestamo, contiene la información del
 * prestamo a solicitar
 * universidad del quindio
 * ingeniería de sistemas y computación
 * @author Juan Sebastian Rojas Juan Pablo Cardona
 */
public class Prestamo {
	
	private String codigo;
	
	private int    diasSolicitados;
	private int    diasTranscurridos;
	
	private double valor;
	
	private Cliente cliente=null;
	
	private Empleado empleado=null;
	
	private DetallePrestamo detallePrestamo1=null;
	private DetallePrestamo detallePrestamo2=null;
	
	/**
	 * método constructor de la clase prestamo
	 * @param codigo
	 * @param diasSolicitados
	 * @param diasTranscurridos
	 * @param valor
	 * @param empleadoAux 
	 * @param clienteAux 
	 */
	public Prestamo(String codigo, int diasSolicitados, int diasTranscurridos, double valor, Cliente clienteAux, Empleado empleadoAux) {
		this.codigo = codigo;
		this.diasSolicitados = diasSolicitados;
		this.diasTranscurridos = diasTranscurridos;
		this.valor = valor;
		this.cliente=clienteAux;
		this.empleado=empleadoAux;
	}
	/**
	 * getters y setters de la clase prestamo
	 */
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getDiasSolicitados() {
		return diasSolicitados;
	}
	public void setDiasSolicitados(int diasSolicitados) {
		this.diasSolicitados = diasSolicitados;
	}
	public int getDiasTranscurridos() {
		return diasTranscurridos;
	}
	public void setDiasTranscurridos(int diasTranscurridos) {
		this.diasTranscurridos = diasTranscurridos;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * metodo toString de la clase Prestamo
	 */
	public String toString() {
		return "Prestamo [codigo=" + codigo + ", diasSolicitados=" + diasSolicitados + ", diasTranscurridos="
				+ diasTranscurridos + ", valor=" + valor + "]";
	}
	/**
	 * método que verifica si el nombre ingresado como parametro 
	 * pertenece al prestamo, retorna un booleano
	 * @param nombre
	 * @return respuesta
	 */
	public boolean verificarPertenciaPrestamo(String nombre) {
		boolean respuesta=false;
		if(detallePrestamo1!=null)
		{
			respuesta=detallePrestamo1.verificarObjetoNombre(nombre);
			if(respuesta==true)
				return respuesta;
		}
		if(detallePrestamo2!=null)
		{
			respuesta=detallePrestamo2.verificarObjetoNombre(nombre);
			if(respuesta==true)
				return respuesta;
		}
		return respuesta;
	}
	/**
	 * método que obtiene la cantidad de unidades prestadas 
	 * de un objeto usando su nombre como identificador
	 * @param nombreObjeto
	 * @return cantidadUnidadesPrestadas
	 */
	public int obtenerCantidadUnidadesPrestadas(String nombreObjeto) {
		int cantidadUnidadesPrestadas=0;
		if(detallePrestamo1!=null)
		{
			cantidadUnidadesPrestadas+=detallePrestamo1.obtenerUnidadesPrestadas(nombreObjeto);
		}
		if(detallePrestamo2!=null)
		{
			cantidadUnidadesPrestadas+=detallePrestamo2.obtenerUnidadesPrestadas(nombreObjeto);
		}
		return cantidadUnidadesPrestadas;
	}
	/**
	 * Metodo para verificar si se puede dar el prestamo
	 * @param unidadesPrestadas (Inf ingresada)
	 * @return centinela (boolean)
	 */
	public boolean verificarDetallePrestamo(int unidadesPrestadas) {
		boolean centinela=true;
		int unidadesDisponibles;
		unidadesDisponibles=detallePrestamo1.darUnidadesDisponibles();
		if(unidadesDisponibles>=unidadesPrestadas){
			centinela=false;
		}
		return centinela;
	}
	/**
	 * Metodo para calculcar el valor del prestamo
	 * @param unidadesPrestadas
	 * @param diasSolicitados2 
	 * @param diasTranscurridos2 
	 * @return valor
	 */
	public double calcularValor(int diasSolicitados, int diasTranscurridos){
		int    diasRetraso;
		double valor=0;
		double valorSancion=0;
		double valorTotal;
		
		if(detallePrestamo1!=null)
			valor+=detallePrestamo1.getSubTotal();
		if(detallePrestamo2!=null)
			valor+=detallePrestamo2.getSubTotal();
		if(diasTranscurridos>diasSolicitados)
		{
			diasRetraso=diasTranscurridos-diasSolicitados;
			if(detallePrestamo1!=null)
				valorSancion+=detallePrestamo1.getSubTotalRetraso();
			if(detallePrestamo2!=null)
				valorSancion+=detallePrestamo2.getSubTotalRetraso();
			valorSancion*=diasRetraso;
		}
		valor*=diasSolicitados;
		
		valorTotal=valor+valorSancion;
		
		return valorTotal;
	}
	/**
	 * método que crea un detalle prestamo.
	 * @param unidadesPrestadas
	 * @param valor
	 * @param objetoAux
	 * @throws SinCupoDetallePrestamo 
	 */
	public void crearOActualizarDetallePrestamo(int unidadesPrestadas, double valor, Objeto objetoAux) throws SinCupoDetallePrestamo {
		String  codigoObjetoBuscar;
		String  codigoObjeto;
		int     unidadesRegistradas;
		int     unidadesAgregar;
		boolean error=true;
		double  subtotal;
		
		codigoObjetoBuscar=objetoAux.getCodigo();
		
		if(detallePrestamo1==null)
		{
			detallePrestamo1=new DetallePrestamo(unidadesPrestadas, valor);
			detallePrestamo1.setObjeto(objetoAux);
			subtotal=detallePrestamo1.calcularSubtotal();
			detallePrestamo1.setSubTotal(subtotal);
			error=false;
		}
		else
		{
			codigoObjeto=detallePrestamo1.getCodigoObjeto();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
			{
				unidadesRegistradas=detallePrestamo1.getUnidadesPrestadas();
				unidadesAgregar=unidadesRegistradas+unidadesPrestadas;
				detallePrestamo1.setUnidadesPrestadas(unidadesAgregar);
				error=false;

			}
			else
			{
				if(detallePrestamo2==null)
				{
					detallePrestamo2=new DetallePrestamo(unidadesPrestadas, valor);
					detallePrestamo2.setObjeto(objetoAux);
					subtotal=detallePrestamo2.calcularSubtotal();
					detallePrestamo2.setSubTotal(subtotal);

					error=false;
				}
				else
				{
					codigoObjeto=detallePrestamo2.getCodigoObjeto();
					if(codigoObjeto.equalsIgnoreCase(codigoObjetoBuscar))
					{
						unidadesRegistradas=detallePrestamo2.getUnidadesPrestadas();
						unidadesAgregar=unidadesRegistradas+unidadesPrestadas;
						detallePrestamo2.setUnidadesPrestadas(unidadesAgregar);
						error=false;
					}
				}
			}		
		}
		
		if(error==true)
			throw new SinCupoDetallePrestamo("no hay cupo para más detalles de prestamo...");
	}
	/**
	 * método que elimina los Detalles del prestamos
	 */
	public void limpiarDetallePrestamos() {
		if(detallePrestamo1!=null)
			detallePrestamo1=null;
		if(detallePrestamo2!=null)
			detallePrestamo2=null;
	}
	/**
	 * método que setea el objeto en detalle prestamo
	 * @param objetoAux
	 */
	public void setObjetoDetallePrestamo(Objeto objetoAux) {
		String codigoObjetoAux;
		String codigoObjeto;
		
		boolean seteadoCompleado=false;
		
		codigoObjetoAux=objetoAux.getCodigo();
		if(detallePrestamo1!=null && seteadoCompleado==false)
		{
			codigoObjeto=detallePrestamo1.getCodigoObjeto();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoAux))
			{
				detallePrestamo1.setObjeto(objetoAux);
				seteadoCompleado=true;
			}
			
		}
		if(detallePrestamo2!=null && seteadoCompleado==false)
		{
			codigoObjeto=detallePrestamo2.getCodigoObjeto();
			if(codigoObjeto.equalsIgnoreCase(codigoObjetoAux))
			{
				detallePrestamo2.setObjeto(objetoAux);
				seteadoCompleado=true;
			}
			
		}
		
	}
	/**
	 * método que retorna el nombre del empleado registrado en el
	 * prestamo
	 * @return nombreEmpleado
	 */
	public String getNombreEmpleado() {
		String nombreEmpleado;
		nombreEmpleado=empleado.getNombre();
		return nombreEmpleado;
	}
	/**
	 * método que retorna el nombre del cliente registrado 
	 * en el prestamo
	 * @return nombreCliente
	 */
	public String getNombreCliente() {
		String nombreCliente;
		nombreCliente=cliente.getNombre();
		return nombreCliente;
	}
	/**
	 * método que retorna la cantidad de unidades prestadas de un objeto
	 * si el detalle prestamo es null se retorna un 0
	 * @param numeroDetallePrestamo
	 * @return
	 */
	public int getunidadesPrestadasDetalle(int numeroDetallePrestamo) {
		int cantidadUnidadesPrestadas=0;
		if(detallePrestamo1!=null && numeroDetallePrestamo==1)
		{
			cantidadUnidadesPrestadas=detallePrestamo1.getUnidadesPrestadas();
			return cantidadUnidadesPrestadas;
		}
		if(detallePrestamo2!=null && numeroDetallePrestamo==2)
		{
			cantidadUnidadesPrestadas=detallePrestamo2.getUnidadesPrestadas();
			return cantidadUnidadesPrestadas;
		}
		
		return cantidadUnidadesPrestadas;
	}
	public String obtenerCodigoObjeto(int numeroDetallePrestamo) {
		String codigoObjeto="";
		if(detallePrestamo1!=null && numeroDetallePrestamo==1)
		{
			codigoObjeto=detallePrestamo1.getCodigoObjeto();
			return codigoObjeto;
		}
		if(detallePrestamo2!=null && numeroDetallePrestamo==2)
		{
			codigoObjeto=detallePrestamo2.getCodigoObjeto();
			return codigoObjeto;
		}
		
		return codigoObjeto;
	}
	/**
	 * método que verifica si el nombre ingresado
	 * coincide con el del empleado registraddo en 
	 * el prestamo
	 * @param nombreEmpleadoBuscar
	 * @return coinciden
	 */
	public boolean verificarEmpleadoNombre(String nombreEmpleadoBuscar) {
		String nombreEmpleado;
		boolean coinciden=false;
		nombreEmpleado=empleado.getNombre();
		if(nombreEmpleado.equalsIgnoreCase(nombreEmpleadoBuscar))
		{
			coinciden=true;
		}
		
		return coinciden;
	}
	/**
	 * método que verifica si el nombre ingresado
		 * coincide con el del empleado registraddo en 
		 * el prestamo
	 * @param codigoEmpleado
	 * @return
	 */
	public boolean verificarEmpleadoCodigo(String codigoEmpleadoBuscar) {
		String codigoEmpleado;
		boolean coinciden=false;
		codigoEmpleado=empleado.getNombre();
		if(codigoEmpleado.equalsIgnoreCase(codigoEmpleadoBuscar))
		{
			coinciden=true;
		}
		
		return coinciden;		
	}
	
	/**Punto 1
     * Metodo que consulta la informacion del empleado que
     * haya realizado un préstamo de un objeto dado el codigo del objeto
     * @param codigoObjeto
     */
    public Empleado consultarEmpleadoPrestamoObjeto(String codigoObjeto) {
        Empleado empleadoEncontrado = null;
        boolean  encontroObjeto=false;
        
        if(detallePrestamo1!=null)
        {
        	encontroObjeto=detallePrestamo1.validarObjetoPrestado(codigoObjeto);
        	if(encontroObjeto==true)
        	{
        		empleadoEncontrado=empleado;
        		return empleadoEncontrado;
        	}
        }
        if(detallePrestamo2!=null)
        {
        	encontroObjeto=detallePrestamo2.validarObjetoPrestado(codigoObjeto);
        	if(encontroObjeto==true)
        	{
        		empleadoEncontrado=empleado;
        		return empleadoEncontrado;
        	}
        }
        return empleadoEncontrado ;
    }

    
    
    /**Punto 2
     * Este metodo verifica si el empelado tiene
     *  el rango de anios de experincia  y verifica si la unidades prestadas
     *  se encuentran en el rango mayorigual 5 y menor igual 15
     * @return
     */

    public boolean verificarPrestamoEmpleadoRango() {
    	int     aniosExperiencia;
    	boolean cumpleRango=false;
    	boolean cumpleRequisitos=false;
    	
    	aniosExperiencia=empleado.getAniosExperiencia();
    	
    	if(aniosExperiencia>=2)
    	{
    		if(detallePrestamo1!=null)
    		{
    			cumpleRango=detallePrestamo1.verificarRangoUnidades();
    			if(cumpleRango==true)
    			{
    				cumpleRequisitos=true;
    				return cumpleRequisitos;

    			}	
    		}
    		if(detallePrestamo2!=null)
    		{
    			cumpleRango=detallePrestamo2.verificarRangoUnidades();
    			if(cumpleRango==true)
    			{
    				cumpleRequisitos=true;
    				return cumpleRequisitos;

    			}	
    		}		
    	}
    	return cumpleRequisitos;
    }

    /**punto 3.b
     * Este metodo retorna las unidades prestadas total
     * de los detalles segun el tipo
     * @param tipoObjeto
     * @return
     */
    public int consultarUnidadesPrestadas(TipoObjeto tipoObjeto) {

        int unidadesPrestadasTotalDetalles = 0;
        
        if(detallePrestamo1!=null)
        {
        	unidadesPrestadasTotalDetalles+=detallePrestamo1.consutarUnidadesPrestadas(tipoObjeto);
        }
        if(detallePrestamo2!=null)
        {
        	unidadesPrestadasTotalDetalles+=detallePrestamo2.consutarUnidadesPrestadas(tipoObjeto);
        }
        return unidadesPrestadasTotalDetalles;
    }
    
    /**Punto 4
     * Metodo que verifica si el cliente del prestamo
     *  cumple con la condicion del codigo y ciudad de residencia
     * @param codigoCliente
     * @return
     */
    public boolean verificarCliente(String codigoCliente, String ciudadCliente) {
        String codigoClienteRegistrado;
        String ciudadClienteRegistrado;
        
        boolean coinciden=false;

        coinciden=cliente.verificarCodigoCiudad(codigoCliente, ciudadCliente);
        return coinciden;
    }
    /**Punto 4
     * verifica que el valor este en el rango 10000 y 200000
     * @param valorVerificar
     * @return
     */
    public boolean verificarValorPrestamoRango(double valorVerificar) {
    	
    	double  valorMaximo=200000;
    	double  valorMinimo=10000;
    	
    	boolean valorCorrecto=false;
    	
    	if(valorVerificar>valorMinimo && valorVerificar<valorMaximo)
    	{
    		valorCorrecto=true;
    	}
    	return valorCorrecto;
    }
    /**Punto 4
     * Este metodo devuelve los objetos de cada detalle segun el tipo de objeto Electrodomesticos
     * @return
     */
    public String obtenerObjetosPrestados() {

        String objetos = "";
        
        int cantidadObjetos=0;
        
        if(detallePrestamo1!=null)
        {
        	cantidadObjetos+=detallePrestamo1.consutarUnidadesPrestadas(TipoObjeto.ELECTRODOMESTICOS);
        }
        if(detallePrestamo2!=null)
        {
        	cantidadObjetos+=detallePrestamo2.consutarUnidadesPrestadas(TipoObjeto.ELECTRODOMESTICOS);
        }
        
        objetos+=" la cantidad de objetos prestados por el cliente  y de tipo electrodomesticos es :"+cantidadObjetos;
        return objetos;
    }


}

	

