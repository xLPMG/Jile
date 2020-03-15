package me.lpmg.jile.events;

import java.util.HashMap;
import java.util.Map;

public class EventContext {

	private Map<String, Object> contextAttributes = new HashMap<>(); 
	
	public void putAttribute(String id, Object object) 
	{
		contextAttributes.put(id, object);
	}

	public Object getAttribute(String id) 
	{
		return contextAttributes.get(id);
	}

	
}
