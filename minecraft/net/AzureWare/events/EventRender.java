package net.AzureWare.events;

import com.darkmagician6.eventapi.events.Event;

public class EventRender implements Event {
	int pass;
	float partialTicks;
	long finishTimeNano;
	
	public EventRender(int pass, float partialTicks, long finishTimeNano) {
		this.pass = pass;
		this.partialTicks = partialTicks;
		this.finishTimeNano = finishTimeNano;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public float getPartialTicks() {
		return partialTicks;
	}

	public void setPartialTicks(float partialTicks) {
		this.partialTicks = partialTicks;
	}

	public long getFinishTimeNano() {
		return finishTimeNano;
	}

	public void setFinishTimeNano(long finishTimeNano) {
		this.finishTimeNano = finishTimeNano;
	}
	
}
