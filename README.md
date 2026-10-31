# 🎮 Dungeon Adventure Game

Final Java Project for Mathematical Programming


## 👥 Team Members

- Adrian Gonsalves
- Aaditya Bhusal
- Rohit Manjunath


## 📖 Project Overview

Dungeon Adventure Game is a simple adventure game developed in Java.

The player explores a dungeon, encounters enemies, collects potion, defeats the final boss, and reaches the exit to win the game.

This project is primarily focused on demonstrating understanding of Java programming concepts learned during the course lectures such as :

- Variables
- Methods and Functions
- Classes and Objects
- Constructors
- Arrays
- Loops
- Conditional Statements
- User Input
- Inheritance

The project is intentionally designed to be slightly more advanced than the classroom assignments while remaining achievable within our current skill level and
rather than creating a fully featured commercial game with gui and feeback per move , we intended to make this a small collaborative team project where we communicate with each other, update things, polish the game and determine what we could achieve.


## 🎯 Project Goals

The player must:

- Explore the dungeon
- Avoid walls
- Defeat enemies
- Defeat the final boss
 Survive with remaining health
- Reach the exit

### ✅ Win Condition

The player wins if:

1. The boss has been defeated
2. The exit is reached

### ❌ Lose Condition

The player loses if:

- Health (HP) reaches zero


## 🗺️ Example Dungeon Layout

```text
##########
#P.......#
#....E...#
#........#
#....B..X#
##########
```

### Legend

| Symbol | Meaning |
|----------|---------|
| # | Wall |
| P | Player |
| E | Enemy |
| B | Boss |
| X | Exit |
| . | Empty Space |

---

## ⚔️ Combat System

When the player enters a tile occupied by an enemy, a turn-based battle begins.

Example:

```text
Battle Started!

Player attacks!

Enemy HP: 20

Enemy attacks!

Player HP: 85
```

Combat continues until either:

- The enemy's health reaches zero
- The player's health reaches zero

---

## 👹 Boss Enemy

A special Boss enemy will be implemented using inheritance.

Example:

```java
public class Boss extends Enemy
{
}
```

Boss enemies will have stronger statistics than regular enemies.

Example:

```text
Enemy HP  = 40
Enemy DMG = 10

Boss HP   = 100
Boss DMG  = 20
```

---

## 💻 Planned Features

### Core Features

- [x] Fixed dungeon map
- [x] Player movement (WASD)
- [x] Wall collision detection
- [X] Enemy encounters
- [X] Turn-based combat
- [X] Health system
- [X] Boss battle
- [X] Win condition
- [X] Lose condition
- [X] Restart option
- [X] Quit option


## 🧠 Java Concepts Used

### Variables

Examples:

```java
int health = 100;
int damage = 10;
boolean gameOver = false;
```

---

### Arrays

Dungeon layout:

```java
char[][] map;
```

---

### Loops

Game Loop:

```java
while(gameRunning)
{
}
```

Map Display:

```java
for(int row = 0; row < map.length; row++)
{
    for(int col = 0; col < map[row].length; col++)
    {
    }
}
```

---

### Conditions

Examples:

```java
if(isWall)
{
}
```

```java
if(enemyHealth <= 0)
{
}
```

---

### Methods

Examples:

```java
displayMap();

movePlayer();

battle();

restartGame();
```

---

### Classes

```java
Player
Enemy
Boss
Game
```

---

### Constructors

Example:

```java
Player player =
    new Player(100, 10, 1, 1);
```

---

### Inheritance

```java
Boss extends Enemy
```

---

## 🏗️ Project Structure

```text
DungeonGame
│
├── src
│   ├── Game.java
│   ├── Player.java
│   ├── Enemy.java
│   └── Boss.java
│
│
└── README.md
```

---

## 👨‍💻 Team Responsibilities

### Adrian

Responsible for:

- Main game loop
- Dungeon map
- Displaying map
- Player movement
- Integrating project components

Files:

```text
Game.java
```

---

### Aaditya

Responsible for:

- Player class
- Player attributes
- Player combat functions

Files:

```text
Player.java
```

---

### Rohit

Responsible for:

- Enemy class
- Boss class
- Enemy combat functions
- Inheritance implementation

Files:

```text
Enemy.java
Boss.java
```

---

## 🚀 Development Roadmap

### Phase 1

- Project setup
- Map creation
- Display map

### Phase 2

- Player movement
- Wall collision

### Phase 3

- Enemy implementation
- Combat system

### Phase 4

- Boss battle
- Win/Lose conditions

### Phase 5

- Restart system
- Final testing and polishing of the project
- Optional graphical improvements


