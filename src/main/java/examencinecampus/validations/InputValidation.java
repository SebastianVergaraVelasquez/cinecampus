package examencinecampus.validations;

import java.util.Scanner;

public class InputValidation {
    private Scanner scanner;

    public InputValidation() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt(String message){
        int value;
        while (true) {
            System.out.println(message);
            try {
                value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor correcto");
            }
        }
    }

    public String stringNotNull(String message){
        
        String value;
        while (true) {
            System.out.println(message);
            value = scanner.nextLine();
            if (value.isBlank()) {
                System.out.println("Dato invalido, vuelva a intentar");
            } else {
                break; 
            }
        }
        return value;
    }
}
