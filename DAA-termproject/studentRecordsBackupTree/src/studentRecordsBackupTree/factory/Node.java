package studentRecordsBackupTree.factory;

public class Node {
    public int item;
    public Node leftChild;
    public Node rightChild;

    public int getBNumber() {
        return item;
    }

    public void setbNumber(int item) {
        this.item = item;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

}
