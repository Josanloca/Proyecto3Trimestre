package views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controllador.ConexionBaseDatos;
import Controllador.general.PaqueteController;
import Limites.iLimitesGenerales;
import Valida.ValidaLibrary;
import modelo.Peticion;
import modelo.oferta;
import modelo.usuario;
import modelo.tipo_estados.EstadoOferta;
import modelo.tipo_estados.EstadoPeticion;

public class PeticionViews {
	
	public static byte ContadorPeticion() {
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

	public static Peticion EntradaPeticion(PaqueteController Controllador,usuario oUsuario) {
		Peticion oPeticion = null,oObjeto2;
		oferta oOferta =null;
		boolean bEC = true;
		int iIdPeticion=0,iPrecio=0,iIdOferta=0;
		String sDescripcion = null, sContraseña = null,iUsuarioPeticion= null,sEstadoPeticion=null;
		System.out.println("Para crear una peticion, por favor rellene los siguientes campos: ");
		
		while(bEC) {
		    try {
		    iIdPeticion = ContadorPeticion()+1;
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la id: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC= true;
		
		while(bEC) {
		    try {
		    sDescripcion = ValidaLibrary.leer("Introduzca un titulo con una descripccion del trabajo que pide: ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la Descripcion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		    
			bEC= true;
			
			while(bEC) {
			    try {
			    	iPrecio = (int) ValidaLibrary.valida("Dime que cantidad de dinero pagarias por este trabajo: ", 1, 9999, 1);
			    bEC = false;
			    } catch(Exception ex) {
				System.out.println("Error en la Precio: " + ex.getMessage()+"\n");
				System.out.println("Intentelo de nuevo \n");
			    } 
			 
			}

					bEC = true;
					
					while(bEC) {
					    try {
					    sEstadoPeticion = "ESPERA";
					    bEC = false;
					    } catch(Exception ex) {
						System.out.println("Error en la introduccion del Estado Peticion: " + ex.getMessage()+"\n");
						System.out.println("Intentelo de nuevo \n");
					    }
					}

					bEC = true;
					
					while(bEC) {
					    try {
					    oOferta = Controllador.getofertaController().inicioPeticionConOferta();
					    bEC = false;
					    } catch(Exception ex) {
						System.out.println("Error en idOferta: " + ex.getMessage()+"\n");
						System.out.println("Intentelo de nuevo \n");
					    }
					}
					
					EstadoPeticion oEP = new EstadoPeticion(sEstadoPeticion);
		    
					oObjeto2 = new Peticion(iIdPeticion,sDescripcion,iPrecio,oUsuario,oEP,oOferta);
					
					if(Controllador.getpeticionController().add(oObjeto2) > 0) {
						oPeticion = oObjeto2;
						System.out.println("peticion realizada correctamente");
					}				
		return oPeticion;
	}

}
