package views;

import Controllador.ConexionBaseDatos;

public class Principal {

	public static void main(String[] args) {

		
		ConexionBaseDatos  d= new ConexionBaseDatos("tienda");
		
		if(ConexionBaseDatos.checkConnectionDatabase()) {
			System.out.println("Retraso perfecto");
		}
		
	}

}
