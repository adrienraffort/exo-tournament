package me.guillaume.recruitment.tournament;

public class Highlander extends Attacker {
	
	private int attackNumber;

	Highlander(){
		this.pv = 150;
		this.dmg = 12;
		this.weapon = Weapon.GreatSword;
		
		this.attackNumber = 1;
	}
	
	
	public void addAttack() {
		this.attackNumber += 1;
	}
	
	public boolean cannotAttack() {
		return this.attackNumber % 3 == 0; // If the number of the attack is a mulitplier of 3 (He can attack only 2 times of 3)
	}
	
	@Override
	protected void attack(Attacker at, int round) {
		
		this.dmg = cannotAttack() ? 0 : this.dmg; // The dmg = 0 if the highlander can attack, in reality, he attack with 0 dmg.
	
		super.attack(at, round);
		
		this.dmg = 12;
		
		addAttack(); // Increment the attack number for check every 3 times.
	}
}
