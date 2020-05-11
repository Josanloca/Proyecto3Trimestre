package modelo.tipo_estados;

import Limites.iLimitesGenerales;

public class EstadoPeticion implements iLimitesGenerales,iEstadoPeticion{

	private String sEstadoPeticion;

	public EstadoPeticion(String sEstadoPeticion) {
		this.setsEstadoPeticion(sEstadoPeticion);
	}
	
	@Override
	public String getsEstadoPeticion() {
		return sEstadoPeticion;
	}

	
	private boolean setsEstadoPeticion(String sEstadoPeticion) {
		boolean bExito = false;
		if(sEstadoPeticion != null && sEstadoPeticion.length() > LIMITEPETIZERO && sEstadoPeticion.length() <= LIMITEPETIMAX) {
			this.sEstadoPeticion = sEstadoPeticion;
			bExito = true;
		}else {
			this.sEstadoPeticion = null;
		}		
		return bExito;
	}
	
	@Override
	public boolean checkEstadoPeticion() {
		boolean bExito = false;
		if(sEstadoPeticion != null && sEstadoPeticion.length() > LIMITEPETIZERO && sEstadoPeticion.length() <= LIMITEPETIMAX) {
			bExito = true;
		}
		return bExito;
	}
	
    @Override
    public int hashCode () {
    	final int prime = 31;
    	int result = 1;
    	result = prime * result + ((sEstadoPeticion == null) ? 0 : sEstadoPeticion.hashCode());
    	return result;
    }

    @Override
    public boolean equals (Object obj) {
    	boolean bExito = false;
    	EstadoPeticion other = (EstadoPeticion) obj;
    	if (checkEstadoPeticion() && other.checkEstadoPeticion() && this.sEstadoPeticion.equals(other.sEstadoPeticion)) {
    		bExito = true;
    	}
    	return bExito;
    }
    
    @Override
    public String toString() {
    	String sTexto= "";
    	sTexto += "Estado de la peticion: "+ sEstadoPeticion + "\n";
    	return sTexto;
    }
}