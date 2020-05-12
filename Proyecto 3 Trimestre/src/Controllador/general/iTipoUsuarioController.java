package Controllador.general;

import java.util.List;

import modelo.tipo_estados.TipoUsuario;

public interface iTipoUsuarioController {

	public int add(TipoUsuario oTipoUsuario);
	public int remove(TipoUsuario oTipoUsuario);
	public int existeTipoUsuario(TipoUsuario oTipoUsuario);
	public List<TipoUsuario> ListaDeLosTipoUsuario(TipoUsuario oTU);
}
