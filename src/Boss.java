public class Boss extends Enemy{
	public Boss(int startingHealth,int startingDamage,int startingRow,int startingColumn) 
	{
		super(startingHealth,startingDamage,startingRow,startingColumn);
	}
	@Override
	public int attack() 
	{
		return getDamage()+5;
	}
}
