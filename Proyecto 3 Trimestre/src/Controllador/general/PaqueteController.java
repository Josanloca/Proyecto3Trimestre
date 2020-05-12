package Controllador.general;

import Controllador.ConexionBaseDatos;

public class PaqueteController {

	private TipoUsuarioController tipoUsuario;
	private usuarioController usuario;
	
	public PaqueteController(String sDatabase) {
		
		tipoUsuario = new TipoUsuarioController();
		usuario = new usuarioController();
		new ConexionBaseDatos(sDatabase);	
	}
	
	public TipoUsuarioController getTipoUsuarioctrl () {
		return tipoUsuario;
	}
	
	public usuarioController getUsuarioController() {
		return usuario;
	}
	
}
