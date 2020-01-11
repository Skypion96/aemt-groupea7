package be.helha.aemt.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BonjourLocalEJB {
	public String bonjourLocal() {
		return "\nBonjour Local";
	}
}
