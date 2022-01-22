package me.guillaume.recruitment.tournament;

import org.assertj.core.internal.bytebuddy.asm.Advice.This;

public class Swordsman extends Attacker {
	
	Swordsman(){
		this.pv = 100;
		this.dmg = 5;
	}
	
	
	public void engage(Attacker at) {
		while (this.pv > 0 && at.pv > 0){
			this.attack(at);
			
			if (at.pv == 0) {
				break;
			}
			
			at.attack(this);
			
		}	
	}
	

}
