# 07 - Substring e Split

Essa dupla representa o núcleo da extração de dados tabulares, arquivos texto, logs e processamento de URLs/parâmetros em Java.

## `substring(int beginIndex)` e `substring(int beginIndex, int endIndex)`

Retorna um pedaço (fatia) da String original.
- Cuidado clássico: o `beginIndex` é **inclusivo**, mas o `endIndex` é **exclusivo** (o caractere na posição `endIndex` fica de fora).
- **Memória:** Nas versões muito antigas do Java (até o Java 7 update 5), `substring` apenas criava um novo objeto com ponteiros para o mesmo array de char interno da String original. A partir do Java 7 update 6+, o `substring` força a cópia do array de char subjacente na memória para evitar memory leaks caso a String original fosse gigante.

**Dica de ouro em concorrência e algoritmos**: `endIndex - beginIndex` sempre resulta no `length()` da String gerada.

## `split(String regex)` e `split(String regex, int limit)`

Corta a String em pedaços usando uma expressão regular (Regex) como delimitador, retornando um array de `String[]`. O limit controla o tamanho máximo do array resultante.

## Exemplos Reais em Produção

```java
// Cenário 1: Extrair um código padronizado de um número de série de produto
String serial = "PRD-2023-XYZ99";
String anoCriacao = serial.substring(4, 8); // Extrai "2023"

// Cenário 2: Quebrar uma linha de um arquivo CSV recebido (valores separados por vírgula)
String linhaCsv = "joao,joao@email.com,true,admin";
String[] colunas = linhaCsv.split(",");
// colunas[0] -> "joao"
// colunas[1] -> "joao@email.com"
```
