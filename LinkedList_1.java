import java.util.*;
public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }


    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {

        ArrayList<Node> nodes = new ArrayList<Node>();
        if (head == null) {
            return nodes;
        }
        // здесь будет ваш код поиска всех узлов
        Node node1 = head;
        while (node1 != null) {
            if (node1.value == _value) {
                nodes.add(node1);
            }
            node1 = node1.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (head == null) {
            return false;
        }
        Node node = this.head, previous = head;
        while (node != null) {
            if (node.value == _value) {
                if (head.next == null) {
                    head = null;
                    tail = null;
                } else if (head.value == _value) {
                    head = head.next;
                } else {
                    node = previous;
                    node.next = previous.next.next;
                }
                return true;
            }
            previous = node;
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {// здесь будет ваш код удаления всех узлов по заданному значению
        Node node = this.head, previous = head;
        while (node != null) {
            if (node.value == _value && head != null) {
                if (head.next == null) {
                    head = null;
                    tail = null;
                } else if (head.value == _value) {
                    head = head.next;
                } else if (node == tail) {
                    tail = previous;
                    tail.next = null;
                } else {
                    node = previous;
                    node.next = previous.next.next;
                }
            }
            previous = node;
            node = node.next;
        }
    }

    public void clear() {
        // здесь будет ваш код очистки всего списка
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

   public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (this.head == null) {
            addInTail(_nodeToInsert);
            return;
        }
        Node current = this.head;
        while(current != null) {
            if(_nodeAfter.value == this.tail.value) {
                this.tail.next = _nodeToInsert;
                _nodeToInsert.prev = this.tail;
                this.tail = _nodeToInsert;
                _nodeToInsert.next = null;
                return;
            }
            if(current.value == _nodeAfter.value) {
                _nodeToInsert.next = current.next;
                current.next.prev = _nodeToInsert;
                current.next = _nodeToInsert;
                _nodeToInsert.prev = current;
                return;
            }
            current = current.next;
        }
    }

   /* @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }*/
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }

    /*@Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }*/
}