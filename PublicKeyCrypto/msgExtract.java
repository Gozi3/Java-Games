package PublicKeyCrypto;

import java.util.*;
import java.math.*;

//given a public key and a cipher, extract the message where:
//g -> number
//p -> modulus
//x -> A's private key
//y -> B's private key
//public key -> (p, g, g^x mod p)
//cipher -> (g^y, m.g^xy)
//Decryption Algo:
//cipher = (c1, c2)
//(c2)/(c1^x)
//get X
public class msgExtract {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the public key numbers separated by space: ");
		String pubKey = scan.nextLine();
		String pkArr[] = pubKey.split(" ");
		BigInteger pk[] = new BigInteger[3];
		pk[0] = new BigInteger(pkArr[0]);
		pk[1] = new BigInteger(pkArr[1]);
		pk[2] = new BigInteger(pkArr[2]);

		System.out.print("Please enter the Cipher key numbers separated by a space: ");
		String cipher = scan.nextLine();
		// program starts here
		long startTime = System.currentTimeMillis();
		String cArr[] = cipher.split(" ");
		BigInteger c[] = new BigInteger[2];
		c[0] = new BigInteger(cArr[0]);
		c[1] = new BigInteger(cArr[1]);

		BigInteger x = getPK(pk[0], pk[1], pk[2]);
		// System.out.println(x.toString());
		BigInteger exponent = pk[0].subtract(new BigInteger("1"));
		exponent = exponent.subtract(x);
		BigInteger c1 = c[0].modPow(exponent, pk[0]);
		BigInteger c2 = (c[1].multiply(c1)).mod(pk[0]);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Message is: " + c2.toString() + "\nTime Taken: " + totalTime + "ms");
		System.out.print("Done? Y/N ");
		scan.close();
	}

	public static BigInteger getPK(BigInteger p, BigInteger g, BigInteger gxmodp) {
		BigInteger temp = new BigInteger("0");
		BigInteger result = new BigInteger("0");
		BigInteger i = (g.mod(p)).add(new BigInteger("1"));
		temp = (new BigInteger("1").mod(p));
		if (temp.equals(gxmodp)) {
			return temp;
		}
		while (i.compareTo(p) == -1) {
			temp = (g.modPow(i, p));
			if (gxmodp.equals(temp)) {
				result = i;
				// i = 94156 -> for lab question
				System.out.println(i);
				return result;
			}
			i = i.add(new BigInteger("2"));
		}
		return result;
	}
}