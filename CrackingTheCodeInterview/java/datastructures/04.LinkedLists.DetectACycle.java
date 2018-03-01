//
// Input Format
//
// Our hidden code checker passes the appropriate argument to your function. You are not responsible for reading any input from stdin.
//
// Output Format
//
// If the list contains a cycle, your function must return true. If the list does not contain a cycle, it must return false. The binary integer corresponding to the boolean value returned by your function is printed to stdout by our hidden code checker.

/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

/*
* Solution using a HashSet.
*/
boolean hasCycleWithHashSet(Node head) {

    if (head == null) return false;

    Node current = head;
    Set<Node> visited = new HashSet<Node>();
    while (current.next != null) {
        if (visited.contains(current)) {
            return true;
        }
        visited.add(current);
        current = current.next;
    }

    return false;
}

/*
* Solution using slow and fast pointers.
*/
boolean hasCycleWithSlowAndFastPointers(Node head) {
    if (head == null) return false;

    Node slow = head;
    Node fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) return false;

        slow = slow.next;
        fast = fast.next.next;
    }

    return true;
}
