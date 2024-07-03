package examencinecampus.genero.adapters.in;

import examencinecampus.genero.application.GeneroService;
import examencinecampus.validations.InputValidation;

public class GeneroConsoleAdapter {
    private final GeneroService generoService;

    public GeneroConsoleAdapter(GeneroService generoService) {
        this.generoService = generoService;
    }

    public void menuGenero(){
        InputValidation inputValidation = new InputValidation();
        boolean executing = true;
        
        while(executing){
            System.out.println("*** Modulo de genero ***\n");
            System.out.println("1.Registrar genero \n2.Actualizar información \3.Eliminar genero \n4.Ver todos los genero \n0.Salir");
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
