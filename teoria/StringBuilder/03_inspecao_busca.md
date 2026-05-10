# 03 - StringBuilder: inspecao e busca

Depois de criar e montar texto com `append()`, precisamos saber como consultar o
conteudo de um `StringBuilder`.

Neste grupo, vamos estudar:

- `length()`
- `isEmpty()`
- `charAt()`
- `substring()`
- `indexOf()`
- `lastIndexOf()`

## length()

`length()` retorna quantos caracteres existem no conteudo atual do builder.

```java
StringBuilder builder = new StringBuilder("Java");

int tamanho = builder.length();
// 4
```

Importante: `length()` mede o conteudo, nao a capacidade interna.

## isEmpty()

`isEmpty()` retorna `true` quando o builder nao tem nenhum caractere.

```java
StringBuilder builder = new StringBuilder();

boolean vazio = builder.isEmpty();
// true
```

Um builder com espaco nao esta vazio:

```java
StringBuilder builder = new StringBuilder(" ");

builder.isEmpty();
// false
```

## charAt()

`charAt(indice)` retorna o caractere em uma posicao especifica.
O indice comeca em 0.

```java
StringBuilder builder = new StringBuilder("Java");

char letra = builder.charAt(0);
// 'J'
```

Se o indice for invalido, ocorre `StringIndexOutOfBoundsException`.
Em exercicios, vamos validar antes quando isso fizer sentido.

## substring()

`substring()` extrai uma parte do conteudo e devolve uma `String`.
Ela nao devolve um `StringBuilder`.

```java
StringBuilder builder = new StringBuilder("Java 21");

String parte = builder.substring(0, 4);
// "Java"
```

O indice inicial entra no resultado.
O indice final nao entra.

## indexOf()

`indexOf(texto)` procura a primeira ocorrencia de um texto dentro do builder.
Se encontrar, retorna o indice inicial. Se nao encontrar, retorna `-1`.

```java
StringBuilder builder = new StringBuilder("banana");

int indice = builder.indexOf("na");
// 2
```

## lastIndexOf()

`lastIndexOf(texto)` procura a ultima ocorrencia de um texto dentro do builder.

```java
StringBuilder builder = new StringBuilder("banana");

int indice = builder.lastIndexOf("na");
// 4
```

## StringBuilder ainda nao e String

Mesmo tendo metodos parecidos com `String`, `StringBuilder` nao possui todos os
metodos de `String`.

Ele tem boas ferramentas para inspecionar e buscar dentro do conteudo atual,
mas operacoes como `trim()`, `split()`, `toUpperCase()` e `contains()` continuam
sendo metodos de `String`.

## Uso real em producao

Esses metodos aparecem quando voce precisa:

- verificar se algo foi montado;
- decidir se adiciona separador;
- pegar um caractere especifico;
- extrair um trecho do texto montado;
- localizar marcadores dentro de uma mensagem;
- encontrar a primeira ou ultima ocorrencia de um termo.

## Exemplo pratico

```java
public static boolean temConteudoUtil(String texto) {
    StringBuilder builder = new StringBuilder(texto == null ? "" : texto);

    return !builder.isEmpty();
}
```

## Resumo mental

Use `length()` para tamanho.
Use `isEmpty()` para vazio.
Use `charAt()` para caractere por indice.
Use `substring()` para extrair uma parte como `String`.
Use `indexOf()` e `lastIndexOf()` para localizar texto.
