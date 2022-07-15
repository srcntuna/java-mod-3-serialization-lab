package OptionServices;

import InputServices.UserInputService;

public class OptionsService {

    private UserInputService userInputService;

    public OptionsService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }


    public int getInitialOption(){
        printInitialOptions();
        String optionStr = userInputService.getUserInput();
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > 4){
                System.out.println("Please type a number for option within range!");
                return getInitialOption();
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return getInitialOption();
        }
        return option;
    }

    public int getToDoOption(){
        printToDoOptions();
        String optionStr = userInputService.getUserInput();
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > 3){
                System.out.println("Please type a number for option within range!");
                return getToDoOption();
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return getToDoOption();
        }
        return option;


    }


    public void printToDoOptions(){

        System.out.println("Please choose an option!");
        System.out.println(" ----------- Options ---------------------- ");
        System.out.println("|  1.    Add a person to the list.         |");
        System.out.println("|  2.    Print a list of current persons.  |");
        System.out.println("|  3.    Exit the program.                 |");
        System.out.println(" ------------------------------------------ ");
    }

    public void printInitialOptions(){

        System.out.println("WELCOME!");
        System.out.println("Please choose an option!");
        System.out.println(" ------------------ Options ----------------------- ");
        System.out.println("|  1.    Restore the list of people from CSV file  |");
        System.out.println("|  2.    Restore the list of people from JSON file |");
        System.out.println("|  3.    Start a brand new list for CSV file.      |");
        System.out.println("|  4.    Start a brand new list for JSON file.     |");
        System.out.println(" -------------------------------------------------- ");

    }


}
