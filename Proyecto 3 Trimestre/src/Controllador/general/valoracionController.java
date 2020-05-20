package Controllador.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controllador.ConexionBaseDatos;
import modelo.Peticion;
import modelo.valoraciones;
import modelo.tipo_estados.TipoUsuarioValorado;

public class valoracionController implements iValoracionController{

	@Override
	public int add(valoraciones oValoracion) {
		String sql = "INSERT INTO valoracion VALUES ("+oValoracion.getiIdValoracion();
		sql += ","+oValoracion.getbPuntuacion();
		sql += ",\""+oValoracion.getsDesValor();
		sql += "\","+oValoracion.getoPeticion().getiIdPeticion();
		sql += ",\""+oValoracion.getTuv().getTipoUsuarioValorado()+"\")";
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
	@Override
	public int remove(valoraciones oValoracion) {
		String sql = "DELETE FROM valoracion WHERE id_valoracion LIKE "+oValoracion.getiIdValoracion();
		return ConexionBaseDatos.executeUpdate(sql);
	} 
	
	@Override
    public List<valoraciones> ListaTotal () {
		
	List<valoraciones> lvaloraciones = new ArrayList<valoraciones>();	
	String sql = "SELECT * FROM valoracion ";

	Statement stm = null;
	
	try {
	    stm = ConexionBaseDatos.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery(sql);
	    while (rs.next()) {
	    byte bId_Valoracion = (byte)rs.getInt(1);
		byte bPuntuacion =(byte) rs.getInt(2);
		String sDesc = rs.getString(3);
		byte bIdPeticion= (byte) rs.getInt(4);
		String sNEP = rs.getString(5);
		
		Peticion oPeticion = new Peticion(bIdPeticion);
		System.out.println(oPeticion.getiIdPeticion());
		TipoUsuarioValorado oTUV = new TipoUsuarioValorado(sNEP);

		lvaloraciones.add(new valoraciones(bId_Valoracion,bPuntuacion,sDesc,oPeticion,oTUV));
	    }
	    stm.close();
	} catch (SQLException e) {
		lvaloraciones = null;
	}	
	return lvaloraciones;	
    }
	
    @Override
    public List<valoraciones> ListaXPeticion (Peticion oPeticion) {
		
	List<valoraciones> lvaloraciones = new ArrayList<valoraciones>();	
	String sql = "SELECT * FROM valoracion WHERE id_Peticion =" +oPeticion.getiIdPeticion();

	Statement stm = null;
	
	try {
	    stm = ConexionBaseDatos.getConnection().createStatement();
	    ResultSet rs = stm.executeQuery(sql);
	    while (rs.next()) {
	    byte bId_Valoracion = (byte)rs.getInt(1);
		byte bPuntuacion =(byte) rs.getInt(2);
		String sDesc = rs.getString(3);
		byte bIdPeticion= (byte) rs.getInt(4);
		String sNEP = rs.getString(5);
		
		Peticion oPeticion2 = new Peticion(bIdPeticion);
		TipoUsuarioValorado oTUV = new TipoUsuarioValorado(sNEP);

		lvaloraciones.add(new valoraciones(bId_Valoracion,bPuntuacion,sDesc,oPeticion2,oTUV));
	    }
	    stm.close();
	} catch (SQLException e) {
		lvaloraciones = null;
	}	
	return lvaloraciones;	
    }
	
    @Override
	public byte ContadorValoracion() {
		byte bResultado=0;
		Statement stm = null;

		String sql = "SELECT MAX(id_valoracion) FROM valoracion";
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
