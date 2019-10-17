package arrays_strings;

import java.util.Arrays;
import java.util.Collections;

public class StringPermutation {

    /*
        First method sorts both strings using a good sorting algorithm than compares char by char
        Time complexity O(n*logn) - where n is the length of the bigger array
        Space complexity O(n+m) - n is the size of one array, m is the size of the other array
     */


    public static boolean isPermutationMethod1(String txt1,String txt2){
        if(txt1.length() != txt2.length())
            return false;
        char[] charA1 = txt1.toCharArray();
        char[] charA2 = txt2.toCharArray();

        Arrays.sort(charA1);
        Arrays.sort(charA2);

        for(int i=0;i<txt1.length();i++)
            if(charA1[i] != charA2[i])
                return false;

        return true;
    }


    public static boolean isPermutationMethod2(String txt1,String txt2){
        int arrayCount1[] = new int[256];
        int arrayCount2 [] = new int[256];

        for(int i=0; i<txt1.length();i++)
            arrayCount1[txt1.charAt(i)]++;

        for(int i=0;i<txt2.length();i++)
            arrayCount2[txt2.charAt(i)]++;
        if(arrayCount1.length != arrayCount2.length)
            return false;

        for(int i=0;i<256;i++)
            if(arrayCount1[i]!=arrayCount2[i])
                return false;

         return true;

    }

    public static void main(String[] args){
        String s1 = "acs";
        String s2 = "sac";

        System.out.println(isPermutationMethod2(s1,s2));

    }
}
