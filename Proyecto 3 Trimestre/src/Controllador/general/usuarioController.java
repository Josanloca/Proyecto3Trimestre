package Controllador.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Controllador.ConexionBaseDatos;
import modelo.usuario;
import modelo.tipo_estados.TipoUsuario;

public class usuarioController implements iUsuarioController{

	@Override
	public int add (usuario oUsuario) {
		//String sql = "INSERT INTO usuario VALUES (\""+oUsuario.getsDni_nif()+"\",\""+oUsuario.getsNombre()+"\",\""+oUsuario.getsContraseña()+"\",\""+oUsuario.getFecha().getYear()+"*"+oUsuario.getFecha().getMonthValue()+"*"+oUsuario.getFecha().getDayOfMonth()+"\",\""+oUsuario.getsCorreoElectronico()+"\","+oUsuario.getiTelefono()+",\""+oUsuario.getsDireccion()+"\",\""+oUsuario.getsDescripccion()+"\",\""+oUsuario.getoTipoUsuario().getNombreUsuario()+"\")";
		String sql = "INSERT INTO usuario VALUES (\""+oUsuario.getsDni_nif()+"\",\"";
		sql += oUsuario.getsNombre()+"\",\"";
		sql += oUsuario.getsContraseña()+"\",\"";
		sql += oUsuario.getFecha().getYear()+"*"+oUsuario.getFecha().getMonthValue()+"*"+oUsuario.getFecha().getDayOfMonth()+"\",\"";
		sql += oUsuario.getsCorreoElectronico()+"\",";
		sql += oUsuario.getiTelefono()+",\"";	
		sql += oUsuario.getsDireccion()+"\",\"";
		sql += oUsuario.getsDescripccion()+"\",\"";
		sql += oUsuario.getoTipoUsuario().getNombreUsuario()+"\")";

		System.out.println(sql);
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
	
	@Override
    public int checkUsuarioLogin (usuario oUsuario) {
    	String sql = "SELECT COUNT(*) FROM usuario WHERE correo_Electronico = \"" + oUsuario.getsCorreoElectronico() + "\" AND contraseña = \""+oUsuario.getsContraseña()+"\"";
  
    	return ConexionBaseDatos.executeCount(sql);
    }
    
    //GeneradorDeUsuarioCompletoAlEntrar
    
	@Override
	public usuario GDUCAE(usuario oUsuario) {
		usuario oObjeto=null;
		String sql = "SELECT * FROM usuario WHERE Correo_Electronico LIKE \"" + oUsuario.getsCorreoElectronico() + "\"";
		
		Statement stm = null;

		try {
		    stm = ConexionBaseDatos.getConnection().createStatement();
		    ResultSet rs = stm.executeQuery(sql);
		    while (rs.next()) {
		    String sDni_nif = rs.getString(1);
			String sNombre = rs.getString(2);
			String sContraseña = rs.getString(3);
			String sCorreoElectronico = rs.getString(5);
			int iTelefono = (int)rs.getInt(6);
			String sDireccion = rs.getString(7);
			String sDescripccion = rs.getString(8);
			String sTipoUsuario = rs.getString(9);
				
			TipoUsuario oTipoUsuario = new TipoUsuario(sTipoUsuario);
		    
			oObjeto =new usuario(sDni_nif,sNombre,sContraseña,sCorreoElectronico,iTelefono,sDireccion,sDescripccion,oTipoUsuario);
		    }		    
		    stm.close();
		} catch (SQLException e) {
			oObjeto = null;
		}catch(NullPointerException Nex){
			System.out.println(Nex.getMessage()+"\n");	
			oObjeto = null;
		}
		return oObjeto;
	}
}
