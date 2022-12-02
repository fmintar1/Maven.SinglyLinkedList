package com.zipcodewilmington.singlylinkedlist;

import org.w3c.dom.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <T extends Comparable>{
    public Node head = null;                                //CREATE THE HEAD OF THE LINKEDLIST AS NULL

    class Node {                                             //CREATE A NEW CLASS NODE
        T data;                                             //CREATE A GENERIC TYPE DATA FOR DATA STORAGE
        Node next;                                          //CREATE A NODE FOR THE NEXT VALUE NODE
        public Node(T data) {                               //CONSTRUCT A NODE THAT PASSES A GENERIC DATA
            this.data = data;                               //SET PARAMETER DATA TO FIELD DATA
            this.next = null;                               //SET NEXT TO NULL
        }
    }
    public void add(T data) {                               //CREATE ADD METHOD THAT PASSES A GENERIC TYPE DATA
        Node newNode = new Node(data);                      //CREATE A NEW NODE CLASS THAT PASSES THE GENERIC TYPE DATA
        if(head == null) {                                  //THE BEGINNING OF LINKEDLIST CREATION ALWAYS HAVE HEAD AS NULL
            head = newNode;                                 //HEAD IS EQUAL TO NEWNODE ON 20
        } else {
            Node temp = this.head;                          //IF HEAD IS NOT NULL, CREATE A TEMP THAT TAKES THE VALUE OF HEAD
            while(temp.next != null) {                      //CREATE A LOOP WHEN NEXT IS NOT EMPTY
                temp = temp.next;                           //TRAVERSE THROUGH THE LIST UNTIL NEXT IS NULL
            }
            temp.next = newNode;                            //IF NEXT IS NULL, NEXT BECOMES NEWNODE AND SO ON
        }
    }
    public void addPosition(int position, T data) {         //CREATE ADDPOSITION METHOD THAT PASSES INT POSITION & GENERIC TYPE DATA
        Node newNode = new Node(data);                      //CREATE A NEW NODE CLASS THAT PASSES THE GENERIC TYPE DATA
        Node prevNode = this.head;                          //CREATE A TEMP PREVNODE NODE FOR NEWNODE
        Node newNext = this.head;                           //CREATE A TEMP NEWNEXT NODE FOR NEWNODE
        if(position == 1) {
            newNode.next = head;                            //IF THE NEWNODE IS MEANT FOR HEAD, MAKE NEWNODE NEXT AS CURRENT HEAD
            head = newNode;                                 //CHANGE CURRENT HEAD AS THE NEWNODE
            return;                                         //ADD RETURN TO EXIT THE METHOD (CAN BE USED TO ESCAPE VOID METHOD)
        }
        while(newNext.next != null && --position > 0) {     //TRAVERSE THROUGH THE LIST AS LONG AS POSITION ISN'T REACHED & NEXT ISN'T NULL
            prevNode = newNext;                             //USE PREVNODE AS A PLACEHOLDER TO BE BEHIND NEWNEXT DURING TRAVERSING
            newNext = newNext.next;                         //USE NEWNEXT AS A PLACEHOLDER TO BE NEXT OF PREVNODE DURING TRAVERSING
        }                                                   //ONCE POSITION IS REACHED AND NODE IS STILL NOT NULL...
        prevNode.next = newNode;                            //LINK THE NODE OF THE PREVNODE (BEHIND NODE THAT NEEDS TO BE CHANGED) TO THE NEW NODE
        newNode.next = newNext;                             //LINK THE NODE OF THE NEWNODE (NEXT TO PREVNODE) TO NEWNEXT (WAS LINKED TO PREVNODE)
    }
    public void removeNode(T data) {                                //CREATE REMOVENODE METHOD THAT PASSES GENERIC TYPE DATA
        if(this.head.data == data) {                                //IF THE HEAD IS THE DATA TO REMOVE...
            this.head = this.head.next;                             //CREATE THE NODE NEXT TO THE HEAD AS THE HEAD
            return;                                                 //BREAK OUT OF THE METHOD
        }
        Node prevNode = this.head;                                  //CREATE A TEMP PREVNODE NODE AS PLACEHOLDER BEFORE DELETED NODE
        Node nodeToDelete = this.head;                              //CREATE A TEMP NODETODELETE NODE AS PLACEHOLDER FOR DELETED NODE
        while(nodeToDelete != null && nodeToDelete.data != data) {  //TRAVERSE THROUGH THE LIST AS LONG AS DATA ISN'T EQUAL & ISN'T NULL
            prevNode = nodeToDelete;                                //USE PREVNODE AS A PLACEHOLDER TO BE BEHIND NODETODELETE DURING TRAVERSING
            nodeToDelete = nodeToDelete.next;                       //USE NODETODELETE AS A PLACEHOLDER TO BE THE NODE TO BE DELETED
        }
        if(nodeToDelete != null) {                                  //ONCE DATA IS FOUND & NODE IS STILL NOT NULL...
            prevNode.next = nodeToDelete.next;                      //LINK PREVNODE TO THE NODE NEXT TO NODETODELETE
        } else {
            System.out.println("Node does not exist");
        }
    }
    public boolean checkNode(T data) {                              //CREATE CHECKNODE METHOD THAT PASSES GENERIC TYPE DATA
        if(this.head.data == data) {                                //IF THE HEAD IS THE DATA TO CHECK...
            return true;                                            //RETURN TRUE
        }
        Node nodeChecker = this.head;                               //CREATE A TEMP NODECHECKER NODE AS PLACEHOLDER FOR CHECKED NODE
        while(nodeChecker != null && nodeChecker.data != data) {    //TRAVERSE THROUGH THE LIST AS LONG AS DATA ISN'T EQUAL & ISN'T NULL
            nodeChecker = nodeChecker.next;                         //USE NODECHECKER AS A PLACEHOLDER TO BE THE NODE TO BE CHECKED
        }
        return nodeChecker != null;                                 //RETURN TRUE IF NODEHCECKED EXISTED, OTHERWISE RETURN FALSE
    }
    public int findIndex(T data) {
        int counter = 0;
        if(this.head.data == data) return counter;
        Node nodeIndex = this.head;
        while(nodeIndex != null && nodeIndex.data != data) {
            counter++;
            nodeIndex = nodeIndex.next;
        }
        if(!checkNode(data)) return -1;
        return counter;
    }
    public int findSize() {
        int counter = 0;
        if(this.head.data == null) return counter;
        Node temp = this.head;
        while(temp.next != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }
    public T getElement(int index) {
        int counter = 0;
        if(index == 0) return this.head.data;
        Node nodeGet = this.head;
        while(nodeGet.next != null && counter != index) {
            counter++;
            nodeGet = nodeGet.next;
        }
        if(counter != index) return null;
        return nodeGet.data;
    }
    public SinglyLinkedList<T> getCopy(SinglyLinkedList<T> links) {
        return links;
    }
    public SinglyLinkedList<T> sortListAsc()  {
        Node prevNode = this.head;
        Node curNode = prevNode.next;
        Node temp = new Node(head.data);
        for(int i = 0; i < this.findSize(); i++) {
            while(curNode != null) {
                if(prevNode.data.compareTo(curNode.data) > 0) {
                    temp.data = prevNode.data;
                    prevNode.data = curNode.data;
                    curNode.data = temp.data;
                }
                prevNode = curNode;
                curNode = curNode.next;
            }
            prevNode = this.head;
            curNode = prevNode.next;
        }
        return this;
    }
    public SinglyLinkedList<T> sortListDesc()  {
        Node prevNode = this.head;
        Node curNode = prevNode.next;
        Node temp = new Node(head.data);
        for(int i = 0; i < this.findSize(); i++) {
            while(curNode != null) {
                if(prevNode.data.compareTo(curNode.data) < 0) {
                    temp.data = prevNode.data;
                    prevNode.data = curNode.data;
                    curNode.data = temp.data;
                }
                prevNode = curNode;
                curNode = curNode.next;
            }
            prevNode = this.head;
            curNode = prevNode.next;
        }
        return this;

    }
    public String print() {
        String result = "";
        if (this.head == null) {
            System.out.println("This list is empty");
        } else {
            result += ("These are the contents of the list:\n");
            Node temp = this.head;
            while(temp != null) {
                result += ("[ " + temp.data + " ]");
                temp = temp.next;
            }
            result += (" [END OF THE LIST]");
        }
        return result;
    }
//    add -- add an element to the list
//	- remove -- remove an element (specified by numeric index) from the list
//	- contains -- returns true if the element is in the list, false otherwise
//	- find -- returns the element's index if it is in the list, -1 otherwise
//  - size -- returns the current size of the list
//	- get -- returns the element at the specified index
//	- copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
//	- sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)
}
