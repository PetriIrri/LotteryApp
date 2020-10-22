package fi.tuni.tamk.tiko.petriirri;

import fi.tuni.tamk.tiko.petriirri.utils.MyConsole;
import fi.tuni.tamk.tiko.petriirri.utils.LottoHelper;
import fi.tuni.tamk.tiko.petriirri.utils.ArrayHelper;

/**
* This is the main class of this LottoApp.
*
* The purpose of the lotto app is to showcase how unlikely it is to win a lottery.
* The program asks the user for his numbers and then the program draws random numbers which are compared to the users numbers.
* This is continued until user gets all the numbers right and he has won it in a lifetime (120 years = 6240 weeks)
*
*@author Petri Irri
*@version 1.0
*@since 2020-10-20
*/
public class LottoApp {
    public static final int numOfLottoNumbers = 10; //the amount of lotto numbers
    public static final int maxLottoNumber = 120; // the highest possible lotto number: 1 - maxLottoNumber
    /**
    * The main method of lottoApp
    *
    * @param args User can use args to tell the program his lottery numbers
    */
    public static void main(String[] args) {
        boolean victory = false;
        //create users lotto array
        int [] userLottoNumbers = ArrayHelper.createLottoArray(numOfLottoNumbers);
        //check if we have received any args and if there are correct number of them
        if(args.length == numOfLottoNumbers) {
            //take lotto numbers from args
            userLottoNumbers = ArrayHelper.stringArrayToInt(args);
        }else {
            //ask the lotto numbers from the user
            LottoHelper.askUserLottoNumbers(userLottoNumbers, numOfLottoNumbers, maxLottoNumber);
        }
        //sort userLottoNumbers
        userLottoNumbers = ArrayHelper.sortArray(userLottoNumbers);
        //create lotto array
        int [] lottoNumbers = ArrayHelper.createLottoArray(numOfLottoNumbers);
        System.out.println("Starting the lottery machine!");
        //Start anew if user has not won in a lifetime
        while(victory == false) {
            boolean jackpot = false;
            int [] weekArray = new int [numOfLottoNumbers];
            int week = 0;//keeps track of how many weeks we have played lotto
            //continue playing while user has not got 7 right
            while(jackpot == false) {
                //count how many weeks we have played
                week++;
                //generate lotto numbers
                lottoNumbers = LottoHelper.generateLottoNumbers(lottoNumbers, numOfLottoNumbers, maxLottoNumber);
                //check how many numbers user got right
                int numbersRight = LottoHelper.checkLottoResults(userLottoNumbers, lottoNumbers);
                //save the week number when we got numbers right
                weekArray = LottoHelper.saveWeeks(weekArray, week, numbersRight);
                //if numbersRight value is numOfLottoNumbers value then we have hit the jackpot
                if(numbersRight >= numOfLottoNumbers) {
                    System.out.println("Jackpot");
                    jackpot = true;
                }
            }
        //sort generated lotto numbers
        lottoNumbers = ArrayHelper.sortArray(lottoNumbers);
        //print out the statistics
        LottoHelper.printStatistics(weekArray, userLottoNumbers,lottoNumbers);
            if(week <= 6240) {
                System.out.println("You won in a lifetime!");
                victory = true;
            }else {
                System.out.println("You didn't win in a lifetime (120 years), so lets try it again!");
            }
        }
    }
}