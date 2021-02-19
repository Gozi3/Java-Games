package Huffman;

////////////////////////////////////////////////////////////////
public class Tree implements Comparable<Tree> {
	public Node root; // first node of tree
	public int frequency = 0;

	// -------------------------------------------------------------
	public Tree() // constructor
	{
		root = null;
	} // no nodes in tree yet
	// -------------------------------------------------------------

	// the PriorityQueue needs to be able to somehow rank the objects in it
	// thus, the objects in the PriorityQueue must implement an interface called
	// Comparable
	// the interface requires you to write a compareTo() method so here it is:

	public int compareTo(Tree object) { //
		if (frequency - object.frequency > 0) { // compare the cumulative frequencies of the tree
			return 1;
		} else if (frequency - object.frequency < 0) {
			return -1; // return 1 or -1 depending on whether these frequencies are bigger or smaller
		} else {
			return 0; // return 0 if they're the same
		}
	}

	// -------------------------------------------------------------
	String path = "";

	public void treeTraverse(Node root, char letter, String path) {
		if (root != null) {
			if (root.letter == letter) {
				this.path = path;
			} else {
				treeTraverse(root.leftChild, letter, path + "0");
				treeTraverse(root.rightChild, letter, path + "1");
			}
		}
	}

	public String getCode(char letter) { // we want the code for this letter
		treeTraverse(root, letter, "");
		// Track the path along the way and store the current path when you arrive at
		// the right letter
		return path; // return the path that results

	}

} // end class Tree
////////////////////////////////////////////////////////////////
/*
 * Forever and ever (e) = [4] (r) = [3] ( ) = [2] (v) = [2] (F) = [1] (a) = [1]
 * (d) = [1] (n) = [1] (o) = [1]
 *
 * [16] 0/ \1 [12] [e] / \1 0/ [5] [7] 0/ \1 / \1 ( ) (r) 0/ [3] [4] 0/ \1 0/ \
 * (F) (v) [2] \1 0/ \1 [2] (n) (o) / \ 0/ \1 (d) (a)
 *
 */