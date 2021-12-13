package snakeandladders;

import java.util.*;

public class PlayGame {
    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Queue<Player> allPlayers = new LinkedList<>();
        Map<String,Integer> currPosition=new HashMap<String,Integer>();
        System.out.println("Enter all player names in seperated with spaces");
        Scanner sc= new Scanner(System.in);
        String a= sc.nextLine();  
        String[] x=a.split("\\s");
        for(String n:x) {
            Player p=new Player(n,0);
            currPosition.put(n,0);
            allPlayers.offer(p);
        }
        sc.close();
        Snake snake1 = new Snake(97,20);
        Snake snake2 = new Snake(60,45);
        Snake snake3 = new Snake(80,62);
        Snake snake4 = new Snake(45,33);
        Snake snake5 = new Snake(21,17);
        List<Snake> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);
        snakes.add(snake4);
        snakes.add(snake5);
        Ladder ladder1 = new Ladder(5,15);
        Ladder ladder2 = new Ladder(22,89);
        Ladder ladder3 = new Ladder(43,74);
        Ladder ladder4 = new Ladder(57,66);
        Ladder ladder5 = new Ladder(84,96);
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        ladders.add(ladder3);
        ladders.add(ladder4);
        ladders.add(ladder5);
        Board board= new Board(dice, allPlayers, snakes, ladders, currPosition, 100);
        board.startGame();
    }
}
