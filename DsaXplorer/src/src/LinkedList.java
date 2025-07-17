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

    public static Node removeFirstElement(Node headNode) {
        return headNode.nextNode;
    }

    public static Node removeNodeByValue(Node headNode, String value) {
        if (headNode == null || value.isBlank()){
            System.out.println("Nothing to remove!");
            return headNode;
        } else {
            if (headNode.value.equals(value)){
                return removeFirstElement(headNode);
            }
            Node currNode = headNode;
            Node prevNode = headNode;
            while (currNode != null) {
                if (currNode.value.equals(value)) {
                   prevNode.nextNode = currNode.nextNode;
                   break;
                } else {
                    prevNode = currNode;
                    currNode = currNode.nextNode;
                }
            }
            return headNode;
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
        addNode(mainNode, "4");
        addNode(mainNode, "5");
        addNode(mainNode, "7");
        addNode(mainNode, "6");
        addNode(mainNode, "10");

        System.out.println("Before Removing : ");
        display(mainNode);

        mainNode = removeNodeByValue(mainNode, "10");
        mainNode = removeNodeByValue(mainNode, "7");
        mainNode = removeNodeByValue(mainNode, "1");

        System.out.println();
        System.out.println("After Removing : ");
        display(mainNode);
    }
}
