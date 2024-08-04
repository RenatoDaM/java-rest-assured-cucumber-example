# language: pt
  @users
  Funcionalidade:
    Como usuário do sistema
    desejo alterar minhas informações
    para assim poder mantê-las atualizadas

    Cenário: Edição de usuário
      Dado estar autenticado com usuário de email 'user.automation@gmail.com' e senha 'userAutomation'
      Quando enviar uma requisição PUT para atualizar os dados do usuário logado
