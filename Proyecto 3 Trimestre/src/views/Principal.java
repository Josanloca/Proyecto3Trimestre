package views;

import java.time.LocalDate;
import Controllador.ConexionBaseDatos;
import Controllador.general.PaqueteController;
import modelo.Peticion;
import modelo.oferta;
import modelo.usuario;
import modelo.tipo_estados.EstadoOferta;
import modelo.tipo_estados.EstadoPeticion;
import modelo.tipo_estados.TipoUsuario;
import modelo.tipo_estados.TipoUsuarioValorado;

public class Principal {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(1995, 07, 22);
		TipoUsuario tu= new TipoUsuario("PARTICULAR");
		
		EstadoOferta eo = new EstadoOferta("FINALIZADO");
		
		TipoUsuarioValorado oTUV = new TipoUsuarioValorado("PARTICULAR");
		
		//System.out.println(localDate.getYear()+"*"+localDate.getMonthValue()+"*"+localDate.getDayOfMonth());
		
		//usuario usuario = new usuario("98765432B","pepe","Contraseña11",localDate,"cacacOTA@gmail.com",959211725,"Calle cine Victoria n15","x",tu);		
		usuario usuario = new usuario("11345678f");
		//oferta oferta = new oferta(5,"soy subnormal",79,usuario,eo);
		//EstadoPeticion oEP = new EstadoPeticion("ESPERA");
		//oferta oferta = new oferta(1);
		//Peticion oPeticion = new Peticion(3,"Limpieza de local",45,usuario,oEP,oferta);

		
		//usuario busqueda = new usuario("98765432A");
		PaqueteController d = new PaqueteController("tienda");
		//System.out.println(d.getTipoUsuarioctrl().remove(tu));
		//System.out.println(d.getTipoUsuarioctrl().existeTipoUsuario(tu));
		//System.out.println(d.getUsuarioController().add(usuario));
		//System.out.println(d.getUsuarioController().existeUsuario(busqueda));
		//System.out.println(d.getUsuarioController().ListaDeLosUsuario());
		//System.out.println(d.getestadoOfertaController().ListaDeLosUsuario());
		//System.out.println(d.getofertaController().ListaXPeticion(oferta));
		//System.out.println(d.getpeticionController().ListaPeticionToda(usuario));
		
		System.out.println(d.getTipoUsuarioValoradoController().ListaTUV(oTUV));

	}

}
