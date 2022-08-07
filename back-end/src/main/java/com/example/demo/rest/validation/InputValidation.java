package com.example.demo.rest.validation;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InputValidation {

    public boolean phoneNumberIsValid(String phoneNumber){
        boolean valid = false;
        if(phoneNumber.startsWith("01") ) {
            int sum = 0;
            char[] phone = phoneNumber.toCharArray();
            int thirdDigit = phone[2] - '0';
            int lastDigit = phone[phone.length - 1] - '0';
            for (int index = 2; index < phone.length; index++) {
                sum += phone[index] - '0'; }
            if (thirdDigit == 0 || thirdDigit == 1 || thirdDigit == 2 || thirdDigit == 5) {
                if (sum / (phone.length - 3) != lastDigit){
                    valid = true;}
            }
        }

        return valid;
    }
    public boolean emailIsValid(String email){
        boolean valid = false;
        if(email.endsWith(".com")){
            valid = true;
        }
        return valid;
    }
}
