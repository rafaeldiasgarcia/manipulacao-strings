## Sobre o projeto

Repositório de estudo de manipulação de Strings em Java. O usuário resolve exercícios progressivos conforme a necessidade didática de cada comando/grupo e recebe revisão técnica a cada solução. Não há framework de testes — a validação é feita via `System.out.println` com `PASSOU` / `FALHOU` no próprio `main`.

**Versão do Java:** Java 21 (sem usar features preview). Evitar sintaxes como *String Templates* (ex: `STR."..."` ou `StringTemplate`, e também `replaceAll(regex: ...)`). Usar `String` comum com escapes (ex: `"\\s+"`).

## Como rodar um exercício

Projeto IntelliJ IDEA sem Maven/Gradle. Para rodar via terminal:

```bash
# compilar um exercício
javac -d out src/exercicios/length/Exercicio01.java

# executar
java -cp out exercicios.length.Exercicio01
```

**Regra da mentoria:** o assistente não deve rodar compilação nem testes automaticamente após o usuário enviar uma solução. A revisão deve ser feita lendo o código. Só rodar comandos (`javac`, `java`, testes ou equivalentes) se o usuário pedir explicitamente ou enviar um erro/saída para investigar.

## Convenções do repositório

**Nomenclatura de arquivos:**
- Teoria: `teoria/NN_nomeDoComando.md` (ex: `01_length.md`, `02_isEmpty_isBlank.md`)
- Exercícios: `src/exercicios/nome_do_comando/ExercicioNN.java` (ex: `exercicios/length/Exercicio01.java`)
- Pacote Java espelha a pasta: `package exercicios.length;`

**Estrutura de cada arquivo `.java`:**
- Enunciado e restrições no Javadoc da classe
- Um único método estático a ser implementado, com `// TODO` quando vazio
- `main` com testes unitários cobrindo todos os cenários e edge cases (sem limite fixo de quantidade, use o necessário para cobrir nulos, bordas, sucessos e exceções lógicas) imprimindo `Teste N | Esperado: X | Obtido: Y | PASSOU/FALHOU` com cores no console, usando ANSI escape codes (`\u001B[32m` verde para "PASSOU" e `\u001B[31m` vermelho para "FALHOU").

**Progressão dos exercícios:** não há quantidade fixa por comando/grupo. Criar apenas a quantidade necessária para o usuário dominar o tema: se um conceito precisar de 1 exercício, fazer 1; se precisar de 30, fazer 30. A progressão deve ir do básico ao desafio somente enquanto houver ganho didático real, evitando exercícios repetitivos que testam o mesmo cenário.

## Roadmap de comandos

| # | Grupo | Comandos |
|---|-------|----------|
| 1 | Inspeção e Validação | `length()`, `isEmpty()`, `isBlank()`, `startsWith()`, `endsWith()`, `contains()` |
| 2 | Comparação | `equals()`, `equalsIgnoreCase()` |
| 3 | Fatiamento e Busca | `charAt()`, `indexOf()`, `lastIndexOf()`, `substring()`, `split()` |
| 4 | Modificação e Limpeza | `trim()`, `strip()`, `replace()`, `replaceAll()`, `toLowerCase()`, `toUpperCase()` |
| 5 | Conversão e Formatação | `String.valueOf()`, `String.format()`, `String.join()` |
| 6 | Alta Performance | `StringBuilder` |

## Roadmap de StringBuilder

| # | Grupo | Métodos / Conceitos |
|---|-------|---------------------|
| 1 | Criação e Conversão | `new StringBuilder()`, `new StringBuilder(int capacity)`, `new StringBuilder(String)`, `toString()` |
| 2 | Construção de Texto | `append()` |
| 3 | Inspeção e Busca | `length()`, `isEmpty()`, `charAt()`, `substring()`, `indexOf()`, `lastIndexOf()` |
| 4 | Inserção | `insert()` |
| 5 | Remoção | `delete()`, `deleteCharAt()` |
| 6 | Alteração | `setCharAt()`, `replace()` |
| 7 | Reordenação | `reverse()` |
| 8 | Comparação (Atenção) | `compareTo()`; `equals()` compara referência/endereço, não conteúdo |
| 9 | Capacidade e Performance | `capacity()`, `ensureCapacity()`, `trimToSize()`, `setLength()` |
| 10 | Integração com Streams | `chars()`, `codePoints()` |

