import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    ArrayList<Person> roaster ;

    @Before
    public void setUp(){
        roaster = new ArrayList<>();
        roaster.add(new Person("Edelgard", LocalDate.of(1162, Month.JUNE, 22), Person.Sex.FEMALE, "edelgard@blackeagles.edu" ));
        roaster.add(new Person("Hubert", LocalDate.of(1160, Month.APRIL, 17), Person.Sex.MALE, "hubert@blackeagles.edu" ));
        roaster.add(new Person("Dimitri", LocalDate.of(1162, Month.NOVEMBER, 20), Person.Sex.MALE, "dimitri@bluelions.edu" ));
        roaster.add(new Person("Dedue", LocalDate.of(1161, Month.AUGUST, 31), Person.Sex.MALE, "dedue@bluelions.edu" ));
        roaster.add(new Person("Claude", LocalDate.of(1162, Month.JULY, 24), Person.Sex.MALE, "claude@goldendeers.edu" ));
        roaster.add(new Person("Hilda", LocalDate.of(1162, Month.FEBRUARY, 3), Person.Sex.FEMALE, "hilda@goldendeers.edu" ));
        roaster.add(new Person("Yuri", LocalDate.of(1160, Month.AUGUST, 12), Person.Sex.MALE, "yuri@ashenwolves.edu" ));
        roaster.add(new Person("Seteth", LocalDate.of(0, Month.DECEMBER, 27), Person.Sex.MALE, "seteth@seiros.edu" ));
        roaster.add(new Person("Flayn", LocalDate.of(0, Month.JULY, 12), Person.Sex.FEMALE, "flayn@seiros.edu" ));
    }

    @Test
    public void getAge() {
        assertEquals(2019,roaster.get(8).getAge());
    }

    @Test
    public void getName() {
        assertEquals("Edelgard",roaster.get(0).getName());
    }

    @Test
    public void getBirthday() {
        assertEquals(LocalDate.of(1162, Month.JUNE, 22),roaster.get(0).getBirthday());
    }

    @Test
    public void getGender() {
        assertEquals(Person.Sex.MALE,roaster.get(4).getGender());
    }

    @Test
    public void getEmailAddress() {
        assertEquals("claude@goldendeers.edu",roaster.get(4).getEmailAddress());
    }

    @Test
    public void printPerson() {
        roaster.get(2).printPerson();
    }

    @Test
    public void printPersonsByLocalClassFemaleChecker() {
        Person.printPersons(roaster,new FemaleChecker());
    }

    @Test
    public void printPersonsByAnonClassMaleChecker() {
        Person.printPersons(roaster, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender().equals(Person.Sex.MALE);
            }
        });
    }

    @Test
    public void printPersonsByLambdaEmailChecker() {
        Person.printPersons(roaster, p -> p.getEmailAddress().contains("goldendeers"));
    }

}