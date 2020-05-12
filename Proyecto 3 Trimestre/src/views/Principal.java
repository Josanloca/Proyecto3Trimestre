package views;

import Controllador.ConexionBaseDatos;
import Controllador.general.PaqueteController;
import modelo.tipo_estados.TipoUsuario;

public class Principal {

	public static void main(String[] args) {

		TipoUsuario tu= new TipoUsuario("123456789123");
		
		PaqueteController d = new PaqueteController("tienda");
		//System.out.println(d.getTipoUsuarioctrl().add(tu));
		System.out.println(d.getTipoUsuarioctrl().remove(tu));
	
	}

}
