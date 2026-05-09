# String.indexOf() e String.lastIndexOf()

## O que são

Esses métodos são os "buscadores" nativos do Java. Eles procuram a primeira (ou última) ocorrência de um caractere (`char`) ou de um texto (`String`) dentro da String principal.

Se o texto for encontrado, eles retornam o **índice** (posição de `0` até `length - 1`) onde o texto começa.
Se o texto **NÃO** for encontrado, eles retornam exatamente **`-1`**.

## Como funciona na memória

O Java percorre a String caractere por caractere tentando dar "match" com o que você pediu.
- **`indexOf`**: Busca da Esquerda para a Direita (do começo pro fim).
- **`lastIndexOf`**: Busca da Direita para a Esquerda (do fim pro começo).

```
"Programador"
 0123456789...

"Programador".indexOf('r')      → Retorna 1  (primeiro 'r')
"Programador".lastIndexOf('r')  → Retorna 10 (último 'r')
"Programador".indexOf("grama")  → Retorna 3  (onde a palavra começa)
"Programador".indexOf("Java")   → Retorna -1 (não existe)
```

## Uso real em produção

- **Validação:** Substitui a necessidade do `contains()` em versões antigas do Java. Se `indexOf(texto) != -1`, é porque o texto contém aquela palavra.
- **Busca de extensões de arquivos:** Usar `lastIndexOf('.')` para achar exatamente onde começa a extensão do arquivo (mesmo que o arquivo tenha outros pontos no nome, como `relatorio.v2.final.pdf`).
- **Extração Dinâmica:** Achar a posição do espaço em branco para separar o Primeiro Nome do Sobrenome.

## Assinaturas mais usadas

```java
public int indexOf(int ch)             // Busca caractere
public int indexOf(String str)         // Busca texto
public int lastIndexOf(int ch)         // Busca caractere de trás pra frente
public int lastIndexOf(String str)     // Busca texto de trás pra frente

// Versões com fromIndex:
public int indexOf(int ch, int fromIndex)      // começa a busca a partir de fromIndex
public int indexOf(String str, int fromIndex)  // idem para substring
```

## indexOf com fromIndex — busca a partir de uma posição

A versão com dois parâmetros funciona igual à normal, mas **ignora tudo antes do índice informado**. É como dizer: "começa a procurar daqui em diante".

```
texto:     "b a n a n a"
índices:    0 1 2 3 4 5

indexOf('a')       → começa do 0, acha no índice 1
indexOf('a', 2)    → começa do 2, ignora o 'a' do índice 1, acha no índice 3
indexOf('a', 4)    → começa do 4, ignora os anteriores, acha no índice 5
indexOf('a', 6)    → começa do 6, passou do fim, retorna -1
```

O uso mais comum é **iterar todas as ocorrências** avançando o `fromIndex` a cada achado:

```java
String texto = "banana";
int pos = 0;

while ((pos = texto.indexOf('a', pos)) != -1) {
    System.out.println("Achou 'a' no índice " + pos);
    pos++; // avança para não ficar preso na mesma posição
}
// Saída:
// Achou 'a' no índice 1
// Achou 'a' no índice 3
// Achou 'a' no índice 5
```

> Sem o `pos++` no final do loop, o `indexOf` encontraria sempre o mesmo índice e o loop nunca terminaria.
