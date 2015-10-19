package delegate;

import java.util.List;

import entities.Model3D;
import locator.ServiceLocator;
import services.interfaces.Model3DServicesRemote;


public class Model3DServicesDelegate {

	private static Model3DServicesRemote remote;
	private static final String jndi = "/g-community/Model3DServices!services.interfaces.Model3DServicesRemote";

	private static Model3DServicesRemote getProxy() {
		return (Model3DServicesRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}
	
	public static Boolean addM(Model3D model3D)
	{
		return getProxy().addM(model3D);
	}

	public static Model3D findModel3DById(Integer id)
	{
		return getProxy().findModel3DById(id);
	}

	public static Boolean updateModel3D(Model3D model3D)
	{
		return getProxy().updateModel3D(model3D);
	}

	public static Boolean deleteModel3D(Integer id)
	{
		return getProxy().deleteModel3D(id);
	}

	public static List<Model3D> finAll3DModels()
	{
		return getProxy().finAll3DModels();
	}
}
