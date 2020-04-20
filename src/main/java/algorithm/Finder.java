package algorithm;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Finder {

    private final List<Person> people;
    private Couple easyAnswer = null;

    public Finder(List<Person> people) {

        this.people = people;

        if (people.size() < 2) {
            this.easyAnswer = new Couple(null,null);
        }if(people.size() == 2){
            this.easyAnswer = new Couple(people.get(0),people.get(1));
        }

    }

    public Couple findClosestCouple() {

        if(easyAnswer != null){ return easyAnswer; }

        List<Person> sortedPeople = people.stream()
                .sorted(Person::compare)
                .collect(Collectors.toList());

        Couple closestCouple = IntStream.range(0,sortedPeople.size()-2)
            .mapToObj( p -> new Couple(sortedPeople.get(p),sortedPeople.get(p+1)))
            .min(Couple::compare).get();

        return closestCouple;
    }

    public Couple findFurthestCouple() {

        if(easyAnswer != null){ return easyAnswer; }

        List<Person> sortedPeople = people.stream()
                .sorted(Person::compare)
                .collect(Collectors.toList());

        Person younger = sortedPeople.get(0);
        Person older = sortedPeople.get(sortedPeople.size()-1);

        Couple furthestCouple = new Couple(younger,older);

        return furthestCouple;
    }
}
