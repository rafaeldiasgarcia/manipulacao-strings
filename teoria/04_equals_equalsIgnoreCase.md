# equals(), equalsIgnoreCase()

## equals(Object anObject)

Retorna `true` se as Strings tiverem exatamente os mesmos caracteres, na mesma ordem e com a mesma capitalização (case-sensitive). Em Java, o operador `==` compara as **referências de memória**, enquanto `equals()` compara o **conteúdo** do objeto.

```
"Java".equals("Java")  → true
"Java".equals("java")  → false  ← case-sensitive!
"Java".equals(" Java") → false  ← espaços contam!
```

**Assinatura:**
```java
public boolean equals(Object anObject)
```

## equalsIgnoreCase(String anotherString)

Faz a mesma comparação de conteúdo, mas ignora a diferença entre letras maiúsculas e minúsculas (case-insensitive).

```
"Java".equalsIgnoreCase("java")  → true
"JAVA".equalsIgnoreCase("java")  → true
"admin".equalsIgnoreCase("ADMIN") → true
```

**Assinatura:**
```java
public boolean equalsIgnoreCase(String anotherString)
```

## Como funcionam na memória

- **`equals()`**: Primeiro checa se as referências de memória são idênticas (`this == anObject`) e retorna `true` direto se forem (O(1)). Se não forem, ele verifica se o `length()` é igual. Só então ele percorre os arrays internos (`byte[]` no Java 9+) comparando posição por posição. A operação é O(n) no pior caso, mas otimizada para falhar rápido.
- **`equalsIgnoreCase()`**: Faz um trabalho similar de iteração O(n), mas ao comparar cada caractere, tenta convertê-los (ambos para maiúsculo e depois minúsculo) antes da checagem, ignorando assim a capitalização.

## Diferença Crítica (`==` vs `equals`)

| Operação | O que compara? | "Java" vs "Java" (Literais) | "Java" vs new String("Java") |
|----------|----------------|-----------------------------|------------------------------|
| `==`     | Memória        | true (String Pool)          | false                        |
| `equals` | Conteúdo       | true                        | true                         |

## Boas Práticas contra NullPointerException (NPE)

Chamar o método `.equals()` a partir de uma variável nula resulta em um erro crítico (`NullPointerException`). Temos duas formas consagradas de evitar isso em Java:

### 1. Yoda Condition
Usado quando comparamos uma variável com uma constante/literal. Sempre chamamos o método a partir da String que temos certeza que **não é** nula:
```java
String status = null;
// Errado: status.equals("ATIVO") -> NullPointerException
// Certo:
if ("ATIVO".equals(status)) { ... } 
```

### 2. O utilitário `Objects.equals` (Java 7+)
A forma mais moderna e segura quando estamos comparando **duas variáveis** que podem ser nulas. Esse método da classe utilitária genérica `java.util.Objects` faz todas as checagens por baixo dos panos.
```java
import java.util.Objects;

String texto1 = null;
String texto2 = null;

// Retorna true sem quebrar a aplicação (null é igual a null)
boolean saoIguais = Objects.equals(texto1, texto2); 
```
*(Atenção: A classe `Objects` não possui um `Objects.equalsIgnoreCase`. Nesse caso, é preciso tratar o nulo manualmente antes de chamar o método).*

## Uso real em produção

```java
// Autenticação exata
if (senha.equals(senhaDoBanco)) { ... }

// Checagem de formato exato ou constante
if ("PRODUCAO".equals(ambienteAtual)) { ... }

// Entrada flexível do usuário
if (respostaUsuario.equalsIgnoreCase("Sim")) { ... }
if (emailDigitado.equalsIgnoreCase(emailCadastrado)) { ... }
```
