# 03 - StringBuilder: length() e isEmpty()

`length()` e `isEmpty()` sao metodos de inspecao basica do `StringBuilder`.
Eles ajudam a responder duas perguntas simples:

- existe algum conteudo?
- quantos caracteres existem no conteudo atual?

## length()

`length()` retorna quantos caracteres existem dentro do builder.

```java
StringBuilder builder = new StringBuilder("Java");

int tamanho = builder.length();
// 4
```

Esse tamanho considera todos os caracteres, inclusive espacos.

```java
StringBuilder builder = new StringBuilder(" ");

builder.length();
// 1
```

## length() nao e capacity()

`length()` mede o conteudo atual.
`capacity()` mede o espaco interno disponivel antes de o builder precisar
crescer.

```java
StringBuilder builder = new StringBuilder();

builder.length();
// 0

builder.capacity();
// 16
```

O builder esta vazio, mesmo tendo capacidade interna.

## isEmpty()

`isEmpty()` retorna `true` quando `length()` e igual a zero.

```java
StringBuilder builder = new StringBuilder();

builder.isEmpty();
// true
```

Um builder com espaco nao esta vazio:

```java
StringBuilder builder = new StringBuilder(" ");

builder.isEmpty();
// false
```

## Como usar em codigo real

Esses metodos aparecem quando voce precisa decidir se ja existe conteudo antes
de adicionar outro trecho.

Exemplo comum: adicionar separador somente se o builder ja tiver texto.

```java
StringBuilder builder = new StringBuilder();

if (!builder.isEmpty()) {
    builder.append(", ");
}

builder.append("Java");
```

Tambem aparecem quando voce precisa validar se algo foi montado:

```java
if (builder.length() == 0) {
    return "sem conteudo";
}
```

## Exemplo pratico

```java
public static String descrever(String texto) {
    String textoNormalizado = texto == null ? "" : texto;
    StringBuilder builder = new StringBuilder(textoNormalizado);

    if (builder.isEmpty()) {
        return "vazio";
    }

    return "tamanho: " + builder.length();
}
```

## Resumo mental

Use `isEmpty()` para perguntar se nao ha conteudo.
Use `length()` para saber quantos caracteres existem.
Espaco conta como caractere.
Capacidade interna nao significa conteudo.
