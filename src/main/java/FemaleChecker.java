public class FemaleChecker implements CheckPerson{
    @Override
    public boolean test(Person p) {
        return p.getGender().equals(Person.Sex.FEMALE);
    }
}