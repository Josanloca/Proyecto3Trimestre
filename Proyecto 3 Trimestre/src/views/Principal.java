package views;

import java.time.LocalDate;
import Controllador.ConexionBaseDatos;
import Controllador.general.PaqueteController;
import Controllador.general.valoracionController;
import modelo.Peticion;
import modelo.oferta;
import modelo.usuario;
import modelo.valoraciones;
import modelo.tipo_estados.EstadoOferta;
import modelo.tipo_estados.EstadoPeticion;
import modelo.tipo_estados.TipoUsuario;
import modelo.tipo_estados.TipoUsuarioValorado;

public class Principal {

	public static void main(String[] args) {
		usuario oUsuario = null;	
		byte bMenu;
		
		PaqueteController Controllador = new PaqueteController("tienda");
		System.out.println(Controllador.getpeticionController().ListaPeticionToda());
		
		
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
						
			views.PeticionViews.EntradaPeticion(Controllador, oUsuario);
			
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
		System.out.println("*3* Responder a una peticion.");
		System.out.println("*4* Ver si tiene notificaciones de una peticion.");

		
		
		return bMenu;
	}

}
