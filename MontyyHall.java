package Monty_Redux;

import java.util.*;



class Door {
    boolean Open;
    boolean HasPrize;
    boolean ContestantChosen;

    Door(){
        this.Open = false;
        this.HasPrize = false;
        this.ContestantChosen = false;
    }

}

class PlayingManyGames {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Game TheGame = new Game();
        int choice, wins = 0;

        System.out.println("Press/Type 1 to Always Switch? ");
        System.out.println("Press/Type 2 to Never Switch? ");
        System.out.println("Enter your choice: ");
        choice = Integer.parseInt(sc.nextLine());
        sc.close();

        switch (choice) {
            case 1 -> {
                for (int i = 0; i < 10000; i++) {
                    TheGame.SetUpGame();
                    TheGame.ContestantChosenDoor();
                    TheGame.MonteOpenDoor();
                    TheGame.SwitchDoor();
                    wins += TheGame.win();
                }
                System.out.println("The total number of simulations is " + 10000);
                System.out.println("The number of wins are : " + wins);
                System.out.println("The percentage of wins are : " + wins * 100.0 / 10000 + "%");
            }
            case 2 -> {
                for (int i = 0; i < 10000; i++) {
                    TheGame.SetUpGame();
                    TheGame.MonteOpenDoor();
                    TheGame.ContestantChosenDoor();
                    wins += TheGame.win();
                }
                System.out.println("The total number of simulations is " + 10000);
                System.out.println("The number of wins are : " + wins);
                System.out.println("The percentage of wins are : " + wins * 100.0 / 10000 + "%");
            }
            default -> System.out.println("Invalid choice! Try again. ");
        }
    }
}

class Game {
    static Random r = new Random();
    private Door door1, door2, door3;
    int GrandPrizeDoor, ContestantDoor;

    public void SetUpGame(){
        door1 = new Door();
        door2 = new Door();
        door3 = new Door();

        GrandPrizeDoor = r.nextInt(3);
        switch (GrandPrizeDoor) {
            case 0 -> {
                door1.HasPrize = true;
                door2.HasPrize = false;
                door3.HasPrize = false;
            }
            case 1 -> {
                door1.HasPrize = false;
                door2.HasPrize = true;
                door3.HasPrize = false;
            }
            case 2 -> {
                door1.HasPrize = false;
                door2.HasPrize = false;
                door3.HasPrize = true;
            }
        }
    }
    public void MonteOpenDoor(){
        if(!door1.HasPrize && !door1.ContestantChosen){
            door1.Open = true;
        }
        if(!door2.HasPrize && !door2.ContestantChosen) {
            door2.Open = true;
        }
        if(!door3.HasPrize && !door3.ContestantChosen){
            door3.Open = true;
        }
    }
    public void ContestantChosenDoor(){
        ContestantDoor = r.nextInt(3);
        switch (ContestantDoor) {
            case 0 -> {
                door1.ContestantChosen = true;
                door2.ContestantChosen = false;
                door3.ContestantChosen = false;
            }
            case 1 -> {
                door1.ContestantChosen = false;
                door2.ContestantChosen = true;
                door3.ContestantChosen = false;
            }
            case 2 -> {
                door1.ContestantChosen = false;
                door2.ContestantChosen = false;
                door3.ContestantChosen = true;
            }
        }
    }
    public void SwitchDoor(){
        if(!door1.ContestantChosen && !door1.Open) {
            door1.ContestantChosen = true;
            door2.ContestantChosen = false;
            door3.ContestantChosen = false;
        }
        if(!door2.ContestantChosen && !door2.Open){
            door1.ContestantChosen = false;
            door2.ContestantChosen = true;
            door3.ContestantChosen = false;
        }
        if(!door3.ContestantChosen && !door3.Open){
            door1.ContestantChosen = false;
            door2.ContestantChosen = false;
            door3.ContestantChosen = true;
        }
    }
    public int win(){
        if((door1.HasPrize && door1.ContestantChosen) || (door2.HasPrize && door2.ContestantChosen) || (door3.HasPrize && door3.ContestantChosen)){
            return 1;
        }
        return 0;
    }
}

