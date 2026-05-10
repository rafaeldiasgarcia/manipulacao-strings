# 04 - StringBuilder: charAt()

`charAt()` retorna o caractere que esta em uma posicao especifica do
`StringBuilder`.

O indice comeca em zero.

```java
StringBuilder builder = new StringBuilder("Java");

char primeiraLetra = builder.charAt(0);
// 'J'
```

## Indices

Para o texto `"Java"`:

```text
J a v a
0 1 2 3
```

Entao:

```java
builder.charAt(0); // 'J'
builder.charAt(1); // 'a'
builder.charAt(2); // 'v'
builder.charAt(3); // 'a'
```

## Indice invalido

Se o indice for menor que zero ou maior/igual ao tamanho do builder, o Java
lanca `StringIndexOutOfBoundsException`.

```java
StringBuilder builder = new StringBuilder("Java");

builder.charAt(4); // erro
```

O ultimo indice valido e sempre:

```java
builder.length() - 1
```

## Validando antes de acessar

Em codigo real, se o indice vier de fora, valide antes:

```java
if (indice < 0 || indice >= builder.length()) {
    return '?';
}

return builder.charAt(indice);
```

## StringBuilder vs String

`String` tambem tem `charAt()`.
A diferenca aqui e que estamos consultando o conteudo atual do builder, que
pode ter sido montado ou alterado antes.

```java
StringBuilder builder = new StringBuilder();
builder.append("J");
builder.append("ava");

char primeira = builder.charAt(0);
// 'J'
```

## Uso real em producao

`charAt()` aparece quando voce precisa:

- validar o primeiro caractere;
- olhar o ultimo caractere antes de adicionar algo;
- percorrer texto caractere por caractere;
- identificar separadores;
- fazer validacoes simples em textos montados dinamicamente.

## Exemplo pratico

```java
public static boolean terminaComPonto(String texto) {
    StringBuilder builder = new StringBuilder(texto == null ? "" : texto);

    if (builder.isEmpty()) {
        return false;
    }

    return builder.charAt(builder.length() - 1) == '.';
}
```

## Resumo mental

Use `charAt(indice)` para pegar um caractere.
O primeiro indice e 0.
O ultimo indice e `length() - 1`.
Valide o indice quando ele puder ser invalido.
