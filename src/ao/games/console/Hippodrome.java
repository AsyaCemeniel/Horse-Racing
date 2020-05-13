package ao.games.console;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;
    
    public Hippodrome(List<Horse> list) {
        this.horses = list;
        
    }
    
    public List<Horse> getHorses() {
        return horses;
    }
    
    public void run() throws InterruptedException {
        for(int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
        
    }
    
    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    
    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for( int i = 0; i < 10; i++) {
            System.out.println();
        }
        
    }
    
    public Horse getWinner() {
        return horses.stream().max(Comparator.comparing(Horse::getDistance)).orElse(null);
    }
    
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Horsy", 3, 0));
        game.getHorses().add(new Horse("Peter", 3, 0));
        game.getHorses().add(new Horse("Marusya", 3, 0));
        game.getHorses().add(new Horse("Sus", 3, 0));
        game.getHorses().add(new Horse("Alma", 3, 0));
        game.getHorses().add(new Horse("Bob", 3, 0));

        game.run();
        game.printWinner();
        
    }
}