package modelo;

import Limites.iLimitesGenerales;
import modelo.tipo_estados.TipoUsuarioValorado;

public class valoraciones implements iLimitesGenerales,iValoraciones{

	private int iIdValoracion;
	private byte bPuntuacion;
	private String sDesValor;
	private Peticion oPeticion;
	private TipoUsuarioValorado tuv;
	
	
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
		if(oPeticion.checkPeticion()) {
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
		if(tuv.checkTipoUsuarioValorado()) {
			this.tuv = tuv;
			bExito = true;
		}
		return bExito;
	}	
	
}