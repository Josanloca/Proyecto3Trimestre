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
		

		//System.out.println(Controllador.getpeticionController().ListaPeticionToda());

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
			
			System.out.println("Bienvenido, ¿que quiere realizar hoy?");
						
			//views.PeticionViews.EntradaPeticion(Controllador, oUsuario);
			//views.PeticionViews.BorrarPeticion(Controllador, oUsuario);
			//views.OfertaViews.EntradaPeticion(Controllador, oUsuario);
			//views.PeticionViews.MostrarSeleccionar(Controllador, oUsuario);

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
					views.OfertaViews.BorrarOferta(Controllador, oUsuario);;
				    break;
				default:
				    try {
					ConexionBaseDatos.getConnection().close();
				    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }
				    System.out.println("Hasta luego.");
				}

			    } while (bMenu != -1);
			
			
		}else {
			System.out.println("Lo lamentamos pero el servidor no respondo, intentelo mas tarde.");
		}
		

		
		

		//LocalDate localDate = LocalDate.of(1995, 07, 22);
		//TipoUsuario tu= new TipoUsuario("PARTICULAR");
		
		//EstadoOferta eo = new EstadoOferta("FINALIZADO");
		
		//TipoUsuarioValorado oTUV = new TipoUsuarioValorado("PARTICULAR");
		
		
		//System.out.println(localDate.getYear()+"*"+localDate.getMonthValue()+"*"+localDate.getDayOfMonth());
		
		//usuario usuario = new usuario("98765432B","pepe","Contraseña11",localDate,"cacacOTA@gmail.com",959211725,"Calle cine Victoria n15","x",tu);		
		//usuario usuario = new usuario("11345678f");
		//oferta oferta = new oferta(5,"soy subnormal",79,usuario,eo);
		//EstadoPeticion oEP = new EstadoPeticion("ESPERA");
		//oferta oferta = new oferta(1);
		//Peticion oPeticion = new Peticion(2,"Limpieza de local",45,usuario,oEP,oferta);

		//valoraciones oV = new valoraciones(5,(byte)5,"sosos",oPeticion,oTUV);
		
		//usuario busqueda = new usuario("98765432A");
		
		//System.out.println(d.getTipoUsuarioctrl().remove(tu));
		//System.out.println(d.getTipoUsuarioctrl().existeTipoUsuario(tu));
		//System.out.println(d.getUsuarioController().add(usuario));
		//System.out.println(d.getUsuarioController().existeUsuario(busqueda));
		//System.out.println(d.getUsuarioController().ListaDeLosUsuario());
		//System.out.println(d.getestadoOfertaController().ListaDeLosUsuario());
		//System.out.println(d.getofertaController().ListaXPeticion(oferta));
		//System.out.println(d.getpeticionController().ListaPeticionToda(usuario));
		
		//System.out.println(d.getvaloracionController().ListaXPeticion(oV));

		//System.out.println(Controllador.getofertaController().inicioPeticionConOferta());

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
		System.out.println("*6* Ver si tiene notificaciones de una peticion.");

		
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
