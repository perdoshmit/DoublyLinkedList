package org.example;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Main mainInstance = new Main();
        Listd list = mainInstance.new Listd();
        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));
        list.AddEl(mainInstance.new ListEl(3));
        System.out.println(list.ShowList());
        System.out.println(list.Head.key);
        list.ReverseFromEnd();
        System.out.println(list.ShowList());
        System.out.println(list.ShowList());
        System.out.println(list.Head.key);
        list.AddElByIndex(mainInstance.new ListEl(8), 3);
        System.out.println(list.ShowList());


    }
     class Listd{
        public ListEl Head;

        public List<Integer> ShowList() {
            List<Integer> elementsList = new ArrayList<>();
            ListEl currentEl = Head;

            while (currentEl != null) {
                elementsList.add(currentEl.key);
                currentEl = currentEl.next;
            }

            return elementsList;
        }

        public ListEl FindTail(){
            if (Head == null) {
                return null;
            }

            ListEl lastEl = Head;

            while(lastEl.next != null){
                lastEl = lastEl.next;
            }
            return lastEl;
        }

        public void AddEl(ListEl newElement){
            if(Head == null){
                Head = newElement;
            }else{
                ListEl lastEl = FindTail();
                lastEl.next = newElement;
                newElement.prev = lastEl;
            }
        }

        public Listd AddElByIndex(ListEl newElement, Integer ElNum){
            if(Head == null){
                Head = newElement;
                return this;
            }

            Integer number = 0;
            ListEl currentEl = Head;
            while(currentEl != null && number < ElNum){
                currentEl = currentEl.next;
                number++;
            }

            if(currentEl == null){
                AddEl(newElement);
            }else{
                newElement.next = currentEl;
                newElement.prev = currentEl.prev;
                currentEl.prev = newElement;
                if(newElement.prev!=null) {
                    newElement.prev.next = newElement;
                }else{
                    Head = newElement;
                }
            }

            return this;
        }

        public Listd ReverseFromEnd(){
            if(Head == null){
                return null;
            }
            ListEl tail = FindTail();


            ListEl currentEl = tail;
            ListEl temp = null;
            while (currentEl != null) {
                temp = currentEl.next;
                currentEl.next=currentEl.prev;
                currentEl.prev = temp;
                currentEl=currentEl.next;
            }
            Head = tail;

            return this;
        }

        public Listd ReverseFromStart(){
            if(Head == null){
                return null;
            }

            ListEl currentEl = Head;
            ListEl temp = null;
            while (currentEl != null){
                temp = currentEl.next;
                currentEl.next = currentEl.prev;
                currentEl.prev = temp;
                temp = currentEl;
                currentEl = currentEl.prev;

            }
            Head = temp;
            return this;
        }
    }

    class ListEl{
        public ListEl next;
        public int key;
        public ListEl prev;

        public ListEl(int key) {
            this.key = key;
            this.next = null;
            this.prev = null;
        }

    }
}