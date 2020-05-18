package Controllador.general;

import java.util.List;

import modelo.Peticion;
import modelo.usuario;

public interface iPeticionController {

	public int add(Peticion oPeticion);
	public int remove(Peticion oPeticion);
    public List<Peticion> ListaPeticionToda ();
    
}
