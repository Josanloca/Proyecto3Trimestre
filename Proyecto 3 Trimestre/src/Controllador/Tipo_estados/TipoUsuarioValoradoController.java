package Controllador.Tipo_estados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controllador.ConexionBaseDatos;
import modelo.tipo_estados.TipoUsuarioValorado;

public class TipoUsuarioValoradoController {

	public int add(TipoUsuarioValorado oTUV) {
		String sql = "INSERT INTO tipo_de_usuario_valorado VALUES (\""+oTUV.getTipoUsuarioValorado()+"\")";
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	public int remove(TipoUsuarioValorado oTUV) {
		String sql = "DELETE FROM tipo_de_usuario_valorado WHERE nombre_tipo_usuario_valorado LIKE \""+oTUV.getTipoUsuarioValorado()+"\"";
		System.out.println(sql);
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
    public List<TipoUsuarioValorado> ListaTUVTodos () {
		
	List<TipoUsuarioValorado> lTipoUsuarioValorado = new ArrayList<TipoUsuarioValorado>();	
	String sql = "SELECT * FROM tipo_de_usuario_valorado";
	System.out.println(sql);
	Statement stm = null;
	
	try {
	    stm = ConexionBaseDatos.getConnection().createStatement();
	    
	    ResultSet rs = stm.executeQuery(sql);
	    
	    while (rs.next()) {	    	
	    String bId_Peticion = rs.getString(1);		
		lTipoUsuarioValorado.add(new TipoUsuarioValorado(bId_Peticion));
	    }
	    stm.close();
	} catch (SQLException e) {
		lTipoUsuarioValorado = null;
	}	
	return lTipoUsuarioValorado;	
    }
    
    public List<TipoUsuarioValorado> ListaTUV (TipoUsuarioValorado oTUV) {
		
	List<TipoUsuarioValorado> lTipoUsuarioValorado = new ArrayList<TipoUsuarioValorado>();	
	String sql = "SELECT * FROM tipo_de_usuario_valorado WHERE nombre_tipo_usuario_valorado LIKE \""+oTUV.getTipoUsuarioValorado()+"\"";
	System.out.println(sql);
	Statement stm = null;
	
	try {
	    stm = ConexionBaseDatos.getConnection().createStatement();
	    
	    ResultSet rs = stm.executeQuery(sql);
	    
	    while (rs.next()) {	    	
	    String bId_Peticion = rs.getString(1);		
		lTipoUsuarioValorado.add(new TipoUsuarioValorado(bId_Peticion));
	    }
	    stm.close();
	} catch (SQLException e) {
		lTipoUsuarioValorado = null;
	}	
	return lTipoUsuarioValorado;	
    }
}
