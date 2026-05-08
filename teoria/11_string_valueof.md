# 11 - String.valueOf()

`String.valueOf()` e um metodo estatico usado para converter valores em `String`.
Ele aparece muito quando precisamos montar logs, mensagens, respostas de API, linhas de arquivo, telas ou qualquer texto que mistura dados de tipos diferentes.

## O que ele faz?

Ele recebe um valor e devolve uma representacao textual desse valor.

Exemplos:

```java
String idadeTexto = String.valueOf(30);
String ativoTexto = String.valueOf(true);
String precoTexto = String.valueOf(19.90);
```

Resultados:

```text
"30"
"true"
"19.9"
```

## Por que nao usar sempre concatenacao?

Quando fazemos:

```java
String texto = "" + idade;
```

O Java tambem converte o valor para texto, mas a intencao fica menos explicita.
Com `String.valueOf(idade)`, voce comunica claramente:

> "Quero transformar este valor em String."

Isso ajuda principalmente em metodos pequenos, validacoes, logs e testes.

## Sobrecargas principais

`String.valueOf()` tem varias versoes:

```java
String.valueOf(int valor)
String.valueOf(long valor)
String.valueOf(double valor)
String.valueOf(boolean valor)
String.valueOf(char valor)
String.valueOf(char[] valor)
String.valueOf(Object valor)
```

Cada sobrecarga converte um tipo especifico.

## Como funciona com null?

Quando usamos `String.valueOf()` com uma referencia de objeto nula, o retorno e a string literal `"null"`.

```java
Object valor = null;
String texto = String.valueOf(valor);
// texto -> "null"
```

Isso e diferente de chamar `valor.toString()`, que causaria `NullPointerException`.

```java
Object valor = null;
String texto = valor.toString(); // erro em tempo de execucao
```

Por isso `String.valueOf(objeto)` e uma forma segura de converter referencias em texto quando o valor pode ser nulo.

## Atencao com char[]

Com arrays de caracteres, `String.valueOf(char[])` cria uma String com os caracteres do array.

```java
char[] letras = {'J', 'a', 'v', 'a'};
String texto = String.valueOf(letras);
// texto -> "Java"
```

Isso e util para montar texto a partir de caracteres, mas nao deve ser usado para imprimir senhas ou dados sensiveis em logs.

## Uso real em producao

`String.valueOf()` e comum em:

- Montagem de logs e mensagens de auditoria.
- Conversao de IDs numericos para texto.
- Normalizacao de valores opcionais antes de exibir.
- Criacao de linhas CSV ou TXT.
- Preparacao de respostas simples para telas ou APIs.

## Exemplo pratico diferente dos exercicios

```java
int tentativas = 3;
boolean bloqueado = false;

String resumo = "tentativas=" + String.valueOf(tentativas)
        + "; bloqueado=" + String.valueOf(bloqueado);

System.out.println(resumo);
// tentativas=3; bloqueado=false
```
