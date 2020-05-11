package modelo;

import modelo.tipo_estados.EstadoOferta;

public interface iOferta {

	public int getId_Oferta();
	public String getDescOferta();
	public boolean setDescOferta(String descOferta);
	public int getPrecioOferta() ;
	public boolean setPrecioOferta(int PrecioOferta);
	public usuario getoUsuarioOferta();
	public boolean setoUsuarioOferta(usuario oUsuarioOferta);
	public EstadoOferta getoEstadoOferta();
	public boolean setoEstadoOferta(EstadoOferta oEstadoOferta);
	public boolean checkOferta();
	public int hashCode ();
	public boolean equals (Object obj);
    public String toString() ;
    
}
