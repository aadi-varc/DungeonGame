public class Player {
    private int playerhp = 100;
    private final int maxHealth;
    private int attack = 10;
    private int row;
    private int col;
    
    public Player(int health, int damage, int startingRow, int startingColumn) {
    	this.maxHealth = health;
    	setPlayerhp(health);
    	this.attack = damage;
    	this.row= startingRow;
    	this.col= startingColumn;
    }

    public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

public boolean isAlive() {
     if(playerhp>0){
        return true;
     }
     else {
        return false;
     }
    
}

public int getPlayerhp() {
	return playerhp;
}

public void setPlayerhp(int playerhp) {
	if (playerhp < 0) {
		this.playerhp = 0;
	} else {
		this.playerhp = Math.min(maxHealth, playerhp);
	}
}

public int heal(int amount) {
    int previousHealth = playerhp;
    setPlayerhp(playerhp + amount);
    return playerhp - previousHealth;
}


public int getAttack()
{
	return attack;
}
public void takeDamage(int damage) {
    setPlayerhp(this.playerhp - damage);
}
}
