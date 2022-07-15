package IOServices;

import PersonServices.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RestorePersonService {

    public Person deserializePerson(String fileStr ) throws IOException {
        ObjectInputStream personInputStream = null;
        Person newPerson = null;
        try {
            FileInputStream personFile = new FileInputStream(fileStr);
            personInputStream = new ObjectInputStream(personFile);
            newPerson = (Person) personInputStream.readObject();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (personInputStream != null) {
                personInputStream.close();
            }
        }

        return newPerson;
    }

}
