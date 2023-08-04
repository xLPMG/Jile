package me.lpmg.jile.events;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.entities.creatures.Jina;

public class JinaFirstEncounter extends Event {

	public JinaFirstEncounter(Handler handler) {
		super(handler, "firstEncounteredJina");
	}

	@Override
	public void startEvent(EventContext eventContext) {

		Entity jina = new Jina(getHandler(), (Float) eventContext.getAttribute("spawnX"),
				(Float) eventContext.getAttribute("spawnY"));
		getHandler().getWorld().getEntityManager().addEntity(jina);
		((Jina) jina).firstEncounter();

	}

}
