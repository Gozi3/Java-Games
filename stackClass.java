import java.util.*;

public class stackClass
{
	@SuppressWarnings("resource")
	public static void main(String []args)
	{
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String r = "";
		String s = "";
		for(int a = 0;a<input.length();a++){
			if(input.charAt(a)== ' '){
				
			}
			else{
				s = s + input.charAt(a);
			}
		}
		Stack stackArray = new Stack(s.length());
		for(int i = 0;i<s.length();i++){
			
			stackArray.push(s.charAt(i));
		}
		for(int j = 0;j<s.length();j++){
			r = r + stackArray.pop();
		}
		if(r.equals(s)){
			System.out.println("TRUE");
		}
		else{
			System.out.println("FALSE");
		}
	}
}
class Stack{
   
    private int maxSize;        // size of stack array
    private char[] stackArray;
    private int top;            // top of stack

    public Stack(int s) {         // constructor    
        maxSize = s;             // set array size
        stackArray = new char[maxSize]; // create array
        top = -1;                // no items yet
    }
    
    public void push(char j) {    // put item on top of stack
	   top++;
       stackArray[top] = j;   // increment top, insert item
    }      

    public char pop() {           // take item from top of stack
        return stackArray[top--]; //access item, decrement top
    }      

    public char peek() {          // peek at top of stack
        return stackArray[top];
    }   
    
    public boolean isEmpty() {   // true if stack is empty  
        return (top == -1);
    }      

    public boolean isFull() {     // true if stack is full  
        return (top == maxSize-1);
    }      

    public void makeEmpty() {     // empty stack 
	   top=-1;  
    }
}


