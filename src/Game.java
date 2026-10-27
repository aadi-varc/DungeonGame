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

            if(move.equalsIgnoreCase("W"))
            {
                player.setRow(player.getRow() - 1);
            }

            if(move.equalsIgnoreCase("S"))
            {
                player.setRow(player.getRow() + 1);
            }

            if(move.equalsIgnoreCase("A"))
            {
                player.setCol(player.getCol() - 1);
            }

            if(move.equalsIgnoreCase("D"))
            {
                player.setCol(player.getCol() + 1);
            }
        }
    }

    public static void updateMap(char[][] map, Player player)
    {
        // Clear old player positions
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