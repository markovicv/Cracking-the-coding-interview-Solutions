package arrays_strings;

public class SpaceReplacment {

    /*
        Time complexity O(n) - where n is the size of the array
        Space complexity O(1) - we dont create any extra data structures
     */

    public static String spaceReplacment(char[] arrayChars,int sizeOfArray){


        int numberOfSpaces = 0;
        for(int i=0;i<sizeOfArray;i++)
            if(arrayChars[i]==' ')
                numberOfSpaces++;

        int index = sizeOfArray+2*numberOfSpaces;
        for(int i=sizeOfArray-1;i>=0;i--){
            if(arrayChars[i]!=' ') {
                arrayChars[index - 1] = arrayChars[i];
                index--;
            }
            else{
                arrayChars[index-1] = '0';
                arrayChars[index-2] = '2';
                arrayChars[index-3] = '%';
                index = index-3;
            }
        }

        return new String(arrayChars);

    }


    public static void main(String[] args){
        char[] array = "Mr John Smith    ".toCharArray();
        System.out.println(spaceReplacment(array,13));


    }
}
