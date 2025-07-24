public class LinkedList {

    public static class Node {
        String value;
        Node nextNode;

        Node(String value, Node node){
            this.value = value;
            this.nextNode = node;
        }
    }

    public static Node addNodeAtIndexPosition(Node headNode, int index, String value) {
        if (headNode == null && index == 1) {
          return new Node(value, null);
        } else if (headNode == null && (index > 1 || index < 0)) {
            System.out.println("Invalid insert operation!");
            return null;
        } else if (headNode != null && index > size(headNode) + 1) {
            System.out.println("Invalid insert operation!");
            return headNode;
        } else {
            Node newNode = new Node(value, null);
            if (index == 1) {
                newNode.nextNode = headNode;
                return newNode;
            } else if (index == size(headNode) + 1) {
                Node currNode = headNode;
                while(currNode.nextNode != null) {
                    currNode = currNode.nextNode;
                }
                currNode.nextNode = newNode;
                return headNode;
            }
            Node prevNode = headNode;
            Node currNode = headNode;
            int position = 1;
            while(currNode != null) {
                if (position == index) {
                    prevNode.nextNode = newNode;
                    newNode.nextNode = currNode;
                    break;
                }
                prevNode = currNode;
                currNode = currNode.nextNode;
                position += 1;
            }
        }
        return headNode;
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

    public static int size(Node headNode) {
        int count = 0;
        if (headNode == null) {
            System.out.println("Empty Linked List");
        } else {
            Node currNode = headNode;
            while (currNode != null) {
                count += 1;
                currNode = currNode.nextNode;
            }
        }
        return count;
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

        System.out.println();
        System.out.println("After Adding 1 at first : ");
        mainNode = addNodeAtIndexPosition(mainNode, 1, "1");
        display(mainNode);

        System.out.println();
        System.out.println("After Adding 7 at last : ");
        mainNode = addNodeAtIndexPosition(mainNode, 7, "7");
        display(mainNode);
    }
}
