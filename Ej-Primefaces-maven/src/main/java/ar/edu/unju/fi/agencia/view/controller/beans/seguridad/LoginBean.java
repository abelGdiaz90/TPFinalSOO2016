package ar.edu.unju.fi.agencia.view.controller.beans.seguridad;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



/**
 * 
 * Bean para el login del sistema
 * @author Jos� Zapana
 *
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	private String nombreUsuario;
	private String password;
	private final String FORWARD_DASHBOARD = "escritorio.xhtml?faces-redirect=true";
	

	/**
	 * Login del sistema
	 * @return
	 * @throws Exception 
	 */
	public String ingresar() throws Exception{

			if(nombreUsuario.isEmpty() || password.isEmpty()){
				
				//FIXME deber�a mejorar este c�digo para que sea reusable
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe Ingresar usuario y clave"));
				return null;
			}
			
			
			return FORWARD_DASHBOARD;
			
	}

	/**
	 * Cerrar sesi�n
	 * @return
	 */
	public void closeSession() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.invalidate();


	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
