package Controllador.Tipo_estados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Controllador.ConexionBaseDatos;
import modelo.tipo_estados.TipoUsuario;

public class TipoUsuarioController implements iTipoUsuarioController{

	@Override
	public int add(TipoUsuario oTipoUsuario) {
		String sql = "INSERT INTO tipo_de_usuario VALUES (\""+oTipoUsuario.getNombreUsuario()+"\")";
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
	public int remove(TipoUsuario oTipoUsuario) {
		String sql = "DELETE FROM tipo_de_usuario WHERE Nombre_Tipo_usuario LIKE \""+ oTipoUsuario.getNombreUsuario()+"\"";
		return ConexionBaseDatos.executeUpdate(sql);		
	}
	
	@Override
	public int existeTipoUsuario(TipoUsuario oTipoUsuario) {
		String sql = "SELECT COUNT(*) FROM tipo_de_usuario WHERE Nombre_Tipo_usuario LIKE \""+"EMPRESARIO"+"\"";
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
	public List<TipoUsuario> ListaDeLosTipoUsuario(TipoUsuario oTU){
		List<TipoUsuario> LTU = new ArrayList<TipoUsuario>();
		String sql = "SELECT * FROM tipo_de_usuario";
		Statement stm = null;
		try {
		    stm = ConexionBaseDatos.getConnection().createStatement();
		    ResultSet rs = stm.executeQuery(sql);
		    while (rs.next()) {
		    LTU.add(new TipoUsuario(rs.getString(1)));
		    }
		    stm.close();
		} catch (SQLException e) {
			LTU = null;
		}		
		return LTU;
	}
}
