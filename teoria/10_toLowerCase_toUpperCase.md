# 10 - toLowerCase() e toUpperCase()

Esses metodos sao usados para transformar letras de uma `String` em minusculas ou maiusculas.
Eles nao alteram a string original, porque `String` em Java e imutavel: o resultado sempre vem como uma nova `String`.

## `toLowerCase()`

Converte os caracteres alfabeticos para minusculas.

Exemplo:

```java
String texto = "ADMIN";
String normalizado = texto.toLowerCase();
// normalizado -> "admin"
```

## `toUpperCase()`

Converte os caracteres alfabeticos para maiusculas.

Exemplo:

```java
String texto = "java";
String destaque = texto.toUpperCase();
// destaque -> "JAVA"
```

## Como funciona na memoria?

Como `String` e imutavel, chamadas como `nome.toLowerCase()` ou `nome.toUpperCase()` nao mudam o conteudo da variavel original.

```java
String original = "Rafael";
String minusculo = original.toLowerCase();

// original continua "Rafael"
// minusculo e "rafael"
```

Se voce quiser guardar a versao transformada, precisa atribuir o retorno a uma variavel:

```java
email = email.toLowerCase();
```

## Uso real em producao

Esses metodos aparecem muito em normalizacao de dados:

- Comparar usuarios sem diferenciar maiusculas/minusculas.
- Padronizar e-mails antes de salvar.
- Criar codigos, slugs ou chaves normalizadas.
- Preparar textos para busca.
- Exibir siglas ou codigos em caixa alta.

## Atencao com idioma

As versoes sem parametro usam o locale padrao da JVM:

```java
texto.toLowerCase();
texto.toUpperCase();
```

Em sistemas de producao, quando a regra precisa ser estavel e independente do idioma da maquina, e comum usar:

```java
texto.toLowerCase(Locale.ROOT);
texto.toUpperCase(Locale.ROOT);
```

Isso evita comportamentos especiais de alguns idiomas, como o turco, onde a letra `i` tem regras proprias de maiuscula/minuscula.

Para nossos exercicios, vamos praticar primeiro a ideia central usando `toLowerCase()` e `toUpperCase()`.

## Exemplo pratico diferente dos exercicios

```java
String nivel = "warning";

String exibicao = "[" + nivel.toUpperCase() + "]";

System.out.println(exibicao);
// [WARNING]
```
