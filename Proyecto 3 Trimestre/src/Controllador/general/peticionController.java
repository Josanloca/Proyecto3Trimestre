package Controllador.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controllador.ConexionBaseDatos;
import modelo.Peticion;
import modelo.oferta;
import modelo.usuario;
import modelo.tipo_estados.EstadoPeticion;

public class peticionController implements iPeticionController{

	@Override
	public int add(Peticion oPeticion) {
		String sql = "INSERT INTO peticion VALUES ("+oPeticion.getiIdPeticion();
		sql += ",\""+oPeticion.getsDescripcion();
		sql += "\","+oPeticion.getiPrecio();
		sql += ",\""+oPeticion.getoUsuarioPeticion().getsDni_nif();
		sql += "\","+oPeticion.getoIdOferta().getId_Oferta();
		sql += ",\""+oPeticion.getoEstadoPeticion().getsEstadoPeticion()+"\")";		
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
	public int remove(Peticion oPeticion) {
		String sql = "DELETE FROM peticion WHERE id_peticion LIKE \""+oPeticion.getiIdPeticion()+"\"";
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
    public int existePeticio (Peticion oPeticion) {
    	String sql = "SELECT COUNT(*) FROM peticion WHERE id_peticion LIKE \""+oPeticion.getiIdPeticion()+"\"";
    	//System.out.println(sql);
    	return ConexionBaseDatos.executeCount(sql);
    }
	
	@Override
    public List<Peticion> ListaPeticionToda () {
		
	List<Peticion> lPeticion = new ArrayList<Peticion>();	
	String sql = "SELECT * FROM peticion";
	Statement stm = null;
	
	try {
	    stm = ConexionBaseDatos.getConnection().createStatement();
	    
	    ResultSet rs = stm.executeQuery(sql);
	    
	    while (rs.next()) {
	    	
	    byte bId_Peticion = (byte) rs.getInt(1);
		String sDescPeticion = rs.getString(2);
		byte bPrecio = (byte)rs.getInt(3);
		String sUsuario = rs.getString(4);
		byte bidOferta = (byte)rs.getInt(5);
		String sEP = rs.getString(6);
		
		usuario oUsuario = new usuario(sUsuario);

		EstadoPeticion oEP = new EstadoPeticion(sEP);
		oferta oOferta = new oferta(bidOferta);

		lPeticion.add(new Peticion(bId_Peticion,sDescPeticion,bPrecio,oUsuario,oEP,oOferta));
	    }
	    stm.close();
	} catch (SQLException e) {
		lPeticion = null;
	}	
	return lPeticion;	
    }
	
	public List<Peticion> ListaPeticionNoFinalizadas(usuario oUsuario) {
		
		List<Peticion> lPeticion = new ArrayList<Peticion>();	
		String sql = "SELECT * FROM peticion WHERE nombre_estado_peticion LIKE \"ESPERA\" AND usuario_Peticion NOT LIKE \""+oUsuario.getsDni_nif()+"\"";
		Statement stm = null;
		
		try {
		    stm = ConexionBaseDatos.getConnection().createStatement();
		    
		    ResultSet rs = stm.executeQuery(sql);
		    
		    while (rs.next()) {
		    	
		    byte bId_Peticion = (byte) rs.getInt(1);
			String sDescPeticion = rs.getString(2);
			int bPrecio = (int) rs.getInt(3);
			String sUsuario = rs.getString(4);
			byte bidOferta = (byte)rs.getInt(5);
			String sEP = rs.getString(6);
			
			usuario oU = new usuario(sUsuario);
			EstadoPeticion oEP = new EstadoPeticion(sEP);
			oferta oOferta = new oferta(bidOferta);

			lPeticion.add(new Peticion(bId_Peticion,sDescPeticion,bPrecio,oU,oEP,oOferta));
		    }
		    stm.close();
		} catch (SQLException e) {
			lPeticion = null;
		}	
		return lPeticion;	
	    }
   
	public byte ContadorPeticion() {
		byte bResultado=0;
		Statement stm = null;

		String sql = "SELECT MAX(id_Peticion) FROM peticion";
		try {
		    stm = ConexionBaseDatos.getConnection().createStatement();
		    ResultSet rs = stm.executeQuery(sql);
		    while (rs.next()) {
		    bResultado = (byte)rs.getInt(1);
		    }
		    stm.close();
		} catch (SQLException e) {
			bResultado = 0;
		}		
		return bResultado;
	}
	
    public List<Peticion> ListaPeticionXDNI(usuario oUsuario) {
		
	List<Peticion> lPeticion = new ArrayList<Peticion>();	
	String sql = "SELECT * FROM peticion WHERE usuario_Peticion LIKE \""+oUsuario.getsDni_nif()+"\"";
	Statement stm = null;
	
	try {
	    stm = ConexionBaseDatos.getConnection().createStatement();
	    
	    ResultSet rs = stm.executeQuery(sql);
	    
	    while (rs.next()) {
	    	
	    byte bId_Peticion = (byte) rs.getInt(1);
		String sDescPeticion = rs.getString(2);
		int bPrecio = (int) rs.getInt(3);
		String sUsuario = rs.getString(4);
		byte bidOferta = (byte)rs.getInt(5);
		String sEP = rs.getString(6);
		
		usuario oUser = new usuario(sUsuario);
		EstadoPeticion oEP = new EstadoPeticion(sEP);
		oferta oOferta = new oferta(bidOferta);

		lPeticion.add(new Peticion(bId_Peticion,sDescPeticion,bPrecio,oUser,oEP,oOferta));
	    }
	    stm.close();
	} catch (SQLException e) {
		lPeticion = null;
	}	
	return lPeticion;	
    }
	
    public List<Peticion> ListaPeticionSinContarte(usuario oUsuario) {
		
    	List<Peticion> lPeticion = new ArrayList<Peticion>();	
    	String sql = "SELECT * FROM peticion WHERE usuario_Peticion NOT LIKE \""+oUsuario.getsDni_nif()+"\" AND";
    	Statement stm = null;
    	
    	try {
    	    stm = ConexionBaseDatos.getConnection().createStatement();
    	    
    	    ResultSet rs = stm.executeQuery(sql);
    	    
    	    while (rs.next()) {
    	    	
    	    byte bId_Peticion = (byte) rs.getInt(1);
    		String sDescPeticion = rs.getString(2);
    		int bPrecio = (int) rs.getInt(3);
    		String sUsuario = rs.getString(4);
    		byte bidOferta = (byte)rs.getInt(5);
    		String sEP = rs.getString(6);
    		
    		usuario oUser = new usuario(sUsuario);
    		EstadoPeticion oEP = new EstadoPeticion(sEP);
    		oferta oOferta = new oferta(bidOferta);

    		lPeticion.add(new Peticion(bId_Peticion,sDescPeticion,bPrecio,oUser,oEP,oOferta));
    	    }
    	    stm.close();
    	} catch (SQLException e) {
    		lPeticion = null;
    	}	
    	return lPeticion;	
        }
    

    
    public int ActualizarPeticionAñadiendoOferta (Peticion oPeticion) {
    	String sql = "UPDATE peticion ";
    	sql +="SET nombre_estado_Peticion = \"PROCESANDO\"";
    	sql	+=	"WHERE id_peticion = "+oPeticion.getiIdPeticion();
    	return ConexionBaseDatos.executeUpdate(sql);
    }
    
    
    
}
