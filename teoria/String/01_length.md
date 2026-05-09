# String.length()

## O que é

Retorna o número de caracteres (unidades UTF-16) contidos na String. É um método de instância que acessa um campo interno `count` — **não percorre a String toda**, a operação é O(1).

## Como funciona na memória

Em Java, uma `String` é um objeto imutável que internamente guarda um array de `char[]` e um campo `int count`. Quando você chama `length()`, ele simplesmente retorna esse campo — sem iteração, sem custo extra.

```
"Java"
 ┌───┬───┬───┬───┐
 │ J │ a │ v │ a │   count = 4
 └───┴───┴───┴───┘
   0   1   2   3
```

> **Atenção:** caracteres Unicode fora do BMP (emojis, por exemplo) são representados como dois `char` (surrogate pair), então `"😀".length()` retorna **2**, não 1.

## Uso real em produção

- Validar tamanho de campos antes de persistir no banco (evitar `DataTooLongException`)
- Verificar se um token, CPF ou código tem o formato esperado
- Limitar exibição de texto em UI ("mostrando 1 de N resultados")

## Exemplo rápido

```java
String email = "usuario@empresa.com";

if (email.length() > 100) {
    throw new IllegalArgumentException("E-mail excede 100 caracteres");
}
```

## Assinatura

```java
public int length()
```
