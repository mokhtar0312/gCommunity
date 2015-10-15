package services.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import services.interfaces.MembershipServicesLocal;
import services.interfaces.MembershipServicesRemote;

/**
 * Session Bean implementation class MembershipServices
 */
@Stateless
@LocalBean
public class MembershipServices implements MembershipServicesRemote, MembershipServicesLocal {

    /**
     * Default constructor. 
     */
    public MembershipServices() {
        // TODO Auto-generated constructor stub
    }

}
