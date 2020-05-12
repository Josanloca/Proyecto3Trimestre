package views;

import java.time.LocalDate;

import Controllador.ConexionBaseDatos;
import Controllador.general.PaqueteController;
import modelo.usuario;
import modelo.tipo_estados.TipoUsuario;

public class Principal {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		TipoUsuario tu= new TipoUsuario("EMPRESARIO");

		usuario usuario = new usuario("15947895z","Jose antonio","Contraseña11","xxxx@gmail.com",959332425,"Calle cine Victoria n15","x",tu);
		
		PaqueteController d = new PaqueteController("tienda");
		//System.out.println(d.getTipoUsuarioctrl().remove(tu));
		//System.out.println(d.getTipoUsuarioctrl().existeTipoUsuario(tu));
		System.out.println(d.getUsuarioController().add(usuario));

	}

}
