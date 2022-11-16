package com.student.ust.util;

import com.student.ust.entity.Student;
import com.student.ust.exception.InvalidEmailException;
import com.student.ust.exception.InvalidPasswordException;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class USTUtil {
    public  static boolean ValidEmail(Student student) throws InvalidEmailException {
        String email = student.getEmail();
        String regex = "^([A-Za-z0-9+_.-]+)@([a-z]+)\\.([a-z]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validPassword(Student student) throws InvalidPasswordException {
        String password= student.getPassword();
        String regexPassword =  "^(?=(?:.*\\d){3,})(?=\\S+$)(?=.*[@#$%^&+=])(?=(?:.*[A-Za-z]){3,})(?=.*[A-Z]).{8,}$";
        Pattern pattern1=Pattern.compile(regexPassword);
        Matcher matcher1= pattern1.matcher(password);

        if(matcher1.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    public static String hashPassword(String password){
        try{
            return toHexString(getSHA(password));
        }
        catch(NoSuchAlgorithmException e){
            return null;

        }
    }
    public static byte[] getSHA(String password) throws NoSuchAlgorithmException{
        MessageDigest md=MessageDigest.getInstance("SHA-256");
        return md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash){
        BigInteger number=new BigInteger(1,hash);
        StringBuilder hexString=new StringBuilder(number.toString(16));
        while(hexString.length()<64){
            hexString.insert(0,'0');
        }
        return hexString.toString();
    }
}
