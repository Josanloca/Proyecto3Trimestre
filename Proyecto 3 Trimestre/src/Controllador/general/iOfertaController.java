package Controllador.general;

import java.util.List;

import modelo.oferta;
import modelo.usuario;

public interface iOfertaController {

	public int add (oferta oOferta);
	public int remove (oferta oOferta);
    public int existeOferta (oferta oOferta);
    public List<oferta> ListaXPeticion (oferta oOferta);
    public List<oferta> ListaOfertaXDNI (usuario oUsuario);
	public oferta inicioPeticionConOferta();
	public byte ContadorOferta();
    public List<oferta> ListaV1 (usuario oUsuario1,PaqueteController Controllado);
    public int ActualizarOfertasAceptado (int iDato1,int iDato2);
    public int ActualizarOfertasDenegadas (int iDato1);
    public List<oferta> ListaOfertaXdniFinalizarPeticion (usuario oUsuario);
    public oferta ObjetoDevueltoOferta (oferta oOferta);
    public int ActualizarOfertaFinalizacion (int iDato1);
}
