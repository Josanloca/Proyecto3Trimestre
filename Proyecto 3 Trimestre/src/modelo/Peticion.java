package modelo;

import Limites.iLimitesGenerales;
import modelo.tipo_estados.EstadoPeticion;

public class Peticion implements iLimitesGenerales,iPeticion{

	private int iIdPeticion;
	private String sDescripcion;
	private int iPrecio;
	private usuario oUsuarioPeticion;
	private EstadoPeticion oEstadoPeticion;
	private oferta oIdOferta;
	
	public Peticion(int iIdPeticion,String sDescripcion,int iPrecio,usuario oUsuarioPeticion,EstadoPeticion oEstadoPeticion,oferta oIdOferta) {
		this.setiIdPeticion(iIdPeticion);
		this.setsDescripcion(sDescripcion);
		this.setiPrecio(iPrecio);
		this.setoUsuarioPeticion(oUsuarioPeticion);
		this.setoEstadoPeticion(oEstadoPeticion);
		this.setoIdOferta(oIdOferta);
	}
	
	public Peticion(int iIdPeticion,String sDescripcion,int iPrecio,usuario oUsuarioPeticion,EstadoPeticion oEstadoPeticion) {
		this.setiIdPeticion(iIdPeticion);
		this.setsDescripcion(sDescripcion);	
		this.setiPrecio(iPrecio);
		this.setoUsuarioPeticion(oUsuarioPeticion);
	}
	
	@Override
	public int getiIdPeticion() {
		return iIdPeticion;
	}
	
	private boolean setiIdPeticion(int iIdPeticion) {
		boolean bExito = false;
		if(String.valueOf(iIdPeticion) != null && iIdPeticion >LIMITEPETIZERO && iIdPeticion < LIMITEPETIMAX) {
			this.iIdPeticion = iIdPeticion;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String getsDescripcion() {
		return sDescripcion;
	}
	
	@Override
	public boolean setsDescripcion(String sDescripcion) {
		boolean bExito = false;
		if(sDescripcion.length() < LIMITDESCMAX) {
			this.sDescripcion = sDescripcion;
			bExito = true;
		}		
		return bExito;
	}
	
	@Override
	public int getiPrecio() {
		return iPrecio;
	}

	@Override
	public boolean setiPrecio(int iPrecio) {
		boolean bExito = false;
		if(iPrecio > LIMITEPETIZERO && iPrecio <= LIMITEPREMAX) {
			this.iPrecio = iPrecio;
			bExito = true;
		}		
		return bExito;
	}

	@Override
	public usuario getoUsuarioPeticion() {
		return oUsuarioPeticion;
	}
	
	@Override
	public boolean setoUsuarioPeticion(usuario oUsuarioPeticion) {
		boolean bExito = false;
		if(oUsuarioPeticion.checkUsuario()) {
			this.oUsuarioPeticion = oUsuarioPeticion;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public EstadoPeticion getoEstadoPeticion() {
		return oEstadoPeticion;
	}
	
	@Override
	public boolean setoEstadoPeticion(EstadoPeticion oEstadoPeticion) {
		boolean bExito = false;
		if(oEstadoPeticion.checkEstadoPeticion()) {
			this.oEstadoPeticion = oEstadoPeticion;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public oferta getoIdOferta() {
		return oIdOferta;
	}
	
	@Override
	public boolean setoIdOferta(oferta oIdOferta) {
		boolean bExito = false;
		if(oIdOferta.getId_Oferta() >0 || oIdOferta.checkOferta() ) {
			this.oIdOferta = oIdOferta;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public boolean checkPeticion() {
		boolean bExito = false;
		if(String.valueOf(this.iIdPeticion) != null && this.oEstadoPeticion != null && this.oUsuarioPeticion != null && this.oIdOferta != null){
			bExito = true;			
		}
		return bExito;
	}
	
    @Override
    public int hashCode () {
    	final int prime = 31;
    	int result = 1;
    	result = prime * result + iIdPeticion;
    	return result;
    }
	
    @Override
    public boolean equals (Object obj) {
    	boolean bExito = false;
    	Peticion other = (Peticion) obj;
    	if (checkPeticion() && other.checkPeticion() && this.iIdPeticion ==(other.iIdPeticion)) {
    		bExito = true;
    	}
    	return bExito;
    }
    
   public String toString () {
   	String sResultado = "";
   	sResultado += "Id del pedido: "+this.getoIdOferta()+"\n";
   	sResultado += "Descripccion: "+this.getsDescripcion()+"\n";
   	sResultado += "Precio Medio: "+this.getiPrecio()+"\n";
   	sResultado += "Nombre del usuario: "+this.getoUsuarioPeticion()+"\n";
   	sResultado += "Estado de la peticion: "+this.getoEstadoPeticion().getsEstadoPeticion()+"\n";
   	sResultado += "Id de la oferta es: "+this.getoIdOferta().getId_Oferta()+"\n";
   			
	return sResultado;

   }
}