# language: pt

Funcionalidade: Apenas usuarios cadastrados podem se logar

	Cenario: Um usuario valido consegue se logar
		Dado o usuario valido
		Quando realiza login
		Entao eh redireciionado para a pagina de leiloes
		
	Cenario: Um usuario invalido nao consegue se logar
		Dado o usuario invalido
		Quando tenta se logar
		Entao continua na página de login