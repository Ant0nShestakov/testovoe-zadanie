import java.util.Scanner;

public class Main {
    /**
     *Метод конвертирования арабской цифры в римскую(от 1 до 10). В случае неудачи возвращает -1
     * */
    private static int romanToNumber (String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    //метод конвертирования арабской цифры в римскую
    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }

    //метод формирования ответа в зависимости от системы счисления(арабская или римская)
    private static String CreateResult(boolean flag, int result) throws Exception {
        String strResult = null;
        if (!flag)
            strResult = Integer.toString(result);
        if (flag)
            if (result > 0)
                strResult = convertNumToRoman(result);
            else {
                throw new Exception();
            }
        return strResult;
    }

    public static String calc(String input) {
        boolean isRoman;
        int result;
        String strResult;
        String[] array = input.split(" ");
        try {
            if (array.length != 3) {
                throw new Exception();
            }
            int firstArg = romanToNumber(array[0]);
            int secondArg = romanToNumber(array[2]);
            isRoman = true; //аргументы римские числа
            if (firstArg == -1 || secondArg == -1) {
                firstArg = Integer.parseInt(array[0]);
                secondArg = Integer.parseInt(array[2]);
                isRoman = false; //аргументы арабские числа
            }
            if (firstArg <= 10 && secondArg <= 10) {
                result = switch (array[1]) {
                    case "+" -> firstArg + secondArg;
                    case "-" -> firstArg - secondArg;
                    case "*" -> firstArg * secondArg;
                    case "/" -> firstArg / secondArg;
                    default -> throw new Exception();
                };
                strResult = CreateResult(isRoman, result);
            }
            else
                throw new Exception();
        } catch (Exception e) {
            return null;
        }
        return strResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        if(result != null)
            System.out.println(result);
    }
}