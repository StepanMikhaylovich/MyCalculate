package MyPackage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Pattern myArabianPattern = Pattern.compile("\\s*\\d{1,}\\s*[*/+-]\\s*\\d{1,}\\s*");
        Pattern myRomainPattern = Pattern.compile("\\s*[ILCVX]{1,}\\s*[*/+-]\\s*[ILCVX]{1,}\\s*");
        String str = myScanner.nextLine();
        Matcher myRomainMatcher = myRomainPattern.matcher(str);
        if (myRomainMatcher.matches()) {
            RomainNumbers romainNumbers = new RomainNumbers(str);
        }
        Matcher myArabianMatcher = myArabianPattern.matcher(str);
        if (myArabianMatcher.matches()) {
            ArabianNumbers arabianNumbers = new ArabianNumbers(str);
        }
        if (!(myArabianMatcher.matches() || myRomainMatcher.matches())) {
            System.out.println("Некорректный ввод");
        }
    }
}
