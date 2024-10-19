package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListdTest {
    private Main.Listd list;


    @Before
    public void initTest() {
        Main mainInstance = new Main();
        list = mainInstance.new Listd();
    }

    @After
    public void afterTest() {
        list = null;
    }
    // AddEl
    @Test
    public void AddElToEmptyListTest() {
        Main mainInstance = new Main();
        list.AddEl(mainInstance.new ListEl(1));

        assertNotNull("List not empty", list.Head);
        assertEquals("Head element is added element", 1, list.Head.key);
    }

    @Test
    public void AddElToNotEmptyListTest() {
        Main mainInstance = new Main();
        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));

        assertNotNull("List not empty", list.Head);
        assertEquals("Head element is first element", 1, list.Head.key);
        assertEquals("Next element is added element", 2, list.Head.next.key);
        assertEquals("Prev element second's element is head element", 1, list.Head.next.prev.key);
        assertNull("Next element second's element is null", list.Head.next.next);
    }
    // ShowList
    @Test
    public void ShowListEmptyListTest() {

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List is not null", elementsList);
        assertTrue("List is empty", elementsList.isEmpty());
    }

    @Test
    public void ShowListSingleElementTest() {
        Main mainInstance = new Main();

        Main.ListEl singleElement = mainInstance.new ListEl(1);
        list.AddEl(singleElement);

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List should not be null", elementsList);
        assertEquals("List should contain one element", 1, elementsList.size());
        assertEquals("First element should be 1", Integer.valueOf(1), elementsList.get(0));
    }

    @Test
    public void ShowListMultipleElementTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));
        list.AddEl(mainInstance.new ListEl(3));


        List<Integer> elementsList = list.ShowList();
        assertNotNull("List should not be null", elementsList);
        assertEquals("List should contain 3 elements", 3, elementsList.size());
        assertEquals("First element should be 1", Integer.valueOf(1), elementsList.get(0));
        assertEquals("Second element should be 2", Integer.valueOf(2), elementsList.get(1));
        assertEquals("Third element should be 3", Integer.valueOf(3), elementsList.get(2));
    }
    // FindTail
    @Test
    public void FindTailEmptyListTest() {
        Main mainInstance = new Main();

        Main.ListEl tail = list.FindTail();
        assertNotNull("List should not be null", list);
        assertNull("Tail should be null", tail);

    }
    @Test
    public void FindTailSingleElementListTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));

        Main.ListEl tail = list.FindTail();
        assertNotNull("List should not be null", list);
        assertNotNull("Tail should not be null", tail);
        assertEquals("Tail should be 1", 1, tail.key);
    }

    @Test
    public void FindTailMultipleElementListTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));
        list.AddEl(mainInstance.new ListEl(3));

        Main.ListEl tail = list.FindTail();
        assertNotNull("List should not be null", list);
        assertNotNull("Tail should not be null", tail);
        assertEquals("Tail should be 3", 3, tail.key);
    }
    // AddElByIndex
    @Test
    public void AddElByIndexEmptyListTest() {
        Main mainInstance = new Main();

        list.AddElByIndex(mainInstance.new ListEl(1), 0);

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List should not be null", list);
        assertEquals("List should contain one element", 1, elementsList.size());
        assertEquals("First element should be 1", Integer.valueOf(1), elementsList.get(0));
    }

    @Test
    public void AddElByIndexNotEmptyListTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));
        list.AddEl(mainInstance.new ListEl(3));
        list.AddElByIndex(mainInstance.new ListEl(8), 2);

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List should not be null", list);
        assertEquals("List should contain 4 elements", 4, elementsList.size());
        assertEquals("Zero index element should be 1", Integer.valueOf(1), elementsList.get(0));
        assertEquals("First index element should be 2", Integer.valueOf(2), elementsList.get(1));
        assertEquals("Second index element should be 8", Integer.valueOf(8), elementsList.get(2));
        assertEquals("Third index element should be 3", Integer.valueOf(3), elementsList.get(3));
    }

    @Test
    public void AddElByIndexNotEmptyWithNegativeIndexListTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));
        list.AddEl(mainInstance.new ListEl(3));
        list.AddElByIndex(mainInstance.new ListEl(8), -2);

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List should not be null", list);
        assertEquals("List should contain 4 elements", 4, elementsList.size());
        assertEquals("Zero index element should be 8", Integer.valueOf(8), elementsList.get(0));
        assertEquals("First index element should be 1", Integer.valueOf(1), elementsList.get(1));
        assertEquals("Second index element should be 2", Integer.valueOf(2), elementsList.get(2));
        assertEquals("Third index element should be 3", Integer.valueOf(3), elementsList.get(3));
    }

    @Test
    public void AddElByIndexNotEmptyListOutOfScopeTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));
        list.AddEl(mainInstance.new ListEl(3));
        list.AddElByIndex(mainInstance.new ListEl(8), 6);

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List should not be null", list);
        assertEquals("List should contain 4 elements", 4, elementsList.size());
        assertEquals("Zero index element should be 1", Integer.valueOf(1), elementsList.get(0));
        assertEquals("First index element should be 2", Integer.valueOf(2), elementsList.get(1));
        assertEquals("Second index element should be 3", Integer.valueOf(3), elementsList.get(2));
        assertEquals("Third index element should be 8", Integer.valueOf(8), elementsList.get(3));
    }

    @Test
    public void AddElByIndexNotEmptyListAsTailTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));
        list.AddEl(mainInstance.new ListEl(3));
        list.AddElByIndex(mainInstance.new ListEl(8), 3);

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List should not be null", list);
        assertEquals("List should contain 4 elements", 4, elementsList.size());
        assertEquals("Zero index element should be 1", Integer.valueOf(1), elementsList.get(0));
        assertEquals("First index element should be 2", Integer.valueOf(2), elementsList.get(1));
        assertEquals("Second index element should be 3", Integer.valueOf(3), elementsList.get(2));
        assertEquals("Third index element should be 8", Integer.valueOf(8), elementsList.get(3));
        assertNull("Next element of added should be null", list.FindTail().next);
    }

    @Test
    public void AddElByIndexNotEmptyListAsHeadTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));
        list.AddEl(mainInstance.new ListEl(3));
        list.AddElByIndex(mainInstance.new ListEl(8), 0);

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List should not be null", list);
        assertEquals("List should contain 4 elements", 4, elementsList.size());
        assertEquals("Zero index element should be 8", Integer.valueOf(8), elementsList.get(0));
        assertEquals("First index element should be 1", Integer.valueOf(1), elementsList.get(1));
        assertEquals("Second index element should be 2", Integer.valueOf(2), elementsList.get(2));
        assertEquals("Third index element should be 3", Integer.valueOf(3), elementsList.get(3));
        assertNull("Previous element of added should be null", list.Head.prev);
    }

    // ReverseFromEnd

    @Test
    public void ReverseFromEndEmptyListTest() {
        list.ReverseFromEnd();

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List is not null", elementsList);
        assertTrue("List is empty", elementsList.isEmpty());
    }

    @Test
    public void ReverseFromEndSingleElementListTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));

        list.ReverseFromEnd();

        List<Integer> elementsList = list.ShowList();
        assertNotNull("List is not null", elementsList);
        assertEquals("List should contain 1 element", 1, elementsList.size());
        assertEquals("Head element should be 1", 1, list.Head.key);

    }

    @Test
    public void ReverseFromEndMultipleElementsListTest() {
        Main mainInstance = new Main();

        list.AddEl(mainInstance.new ListEl(1));
        list.AddEl(mainInstance.new ListEl(2));
        list.AddEl(mainInstance.new ListEl(3));

        list.ReverseFromEnd();

        List<Integer> elementsList = list.ShowList();
        Main.ListEl tail = list.FindTail();
        assertNotNull("List is not null", elementsList);
        assertEquals("First element should be 3", Integer.valueOf(3), elementsList.get(0));
        assertEquals("Second element should be 2", Integer.valueOf(2), elementsList.get(1));
        assertEquals("Third element should be 1", Integer.valueOf(1), elementsList.get(2));
        assertEquals("Head element should be 3", 3, list.Head.key);
        assertEquals("Tail element should be 1", 1, tail.key);

    }
}
