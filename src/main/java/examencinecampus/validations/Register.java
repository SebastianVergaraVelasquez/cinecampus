package examencinecampus.validations;

public class Register {

    public static boolean newRegister(String message){

    boolean value;
    int choice;
    InputValidation inputValidation = new InputValidation();
    while (true) {
        choice = inputValidation.readInt(message);
        switch (choice) {
            case 1:
                value = true;
                return value;
            case 2:
                value = false;
                return value;
            default:
                System.out.println("Ingrese una de las dos opciones unicamente");
                break;
        }
    }
}
}
