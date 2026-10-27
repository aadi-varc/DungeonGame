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

}
