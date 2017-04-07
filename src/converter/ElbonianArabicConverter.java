package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;
    private final int strLength;


    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        number.trim(); //remove trailing and leading spaces
        number = number;
        strLength = number.length();
        try {
            int i = Integer.valueOf(number);
            if (i > 4998 && i <= 0) { throw new ValueOutOfBoundsException("Specific Arabic value is out of bounds of Elbonian number system."); }
            toElbonian();
        }
        catch (NumberFormatException e) {
            Character current;
            for (int i = 0; i < strLength; i++) {
                current = number.charAt(i);
                if (Character.isDigit(current)) {
                    throw new MalformedNumberException("Malformed arabic number");
                } else {
                    try {
                        isElbonianValid();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        throw e1;
                    }
                    toArabic();
                }
            }
        }
        this.number = number;
    }

    private void isElbonianValid() throws MalformedNumberException {
        // TODO check to see if the number is valid, then set it equal to the string
        //Only M,D,C,L,X,V,I and d,l, and v.  In order of first list
        //No spaces within string, no more than 3 of the same letter in a row
        //D,L, and V can have one lowercase in front of them
        int i; //loop counter
        int repeatCount = 0; //Counts number of same characters in a row
        Character previous;
        Character current = null;
        ArrayList<Character> validChars = new ArrayList<>();
        char[] chars = new char[]{'M','d','D','C','l','L','X','v','V','I'};
        for(char mychar : chars) {
            validChars.add(new Character(mychar));
        }

        for(i=0; i < strLength; i++) {

            previous = current;
            current = number.charAt(i);
            //make sure character is in list of acceptable characters
            if (!validChars.contains(current)) {
                throw new MalformedNumberException("Invalid character");
            }
            //make sure that string has no spaces after trimming
            if (current == ' ') {
                throw new MalformedNumberException("String contains spaces");
            }

            //Check for repetition
            if (current.equals(previous)) {
                repeatCount++;

                if (repeatCount > 3) {
                    throw new MalformedNumberException("A symbol may not be repeated more than three times.");
                }
            } else {
                if (validChars.indexOf(Character.toUpperCase(previous)) > validChars.indexOf(Character.toUpperCase(current))) {
                    throw new MalformedNumberException("Improper order of symbols in string");
                }

                //Make sure lowercase letters are followed by their uppercase counterparts
                if (Character.isLowerCase(previous) && !current.equals(Character.toUpperCase(previous))) {
                    throw new MalformedNumberException("Lowercase symbols must be followed by their uppercase counterpart.");
                }
            }
        }
        if(Character.isLowerCase(number.charAt(strLength-1))){
            throw new MalformedNumberException("Cannot end an Elbonian number with a lowercase symbol");
        }
    }
    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        return 1;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        return "I";
    }

}
