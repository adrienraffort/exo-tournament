package me.guillaume.recruitment.tournament;


public class Swordsman extends Attacker {
	
	private boolean isVicious = false;
	
	private boolean activeExtraDmg = false;
	
	Swordsman(){
		this.pv = 100;
		this.dmg = 5;
		this.weapon = Weapon.SWORD;
	}
	
	Swordsman(String caracteristic){
		this.pv = 100;
		this.dmg = 5;
		this.weapon = Weapon.SWORD;
		this.isVicious = caracteristic == "Vicious" ? true : false;
		this.activeExtraDmg = true;
	}
	
	
	public void engage(Attacker at) {
		
		int round = 1;
		
		while (this.pv > 0 && at.pv > 0){
			this.attack(at, round);
			
			if (at.pv == 0) {
				break;
			}
			
			at.attack(this, round);
			
			round ++;
			
		}	
	}
	
	@Override
	protected void attack(Attacker at, int round) {
		increaseDmgVicious(round);
		
		super.attack(at, round);
	}
	
	public void increaseDmgVicious(int round) {
		if (this.isVicious && activeExtraDmg) {
			this.dmg = 20 + this.dmg;
			this.activeExtraDmg = false;
		}
		if (this.isVicious && round > 2 && !activeExtraDmg) {
			this.dmg = getDefaultDmg();
		}
	}
	
	
	public Swordsman equip(String what) {
		if (what == "buckler") {
			this.hasBuckler = true;
		}
		
		if (what == "axe") {
			this.weapon = Weapon.AXE;
		}
		
		if (what == "armor") {
			this.hasArmor = true;
		}
		
		this.dmg = getDefaultDmg();
		
		
		return this;
	}
	
	private int getDefaultDmg() {
		int e = 0;
		switch (weapon) {
			case SWORD: e = 5; break;
			case AXE: e = 6; break;
			case GreatSword: e = 12; break;
		} 
		
		return e -= (hasArmor ? 1 : 0);
	}
	
	

}
