package com.example.calculator;

public class Convertor {
    public boolean isValidArabic(int arabicNumber) {
        String number = String.valueOf(arabicNumber);

        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }

        return arabicNumber <= 3999 && arabicNumber >= 1;
    }

    public boolean isValidRoman(String romanNumber) {
        for (int i = 0; i < romanNumber.length(); i++) {
            if (romanNumber.charAt(i) != 'I' &&
                    romanNumber.charAt(i) != 'V' &&
                    romanNumber.charAt(i) != 'X' &&
                    romanNumber.charAt(i) != 'L' &&
                    romanNumber.charAt(i) != 'C' &&
                    romanNumber.charAt(i) != 'D' &&
                    romanNumber.charAt(i) != 'M') {
                return false;
            }
        }
        return true;
    }

    public String toRoman(int arabicNumber) {
        if (isValidArabic(arabicNumber)) {
            StringBuilder Roman = new StringBuilder();

            String[] onesArray = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
            String[] tensArray = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
            String[] hundredsArray = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };

            int ones = arabicNumber % 10;

            arabicNumber = (arabicNumber - ones) / 10;
            int tens = arabicNumber % 10;

            arabicNumber = (arabicNumber - tens) / 10;
            int hundreds = arabicNumber % 10;

            arabicNumber = (arabicNumber - hundreds) / 10;
            Roman.append("M".repeat(Math.max(0, arabicNumber)));

            if (hundreds >= 1) {
                Roman.append(hundredsArray[hundreds - 1]);
            }

            if (tens >= 1) {
                Roman.append(tensArray[tens - 1]);
            }

            if (ones >= 1) {
                Roman.append(onesArray[ones - 1]);
            }

            return Roman.toString();
        } else {
            return null;
        }
    }

    public int toArabic(String s) {
        if (isValidRoman(s)) {
            int Arabic = 0;
            int last_digit = 0;
            int current_digit = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'I') {
                    current_digit = 1;
                }
                if (s.charAt(i) == 'V') {
                    current_digit = 5;
                }
                if (s.charAt(i) == 'X') {
                    current_digit = 10;
                }
                if (s.charAt(i) == 'L') {
                    current_digit = 50;
                }
                if (s.charAt(i) == 'C') {
                    current_digit = 100;
                }
                if (s.charAt(i) == 'D') {
                    current_digit = 500;
                }
                if (s.charAt(i) == 'M') {
                    current_digit = 1000;
                }

                if (last_digit < current_digit && last_digit != 0) {
                    current_digit -= last_digit;
                    Arabic -= last_digit;
                    Arabic += current_digit;
                    last_digit = current_digit;
                } else {
                    last_digit = current_digit;
                    Arabic += current_digit;
                }
                current_digit = 0;
            }

            return Arabic;
        } else {
            return 0;
        }
    }
}
