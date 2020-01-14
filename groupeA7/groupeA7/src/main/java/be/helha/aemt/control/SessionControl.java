package be.helha.aemt.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@SessionScoped
@Named
public class SessionControl implements Serializable{

	
	public String logOut() {
		FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        request.getSession(false).invalidate(); // on invalide
        return "index.xhtml";   
    }

	public boolean connected() {
		return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() != null;
	}
	
	
}
