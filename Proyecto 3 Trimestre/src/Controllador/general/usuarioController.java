package Controllador.general;

import Controllador.ConexionBaseDatos;
import modelo.usuario;

public class usuarioController {

	public int add (usuario oUsuario) {
		String z="13*04*21";
		//INSERT INTO usuario VALUES
		//('15947895b','Jose lopez','contraseña123','13*04*21','xxxx@gmail.com',959333333,'Calle cine victoria n2','x','PARTICULAR')


		//String sql = "INSERT INTO usuario VALUES (\""+oUsuario.getsDni_nif()+"\",\""+oUsuario.getsNombre()+"\",\""+oUsuario.getsContraseña()+"\",\""+z+"\",\""+oUsuario.getsCorreoElectronico()+"\",\""+oUsuario.getsDireccion()+"\",\""+oUsuario.getsDescripccion()+"\",\""+oUsuario.getoTipoUsuario()+"\")";
		String sql = "INSERT INTO usuario VALUES (\""+"15917895l"+"\",\""+"Jose lopez"+"\",\""+"contraseña123"+"\",\""+z+"\",\""+"154@gmail.com"+"\",\""+959331731+"\",\""+"Calle cine victoria n2"+"\",\""+"X"+"\",\""+"PARTICULAR"+"\")";
		System.out.println(sql);
		return ConexionBaseDatos.executeUpdate(sql);
	}
	
}
