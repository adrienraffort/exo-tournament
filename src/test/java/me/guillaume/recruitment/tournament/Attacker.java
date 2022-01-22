package me.guillaume.recruitment.tournament;

public abstract class Attacker {

	protected int pv;
	
	protected int dmg;
	
	
	protected int hitPoints() {
		return this.pv;
	}
	
	
	protected void attack(Attacker at) {
		at.pv = at.pv - this.dmg;
		
		if(at.pv <= 0) at.pv = 0;
	}
	
	
	
}
