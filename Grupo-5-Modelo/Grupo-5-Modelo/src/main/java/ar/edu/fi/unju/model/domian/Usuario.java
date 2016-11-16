package ar.edu.fi.unju.model.domian;

public class Usuario {    
	private Integer usuarioId;
	private String usuario;
    private String apellidoNombre;
    private String clave;
    private String eMail;
    private Rol rol;
    
   public  Usuario( String usu, String apellidoNombre, String clave, String eMail, Rol rol){
	   this.usuario = usu;
	   this.apellidoNombre = apellidoNombre;
	   this.clave = clave;
	   this.eMail = eMail;
	   this.rol = rol;
   }
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getApellidoNombre() {
		return apellidoNombre;
	}
	public void setApellidoNombre(String apellidoNombre) {
		this.apellidoNombre = apellidoNombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	
}
