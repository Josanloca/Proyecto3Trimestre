package Controllador.Tipo_estados;

import java.util.List;

import modelo.tipo_estados.TipoUsuarioValorado;

public interface iTipoUsuarioValoradoController {

	public int add(TipoUsuarioValorado oTUV);
	public int remove(TipoUsuarioValorado oTUV);
    public List<TipoUsuarioValorado> ListaTUVTodos ();
    public List<TipoUsuarioValorado> ListaTUV (TipoUsuarioValorado oTUV);
    
}
