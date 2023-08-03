package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonService {

    public static String generateRandomAlphabetString(int length){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomAlphaNumericString(int length){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static long generateRandomNumberWithinRange(long min, long max){
        long num = Long.MIN_VALUE;
        while(num < min || num > max ) {
            num = (long) (Math.random()*(max-min+1)+min);
        }

        return num;
    }
    public static long generateRandomNumber(int length){
        long num = -1;
        while(num < 0 || countDigit(num) != length ) {
            num = (long) (Math.random() * Math.pow(10, length));
        }

        return num;
    }

    private static int countDigit(long n)
    {
        int count = 0;
        while(n != 0)
        {
            n = n / 10;
            count = count + 1;
        }
        return count;
    }

    public static long dateToMilliSeconds(String myDate){
        //Format : String myDate = "21-09-21 12:01:24.677000000";
        int indexOfSeperator = myDate.lastIndexOf(":");
        long microseconds = Integer.parseInt(myDate.substring(indexOfSeperator+4));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        try {
            date1 = sdf.parse(myDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long millis = date1.getTime() + microseconds;

        return millis;
    }

    public static String currentDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
