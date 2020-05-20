package Controllador.general;

import java.util.List;
import modelo.Peticion;
import modelo.valoraciones;

public interface iValoracionController {
	public int add(valoraciones oValoracion);
	public int remove(valoraciones oValoracion);
    public List<valoraciones> ListaTotal ();
    public List<valoraciones> ListaXPeticion (Peticion oPeticion);
	public byte ContadorValoracion();
}
