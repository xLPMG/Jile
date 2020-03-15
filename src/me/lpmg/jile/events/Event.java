package me.lpmg.jile.events;

import me.lpmg.jile.Handler;

public abstract class Event {
	
	private Handler handler;
	private String eventID;
	
	public Event(Handler handler, String eventID) {
		this.handler=handler;
		this.eventID = eventID;
	}

	public boolean isApplicable(String eventID, EventContext eventContext) 
	{
		return this.eventID.equals(eventID);
	}
	
	
	protected Handler getHandler() {
		return handler;
	}
	
	public abstract void startEvent(EventContext eventContext);
}
