package Controllador.general;

import Controllador.ConexionBaseDatos;
import Controllador.Tipo_estados.TipoUsuarioController;
import Controllador.Tipo_estados.estadoOfertaController;
import Controllador.Tipo_estados.estadoPeticionController;

public class PaqueteController {

	private TipoUsuarioController tipoUsuario;
	private usuarioController usuario;
	private estadoOfertaController  oEOferta;
	private ofertaController oOferta;
	private estadoPeticionController oEP;
	private peticionController oPeticion;
	private TipoUsuarioValoradoController oTUV;
	
	public PaqueteController(String sDatabase) {		
		tipoUsuario = new TipoUsuarioController();
		usuario = new usuarioController();
		oEOferta = new estadoOfertaController();
		oOferta = new ofertaController();
		oEP = new estadoPeticionController();
		oPeticion = new peticionController();
		oTUV = new TipoUsuarioValoradoController();
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
	
	public estadoPeticionController getestadoPeticionController() {
		return oEP;
	}
	
	public peticionController getpeticionController() {
		return oPeticion;
	}
	
	public TipoUsuarioValoradoController getTipoUsuarioValoradoController() {
		return oTUV;
	}
	
}
