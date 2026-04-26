# Manipulação de Strings em Java

Repositório de estudo focado em dominar a manipulação de Strings em Java, com exercícios progressivos orientados a testes.

## Objetivo

Percorrer os principais métodos da classe `String` (e `StringBuilder`) do zero ao avançado, resolvendo 5 exercícios por comando — do fácil ao desafio — sempre validando a lógica com testes rudimentares (`PASSOU` / `FALHOU`).

## Estrutura

```
manipulacao-strings/
├── teoria/                          # Arquivos .md com teoria de cada comando
│   ├── 01_length.md
│   ├── 02_isEmpty_isBlank.md
│   └── ...
└── src/
    └── exercicios/                  # Um pacote por comando
        ├── length/
        │   ├── Exercicio01.java
        │   └── ...
        ├── isempty_isblank/
        │   └── ...
        └── ...
```

## Roadmap de Comandos

| # | Grupo | Comandos |
|---|-------|----------|
| 1 | Inspeção e Validação | `length()`, `isEmpty()`, `isBlank()`, `startsWith()`, `endsWith()`, `contains()` |
| 2 | Comparação | `equals()`, `equalsIgnoreCase()` |
| 3 | Fatiamento e Busca | `charAt()`, `indexOf()`, `lastIndexOf()`, `substring()`, `split()` |
| 4 | Modificação e Limpeza | `trim()`, `strip()`, `replace()`, `replaceAll()`, `toLowerCase()`, `toUpperCase()` |
| 5 | Conversão e Formatação | `String.valueOf()`, `String.format()`, `String.join()` |
| 6 | Alta Performance | `StringBuilder` |

## Como usar

Cada arquivo `.java` em `src/exercicios/` contém:
- O enunciado no Javadoc da classe
- O método a ser implementado (com `// TODO`)
- Um `main` com testes automáticos que imprimem `PASSOU` ou `FALHOU`

Basta abrir o arquivo, implementar o método e rodar a classe.

---

## Prompt de Estudo

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
