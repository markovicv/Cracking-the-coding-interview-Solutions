package arrays_strings;

public class StringRotation {

    /*
        Time complexity O(n) - n is the length of the longer string
        Space complexity O(1) - didnt create any extra space
     */

    public static boolean isRotated(String word1,String word2){
        if(word1==null || word1.equals(""))
            return false;
        if(word1.length() == word2.length()){
            String conWord1 = word1+word1;
            if(conWord1.contains(word2))
                return true;
        }
        return false;
    }



    public static void main(String[] args){
        String s1 = "waterbotlle";
        String s2 = "botllewater";

        System.out.println(isRotated(s1,s2));

    }
}
