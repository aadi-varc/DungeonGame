import java.util.Scanner;


public class Game {


    public static void main(String[] args) {


        char[][] map =
        {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','.','.','.','E','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','.','#','#','#','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','E','.','.','.','.','#','#','#','#','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','.','B','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','X','#','#','#','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };


        Player player = new Player(100, 10, 1, 1);


        Enemy enemy = new Enemy(40, 10, 1, 5);


        Boss boss = new Boss(60, 10, 3, 6);


        int exitRow = 7;
        int exitCol = 13;


        Scanner scanner = new Scanner(System.in);


        while(true)
        {
            updateMap(map, player, enemy, boss);


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


            // Enemy battle
            if(player.getRow() == enemy.getRow() &&
                player.getCol() == enemy.getColumn() &&
                !enemy.isDead())
            {
                System.out.println();
                System.out.println("Battle Started!");


                while(player.isAlive() && !enemy.isDead())
                {
                    System.out.println();
                    System.out.println("Player HP: " + player.getPlayerhp());
                    System.out.println("Enemy HP: " + enemy.getHealth());
                    System.out.println("Press F to attack");


                    String attackMove = scanner.nextLine();


                    if(attackMove.equalsIgnoreCase("F"))
                    {
                        enemy.takeDamage(20);


                        System.out.println("Player attacks!");
                        System.out.println("Enemy HP: " + enemy.getHealth());


                        if(enemy.isDead())
                        {
                            System.out.println("Enemy Defeated!");


                            player.setPlayerhp(player.getPlayerhp() + 20);


                            System.out.println("Health Potion Found!");
                            System.out.println("+20 HP Restored");
                            System.out.println("Current HP: " + player.getPlayerhp());


                            break;
                        }


                        player.takeDamage(10);


                        System.out.println("Enemy attacks!");
                        System.out.println("Player HP: " + player.getPlayerhp());


                        if(!player.isAlive())
                        {
                            System.out.println("Game Over!");


                            System.out.println();
                            System.out.println("Press R to restart or Q to quit");


                            String choice = scanner.nextLine();


                            if(choice.equalsIgnoreCase("R"))
                            {
                                main(new String[0]);
                                return;
                            }
                            else
                            {
                                scanner.close();
                                return;
                            }
                        }
                    }
                }
            }


            // Boss battle
            if(player.getRow() == boss.getRow() &&
                player.getCol() == boss.getColumn() &&
                !boss.isDead())
            {
                System.out.println();
                System.out.println("Boss Battle Started!");


                while(player.isAlive() && !boss.isDead())
                {
                    System.out.println();
                    System.out.println("Player HP: " + player.getPlayerhp());
                    System.out.println("Boss HP: " + boss.getHealth());
                    System.out.println("Press F to attack");


                    String attackMove = scanner.nextLine();


                    if(attackMove.equalsIgnoreCase("F"))
                    {
                        boss.takeDamage(20);


                        System.out.println("Player attacks Boss!");
                        System.out.println("Boss HP: " + boss.getHealth());


                        if(boss.isDead())
                        {
                            System.out.println("Boss Defeated!");
                            break;
                        }


                        player.takeDamage(15);


                        System.out.println("Boss attacks!");
                        System.out.println("Player HP: " + player.getPlayerhp());


                        if(!player.isAlive())
                        {
                            System.out.println("Game Over!");


                            System.out.println();
                            System.out.println("Press R to restart or Q to quit");


                            String choice = scanner.nextLine();


                            if(choice.equalsIgnoreCase("R"))
                            {
                                main(new String[0]);
                                return;
                            }
                            else
                            {
                                scanner.close();
                                return;
                            }
                        }
                    }
                }
            }


            // Win condition
            if(player.getRow() == exitRow &&
               player.getCol() == exitCol &&
               boss.isDead())
            {
                updateMap(map, player, enemy, boss);


                printMap(map);


                System.out.println();
                System.out.println("Congratulations!");
                System.out.println("You escaped the dungeon!");
                System.out.println("You defeated the Boss and completed the game!");


                System.out.println();
                System.out.println("Press R to restart or Q to quit");


                String choice = scanner.nextLine();


                if(choice.equalsIgnoreCase("Q"))
                {
                    break;
                }
                else if(choice.equalsIgnoreCase("R"))
                {
                    main(new String[0]);
                    return;
                }
            }
        }


        scanner.close();
    }


    public static void updateMap(char[][] map, Player player, Enemy enemy, Boss boss)
    {
        // Clear old positions
        for(int row = 0; row < map.length; row++)
        {
            for(int col = 0; col < map[row].length; col++)
            {
                if(map[row][col] == 'P' ||
                   map[row][col] == 'E' ||
                   map[row][col] == 'B')
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


        // Place boss
        if(!boss.isDead())
        {
            map[boss.getRow()][boss.getColumn()] = 'B';
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