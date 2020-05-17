package views;

import java.time.LocalDate;

import Controllador.general.PaqueteController;
import Limites.iLimitesGenerales;
import Valida.ValidaLibrary;
import modelo.usuario;

public class LoginViews {
	
	public static boolean Registrar_Login() {
		boolean bResultado= false,bEC = true;	
		byte byBoolean=-1;
		
		while(bEC) {
		    try {
				byBoolean = (byte) ValidaLibrary.valida("¿Deseas inicar sesion o registrarte? (iniciar sesion = 0,registrarte = 1)", 0, 1, 3);
				bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la seleccion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		if(byBoolean == 0) {
			bResultado = true;
		}else if(byBoolean == 1) {
			bResultado = false;
		}		
		return bResultado;
	}

	public static usuario entrada(PaqueteController Controllador) {
		usuario oUsuario = null;
		boolean bEC = true;
		String sCorreo = null, sContraseña = null;
		System.out.println("Para poder acceder a la aplicacion por favor introduzca su correo electronico y su contraseña");
		
		while(bEC) {
		    try {
		    sCorreo = ValidaLibrary.leer("Introduzca su correo electronico: ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en el correo: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC= true;
		
		while(bEC) {
		    try {
		    	sContraseña = ValidaLibrary.leer("Introduzca su contraseña: ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la contraseña: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    } 
		    usuario oUEntrada = new usuario(sContraseña,sCorreo);
		    
		    //COMPROBADOR
		    if(Controllador.getUsuarioController().checkUsuarioLogin(oUEntrada) > iLimitesGenerales.LIMITEZEROVISTA) {
		    	oUsuario = oUEntrada;
		    }   
		}		
		return oUsuario;
	}

	public static usuario Registrar(PaqueteController Controllador) {
		usuario oUsuario = null;
		boolean bEC = true;
		int iTelefono,fecha_Año,fecha_Mes,fecha_Dia;
		LocalDate fecha;
		String sDni_nif,sNombre,sContraseña,sCorreoElectronico,sDireccion,sDescripccion;
		
		System.out.println("Para registrarse rellene los campos a continuacion: ");
		
		while(bEC) {
		    try {
		    sDni_nif = ValidaLibrary.leer("Introduzca su dni o nif si es una empresa(Tiene que ser igual a 9): ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion dni/nif: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }	    
		}
		
		bEC = true;
		
		while(bEC) {
		    try {
		    sNombre = ValidaLibrary.leer("Introduzca su nombre o el de la empresa(MAX 35): ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del nombre: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC = true;
		
		while(bEC) {
		    try {
		    sContraseña = ValidaLibrary.leer("Introduzca su contraseña(MIN 7 - MAX 40): ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del nombre: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		bEC = true;
		
		while(bEC) {
		    try {
		    fecha_Año =(int) ValidaLibrary.valida("Introuzca en que año naciste (MIN 1900 - MAX 2019)", 1900, 2019, 1);
		    fecha_Año =(int) ValidaLibrary.valida("Introuzca en que año naciste (MIN 1900 - MAX 2019)", 1900, 2019, 1);

		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del nombre: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}
		
		return oUsuario;
	}
		
}
