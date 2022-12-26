package studentRecordsBackupTree.factory;

public class BSTreeImpl {

    private Node rootNode;

    public void addNode(Node node) {
        int bNumber = node.getBNumber();
        if (find(bNumber) == null) {
            if (getRootNode() == null) {
                rootNode = node;
            } else {
                Node focusNode = getRootNode();
                Node parent;

                while (true) {
                    parent = focusNode;

                    if (bNumber < focusNode.getBNumber()) {
                        focusNode = focusNode.getLeftChild();

                        if (focusNode == null) {
                            parent.setLeftChild(node);
                            return;
                        }
                    } else {
                        focusNode = focusNode.getRightChild();
                        if (focusNode == null) {
                            parent.setRightChild(node);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.getLeftChild());
            System.out.println(rootNode.getBNumber());
            inOrderTraversal(focusNode.getRightChild());
        }
    }

    public int addRoots(Node root) {
        if (root == null)
            return 0;
        return root.getBNumber() + addRoots(root.getLeftChild()) + addRoots(root.getRightChild());
    }

    public Node find(int index) {
        Node currentNode = rootNode;
        if (rootNode == null) {
            return null;
        }
        while (currentNode.getBNumber() != index) {
            if (index < currentNode.getBNumber()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

}
