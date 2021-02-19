public class functionPractice {
	public static void main(String args[])
	{
		System.out.println("XXMMMMMMMMMXX");
		System.out.println("XX   ___   XX");
		System.out.println("XX  |___|  XX");
		System.out.println("XX <(^ ^)> XX");
		System.out.println("XX  (=*=)  XX");
		System.out.println("XX  (_~_)  XX");
		System.out.println("XX  &&&&&  XX");
		System.out.println("XX   ###   XX");
		System.out.println("XX   ###   XX");
		System.out.println("XX   ###   XX");
		System.out.println("XXWWWWWWWWWXX");

	}
	public static String sReverser(String i)
	{
		String holder = new String("");
		for(int x = i.length()-1; x>=0; x--)
		{
			holder = holder + i.charAt(x);
		}
		return holder;
	}
}