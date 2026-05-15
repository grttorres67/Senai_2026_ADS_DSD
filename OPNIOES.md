# Respostas do Questionário de Arquitetura

**1. Qual tecnologia de comunicação ou servidor de design utiliza?**
*(Avaliando pelo contexto da arquitetura, acredito que a pergunta refere-se ao **Servidor de Dados**)*
**Resposta:** O Servidor de Dados utiliza a tecnologia **Java RMI** (Remote Method Invocation) para comunicação e exposição dos seus serviços.

**2. Qual protocolo de mensagem o servidor de design utiliza?**
*(Avaliando pelo contexto da arquitetura, acredito que a pergunta refere-se ao **Servidor de Cálculos**)*
**Resposta:** O Servidor de Cálculos utiliza o protocolo de mensagem **JSON-RPC** trafegado através de Sockets TCP.

**3. Qual tecnologia de comunicação ou servidor de design utiliza?**
*(Considerando que seja uma complementação das perguntas acima para o **Servidor de Cálculos**)*
**Resposta:** O Servidor de Cálculos utiliza **Sockets TCP/IP** brutos (*Raw Sockets*) como tecnologia de comunicação base.

**4. Qual estilo arquitetônico do projeto web api implementado para expor suas funcionalidades?**
**Resposta:** O projeto `web_api` expõe suas funcionalidades seguindo o estilo arquitetônico **REST** (Representational State Transfer) utilizando o Spring Boot (WebMVC) para criar os endpoints HTTP.
