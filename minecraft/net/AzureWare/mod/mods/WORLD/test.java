package net.AzureWare.mod.mods.WORLD;

import com.darkmagician6.eventapi.EventTarget;

import net.AzureWare.Client;
import net.AzureWare.events.EventUpdate;
import net.AzureWare.mod.Mod;
import net.AzureWare.utils.TimeHelper;

public class test extends Mod{

	public TimeHelper timer = new TimeHelper();
	private String message;
	public test() {
		super("test", Category.WORLD);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	@EventTarget
	public void onUpdate(EventUpdate e) {

	}

}
