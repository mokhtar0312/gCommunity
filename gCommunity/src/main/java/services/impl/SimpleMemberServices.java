package services.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import services.interfaces.SimpleMemberServicesLocal;
import services.interfaces.SimpleMemberServicesRemote;

/**
 * Session Bean implementation class SimpleMemberServices
 */
@Stateless
@LocalBean
public class SimpleMemberServices implements SimpleMemberServicesRemote, SimpleMemberServicesLocal {

    /**
     * Default constructor. 
     */
    public SimpleMemberServices() {
        // TODO Auto-generated constructor stub
    }

}
