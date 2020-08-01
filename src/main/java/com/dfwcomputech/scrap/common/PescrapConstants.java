package com.dfwcomputech.scrap.common;

public class PescrapConstants {
	public static final String pesURL="http://pesdb.net/pes2020/";
	
	public enum ResultColumn {
		POSITION("Position"),
		PLAYER_NAME("Player Name"),
		TEAM_NAME("Team Name"),
		NATIONALITY("Nationality"),
		HEIGHT("Height"),
		WEIGHT("Weight"),
		AGE("Age"),
		CONDITION("Condition"),
		OVERALL_RATING("Overall Rating");
		
		private String name;
		
		private ResultColumn(String name) {
			this.name=name;
		}
		
		public String getName() {
			return this.name;
		}
	}
}
