package Controllador.general;

import Controllador.ConexionBaseDatos;

public class PaqueteController {

	private TipoUsuarioController tipoUsuario;
	
	public PaqueteController(String sDatabase) {
		
		tipoUsuario = new TipoUsuarioController();
		new ConexionBaseDatos(sDatabase);	
	}
	
	public TipoUsuarioController getTipoUsuarioctrl () {
		return tipoUsuario;
	}
	
}
