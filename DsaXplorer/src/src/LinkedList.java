public class LinkedList {

    public static class Node {
        String value;
        Node nextNode;

        Node(String value, Node node){
            this.value = value;
            this.nextNode = node;
        }
    }

    public static void addNode(Node headNode, String value) {
        Node newNode = new Node(value, null);
        if(headNode.nextNode == null){
            headNode.nextNode = newNode;
        } else {
            Node currNode = headNode;
            while(currNode.nextNode != null){
                currNode = currNode.nextNode;
            }
            currNode.nextNode = newNode;
        }
    }

    public static void display(Node headNode) {
        if (headNode == null) {
            System.out.println("Nothing to display!");
        } else {
            Node currNode = headNode;
            while (currNode != null) {
                System.out.print(currNode.value + "  ");
                currNode = currNode.nextNode;
            }
        }
    }

    public static void main(String[] args) {

        Node mainNode = new Node("1", null);
        addNode(mainNode, "2");
        addNode(mainNode, "3");

        display(mainNode);

    }
}
