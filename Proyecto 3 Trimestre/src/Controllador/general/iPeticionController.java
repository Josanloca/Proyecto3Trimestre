package Controllador.general;

import java.util.List;

import modelo.Peticion;
import modelo.usuario;

public interface iPeticionController {

	public int add(Peticion oPeticion);
	public int remove(Peticion oPeticion);
    public List<Peticion> ListaPeticionToda ();
    public int existePeticio (Peticion oPeticion);
	public List<Peticion> ListaPeticionNoFinalizadas(usuario oUsuario);
	public byte ContadorPeticion();
    public List<Peticion> ListaPeticionXDNI(usuario oUsuario);
    public List<Peticion> ListaPeticionXDNIXValoracion(usuario oUsuario);
    public List<Peticion> ListaPeticionSinContarte(usuario oUsuario);
    public int ActualizarPeticionAñadiendoOferta (int iDato1, int iDato2);
    public int ActualizarPeticionFinalizada (int iDato1);
}
