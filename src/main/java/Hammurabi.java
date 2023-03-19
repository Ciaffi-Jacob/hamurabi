
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    private int price;
    private int bushels;
    private int population;
    private int currentYear;
    private  int acres;
    private  int acresFarmed;
    private  int bushelsFedToPeople;
    private int howManyPeopleStarved;
    private  int howManyPeopledDiedFromPlague;
    private int imm;
    private int harv;
    private int totalPeopleDiedByPlague;
    private  int totalHarvest;
    private int totalImmigrants;
    private int totalStarved;
   private  int totalGrainEatenByRats;


    public  static void  main(String[] args){
        Hammurabi ham = new Hammurabi();
        ham.playGame();
    }
    public void playGame() {
    initializeGame();
    while(currentYear <= 1) {
        askHowManyAcresToBuy(price, bushels);
        askHowManyAcresToSell(acres);
        askHowMuchGrainToFeedPeople(bushels);
        askHowManyAcresToPlant(acres, population, bushels);

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

    public int askHowManyAcresToBuy(int price, int bushels){
        int acresBought;
        System.out.print("The current price for one acre is " + price + " bushels.\n" +
                "There are currently " + population + " citizens, " + bushels + " bushels, and " + acres + " acres available.\n" +
                "How many acres would you like to buy?\n");
        while (true) {
            try {
                acresBought = scanner.nextInt();
                if(acresBought * price > bushels){
                    System.out.println("Not enough bushels.");
                } else if (acresBought < 0) {
                    System.out.println("Must be positive.");
                }else if(acresBought == 0){

                    break;
                }
                else {break;}
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
                scanner.next();
            }
        }
        this.bushels = (bushels - (acresBought * price));
        acres = acres + acresBought;
        return acresBought;
    }
    public int askHowManyAcresToSell(int acres){
        int acresSold;
        System.out.print("The current value of one acre is " + price + " bushels.\n" +
                "There are currently " + population + " citizens, " + bushels + " bushels, and " + acres + " acres available.\n" +
                "How many acres would you like to sell?\n");
        while (true) {
            try {
                acresSold = scanner.nextInt();
                if(acresSold > acres){
                    System.out.println("Not enough acres.");
                } else if (acres < 0) {
                    System.out.println("Must be positive.");
                }else if(acres == 0){

                    break;
                }
                else {break;}
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
                scanner.next();
            }
        }
        this.bushels = (bushels + (acresSold * price));
        this.acres = acres - acresSold;
        return acresSold;
    }
    public  int askHowMuchGrainToFeedPeople(int bushels){
        System.out.print("Each citizen needs 20 bushels to survive the year.\n" +
                "There are currently " + population + " citizens, " + bushels + " bushels, and " + acres + " acres available.\n" +
                "How many bushels would you like to give to citizens?\n");
        while (true) {
            try {
                bushelsFedToPeople = scanner.nextInt();
                if(bushelsFedToPeople> bushels){
                    System.out.println("Not enough bushels.");
                } else if (bushelsFedToPeople < 0) {
                    System.out.println("Must be positive.");
                }else if(bushelsFedToPeople == 0){

                    break;
                }
                else {break;}
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
                scanner.next();
            }
        }
        this.bushels = (bushels  - bushelsFedToPeople);
        return bushelsFedToPeople;
    }
    public  int askHowManyAcresToPlant(int acres, int population, int bushels){
        System.out.print("Citizens can farm 10 acres. And each acre of farming takes 2 bushels.\n" + 
                        "There are currently " + population + " citizens, " + bushels + " bushels, and " + acres + " acres available.\n" +
                "How many acres would you like to farm?\n");
        while (true) {
            try {
                acresFarmed = scanner.nextInt();
                if(acresFarmed > acres){
                    System.out.println("Not enough acres.");
                } else if (acresFarmed > population * 10) {
                    System.out.println("Not enough citizens.");
                } else if (acresFarmed * 2 > bushels) {
                    System.out.println("Not enough bushels.");
                    
                } else if (acresFarmed < 0) {
                    System.out.println("Must be positive.");
                }else if(acresFarmed == 0){

                    break;
                }
                else {break;}
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
                scanner.next();
            }
        }
        this.bushels = (bushels - (acresFarmed * 2));
        return  acresFarmed;
    }
    public  int plagueDeaths(int population){
        int randPlague;
        randPlague = rand.nextInt(20);
        if (randPlague > 16){
            howManyPeopledDiedFromPlague = (population / 2);
        }
        else howManyPeopledDiedFromPlague = 0;
        return  howManyPeopledDiedFromPlague;
    }
    public  int starvationDeaths(int population, int bushelsFedToPeople){
        if ((bushelsFedToPeople / 20) <= population) {
            howManyPeopleStarved = (population - (bushelsFedToPeople / 20));
        }
        return howManyPeopleStarved;
    }
    public  boolean uprising(int population, int howManyPeopleStarved){
        if (population == 0){
            return true;
        }
        else if ((howManyPeopleStarved * 100) / population >= 45){
            return true;
        }
        else {return false;
        }
    }
    public int immigrants(int population, int acres, int bushels){
        imm = 0;
        if (howManyPeopleStarved == 0){
            imm = ((20 * acres + bushels) / (100 * population) + 1);
        }

        return imm;
    }
    public  int harvest(int acresFarmed){
        harv = ((rand.nextInt(6)+1) * acresFarmed);
        return harv;
    }
    public  int grainEatenByRats(int bushels){
        int ratChance = rand.nextInt(10);
        int amountEaten = 0;
        if (ratChance > 5){
            amountEaten = (rand.nextInt(21) + 10);
        }
        return amountEaten;
    }
    public int newCostOfLand(){
        price = rand.nextInt(7) + 17;
        return price;
    }
    public String printSummary(){

        totalPeopleDiedByPlague += plagueDeaths(population);
        this.population -= plagueDeaths(population);
        System.out.println(howManyPeopledDiedFromPlague + " people died by plague.");

        totalStarved += starvationDeaths(population,bushelsFedToPeople);
        this.population -= howManyPeopleStarved;
        System.out.println(howManyPeopleStarved + " people died by starvation.");

        if(uprising(population, howManyPeopleStarved)) {
            currentYear = 11;
            System.out.println("\nUprising!\nYou have been overthrown!\n");
        }

        totalImmigrants += immigrants(population, acres, bushels);
        this.population += immigrants(population, acres, bushels);
        System.out.println(imm + " people immigrated to your land.");

        totalHarvest += harvest(acresFarmed);
        this.bushels += harvest(acresFarmed);
        System.out.println(harv + " bushels harvested.");

        totalGrainEatenByRats += grainEatenByRats(bushels);
        this.bushels -= ((grainEatenByRats(bushels) * bushels) / 100);
        System.out.println(grainEatenByRats(bushels) + " bushels eaten by rats.");




        return  null;
    }
    public  String finalSummary(){
        System.out.println(totalPeopleDiedByPlague + " people in total died by plague.\n" +
                            totalStarved + " people in total died by starvation.\n" +
                        totalImmigrants + " people in total immigrated to your land.\n" +
                        totalHarvest + " bushels in total were harvested.\n" +
                        totalGrainEatenByRats + " bushels in total were eaten by rats.\n");

        return null;
    }
}
