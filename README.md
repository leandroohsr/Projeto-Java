# 🕹️ Projeto MC322
### 💻 [UNICAMP][1S2023] MC322 • Programação Orientada a Objetos

#

### 🧑‍🤝‍🧑 Autores

224538 ∷ Artur de Miranda Rodrigues  
213437 ∷ Leandro Henrique Silva Resende  
231718 ∷ Vitor Rodrigues Zanata Da Silva

#

### 🗒️ Descrição do Projeto
#### 1 - Conceitualização
O jogo desenvolvido tem como bases os gêneros "clicker" e "idle" e assemelha-se a um "simulador de cidade". Em essência, o jogador deve comprar casas, parques, hospitais e outras construções a fim de manter sua cidade ativa e rentável, de forma também a equilibrar suas estatísticas. Essas serão chamadas de "Stats", compostas por "População", "Felicidade" e "Infraestrutura". Caso o jogador falhe nesse equilíbrio, perde o jogo.

Outros recursos do jogo são: uma GUI interativa, recurso de salvar e de continuar um jogo prévio, tratamento de erros do usuário, entre outros.


#### Core mechanics

Aqui serão descritos os elementos principais do jogo:
- "Poupança" do jogador aumentada em taxa constante por segundo, podendo essa taxa ser aumentada de acordo com os tipos de construção presentes;
- Construções que podem ser compradas, ter sua capacidade ampliada ou receber uma transformação/"upgrade" (por exemplo, uma casa pode ser aumentada ou transformada em um prédio);
- Stats de População, Felicidade e Infraestrutura, que devem ser balanceados;
- Salvamento e carregamento de sessões de jogo;

#### Ideias da estrutura da base do programa

- "Construcao" será classe **interface**, determinando características comuns às das construções do jogo
- Classes como "Habtavel" serão pais **abstratos** dos tipos diferentes de contrução do mesmo nicho, como nesse caso, "Habtavel" é pai de "Casa" e "Predio".
- A classe "Cidade" representa a sessão de jogo atual, como Stats, taxas de aumento/decréscimo, poupança etc. Ela será também uma **agregação** dos diferentes tipos de construção. Será ela o "arquivo" a ser salvo para continuar o jogo.
- Existe uma classe "ElementosGraficos" responsável por criar e gerenciar os elementos da GUI e ligar os Triggers dos elementos às classes e métodos apropriados. Será a gerenciadora do Swing.
- A classe "AppMain" apenas estará encarregada de instanciar e iniciar o programa.

#### Resumo do funcionamento geral
- Main lida com "ElementosGraficos" e seus métodos, iniciando o programa e a GUI.
- O andamento será gerenciado pelos Triggers programados por Swing e Timers.
- O backend é armazenado e executado por Cidade
- Classes adicionais podem ser criadas como auxiliares.
- Erros/exceções como "Comprar algo sem ter dinheiro" ou "Carregar um jogo inexistente" são tratados corretamente

#

### 📔 A Disciplina

No início da disciplina MC322 (Programação Orientada a Objetos) da Unicamp, os alunos são introduzidos aos paradigmas de programação, que são diferentes abordagens para resolver problemas utilizando código. Eles exploram os conceitos de programação imperativa, orientada a objetos e funcional, entendendo as características distintas de cada um.

Além disso, os alunos são apresentados ao versionamento de projetos, que é o controle de versões do código-fonte ao longo do tempo. Eles aprendem a utilizar ferramentas populares, como Git, para gerenciar alterações, rastrear problemas e colaborar de forma eficiente em projetos de programação.

A abstração de dados é um conceito crucial, onde os alunos aprendem a representar informações do mundo real por meio de objetos, classes e tipos. Eles exploram como encapsular dados e comportamentos relacionados em objetos, definindo classes que atuam como modelos para criar instâncias.

Os alunos também são introduzidos às propriedades e estados dos objetos, entendendo como os objetos podem ter atributos que representam seu estado atual. Eles aprendem sobre métodos e mensagens, que são ações que os objetos podem executar e como a sobrecarga de métodos permite a existência de várias implementações para um mesmo método, mas com diferentes parâmetros.

O conceito de herança é explorado, tanto em herança simples como em herança múltipla, permitindo que os alunos compreendam como uma classe pode herdar atributos e comportamentos de uma classe pai. Eles também aprendem sobre hierarquias de generalização/especialização, onde classes mais específicas podem ser derivadas de classes mais gerais.

A compreensão de relacionamentos entre objetos é fundamental, e os alunos estudam associação, agregação e composição. Eles aprendem como os objetos podem se relacionar entre si, seja através de associações simples, composições mais fortes ou agregações mais fracas.

Os conceitos de sobrescrita, polimorfismo e alocação dinâmica são abordados para ensinar aos alunos a capacidade de substituir métodos em classes derivadas, a capacidade de usar uma mesma interface para diferentes tipos de objetos e como a alocação dinâmica permite a criação de objetos em tempo de execução.

Classes abstratas são introduzidas como classes que não podem ser instanciadas diretamente, mas fornecem uma base para outras classes derivadas. Os alunos aprendem a utilizar classes abstratas como modelos para criar hierarquias mais específicas de classes.

Por fim, as interfaces são discutidas como contratos que definem um conjunto de métodos que uma classe deve implementar. Os alunos aprendem a criar interfaces para garantir que diferentes classes possam fornecer implementações consistentes para funcionalidades específicas.

Ao final do semestre, espera-se que os alunos tenham uma compreensão sólida desses conceitos e estejam aptos a aplicá-los na resolução de problemas de programação utilizando diferentes paradigmas.
