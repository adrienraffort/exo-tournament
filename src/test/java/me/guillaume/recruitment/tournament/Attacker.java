package me.guillaume.recruitment.tournament;

public abstract class Attacker {

	protected int pv;
	
	protected int dmg;
	
	protected boolean hasBuckler;
	
	protected int buckerProtection = 0;
	
	protected Weapon weapon;
	
	
	protected int hitPoints() {
		return this.pv;
	}
	
	
	protected void attack(Attacker at, int round) {
	
		
		// If the attacker has no shield and is not protected by the blow
		if (!at.hasBuckler || !protect(round)) {
			at.pv = at.pv - this.dmg;
		}else {
			at.buckerProtection += 1;
		}
		
		if(at.pv <= 0) at.pv = 0;
		
		// Remove the buckler, after 3 protection and if the weapon is an axe
		if(this.hasBuckler && this.buckerProtection == 3 && at.weapon == Weapon.AXE) { 
			this.hasBuckler = false;
		}
	}
	
	

	
	private boolean protect(int round) {
		return round % 2 == 0;
	}
	
}
