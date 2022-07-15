package IOServices;

import IOServices.IOService;

import PersonServices.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonIOService implements IOService {

    public void writeToFile(String fileName, List<Person> people) throws Exception {

        String json = new ObjectMapper().writeValueAsString(people);

        try (FileWriter fileWriter = new FileWriter(fileName);) {

            fileWriter.write(json);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }

    @Override
    public List<Person> parseFile(String fileName) throws IOException {

        List<Person> restoredPersons = null;

        try{
            restoredPersons = new ArrayList<>(Arrays.asList(new ObjectMapper().readValue(new File(fileName), Person[].class)));
        }catch (Exception e){
            e.printStackTrace();
        }

        return restoredPersons;

    }
}
