package modelo;

import java.time.LocalDate;

public interface iUsuario {

	public String getsDni_nif();
	public String getsNombre();
	public boolean setsNombre(String nombre);
	public String getsApellido() ;
	public boolean setsApellido(String apellido) ;
	public String getsContraseña();
	public boolean setsContraseña(String contraseña);
	public String encryptSha512(String input);
	public LocalDate getFecha();
	public void setFecha(LocalDate fecha);
	public String getsCorreoElectronico();
	public boolean setsCorreoElectronico(String correoElectronico);
	public int getiTelefono();
	public boolean setiTelefono(int telefono);
	public String getsDireccion();
	public boolean setsDireccion(String direccion);
	public String getsDescripccion();
	public boolean setsDescripccion(String descripccion);
	public TipoUsuario getoTipoUsuario();
	public boolean setoTipoUsuario(TipoUsuario oTipoUsuario);
	public int hashCode ();
	public String toString();
	
}
