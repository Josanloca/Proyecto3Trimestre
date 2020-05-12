package Controllador.general;

import Controllador.ConexionBaseDatos;
import modelo.tipo_estados.TipoUsuario;

public class TipoUsuarioController {

	
	public int add(TipoUsuario oTipoUsuario) {
		String sql = "INSERT INTO tipo_de_usuario VALUES (\""+oTipoUsuario.getNombreUsuario()+"\")";
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	public int remove(TipoUsuario oTipoUsuario) {
		String sql = "DELETE FROM tipo_de_usuario WHERE Nombre_Tipo_usuario LIKE \""+oTipoUsuario.getNombreUsuario()+"\"";
		return ConexionBaseDatos.executeUpdate(sql);		
	}
	

}
