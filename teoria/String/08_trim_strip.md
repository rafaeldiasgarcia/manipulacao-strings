# 08 - Trim e Strip

Comandos focados em "limpar" as bordas de uma String, removendo espaços em branco acidentais no início ou no fim.

## `trim()`
- **O Clássico (Desde o Java 1.0):** Remove caracteres cujo código ASCII seja menor ou igual a espaço (U+0020).
- **Limitação:** Não reconhece espaços em branco "exóticos" do padrão Unicode (como o espaço inquebrável usado em algumas tabelas e formatações).
- **Memória:** Caso a String original não possua espaços nas bordas, ele avalia e retorna a exata mesma referência da String original na memória. Caso contrário, gera uma string nova.

## `strip()` (Recomendado)
- **O Moderno (Desde o Java 11):** Faz a mesma coisa que o trim, mas usa o método `Character.isWhitespace(char)` atualizado, sendo totalmente compatível com a remoção de espaços em branco do padrão Unicode moderno.
- **Variantes Úteis:** `stripLeading()` (limpa apenas no começo/esquerda) e `stripTrailing()` (limpa apenas no final/direita).

## Quando usar na vida real?
Praticamente TODA validação de Input recebido pelo usuário.

## Exemplo em Produção
```java
// Usuário preencheu um formulário e copiou e colou o nome com espaços a mais
String usernameDigitado = "  admin_ti  ";
String emailDigitado = " contato@empresa.com \t \n";

String userLimpo = usernameDigitado.strip(); // "admin_ti"
String emailLimpo = emailDigitado.strip(); // "contato@empresa.com"
```
