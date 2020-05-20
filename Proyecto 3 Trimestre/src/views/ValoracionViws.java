package views;

import java.util.List;

import Controllador.general.PaqueteController;
import Valida.ValidaLibrary;
import modelo.Peticion;
import modelo.oferta;
import modelo.usuario;
import modelo.valoraciones;
import modelo.tipo_estados.TipoUsuarioValorado;

public class ValoracionViws {

	public static void EntradaValoracionPeticion(PaqueteController Controllador,usuario oUsuario) {
		List<Peticion> lValoracion =Controllador.getpeticionController().ListaPeticionXDNIXValoracion(oUsuario);
		boolean bEC = true;
		int iIdValoracion = 0;
		byte bPuntuacion = 0,bDato=0,bPeticon =0;
		String sDesValor=null,sTipoUsuario = null;
		System.out.println("Para crear una valoracion, por favor rellene los siguientes campos: ");
		
		if(lValoracion != null) {
		 System.out.println(lValoracion);
		
		while(bEC) {
		    try {
		   
		    bPeticon = (byte) ValidaLibrary.valida("Dime cual de las siguientes peticiones quieres ofrecer una valoracion: ",lValoracion.get(0).getiIdPeticion(),lValoracion.get(lValoracion.size()-1).getiIdPeticion(), 3);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la Descripcion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC= true;
		
		while(bEC) {
		    try {
		    iIdValoracion = Controllador.getvaloracionController().ContadorValoracion()+1;
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la id: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC= true;
		
		while(bEC) {
		    try {
		    bPuntuacion = (byte) ValidaLibrary.valida("¿Dime que nota le darias?: ", 0, 10, 3);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la Descripcion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC= true;
		
		while(bEC) {
		    try {
		    sDesValor =  ValidaLibrary.leer("Introduce alguna descripccion de la valoracion: ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la Descripcion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		bEC = true;
		
		while(bEC) {
		    try {
		    bDato = (byte) ValidaLibrary.valida("¿Que tipo de ususario sera? 1= EMPRESARIO o 2= PARTICULAR : ",1,2,3);
		    
		    if(bDato ==1) {
		    	sTipoUsuario ="EMPRESARIO";
		    }else if(bDato ==2) {
		    	sTipoUsuario ="PARTICULAR";
		    }else {
		    	System.out.println("ERROR VALIDA TIPO USUARIO");
		    }
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del tipo de usuario: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		TipoUsuarioValorado oTPV = new TipoUsuarioValorado(sTipoUsuario);
		
		Peticion oPeticion = new Peticion(bPeticon);
		
		
		valoraciones oValo = new valoraciones(iIdValoracion,bPuntuacion,sDesValor,oPeticion,oTPV);
		
		if(Controllador.getvaloracionController().add(oValo) > 0) {
			System.out.println("Datos introduccidos correctamente");
		}else {
			System.out.println("DATOS NO INTRODUCIDOS CORRECTAMENTE");
		}
		}else {
			System.out.println("No hay ninguna peticion terminada");
		}

	}
	
	public static void FinalizarOfertaYPeticion(PaqueteController Controllador,usuario oUsuario) {
		List<oferta> lOferta =Controllador.getofertaController().ListaOfertaXdniFinalizarPeticion(oUsuario);
		boolean bEC = true;
		int iIdOferta = 0;
		byte bEleccion =0;
		System.out.println("Para terminar una oferta digame cual quieres terminar: ");
		
		if(lOferta != null) {
		 System.out.println(lOferta);
		
		while(bEC) {
		    try {
		   
		    iIdOferta =  (int) ValidaLibrary.valida("¿Dime cual de las siguientes ofertas quieres dar por terminada?: ",lOferta.get(0).getId_Oferta(),lOferta.get(lOferta.size()-1).getId_Oferta(), 1);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la Descripcion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
			}
		
		
		
		if(Controllador.getpeticionController().ActualizarPeticionFinalizada(iIdOferta)>0) {
			System.out.println("Actualizacion realizada");
			System.out.println(Controllador.getofertaController().ActualizarOfertaFinalizacion(iIdOferta));
			
			bEC = true;
			
			while(bEC) {
			    try {
			   
			    bEleccion =  (byte) ValidaLibrary.valida("¿Quiere realizar una valoracion de como ha sido la experiencia de trabajo?(Si = 1 Y No = 2): ",1,2,3);
			    bEC = false;
			    } catch(Exception ex) {
				System.out.println("Error en la Descripcion: " + ex.getMessage()+"\n");
				System.out.println("Intentelo de nuevo \n");
			    }
				}
			if(bEleccion==1) {
				views.ValoracionViws.EntradaValoracionPeticion(Controllador, oUsuario);
			}
		}else {
			System.out.println("Error en al actualizacion");
		}
		
		}else {
			System.out.println("No existe ninguna oferta que puedas termianr");
		}
	}
	
}
