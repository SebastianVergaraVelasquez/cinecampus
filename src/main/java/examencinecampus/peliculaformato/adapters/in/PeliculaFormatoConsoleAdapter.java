package examencinecampus.peliculaformato.adapters.in;

import examencinecampus.peliculaformato.application.PeliculaFormatoService;
import examencinecampus.validations.InputValidation;

public class PeliculaFormatoConsoleAdapter {
    private final PeliculaFormatoService peliculaFormatoService;

    public PeliculaFormatoConsoleAdapter(PeliculaFormatoService peliculaFormatoService) {
        this.peliculaFormatoService = peliculaFormatoService;
    }

    public void menuPeliculaFormato(){
        InputValidation inputValidation = new InputValidation();
        boolean executing = true;
        
        while(executing){
            System.out.println("*** Modulo de pelicula formato ***\n");
            System.out.println("1.Registrar pelicula formato \n2.Actualizar información \3.Eliminar pelicula formato \n4.Ver todos las peliculas con sus formatos \n0.Salir");
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
