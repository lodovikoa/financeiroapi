financeiroapi

API Restful para obter dados financeiros em aberto de um ministro, bem como registro de boletos de acordo com a seleção de parcelas escolhida pelo ministro usuário.

Requerido:
Banco de dados MySql confrater00 

Obs.: O banco de dados confrater00 é mantido pela aplicação versionada em https://github.com/lodovikoa/convencao

Exemplos de uso com testes feitos no Postman:
Requisições devem ser feitas usando Authorization Type: Basic Auth, Username: confrateres, Password: <senha definida no sistema>

------------------------------------------------------------------------------------------
Consulta pendências de ministro - GET:
localhost:8081/regLancamento/<codigo>/<cpf>/<data nascimento yyyy-mm-dd>/<nome parcial>

Retorno json:
{
    "nmNome": "<nome>",
    "dsEmail": "<email opcional>",
    "dsCargo": "<cargo>",
    "dsIgreja": "<igreja>",
    "regLancamentoDTO": [
        {
            "sqRegLancamento": <codigo>,
            "dtVencimento": "<dd/mm/yyyy>",
            "vlLancamento": <valor exemplo 88.50>,
            "vlSaldo": <saldo exemplo 88.50>,
            "dsLancamentoTipo": "<descrição>",
            "dsUrl": ""
        }
    ],
    "cdMinistro": <codigo>
}
------------------------------------------------------------------------------------------

Gravar boleto gerado - POST:
localhost:8081/boleto
[{
	"dsUrl": "<URL do boleto>",
	"regLancamentos": [
		{
			"sqRegLancamento" : <codigo>
		}
	]
}]

Retorno código http 201-created
Não retorno no corpo (Body)
------------------------------------------------------------------------------------------