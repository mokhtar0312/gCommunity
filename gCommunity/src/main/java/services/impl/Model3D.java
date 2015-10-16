package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.Model3DLocal;
import services.interfaces.Model3DRemote;

/**
 * Session Bean implementation class Model3D
 */
@Stateless
@LocalBean
public class Model3D implements Model3DRemote, Model3DLocal {
@PersistenceContext
	EntityManager entitymanager;
    /**
     * Default constructor. 
     */
    public Model3D() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Boolean addM(entities.Model3D model3d) {
		boolean b=false;
		try {
			entitymanager.persist(model3d);
			b=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	@Override
	public entities.Model3D findModel3DById(Integer id) {
		
		return entitymanager.find(Model3D.class, id);
	}
	@Override
	public Boolean updateModel3D(entities.Model3D model3d) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean deleteModel3D(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<entities.Model3D> finAll3DModels() {
		// TODO Auto-generated method stub
		return null;
	}

}
