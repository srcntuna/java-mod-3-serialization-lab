package IOServices;

import PersonServices.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvIOService implements IOService {

    @Override
    public void writeToFile(String fileName, List<Person> people) throws Exception {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("firstName, lastName, birthYear, birthMonth, birthDay\n");

        for (int i=0;i<people.size();i++) {
            Person person = people.get(i);
            if(i == people.size() -1){
                stringBuffer.append(person.formatAsCSV());
            }else{
                stringBuffer.append(person.formatAsCSV() + "\n");
            }

        }

        try (FileWriter fileWriter = new FileWriter(fileName);) {

            fileWriter.write(stringBuffer.toString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }

    @Override
    public List<Person> parseFile(String fileName) {

        List<Person> people = new ArrayList<>();

        File csvFile = new File(fileName);
        Scanner scanner;
        try {
            scanner = new Scanner(csvFile);
        } catch (Exception e) {
            System.out.println("File does not exist");
            return null;
        }
        System.out.println("File does exist!");

        String header = scanner.nextLine();

        while (scanner.hasNextLine()) {
            String thisLine = scanner.nextLine();

            String[] personStrings = thisLine.split(",");

            String firstName = personStrings[0];
            String lastName = personStrings[1];
            int birthYear = Integer.parseInt(personStrings[2]);
            int birthMonth= Integer.parseInt(personStrings[3]);
            int birthDay = Integer.parseInt(personStrings[4]);

            Person student = new Person(firstName, lastName, birthYear,birthMonth,birthDay);

            people.add(student);
        }

        return  people;
    }
}
