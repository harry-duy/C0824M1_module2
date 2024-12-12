package ss9.s3;

public class NextDayCalculator {
    public String getNextDay(int day, int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Xử lý năm nhuận
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Tăng ngày
        day++;

        // Kiểm tra nếu vượt quá số ngày trong tháng
        if (day > daysInMonth[month - 1]) {
            day = 1;
            month++;

            // Kiểm tra nếu vượt quá tháng 12
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        return String.format("%d/%d/%d", day, month, year);
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
