package Controllador.general;

import java.util.List;

import modelo.oferta;

public interface iOfertaController {

	public int add (oferta oOferta);
	public int remove (oferta oOferta);
    public int existeOferta (oferta oOferta);
    public List<oferta> ListaXPeticion (oferta oOferta);
    
}
