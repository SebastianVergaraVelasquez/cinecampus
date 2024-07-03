package examencinecampus.validations;

import java.util.Optional;
import java.util.function.Supplier;

public class ValidationExist {
    
        public static <T> T optionalExist(Supplier<Optional<T>> supplier){
            T objetoSeleccionado = null;
            while (true) {
                Optional<T> objetoOpcional = supplier.get();
                if (objetoOpcional.isPresent()) {
                    System.out.println();
                    return objetoSeleccionado = objetoOpcional.get();
                }
                else{System.out.println("Id no encontrado");}
            }
        }
}
