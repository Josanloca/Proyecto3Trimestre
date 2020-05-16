package modelo;

import modelo.tipo_estados.TipoUsuarioValorado;

public interface iValoraciones {

	public int getiIdValoracion();
	public byte getbPuntuacion();
	public boolean setbPuntuacion(byte bPuntuacion);
	public String getsDesValor();
	public boolean setsDesValor(String sDesValor);
	public Peticion getoPeticion();
	public boolean setoPeticion(Peticion oPeticion);
	public TipoUsuarioValorado getTuv();
	public boolean setTuv(TipoUsuarioValorado tuv);
	public boolean checkValoracion();
    public int hashCode () ;
    public boolean equals (Object obj);
    public String toString ();
	
}
