# 01 - StringBuilder: mutabilidade, performance e quando usar

`StringBuilder` e uma classe do Java feita para construir e modificar texto de forma eficiente.
Ela e especialmente util quando o texto vai sendo montado aos poucos.

```java
StringBuilder sb = new StringBuilder();

sb.append("Java");
sb.append(" ");
sb.append("21");

String resultado = sb.toString();
// "Java 21"
```

## O ponto central: StringBuilder e mutavel

Diferente de `String`, um `StringBuilder` pode mudar internamente.
Quando chamamos `append()`, `insert()`, `delete()` ou `setCharAt()`, o proprio objeto e alterado.

```java
StringBuilder sb = new StringBuilder("Java");

sb.append(" 21");

System.out.println(sb);
// "Java 21"
```

Nao foi criada uma nova variavel de texto a cada passo.
O mesmo builder foi reaproveitado.

## Por que a mutabilidade ajuda?

Imagine montar um texto dentro de um loop:

```java
String resultado = "";

for (int i = 1; i <= 1000; i++) {
    resultado = resultado + i + "\n";
}
```

Como `String` e imutavel, cada concatenacao tende a criar novas strings intermediarias.
Isso pode pesar em memoria e tempo quando o volume cresce.

Com `StringBuilder`, o texto cresce dentro de uma estrutura mutavel:

```java
StringBuilder sb = new StringBuilder();

for (int i = 1; i <= 1000; i++) {
    sb.append(i).append("\n");
}

String resultado = sb.toString();
```

Esse padrao costuma ser melhor para montagem repetitiva.

## Como ele funciona por dentro?

Pense no `StringBuilder` como uma area de montagem de texto.
Ele guarda caracteres em uma estrutura interna que pode crescer conforme necessario.

Quando voce chama:

```java
sb.append("abc");
```

ele adiciona esses caracteres no final da area interna.

Quando chama:

```java
sb.insert(0, "Inicio: ");
```

ele desloca parte do conteudo e insere o novo texto.

Quando chama:

```java
sb.delete(0, 3);
```

ele remove um trecho do conteudo interno.

No final, quando o texto estiver pronto, voce chama:

```java
String finalizado = sb.toString();
```

Ai sim voce volta para uma `String` comum.

## StringBuilder vs String

Use `String` quando o texto representa um valor.
Use `StringBuilder` quando voce esta construindo um texto.

Exemplo com `String`:

```java
String email = "USER@EMAIL.COM".toLowerCase();
```

Exemplo com `StringBuilder`:

```java
StringBuilder log = new StringBuilder();

log.append("Inicio\n");
log.append("Processando usuario\n");
log.append("Fim\n");

String textoLog = log.toString();
```

## Quando usar StringBuilder?

Use `StringBuilder` quando:

- Voce esta concatenando dentro de loops.
- O texto tem muitas partes.
- Existem muitos `if` adicionando trechos opcionais.
- Voce precisa inserir texto no meio.
- Voce precisa remover trechos.
- Voce precisa alterar caracteres especificos.
- Voce esta montando relatorios, logs grandes, HTML simples, CSV, SQL dinamico com cuidado, ou arquivos texto.

## Quando nao precisa usar StringBuilder?

Nao precisa usar `StringBuilder` para casos simples:

```java
String nomeCompleto = primeiroNome + " " + sobrenome;
```

Ou:

```java
String mensagem = String.format("Usuario %s tem %d anos", nome, idade);
```

Para pequenas concatenacoes, o codigo com `String`, `String.format()` ou `String.join()` pode ser mais legivel.

## Cuidado com retorno

Muitos metodos de `StringBuilder` retornam o proprio builder, permitindo encadeamento:

```java
String texto = new StringBuilder()
        .append("A")
        .append("B")
        .append("C")
        .toString();
```

Isso e comum e idiomatico.
Mas lembre: o builder foi alterado a cada `append()`.

## StringBuilder nao e String

Mesmo que ele represente texto, `StringBuilder` nao e uma `String`.
Se um metodo espera `String`, voce precisa chamar `toString()`.

```java
StringBuilder sb = new StringBuilder("Java");

String texto = sb.toString();
```

## StringBuilder e thread-safe?

`StringBuilder` nao e thread-safe.
Isso significa que ele nao foi feito para ser compartilhado e alterado por varias threads ao mesmo tempo.

Na maioria dos casos comuns, ele e usado dentro de um unico metodo, por uma unica thread, e isso e perfeito.

Existe tambem `StringBuffer`, que e uma versao sincronizada e mais antiga.
Hoje, para codigo comum, usamos `StringBuilder`.

## Resumo mental

`String` e texto pronto e imutavel.
`StringBuilder` e uma oficina mutavel para montar texto.

Use `StringBuilder` quando o texto nasce aos poucos.
Quando terminar, converta com `toString()`.

