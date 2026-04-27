# isEmpty() e isBlank()

## isEmpty()

Retorna `true` se a String tiver comprimento zero — ou seja, `length() == 0`. Uma String com apenas espaços **não** é considerada vazia.

```
""      → isEmpty() = true
" "     → isEmpty() = false   ← tem 1 caractere (espaço)
"Java"  → isEmpty() = false
```

**Assinatura:**
```java
public boolean isEmpty()
```

## isBlank()

Introduzido no **Java 11**. Retorna `true` se a String for vazia **ou** contiver apenas espaços em branco (espaço, tab, newline…). Internamente usa `Character.isWhitespace()`, por isso é mais robusto que checar `trim().isEmpty()`.

```
""      → isBlank() = true
" "     → isBlank() = true    ← só espaço
"\t\n"  → isBlank() = true    ← tab e newline
"Java"  → isBlank() = false
" a "   → isBlank() = false   ← tem conteúdo real
```

**Assinatura:**
```java
public boolean isBlank()   // Java 11+
```

## Como funciona na memória

- `isEmpty()` compara `length() == 0` — O(1), sem iteração.
- `isBlank()` percorre os caracteres até achar um não-whitespace — O(n) no pior caso, mas retorna cedo se achar conteúdo.

## Diferença crítica

| String   | isEmpty() | isBlank() |
|----------|-----------|-----------|
| `""`     | true      | true      |
| `" "`    | false     | true      |
| `"abc"`  | false     | false     |

## Uso real em produção

```java
// Antes do Java 11 — padrão antigo (ainda válido)
if (input == null || input.trim().isEmpty()) { ... }

// Java 11+ — forma preferida
if (input == null || input.isBlank()) { ... }
```

Use `isBlank()` para validar entradas do usuário (campos de formulário, parâmetros de API). Use `isEmpty()` quando espaços são conteúdo válido (senhas, tokens).
