import java.util.Scanner;

public class Game {

    private static final int TOTAL_ROUNDS = 2;
    private static final int POTION_HEAL = 20;

    public static void main(String[] args) {

        char[][] map = {
                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
                        '#', '#', '#', '#' },
                { '#', '.', '.', '.', '.', '.', '.', 'E', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '#' },
                { '#', '.', '.', '#', '#', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '#' },
                { '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '#' },
                { '#', '.', '.', '.', '.', 'E', '.', '.', '.', '.', '#', '#', '#', '#', '.', '#', '.', '.', '.', '.',
                        '.', '.', '.', '#' },
                { '#', '.', '.', '.', '.', '.', '#', '#', '#', '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.',
                        '.', '.', '.', '#' },
                { '#', '.', '.', '.', '.', '.', '#', 'B', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.',
                        '.', '.', '.', '#' },
                { '#', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', 'X', '#', '#', '#', '#', '#',
                        '#', '#', '#', '#' },
                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
                        '#', '#', '#', '#' }
        };

        Player player = new Player(100, 10, 1, 1);

        Enemy enemy = new Enemy(40, 10, 1, 5);

        Boss boss = new Boss(60, 10, 6, 7);

        int exitRow = 7;
        int exitCol = 14;
        int round = 1;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            updateMap(map, player, enemy, boss, exitRow, exitCol);

            clearScreen();
            printMap(map);

            System.out.println();
            if (player.getRow() == exitRow &&
                    player.getCol() == exitCol &&
                    !boss.isDead()) {
                System.out.println("Defeat the Boss first");
            }
            System.out.println("Round: " + round + " of " + TOTAL_ROUNDS + " | Player HP: " + player.getPlayerhp());
            if (boss.isDead()) {
                System.out.println("Objective: Reach X to finish this round");
            } else {
                System.out.println("Objective: Defeat the Boss, then reach X");
            }
            System.out.println("W A S D: Move | Q: Quit");

            String move = readCommand(scanner);
            if (move.equalsIgnoreCase("Q")) {
                scanner.close();
                return;
            }

            // Move Up
            if (move.equalsIgnoreCase("W")) {
                int newRow = player.getRow() - 1;

                if (map[newRow][player.getCol()] != '#') {
                    player.setRow(newRow);
                }
            }

            // Move Down
            if (move.equalsIgnoreCase("S")) {
                int newRow = player.getRow() + 1;

                if (map[newRow][player.getCol()] != '#') {
                    player.setRow(newRow);
                }
            }

            // Move Left
            if (move.equalsIgnoreCase("A")) {
                int newCol = player.getCol() - 1;

                if (map[player.getRow()][newCol] != '#') {
                    player.setCol(newCol);
                }
            }

            // Move Right
            if (move.equalsIgnoreCase("D")) {
                int newCol = player.getCol() + 1;

                if (map[player.getRow()][newCol] != '#') {
                    player.setCol(newCol);
                }
            }

            // Enemy battle
            if (player.getRow() == enemy.getRow() &&
                    player.getCol() == enemy.getColumn() &&
                    !enemy.isDead()) {
                updateMap(map, player, enemy, boss, exitRow, exitCol);
                String battleMessage = "Battle Started!";

                while (player.isAlive() && !enemy.isDead()) {
                    printBattleScreen(map, player, round);
                    System.out.println(battleMessage);
                    System.out.println("Enemy HP: " + enemy.getHealth());
                    System.out.println("Press F to attack or Q to quit");

                    String attackMove = readCommand(scanner);
                    if (attackMove.equalsIgnoreCase("Q")) {
                        scanner.close();
                        return;
                    }

                    if (attackMove.equalsIgnoreCase("F")) {
                        int enemyHealthBeforeAttack = enemy.getHealth();
                        enemy.takeDamage(20);

                        battleMessage = "You dealt " + (enemyHealthBeforeAttack - enemy.getHealth()) + " damage!";

                        if (enemy.isDead()) {
                            int healthRestored = player.heal(POTION_HEAL);

                            printBattleScreen(map, player, round);
                            System.out.println(battleMessage);
                            System.out.println("Enemy HP: " + enemy.getHealth());
                            System.out.println("Enemy Defeated!");
                            System.out.println("Health Potion Found!");
                            System.out.println("+" + healthRestored + " HP Restored");
                            if (!waitForContinue(scanner)) {
                                scanner.close();
                                return;
                            }

                            break;
                        }

                        int playerHealthBeforeAttack = player.getPlayerhp();
                        player.takeDamage(enemy.attack());

                        battleMessage += "\nEnemy dealt " + (playerHealthBeforeAttack - player.getPlayerhp()) + " damage!";

                        if (!player.isAlive()) {
                            printBattleScreen(map, player, round);
                            System.out.println(battleMessage);
                            System.out.println("Enemy HP: " + enemy.getHealth());
                            System.out.println("Game Over!");

                            System.out.println();
                            System.out.println("Press R to restart or Q to quit");

                            String choice = readCommand(scanner);
                            if (choice.equalsIgnoreCase("R")) {
                                main(new String[0]);
                                return;
                            } else {
                                scanner.close();
                                return;
                            }
                        }
                    }
                }
            }

