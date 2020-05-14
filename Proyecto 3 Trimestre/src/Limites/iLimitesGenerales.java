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
	public final byte LIMITEESTADOOFERTAMIN=0;
	public final byte LIMITEESTADOOFERTAMAX=10;

	//Oferta
	public final byte LIMITEOFERTAZERO=0;
	public final byte LIMITEOFERTAMAXID=6;
	public final int LIMITEDESCMAX=500;
	public final int LIMITEPRECMAX=1000;

	//Peticion
	public final byte LIMITEPETIZERO=0;
	public final byte LIMITEPETIMAX=9;
	public final int LIMITDESCMAX = 500;
	public final int LIMITEPREMAX=9999;
	
	//TipoUsuarioValorado
	public final byte LIMITTYPEVZERO = 0;
	public final byte LIMITTYPEVMAX = 12;

	//valoracion
	public final byte LIMITTUVZERO =0;
	public final byte LIMITTUVPUNTMAX =10;
	public final byte LIMITTUVMAX =9;
	public final int LIMITTUVDEXMAX =500;


	
	

}
