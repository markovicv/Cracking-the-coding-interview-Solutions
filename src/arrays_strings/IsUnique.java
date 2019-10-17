package arrays_strings;

public class IsUnique {

    /*
        Time complexity is O(n) - we itarate through the whole array
        Space complexity is O(n) - we are making boolean array keep track of our chars
     */


    public static boolean isUnique(String input){
        // if the array is empty we return true
        if(input.length()==0)
            return true;
        // stores true for every char value
        boolean[] repeated = new boolean[128];
        for(int i=0;i<input.length();i++){
            if(repeated[input.charAt(i)])
                return false;
            repeated[input.charAt(i)]=true;
        }
        return true;
    }


    public static void main(String[] args){
        String input = "";
        System.out.println(isUnique(input));
    }
}
