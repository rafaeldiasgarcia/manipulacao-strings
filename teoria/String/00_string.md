# 00 - String: conceito, imutabilidade e quando usar

`String` e a classe principal do Java para representar texto.
Sempre que escrevemos algo entre aspas duplas, estamos criando uma `String`.

```java
String nome = "Rafael";
String linguagem = "Java";
```

Ela e usada em praticamente todo sistema: nomes, emails, senhas, mensagens, logs, caminhos, codigos, respostas de API, linhas de arquivo e textos exibidos em tela.

## O ponto central: String e imutavel

Uma `String` nao muda depois que e criada.
Quando chamamos um metodo como `toLowerCase()`, `replace()`, `strip()` ou `substring()`, o Java nao altera a `String` original.
Ele retorna outra `String`.

```java
String texto = " Java ";

texto.strip();

System.out.println(texto);
// " Java "
```

Para guardar o resultado, precisamos atribuir:

```java
String texto = " Java ";

texto = texto.strip();

System.out.println(texto);
// "Java"
```

Essa e uma das ideias mais importantes para dominar manipulacao de texto em Java.

## Por que String ser imutavel e bom?

Imutabilidade parece estranha no comeco, mas ela resolve problemas importantes.

### 1. Segurança

Textos sao usados em lugares sensiveis: usuario, senha, token, query, caminho de arquivo, URL, permissao.
Se uma `String` pudesse mudar por acidente depois de ser passada para outro metodo, seria muito mais facil criar bugs perigosos.

### 2. Previsibilidade

Quando voce passa uma `String` para um metodo, sabe que aquele metodo nao vai alterar o objeto original.

```java
String email = "USER@EMAIL.COM";
String normalizado = email.toLowerCase();

// email continua "USER@EMAIL.COM"
// normalizado e "user@email.com"
```

Isso deixa o raciocinio mais simples.

### 3. Reuso em memoria

O Java pode reaproveitar strings literais por meio do String Pool.

```java
String a = "java";
String b = "java";
```

Como strings literais sao imutaveis, o Java pode guardar uma unica copia de `"java"` e reutilizar essa referencia.
Se strings fossem mutaveis, esse reaproveitamento seria perigoso.

### 4. Uso seguro como chave

`String` e muito usada como chave em `Map`, valores em cache e identificadores.
Por ser imutavel, o valor nao muda depois de entrar nessas estruturas.

## O custo da imutabilidade

O lado ruim aparece quando fazemos muitas modificacoes sucessivas.

```java
String resultado = "";

resultado = resultado + "A";
resultado = resultado + "B";
resultado = resultado + "C";
```

Cada concatenacao pode gerar uma nova `String`.
Para poucos textos, isso nao e problema.
Mas em loops grandes ou montagem pesada de texto, isso pode gerar muitos objetos temporarios.

Exemplo ruim em processamento grande:

```java
String csv = "";

for (int i = 0; i < 10000; i++) {
    csv = csv + i + "\n";
}
```

Nesse tipo de caso, `StringBuilder` costuma ser melhor.

## Quando usar String?

Use `String` quando:

- O texto ja vem pronto.
- Voce precisa validar, comparar, buscar ou fatiar texto.
- A quantidade de transformacoes e pequena.
- A legibilidade importa mais que micro-otimizacao.
- Voce esta lidando com valores finais: email, nome, token, codigo, mensagem.
- Voce quer seguranca e previsibilidade.

Exemplos bons:

```java
String email = entrada.strip().toLowerCase();
boolean valido = email.contains("@");
String dominio = email.substring(email.indexOf("@") + 1);
```

## Quando evitar String pura?

Evite usar `String` com concatenacao repetida quando:

- Ha loop grande.
- Voce monta relatorios extensos.
- Voce gera arquivos grandes.
- Voce concatena muitos pedacos condicionais.
- Voce precisa inserir, remover ou alterar texto muitas vezes.

Nesses casos, prefira `StringBuilder`.

## Resumo mental

`String` e o texto pronto, seguro e imutavel.

Use `String` para representar texto.
Use os metodos de `String` para consultar, validar, comparar e transformar.
Quando a construcao do texto ficar muito dinamica ou repetitiva, pense em `StringBuilder`.

