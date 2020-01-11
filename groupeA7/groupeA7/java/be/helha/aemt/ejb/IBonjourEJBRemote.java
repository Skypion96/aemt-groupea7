package be.helha.aemt.ejb;

import javax.ejb.Remote;

@Remote
public interface IBonjourEJBRemote {

	public String bonjour();
}
