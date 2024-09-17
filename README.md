# Índice Remissivo Automático
> *Projeto desenvolvido pela equipe 05 - ADS*

## Equipe
- *2326350 - Leandro Gonçalves Nascimento*
- *2326780 - Carlos Alexandre Almeida Fonseca*
- *2326252 - Alexya Cavalcante Pereira*
- *2326195 - Mycow Wyllyan Coelho Henrique*
- *2323783 - Sidney Jesus Felix de Freitas*
- *2326242 - Eric Vinicius Dias Aquino*

---

## 📋 Descrição do Projeto
Este projeto tem como objetivo criar um *índice remissivo automático* a partir de um texto e uma lista de palavras-chave fornecida. O programa analisa o texto, identifica as linhas onde cada palavra-chave aparece e gera um arquivo de saída contendo essas informações. 

## 📂 Arquivos Utilizados
- *texto.txt*: Arquivo de entrada contendo o texto a ser analisado.
- *palavrasChave.txt*: Arquivo de entrada contendo as palavras-chave, separadas por vírgulas.
- *resposta.txt*: Arquivo gerado pelo programa contendo o índice remissivo com as palavras-chave e as linhas onde foram encontradas.

---

## 🚀 Como Executar o Programa
### Pré-requisitos
- Java Development Kit (JDK) instalado no computador.
- Java 21.0 instalado no computador.
- Arquivos texto.txt e palavrasChave.txt presentes na pasta raiz do programa.

### Passo a Passo
1. *Compilar o Programa*
   - Abra o terminal (ou prompt de comando) e navegue até o diretório onde está o arquivo IndiceRemissivo.java.
   - Execute o comando abaixo para compilar o programa:
     
     ```bash
     javac IndiceRemissivo.java
     ```
     
   - Este comando gera o arquivo IndiceRemissivo.class.

2. *Executar o Programa*
   - Ainda no terminal, execute o comando abaixo para rodar o programa:
     ```bash
     java IndiceRemissivo
     ```
     
   - O programa vai ler os arquivos texto.txt e palavrasChave.txt e gerar o arquivo resposta.txt com o índice remissivo.

### 📝 Arquivo de Saída
- Após a execução, o arquivo resposta.txt será gerado automaticamente no mesmo diretório.