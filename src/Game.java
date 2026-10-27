import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        char[][] map =
        {
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','.','.','.','.','X','#'},
            {'#','.','.','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#'}
        };

        Player player = new Player(100, 10, 1, 1);

        Enemy enemy = new Enemy(40, 10, 1, 5);

        int exitRow = 1;
        int exitCol = 8;

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            updateMap(map, player, enemy);

            printMap(map);

            System.out.println();
            System.out.println("Player HP: " + player.getPlayerhp());
            System.out.println("Use W A S D to move");

            String move = scanner.nextLine();

            // Move Up
            if(move.equalsIgnoreCase("W"))
            {
                int newRow = player.getRow() - 1;

                if(map[newRow][player.getCol()] != '#')
                {
                    player.setRow(newRow);
                }
            }

            // Move Down
            if(move.equalsIgnoreCase("S"))
            {
                int newRow = player.getRow() + 1;

                if(map[newRow][player.getCol()] != '#')
                {
                    player.setRow(newRow);
                }
            }

            // Move Left
            if(move.equalsIgnoreCase("A"))
            {
                int newCol = player.getCol() - 1;

                if(map[player.getRow()][newCol] != '#')
                {
                    player.setCol(newCol);
                }
            }

            // Move Right
            if(move.equalsIgnoreCase("D"))
            {
                int newCol = player.getCol() + 1;

                if(map[player.getRow()][newCol] != '#')
                {
                    player.setCol(newCol);
                }
            }

            // Enemy encounter
            if(player.getRow() == enemy.getRow() &&
               player.getCol() == enemy.getColumn())
            {
                System.out.println();
                System.out.println("Battle Started!");

                break;
            }

            // Exit reached
            if(player.getRow() == exitRow &&
               player.getCol() == exitCol)
            {
                updateMap(map, player, enemy);

                printMap(map);

                System.out.println();
                System.out.println("Congratulations!");
                System.out.println("You escaped the dungeon!");

                break;
            }
        }

        scanner.close();
    }

    public static void updateMap(char[][] map, Player player, Enemy enemy)
    {
        // Clear old positions
        for(int row = 0; row < map.length; row++)
        {
            for(int col = 0; col < map[row].length; col++)
            {
                if(map[row][col] == 'P' || map[row][col] == 'E')
                {
                    map[row][col] = '.';
                }
            }
        }

        // Place enemy
        if(!enemy.isDead())
        {
            map[enemy.getRow()][enemy.getColumn()] = 'E';
        }

        // Place player
        map[player.getRow()][player.getCol()] = 'P';
    }

    public static void printMap(char[][] map)
    {
        for(int row = 0; row < map.length; row++)
        {
            for(int col = 0; col < map[row].length; col++)
            {
                System.out.print(map[row][col]);
            }

            System.out.println();
        }
    }
}
