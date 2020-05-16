package Controllador.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controllador.ConexionBaseDatos;
import Controllador.Tipo_estados.iPeticionController;
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
		return ConexionBaseDatos.executeCount(sql);
	}
	
	@Override
	public int remove(Peticion oPeticion) {
		String sql = "DELETE FROM peticion WHERE id_peticion LIKE \""+oPeticion.getiIdPeticion()+"\"";
		return ConexionBaseDatos.executeCount(sql);
	}
	
	@Override
    public List<Peticion> ListaPeticionToda (usuario oUser) {
		
	List<Peticion> lPeticion = new ArrayList<Peticion>();	
	String sql = "SELECT * FROM peticion";
	System.out.println(sql);
	Statement stm = null;
	
	try {
	    stm = ConexionBaseDatos.getConnection().createStatement();
	    
	    ResultSet rs = stm.executeQuery(sql);
	    
	    while (rs.next()) {
	    	
	    byte bId_Peticion = (byte) rs.getInt(1);
		String sDescPeticion = rs.getString(2);
		byte bPrecio = (byte)rs.getInt(3);
		String sUsuario = rs.getString(4);
		System.out.println(sUsuario);
		byte bidOferta = (byte)rs.getInt(5);
		System.out.println(bidOferta);
		String sEP = rs.getString(6);
		System.out.println(sEP);
		
		usuario oUsuario = new usuario(sUsuario);	
		System.out.println("vale: "+oUsuario.getsDni_nif());
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
    
}
