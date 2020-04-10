package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputHelper {
    private final Scanner reader;

    public InputHelper() {
        reader = new Scanner(System.in);
    }

    public char readCharacter(String prompt) {

        System.out.println(prompt + ": ");
        char inputText = reader.nextLine().charAt(0);
        return inputText;
    }

    public char readCharacter(String prompt, String validCharacters) {
        char inputText;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");
            inputText = reader.nextLine().toUpperCase().charAt(0);
            if (validCharacters.indexOf(inputText) == -1) {
                inputError = true;
                System.out.println("Character out of range: please re-enter: ");
            }
        } while (inputError);
        return inputText;
    }

    public String readString(String prompt) {
        System.out.println(prompt + ": ");
        String inputText = reader.nextLine();
        return inputText;
    }

    public int readInt(String prompt, int max, int min) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
                if (inputNumber < min || inputNumber > max) {
                    inputError = true;
                    System.out.println("Number out of range: please re-enter\n");
                }
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    public int readInt(String prompt) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    public float readFloat(String prompt) {
        float inputNumber = 0.0f;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Float.parseFloat(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    public Calendar readDate(String prompt, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = readString("Enter date yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(InputHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}