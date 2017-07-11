package comparador;

/**
 *
 * @author Elton
 */
public class Diferenca {
    private String propriedade;
    private Object valorNovo;
    private Object valorVelho;

    public Diferenca(String propriedade, Object valorNovo, Object valorVelho) {
        this.propriedade = propriedade;
        this.valorNovo = valorNovo;
        this.valorVelho = valorVelho;
    }

    @Override
    public String toString() {
        return "Diferenca{" + "propriedade=" + propriedade + ", valorNovo=" + valorNovo + ", valorVelho=" + valorVelho + '}';
    }
}
