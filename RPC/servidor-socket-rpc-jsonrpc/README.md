# Servidor Socker RPC com JsonRPC

## Procedimentos

1. Baskara
    - Definição: Realizar o calculo das raízes utilizando a formula de Báskara, verificando se existe raiz, se existe apenas uma(x) ou duas (x1,x2).
    - Entrada: [a,b,c]
    - Saídas: [] || [x] || [x1, x2]


1. Palavras
    - Definição: Realizar a estatística de um texto enviado, retornando as informações quantidade de palavras, quantidade de vogais (sem acento), quantidade de vogais acentuadas, quantidade de consoantes, quantidade de espaços, quantidade de palavras pares, quantidade de palavras impares e quantidade de linhas. 
    - Entrada: [texto]
    - Saída: [qtdLetras, qtdPalavras, qtdVogal, qtdVogalAcentuada, qtdConsoantes, qtdEspacos, qtdPalavrasPar, qtdPalavrasImpar, qtdDeLinhas]

1. PI
    - Definição: Realizar o calculo do valor de PI com precisão informada. Ex: qtdCasas = 5, deve retornar 3.14159.
    - Entrada: [qtdCasas]
    - Saída: [piComQtdCasasInformada]

## Scripts Maven

* `mvn install`: Instalação das dependências.
* `mvn compile`: Para compilar o projeto.
* `mvn package`: Para empacotar e gerar o .jar
* `mvn test`: Para executar os testes.
* `mvn clean`: Para apagar os arquivos compilados.

*Obs: Utilize _-DskipTests_ para pular os testes. 