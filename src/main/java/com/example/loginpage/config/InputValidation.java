package com.example.loginpage.config;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    final Pattern JavaScriptPattern = Pattern.compile("(<script[^>]*>.*</script>)|(<script>)", Pattern.CASE_INSENSITIVE);
    final Pattern HTMLpattern = Pattern.compile("<(\\w+)(\\s*[^>]*)?>.*?<\\/\\1>", Pattern. DOTALL);

    //name validation
    public boolean validateName(String name){
        return  !(JavaScriptPattern.matcher(name).find() || HTMLpattern.matcher(name).find());
    }

    //id validation
    public boolean validateId(String id){
        return  !(JavaScriptPattern.matcher(id).find() || HTMLpattern.matcher(id).find());
    }

    //email validation
    public boolean validateEmail(String email){
        final Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        return  !(JavaScriptPattern.matcher(email).find() || HTMLpattern.matcher(email).find()) &&
                emailPattern.matcher(email).find();
    }

    //phone number validation
    public boolean validatePhoneNumber(String number){
        final Pattern mobilePattern = Pattern.compile("^[0-9]+$");
        return !(JavaScriptPattern.matcher(number).find() || HTMLpattern.matcher(number).find()) &&
                mobilePattern.matcher(number).find();
    }
}
