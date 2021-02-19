import java.util.Arrays;
import java.util.Scanner;

public class middleQueue {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    // String inputs = new String("");
    String inputs = new String("INSERT 1,INSERT 2,REMOVE,INSERT 2,INSERT 3,INSERT 4,INSERT 5");
    // while (sc.hasNextLine()) {
    // inputs = inputs + "," + sc.nextLine();
    // }

    String[] commands = inputs.split(",");

    Queue myQueue = new Queue(commands.length);

    System.out.println(Arrays.toString(inputs.split(",")));
    for (int i = 0; i < commands.length; i++) {
      if (commands[i].substring(0, 6).equals("INSERT")) {
        myQueue.insert(commands[i].substring(7));
      } else if (commands[i].equals("REMOVE")) {
        myQueue.remove();
      }
    }

    int p = 0;

    if (myQueue.size() % 2 == 0) {
      p = myQueue.size() / 2;
    }

    else {
      p = (myQueue.size() - 1) / 2;
    }

    System.out.println(myQueue.position(p));
    sc.close();
  }
}

class Queue {
  private int maxSize;
  private String[] queArray;
  private int front;
  private int rear;
  private int nItems;

  public Queue(int s) {
    maxSize = s;
    queArray = new String[maxSize];
    front = 0;
    rear = -1;
    nItems = 0;
  }

  public boolean insert(String j) {
    if (isFull())
      return false;
    if (rear == maxSize - 1)
      rear = -1;
    rear++;
    queArray[rear] = j;
    nItems++;
    return true;

  }

  public String remove() {
    if (isEmpty())
      return null;
    String temp = queArray[front];
    front++;
    if (front == maxSize)
      front = 0;
    nItems--;
    return temp;
  }

  public String peekFront() {
    return queArray[front];
  }

  public boolean isEmpty() {
    return (nItems == 0);
  }

  public boolean isFull() {
    return (nItems == maxSize);
  }

  public int size() {
    return nItems;
  }

  public String position(int p) {
    return queArray[p];
  }
}