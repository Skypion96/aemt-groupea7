package be.helha.aemt.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@SessionScoped
@Named
public class SessionControl implements Serializable{

	
	public String logOut() {
		String page="/index.xhtml?logout=true&faces-redirect=true";
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
          request.logout();
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed!"));
            page="/index.xhtml?logout=false&faces-redirect=true";
        }
        return page;  
    }

	public boolean connected() {
		return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() != null;
	}
	
	public String getNameAndFirstname() {
		return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
	}
	
}
