# Read Me First
Esta é uma API REST, o crud de atendimento

# Getting Started
Passos para execuçao do projeto.
1- Criar um seviço realizando um POST no endpoint /servico com o JSON de exemplo:
    {
        "id": 1231,
        "descricao_procedimento": "Teste Covid",
        "valor_servico": 123.0
    }

2-Para criar um atendimento Realizar um POST no endpoint /atendimentos/atendimento com o JSON de exemplo:
{
    "identificador_paciente": "A123",
    "tipo_atendimento": "URGENCIA",
    "local": "HOSPITAL",
    "servicos": [
        {
            "id": 1231,
            "descricao_procedimento": "Teste Covid",
            "valor_servico": 123.0
        }
    ]
}
3- Para buscar um atendimento por identificador_paciente basta dar um GET no endpoint /atendimentos/paciente/{codigo-paciente}.
	Exemplo de chamada no endpoint "/atendimentos/paciente/A123"

4- Para atualizar um atendimento realizar um PUT no endpoint /atendimentos/atendimento/{codigo-paciente} com o Json de exemplo:
{
    "identificador_paciente": "A123",
    "tipo_atendimento": "ELETIVA",
    "local": "HOSPITAL",
    "servicos": [
        {
            "id": 1231,
            "descricao_procedimento": "Teste Covid",
            "valor_servico": 123.0
        }
    ]
}

5- Para deletar um atendimento realizar um DELETE no endpoint atendimentos/atendimento{codigo-paciente}

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#using-boot-devtools)

