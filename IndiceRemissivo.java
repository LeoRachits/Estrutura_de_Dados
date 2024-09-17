import java.io.*;
import java.util.*;

public class IndiceRemissivo {
    public static void main(String[] args) {
        // Definimos os nomes dos arquivos de entrada: o texto e as palavras-chave
        String arquivoTexto = "texto.txt";
        String arquivoPalavrasChave = "palavrasChave.txt";

        // Aqui criamos dois HashMaps:
        // - 'indicePalavras' usa uma Tabela de Dispersão (HashMap) para armazenar todas as palavras do texto e suas linhas
        // - 'indiceRemissivoFinal' usa outra Tabela de Dispersão (HashMap) para armazenar as palavras-chave e as linhas onde elas aparecem
        Map<String, LinkedList<Integer>> indicePalavras = new HashMap<>();
        Map<String, LinkedList<Integer>> indiceRemissivoFinal = new HashMap<>();

        try {
            // Código responsavel por ler o arquivo de texto e registrar onde cada palavra aparece
            BufferedReader brTexto = new BufferedReader(new FileReader(arquivoTexto));
            String linhaTexto;
            int numeroLinha = 1; // Contador para saber a linha atual

            // Criar laço de repetição para ler o texto linha por linha
            while ((linhaTexto = brTexto.readLine()) != null) {
                // Dividimos a linha em palavras, usando espaços e pontuações como separadores
                String[] palavras = linhaTexto.split("[\\s,.;!?]+");

                // Código para aplicar ação para cada palavra na linha
                for (String palavra : palavras) {
                    String palavraLower = palavra.toLowerCase(); // onvertendo para minúsculas para não distinguir maiúsculas e minúsculas
                    // Usamos o HashMap 'indicePalavras' para mapear cada palavra para uma lista de números de linha
                    // 'putIfAbsent' garante que, se a palavra não existir, criamos uma nova LinkedList para ela
                    indicePalavras.putIfAbsent(palavraLower, new LinkedList<>());
                    // Adicionamos o número da linha na lista de ocorrências dessa palavra
                    indicePalavras.get(palavraLower).add(numeroLinha);
                }
                numeroLinha++; // Passamos para a próxima linha
            }
            brTexto.close(); // Fechamos o leitor do arquivo de texto

            // Nesse trecho vamos ler as palavras-chave e montar o índice remissivo final
            BufferedReader brPalavrasChave = new BufferedReader(new FileReader(arquivoPalavrasChave));
            String linhaPalavraChave;

            // Vamos ler o arquivo de palavras-chave linha por linha
            while ((linhaPalavraChave = brPalavrasChave.readLine()) != null) {
                // Dividimos as palavras-chave, que são separadas por vírgulas
                String[] palavrasChave = linhaPalavraChave.toLowerCase().split(",\\s*");

                // Código para aplicar ação para palavra-chave
                for (String palavra : palavrasChave) {
                    String palavraTrimmed = palavra.trim(); // Remove espaços extras
                    // Verificamos se a palavra-chave está no HashMap 'indicePalavras'
                    // Se a palavra estiver no texto, copiamos a lista de linhas para o índice remissivo final
                    if (indicePalavras.containsKey(palavraTrimmed)) {
                        indiceRemissivoFinal.put(palavraTrimmed, indicePalavras.get(palavraTrimmed));
                    } else {
                        // Se a palavra-chave não foi encontrada no texto, adicionamos com uma lista vazia
                        indiceRemissivoFinal.put(palavraTrimmed, new LinkedList<>());
                    }
                }
            }
            brPalavrasChave.close(); // Fechamos o leitor do arquivo de palavras-chave

            // Aqui vamos escrever o índice remissivo no arquivo de saída
            BufferedWriter bw = new BufferedWriter(new FileWriter("resposta.txt"));

            // Código para aplicar ação para cada entrada no índice remissivo final
            for (Map.Entry<String, LinkedList<Integer>> entry : indiceRemissivoFinal.entrySet()) {
                bw.write(entry.getKey()); // Escrevemos a palavra-chave
                // Em seguida, escrevemos todos os números das linhas onde a palavra-chave aparece
                for (Integer linha : entry.getValue()) {
                    bw.write(" " + linha);
                }
                bw.newLine(); // Pular para a próxima linha no arquivo de resposta
            }
            bw.close(); // Fechamos o escritor do arquivo

            System.out.println("Índice remissivo criado com sucesso em 'resposta.txt'.");

        } catch (IOException e) {
            e.printStackTrace(); // Se algo der errado com a leitura ou escrita, mostramos o erro
        }
    }
}