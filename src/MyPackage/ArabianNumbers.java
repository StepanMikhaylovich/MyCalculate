package MyPackage;

import java.io.IOException;

public class ArabianNumbers {
    String arabianString;

    ArabianNumbers(String arabianString){
        this.arabianString = arabianString.replaceAll("\\s","");
        calculate();
    }

    private String getOperation(){
        return this.arabianString.replaceAll("\\d","");
    }

    private  int[] getNumbers() throws IOException {
        String str[] = this.arabianString.split("[+/*-]");
        int[] numbers = new int[str.length];
        for (int i = 0; i < str.length; i++){
            numbers[i] = Integer.parseInt(str[i]);
            if ((numbers[i] > 10) || (numbers[i] < 1)){
                throw new IOException("Введите число не больше 10 и не меньше единицы");
            }
        }
        return numbers;
    }

    private void calculate(){
        try {
            int [] numbers = getNumbers ();
            switch (getOperation()) {
                case "+":
                    System.out.print(numbers[0] + numbers[1]);
                    break;
                case "-":
                    System.out.print(numbers[0] - numbers[1]);
                    break;
                case "/":
                    System.out.print(numbers[0] / numbers[1]);
                    break;
                case "*":
                    System.out.print(numbers[0] * numbers[1]);
                    break;
            }
        } catch (IOException e){
            System.out.println(e);
        }

    }

}
