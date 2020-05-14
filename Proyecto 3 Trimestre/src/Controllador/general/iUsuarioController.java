package Controllador.general;

import java.util.List;

import modelo.usuario;

public interface iUsuarioController {

	public int add (usuario oUsuario);
	public int remove (usuario oUsuario);
    public int existeUsuario (usuario oUsuario);
	public List<String> ListaDeLosUsuarioNombre();
}
