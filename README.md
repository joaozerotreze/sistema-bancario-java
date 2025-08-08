# Sistema Bancário Básico em Java

## Descrição do Projeto

Este projeto é uma aplicação Java que simula um sistema bancário básico construído para consolidar os principais conceitos da Programação Orientada a Objetos (POO), tais como herança, encapsulamento, polimorfismo, abstração e reuso de código.

A aplicação permite operações comuns de um banco como:

- Criação de clientes e contas (Conta Corrente)
- Depósitos e saques
- Transferências via PIX entre contas
- Visualização de extrato bancário (histórico de transações)

O projeto utiliza boas práticas de programação e estruturação de código, com potencial de evolução para incluir investimentos e outros tipos de contas.

---

## Tecnologias Utilizadas

- Java 11+ (ou superior)
- APIs padrão do Java (`java.util`, `java.time`, etc.)
- Conceitos de POO: encapsulamento, herança, polimorfismo
- API Stream (opcional para manipulação de coleções)
- Entrada de dados via console (`Scanner`)

---

## Estrutura do Projeto

src/
├── model/
│ ├── Cliente.java
│ ├── Conta.java (classe abstrata)
│ ├── ContaCorrente.java
│ ├── Transacao.java
│ └── enums/ (se aplicável)
├── service/ (lógica de negócio e operações)
├── repository/ (persistência em memória)
└── SistemaBancarioApp.java (classe principal com o menu interativo)


---

## Funcionalidades

1. **Criar Cliente e Conta Corrente:**  
   Permite cadastrar um novo cliente e criar uma conta corrente associada.

2. **Depósito:**  
   Depositar valores na conta do cliente.

3. **Saque:**  
   Retirar valores da conta, respeitando saldo disponível.

4. **Transferência via PIX:**  
   Transferir dinheiro entre contas utilizando o mecanismo de PIX simplificado.

5. **Visualização de Extrato:**  
   Mostrar o histórico completo de transações e saldo atual da conta.

---

## Como Executar o Projeto

1. Clone o repositório para sua máquina local:


2. Navegue até o diretório do projeto:


3. Compile todas as classes Java:


4. Execute a classe principal:


5. Siga as instruções do menu no console para usar o sistema.

---

## Exemplos de Uso

- Criar um cliente chamado "Maria Silva" com conta número "12345".
- Realizar depósito de R$1000,00 na conta "12345".
- Sacar R$200,00 da conta "12345".
- Transferir R$100,00 da conta "12345" para a conta "67890".
- Visualizar o extrato da conta "12345".

---

## Próximos Passos / Evoluções

- Implementar outros tipos de conta (Conta Poupança, Conta Investimento).
- Adicionar gerenciamento de investimentos financeiros.
- Persistência real com banco de dados.
- Interface gráfica (GUI) para melhor interação com o usuário.
- Tratamento avançado de erros e exceções.
- Uso de Lombok para redução do boilerplate.
- Uso de Records para classes imutáveis simples.
- Testes automatizados (JUnit).

---

## Sobre o Autor

Desenvolvido como projeto de estudo para fortalecer conhecimentos em Java e programação orientada a objetos.

---

*Obrigado por acompanhar este projeto!*
