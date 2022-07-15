package SerializationServices;

import PersonServices.Person;

import java.io.*;

public class Serialization {

    public void serializePerson(Person person) throws IOException, IOException {
        ObjectOutputStream personObjectStream = null;
        try {
            FileOutputStream personFile = new FileOutputStream(person.getFirstName()+".dat");
            personObjectStream = new ObjectOutputStream(personFile);
            personObjectStream.writeObject(person);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (personObjectStream != null) {
                personObjectStream.flush();
                personObjectStream.close();
            }
        }
    }




}
