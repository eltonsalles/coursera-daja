package tiposgenericos;

/**
 *
 * @author Elton
 */
public class Fruta {

    protected String nome;

    public Fruta(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Fruta{" + "nome=" + nome + '}';
    }
}
