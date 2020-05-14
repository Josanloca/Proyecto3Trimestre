package Controllador.Tipo_estados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controllador.ConexionBaseDatos;
import modelo.tipo_estados.EstadoOferta;

public class estadoOfertaController implements iEstadoOfertaController{

	@Override
	public int add(EstadoOferta oEO) {
		String sql = "INSERT INTO estado_oferta VALUES (\""+oEO.getsEstadoOferta()+"\")";		
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
    public int remove(EstadoOferta oEO) {
    	String sql = "DELETE FROM estado_oferta WHERE nombre_tipo_oferta LIKE \""+oEO.getsEstadoOferta()+"\"";
    	return ConexionBaseDatos.executeUpdate(sql);
    }
	
	@Override
    public int existe (EstadoOferta oEO) {
    	String sql = "SELECT COUNT(*) FROM estado_oferta WHERE nombre_tipo_oferta LIKE \"" + oEO.getsEstadoOferta() + "\"";
    	//System.out.println(sql);
    	return ConexionBaseDatos.executeCount(sql);
    }
    
	@Override
	public List<String> Lista() {
		List<String> LTU = new ArrayList<String>();
		String sql = "SELECT * FROM estado_oferta";
		Statement stm = null;
		try {
		    stm = ConexionBaseDatos.getConnection().createStatement();
		    ResultSet rs = stm.executeQuery(sql);
		    while (rs.next()) {
		    LTU.add(rs.getString(1));
		    }
		    stm.close();
		} catch (SQLException e) {
			LTU = null;
		}		
		return LTU;
	}
}