# ArrayList vs LinkedList — Análise Experimental

Trabalho prático de análise experimental comparando o desempenho de `ArrayList` e `LinkedList` em diferentes operações, desenvolvido para a disciplina de Algoritmos e Estruturas de Dados na FURB.

**Autores:** Felipe Grochovksi e Elcio Cleiton Wippel

---

## Experimentos realizados

**Questão 1 — Inserção ao final (100.000 elementos, 20 execuções)**
- ArrayList: ~2,04 ms | LinkedList: ~3,20 ms
- ArrayList foi **1,57x mais rápido** por conta da localidade de cache e memória contígua.
- Testou-se também o impacto da capacidade inicial do ArrayList (10, 1.000 e 100.000): capacidade pré-alocada em 100.000 foi a mais rápida por eliminar redimensionamentos internos.

**Questão 2 — Inserção em posição aleatória (20 execuções)**
- ArrayList: ~191 ms | LinkedList: ~7.750 ms
- ArrayList foi **40x mais rápido**.

**Questão 3 — Remoção sequencial (100.000 elementos, 20 execuções)**
- Removendo o **primeiro elemento**: LinkedList venceu por **810x** (operação O(1) vs O(n)).
- Removendo o **último elemento**: desempenho praticamente idêntico (~1,07x).

**Questão 4 — Remoção em posição aleatória (20 execuções)**
- ArrayList: ~148 ms | LinkedList: ~2.540 ms
- ArrayList foi **17x mais rápido**.

**Questão 5 — Acesso por índice aleatório (10.000 acessos, 20 execuções)**
- ArrayList: ~0,677 ms | LinkedList: ~328 ms
- ArrayList foi **485x mais rápido** (O(1) vs O(n)).

---

## Conclusão

O ArrayList superou a LinkedList na maioria dos cenários. O principal fator foi a **localidade de cache**: dados contíguos em memória reduzem cache misses e permitem otimizações nativas da JVM (JIT, SIMD). A LinkedList só se destacou na remoção do primeiro elemento, sendo recomendada em cenários de **fila (FIFO)** com muitas operações nessa extremidade.

---

## Tecnologias

- Java
- JVM (HotSpot)

---

<img width="884" height="1142" alt="image" src="https://github.com/user-attachments/assets/33250e57-ed54-4531-b77f-04c64bbec797" />

