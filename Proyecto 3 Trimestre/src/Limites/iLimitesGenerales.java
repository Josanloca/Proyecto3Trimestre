package Limites;

public interface iLimitesGenerales {

	//TipoUsuario
	public final byte LIMITENOMBRETU=12;
	
	//Usuario
	public final byte LIMITENOMBREU=9;
	public final byte LIMITEUZERO=0;
	public final byte LIMITEUNOMBRE=35;
	public final byte LIMITCONTRASEÑAMIN=7;
	public final byte LIMITCONTRASEÑAMAX=40;
	public final byte LIMITCORREOMIN=7;
	public final byte LIMITCORREOMAX=35;
	public final byte LIMITTELEFONO=9;
	public final byte LIMITDIREMAX=9;
	public final int LIMITDESCRIPCCIONMAX=200;
	
	//EstadoUsuario
	public final byte LIMITEESTADOOFERTAMIN=9;
	public final byte LIMITEESTADOOFERTAMAX=10;

	//Oferta
	public final byte LIMITEOFERTAZERO=0;
	public final byte LIMITEOFERTAMAXID=6;
	public final int LIMITEDESCMAX=500;
	

}
