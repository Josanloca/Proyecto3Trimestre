package views;

import java.time.LocalDate;

import Controllador.general.PaqueteController;
import Limites.iLimitesGenerales;
import Valida.ValidaLibrary;
import modelo.usuario;
import modelo.tipo_estados.TipoUsuario;

public class LoginViews {
	
	public static boolean Registrar_Login() {
		boolean bResultado= false,bEC = true;	
		byte byBoolean=-1;
		
		while(bEC) {
		    try {
				byBoolean = (byte) ValidaLibrary.valida("�Deseas inicar sesion o registrarte? (iniciar sesion = 0,registrarte = 1)", 0, 1, 3);
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
		String sCorreo = null, sContrase�a = null;
		System.out.println("Para poder acceder a la aplicacion por favor introduzca su correo electronico y su contrase�a");
		
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
		    	sContrase�a = ValidaLibrary.leer("Introduzca su contrase�a: ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la contrase�a: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    } 
		    usuario oUEntrada = new usuario(sContrase�a,sCorreo);
		    
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
		int iTelefono= 0,fecha_A�o= 0,fecha_Mes= 0,fecha_Dia=0;
		byte bDato= 0;
		String sDni_nif= null,sNombre= null,sContrase�a= null,sCorreoElectronico= null,sDireccion= null,sDescripccion= null,sTipoUsuario= null;
		
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
		    sContrase�a = ValidaLibrary.leer("Introduzca su contrase�a(MIN 7 - MAX 40): ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del nombre: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		bEC = true;
		
		while(bEC) {
		    try {
		    fecha_A�o =(int) ValidaLibrary.valida("Introuzca en que a�o naciste (MIN 1900 - MAX 2019): ", 1900, 2019, 1);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del a�o: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		bEC = true;
		
		while(bEC) {
		    try {
		    fecha_Mes =(int) ValidaLibrary.valida("Introuzca en que mes naciste (MIN 1 - MAX 12): ", 1, 12, 1);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del mes: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		bEC = true;
		
		while(bEC) {
		    try {
		    fecha_Dia =(int) ValidaLibrary.valida("Introuzca en que dia naciste(MIN 1 - MAX 30): ", 1, 30, 1);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del mes: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		bEC = true;
		
		while(bEC) {
		    try {
		    sCorreoElectronico = ValidaLibrary.leer("Introduzca su correo electronico (debe contener un @): ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del correo electronico: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		
		bEC = true;
		
		while(bEC) {
		    try {
		    iTelefono = (int) ValidaLibrary.valida("Introduzca su numero de telefono: ", 100000000, 999999999, 1);
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del telefono: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		bEC = true;
		
		while(bEC) {
		    try {
		    	sDireccion = ValidaLibrary.leer("Introduzca su direccion : ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion de la direccion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		bEC = true;
		
		while(bEC) {
		    try {
		    	sDescripccion = ValidaLibrary.leer("Introduzca una peque�a descripccion de si mismo: ");
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion de la descripccion: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		
		bEC = true;
		
		while(bEC) {
		    try {
		    bDato = (byte) ValidaLibrary.valida("�Que tipo de ususario sera? 1= EMPRESARIO o 2= PARTICULAR : ",1,2,3);
		    
		    if(bDato ==1) {
		    	sTipoUsuario ="EMPRESARIO";
		    }else if(bDato ==2) {
		    	sTipoUsuario ="PARTICULAR";
		    }else {
		    	System.out.println("ERROR VALIDA TIPO USUARIO");
		    }
		    bEC = false;
		    } catch(Exception ex) {
			System.out.println("Error en la introduccion del tipo de usuario: " + ex.getMessage()+"\n");
			System.out.println("Intentelo de nuevo \n");
		    }
		}

		
		LocalDate localDate = LocalDate.of(fecha_A�o, fecha_Mes, fecha_Dia);
		
		TipoUsuario oTU = new TipoUsuario(sTipoUsuario);
		
		usuario oResultado = new usuario(sDni_nif,sNombre,sContrase�a,localDate,sCorreoElectronico,iTelefono,sDireccion,sDescripccion,oTU);
		
		if(Controllador.getUsuarioController().add(oResultado) >0) {
			oUsuario = oResultado;
		}
		
		return oUsuario;
	}
	
	
		
}
