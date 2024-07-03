package examencinecampus.actor.adapters.in;

import java.util.ArrayList;
import java.util.List;

import examencinecampus.actor.application.ActorService;
import examencinecampus.actor.domain.models.Actor;
import examencinecampus.validations.InputValidation;
import examencinecampus.validations.Register;
import examencinecampus.validations.ValidationExist;

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
                    Actor newActor = infoActor();
                    actorService.createActor(newActor);
                    System.out.println("Actor guardado exitosamente");
                    break;
                case 2:
                    System.out.println("Editar");
                    Actor actorUpdate = returnActor();
                    actorUpdate = updateInfo(actorUpdate);
                    actorService.updateActor(actorUpdate);
                    System.out.println("Actor actualizado");
                break;
                case 3:
                    System.out.println("Eliminar");
                    Actor actordelete = returnActor();
                    actorService.deleteActor(actordelete.getId());
                    System.out.println("Actor eliminado");
                break;
                case 4:
                    System.out.println("Lista de actores");
                    showActores();
                break;
                case 0:
                break;
                default:
                    System.out.println("Escoja una de las opciones mostradas");
            }
        }
    }

    public void showActores(){
        List<Actor> actores = new ArrayList<>();
        actores = actorService.findAllActor();
        for (Actor actor : actores) {
            System.out.println(String.format("id: %s , nombre: %s", actor.getId(), actor.getNombre()));
        }
    }


    public Actor updateInfo(Actor actor){
        boolean newInput;
        InputValidation inputValidation = new InputValidation();
        newInput = Register.newRegister("Desea cambiar el nombre? Ingrese 1 para si, 2 para no");
        if(newInput){
            String name = inputValidation.stringNotNull("Ingrese el nuevo nombre");
            actor.setNombre(name);
        }
        newInput = Register.newRegister("Desea cambiar la nacionalidad?  Ingrese 1 para si, 2 para no");
        if (newInput) {
            int idnacionalidad = inputValidation.readInt("Ingrese el id de la nacionalidad");
            actor.setIdNacionalidad(idnacionalidad);
        }
        newInput = Register.newRegister("Desea cambiar la edad?  Ingrese 1 para si, 2 para no");
        if (newInput) {
            int edad = inputValidation.readInt("Ingrese la edad");
            actor.setEdad(edad);
        }
        newInput = Register.newRegister("Desea cambiar el genero?  Ingrese 1 para si, 2 para no");
        if (newInput) {
            int idgenero = inputValidation.readInt("Ingrese la id del genero");
            actor.setIdGenero(idgenero);
        }
        return actor;
    }

    public Actor returnActor(){
        InputValidation inputValidation = new InputValidation();
        Actor actor = ValidationExist.optionalExist(
            () -> actorService.findById(inputValidation.readInt("Ingrese la id del actor")));
        return actor;
    }


    public Actor infoActor(){
        InputValidation inputValidation = new InputValidation();
        System.out.println("Ingrese la informacion del nuevo actor");
        String nombre = inputValidation.stringNotNull("Ingrese el nombre del actor\n");
        //Mostrar paises primero
        int idnacionalidad = inputValidation.readInt("Ingrese el id de la nacionalidad");
        int edad = inputValidation.readInt("ingrese la edad");
        //Mostrar lista de generos luego
        int idgenero = inputValidation.readInt("Ingrese el id del genero");
        Actor newActor = new Actor(nombre, idnacionalidad, edad, idgenero);
        
        return  newActor;
    }
}
