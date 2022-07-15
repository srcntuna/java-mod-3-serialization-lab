import IOServices.*;
import InputServices.ScannerUserInputService;
import InputServices.SysoutUserOutputService;
import InputServices.UserInputService;
import InputServices.UserOutputService;
import OptionServices.OptionsService;
import PersonServices.Person;
import PersonServices.PrintPeopleService;
import SerializationServices.Serialization;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIORunner {

    public static void main(String[] args) throws IOException {

        UserOutputService userOutputService = new SysoutUserOutputService();

        try (UserInputService userInputService = new ScannerUserInputService(userOutputService);) {

            OptionsService optionsService = new OptionsService(userInputService);
            int initialOption = optionsService.getInitialOption();
            List<Person> peopleList;
            if (initialOption == 1) {
                peopleList = new CsvIOService().parseFile("person.csv");
            } else if(initialOption == 2){
                peopleList = new JsonIOService().parseFile("person.json");
                System.out.println("line 33" + peopleList.getClass());
            } else if (initialOption == 5){
                     RestorePersonService restorePersonService = new RestorePersonService();
                    int deserializeOption = optionsService.getDeseralizeOption();
                    Person deserializedPerson;
                    if(deserializeOption == 1){
                        deserializedPerson = restorePersonService.deserializePerson("Henrik.dat");
                    }else {
                        deserializedPerson = restorePersonService.deserializePerson("Zlatan.dat");
                    }
                System.out.println(deserializedPerson);
                    return;
            }else{
                peopleList = new ArrayList<>();
            }

            while (true) {
                int toDoOption = optionsService.getToDoOption();

                if (toDoOption == 1) {
                    AddPersonService addPersonService = new AddPersonService(userInputService);
                    addPersonService.createPerson(peopleList);
                } else if (toDoOption == 2) {
                    PrintPeopleService printPeopleService = new PrintPeopleService();
                    printPeopleService.printPeople(peopleList);
                } else {
                    IOService writeToFileService;
                    if (initialOption == 1 || initialOption == 3) {
                        writeToFileService = new CsvIOService();
                        writeToFileService.writeToFile("person.csv", peopleList);
                    } else {
                        writeToFileService = new JsonIOService();
                        writeToFileService.writeToFile("person.json", peopleList);

                    }
                    userOutputService.printMessage("GOODBYE!");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}





