package modelo.tipo_estados;

import Limites.iLimitesGenerales;

public class EstadoOferta implements iLimitesGenerales,iEstadoOferta{

	private String sEstadoOferta; // PK
	
	public EstadoOferta() {
		this.setsEstadoOferta(sEstadoOferta);
	}

	@Override
	public String getsEstadoOferta() {
		return sEstadoOferta;
	}

	
	private boolean setsEstadoOferta(String sEstadoOferta) {
		boolean bExito = false;
		if(sEstadoOferta != null && sEstadoOferta.length() >= LIMITEESTADOOFERTAMIN && sEstadoOferta.length() <= LIMITEESTADOOFERTAMAX) {
			this.sEstadoOferta = sEstadoOferta;
			bExito = true;
		}else {
			this.sEstadoOferta = null;
		}
		return bExito;
	}
	
	@Override
	public boolean checkEstadoOferta() {
		boolean bExito = false;
		if(sEstadoOferta != null && sEstadoOferta.length() >= LIMITEESTADOOFERTAMIN && sEstadoOferta.length() <= LIMITEESTADOOFERTAMAX) {
			bExito = true;
		}
		return bExito;
	}
	
    @Override
    public int hashCode () {
    	final int prime = 31;
    	int result = 1;
    	result = prime * result + ((sEstadoOferta == null) ? 0 : sEstadoOferta.hashCode());
    	return result;
    }

    @Override
    public boolean equals (Object obj) {
    	boolean bExito = false;
    	EstadoOferta other = (EstadoOferta) obj;
    	if (checkEstadoOferta() && other.checkEstadoOferta() && this.sEstadoOferta.equals(other.sEstadoOferta)) {
    		bExito = true;
    	}
    	return bExito;
    }
	
    public String toString() {
    	String sTexto= "";
    	sTexto += "Estado: "+ sEstadoOferta + "\n";
    	return sTexto;
    }
	
}