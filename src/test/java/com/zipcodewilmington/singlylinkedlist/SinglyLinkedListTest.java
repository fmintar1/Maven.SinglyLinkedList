package com.zipcodewilmington.singlylinkedlist;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void addTest() {
        SinglyLinkedList<Integer> linkedTest = new SinglyLinkedList<Integer>();
        linkedTest.add(10);
        linkedTest.add(15);
        linkedTest.add(25);
        Assert.assertTrue(linkedTest.checkNode(25));
        Assert.assertTrue(linkedTest.checkNode(10));
    }
    @Test
    public void addPositionTest() {
        SinglyLinkedList<Integer> linkedTest = new SinglyLinkedList<Integer>();
        linkedTest.add(10);
        linkedTest.add(15);
        linkedTest.add(25);
        linkedTest.addPosition(2, 20);
        linkedTest.addPosition(3, 30);
        Assert.assertTrue(linkedTest.checkNode(20));
        Assert.assertTrue(linkedTest.checkNode(30));
    }
    @Test
    public void removeTest() {
        SinglyLinkedList<Integer> linkedTest = new SinglyLinkedList<Integer>();
        linkedTest.add(10);
        linkedTest.add(15);
        linkedTest.add(25);
        linkedTest.removeNode(15);
        Assert.assertFalse(linkedTest.checkNode(15));
        Assert.assertTrue(linkedTest.checkNode(10));
    }
    @Test
    public void containsTest() {
        SinglyLinkedList<Integer> linkedTest = new SinglyLinkedList<Integer>();
        linkedTest.add(10);
        linkedTest.add(15);
        linkedTest.add(25);
        Assert.assertTrue(linkedTest.checkNode(25));
        Assert.assertFalse(linkedTest.checkNode(30));
    }
    @Test
    public void findIndexTest() {
        SinglyLinkedList<Integer> linkedTest = new SinglyLinkedList<Integer>();
        linkedTest.add(10);
        linkedTest.add(15);
        linkedTest.add(25);
        Assert.assertEquals(linkedTest.findIndex(15), 1);
        Assert.assertEquals(linkedTest.findIndex(25), 2);
        Assert.assertEquals(linkedTest.findIndex(30), -1);
    }
    @Test
    public void getDataTest() {
        SinglyLinkedList<Integer> linkedTest = new SinglyLinkedList<Integer>();
        linkedTest.add(10);
        linkedTest.add(15);
        linkedTest.add(25);
        Assert.assertEquals(linkedTest.getElement(0),10);
        Assert.assertEquals(linkedTest.getElement(1),15);
        Assert.assertEquals(linkedTest.getElement(2),25);
        Assert.assertNull(linkedTest.getElement(3));
    }
    @Test
    public void getCopyTest() {
        SinglyLinkedList<Integer> linkedTest = new SinglyLinkedList<Integer>();
        linkedTest.add(10);
        linkedTest.add(15);
        linkedTest.add(25);
        SinglyLinkedList<Integer> copyTest = new SinglyLinkedList<>();
        copyTest = copyTest.getCopy(linkedTest);
        Assert.assertEquals(linkedTest, copyTest);
        Assert.assertEquals(linkedTest.checkNode(10),copyTest.checkNode(10));
        Assert.assertEquals(linkedTest.checkNode(15),copyTest.checkNode(15));
        Assert.assertEquals(linkedTest.checkNode(25),copyTest.checkNode(25));
    }
    @Test
    public void getSizeTest() {
        SinglyLinkedList<Integer> linkedTest = new SinglyLinkedList<Integer>();
        linkedTest.add(10);
        linkedTest.add(15);
        linkedTest.add(25);
        linkedTest.add(5);
        linkedTest.add(20);
        int expected = linkedTest.findSize();
        Assert.assertEquals(4, expected);
    }
    @Test
    public void SortTest() {
        SinglyLinkedList<Integer> linkedTest = new SinglyLinkedList<Integer>();
        linkedTest.add(10);
        linkedTest.add(15);
        linkedTest.add(25);
        linkedTest.add(5);
        linkedTest.add(20);
        String actual = "These are the contents of the list:\n[ 5 ][ 10 ][ 15 ][ 20 ][ 25 ] [END OF THE LIST]";
        Assert.assertEquals(linkedTest.sortListAsc().print(), actual);
        String actual2 = "These are the contents of the list:\n[ 25 ][ 20 ][ 15 ][ 10 ][ 5 ] [END OF THE LIST]";
        Assert.assertEquals(linkedTest.sortListDesc().print(), actual2);
    }
}