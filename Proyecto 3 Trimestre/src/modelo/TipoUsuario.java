package modelo;

import Limites.iLimitesGenerales;

public class TipoUsuario implements iLimitesGenerales,iTipoUsuario{

	private String nombreUsuario;
	
	public TipoUsuario(String nombreUsuario) {
		this.setNombreUsuario(nombreUsuario);
	}

	@Override
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	private boolean setNombreUsuario(String nombreUsuario) {
		boolean bExito = false;
		if(nombreUsuario != null && nombreUsuario.length() == LIMITENOMBRETU) {
			this.nombreUsuario = nombreUsuario;
			bExito = true;
		}else {
			this.nombreUsuario = null;
		}
		return bExito;
	}
	
	@Override
	public boolean checkNombreUsuario() {
		boolean bExito = false;
		if(this.nombreUsuario != null) {
		    bExito = true;
		}
		return bExito;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		TipoUsuario otro = (TipoUsuario) obj;
		if (this!= null && obj != null &&  otro.nombreUsuario.equals(this.nombreUsuario)) {
			bIgual = true;
		}
		return bIgual;
	}	
	
	@Override
	public String toString (){
		String sTexto= "";
		sTexto += "Tipo de usuario: "+ nombreUsuario;
		return sTexto;
	}
}