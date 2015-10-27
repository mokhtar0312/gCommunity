package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.PacksServicesRemote;
import entities.Packs;

public class PacksServicesDelegate {
	//private static PacksServicesRemote remote;
		private static final String jndi = "/g-community/PacksServices!services.interfaces.PacksServicesRemote";

		private static PacksServicesRemote getProxy() {
			return (PacksServicesRemote) ServiceLocator.getInstance().getProxy(
					jndi);
		}
		
		public static Boolean addPacks(Packs Packs)
		{
			return getProxy().addPacks(Packs);
		}

		public static Packs findPacksbyId(Integer id)
		{
			return getProxy().findPacksById(id);
		}

		public static Boolean updatePacks(Packs Packs)
		{
			return getProxy().updatePacks(Packs);
		}

		public static Boolean deletePacks(Packs Packs)
		{
			return getProxy().deletePacks(Packs);
		}

		public static List<Packs> findAllPacks()
		{
			return getProxy().findAllPacks();
		}
		public static Boolean deletePacksbyId(Integer id)
		{
			return getProxy().deletePacksById(id);
		}
}
