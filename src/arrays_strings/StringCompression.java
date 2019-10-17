package arrays_strings;

public class StringCompression {

    /*
        Time complexity O(n) - where n is the length of the string
        Space complexity O(n) - stringbuilder will be length of n
     */


    public static String compression(String s){
        StringBuilder builder= new StringBuilder();
        int j = 0;
        int counter=1;
        for(int i=1; i<s.length();i++){
            if(s.charAt(i) == s.charAt(j)){
                counter++;
            }
            else{
                builder.append(s.charAt(j));
                builder.append(counter);
                counter=1;
            }
            j++;
        }
        builder.append(s.charAt(j));
        builder.append(counter);
        return s.length()>builder.length()? builder.toString() : s;

    }



    public static void main(String[] args){
        String s = "aabcccccaaa";
        System.out.println(compression(s));
    }
}
