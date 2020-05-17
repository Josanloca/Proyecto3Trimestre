package modelo;

import Limites.iLimitesGenerales;
import modelo.tipo_estados.TipoUsuarioValorado;

public class valoraciones implements iLimitesGenerales,iValoraciones{

	private int iIdValoracion;
	private byte bPuntuacion;
	private String sDesValor;
	private Peticion oPeticion;
	private TipoUsuarioValorado tuv;
	
	public valoraciones (int iIdValoracion) {
		this.setiIdValoracion(iIdValoracion);
	}
	
	public valoraciones (int iIdValoracion,byte bPuntuacion,String sDesValor,Peticion oPeticion,TipoUsuarioValorado tuv) {
		this.setiIdValoracion(iIdValoracion);
		this.setbPuntuacion(bPuntuacion);
		this.setsDesValor(sDesValor);
		this.setoPeticion(oPeticion);
		this.setTuv(tuv);
	}
	
	@Override
	public int getiIdValoracion() {
		return iIdValoracion;
	}
	private boolean setiIdValoracion(int iIdValoracion) {
		boolean bExito = false;
		if(iIdValoracion> LIMITTUVZERO && String.valueOf(iIdValoracion).length()  < LIMITTUVMAX) {
			this.iIdValoracion = iIdValoracion;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public byte getbPuntuacion() {
		return bPuntuacion;
	}
	
	@Override
	public boolean setbPuntuacion(byte bPuntuacion) {
		boolean bExito = false;
		if(bPuntuacion > LIMITTUVZERO && bPuntuacion <= LIMITTUVPUNTMAX) {
			this.bPuntuacion = bPuntuacion;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String getsDesValor() {
		return sDesValor;
	}
	
	@Override
	public boolean setsDesValor(String sDesValor) {
		boolean bExito = false;
		if(sDesValor != null && sDesValor.length() <= LIMITTUVDEXMAX) {
			this.sDesValor = sDesValor;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public Peticion getoPeticion() {
		return oPeticion;
	}
	
	@Override
	public boolean setoPeticion(Peticion oPeticion) {
		boolean bExito = false;
		if(oPeticion.checkPeticion() || oPeticion != null) {
			this.oPeticion = oPeticion;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public TipoUsuarioValorado getTuv() {
		return tuv;
	}
	
	@Override
	public boolean setTuv(TipoUsuarioValorado tuv) {
		boolean bExito = false;
		if(tuv.checkTipoUsuarioValorado() || tuv != null) {
			this.tuv = tuv;
			bExito = true;
		}
		return bExito;
	}	
	
	@Override
	public boolean checkValoracion() {
		boolean bExito = false;
		if(String.valueOf(this.iIdValoracion) != null && this.bPuntuacion >=0 && this.bPuntuacion <= 10 && this.oPeticion != null && this.tuv != null){
			bExito = true;			
		}
		return bExito;
	}
	
	@Override
    public int hashCode () {
    	final int prime = 31;
    	int result = 1;
    	result = prime * result + iIdValoracion;
    	return result;
    }
    
	@Override
    public boolean equals (Object obj) {
    	boolean bExito = false;
    	valoraciones other = (valoraciones) obj;
    	if (checkValoracion() && other.checkValoracion() && this.iIdValoracion ==(other.iIdValoracion)) {
    		bExito = true;
    	}
    	return bExito;
    } 
    
	@Override
    public String toString () {
       	String sResultado = "";
       	
       	sResultado += "Id de la valoracion: "+this.getiIdValoracion()+"\n";
       	sResultado += "Puntuacion: "+this.getbPuntuacion()+"\n";
       	sResultado += "Precio Medio: "+this.getsDesValor()+"\n";
       	sResultado += "Id de la peticion valorada: "+this.getoPeticion().getiIdPeticion()+"\n";
       	sResultado += "Tipo de persona valorada: "+this.getTuv().getTipoUsuarioValorado()+"\n";
       			
    	return sResultado;

       }
	
}