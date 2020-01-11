package be.helha.aemt.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BonjourEJB implements IBonjourEJBRemote{

	@EJB //injection de la part du serveur(@Inject)
	private BonjourLocalEJB beanBonjourLocalEJB;
	public String bonjour() {
		return "Bonjour du serveur EE" +beanBonjourLocalEJB.bonjourLocal();
	}
}
