# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Sobre o projeto

Repositório de estudo de manipulação de Strings em Java. O usuário resolve exercícios progressivos (5 por comando, do fácil ao desafio) e recebe revisão técnica a cada solução. Não há framework de testes — a validação é feita via `System.out.println` com `PASSOU` / `FALHOU` no próprio `main`.

## Como rodar um exercício

Projeto IntelliJ IDEA sem Maven/Gradle. Para rodar via terminal:

```bash
# compilar um exercício
javac -d out src/exercicios/length/Exercicio01.java

# executar
java -cp out exercicios.length.Exercicio01
```

## Convenções do repositório

**Nomenclatura de arquivos:**
- Teoria: `teoria/NN_nomeDoComando.md` (ex: `01_length.md`, `02_isEmpty_isBlank.md`)
- Exercícios: `src/exercicios/nome_do_comando/ExercicioNN.java` (ex: `exercicios/length/Exercicio01.java`)
- Pacote Java espelha a pasta: `package exercicios.length;`

**Estrutura de cada arquivo `.java`:**
- Enunciado e restrições no Javadoc da classe
- Um único método estático a ser implementado, com `// TODO` quando vazio
- `main` com testes unitários cobrindo todos os cenários e edge cases (sem limite de quantidade) imprimindo `Teste N | Esperado: X | Obtido: Y | PASSOU/FALHOU` com cores no console, usando ANSI escape codes (`\u001B[32m` verde para "PASSOU" e `\u001B[31m` vermelho para "FALHOU").

**Progressão dos exercícios:** cada comando tem exatamente 5 exercícios em dificuldade crescente. O Exercicio05 é sempre o desafio final do comando.

## Roadmap de comandos

| # | Grupo | Comandos |
|---|-------|----------|
| 1 | Inspeção e Validação | `length()`, `isEmpty()`, `isBlank()`, `startsWith()`, `endsWith()`, `contains()` |
| 2 | Comparação | `equals()`, `equalsIgnoreCase()` |
| 3 | Fatiamento e Busca | `charAt()`, `indexOf()`, `lastIndexOf()`, `substring()`, `split()` |
| 4 | Modificação e Limpeza | `trim()`, `strip()`, `replace()`, `replaceAll()`, `toLowerCase()`, `toUpperCase()` |
| 5 | Conversão e Formatação | `String.valueOf()`, `String.format()`, `String.join()` |
| 6 | Alta Performance | `StringBuilder` |

## Fluxo de mentoria (como conduzir a sessão)

1. Criar `teoria/NN_comando.md` com teoria do comando (o que é, como funciona na memória, uso em produção, exemplo prático)
2. Criar `src/exercicios/comando/Exercicio01.java` com método `// TODO` e testes no `main`
3. Aguardar o usuário implementar e enviar o código
4. Revisar: apontar bugs, anti-padrões (ex: `condition ? true : false`, variável intermediária desnecessária) e sugerir forma mais idiomática
5. Criar o próximo exercício e repetir até o Exercicio05
6. Após o Exercicio05 aprovado, avançar para o próximo comando da lista

## Progresso atual

- `length()` — **concluído**
- `isEmpty()` / `isBlank()` — **concluído**
- `startsWith()` / `endsWith()` / `contains()` — **concluído**
- `equals()` / `equalsIgnoreCase()` — **concluído**
- `charAt()` — **concluído**
- `indexOf()` / `lastIndexOf()` — **concluído**
- `substring()` / `split()` — **concluído**
- `trim()` / `strip()` / `replace()` / `replaceAll()` / `toLowerCase()` / `toUpperCase()` — **próximo**

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
