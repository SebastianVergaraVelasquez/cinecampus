package examencinecampus.pais.adapters.in;

import examencinecampus.pais.application.PaisService;
import examencinecampus.validations.InputValidation;

public class PaisConsoleAdapter {
    private final PaisService paisService;

    public PaisConsoleAdapter(PaisService paisService) {
        this.paisService = paisService;
    }

    public void menuPais(){
        InputValidation inputValidation = new InputValidation();
        boolean executing = true;
        
        while(executing){
            System.out.println("*** Modulo de pais ***\n");
            System.out.println("1.Registrar pais \n2.Actualizar información \3.Eliminar pais \n4.Ver todos los paises \n0.Salir");
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
