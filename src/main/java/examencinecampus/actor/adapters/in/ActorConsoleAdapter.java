package examencinecampus.actor.adapters.in;

import examencinecampus.actor.application.ActorService;
import examencinecampus.validations.InputValidation;

public class ActorConsoleAdapter {
    private final ActorService actorService;

    public ActorConsoleAdapter(ActorService actorService) {
        this.actorService = actorService;
    }

    public void menuActor(){
        InputValidation inputValidation = new InputValidation();
        boolean executing = true;
        
        while(executing){
            System.out.println("*** Modulo de actor ***\n");
            System.out.println("1.Registrar actor \n2.Actualizar información \3.Eliminar actor \n4.Ver todos los actores \n0.Salir");
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
