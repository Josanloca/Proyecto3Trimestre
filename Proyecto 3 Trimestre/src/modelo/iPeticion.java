package modelo;

import modelo.tipo_estados.EstadoPeticion;

public interface iPeticion {

	public int getiIdPeticion();
	public String getsDescripcion();
	public boolean setsDescripcion(String sDescripcion);
	public int getiPrecio();
	public boolean setiPrecio(int iPrecio);
	public usuario getoUsuarioPeticion();
	public boolean setoUsuarioPeticion(usuario oUsuarioPeticion);
	public EstadoPeticion getoEstadoPeticion();
	public boolean setoEstadoPeticion(EstadoPeticion oEstadoPeticion);
	public oferta getoIdOferta();
	public boolean setoIdOferta(oferta oIdOferta);
	public boolean checkPeticion();
}
