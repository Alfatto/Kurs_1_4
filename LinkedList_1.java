import java.util.*;

public class LinkedList {
    static class Node {
        public int value;
        public Node next;

        public Node() {
        }

        public Node(int _value) {
            value = _value;
            next = null;
        }

       /* @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }*/
    }

   /* @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }*/

    //создаем поле с параметром Node
    public Node head;//голова
    public Node tail;//хвост


    public LinkedList() {//при создании объекта инициализируем его поля значением null
        head = null;
        tail = null;
    }


    //добавляем элемент в конец списка
    public void addInTail(Node item) {
        if (this.head == null)//если голова равна нулю, то присваиваем значение item
            this.head = item;
        else this.tail.next = item;
        this.tail = item;
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

    public int count() {
        Node node = this.head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void clear() {
        // здесь будет ваш код очистки всего списка
        this.head = null;
        this.tail = null;
    }


    public ArrayList<Integer> myArray(LinkedList myList) {
        Node node = this.head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (node != null) {
            arrayList.add(node.value);
            node = node.next;
        }
        return arrayList;
    }

   /* public void displayList(LinkedList0 list) {
        if (head == null) {
            System.out.println("null!");
        }
        Node1 node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }*/

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (head == null) {
            return;
        }
        Node node = head, previous;
        if (_nodeAfter == null) {
//            System.out.println("_nodeAfter == null");
            previous = head;
            head = _nodeToInsert;
            head.next = previous;
            return;
        }
        while (node != null) {
            if (node.value == _nodeAfter.value) {
                if (node == tail) {
                    node.next = _nodeToInsert;
                    tail = _nodeAfter;
                } else {
                    previous = node.next;
                    node.next = _nodeToInsert;
                    node.next.next = previous;
                    break;
                }
            }
            node = node.next;
        }
    }

    public static LinkedList sum(LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        if (list1.count() != list2.count()) {
            return result;
        }
        LinkedList.Node node1 = list1.head;
        LinkedList.Node node2 = list2.head;
        LinkedList.Node item;
        while (node1 != null) {
            item = new LinkedList.Node(node1.value + node2.value);
            result.addInTail(item);
            node1 = node1.next;
            node2 = node2.next;
        }
        return result;
    }
}