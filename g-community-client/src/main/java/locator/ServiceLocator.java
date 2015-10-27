package locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {
	private Context context;
	private Map<String, Object> map;

	private static ServiceLocator instance;

	public ServiceLocator() {
		map = new HashMap<String, Object>();
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}

	public Object getProxy(String jndiName) {
		Object proxy = null;
		proxy = map.get(jndiName);
		if (proxy == null) {
			try {
				proxy = context.lookup(jndiName);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			map.put(jndiName, proxy);
		}

		return proxy;

	}

}
