package SampleJavaCode;
public class stringCapitalizer
{
	public static void main (String args [])
	{
		String s1 = new String ("My name is mariam and i study at maynooth university");
		s1 = s1.toLowerCase();
		for (int x=0 ; x <(s1.length()) ; x++){
			if(x==0){
			    s1 = s1.substring(x,x+1).toUpperCase() + s1.substring(x+1);
			 }
		    else if (s1.charAt(x) == ' '){
				s1 = s1.substring(0,x) + " " + s1.substring(x+1,x+2).toUpperCase()+ s1.substring(x+2);
			}
		}
		System.out.println(s1);
	}
}