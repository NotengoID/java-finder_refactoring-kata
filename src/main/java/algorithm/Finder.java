package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {

    private final List<Person> people;

    public Finder(List<Person> people) {
        this.people = people;
    }

    public Couple findCouple(Criteria criteria) {

        List<Couple> couples = new ArrayList<>();

        for (int i = 0; i < this.people.size() - 1; i++) {
            for (int j = i + 1; j < this.people.size(); j++) {

                Couple r = new Couple(this.people.get(i),this.people.get(j));
                couples.add(r);
            }
        }

        if (couples.size() < 1) {
            return new Couple(null,null);
        }

        Couple answer = couples.get(0);

        for (Couple couple : couples) {
            switch (criteria) {
                case Closest:
                    if (couple.isCloserThan(answer)) {
                        answer = couple;
                    }
                    break;

                case Furthest:
                    if (couple.isFurthestThan(answer)) {
                        answer = couple;
                    }
                    break;
            }
        }

        return answer;
    }
}
