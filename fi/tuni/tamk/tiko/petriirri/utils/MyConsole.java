package fi.tuni.tamk.tiko.petriirri.utils;

import java.io.Console;
/**
* MyConsole class is responsible for reading user inputs.
*
* Contains method readInt which reads int input with Console
*
* @author Petri Irri
*/
public class MyConsole {
    /**
    * Method readInt reads user inputs and returns it as an integer.
    *
    * If the input is not an integer it will ask the user for new input until the given input is an integer.
    *
    * @return returns the inputted integer
    */
    public static int readInt() {
        Console c = System.console();
        int input = 0;
        boolean inputIsInteger = false;
        while (inputIsInteger == false) {
            try {
                input = Integer.parseInt(c.readLine());
                inputIsInteger = true;
            } catch(NumberFormatException e) {
                System.out.println("Please give an integer");
            }
        }
        return input;
    }
}