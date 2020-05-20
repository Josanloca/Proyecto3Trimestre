package views;

import java.sql.SQLException;

import Controllador.ConexionBaseDatos;
import Controllador.general.PaqueteController;
import Valida.ValidaLibrary;
import modelo.usuario;


public class Principal {

	public static void main(String[] args) {
		usuario oUsuario = null;	
		byte bMenu = 0;
		
		PaqueteController Controllador = new PaqueteController("tienda");
		

		if(ConexionBaseDatos.checkConnectionDatabase()) {			
			System.out.println("Conexion a la BD Correcta.");
			
			if(LoginViews.Registrar_Login()) {
				oUsuario = LoginViews.entrada(Controllador);
				//EL PASADOR
				oUsuario = Controllador.getUsuarioController().GDUCAE(oUsuario);
				
				while (oUsuario == null) {
					System.out.println("Acesso no autorizado, intentelo de nuevo.");
					oUsuario = LoginViews.entrada(Controllador);
				}
			}else {
				oUsuario = LoginViews.Registrar(Controllador);
				
				while (oUsuario == null) {
					System.out.println("Acesso no autorizado, intentelo de nuevo.");
					oUsuario = LoginViews.Registrar(Controllador);
				}
			}

			
			System.out.println("Bienvenido, �que quiere realizar hoy?");

			do {
				bMenu = menuSelecPrincipal();
				switch (bMenu) {
				case 1:
				    views.PeticionViews.EntradaPeticion(Controllador, oUsuario);
				    break;
				case 2: 
					views.PeticionViews.BorrarPeticion(Controllador, oUsuario);
				    break;
				case 3: 
					views.PeticionViews.MostrarPeticionesPropias(Controllador, oUsuario);
				    break;
				case 4: 
					views.PeticionViews.MostrarSeleccionar(Controllador, oUsuario);
				    break;
				case 5: 
					views.OfertaViews.MostrarPeticionesPropias(Controllador, oUsuario);
				    break;
				case 6: 
					System.out.println(Controllador.getofertaController().ListaV1(oUsuario, Controllador));
				    break;
				case 7: 
					views.PeticionViews.seleccionarOfertaDefinitiva(Controllador, oUsuario);
				    break;
				case 8: 
					views.ValoracionViws.FinalizarOfertaYPeticion(Controllador, oUsuario);
				    break;
				case 9: 
					views.ValoracionViws.EntradaValoracionPeticion(Controllador, oUsuario);
				    break;
				default:
				    try {
					ConexionBaseDatos.getConnection().close();
				    } catch (SQLException e) {
					
					e.printStackTrace();
				    }
				    System.out.println("Hasta luego.");
				}

			    } while (bMenu != -1);
			
			
		}else {
			System.out.println("Lo lamentamos pero el servidor no respondo, intentelo mas tarde.");
		}

	}
	
	public static byte menuSelecPrincipal() {
		byte bMenu = 0;
		boolean bError = true;
		
		System.out.println("\n\nMenu principal: ");
		System.out.println("*1* Crear una peticion.");
		System.out.println("*2* Borrar una peticion.");
		System.out.println("*3* Mostrar mis peticiones.");
		System.out.println("*4* Ver peticiones globales(sin contar las tuyas ni las finalizadas o en progreso).");
		System.out.println("*5* Ver sus ofertas.");
		System.out.println("*6* Ver las ofertas a tus peticiones.");
		System.out.println("*7* Seleccionar la oferta a tus peticiones.");
		System.out.println("*8* Terminar el trabajo de una oferta tuya.");
		System.out.println("*9* Valorar algun trabajo como due�o de la peticion.");



		
		while (bError) {
		    try {
		    	bMenu = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 10, 3);
		    	bError = false;
		    } catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		    }
		}
		
		return bMenu;
	}

}
