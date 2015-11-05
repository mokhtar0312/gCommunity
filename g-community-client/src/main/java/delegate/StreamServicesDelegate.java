package delegate;

import java.util.List;

import entities.Streams;
import locator.ServiceLocator;
import services.interfaces.StreamServicesRemote;


public class StreamServicesDelegate {

	private static StreamServicesRemote remote;
	private static final String jndi = "/g-community-ejb/StreamServices!services.interfaces.StreamServicesRemote";

	private static StreamServicesRemote getProxy() {
		return (StreamServicesRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}
	public static Boolean addStream(Streams stream)
	{
		return getProxy().addStream(stream);
	}
	public static Streams findStreamById(Integer id)
	{
		return getProxy().findStreamById(id);
	}
	public static Boolean updateStream(Streams stream)
	{
		return getProxy().updateStream(stream);
	}
	public static Boolean deleteStream(Integer id)
	{
		return getProxy().deleteStream(id);
	}
	public static List<Streams> findAllStreams()
	{
		return getProxy().findAllStreams();
	}
}
