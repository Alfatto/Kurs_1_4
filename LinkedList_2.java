import java.util.*;


import java.util.ArrayList;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
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

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
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
        Node node = head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;

        if (node == null || find(_value) == null) {
            return false;
        }

        if (node.value == _value && node.next == null) {
            node = null;
            this.head = null;
            this.tail = null;
        }

        while (node != null) {
            if (head.next.next == null && head.value == _value) {
                head.value = node.next.value;
                node.next.prev = null;
                node.next = node.next.next;
                tail.value = head.value;
                tail.prev = null;
                break;
            }
            if (head.value == _value) {
                head.value = node.next.value;
                node.next.prev = null;
                node.next = node.next.next;
                break;
            } else if (node.next.value == _value && node.next.next != null) {
                node.next.value = node.next.next.value;
                node.next.next.value = _value;
            } else if (node.next.value == _value && node.next.next == null) {
                this.tail.value = node.value;
                this.tail.prev = node.prev;
                node.next = null;
            }
            node = node.next;
        }
        return true;
    }

    public void removeAll(int _value) {
        if (head.value == _value && head.next == null) {
            this.head = null;
            this.tail = null;
            return;
        }
        while (remove(_value)) {
            remove(_value);
        }
        // здесь будет ваш код удаления всех узлов по заданному значению
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

        Node curret = this.head;
        while (curret != null) {
            if (_nodeAfter.value == this.tail.value) {
                this.tail.next = _nodeToInsert;
                _nodeToInsert.prev = this.tail;
                this.tail = _nodeToInsert;
                return;
            }
            if (curret.value == _nodeAfter.value) {
                _nodeToInsert.next = curret.next;
                curret.next.prev = _nodeToInsert;
                curret.next = _nodeToInsert;
                _nodeToInsert.prev = curret;
            }
            curret = curret.next;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node() {
    }

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}