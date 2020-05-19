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
import modelo.tipo_estados.EstadoOferta;

public class ofertaController implements iOfertaController{

	@Override
	public int add (oferta oOferta) {
		String sql = "INSERT INTO oferta VALUES ("+oOferta.getId_Oferta()+",\""+oOferta.getDescOferta()+"\","+oOferta.getPrecioOferta()+",\""+oOferta.getoUsuarioOferta().getsDni_nif()+"\",\""+oOferta.getoEstadoOferta().getsEstadoOferta()+"\","+oOferta.getoPeticion().getiIdPeticion()+")";
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
	public int remove (oferta oOferta) {
		String sql = "DELETE FROM oferta WHERE id_Oferta = "+oOferta.getId_Oferta();
		System.out.println(sql);
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
    public int existeOferta (oferta oOferta) {
    	String sql = "SELECT COUNT(*) FROM oferta WHERE id_Oferta LIKE \"" +oOferta.getId_Oferta()+ "\"";
    	//System.out.println(sql);
    	return ConexionBaseDatos.executeCount(sql);
    }
    
	@Override
    public List<oferta> ListaXPeticion (oferta oOferta) {
		
	List<oferta> lOferta = new ArrayList<oferta>();	
	String sql = "SELECT * FROM oferta WHERE usuario_oferta=\"" + oOferta.getoUsuarioOferta().getsDni_nif()+"\"";

	Statement stm = null;
	
	try {
	    stm = ConexionBaseDatos.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery(sql);
	    while (rs.next()) {
	    byte bId_Oferta = (byte)rs.getInt(1);
		String sDescOferta = rs.getString(2);
		int bPrecio = (int)rs.getInt(3);
		String sUsuario = rs.getString(4);
		String sEO = rs.getString(5);
		byte bId_Peticion = (byte)rs.getInt(6);
		usuario oUsuario = new usuario(sUsuario);	
		EstadoOferta oEO = new EstadoOferta(sEO);
		Peticion oPeticion = new Peticion(bId_Peticion);
		
		lOferta.add(new oferta(bId_Oferta,sDescOferta,bPrecio,oUsuario,oEO,oPeticion));
	    }
	    stm.close();
	} catch (SQLException e) {
		lOferta = null;
	}

	return lOferta;	
    }
    
    public List<oferta> ListaOfertaXDNI (usuario oUsuario) {
		
	List<oferta> lOferta = new ArrayList<oferta>();	
	String sql = "SELECT * FROM oferta WHERE usuario_oferta=\"" + oUsuario.getsDni_nif()+"\"";
	String sqlComprobador = "SELECT COUNT(*) FROM oferta WHERE usuario_oferta LIKE \"" +oUsuario.getsDni_nif()+ "\"";
	
	if(ConexionBaseDatos.executeCount(sqlComprobador)>0) {
	Statement stm = null;
	
	try {
	    stm = ConexionBaseDatos.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery(sql);
	    while (rs.next()) {
	    byte bId_Oferta = (byte)rs.getInt(1);
		String sDescOferta = rs.getString(2);
		int bPrecio = (int)rs.getInt(3);
		String sUsuario = rs.getString(4);
		String sEO = rs.getString(5);
		byte bId_Peticion = (byte)rs.getInt(6);
		usuario oUsuario2 = new usuario(sUsuario);	
		EstadoOferta oEO = new EstadoOferta(sEO);
		Peticion oPeticion = new Peticion(bId_Peticion);
		
		lOferta.add(new oferta(bId_Oferta,sDescOferta,bPrecio,oUsuario2,oEO,oPeticion));
	    }
	    stm.close();
	} catch (SQLException e) {
		lOferta = null;
	}
	}else {
		System.out.println("ERROR. No existe ninguna oferta con ese dni");
	}
	return lOferta;	
    }
    
	public oferta inicioPeticionConOferta() {
		oferta oOferta = null,oObjeto2=null;
		String sql = "SELECT * FROM oferta WHERE id_Oferta LIKE 10";
		Statement stm = null;

		try {
		    stm = ConexionBaseDatos.getConnection().createStatement();
		    ResultSet rs = stm.executeQuery(sql);
		    while (rs.next()) {
		    byte bId_Oferta = (byte)rs.getInt(1);
			String sDescOferta = rs.getString(2);
			byte bPrecio = (byte)rs.getInt(3);
			String sUsuario = rs.getString(4);
			String sEO = rs.getString(5);
			byte bId_Peticion = (byte)rs.getInt(6);
			usuario oUsuario = new usuario(sUsuario);	
			EstadoOferta oEO = new EstadoOferta(sEO);		
			Peticion oPeticion = new Peticion(bId_Peticion);

			oObjeto2 =new oferta(bId_Oferta,sDescOferta,bPrecio,oUsuario,oEO,oPeticion);
		    }
			if(existeOferta(oObjeto2) >0) {
				oOferta = oObjeto2;
			}
		    
		    stm.close();
		} catch (SQLException e) {
			oOferta = null;
		}
		
		return oOferta;
	}

	public byte ContadorOferta() {
		byte bResultado=0;
		Statement stm = null;

		String sql = "SELECT MAX(id_Oferta) FROM oferta WHERE id_Oferta NOT LIKE 10";
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



}
