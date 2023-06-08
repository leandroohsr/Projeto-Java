# Descrição inicial do Projeto - Jogo
## 1 - Conceitualização
O jogo desenvolvido tem como bases os gêneros "clicker" e "idle" e assemelha-se a um "simulador de cidade". Em essência, o jogador deve comprar casas, parques, hospitais e outras construções a fim de manter sua cidade ativa e rentável, de forma também a equilibrar suas estatísticas. Essas serão chamadas de "Stats", compostas por "População", "Felicidade" e "Infraestrutura". Caso o jogador falhe nesse equilíbrio, perde o jogo.

Outros recursos do jogo são: uma GUI interativa, recurso de salvar e de continuar um jogo prévio, tratamento de erros do usuário, entre outros.


## Core mechanics

Aqui serão descritos os elementos principais do jogo:
- "Poupança" do jogador aumentada em taxa constante por segundo, podendo essa taxa ser aumentada de acordo com os tipos de construção presentes;
- Construções que podem ser compradas, ter sua capacidade ampliada ou receber uma transformação/"upgrade" (por exemplo, uma casa pode ser aumentada ou transformada em um prédio);
- Stats de População, Felicidade e Infraestrutura, que devem ser balanceados;
- Salvamento e carregamento de sessões de jogo;

## Ideias da estrutura da base do programa

- "Construcao" será classe **interface**, determinando características comuns às das construções do jogo
- Classes como "Habtavel" serão pais **abstratos** dos tipos diferentes de contrução do mesmo nicho, como nesse caso, "Habtavel" é pai de "Casa" e "Predio".
- A classe "Cidade" representa a sessão de jogo atual, como Stats, taxas de aumento/decréscimo, poupança etc. Ela será também uma **agregação** dos diferentes tipos de construção. Será ela o "arquivo" a ser salvo para continuar o jogo.
- Existe uma classe "ElementosGraficos" responsável por criar e gerenciar os elementos da GUI e ligar os Triggers dos elementos às classes e métodos apropriados. Será a gerenciadora do Swing.
- A classe "AppMain" apenas estará encarregada de instanciar e iniciar o programa.

## Resumo do funcionamento geral
- Main lida com "ElementosGraficos" e seus métodos, iniciando o programa e a GUI.
- O andamento será gerenciado pelos Triggers programados por Swing e Timers.
- O backend é armazenado e executado por Cidade
- Classes adicionais podem ser criadas como auxiliares.
- Erros/exceções como "Comprar algo sem ter dinheiro" ou "Carregar um jogo inexistente" são tratados corretamente
