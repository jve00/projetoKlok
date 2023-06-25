#projetoKlok


#desafio 

Desafio pedido pela klok, com a inteção de testar as habilidades dos participantes do processo seletivo, referente a uma vaga de estágio.

⚙️ Executando os testes

Esse projeto foi desenvolvido com o padrão de projeto PageObject que é uma abordagem comum para organizar e estruturar os testes automatizados.
O uso do mesmo ajuda a organizar e reutilizar o código de interação com os elementos da página, tornando os testes mais legíveis e fáceis de manter.
fiz um split de teste, para me ajudar a testar todos os testes, deixando assim, o memso mais pratico enquanto eu desenvolvia.

⌨️ Explicando cada teste

testeBuscarProdutoSucesso(): 
Neste teste, é aberta a página inicial, preenchido o campo de busca com o termo "Teclado gamer", clicado no botão de busca e verificado se os resultados contêm as palavras "teclado" e "gamer".

testBtnPesquisaNaoPrecionadoInvalido():
Neste teste, é aberta a página inicial, preenchindo o campo de busca com o termo "teclado" e verifica se o usuário pressionou o botão de buscar

testSelecionarProdutoEComprar(): 
Neste teste, é aberta a página inicial, preenchido o campo de busca com o termo "teclado gamer", clicado no botão de busca, selecionado um produto, adicionado o produto ao carrinho, e verificado se a página de login é exibida.

testProdutoNaoEncontradoInvalido():
Neste teste, é aberta a página inicial, preenchido o campo de busca com um termo inválido, clicado no botão de busca, e verificado se a mensagem de produto não encontrado é exibida.

testCliqueNoCarrinhoSucesso(): 
Neste teste, é aberta a página inicial, clicado no botão do carrinho, e verificado se a URL corresponde à página do carrinho.

testErroConexao(): 
Neste teste, é aberta a página inicial, preenchido o campo de busca com o termo "monitor", clicado no botão de busca, e verificado se ocorre uma exceção indicando falha na conexão.

testURLEncontradaSucesso(): 
Neste teste, é aberta a página inicial, obtida a URL atual, e verificado se a URL corresponde à página inicial.

testCarrinhoSemProdutoInvalido(): 
Neste teste, é aberta a página inicial, clicado no botão do carrinho, e verificado se a mensagem de carrinho vazio 

🛠️ Construído com
IntelliJ IDEA
Feito na lingauem Java
Selenium 
Framework Junit
Maven - Gerente de Dependência


🎁 gratidão
Foi um prazer desenvolver esse teste de automoção, pois agregou muito com os meus conhecimentos, e tive a oportunidade de colocar em pratica os meus conhecimentos.
com ❤️ por Joao vitor 😊
