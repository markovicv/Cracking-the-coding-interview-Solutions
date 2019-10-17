package arrays_strings;

public class PalindromePermutation {
    /*
        If a string is palindrome all the chars except one must of even count
        Time complexity O(n) - n is size of the arrray
        Space complexity O(1) - there are 128 chars, so the space is constant
     */

    public static boolean palindromePermutation(char[] input){
        int[] arrayCount = new int[128];

        for(int i=0;i<input.length;i++){
            if(input[i]!=' ')
                arrayCount[input[i]]++;
        }
        int res=0;
        for(int i=0;i<arrayCount.length;i++){
            res += arrayCount[i]%2;

        }
        if(res<=1)
            return true;
        else
            return false;
    }



    public static void main(String[] args){
        char[] array = "abb".toCharArray();
        System.out.println(palindromePermutation(array));

    }
}
