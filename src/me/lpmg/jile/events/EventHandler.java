package me.lpmg.jile.events;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventHandler {

	private Collection<Event> events;
	
	private Map<String, Collection<Class<? extends Event>>> events2 = new HashMap<>();
	
	private void init() 
	{
		events2.get("firstEncounteredJina").add(JinaFirstEncounter.class);
	}
	
	public void triggerEvent(String eventID, EventContext eventContext) 
	{
		for (Event event : events) {
			if (event.isApplicable(eventID, eventContext)) 
			{
				event.startEvent(eventContext);
			}
		}
	}
}
