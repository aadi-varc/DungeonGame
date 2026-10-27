public class Player {
    private int playerhp = 100;
    private int attack = 10;
    private int row;
    private int col;
    
    public Player(int health, int damage, int startingRow, int startingColumn) {
    	this.playerhp = health;
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
	this.playerhp = playerhp;
}


public int getAttack()
{
	return attack;
}
public void takeDamage(int damage) {
    this.playerhp -= damage;
    if (this.playerhp < 0) {
        this.playerhp = 0;
    }
}
}

