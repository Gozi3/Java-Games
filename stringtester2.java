/**
 * A collection of methods to test strings
 *
 * @author Michael Gleeson 14447212
 * @version 1.0
 *
 */
public class stringtester2
{
    /** This is the main method, where strings are checked by the called methods */
    public static void main (String args[])
    {
       if(palindrome("Navan") == false)
       {
           System.out.println("Palindrome identified");
       }
       else{
       		System.out.println("Palindrome NOT identified");
       }
       if(anagram("moon walk", "K n O w L o A o") == true){
            System.out.println("The two strings are anagrams");
       }
       else{
       		System.out.println("The two strings are NOT anagrams");
       }
    }

    /** This method checks if a string is palindromic */
    public static boolean palindrome(String word)
    {
        word = word.toLowerCase();
        boolean b = false;
        String reverse = "";
        for(int i = word.length() - 1; i >= 0; i-- )
        {
            reverse = reverse + word.charAt(i);
            if (word.equals(reverse))
            {
                b = false;
            }
            else
            {
                b = true;
            }
        }

        return b;
    }

    /** This method checks if one string is an anagram of the other
     @param String first, String second
     @return boolean
     */
    public static boolean anagram(String first, String second)
    {
        first = first.toLowerCase();
        second = second.toLowerCase();
        boolean anagram = true;
		//check the length of the strings
		//first
        int firstcounter = 0;
        for(int a=0; a <first.length()-1; a++)
        {
            if(first.charAt(a) != ' ')
            {
                firstcounter++;
            }
        }
        firstcounter++;
		//second
       int secondcounter = 0;
        for(int b=0; b <second.length()-1; b++)
        {
            if(second.charAt(b) != ' ')
            {
                secondcounter++;
            }
        }
		secondcounter++;
		//if they are the same length
        if(firstcounter == secondcounter)
        {
             //stores the first string in an array without the spaces
            char [] firstarray = new char [firstcounter+1];
            int fcounter = 0;//checks t
            int fcounter1 = 0;
            while(fcounter <firstcounter)
            {

               if(first.charAt(fcounter1) != ' '){
               	firstarray[fcounter] = first.charAt(fcounter1);
               	fcounter++;
               }
               fcounter1++;
            }
			//stores the second string in an array without the spaces
            char [] secondarray = new char [secondcounter+1];
            int scounter = 0;
            int scounter1 = 0;
            while(scounter <secondcounter)
            {

               if(second.charAt(scounter1) != ' '){
               	secondarray[scounter] = second.charAt(scounter1);
               	scounter++;
               }
               scounter1++;
            }

			//loops through both arrays
			boolean done = false;
            for(int i=0; i<=firstarray.length-1; i++)
            {
            	//testing...
            for(int w = 0;w<secondarray.length;w++) {
			System.out.print(secondarray[w]);
			}
			//end test
           		done = false;
            	while(!done){
                    for(int j=0; j<=secondarray.length-1; j++)
                    {
                    	//if the letter has been spotted do nothing(stop checking)
                    	if(done){

                    	}
                    	//if the letter in the array is same as the one in the other array change the char and cont.
                        else if(firstarray[i] == secondarray[j])
                        {
                            secondarray[j] = '*';
                            done = true;
                        }
                        else{
                        	done = false;
                        }
                    }
				}
            }

          	 //if there are '*'s in all places in the array then its an anagram
            for(int i=0; i<=secondarray.length-1; i++)
            {
                if(secondarray[i] != '*')
                {
                  anagram = false;
                }
            }


        }
        else{
        	anagram = false;
        }
        return anagram;
    }
}
