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

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            updateMap(map, player);

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
        }
    }

    public static void updateMap(char[][] map, Player player)
    {
        // Remove old player position
        for(int row = 0; row < map.length; row++)
        {
            for(int col = 0; col < map[row].length; col++)
            {
                if(map[row][col] == 'P')
                {
                    map[row][col] = '.';
                }
            }
        }

        // Place player in new position
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