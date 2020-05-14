package Controllador.Tipo_estados;

import java.util.List;

import modelo.tipo_estados.EstadoPeticion;

public interface iEstadoPeticionController {

	public int add(EstadoPeticion oEP);
	public int remove(EstadoPeticion oEP);
	public int existe(EstadoPeticion oEP);
	public List<EstadoPeticion> Lista();
	
}
