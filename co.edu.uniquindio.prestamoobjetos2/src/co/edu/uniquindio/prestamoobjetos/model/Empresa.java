package co.edu.uniquindio.prestamoobjetos.model;

import java.util.ArrayList;

public class Empresa {


	//Declaracion de atributos
	private String nombre;
	private String nit;
	ArrayList<Cliente> listaClientes = new ArrayList<>();


	/**
	 * Constructor clase empresa
	 * @param nombre, nit
	 */
	public Empresa(String nombre, String nit) {
		this.nombre = nombre;
		this.nit = nit;
		inicializarDatos();
	}

	//Métodos Getters and Setters----------------------------------->
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


	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", nit=" + nit + "]";
	}


	private void inicializarDatos() {

		Cliente cliente = new Cliente();
		cliente.setNombre("Juan");
		cliente.setApellido("Arias");
		cliente.setDocumento("1094");
		cliente.setDireccion("Armenia");

		getListaClientes().add(cliente);

		cliente = new Cliente();
		cliente.setNombre("Pedro");
		cliente.setApellido("Perez");
		cliente.setDocumento("1095");
		cliente.setDireccion("Armenia");

		getListaClientes().add(cliente);


		cliente = new Cliente();
		cliente.setNombre("Ana");
		cliente.setApellido("Arias");
		cliente.setDocumento("1098");
		cliente.setDireccion("Quimbaya");

		getListaClientes().add(cliente);
	}

	public Cliente crearCliente(String nombre, String apellido, String documento, String direccion) {

		Cliente cliente = null;

		cliente = obtenerCliente(documento);

		if(cliente == null){
			cliente = new Cliente();
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setDocumento(documento);
			cliente.setDireccion(direccion);
			getListaClientes().add(cliente);

			return cliente;
		}else{
			return null;
		}

	}


	public boolean eliminarCliente(String documento) {

		Cliente cliente = null;

		cliente = obtenerCliente(documento);

		if(cliente != null){
			getListaClientes().remove(cliente);
			return true;
		}else{
			return false;
		}
	}


	private Cliente obtenerCliente(String documento) {

		for (Cliente cliente : listaClientes) {

			if(cliente.getDocumento().equals(documento)){
				return cliente;
			}
		}
		return null;
	}

	public boolean actualizarCliente(String documentoActual, String nombre, String apellido, String documento,String direccion) {

		Cliente cliente = null;

		cliente = obtenerCliente(documentoActual);

		if(cliente != null){

			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setDocumento(documento);
			cliente.setDireccion(direccion);
			return true;
		}else{
			return false;
		}




	}






}
