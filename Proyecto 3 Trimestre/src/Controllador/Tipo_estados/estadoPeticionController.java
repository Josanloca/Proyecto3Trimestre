package Controllador.Tipo_estados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controllador.ConexionBaseDatos;
import modelo.tipo_estados.EstadoPeticion;

public class estadoPeticionController implements iEstadoPeticionController{

	@Override
	public int add(EstadoPeticion oEP) {
		String sql = "INSERT INTO estado_peticion VALUES (\""+oEP.getsEstadoPeticion()+"\")";		
		System.out.println(sql);
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
	public int remove(EstadoPeticion oEP) {
		String sql = "DELETE FROM estado_peticion WHERE nombre_tipo_peticion LIKE (\""+oEP.getsEstadoPeticion()+"\")";		
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
	public int existe(EstadoPeticion oEP) {
    	String sql = "SELECT COUNT(*) FROM estado_peticion WHERE nombre_tipo_peticion LIKE \"" + oEP.getsEstadoPeticion() + "\"";
    	System.out.println(sql);
    	return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
	public List<EstadoPeticion> Lista() {
		List<EstadoPeticion> LEP = new ArrayList<EstadoPeticion>();
		String sql = "SELECT * FROM estado_peticion";
		Statement stm = null;
		try {
		    stm = ConexionBaseDatos.getConnection().createStatement();
		    ResultSet rs = stm.executeQuery(sql);
		    while (rs.next()) {
		    String sEstadoO = rs.getString(1);
		    LEP.add(new EstadoPeticion(sEstadoO));
		    }
		    stm.close();
		} catch (SQLException e) {
			LEP = null;
		}		
		return LEP;
	}
	
	
	
}