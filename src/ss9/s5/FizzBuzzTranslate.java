package ss9.s5;

public class FizzBuzzTranslate {
    private static final String[] ones = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
    private static final String[] tens = {"", "", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi", "tám mươi", "chín mươi"};

    public String translate(int number) {
        if (String.valueOf(number).contains("3")) {
            return "Fizz";
        }
        if (String.valueOf(number).contains("5")) {
            return "Buzz";
        }
        if(number % 3 == 0 && number % 5 ==0){
            return "FizzBuzz";
        }
        if(number % 3 == 0){
            return "Fizz";
        }
        if(number % 5 == 0){
            return "Buzz";
        }
        return readNumber(number);
    }
    private String readNumber(int number) {
        if (number < 10) {
            return ones[number];
        } else if (number < 20) {
            if (number == 15) {
                return "mười lăm";
            }
            if(number==11) return "mười một";
            if(number==12) return "mười hai";
            if(number==13) return "mười ba";
            if(number==14) return "mười bốn";
            if(number==16) return "mười sáu";
            if(number==17) return "mười bảy";
            if(number==18) return "mười tám";
            if(number==19) return "mười chín";


        } else if (number < 100) {
            int ten = number / 10;
            int one = number % 10;

            return tens[ten] + (one > 0 ? " " + ones[one] : "");
        }
        return "";
    }
}
