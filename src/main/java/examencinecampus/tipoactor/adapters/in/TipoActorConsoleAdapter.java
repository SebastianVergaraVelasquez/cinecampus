package examencinecampus.tipoactor.adapters.in;

import examencinecampus.tipoactor.application.TipoActorService;
import examencinecampus.validations.InputValidation;

public class TipoActorConsoleAdapter {
    private final TipoActorService tipoActorService;

    public TipoActorConsoleAdapter(TipoActorService tipoActorService) {
        this.tipoActorService = tipoActorService;
    }

    public void menuTipoActor(){
        InputValidation inputValidation = new InputValidation();
        boolean executing = true;
        
        while(executing){
            System.out.println("*** Modulo de tipo actor ***\n");
            System.out.println("1.Registrar tipo actor \n2.Actualizar información \3.Eliminar tipo actor \n4.Ver todos los tipos actores \n0.Salir");
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
