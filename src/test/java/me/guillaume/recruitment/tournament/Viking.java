package me.guillaume.recruitment.tournament;

public class Viking extends Attacker {
	
	
	Viking(){
		this.pv = 120;
		this.dmg = 6;
		this.weapon = Weapon.AXE;

	}
	
	public Viking equip(String what) {
		if (what == "buckler") {
			this.hasBuckler = true;
		}
		
		
		return this;
	}

}
