package Huffman;

class Node {

	public char letter; // stores letter

	public Node leftChild; // this node's left child
	public Node rightChild; // this node's right child

	public boolean isLeafNode() {
		if ((leftChild == null) && (rightChild == null)) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return "Letter: " + ((isLeafNode()) ? letter : "Has no letter because it is a parent.");
	}

} // end class Node
