package examencinecampus.formato.adapters.in;

import examencinecampus.formato.application.FormatoService;
import examencinecampus.validations.InputValidation;

public class FormatoConsoleAdapter {
    private final FormatoService formatoService;

    public FormatoConsoleAdapter(FormatoService formatoService) {
        this.formatoService = formatoService;
    }

    public void menuFormato(){
        InputValidation inputValidation = new InputValidation();
        boolean executing = true;
        
        while(executing){
            System.out.println("*** Modulo de formato ***\n");
            System.out.println("1.Registrar formato \n2.Actualizar información \3.Eliminar formato \n4.Ver todos los formato \n0.Salir");
            int choice = inputValidation.readInt("Escoja el numero de una de las opciones listadas");
            switch (choice) {
                case 1 :
                    
                    break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 0:
                break;
                default:
                    System.out.println("Escoja una de las opciones mostradas");
            }
        }
    }
}
