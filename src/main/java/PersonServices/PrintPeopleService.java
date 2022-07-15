package PersonServices;

import java.util.List;

public class PrintPeopleService {

    public void printPeople(List<Person> peopleList){
        if(peopleList.size() == 0){
            System.out.println("Nobody is in the list");
        }else{
            for(Person person : peopleList){
                System.out.println(person.formatAsCSV());
            }
        }

    }

}
