package delegate;

import java.util.List;

import locator.ServiceLocator;
import entities.Equipment;
import entities.Event;
import entities.Packs;
import services.interfaces.EquipmentServicesRemote;

public class EquipmentDelegate {
	public static EquipmentServicesRemote remote;
	private static final String jndi = "/g-community-ejb/EquipmentServices!services.interfaces.EquipmentServicesRemote";
	
	public static EquipmentServicesRemote getProxy() {
		return (EquipmentServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	 public static Boolean addEquipment(Equipment equipment)
	{
		return getProxy().addEquipment(equipment);
	}

	public static Equipment findEquipmentById(Integer id)
	{
		return getProxy().findEquipmentById(id);
	}
	public static Boolean DeleteEquipment(Integer id)
	{
		return getProxy().deleteEquipmentById(id);
	}
	public static Boolean DeleteEquipment(Equipment equipment)
	{
		return getProxy().deleteEquipment(equipment);
	}

	public static Boolean UpdateEquipment(Equipment equipment)
	{
		return getProxy().updateEquipment(equipment);
	}
	public static List<Equipment> findAllEquipment(){
		return getProxy().findAllEquipment();
		
	}
}
