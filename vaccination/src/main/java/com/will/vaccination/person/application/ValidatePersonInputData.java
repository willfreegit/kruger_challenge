package com.will.vaccination.person.application;

import com.will.vaccination.util.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePersonInputData {
    public static boolean validateRequieredFields(String identification, String name, String lastname, String email) {
        return !Utils.nullOrEmpty(identification) && !Utils.nullOrEmpty(name) && !Utils.nullOrEmpty(lastname) && !Utils.nullOrEmpty(email);
    }

    public static boolean validateCedula(String identification) {
        byte sum = 0;
        try {
            if (identification != null && identification.trim().length() == 10 && identification.matches("[+-]?\\d*(\\.\\d+)?")){
                String[] data = identification.split("");
                byte verifier = Byte.parseByte(data[0] + data[1]);
                if (verifier < 1 || verifier > 24) {
                    return false;
                }
                byte[] digits = new byte[data.length];
                for (byte i = 0; i < digits.length; i++) {
                    digits[i] = Byte.parseByte(data[i]);
                }
                if (digits[2] > 6) {
                    return false;
                }
                for (byte i = 0; i < digits.length - 1; i++) {
                    if (i % 2 == 0) {
                        verifier = (byte) (digits[i] * 2);
                        if (verifier > 9) {
                            verifier = (byte) (verifier - 9);
                        }
                    } else {
                        verifier = (byte) (digits[i] * 1);
                    }
                    sum = (byte) (sum + verifier);
                }
                if ((sum - (sum % 10) + 10 - sum) == digits[9]) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean validateEmail(String email) {
        if(email != null){
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(email);
            return mather.find();
        }
        return false;
    }

    public static boolean validateNames(String cadena) {
        if(cadena != null && !cadena.isEmpty()){
            for (int x = 0; x < cadena.length(); x++) {
                char c = cadena.charAt(x);
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
