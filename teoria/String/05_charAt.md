# String.charAt(int index)

## O que é

Retorna o caractere (primitivo `char`) que está em uma posição específica da String. Em Java, as Strings são indexadas começando do zero (0). 

É um método de acesso direto e extremamente rápido (operação O(1)), pois apenas lê a posição diretamente do array interno que compõe a String na memória.

## Como funciona na memória

As Strings em Java guardam um array interno (`byte[]` no Java 9+ ou `char[]` nas versões antigas). O `charAt` apenas acessa o índice desse array.

```
"Java"
 ┌───┬───┬───┬───┐
 │ J │ a │ v │ a │
 └───┴───┴───┴───┘
   0   1   2   3

"Java".charAt(0)  → 'J'
"Java".charAt(2)  → 'v'
```

> **Atenção (IndexOutOfBoundsException):** Se você tentar acessar um índice negativo ou maior/igual ao tamanho da String (`length()`), o Java estourará um erro `StringIndexOutOfBoundsException`.

## Uso real em produção

- **Validação de formato:** Checar se a primeira letra de um nome é maiúscula.
- **Processamento caractere a caractere:** Percorrer uma String em um laço de repetição (for) para contar quantas vogais ela tem.
- **Extração de gênero/flag:** Extrair o caractere 'M' ou 'F' de uma String que veio do banco de dados ("Masculino", "Feminino").

## Exemplo rápido

```java
String status = "Ativo";

// Pega a primeira letra
char primeiraLetra = status.charAt(0);

if (primeiraLetra == 'A') {
    System.out.println("Status começa com A!");
}
```
*(Nota: Lembre-se que `char` usa aspas simples `'A'`, enquanto `String` usa aspas duplas `"A"`).*

## Assinatura

```java
public char charAt(int index)
```
