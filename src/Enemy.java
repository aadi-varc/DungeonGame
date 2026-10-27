public class Enemy {
	int health;
	int damage;
	int row;
	int column;
	
	public Enemy(int startingHealth,int startingDamage,int startingRow,int startingColumn) 
	{
		health=startingHealth;
		damage=startingDamage;
		row=startingRow;
		column=startingColumn;
	}
	
	public int attack() 
	{
		return damage;
	}
	
	public void takeDamage(int amount)
	{
		health=health-amount;
		
		if(health<0) 
		{
			health=0;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getRow() {
	    return row;
	}

	public void setRow(int row) {
	    this.row = row;
	}

	public int getColumn() {
	    return column;
	}

	public void setColumn(int column) {
	    this.column = column;
	}
	
	public boolean isDead() {
	    return health <= 0;
	}

}
