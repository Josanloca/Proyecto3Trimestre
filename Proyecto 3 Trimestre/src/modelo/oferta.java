package modelo;

import Limites.iLimitesGenerales;

public class oferta implements iLimitesGenerales{

	private int id_Oferta; //PK
	private String DescOferta;
	private int PrecioOferta; //nn
	private usuario oUsuarioOferta; //FK
	private EstadoOferta oEstadoOferta; //FK
	
	public oferta() {
		
	}

	public int getId_Oferta() {
		return id_Oferta;
	}

	private boolean setId_Oferta(int id_Oferta) {
		boolean bExito = false;
		if(String.valueOf(id_Oferta).length() > LIMITEOFERTAZERO && String.valueOf(id_Oferta).length() <= LIMITEOFERTAMAXID) {
			this.id_Oferta = id_Oferta;
			bExito = true;
		}
		return bExito;
	}

	public String getDescOferta() {
		return DescOferta;
	}

	public boolean setDescOferta(String descOferta) {
		boolean bExito = false;
		if(descOferta.length() >= LIMITEOFERTAZERO && descOferta.length() <= LIMITEDESCMAX) {
			DescOferta = descOferta;
			bExito = true;
		}
		return bExito;
	}

	public int getPrecioOferta() {
		return PrecioOferta;
	}

	public boolean setPrecioOferta(int precioOferta) {
		boolean bExito = false;
		
			PrecioOferta = precioOferta;
			bExito = true;
		
		return bExito;
	}

	public usuario getoUsuarioOferta() {
		return oUsuarioOferta;
	}

	public boolean setoUsuarioOferta(usuario oUsuarioOferta) {
		boolean bExito = false;
		
			this.oUsuarioOferta = oUsuarioOferta;
			bExito = true;
		
		return bExito;
	}

	public EstadoOferta getoEstadoOferta() {
		return oEstadoOferta;
	}

	public boolean setoEstadoOferta(EstadoOferta oEstadoOferta) {
		boolean bExito = false;
		
			this.oEstadoOferta = oEstadoOferta;
			bExito = true;
		
		return bExito;
	}
	
	
	
}
