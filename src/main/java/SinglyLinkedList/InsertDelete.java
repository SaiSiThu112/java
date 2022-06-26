package SinglyLinkedList;

import lombok.Getter;
import lombok.Setter;

interface LinkedList<T> {
        void add(T data);
        void delete(T data);
        void removeNode();
        int size();
        boolean IsNextNotNull();

        T currentData();
}

class SinglyLinkedList<T> implements LinkedList<T>{

        private Node head;
        private int size;

        private Node currentNode, prevNode;
        private int count;
        private T data;

        @Override
        public void add(T data){
                size++;
                Node node= new Node(data);
                Node n= head;   //n=Local Variable , head=Instant Variable

                if(n==null){
                        head= node;
                }
                else {
                        while (n.next!=null){
                                n= n.next;
                        }
                        n.next= node;
                }
        }

        @Override
        public void delete(T data) {
                Node cur= head ;
                Node prev= null;
                if(cur==null) return;
                if(cur!=null&&cur.data==data){
                        head=cur.next;
                        size--;
                        return;
                }
                while (cur.data!=data){
                        prev=cur;
                        cur= cur.next;
                }
                if(cur==null) return;
                if(cur.data==data) {
                        prev.next = cur.next;
                        size--;
                }
        }

        @Override
        public void removeNode() {
                if(prevNode==head&&prevNode.data==data){
                        head=prevNode.next;
                }
                if(prevNode.next.data==data){
                        prevNode.next=currentNode;
                }
        }

        @Override
        public int size(){
                return size;
        }

        @Override
        public boolean IsNextNotNull() {
                if(count==0){
                        currentNode=head;
                        prevNode=null;
                }
                if(prevNode!=null){
                        while(prevNode.next!=currentNode){
                                prevNode=prevNode.next;
                        }
                }
                boolean hasNode=false;
                if(currentNode!=null){
                        data= (T)currentNode.data;
                        currentNode=currentNode.next;
                        if(prevNode==null){
                                prevNode=head;
                        }
                        hasNode=true;
                        count++;
                }
                else{
                        count=0;
                }
                return hasNode;
        }

        @Override
        public T currentData() {
                return data;
        }

        private class Node{
                private T data;
                private Node next;

                private Node(T data){
                        this.data=data;
                        this.next=null;
                }
        }
                /*public void printList(){
                        Node n= head;

                        while(n!=null){

                                System.out.println(n.data);
                                n=n.next;
                        }
                }*/
}
@Getter
@Setter
class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
                this.name = name;
                this.age = age;
        }
}

class ListIterator<T>{
        private LinkedList<T> linkedList;

        public ListIterator(LinkedList<T> linkedList) {
                this.linkedList = linkedList;
        }
        public boolean hasNext(){
                return linkedList.IsNextNotNull();
        }
        public T data(){
                return linkedList.currentData();
        }
        public void remove(){
                linkedList.removeNode();
        }
}

public class InsertDelete {
        public static void main(String[] args) {
                nonPrimitives();
        }

        public static void primitives(){
                LinkedList<Integer> numbers = new SinglyLinkedList<Integer>();
                numbers.add(1);
                numbers.add(2);
                numbers.add(3);
                numbers.add(4);
                numbers.add(5);

                ListIterator<Integer> itr= new ListIterator<Integer>(numbers);
                while(itr.hasNext()){
                         if(itr.data()==4){
                                 itr.remove();
                         }
                }
                while(itr.hasNext()){
                        System.out.println(itr.data());
                }
        }

        public static void nonPrimitives(){
                LinkedList<Person> people= new SinglyLinkedList<Person>();
                people.add(new Person("Mg Mg",21));
                people.add(new Person("Hla Hla",20));
                people.add(new Person("Mya Mya",19));
                people.add(new Person("Mg Mg",30));

                ListIterator<Person> itr= new ListIterator<Person>(people);
                while(itr.hasNext()){
                        Person prn= itr.data();
                        if(prn.getName().equals("Mg Mg")&&prn.getAge()==21){
                                itr.remove();
                        }

                }
                while(itr.hasNext()){
                        Person prn= itr.data();
                        System.out.println(prn.getName()+"-->"+prn.getAge());
                }
        }
}