            // Boss battle
            if (player.getRow() == boss.getRow() &&
                    player.getCol() == boss.getColumn() &&
                    !boss.isDead()) {
                updateMap(map, player, enemy, boss, exitRow, exitCol);
                String battleMessage = "Boss Battle Started!";

                while (player.isAlive() && !boss.isDead()) {
                    printBattleScreen(map, player, round);
                    System.out.println(battleMessage);
                    System.out.println("Boss HP: " + boss.getHealth());
                    System.out.println("Press F to attack or Q to quit");

                    String attackMove = readCommand(scanner);
                    if (attackMove.equalsIgnoreCase("Q")) {
                        scanner.close();
                        return;
                    }

                    if (attackMove.equalsIgnoreCase("F")) {
                        int bossHealthBeforeAttack = boss.getHealth();
                        boss.takeDamage(20);

                        battleMessage = "You dealt " + (bossHealthBeforeAttack - boss.getHealth()) + " damage to the Boss!";

                        if (boss.isDead()) {
                            printBattleScreen(map, player, round);
                            System.out.println(battleMessage);
                            System.out.println("Boss HP: " + boss.getHealth());
                            System.out.println("Boss Defeated!");
                            if (!waitForContinue(scanner)) {
                                scanner.close();
                                return;
                            }
                            break;
                        }

                        int playerHealthBeforeAttack = player.getPlayerhp();
                        player.takeDamage(15);

                        battleMessage += "\nBoss dealt " + (playerHealthBeforeAttack - player.getPlayerhp()) + " damage!";

                        if (!player.isAlive()) {
                            printBattleScreen(map, player, round);
                            System.out.println(battleMessage);
                            System.out.println("Boss HP: " + boss.getHealth());
                            System.out.println("Game Over!");

                            System.out.println();
                            System.out.println("Press R to restart or Q to quit");

                            String choice = readCommand(scanner);
                            if (choice.equalsIgnoreCase("R")) {
                                main(new String[0]);
                                return;
                            } else {
                                scanner.close();
                                return;
                            }
                        }
                    }
                }
            }

            // Win condition
            if (player.getRow() == exitRow &&
                    player.getCol() == exitCol &&
                    boss.isDead()) {
                if (round < TOTAL_ROUNDS) {
                    System.out.println("Round " + round + " complete! Starting round " + (round + 1) + ".");
                    if (!waitForContinue(scanner)) {
                        scanner.close();
                        return;
                    }

                    round++;
                    player.setRow(1);
                    player.setCol(1);
                    enemy = new Enemy(50, 20, 3, 10);
                    boss = new Boss(60, 10, 6, 7);

                    // Move the entrance to the other side of the boss's tunnel.
                    map[5][6] = '.';
                    map[5][7] = '.';
                    map[5][14] = '#';
                    continue;
                }

                updateMap(map, player, enemy, boss, exitRow, exitCol);

                clearScreen();
                printMap(map);

                System.out.println();
                System.out.println("Congratulations!");
                System.out.println("You escaped the dungeon!");
                System.out.println("You defeated the Boss and completed the game!");

                System.out.println();
                System.out.println("Press R to restart or Q to quit");

                String choice = readCommand(scanner);
                if (choice.equalsIgnoreCase("Q")) {
                    break;
                } else if (choice.equalsIgnoreCase("R")) {
                    main(new String[0]);
                    return;
                }
            }
        }

        scanner.close();
    }

    private static String readCommand(Scanner scanner) {
        return scanner.hasNextLine() ? scanner.nextLine() : "Q";
    }

    private static boolean waitForContinue(Scanner scanner) {
        System.out.println("Press Enter to continue or Q to quit");
        return !readCommand(scanner).equalsIgnoreCase("Q");
    }

    private static void printBattleScreen(char[][] map, Player player, int round) {
        clearScreen();
        printMap(map);
        System.out.println();
        System.out.println("Round: " + round + " of " + TOTAL_ROUNDS + " | Player HP: " + player.getPlayerhp());
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void updateMap(char[][] map, Player player, Enemy enemy, Boss boss, int exitRow, int exitCol) {
        // Clear old positions
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 'P' ||
                        map[row][col] == 'E' ||
                        map[row][col] == 'B') {
                    map[row][col] = '.';
                }
            }
        }

        // Restore the exit after the player moves away from it.
        map[exitRow][exitCol] = 'X';

        // Place enemy
        if (!enemy.isDead()) {
            map[enemy.getRow()][enemy.getColumn()] = 'E';
        }

        // Place boss
        if (!boss.isDead()) {
            map[boss.getRow()][boss.getColumn()] = 'B';
        }

        // Place player
        map[player.getRow()][player.getCol()] = 'P';
    }

    public static void printMap(char[][] map) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                System.out.print(map[row][col]);
            }

            System.out.println();
        }
    }
}
