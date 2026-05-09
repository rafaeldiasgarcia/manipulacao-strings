# 12 - String.format()

`String.format()` e usado para montar uma `String` a partir de um modelo com marcadores.
Ele e muito util quando a mensagem tem uma estrutura fixa e alguns valores variaveis.

## Ideia principal

Em vez de concatenar varias partes:

```java
String texto = "Nome: " + nome + " | Idade: " + idade;
```

Podemos escrever:

```java
String texto = String.format("Nome: %s | Idade: %d", nome, idade);
```

O primeiro argumento e o modelo. Os proximos argumentos preenchem os marcadores.

## Marcadores mais comuns

```text
%s   texto ou objeto
%d   numero inteiro
%f   numero decimal
%.2f numero decimal com 2 casas
%n   quebra de linha independente do sistema operacional
%%   caractere de porcentagem literal
```

Exemplos:

```java
String.format("Usuario: %s", "Rafael");
String.format("Quantidade: %d", 10);
String.format("Preco: %.2f", 19.9);
String.format("Progresso: %.1f%%", 75.5);
```

## Ordem dos argumentos

Os argumentos precisam aparecer na mesma ordem dos marcadores:

```java
String resultado = String.format("%s tem %d anos", "Ana", 25);
// "Ana tem 25 anos"
```

Se a quantidade ou o tipo dos argumentos nao bater com os marcadores, o programa pode falhar em tempo de execucao.

## Formatacao de numeros

`String.format()` permite controlar casas decimais:

```java
String preco = String.format("%.2f", 12.5);
// "12,50" ou "12.50", dependendo do Locale padrao
```

Esse detalhe e importante: a saida de numeros decimais pode mudar conforme o idioma/regiao da JVM.
No Brasil, pode aparecer virgula decimal. Em ambiente americano, ponto decimal.

Para testes e sistemas que precisam de saida previsivel, use um `Locale` explicito:

```java
import java.util.Locale;

String preco = String.format(Locale.US, "%.2f", 12.5);
// "12.50"
```

Nos exercicios deste comando, vamos usar `Locale.US` quando houver numero decimal.

## Como funciona na memoria?

`String.format()` cria uma nova `String` pronta. A `String` original do modelo nao e alterada.
Por baixo, o Java usa um mecanismo de formatacao parecido com um `Formatter`.

Para poucas mensagens, logs e exibicoes, isso e perfeito.
Para loops gigantes ou montagem massiva de texto, mais pra frente vamos estudar `StringBuilder`.

## Uso real em producao

`String.format()` aparece em:

- Mensagens padronizadas para logs.
- Linhas de recibo, relatorio ou arquivo texto.
- Codigos com zeros a esquerda.
- Valores monetarios com casas decimais fixas.
- Percentuais e resumos de progresso.
- Textos multilinha com estrutura previsivel.

## Exemplo pratico diferente dos exercicios

```java
import java.util.Locale;

String host = "api.empresa.com";
int porta = 443;
double latencia = 18.456;

String log = String.format(
        Locale.US,
        "host=%s; porta=%d; latencia=%.2fms",
        host,
        porta,
        latencia
);

System.out.println(log);
// host=api.empresa.com; porta=443; latencia=18.46ms
```
