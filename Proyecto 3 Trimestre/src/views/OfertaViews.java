package views;

import java.util.List;
import Controllador.general.PaqueteController;
import Limites.iLimitesGenerales;
import Valida.ValidaLibrary;
import modelo.Peticion;
import modelo.oferta;
import modelo.usuario;
import modelo.tipo_estados.EstadoOferta;

public class OfertaViews implements iLimitesGenerales{

	public static boolean EntradaOferta(PaqueteController Controllador,usuario oUsuario, Peticion oPeticion) {
		oferta oOferta = null;	
		usuario oUsuarioOferta = null;
		boolean bEC = true,bExito =false;
		int id_Oferta=0,PrecioOferta=0;
		String DescOferta = null,sEO=null;
		
		System.out.println("Para crear su oferta por favor rellene los siguientes campos: ");
		
		while(bEC) {
		    try {
		    id_Oferta = Controllador.getofertaController().ContadorOferta()+1;
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la id: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC= true;
		
		while(bEC) {
		    try {
		    DescOferta = ValidaLibrary.leer("Introduzca una respuesta a la peticion: ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la Descripcion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC= true;
		
		while(bEC) {
		    try {
		    PrecioOferta = (int) ValidaLibrary.valida("Introduzca su oferta(dinero): ", LIMITEONE, LIMITEPRECMAX, LIMITEONE);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en introduccion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC= true;
		
		while(bEC) {
		    try {
		    oUsuarioOferta = oUsuario;
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en introduccion del usuario: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC = true;
		
		while(bEC) {
		    try {
		    	sEO ="ESPERA";
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del estado: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		EstadoOferta oEO = new EstadoOferta(sEO);
		oOferta = new oferta(id_Oferta,DescOferta,PrecioOferta,oUsuarioOferta,oEO,oPeticion);
		
		if(Controllador.getofertaController().add(oOferta)>LIMITEZEROVIEWS) {
			System.out.println("Introduccion correctar");
			bExito =true;
		}else {
			System.out.println("Introduccion Erronea");
		}
		return bExito;
	}

	/*
	public static void seleccionarPeticion(PaqueteController Controllador,usuario oUsuario) {
		boolean bEC = true;
		Peticion oPeticion = null;
		int iDato =0;
		System.out.println("******************************* \n");
		System.out.println(Controllador.getpeticionController().ListaPeticionSinContarte(oUsuario));

		while(bEC) {
		    try {
		    iDato = (int) ValidaLibrary.valida("Dime el id de la peticion a la que quieres realizar una oferta: ", 1, Controllador.getpeticionController().ListaPeticionSinContarte(oUsuario).size(), 1);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		oPeticion = new Peticion(iDato);
		
		if(Controllador.getpeticionController().ActualizarPeticionAñadiendoOferta(oPeticion) >0) {
			System.out.println("Borrado realizado");
		}else {
			System.out.println("Borrado no realizado");
		}
		
	}
*/
	
	public static void MostrarPeticionesPropias(PaqueteController Controllador,usuario oUsuario) {
		System.out.println("Aqui tiene una lista de sus peticiones \n");
		System.out.println(Controllador.getofertaController().ListaOfertaXDNI(oUsuario));
	}
	
	public static void BorrarOferta(PaqueteController Controllador,usuario oUsuario) {
		List<oferta> lOferta = Controllador.getofertaController().ListaOfertaXDNI(oUsuario);	
		boolean bEC = true;
		oferta oOferta = null;
		int iDato =0;
		System.out.println("Escriba el id de la peticion que quiere borrar \n");
		System.out.println(lOferta);

		while(bEC) {
		    try {
		    iDato = (int) ValidaLibrary.valida("Introduce el id de la oferta que quieres borrar", lOferta.get(0).getId_Oferta(), lOferta.get(lOferta.size()-LIMITEONE).getId_Oferta(),LIMITEONE);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		oOferta = new oferta(iDato);
		
		if(Controllador.getofertaController().remove(oOferta) >LIMITEZEROVIEWS) {
			System.out.println("Borrado realizado");
		}else {
			System.out.println("Borrado no realizado");
		}
	}
	
}
