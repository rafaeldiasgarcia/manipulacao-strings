# 02 - StringBuilder: append()

`append()` e o metodo usado para adicionar conteudo ao final de um
`StringBuilder`.

Ele e provavelmente o metodo mais comum da classe.

```java
StringBuilder builder = new StringBuilder();

builder.append("Java");
builder.append(" ");
builder.append("21");

String resultado = builder.toString();
// "Java 21"
```

## Ideia principal

`append()` sempre acrescenta o novo conteudo no final do texto que ja existe no
builder.

```java
StringBuilder builder = new StringBuilder("Ola");

builder.append(", ");
builder.append("Rafael");

System.out.println(builder.toString());
// "Ola, Rafael"
```

O proprio builder e alterado.

## append() muda o objeto atual

Em `String`, uma concatenacao cria outro texto:

```java
String texto = "A";
texto = texto + "B";
```

Em `StringBuilder`, o mesmo objeto recebe mais conteudo:

```java
StringBuilder builder = new StringBuilder("A");
builder.append("B");
```

Isso e util quando o texto cresce em etapas.

## append() aceita varios tipos

Voce pode adicionar `String`, `char`, `int`, `double`, `boolean` e outros tipos.

```java
StringBuilder builder = new StringBuilder();

builder.append("Idade: ");
builder.append(30);
builder.append(" | Ativo: ");
builder.append(true);

String resultado = builder.toString();
// "Idade: 30 | Ativo: true"
```

Por baixo, esses valores sao convertidos para texto.

## Encadeamento

Como `append()` retorna o proprio `StringBuilder`, voce pode encadear chamadas:

```java
String resultado = new StringBuilder()
        .append("A")
        .append("B")
        .append("C")
        .toString();
// "ABC"
```

Isso e comum, mas nem sempre e a forma mais legivel para iniciantes.
No comeco, separar em linhas ajuda a enxergar cada passo.

## append(null)

Um detalhe importante: `append((String) null)` nao quebra o programa.
Ele adiciona o texto `"null"`.

```java
StringBuilder builder = new StringBuilder();

builder.append((String) null);

System.out.println(builder.toString());
// "null"
```

Em codigo real, normalmente validamos `null` antes quando esse resultado nao e
desejado.

## Como funciona na memoria?

O `StringBuilder` mantem uma area interna de caracteres.
Cada `append()` tenta colocar o novo conteudo no final dessa area.

Se houver espaco, ele apenas adiciona.
Se nao houver, o builder aumenta sua capacidade interna e continua.

Por isso, ele costuma ser melhor do que concatenar muitas `String` dentro de
loops.

## Uso real em producao

`append()` aparece muito em:

- Montagem de logs.
- Mensagens com partes opcionais.
- Relatorios em texto.
- Linhas CSV simples.
- Geracao de arquivos texto.
- Montagem de HTML simples.
- Criacao de mensagens de erro detalhadas.

## Exemplo pratico

```java
public static String montarResumo(String produto, int quantidade, double total) {
    StringBuilder builder = new StringBuilder();

    builder.append("Produto: ").append(produto);
    builder.append(" | Quantidade: ").append(quantidade);
    builder.append(" | Total: R$ ").append(total);

    return builder.toString();
}
```

## Resumo mental

`append()` adiciona no final.
Ele altera o proprio `StringBuilder`.
Quando terminar, use `toString()`.
