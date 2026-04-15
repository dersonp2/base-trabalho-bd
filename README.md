# Exemplo de Trabalho de Banco de Dados - 2ª Nota

Este repositório serve como modelo de referência para o trabalho prático da disciplina de Banco de Dados. O objetivo é demonstrar a integração de uma aplicação (Java e Python) com um banco de dados relacional, realizando operações de CRUD e consultas complexas.

## 📌 Sobre o Projeto
O tema escolhido para este exemplo foi um **Sistema de Gestão de usuarios**, bem simples.

## 🛠️ Tecnologias Utilizadas
* **Linguagens:** Java 17 / Python 3.10
* **Banco de Dados:** PostgreSQL
* **Drivers de Conexão:** JDBC (Java) / `jdbc:postgresql` ou `psycopg2` (Python)
* **Interface:** Console (Terminal) - *[Se houver GUI, mencione aqui]*

## 📂 Estrutura do Repositório
A organização das pastas segue rigorosamente as exigências do professor:

* `/diagrama`: Modelo Entidade-Relacionamento (DER).
* `/ddl`: Scripts de criação (CREATE TABLE, Constraints).
* `/dml`: Scripts de manipulação (INSERT, UPDATE, DELETE).
* `/dql`: Scripts de consulta (SELECT, JOINs, Filtros).
* `/projeto`: Código-fonte dividido por linguagem (Java e Python).

---

## 📸 Demonstração (Prints do Sistema)

### 1. Tela de Login
> ![Login](https://via.placeholder.com/600x200?text=Print+da+Tela+de+Login)

### 2. Menu Principal e Operações CRUD
> ![Menu](https://via.placeholder.com/600x300?text=Print+do+Menu+Principal)

### 3. Consulta Complexa (Inner/Left Join)
> ![Join](https://via.placeholder.com/600x200?text=Print+do+Resultado+da+Consulta+com+Join)

---

## 📺 Vídeo Demonstrativo
Confira a explicação detalhada do sistema e do código no link abaixo:
👉 **[ASSISTIR VÍDEO NO YOUTUBE/DRIVE](#)**

---

## 🚀 Como Executar o Projeto

### Configuração do Banco de Dados
1. Execute o script contido em `/ddl/script_criacao.sql`.
2. (Opcional) Popule o banco com `/dml/script_insercao.sql`.

### Executando em Java
1. Importe o projeto na sua IDE (VS Code, IntelliJ ou Eclipse).
2. Certifique-se de ter o driver JDBC no classpath.
3. Execute a classe `Main.java`.

### Executando em Python
1. Instale as dependências: `pip install -r requirements.txt`.
2. Execute o comando: `python main.py`.

---

## 📄 Regras de Negócio e Consultas Complexas
O sistema realiza uma consulta complexa etc...:
* **INNER JOIN**: Para listar xxxx.
* **LEFT JOIN**: Para listar xxxx.

---

## 👤 Autor
* **Professor Anderson Costa** - [andersoncosta@unifsa.com.br](mailto:andersoncosta@unifsa.com.br)
* Centro Universitário Santo Agostinho (UNIFSA)
