# 09 - replace() e replaceAll()

Esses métodos são usados para **substituir** partes de uma `String` por outra.
Como `String` em Java é **imutável**, nenhuma substituição altera a string original: você sempre recebe **uma nova String** como retorno (ou, em algumas implementações, a mesma referência quando nenhuma troca é necessária).

## `replace(...)` (substituição literal)
O `replace` é para **substituição literal**, sem Regex.

Assinaturas comuns:
- `String replace(char oldChar, char newChar)`
- `String replace(CharSequence target, CharSequence replacement)`

**Quando usar:**
- Remover máscara de CPF/telefone (`.` `-` `(` `)`)
- Trocar separador decimal `,` por `.`
- Normalizar entradas vindas de UI/CSV/arquivos

**Vantagem:** não tem “pegadinhas” de Regex.

## `replaceAll(String regex, String replacement)` (substituição por Regex)
O `replaceAll` recebe um **regex** (expressão regular). Isso é muito poderoso, mas tem duas armadilhas comuns:

1) **O primeiro parâmetro é regex, não texto literal**
- `"."` significa “qualquer caractere” em regex.
- Se você quiser substituir um ponto literal, precisa escapar: `"\\."`

2) **Backslash no Java precisa ser escapado**
- Regex `\d+` (dígitos) vira string Java: `"\\d+"`

**Quando usar:**
- Remover tudo que não é dígito: `texto.replaceAll("\\D+", "")`
- Normalizar múltiplos espaços: `texto.replaceAll("\\s+", " ")`
- Limpar caracteres proibidos: `texto.replaceAll("[^a-zA-Z0-9_]", "")`

## Como funciona na memória?
- `String` é imutável; cada transformação cria um novo objeto.
- Em processamento pesado (muitas substituições em loop), considere `StringBuilder` ou pipeline com cuidado (mais pra frente no roadmap).

## Exemplo prático (diferente dos exercícios)
```java
String preco = "R$ 1.234,50";

// 1) Substituição literal (não-regex):
preco = preco.replace("R$", "").replace(".", "").replace(",", ".");
// preco -> " 1234.50" (ainda com espaço)

// 2) Limpeza de bordas (já vimos):
preco = preco.strip();
// preco -> "1234.50"

// 3) Transformar em número:
double valor = Double.parseDouble(preco);
```

