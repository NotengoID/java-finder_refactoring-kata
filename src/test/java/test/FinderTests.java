package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.Couple;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

    Person sue;
    Person greg;
    Person sarah;
    Person mike;

    @Before
    public void setup() {
        sue = new Person("Sue", LocalDate.of(1950,1,1));
        greg = new Person("Greg",  LocalDate.of(1952,6,1));
        sarah = new Person("Sarah",  LocalDate.of(1982,1,1));
        mike = new Person("Mike",  LocalDate.of(1979,1,1));
    }

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<>();
        Finder finder = new Finder(list);

        Couple result = finder.findClosestCouple();
        assertNull(result.getOlder());
        assertNull(result.getYounger());
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<>();
        list.add(sue);

        Finder finder = new Finder(list);

        Couple result = finder.findClosestCouple();

        assertNull(result.getOlder());
        assertNull(result.getYounger());
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(greg);
        Finder finder = new Finder(list);

        Couple result = finder.findClosestCouple();

        assertEquals(sue, result.getOlder());
        assertEquals(greg, result.getYounger());
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        Couple result = finder.findFurthestCouple();

        assertEquals(greg, result.getOlder());
        assertEquals(mike, result.getYounger());
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        Couple result = finder.findFurthestCouple();

        assertEquals(sue, result.getOlder());
        assertEquals(sarah, result.getYounger());
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        Couple result = finder.findClosestCouple();

        assertEquals(sue, result.getOlder());
        assertEquals(greg, result.getYounger());
    }

}
