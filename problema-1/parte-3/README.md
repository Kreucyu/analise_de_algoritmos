Trabalho de Análise de Algoritmos - Parte III

---

Neste trabalho, utilizamos Java para implementar um solução de casa inteligente para um usuário aaplicando os conceitos aprendidos na aula.

O sistema permite ao usuário controlar de forma fácil a sua casa e seus dispositivos, contando com um sistema universal de controle de dispositivos e modos de uso pre-definidos.

---

Problemas/Solução
    
    O código feito inicialmente estava com um excesso de if's, alto acoplamento, god entity e dependências de métodos/classes em lugares sem sentido.

    Utilizando os conceitos de POO e os conceitos estudados em sala de aula, foi possível aplicar uma solução com melhor qualidade de código. 

    As abordagens utilizadas foram:

---

Design Patterns Utilizados

Facade

    A interface do projeto utilizou o padrão Fachada/Facade.
    
    Serve para esconder métodos complexos e transformando tudo em apenas uma função que precisa ser chamada.


State

    Os equipamentos exigem diferentes tipos de funções, podendo variar dependendo do seu estado, então implementamos o padrão State.

    Serve para definir qual função pode ou não ser executada, definindo isso com base no estado do dispositivo.

Adapter

    Com base no enunciado, precisavámos implementar um sistema universal para o controle dos dispositivos da casa inteligente, mas cada dispositivo tem a suas próprias funções.

    Para conseguir realizar o sistema universal, foi utilizado o Padrão Adapter, para que fosse criada uma forma genérica de um dispositivo.

    Com a interface do dispositivo criada, foi possível utilizar comandos únicos para os devidos aparelhos, implementando a lógica de seus métodos na classe genérica.

Context (Strategy)

    Para corrigir o problema da Fachada ser uma God Entity, cuidando da manipulação e declaração de todos os dispositivos, foi aplicado o Context, sendo como um recorte do Padrão Strategy.

    Com o Context, foi possível criar as devidas classes dos dispositivos, servindo para manter a referência dos objetos e definindo as executando as devidas funções em conjunto com o Estado do dispositivo.

---

Clean Code

    Para manter a estrutura de clean code, aplicamos: 
    *Nomes significativos na declaração de variáveis e métodos, mantendo-os consistentes.
    *Funções bem definidas para executar apenas 1 função, utilizando poucos parâmetros para a chamada de cada uma delas.
    *Uso de exceções para o tratamento de possíveis erros.
    *Classes limpas, buscando fazer uma separação maior de classes para suas determinadas funções.

---

Object Calisthenics
    
    Para atender aos object calisthenics, aplicamos:
    *Apenas um nível de identação por método.
    *Não usamos a palavra reservada else.
    *Evitarmos o uso de if's e switch's, substituindo por outros métodos de refatoração.
    *Apenas um ponto por linha.
    *Não abreviamos nomes.
    *Buscamos manter as entidades pequenas, mantendo um número considerável de arquivos por pacotes.
    *Não utilizamos classes com mais de 2 atributos de instâncias.
    *Evitamos o uso de getters e setters em partes desnecessárias do código.

---

Refactoring
    
    Para a melhora do código, foi aplicado:
    *Tratamento de código duplicado, na classe ArCondicionadoLigado, onde ocorria diversos loops duplicados, foram substituidos pelo método genérico "executarAcao()".
    *Tratamento de excesso de condicionais, encapsulando os dispositvos em classes de controle de estados, aplicando Replace Conditional With Polymorphism.
    *Tratamento de muitas chamadas de métodos com muitos parâmetros, substituindo apenas pela chamada de context, que fica responsável pelos dispositivos.
    *Tratamento de códigos de erros por exceções personalizadas.

Tratamento de Exceções

    Para o tratamento das exceções, implementamos duas exceções personalizadas:
    "EstadoInvalidoException", que tem como finalidade as exeções de um dispositivo quando ele está em um estado inacessível para aquela determinada função.
    "FalhaNoDispositivoException", que tem como finalidade as exeções da persiana, caso ela não consiga ser carregada ou executar uma determinada função.
    
---

Testes

    Foram implementados os testes automatizados solicitados no enunciado do trabalho, a fim de testar:
    *As chamadas de métodos separados de cada dispositivo.
    *As chamadas do modo de trabalho, para fazer as funções automaticamente.
    *As chamadas do modo sono, para "desligar" a casa em determinado momento.

---

Diagrama de Classes

![Diagrama UML](uml.png)
