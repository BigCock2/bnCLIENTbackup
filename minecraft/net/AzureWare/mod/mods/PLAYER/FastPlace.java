package net.AzureWare.mod.mods.PLAYER;

import com.darkmagician6.eventapi.EventTarget;

import net.AzureWare.events.EventUpdate;
import net.AzureWare.mod.Mod;

public class FastPlace extends Mod {

	public FastPlace() {
		super("FastPlace", Category.PLAYER);
		// TODO �Զ����ɵĹ��캯�����
	}

	@EventTarget
	public void onUpdate(EventUpdate e) {
		mc.rightClickDelayTimer = 0;
	}
}
