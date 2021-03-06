package com.gellert.zoowsome.models.animals;

import com.gellert.zoowsome.services.factories.Constants;

public class Eagle extends Bird {
	public Eagle(String name, int nrOfLegs, boolean migrates, int avgFlightAltitude, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		this.setName(name);
		this.setNrOfLegs(nrOfLegs);
		this.setMigrates(migrates);
		this.setAvgFlightAltitude(avgFlightAltitude);
	}
	
	public Eagle() {
		this.setName("Eeeee");
		this.setNrOfLegs(2);
		this.setMigrates(false);
		this.setAvgFlightAltitude(35);
	}
}