## Fluxo de mentoria (como conduzir a sessão)

1. Criar `teoria/NN_comando.md` com teoria do comando (o que é, como funciona na memória, uso em produção, exemplo prático)
2. Criar `src/exercicios/comando/Exercicio01.java` com método `// TODO` e testes no `main`
3. Aguardar o usuário implementar e enviar o código
4. Revisar: apontar bugs, anti-padrões (ex: `condition ? true : false`, variável intermediária desnecessária) e sugerir forma mais idiomática
5. Criar o próximo exercício apenas se ainda houver conceito, borda ou combinação relevante a praticar
6. Quando o tema estiver suficientemente coberto, avançar para o próximo comando/grupo da lista

## Progresso atual

- `length()` — **concluído**
- `isEmpty()` / `isBlank()` — **concluído**
- `startsWith()` / `endsWith()` / `contains()` — **concluído**
- `equals()` / `equalsIgnoreCase()` — **concluído**
- `charAt()` — **concluído**
- `indexOf()` / `lastIndexOf()` — **concluído**
- `substring()` / `split()` — **concluído**
- `trim()` / `strip()` — **concluído**
- `replace()` / `replaceAll()` — **concluído**
- `toLowerCase()` / `toUpperCase()` — **concluído**
- `String.valueOf()` — **concluído**
- `String.format()` — **concluído**
- `String.join()` — **concluído**
- `StringBuilder` — **em andamento**

## Prompt original do estudo

```
Aja como um Engenheiro de Software Sênior me mentorando em Java. Quero dominar a manipulação de Strings e estruturar meu raciocínio lógico focado em testes. Vamos percorrer a seguinte lista de comandos essenciais:

**1. Inspeção e Validação:** length(), isEmpty(), isBlank(), startsWith(), endsWith(), contains() **2. Comparação:** equals(), equalsIgnoreCase() **3. Fatiamento e Busca:** charAt(), indexOf(), lastIndexOf(), substring(), split() **4. Modificação e Limpeza:** trim(), strip(), replace(), replaceAll(), toLowerCase(), toUpperCase() **5. Conversão e Formatação:** String.valueOf(), String.format(), String.join() **6. Manipulação de Alta Performance:** StringBuilder

**Regras de Interação e Formatação (MUITO IMPORTANTE):** Trabalharemos **UM comando por vez** e **UM exercício por vez**. Para cada comando, você deve seguir este fluxo exato:

1. **Apresentação do Comando (Formato .MD):** Explique a teoria (o que é, como funciona na memória, uso real em produção) e dê UM pequeno exemplo prático de código diferente dos exercícios. **Toda essa parte teórica e de explicação deve vir encapsulada dentro de um único bloco de código ` ```markdown `**, para que eu possa copiar tudo de uma vez e salvar em um arquivo `.md`.

2. **Entrega do Exercício (Formato .JAVA):** Fora do bloco markdown, me envie o enunciado do exercício atual e **UM código-fonte Java completo exclusivo para este exercício** dentro de um bloco de código ` ```java ` separado. O código deve ter a classe, o método `main` com testes unitários rudimentares (imprimindo "PASSOU" ou "FALHOU") e o método vazio com a assinatura correta para eu preencher a lógica.

3. **PAUSA:** Pare a geração e aguarde minha resposta com a solução do método.

4. **Revisão e Próximo Passo:** Após eu enviar o código, faça a revisão técnica. Se estiver certo, elogie e me envie o **Próximo Exercício** deste mesmo comando (com um novo código-fonte isolado só para ele no bloco Java) e faça uma nova PAUSA.

5. **Ciclo:** Repita isso para 5 exercícios progressivos (do fácil ao desafio) focados apenas no comando atual. Após o Exercício 5 ser resolvido, avance para a **Apresentação do Próximo Comando** da lista.

**Instrução de Partida:** Inicie agora apresentando o PRIMEIRO comando da lista (`length()`). Forneça a teoria no bloco Markdown, entregue o código-fonte independente do **Exercício 1** no bloco Java. Depois, PARE e aguarde meu código.
```
