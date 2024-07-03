package examencinecampus;

import examencinecampus.actor.adapters.in.ActorConsoleAdapter;
import examencinecampus.actor.adapters.out.ActorMYSQLRepository;
import examencinecampus.actor.application.ActorService;
import examencinecampus.formato.adapters.in.FormatoConsoleAdapter;
import examencinecampus.formato.adapters.out.FormatoMYSQLRepository;
import examencinecampus.formato.application.FormatoService;
import examencinecampus.genero.adapters.in.GeneroConsoleAdapter;
import examencinecampus.genero.adapters.out.GeneroMYSQLRepository;
import examencinecampus.genero.application.GeneroService;
import examencinecampus.validations.InputValidation;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String url = "jdbc:mysql://localhost:3306/cinecampus";
        String user = "campus2023";
        String password = "campus2023";
        InputValidation inputValidation = new InputValidation();


        ActorMYSQLRepository actorMYSQLRepository = new ActorMYSQLRepository(url, user, password);
        ActorService actorService = new ActorService(actorMYSQLRepository);
        ActorConsoleAdapter actorConsoleAdapter = new ActorConsoleAdapter(actorService);
        
        FormatoMYSQLRepository formatoMYSQLRepository = new FormatoMYSQLRepository(url, user, password);
        FormatoService formatoService = new FormatoService(formatoMYSQLRepository);
        FormatoConsoleAdapter formatoConsoleAdapter = new FormatoConsoleAdapter(formatoService);

        GeneroMYSQLRepository generoMYSQLRepository = new GeneroMYSQLRepository(password, url, user);
        GeneroService generoService = new GeneroService(generoMYSQLRepository);
        GeneroConsoleAdapter generoConsoleAdapter = new GeneroConsoleAdapter(generoService);


        System.out.println("*** Menu principal ***\n");
        System.out.println("1.Modulo de actor \2.Modulo de peliculas \n3. Modulo de formato");

        int choice = inputValidation.readInt("Ingrese el numero de la opcion deseada");

        switch (choice) {
            case 1:
                actorConsoleAdapter.menuActor();
                break;
            case 2:
                break;
            case 3:
                formatoConsoleAdapter.menuFormato();
            default:
                throw new AssertionError();
        }
        
    }
}