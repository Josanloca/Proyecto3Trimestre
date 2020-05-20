package views;



import java.util.List;

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
		List<Peticion> lValoracion =Controllador.getpeticionController().ListaPeticionXDNI(oUsuario);
		boolean bEC = true;
		Peticion oPeticion = null;
		int iDato =0;
		System.out.println("Escriba el id de la peticion que quiere borrar \n");
		System.out.println(lValoracion);

		while(bEC) {
		    try {
		    iDato = (int) ValidaLibrary.valida("Introduce el id del que quieres borrar",lValoracion.get(0).getiIdPeticion(),lValoracion.get(lValoracion.size()-1).getiIdPeticion(), 1);
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
	
	public static void seleccionarOfertaDefinitiva(PaqueteController Controllador,usuario oUsuario) {
		boolean bEC = true;
		List<oferta> lListaExterna = Controllador.getofertaController().ListaV1(oUsuario, Controllador);
		int iDato1 =0,iDato2 =0;
		System.out.println("******************************* \n");
		System.out.println(lListaExterna);


		while(bEC) {
		    try {
			iDato1 = (int) ValidaLibrary.valida("Dime el id de la peticion: ",lListaExterna.get(0).getoPeticion().getiIdPeticion(),lListaExterna.get(lListaExterna.size()-1).getoPeticion().getiIdPeticion(), 1);
		    iDato2 = (int) ValidaLibrary.valida("Dime el id de la oferta que le ha convencido para contratar: ", lListaExterna.get(0).getId_Oferta(),lListaExterna.get(lListaExterna.size()-1).getId_Oferta(), 1);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		if(Controllador.getpeticionController().ActualizarPeticionAñadiendoOferta(iDato1,iDato2) >0) {
			System.out.println(Controllador.getofertaController().ActualizarOfertasAceptado(iDato1, iDato2));
			System.out.println("actualizacion realizada");
			Controllador.getofertaController().ActualizarOfertasDenegadas(iDato1);
		}else {
			System.out.println("actualizacion no realizado");
		}
		
	}
	
	public static void MostrarSeleccionar(PaqueteController Controllador,usuario oUsuario) {
		boolean bEC = true;
		byte bDato=0;
		Peticion oPeticion = null;
		int iDato =0;
		
		System.out.println(Controllador.getpeticionController().ListaPeticionNoFinalizadas(oUsuario));
		System.out.println("Estos son las peticiones disponibles.");
		System.out.println();
		
		while(bEC) {
		    try {
		    bDato = (byte) ValidaLibrary.valida("¿Quiere proponer una oferta a alguna peticion? (NO =1 Y SI = 2)",1,2,3);
		    
		    if(bDato ==1) {
		    	System.out.println("Volviendo al menu");
		    }else if(bDato ==2) {
		    	
		    	bEC = true;
		    	while(bEC) {
				    try {
				    iDato = (int) ValidaLibrary.valida("Dime el id de la peticion a la que quieres realizar una oferta: ", 1, Controllador.getpeticionController().ListaPeticionNoFinalizadas(oUsuario).size(), 1);
				    bEC = false;
				    } catch(Exception ex) {
					System.out.println("Error en la introduccion: " + ex.getMessage()+"\n");
					System.out.println("Intentelo de nuevo \n");
				    }
				}
				oPeticion = new Peticion(iDato);
				
				if(views.OfertaViews.EntradaOferta(Controllador, oUsuario, oPeticion)) {
					System.out.println("Datos recibidos");
				}else {
					System.out.println("Datos no recibidos");
				}
		    }else {
		    	System.out.println("ERROR VALIDA TIPO USUARIO");
		    }
		    
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del tipo de usuario: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}	
	}

	
	public static void FinalizarPeticion(PaqueteController Controllador,usuario oUsuario) {
		List<Peticion> lValoracion =Controllador.getpeticionController().ListaPeticionXDNI(oUsuario);
		boolean bEC = true;
		Peticion oPeticion = null;
		int iDato =0;
		System.out.println("Escriba el id de la peticion que quiere borrar \n");
		System.out.println(lValoracion);

		while(bEC) {
		    try {
		    iDato = (int) ValidaLibrary.valida("Introduce el id del que quieres borrar",lValoracion.get(0).getiIdPeticion(),lValoracion.get(lValoracion.size()-1).getiIdPeticion(), 1);
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
