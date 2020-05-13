package Controllador.general;

import Controllador.ConexionBaseDatos;

public class PaqueteController {

	private TipoUsuarioController tipoUsuario;
	private usuarioController usuario;
	private estadoOfertaController  oEOferta;
	private ofertaController oOferta;
	
	public PaqueteController(String sDatabase) {
		
		tipoUsuario = new TipoUsuarioController();
		usuario = new usuarioController();
		oEOferta = new estadoOfertaController();
		oOferta = new ofertaController();
		new ConexionBaseDatos(sDatabase);	
	}
	
	public TipoUsuarioController getTipoUsuarioctrl () {
		return tipoUsuario;
	}
	
	public usuarioController getUsuarioController() {
		return usuario;
	}
	
	public estadoOfertaController getestadoOfertaController() {
		return oEOferta;
	}
	
	public ofertaController getofertaController() {
		return oOferta;
	}
	
}
