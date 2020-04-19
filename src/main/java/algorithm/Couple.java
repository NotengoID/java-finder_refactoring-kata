package algorithm;
public class Couple {
    private Person older;
    private Person younger;
    private long distance;

    public Couple(Person p1, Person p2){

        if(p1 == null || p2 == null){ return; }

        boolean p1IsOlder = p1.isOlderThan(p2);

        older = (p1IsOlder)?p1:p2;
        younger = (p1IsOlder)?p2:p1;

        distance = older.getDaysOlder(younger);

    }

    public Person getOlder(){
        return older;
    }

    public Person getYounger(){
        return younger;
    }

    public long getDistance() {
        return distance;
    }

    public boolean isCloserThan(Couple c){
        return distance < c.getDistance();
    }

    public boolean isFurthestThan(Couple c){
        return distance > c.getDistance();
    }
}
