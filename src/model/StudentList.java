package model;

import java.io.Serializable;

public class StudentList implements Serializable {

    private Node head;
    private Node tail;
    private int size;

    public StudentList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public StudentList(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public class Node implements Serializable {

        private  Student student;
        private Node nextNode;
        private Node previousNode;

        public Node(Student student) {
            this.student = student;
            this.nextNode = null;
            this.previousNode = null;
        }

        public Student getStudent() {
            return student;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node prevNode) {
            this.previousNode = prevNode;
        }

        @Override
        public String toString() {
            return this.student.toString();
        }
    }

    public Node displayStudentList() {
        Node current = head;
        System.out.println("<<<<<< this is the head >>>>>>");
        while (current != null) {
            System.out.println(current);
            current = current.getNextNode();
        }
        return head;
    }

    public void addStudent(Student student) {
        Node newNode = new Node(student);
        newNode.setNextNode(this.head);
        if (this.head != null) {
            this.head.setPreviousNode(newNode);
        }
        this.head = newNode;
    }

    public Node removeStudent(Student student) {
        Node current = this.head;
        if(this.head == null || this.head.nextNode == null) {
            return null;
        }
        Node temp = this.head;
        while(temp.nextNode.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = null;
        return head;
    }

    public Node findStudentByRegNumber(int userInput) {
        Node current = this.head;
        while(current != null) {
            if(current.student.getRegNumber() == userInput) {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    public Node findStudentByLastName(String userInput) {
        Node current = this.head;
        while(current != null) {
            if(current.student.getLastName() == userInput) {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    public int length() {
        if (head == null)
            return 0;
        int length = 0;
        Node current = this.head;
        while (current != null) {
            length += 1;
            current = current.getNextNode();
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = this.head;
        while (n != null) {
            sb.append("Student Information : ");
            sb.append(n);
            sb.append("\n");
            n = n.getNextNode();
        }
        return sb.toString();
    }
}