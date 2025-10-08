# 🏦 Banking Exercise

Este projeto simula um sistema bancário com foco no **cadastro de cartões de crédito por cliente**, utilizando **arquitetura hexagonal** e **padrões de projeto (Design Patterns)** para garantir uma estrutura escalável, testável e de fácil manutenção.

## 🎯 Objetivo

Demonstrar a aplicação prática de conceitos avançados de arquitetura de software e design patterns em um cenário bancário, com foco em:

- Cadastro e gerenciamento de clientes
- Emissão e controle de cartões de crédito
- Separação clara entre camadas de negócio, aplicação e infraestrutura

## 🧱 Arquitetura

O projeto segue a **Arquitetura Hexagonal (Ports and Adapters)**, promovendo:

- **Isolamento da lógica de negócio** em relação a frameworks e tecnologias externas
- **Facilidade de testes** e substituição de componentes
- **Organização em camadas**:
  - **Domain**: entidades e regras de negócio
  - **Application**: casos de uso
  - **Adapters**: interfaces externas (ex: REST, banco de dados)
  - **Configuration**: setup de dependências e injeções

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Maven**
- **Arquitetura Hexagonal**
- **Design Patterns** (Factory, Strategy, etc.)
- **JPA / Hibernate**
- **Banco H2 (para testes locais)**

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/vit0ur/baking-exercice.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd baking-exercice
   ```
3. Execute o projeto com sua IDE ou via Maven:
   ```bash
   mvn spring-boot:run
   ```

## ✅ Funcionalidades

- Cadastro de clientes
- Emissão de cartões de crédito
- Validação de dados
- Persistência em banco de dados
- Testes unitários e de integração

## 📁 Estrutura de Pacotes

```
src/
├── domain/
│   ├── model/
│   └── service/
├── application/
│   └── usecase/
├── adapter/
│   ├── in/  (ex: controllers REST)
│   └── out/ (ex: repositórios)
└── config/
```

## 👨‍💻 Autor

**Jose Vitor Oliveira de Araujo**  
GitHub: https://github.com/vit0ur
