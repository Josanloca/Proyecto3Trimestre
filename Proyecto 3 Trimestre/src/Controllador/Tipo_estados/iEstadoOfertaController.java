package Controllador.Tipo_estados;

import java.util.List;

import modelo.tipo_estados.EstadoOferta;

public interface iEstadoOfertaController {

	public int add(EstadoOferta oEO);
    public int remove(EstadoOferta oEO);
    public int existe (EstadoOferta oEO);
	public List<String> Lista();
	
}
