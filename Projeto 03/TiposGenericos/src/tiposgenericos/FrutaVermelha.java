/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposgenericos;

/**
 *
 * @author Elton
 */
public class FrutaVermelha extends Fruta {
    
    public FrutaVermelha(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "FrutaVermelha{" + "nome=" + nome + '}';
    }
}
