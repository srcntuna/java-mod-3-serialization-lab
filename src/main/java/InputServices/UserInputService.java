package InputServices;

public interface UserInputService extends  AutoCloseable{

    String getUserInput();
    String getUserInputToPrompt(String prompt);

}
