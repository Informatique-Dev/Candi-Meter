package com.example.demo.rest.validation;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InputValidation {

    public boolean phoneNumberIsValid(String phoneNumber){
        boolean valid = false;
        if(phoneNumber.startsWith("01") ) {
            char[] phone = phoneNumber.toCharArray();
            int thirdDigit = phone[2] - '0';
            if (thirdDigit == 0 || thirdDigit == 1 || thirdDigit == 2 || thirdDigit == 5) {
                valid = true;}
        }
        return valid;
    }
}
