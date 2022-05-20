package com.company;

import java.util.Scanner;

public class Game {
    private final Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
    }

    private String setPlayerName() {
        System.out.println("Enter your name");
        return scanner.nextLine();
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void duel(Character player, Character challenger) {
        // pick a number between 1 and 100
        // the computer picks a random number between 1 and 100
        // the challenger picks higher or lower
        // if your number is
        System.out.println("Pick a number between 1 and 100.");
        System.out.println("A number will be chosen at random between 1 and 100");
        System.out.println("Your challenger will pick higher or lower");
        System.out.println("If the challenger chooses higher, your number must be higher than the randomly selected number.");
        System.out.println("Similarly, if the challenger chooses lower, your number must be lower than the randomly selected number.");
        System.out.println("What number do you select?");

        int playerNumber = scanner.nextInt();
        int computerNumber = getRandomNumber(1, 100);
        boolean isHigher = Math.pow((-1), Math.random() * 1000) > 0;

        boolean playerWins;
        if (isHigher) {
            System.out.println("Let's hope you chose higher...");
            if (playerNumber > computerNumber) {
                System.out.println("You won!");
                System.out.println("Her father gifts you new cowboy boots.");
                Item boots = new Item("boots", 75);
                player.addItem(boots);
            } else {
                System.out.println("You lose!");
                player.reduceHealth(50);
            }
        } else {
            System.out.println("Let's hope you chose lower...");
            if (playerNumber < computerNumber) {
                System.out.println("You won!");
                System.out.println("Her father gifts you new cowboy boots.");
                Item boots = new Item("boots", 75);
                player.addItem(boots);
            } else {
                System.out.println("You lose!");
                player.reduceHealth(50);
            }
        }

    }

    private void milkTheCow(Character player) {
        System.out.println("How do you want to milk the cow?");
        System.out.println("1. From the side\n2. From behind ;)");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                // From the side
                System.out.println("From the side");
                System.out.println("Here's some milk! Good job :)");
                Item milk = new Item("milk", 50);
                player.addItem(milk);
                break;
            case "2":
                // From behind ;)
                System.out.println("From behind ;)");
                System.out.println("She didn't like that and you go kicked in the face...");
                System.out.println("You lost 10 health points");
                player.reduceHealth(10);
                break;
            default:
                System.out.println("That's not an option!");
                System.out.println("You contracted dysentary");
                player.contractDysentary();
                break;
        }
    }

    private void goToHoeDown(Character player) {
        System.out.println("Hope you're wearing your dancing shoes!");
        System.out.println("A fine lady approaches and asks you to dance..");
        System.out.println("Do you accept? (y/n)");
        String option = scanner.nextLine();
        boolean proceed = false;
        while (!proceed) {
            switch (option) {
                case "y":
                    // time to dance
                    System.out.println("Let's dance!");
                    proceed = true;
                    break;
                case "n":
                    // time to duel
                    System.out.println("Her father is angry at your rejection (even if she isn't the best looking...)");
                    System.out.println("He challenges you to a duel!");
                    Character theDad = new Character("Daddy", Roles.ANTAGONIST);
                    duel(player, theDad);
                    proceed = true;
                    break;
                default:
                    System.out.println("That's not an option!");
                    break;
            }
        }

    }

    private void runGame(Character player) {
        while (player.getHealth() > 0) {
            System.out.println("What do you want to do next?");
            System.out.println("1. Milk the cow\n2. Go to the hoedown\n3. Duel for the loot\n4. Go up brokeback mountain with Heath");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    // milk the cow
                    System.out.println("Milk the cow");
                    milkTheCow(player);
                    break;
                case "2":
                    // go to the hoedown
                    System.out.println("Go to the hoedown");
                    goToHoeDown(player);
                    break;
                case "3":
                    // duel for the loot
                    System.out.println("duel for the loot");
                    break;
                case "4":
                    // go up brokeback
                    System.out.println("go up brokeback (get some with heath)");
                    break;
                default:
                    System.out.println("That option doesn't exist!");
            }
            System.out.println("Your health is currently at: " + player.getHealth());
        }
    }

    public void startGame() {
        Character player = new Character(setPlayerName(), Roles.PROTAGONIST);
        System.out.println("Welcome to the cowboy shitshow rodeo " + player.getName());
        runGame(player);
    }
}
