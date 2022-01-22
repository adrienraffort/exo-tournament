package me.guillaume.recruitment.tournament;

import org.assertj.core.internal.bytebuddy.asm.Advice.This;

public class Swordsman extends Attacker {
	
	Swordsman(){
		this.pv = 100;
		this.dmg = 5;
		this.weapon = Weapon.SWORD;
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
			
			System.out.println(this.pv + "  " + at.pv);
		}	
	}
	
	
	public Swordsman equip(String what) {
		if (what == "buckler") {
			this.hasBuckler = true;
		}
		
		if (what == "armor") {
			this.hasArmor = true;
			this.dmg -= 1;
		}
		
		
		return this;
	}
	
	

}
