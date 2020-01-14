package be.helha.aemt.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.weld.context.http.HttpRequestContext;

@SessionScoped
@Named
public class SessionControl implements Serializable{

	
	public String logOut() {
		HttpServletRequest request = getRequest();
        HttpSession session = request.getSession();
        //user = null;
        session.invalidate();
        session = request.getSession(false);
        return "/index.xhtml?faces-redirect=true";    
    }
	

	public HttpServletRequest getRequest() {
		return null;
	}


	public boolean connected() {
		return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() != null;
	}
	
	
}
