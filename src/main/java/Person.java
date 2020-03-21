import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE, EITHER
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public Person(){
        this("",null,Sex.EITHER,"");
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        Period period = Period.between(birthday, LocalDate.now());
        return period.getYears();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void printPerson() {
        System.out.println( name +" "+ gender +" "+birthday+" "+emailAddress);
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}

