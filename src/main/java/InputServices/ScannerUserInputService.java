package InputServices;

import java.util.Scanner;

public class ScannerUserInputService implements UserInputService{

    private Scanner scanner;
    private UserOutputService userOutputService;

    public ScannerUserInputService(UserOutputService userOutputService) {
        this.scanner = new Scanner(System.in);
        this.userOutputService = userOutputService;
    }


    @Override
    public String getUserInput() {
        String input = scanner.nextLine();
        if (input.isBlank()) {
            return getUserInput();
        }
        return input;    }

    @Override
    public String getUserInputToPrompt(String prompt) {
        userOutputService.printMessage(prompt);
        String input = scanner.nextLine();
        if (input.isBlank()) {
            return getUserInputToPrompt(prompt);
        }
        return input;
    }

    @Override
    public void close() throws Exception {
scanner.close();
    }
}
