package MyPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomainNumbers {
    String myRomainMass[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};


    String romainString;

    RomainNumbers(String romainString) {
        this.romainString = romainString.replaceAll("\\s", "");
        System.out.println(findRomainResult());

    }

    private String[] getRomainNumbers() {
        return this.romainString.split("[+/*-]");
    }

    private String getOperation() {
        Pattern pattern = Pattern.compile("[*/+-]");
        Matcher matcher = pattern.matcher(this.romainString);
        matcher.find();
        return matcher.group();
    }

    private int[] findNumbers() {
        String[] splitRomainString = getRomainNumbers();
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            for (int k = 1; k <= 10; k++) {
                if (splitRomainString[i].matches(myRomainMass[k])) {
                    result[i] = k;
                    break;
                } else result[i] = -1;
            }
        }
        return result;
    }

    private boolean checkNumber() {
        int[] result = findNumbers();
        for (int i = 0; i < result.length; i++) {
            if (result[i] < 0) {
                return false;
            }
        }
        return true;
    }

    private String findRomainResult() {
        String result = "";
        int calc = calculate();
        boolean check = checkNumber();
        if (check && (calc > 0)){
            result = myRomainMass[calc];
        } else System.out.println("Числа не более X, ответ не может быть отрицательным и нулевым");
        return result;
    }

    private int calculate() {
        int result = 0;
        int[] operand = findNumbers();
        switch (getOperation()) {
            case "+":
                result = operand[0] + operand[1];
                break;
            case "-":
                result = operand[0] - operand[1];
                break;
            case "*":
                result = operand[0] * operand[1];
                break;
            case "/":
                result = operand[0] / operand[1];
                break;
        }
        return result;
    }
}