package Pokemon;

/**
 * 
 * @author Jordyn
 *
 */

public class Pokemon {

	//Fields
	private int healthPoints;
	private int level;
	private int attackPoints;
	private int defensePoints;
	private String type;
	private String name;
	
	//Constructor
	public Pokemon(int hp, int l, int a, int d, String t, String n) {
		healthPoints = hp;
		level = l;
		attackPoints = a;
		defensePoints = d;
		type = t;
		name = n;
	}
	
	//Methods
	
	
	//Get Methods
	public int getHealth() {
		return healthPoints;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getAttack() {
		return attackPoints;
	}
	
	public int getDefense() {
		return defensePoints;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
}
