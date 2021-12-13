package snakeandladders;

import java.util.*;

public class Board {
    private Dice dice;
    private Queue<Player> nextPlayer;
    private List<Snake> snakes;
    private  List<Ladder> ladders;
    private  Map<String,Integer> currPosition;
    int boardSize;

    public Board(Dice dice, Queue<Player> nextPlayer, List<Snake> snakes, List<Ladder> ladders,Map<String,Integer> currPosition,int boardSize) {
        this.dice = dice;
        this.nextPlayer = nextPlayer;
        this.snakes = snakes;
        this.ladders = ladders;
        this.currPosition = currPosition;
        this.boardSize = boardSize;
    }

     void startGame(){
        while(nextPlayer.size()>1) {
            Player p = nextPlayer.poll();
            int currentPosition = currPosition.get(p.getPName());
            int diceValue = dice.roll();
            int finalPosition = currentPosition + diceValue;
            if (finalPosition > boardSize) nextPlayer.offer(p);
            else if (finalPosition == boardSize) {
                System.out.println( "Hurray!! "+ p.getPName() + " has won the game");
            }else{
               int[] nextPosition= new int[1];
               boolean[] lad =new boolean[1];
                nextPosition[0]= finalPosition;
               snakes.forEach(move-> {
                   if(move.getHead()==finalPosition) {
                       nextPosition[0] = move.getTail();
                   } } );
               if(nextPosition[0] != finalPosition) System.out.println(p.getPName() + " Ah! There's a snake, dropping to "+ finalPosition);
                ladders.forEach(move-> {
                    if(move.getStart()==finalPosition) {
                        nextPosition[0] = move.getEnd();
                        lad[0]=true;
                    } } );
                if(nextPosition[0] != finalPosition && lad[0]) System.out.println(p.getPName() + " Yay!! a ladder, climb to"+ finalPosition);
                if(nextPosition[0] == boardSize){
                    System.out.println(p.getPName() + " won the game");
                }else{
                    currPosition.put(p.getPName(),nextPosition[0]);
                    System.out.println(p.getPName() + " is at position "+ nextPosition[0]);
                    nextPlayer.offer(p);
                }
            }
        }
    }
}

