package arrays_strings;

public class AddDeleteReplace {

    /*
        Time complexity O(n) - where n is the length of the longer String
        Space complexity O(1) - our array will always be 128
     */



    public static boolean oneEdit(String s1,String s2){

        int[] charrArray = new int[128];

        for(int i=0;i<s1.length();i++){
            charrArray[s1.charAt(i)]++;
        }
        for(int i=0;i<s2.length();i++){
            charrArray[s2.charAt(i)]++;
        }
        int counter=0;
        for(int i=0;i<128;i++){
            if(charrArray[i]%2!=0)
                counter++;
        }
        return counter > 2? false:true;
    }



    public static void main(String[] args){
        String s1 = "pale";
        String s2 = "bale";
        System.out.println(oneEdit(s1,s2));

    }
}
