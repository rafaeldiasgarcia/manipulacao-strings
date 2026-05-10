# 01 - StringBuilder: criacao e conversao

Neste primeiro grupo, vamos estudar as formas basicas de criar um `StringBuilder`
e como converter o resultado final de volta para `String`.

Os pontos principais sao:

- `new StringBuilder()`
- `new StringBuilder(int capacity)`
- `new StringBuilder(String texto)`
- `toString()`

## O que e StringBuilder?

`StringBuilder` e uma classe mutavel usada para construir texto aos poucos.

Enquanto `String` representa um texto pronto e imutavel, `StringBuilder`
representa uma area de montagem que pode crescer, receber novos trechos,
remover partes e alterar caracteres.

```java
StringBuilder builder = new StringBuilder();
```

Esse codigo cria um builder vazio.

## Criando um StringBuilder vazio

```java
StringBuilder builder = new StringBuilder();
```

Essa forma e usada quando voce ainda nao tem nenhum texto inicial.
O conteudo comeca vazio, mas o builder ja tem uma capacidade interna inicial.

```java
StringBuilder builder = new StringBuilder();

System.out.println(builder.toString());
// ""
```

## Criando com capacidade inicial

```java
StringBuilder builder = new StringBuilder(100);
```

Essa forma cria um builder vazio, mas com espaco interno preparado para receber
aproximadamente 100 caracteres antes de precisar crescer.

Importante: capacidade nao e a mesma coisa que tamanho.

```java
StringBuilder builder = new StringBuilder(100);

System.out.println(builder.length());
// 0
```

O builder esta vazio. Ele apenas foi criado com uma area interna maior.

Isso pode ser util quando voce ja tem uma boa estimativa do tamanho final do
texto, como ao montar relatorios, linhas grandes, logs ou exportacoes.

## Criando com texto inicial

```java
StringBuilder builder = new StringBuilder("Java");
```

Essa forma cria um builder que ja comeca contendo o texto informado.

```java
StringBuilder builder = new StringBuilder("Java");

System.out.println(builder.toString());
// "Java"
```

A partir dai, o builder pode continuar sendo modificado.

## Convertendo para String com toString()

`StringBuilder` nao e uma `String`.

Quando voce termina de montar o texto e precisa devolver, imprimir, salvar ou
passar para um metodo que espera `String`, use:

```java
String resultado = builder.toString();
```

Esse metodo cria uma `String` com o conteudo atual do builder.

## Como funciona na memoria?

Uma `String` e imutavel. Depois de criada, seu conteudo nao muda.

Um `StringBuilder`, por outro lado, mantem internamente uma area de caracteres
que pode ser reaproveitada. Quando o texto cresce, ele tenta usar essa area.
Se a area nao for suficiente, a capacidade interna aumenta.

Por isso, `StringBuilder` e uma boa ferramenta quando o texto nasce em etapas.

## Uso real em producao

Voce vai ver `StringBuilder` em situacoes como:

- Montagem de logs com varias partes.
- Geracao de relatorios em texto.
- Criacao de mensagens com trechos opcionais.
- Montagem de CSV simples.
- Criacao de HTML simples.
- Montagem de comandos, filtros ou textos longos com cuidado.

## Exemplo pratico

```java
public static String criarIdentificador(String prefixo, int numero) {
    StringBuilder builder = new StringBuilder(prefixo);

    builder.append("-");
    builder.append(numero);

    return builder.toString();
}
```

Nesse exemplo, o builder comeca com um texto inicial, recebe mais partes e no
final e convertido para `String`.

## Resumo mental

Use `new StringBuilder()` quando comecar vazio.
Use `new StringBuilder(capacity)` quando souber uma estimativa de tamanho.
Use `new StringBuilder(texto)` quando ja houver texto inicial.
Use `toString()` quando terminar e precisar de uma `String`.
