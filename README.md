# API de Sugestão de Receitas com IA GEMINI!

Este projeto é uma API REST desenvolvida com Java e Spring Boot para sugerir receitas culunárias com base nos produtos cadastros em uma "geladeira virtual"




## Variáveis de Ambiente

Para rodar esta aplicação, é necessário:

Java: JDK 17 ou superior.

Maven: Versão 3.4.6 ou superior.

Git: Para clonar o repositório.





##  Como Configurar o Projeto

1. Clone o Repositório

```bash
git clone https://github.com/lucascidade/receipesapi.git

```

2. Baixe as dependências
Caso não tenha o Gradle instalado no seu sistema, use o wrapper (certifique que está dentro da pasta clonada):
```bash
./mvn build

```
Caso tenha o Gradle no seu sistema

```bash
mvn build
```

3. Execute o Projeto
```bash
./mvn run
```

## Documentação da API

#### Cadastrar Produtos

```http
  POST /products
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `String` | **Obrigatório.** nome do produto
| `category` | `Category` | **Obrigatório.**  categoria do produto
| `quantity` | `Integer` | **Obrigatório.**  quantidade do produto


#### Listar Produtos

```http
  GET /list
```

#### Conferir Sugestão de Receitas

```http
  GET /recipes-ai
```




Desenvolvido por Lucas Cidade.
