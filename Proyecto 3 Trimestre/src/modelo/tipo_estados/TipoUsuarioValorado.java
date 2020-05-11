package modelo.tipo_estados;

import Limites.iLimitesGenerales;

public class TipoUsuarioValorado implements iLimitesGenerales,iTipoUsuarioValorado{

private String tipoUsuarioValorado;

	public TipoUsuarioValorado(String tipoUsuarioValorado) {
		setTipoUsuarioValorado(tipoUsuarioValorado);
	}
	
	@Override
	public String getTipoUsuarioValorado() {
		return tipoUsuarioValorado;
	}

	private boolean setTipoUsuarioValorado(String tipoUsuarioValorado) {
		boolean bExito = false;
		if(tipoUsuarioValorado != null && tipoUsuarioValorado.length() > LIMITTYPEVZERO && tipoUsuarioValorado.length() <= LIMITTYPEVMAX) {
			this.tipoUsuarioValorado = tipoUsuarioValorado;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public boolean checkTipoUsuarioValorado() {
		boolean bExito = false;
		if(this.tipoUsuarioValorado != null) {
		    bExito = true;
		}
		return bExito;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoUsuarioValorado == null) ? 0 : tipoUsuarioValorado.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		TipoUsuarioValorado otro = (TipoUsuarioValorado) obj;
		if (this!= null && obj != null &&  otro.tipoUsuarioValorado.equals(this.tipoUsuarioValorado)) {
			bIgual = true;
		}
		return bIgual;
	}	
	
	@Override
	public String toString (){
		String sTexto= "";
		sTexto += "Tipo de usuario valorado: "+ tipoUsuarioValorado + "\n";
		return sTexto;
	}
}
