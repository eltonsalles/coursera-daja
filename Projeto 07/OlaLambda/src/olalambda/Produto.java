/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olalambda;

/**
 *
 * @author Elton
 */
public class Produto {
    private String nome;
    private int valor;

    public Produto(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valor=" + valor + '}';
    }
    
    // 10% de desconto
    public void darDesconto() {
        this.valor = valor * 90 / 100;
    }
    
    public boolean caro() {
        return this.valor > 200;
    }
}
