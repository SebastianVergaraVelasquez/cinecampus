package examencinecampus.pelicula.adapters.in;

import java.util.ArrayList;
import java.util.List;

import examencinecampus.pelicula.application.PeliculaService;
import examencinecampus.pelicula.domain.models.Pelicula;
import examencinecampus.validations.InputValidation;
import examencinecampus.validations.ValidationExist;

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
            System.out.println("1.Registrar pelicula \n2.Actualizar información \3.Eliminar pelicula \n4.Ver todas las peliculas");
            System.out.println("5.Agregar actores a pelicula \n6.Consultar pelicula \0.");
            int choice = inputValidation.readInt("Escoja el numero de una de las opciones listadas");
            switch (choice) {
                case 1 :
                        System.out.println("Registrar pelicula");
                        Pelicula pelicula = infoPelicula();
                        peliculaService.createPelicula(pelicula);
                        System.out.println("Pelicula guardada");
                    break;
                case 2:

                break;
                case 3:
                    Pelicula peliculadelete = returnPelicula();
                    peliculaService.deletePelicula(peliculadelete.getId());
                break;
                case 4:
                    System.out.println("Lista de peliculas");
                    showPeliculas();
                break;
                case 5:
                    
                    break;
                case 6:
                    break;
                case 0:
                break;
                default:
                    System.out.println("Escoja una de las opciones mostradas");
            }
        }
    }    
    
    public Pelicula infoPelicula(){
        InputValidation inputValidation = new InputValidation();
        System.out.println("Ingrese la informacion de la nueva pelicula");
        String codinterno = inputValidation.stringNotNull("Ingrese el codigo interno");
        String nombre = inputValidation.stringNotNull("Ingrese el nombre\n");
        //Mostrar paises primero
        String duracion = inputValidation.stringNotNull("INgrese la duracion");
        String sinopsis = inputValidation.stringNotNull("Ingrese la sinopsis");
                
        return new Pelicula(codinterno, nombre, duracion, sinopsis);

    }

    public Pelicula returnPelicula(){
        InputValidation inputValidation = new InputValidation();
        Pelicula pelicula = ValidationExist.optionalExist(
            () -> peliculaService.findById(inputValidation.readInt("Ingrese la id de la pelicula")));
        return pelicula;
    }

    public void showPeliculas(){
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas = peliculaService.findAllPelicula();
        for (Pelicula pelicula : peliculas) {
            System.out.println(String.format("id:%d , codinterno: %s, nombre: %s, duracion: %s, sinopsis:%s", pelicula.getId(),pelicula.getCodinterno(),pelicula.getNombre(), pelicula.getDuracion(), pelicula.getSinopsis()));
        }
    }
}
