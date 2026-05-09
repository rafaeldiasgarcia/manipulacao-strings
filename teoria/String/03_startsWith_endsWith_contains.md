# startsWith(), endsWith(), contains()

## startsWith(String prefix)

Retorna `true` se a String começar com o prefixo informado. Compara caractere a caractere do início — para assim que achar divergência ou confirmar o prefixo completo.

```
"https://api.empresa.com".startsWith("https://")  → true
"http://api.empresa.com".startsWith("https://")   → false
```

**Assinatura:**
```java
public boolean startsWith(String prefix)
public boolean startsWith(String prefix, int offset)  // inicia a busca a partir do offset
```

## endsWith(String suffix)

Retorna `true` se a String terminar com o sufixo informado. Compara de trás pra frente.

```
"relatorio.pdf".endsWith(".pdf")   → true
"relatorio.xlsx".endsWith(".pdf")  → false
```

**Assinatura:**
```java
public boolean endsWith(String suffix)
```

## contains(CharSequence s)

Retorna `true` se a String contiver a sequência informada em qualquer posição. Internamente usa um algoritmo de busca linear — O(n*m) no pior caso.

```
"Olá Mundo Java".contains("Mundo")  → true
"Olá Mundo Java".contains("mundo")  → false  ← case-sensitive!
```

**Assinatura:**
```java
public boolean contains(CharSequence s)
```

## Como funcionam na memória

Os três métodos **não criam novos objetos** — apenas percorrem o array interno de `char[]` e retornam um `boolean`. São O(n) no pior caso e retornam cedo ao encontrar divergência.

## Atenção: todos são case-sensitive

```
"Arquivo.PDF".endsWith(".pdf")   → false
"Arquivo.PDF".endsWith(".PDF")   → true
```

Para comparação case-insensitive, combine com `toLowerCase()`:
```java
arquivo.toLowerCase().endsWith(".pdf")
```

## Uso real em produção

```java
// Roteamento de requisição
if (path.startsWith("/api/")) { ... }

// Validação de tipo de arquivo
if (!nomeArquivo.endsWith(".csv")) throw new IllegalArgumentException(...);

// Filtro de log
if (mensagem.contains("ERROR") || mensagem.contains("FATAL")) alertar();
```
