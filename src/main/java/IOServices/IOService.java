package IOServices;

import PersonServices.Person;

import java.io.IOException;
import java.util.List;

public interface IOService {

    public void writeToFile(String fileName, List<Person> people) throws Exception;

    public List<Person> parseFile(String fileName) throws IOException;

}
