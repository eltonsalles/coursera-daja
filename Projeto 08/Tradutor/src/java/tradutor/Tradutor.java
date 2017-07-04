package tradutor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Elton
 */
public class Tradutor {
    private String palavra;

    public Tradutor(String palavra) {
        this.palavra = palavra;
    }
    
    public String traduzirPalavra() {
        String result = this.palavra;
        
        try {
            // Arquivo que contém os pares de palavra
            FileReader arquivo = new FileReader("C:\\sandbox\\javadev\\ITA\\coursera-daja\\Projeto 08\\Tradutor\\src\\java\\resource\\palavras.txt");
            
            // Abre o arquivo
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            
            // Lê a primeira linha
            String linha = lerArquivo.readLine();
            
            // Percorre todas as linhas do arquivo
            while (linha != null) {
                // Monta um vetor com a palavra em português e inglês
                String[] palavras = linha.split("=");
                
                // Verifica se a palavra informada está no arquivo e
                // pega a sua tradução e encerra o loop
                if (palavras[0].equalsIgnoreCase(palavra)) {
                    result = palavras[1];
                    break;
                } else if (palavras[1].equalsIgnoreCase(palavra)) {
                    result = palavras[0];
                    break;
                }
                
                // Próxima linha
                linha = lerArquivo.readLine();
            }
            
            // Fecha o arquivo
            arquivo.close();
            
            // Retorna a palavra encontrada ou a mesma palavra informada
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.err);
            return result;
        }
    }
}
