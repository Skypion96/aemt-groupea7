package be.helha.aemt.bean;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class AuthenticationBean {
	
	public void checkErrors(ComponentSystemEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		if("true".equals((String)request.getParameter("failed"))){
			context.addMessage(null, new FacesMessage("Connxion refusée !"));
		}
		else if (request.getRequestedSessionId()!=null && !request.isRequestedSessionIdValid()){
			context.addMessage(null, new FacesMessage("Votre session s'est fermée !"));
		}
		else if(request.getParameter("logout")!=null && request.getParameter("logout").equalsIgnoreCase("true")) {
			context.addMessage(null, new FacesMessage("Déconnexion réussie !"));
		}
	}
	
	public String logout() {
        String page="/index?logout=true&faces-redirect=true";
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
          request.logout();
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Erreur de déconnexion !"));
            page="/index?logout=false&faces-redirect=true";
        }
        return page;
    }

}
