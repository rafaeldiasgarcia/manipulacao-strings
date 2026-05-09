# 13 - String.join()

`String.join()` e usado para juntar varios textos usando um separador.
Ele e muito comum quando precisamos montar listas, caminhos, linhas CSV, tags, mensagens ou qualquer texto repetitivo separado por um delimitador.

## Ideia principal

Em vez de fazer concatenacoes manuais:

```java
String resultado = "java" + ", " + "spring" + ", " + "api";
```

Podemos escrever:

```java
String resultado = String.join(", ", "java", "spring", "api");
// "java, spring, api"
```

O primeiro argumento e o separador. Os proximos argumentos sao os textos que serao unidos.

## Assinaturas principais

```java
String.join(CharSequence delimiter, CharSequence... elements)
String.join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
```

Na pratica, voce pode usar com valores soltos:

```java
String.join("-", "2026", "05", "08");
// "2026-05-08"
```

Ou com uma lista:

```java
List<String> nomes = List.of("Ana", "Bruno", "Carla");
String.join(", ", nomes);
// "Ana, Bruno, Carla"
```

## Como funciona com lista vazia?

Quando a lista nao tem elementos, o retorno e uma string vazia:

```java
String.join(", ", List.of());
// ""
```

## Como funciona com null?

Existem dois pontos importantes:

1. Separador nulo gera `NullPointerException`.
2. Colecao/array nulo tambem gera `NullPointerException`.

Elementos nulos, por outro lado, podem aparecer como o texto `"null"` em algumas formas de uso:

```java
String.join(", ", "A", null, "C");
// "A, null, C"
```

Em codigo de producao, normalmente validamos entradas antes de chamar `String.join()`, especialmente listas que podem vir nulas.

## Como funciona na memoria?

`String.join()` cria uma nova `String` com todos os elementos e separadores.
A string original dos elementos nao e modificada, porque `String` continua sendo imutavel.

Para poucas listas ou mensagens comuns, `String.join()` deixa o codigo bem legivel.
Para montagem pesada em loops gigantes, vamos estudar `StringBuilder` depois.

## Uso real em producao

`String.join()` aparece em:

- Montagem de CSV simples.
- Lista de permissoes: `"ADMIN,USER,REPORT"`.
- Caminhos logicos: `"usuarios/123/perfil"`.
- Mensagens com itens selecionados.
- Tags e categorias.
- Chaves compostas simples.

## Exemplo pratico diferente dos exercicios

```java
List<String> permissoes = List.of("READ", "WRITE", "DELETE");

String cabecalho = String.join("|", permissoes);

System.out.println(cabecalho);
// READ|WRITE|DELETE
```
