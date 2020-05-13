package modelo;

import Limites.iLimitesGenerales;
import modelo.tipo_estados.EstadoOferta;

public class oferta implements iLimitesGenerales,iOferta{

	private int id_Oferta; //PK
	private String DescOferta;
	private int PrecioOferta; //nn
	private usuario oUsuarioOferta; //FK
	private EstadoOferta oEstadoOferta; //FK
	
	public oferta(int id_Oferta) {
		this.setId_Oferta(id_Oferta);
	}
	
	public oferta(int id_Oferta,String DescOferta,int PrecioOferta,usuario oUsuarioOferta,EstadoOferta oEstadoOferta) {
		this.setId_Oferta(id_Oferta);
		this.setDescOferta(DescOferta);
		this.setPrecioOferta(PrecioOferta);
		this.setoUsuarioOferta(oUsuarioOferta);
		this.setoEstadoOferta(oEstadoOferta);
	}

	@Override
	public int getId_Oferta() {
		return id_Oferta;
	}

	private boolean setId_Oferta(int id_Oferta) {
		boolean bExito = false;
		if(id_Oferta > LIMITEOFERTAZERO && String.valueOf(id_Oferta).length() <= LIMITEOFERTAMAXID) {
			this.id_Oferta = id_Oferta;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getDescOferta() {
		return DescOferta;
	}

	@Override
	public boolean setDescOferta(String descOferta) {
		boolean bExito = false;
		if(descOferta.length() >= LIMITEOFERTAZERO && descOferta.length() <= LIMITEDESCMAX) {
			DescOferta = descOferta;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public int getPrecioOferta() {
		return PrecioOferta;
	}

	@Override
	public boolean setPrecioOferta(int PrecioOferta) {
		boolean bExito = false;
		if(PrecioOferta >= LIMITEOFERTAZERO && PrecioOferta <=LIMITEPRECMAX) {
			this.PrecioOferta = PrecioOferta;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public usuario getoUsuarioOferta() {
		return oUsuarioOferta;
	}

	@Override
	public boolean setoUsuarioOferta(usuario oUsuarioOferta) {
		boolean bExito = false;
		if(oUsuarioOferta.checkUsuario()) {
			this.oUsuarioOferta = oUsuarioOferta;
			bExito = true;
		}else {
			this.oUsuarioOferta = null;
		}
		return bExito;
	}

	@Override
	public EstadoOferta getoEstadoOferta() {
		return oEstadoOferta;
	}

	@Override
	public boolean setoEstadoOferta(EstadoOferta oEstadoOferta) {
		boolean bExito = false;
		if(oEstadoOferta.checkEstadoOferta()) {
			this.oEstadoOferta = oEstadoOferta;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public boolean checkOferta() {
		boolean bExito = false;
		if(this.id_Oferta >= LIMITEOFERTAZERO && String.valueOf(this.id_Oferta).length() <= LIMITEOFERTAMAXID && PrecioOferta >= LIMITEOFERTAZERO && PrecioOferta <=LIMITEPRECMAX && oUsuarioOferta.checkUsuario() && oEstadoOferta.checkEstadoOferta()) {
			bExito = true;
		}
		return bExito;
	}
	
	
    @Override
    public int hashCode () {
    	final int prime = 31;
    	int result = 1;
    	result = prime * result + id_Oferta;
    	return result;
    }

	
    @Override
    public boolean equals (Object obj) {
    	boolean bExito = false;
    	oferta other = (oferta) obj;
    	if (checkOferta() && other.checkOferta() && this.id_Oferta == other.id_Oferta) {
    		bExito = true;
    	}
    	return bExito;
    }
    
	@Override
    public String toString() {
    	String sResultado = "";
    	sResultado += "Id de la oferta: "+this.id_Oferta+"\n";
    	if(this.DescOferta!= null) {
    		sResultado += "Descripccion de la oferta: "+this.DescOferta+"\n";
    	}
    	sResultado += "Dinero ofrecido: "+this.PrecioOferta+"\n";
    	sResultado += "Id del usuario ofertante: "+this.oUsuarioOferta+"\n";
    	sResultado += "Estado de la oferta: "+this.oEstadoOferta.getsEstadoOferta()+"\n";
    	return sResultado;
    	
    }
}
