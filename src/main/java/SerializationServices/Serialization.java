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

    static Person deserializePerson(Person person) throws IOException {
        ObjectInputStream personInputStream = null;
        Person newPerson = null;
        try {
            FileInputStream personFile = new FileInputStream(person.getFirstName()+".dat");
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
