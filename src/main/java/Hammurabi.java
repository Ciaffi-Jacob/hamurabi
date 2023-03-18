
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    private int price;
    private int bushels;
    private int acresOwned;
    private int population;
    private int currentYear;
    private  int acres;
    private  int bushelsFedToPeople;
    private int howManyPeopleStarved;
    private  int grainInStorage;
    private int bushelsUsedAsSeed;


    public  static void  main(String[] args){
        Hammurabi ham = new Hammurabi();
        ham.playGame();
    }
    public void playGame() {
    initializeGame();
    while(currentYear <= 1) {
        askHowManyAcresToBuy(price, bushels);
        askHowManyAcresToSell(acresOwned);
        askHowMuchGrainToFeedPeople(bushels);
        askHowManyAcresToPlant(acresOwned, population, bushels);

        plagueDeaths(population);
        starvationDeath(population, bushelsFedToPeople);
        uprising(population, howManyPeopleStarved);
        immigrants(population, acresOwned, grainInStorage);
        harvest(acres, bushelsUsedAsSeed);
        grainEatenByRats(bushels);
        newCostOfLand();

        printSummary();
        currentYear += 1;
    }
        finalSummary();
    }

    public void initializeGame(){
        bushels = 2800;
        population = 100;
        acres = 1000;
        price = 19;
        currentYear = 1;

        System.out.println("O great Hammurabi!\n" +
                            "You are in year 1 of you ten year rule.\n" +
                            "In the previous year 0 people starved to death.\n" +
                            "In the previous year 5 people entered the kingdom.\n" +
                            "The population is now 100.\n" +
                            "We harvested 3000 bushels at 3 bushels per acre.\n" +
                            "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                            "The city owns 1000 acres of land.\n" +
                            "Land is currently worth 19 bushels per acre.\n");

    }
    public int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }
    public int askHowManyAcresToBuy(int price, int bushels){
        int acresBought;
        while (true) {
            System.out.print("The current price for one acre is " + price + " bushels.\n" +
                    "You currently have " + bushels + " bushels.\n" +
                    "How many acres would you like to buy?\n");
            try {
                acresBought = scanner.nextInt();
                if(acresBought * price <= bushels){
                    bushels = bushels - (acresBought * price);
                    acres = acres + acresBought;
                    break;
                } else {
                    System.out.println("You do not have enough bushels.");
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
                scanner.next();
            }
        }
        bushels = bushels - (acresBought * price);
        acres = acres + acresBought;
        return acresBought;
    }
    public int askHowManyAcresToSell(int acresOwned){
        return 0;
    }
    public  int askHowMuchGrainToFeedPeople(int bushels){
        return  0;
    }
    public  int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        return  0;
    }
    public  int plagueDeaths(int population){
        return  0;
    }
    public  int starvationDeath(int population, int bushelsFedToPeople){
        return  0;
    }
    public  boolean uprising(int population, int howManyPeopleStarved){
        return  false;
    }
    public int immigrants(int population, int acresOwned, int grainInStorage){
        return 0;
    }
    public  int harvest(int acres, int bushelsUsedAsSeed){
        return 0;
    }
    public  int grainEatenByRats(int bushels){
        return 0;
    }
    public int newCostOfLand(){
        return 0;
    }
    public String printSummary(){
        return  null;
    }
    public  String finalSummary(){
        return null;
    }
}
