package me.guillaume.recruitment.tournament;

public abstract class Attacker {

	protected int pv;
	
	protected int dmg;
	
	protected boolean hasBuckler;
	
	protected int buckerProtection = 0;
	
	protected Weapon weapon;
	
	protected boolean hasArmor;
	
	
	protected int hitPoints() {
		return this.pv;
	}
	
	
	protected void attack(Attacker at, int round) {
		
		// If the attacker has no shield and is not protected by the blow
		if (!at.hasBuckler || !protect(round)) {
			if (at.hasArmor && this.dmg > 0) { // If there are an armor and if the damage > 0, we add 3 points (Reduce the damage by 3)
				at.pv = at.pv - this.dmg + 3;
			}else {
				at.pv = at.pv - this.dmg;
			}
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
