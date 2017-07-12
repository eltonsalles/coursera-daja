package comparador;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Elton
 */
@Retention(RetentionPolicy.RUNTIME) // Habilita para que a anotação seja encontrada em tempo de execução
@Target(ElementType.METHOD) // Diz que essa anotação só pode ser usada em um método
public @interface IgnorarNaComparacao {
    
}
