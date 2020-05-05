package modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import Limites.iLimitesGenerales;


public class usuario implements iLimitesGenerales,iUsuario{

	private String sDni_nif; // PK
	private String sNombre; // NN
	private String sApellido; 
	private String sContraseña; // NN
	private LocalDate fecha; // NN
	private String sCorreoElectronico; // NN
	private int iTelefono;
	private String sDireccion;
	private String sDescripccion;
	private TipoUsuario oTipoUsuario; // NN
	
	//GENERAL COMPLETO
	public usuario(String sDni_nif,String sNombre,String sApellido,String sContraseña,LocalDate fecha,String sCorreoElectronico,int iTelefono,String sDireccion,String sDescripccion,TipoUsuario oTipoUsuario) {
		this.setsDni_nif(sDni_nif);
		this.setsNombre(sNombre);
		this.setsApellido(sApellido);
		this.setsContraseña(sContraseña);
		this.setFecha(fecha);
		this.setsCorreoElectronico(sCorreoElectronico);
		this.setiTelefono(iTelefono);
		this.setsDireccion(sDireccion);
		this.setsDescripccion(sDescripccion);
		this.setoTipoUsuario(oTipoUsuario);
	}
	
	//GENERAL 1 MODO
	public usuario(String sDni_nif,String sNombre,String sContraseña,LocalDate fecha,String sCorreoElectronico,TipoUsuario oTipoUsuario) {
		this.setsDni_nif(sDni_nif);
		this.setsNombre(sNombre);
		this.setsContraseña(sContraseña);
		this.setFecha(fecha);
		this.setsCorreoElectronico(sCorreoElectronico);
		this.setoTipoUsuario(oTipoUsuario);
	}
	


	@Override
	public String getsDni_nif() {
		return sDni_nif;
	}

	private boolean setsDni_nif(String sDni_nif) {
		boolean bExito = false;
		if(sDni_nif != null && sDni_nif.length() == LIMITENOMBREU) {
			this.sDni_nif = sDni_nif;
			bExito = true;
		}else {
			this.sDni_nif = null;
		}
		return bExito;
	}

	@Override
	public String getsNombre() {
		return sNombre;
	}

	@Override
	public boolean setsNombre(String sNombre) {
		boolean bExito = false;
		if(sNombre != null && sNombre.length() > LIMITEUZERO && sNombre.length() <= LIMITEUNOMBRE) {
			this.sNombre = sNombre;
			bExito = true;
		}else {
			this.sNombre = null;
		}
		return bExito;
	}

	@Override
	public String getsApellido() {
		return sApellido;
	}

	@Override
	public boolean setsApellido(String sApellido) {
		boolean bExito = false;
		if(sApellido.length() > LIMITEUZERO && sApellido.length() <= LIMITEUNOMBRE) {
			this.sApellido = sApellido;
			bExito = true;
		}else {
			this.sApellido = null;
		}
		return bExito;
	}

	@Override
	public String getsContraseña() {
		return sContraseña;
	}

	@Override
	public boolean setsContraseña(String sContraseña) {
		boolean bExito = false;
		if(sContraseña != null && sContraseña.length() >= LIMITCONTRASEÑAMIN && sContraseña.length() <= LIMITCONTRASEÑAMAX) {
			this.sContraseña =encryptSha512(sContraseña);
		}else {
			this.sContraseña = null;
		}
		return bExito;
	}

	@Override
    public String encryptSha512(String input){ 
        try { 
            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
            byte[] messageDigest = md.digest(input.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }    
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }  
	
    //NO ME FIO
	@Override
	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	//NO ME FIO

	@Override
	public String getsCorreoElectronico() {
		return sCorreoElectronico;
	}

	@Override
	public boolean setsCorreoElectronico(String sCorreoElectronico) {
		boolean bExito = false;
		if(sCorreoElectronico != null && sCorreoElectronico.length() > LIMITCORREOMIN && sCorreoElectronico.length() <= LIMITCORREOMAX) {
			this.sCorreoElectronico = sCorreoElectronico;
			bExito = true;
		}else {
			this.sCorreoElectronico = null;
		}
		return bExito; 
	}

	@Override
	public int getiTelefono() {
		return iTelefono;
	}

	@Override
	public boolean setiTelefono(int iTelefono) {
		boolean bExito = false;
		if( String.valueOf(iTelefono).length() == LIMITTELEFONO) {
			this.iTelefono = iTelefono;
		}else {
			this.iTelefono = 0;
		}
		return bExito;
	}

	@Override
	public String getsDireccion() {
		return sDireccion;
	}

	@Override
	public boolean setsDireccion(String sDireccion) {
		boolean bExito = false;
		if(sDireccion.length() >= LIMITEUZERO && sDireccion.length() >= LIMITDIREMAX) {
			this.sDireccion = sDireccion;
			bExito = true;
		}else {
			this.sDireccion = null;
		}
		return bExito;
	}

	@Override
	public String getsDescripccion() {
		return sDescripccion;
	}

	@Override
	public boolean setsDescripccion(String sDescripccion) {
		boolean bExito = false;
		if(sDescripccion.length() > LIMITEUZERO && sDescripccion.length() > LIMITDESCRIPCCIONMAX) {
			this.sDescripccion = sDescripccion;
			bExito = true;
		}else {
			this.sDescripccion = null;
		}
		return bExito;
	}

	@Override
	public TipoUsuario getoTipoUsuario() {
		return oTipoUsuario;
	}

	@Override
	public boolean setoTipoUsuario(TipoUsuario oTipoUsuario) {
		boolean bExito = false;
		if(oTipoUsuario.checkNombreUsuario()) {
			this.oTipoUsuario = oTipoUsuario;
			bExito = true;
		}
		return bExito;
	}
	
	public boolean checkUsuario() {
		boolean bExito = false;
		if(this.sDni_nif != null && this.sNombre != null  && this.sContraseña != null  && this.sCorreoElectronico != null && this.oTipoUsuario.checkNombreUsuario()) {
			bExito = true;
		}
		return bExito;
	}
	
    @Override
    public int hashCode () {
    	final int prime = 31;
    	int result = 1;
    	result = prime * result + ((sDni_nif == null) ? 0 : sDni_nif.hashCode());
    	return result;
    }

    @Override
    public boolean equals (Object obj) {
    	boolean bExito = false;
    	usuario other = (usuario) obj;
    	if (checkUsuario() && other.checkUsuario() && this.sDni_nif.equals(other.sDni_nif)) {
    		bExito = true;
    	}
    	return bExito;
    }
    
    @Override
    public String toString() {
    	String sResultado = "";
    	sResultado += "Dni/nif: "+this.sDni_nif+"\n";
    	sResultado += "Nombre: "+this.sNombre+"\n";
    	if(this.sApellido != null) {
    		sResultado += "Apellido: "+this.sApellido+"\n";
    	}
    	sResultado += "Contraseña: "+this.sContraseña+"\n";
    	sResultado += "Fecha de nacimiento: "+this.fecha+"\n";
    	sResultado += "Telefono: "+this.iTelefono+"\n";
    	sResultado += "Direccion: "+this.sDireccion+"\n";
    	sResultado += "Descripcion: "+this.sDescripccion+"\n";
    	 if(oTipoUsuario != null){
    		 sResultado += oTipoUsuario.toString();
    	 }
    	return sResultado;
    }
    
    
}
	

