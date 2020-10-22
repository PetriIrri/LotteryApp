package fi.tuni.tamk.tiko.petriirri.utils;

import fi.tuni.tamk.tiko.petriirri.utils.MyConsole;
import fi.tuni.tamk.tiko.petriirri.utils.ArrayHelper;
/**
* LottoHelper implements different methods that are used to play lotto.
*
* The main points of this program are: asking users lottery numbers, 
* generating random lottery numbers within given parameters and checking
* the lottery results
*
* @author Petri Irri
* @version 1.0
* @since 2020-10-20
*/
public class LottoHelper {
    /**
    * Asks the user for a given amount of lotto numbers.
    *
    * The method checks if the given numbers is within acceptable range
    * and that it is not yet given. The numbers are then put in to an
    * integer array that is returned
    *
    * @param userLottoNumbers is the given array to which we put the users numbers in
    * @param amount tells us how many numbers we need to ask from the user
    * @param max is the maximium value of the drawn number
    * @return int [] array filled with users numbers
    */
    public static int [] askUserLottoNumbers(int [] userLottoNumbers, int amount, int max) {
        int i = 0;
        while(i < amount) {
            System.out.println("Please give an unique number between 1 and " + max);
            int lottoNumber = MyConsole.readInt();
            //check if lottonumber is in range and not already in array
            if(lottoNumber <= max && lottoNumber > 0 && ArrayHelper.arrayContains(userLottoNumbers, lottoNumber) == false) {
                userLottoNumbers [i] = lottoNumber;
                i++;
            }else {
                System.out.println("The given number wasn't in range or was not unique");
            }
        }
        return userLottoNumbers;
    }
    /**
    * Generates random lotto numbers and puts them in an array.
    *
    * Method first creates an array filled with all the possible numbers
    * and then draws the numbers from it by getting a random index number
    * from method drawNumber
    * 
    * @param lottoNumbers is an array for storing the drawn numbers
    * @param amount is the amount of number drawn
    * @param max is the maximium value of the drawn numbers
    * @return returns an integer array filled with drawn numbers
    */
    public static int [] generateLottoNumbers(int [] lottoNumbers, int amount, int max) {
        int [] numbers = new int [max];// array containing possible values of lotto numbers
        //fill the array with numbers
        numbers = ArrayHelper.fillArray(numbers);
        for(int i = 0; i < amount; i++) {
            int randomIndex = drawNumber(numbers);
            lottoNumbers[i] = numbers[randomIndex];
            numbers = ArrayHelper.removeIndex(numbers, randomIndex);
        }
        return lottoNumbers;
    }
    /**
    * Generates a random number based on the length of the given array.
    *
    * First generates a random number with Math.random() and
    * multiplies it with the length of a given array thus giving
    * a random index from the array
    * 
    * @param numbers is an array from which we want to draw a random index from
    * @return returns a random index number
    */
    public static int drawNumber(int [] numbers) {
        int randomNum = (int) (Math.random() * numbers.length);
        return randomNum;
    }
    /**
    * Checks how many numbers match between two arrays.
    *
    * The program starts by comparing one number to all the other numbers
    * in the other array.
    *
    *@param userLottoNumbers is the first array which we compare
    *@param lottoNumbers is the second array which is compared to
    *@return returns the number of matches between the arrays
    */
    public static int checkLottoResults(int [] userLottoNumbers, int [] lottoNumbers) {
        int numOfMatches = 0;
        //check how many matches we get between the two arrays
        for(int i = 0; i < userLottoNumbers.length; i++) {
            for(int j = 0; j < userLottoNumbers.length; j++) {
                if(userLottoNumbers[i] == lottoNumbers[j]) {
                    numOfMatches++;
                }
            }
            
        }
        return numOfMatches;
    }
    /**
    * Saves the week number of when we got the number right the first time.
    *
    * Method checks first that the amount of numbers right is higher than 0
    * then we check if the index in the array is empty
    * put the week number into the array to corresponding index.
    * such as: 1 number right week number goes to index 0. numbersRight 
    * must be higher than 0 for this method to do anything. 
    *
    *@param weekArray is the array to which we save the week numbers
    *@param week is the week that we want to save into the array
    *@param numbersRight is the amount of numbers that were rigth
    *@return returns the weekArray with saved week numbers
    */
    public static int [] saveWeeks(int [] weekArray, int week, int numbersRight) {
        //check if numbersRight is not 0
        if(numbersRight != 0) {
            //loop through the array and check if there is a value present at the index
            for(int i = 0; i < weekArray.length; i++) {
                //if there is no value and index is <= numbersRight value
                if(weekArray[i] == 0 && i < numbersRight) {
                    //save the week number in the array
                    weekArray[i] = week;
                }
            }
        }
        return weekArray;
    }
    /**
    * Prints the statistics at the end of an end of lotto round.
    *
    * When printing the information of how long it took to get
    * how many numbers rigth and the weeks are transformed to years.
    *
    *@param weekArray contains the saved information of when we got the numbers right
    *@param userLottoNumbers contains the users lottery numbers
    *@param lottoNumbers contains the drawn lottery numbers
    */
    public static void printStatistics(int [] weekArray, int [] userLottoNumbers, int [] lottoNumbers) {
        int years = 0;
        //loop through weekArray values and calculate how many years it took to get numbers right
        for(int i = 0; i < weekArray.length; i++) {
            years = weekArray[i] / 52; //precise value would be 52.177457
            System.out.println(i + 1 + " numbers right in " + years + " years!");
        }
    }
}