package views;



import Controllador.general.PaqueteController;
import Valida.ValidaLibrary;
import modelo.Peticion;
import modelo.oferta;
import modelo.usuario;
import modelo.tipo_estados.EstadoPeticion;

public class PeticionViews {
	


	public static Peticion EntradaPeticion(PaqueteController Controllador,usuario oUsuario) {
		Peticion oPeticion = null,oObjeto2;
		oferta oOferta =null;
		boolean bEC = true;
		int iIdPeticion=0,iPrecio=0;
		String sDescripcion = null,sEstadoPeticion=null;
		System.out.println("Para crear una peticion, por favor rellene los siguientes campos: ");
		
		while(bEC) {
		    try {
		    iIdPeticion = Controllador.getpeticionController().ContadorPeticion()+1;
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
	
	public static void MostrarPeticionesPropias(PaqueteController Controllador,usuario oUsuario) {
		System.out.println("Aqui tiene una lista de sus peticiones \n");
		System.out.println(Controllador.getpeticionController().ListaPeticionXDNI(oUsuario));
	}
	
	public static void BorrarPeticion(PaqueteController Controllador,usuario oUsuario) {
		boolean bEC = true;
		Peticion oPeticion = null;
		int iDato =0;
		System.out.println("Escriba el id de la peticion que quiere borrar \n");
		System.out.println(Controllador.getpeticionController().ListaPeticionXDNI(oUsuario));

		while(bEC) {
		    try {
		    iDato = (int) ValidaLibrary.valida("Introduce el id", 1, Controllador.getpeticionController().ListaPeticionXDNI(oUsuario).size(), 1);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		oPeticion = new Peticion(iDato);
		
		if(Controllador.getpeticionController().remove(oPeticion) >0) {
			System.out.println("Borrado realizado");
		}else {
			System.out.println("Borrado no realizado");
		}
		
	}
	
	public static void seleccionarPeticion(PaqueteController Controllador,usuario oUsuario) {
		boolean bEC = true;
		Peticion oPeticion = null;
		int iDato =0;
		System.out.println("******************************* \n");
		System.out.println(Controllador.getpeticionController().ListaPeticionSinContarte(oUsuario));

		while(bEC) {
		    try {
		    iDato = (int) ValidaLibrary.valida("Introduce el id de la peticion que quieres mandar una oferta", 1, Controllador.getpeticionController().ListaPeticionSinContarte(oUsuario).size(), 1);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		oPeticion = new Peticion(iDato);
		
		if(Controllador.getpeticionController().remove(oPeticion) >0) {
			System.out.println("Borrado realizado");
		}else {
			System.out.println("Borrado no realizado");
		}
		
	}

}
