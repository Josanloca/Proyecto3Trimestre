package views;

import java.time.LocalDate;

import com.sun.tools.sjavac.server.SysInfo;

import Controllador.ConexionBaseDatos;
import Controllador.general.PaqueteController;
import modelo.usuario;
import modelo.tipo_estados.TipoUsuario;

public class Principal {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(1995, 07, 22);
		TipoUsuario tu= new TipoUsuario("PARTICULAR");
		
		System.out.println(localDate.getYear()+"*"+localDate.getMonthValue()+"*"+localDate.getDayOfMonth());




		usuario usuario = new usuario("98765432B","pepe","Contraseña11",localDate,"cacacOTA@gmail.com",959211725,"Calle cine Victoria n15","x",tu);
		
		usuario busqueda = new usuario("98765432A");
		PaqueteController d = new PaqueteController("tienda");
		//System.out.println(d.getTipoUsuarioctrl().remove(tu));
		//System.out.println(d.getTipoUsuarioctrl().existeTipoUsuario(tu));
		//System.out.println(d.getUsuarioController().add(usuario));
		System.out.println(d.getUsuarioController().existeUsuario(busqueda));
		System.out.println(d.getUsuarioController().ListaDeLosUsuario());

	}

}
