package Controllador.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Controllador.ConexionBaseDatos;
import modelo.usuario;

public class usuarioController implements iUsuarioController{

	@Override
	public int add (usuario oUsuario) {
		String sql = "INSERT INTO usuario VALUES (\""+oUsuario.getsDni_nif()+"\",\""+oUsuario.getsNombre()+"\",\""+oUsuario.getsContraseña()+"\",\""+oUsuario.getFecha().getYear()+"*"+oUsuario.getFecha().getMonthValue()+"*"+oUsuario.getFecha().getDayOfMonth()+"\",\""+oUsuario.getsCorreoElectronico()+"\","+oUsuario.getiTelefono()+",\""+oUsuario.getsDireccion()+"\",\""+oUsuario.getsDescripccion()+"\",\""+oUsuario.getoTipoUsuario().getNombreUsuario()+"\")";
		//System.out.println(sql);
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
	public int remove (usuario oUsuario) {
		String sql = "DELETE FROM usuario WHERE dni_nif LIKE \""+oUsuario.getsDni_nif()+"\"";
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
    public int existeUsuario (usuario oUsuario) {
    	String sql = "SELECT COUNT(*) FROM usuario WHERE dni_nif LIKE \"" + oUsuario.getsDni_nif() + "\"";
    	//System.out.println(sql);
    	return ConexionBaseDatos.executeCount(sql);
    }
    
	@Override
	public List<String> ListaDeLosUsuarioNombre() {
		List<String> LTU = new ArrayList<String>();
		String sql = "SELECT nombre FROM usuario";
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
	
    public int checkUsuarioLogin (usuario oUsuario) {
    	String sql = "SELECT COUNT(*) FROM usuario WHERE correo_Electronico LIKE \"" + oUsuario.getsCorreoElectronico() + "\" AND contraseña LIKE \""+oUsuario.getsContraseña()+"\"";
    	System.out.println(sql);
    	return ConexionBaseDatos.executeCount(sql);
    }
}
