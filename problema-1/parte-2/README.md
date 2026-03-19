Trabalho Análise de Algoritmos - Parte II

---

Neste trabalho, utilizamos java para implementar uma simulação de sistema de bolsa de valores, para aplicarmos os conceitos aprendidos em sala de aula.

Temos um sistema de ações para trabalhar com as transações e com a lógica do sistema de bolsa, cuidando das ações disponíveis. Cada ação possui: Nome, Valor e sua lista de Ordens.

O sistema permite que realizemos transações de compra e venda de ações e também permite enviar notificações de alterações de valores de determinada ação no qual o investidor se cadastrou.

---

Design Patterns Utilizados

Observer

    O serviço de notificações foi implementado utilizando o padrão observer.
    Foi utilizado as classes padrões do java para isso (java.util.Observer e java.util.Observable), utilizando essas classes foi possível fazer o sistema de notificação ao observador quando uma ação é vendida.

---

Clean Code

    Práticas aplicadas no código:

    * Uso de nomes claros e descritivos para classes, métodos e variáveis
    * Substituição de variáveis mágicas por constantes
    * Separação de responsabilidades entre entidades e serviços
    * Métodos pequenos com responsabilidades bem definidas

---

Object Calisthenics

    Regras que consideramos durante a implementação:

    * Encapsulamento dos dados dentro de sua própria classe
    * Métodos com responsabilidade única
    * Redução de lógica condicional utilizando lambdas
    * Classes com responsabilidades bem definidas

---

Testes

    Foram criados testes unitários utilizando JUnit para validar o funcionamento do sistema de notificações ao usuário e garantir o comportamento esperado do sistema.

---

Diagrama de Classes

![Diagrama UML](uml.png)

