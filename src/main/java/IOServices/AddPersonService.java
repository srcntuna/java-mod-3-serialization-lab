package IOServices;

import InputServices.UserInputService;
import PersonServices.Person;
import SerializationServices.Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AddPersonService {

    private UserInputService userInputService;

    public AddPersonService(UserInputService userInputService) {

        this.userInputService = userInputService;

    }

    public void createPerson(List<Person> peopleList) throws IOException {
        String firstName = userInputService.getUserInputToPrompt("What is firstName?");
        String lastName = userInputService.getUserInputToPrompt("What is lastName?");
        String birthYearStr = userInputService.getUserInputToPrompt("What is birthYear?");
        int birthYear = Integer.parseInt(birthYearStr);
        String birthMonthStr = userInputService.getUserInputToPrompt("What is birthMonth?");
        int birthMonth = Integer.parseInt(birthMonthStr);
        String birthDayStr = userInputService.getUserInputToPrompt("What is birthDay?");
        int birthDay = Integer.parseInt(birthDayStr);
        System.out.println("Line 25");
        Person newPerson  = new Person(firstName,lastName,birthYear,birthMonth,birthDay);
        System.out.println("Line 27");
        peopleList.add(newPerson);
        serializePerson(newPerson);
        System.out.println("Line 29");
        System.out.println(firstName+" "+lastName+" successfully added to the list!");
    }

    private void serializePerson(Person person) throws IOException, IOException {
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
