public class Game {

    public static void main(String[] args) {

        char[][] map =
        {
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','P','.','.','.','.','.','.','X','#'},
            {'#','.','.','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#'}
        };

        printMap(map);
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