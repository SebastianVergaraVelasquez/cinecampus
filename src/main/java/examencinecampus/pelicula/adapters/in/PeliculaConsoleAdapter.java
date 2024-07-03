package examencinecampus.pelicula.adapters.in;

import examencinecampus.pelicula.application.PeliculaService;
import examencinecampus.validations.InputValidation;

public class PeliculaConsoleAdapter {
    
    private final PeliculaService peliculaService;

    public PeliculaConsoleAdapter(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    public void menuPelicula(){
        InputValidation inputValidation = new InputValidation();
        boolean executing = true;
        
        while(executing){
            System.out.println("*** Modulo de pelicula ***\n");
            System.out.println("1.Registrar pelicula \n2.Actualizar información \3.Eliminar pelicula \n4.Ver todas las peliculas \n0.Salir");
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
