package algorithm;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class Person {

    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    public static int compare(Person p1, Person p2){ return p1.isOlderThan(p2)?-1:1; }

    public boolean isOlderThan(Person p){
        return birthDate.isBefore(p.birthDate);
    }

    public long getDaysOlder(Person p){
        return ChronoUnit.DAYS.between(birthDate, p.birthDate);
    }
}

