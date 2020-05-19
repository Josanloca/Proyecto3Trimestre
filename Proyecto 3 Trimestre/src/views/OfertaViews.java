package views;

import Controllador.general.PaqueteController;
import Limites.iLimitesGenerales;
import Valida.ValidaLibrary;
import modelo.oferta;
import modelo.usuario;
import modelo.tipo_estados.EstadoOferta;

public class OfertaViews implements iLimitesGenerales{

	public static void EntradaPeticion(PaqueteController Controllador,usuario oUsuario) {
		oferta oOferta = null;		
		usuario oUsuarioOferta = null;
		EstadoOferta oEstadoOferta = null;
		boolean bEC = true;
		
		int id_Oferta=0,PrecioOferta=0;
		String DescOferta = null,sEO=null;
		
		
		System.out.println("Para crear su oferta sobre este pedido por favor rellene los siguientes campos: ");
		
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
		    PrecioOferta = (int) ValidaLibrary.valida("Introduzca su oferta(dinero): ", 1, LIMITEPRECMAX, 1);
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
		
		oOferta = new oferta(id_Oferta,DescOferta,PrecioOferta,oUsuarioOferta,oEO);
		
		if(Controllador.getofertaController().add(oOferta)>0) {
			System.out.println("Introduccion correctar");
		}else {
			System.out.println("Introduccion Erronea");
		}
		
	}
}
