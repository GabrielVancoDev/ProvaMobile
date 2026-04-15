# Cadastro de Produtos - Mobile

Este projeto consiste em um aplicativo Android desenvolvido utilizando **Java** e **Room Database**, com o objetivo de realizar o cadastro e a listagem de produtos de forma simples e funcional.

--- 

##  Funcionalidades

###  Cadastro de Produto
- Nome do produto
- Código do produto (alfanumérico)
- Preço (em reais)
- Quantidade em estoque

###  Validações Implementadas
- Nenhum campo pode ser deixado em branco
- O preço deve ser:
  - Numérico
  - Positivo
  - Com até 2 casas decimais
- A quantidade deve ser:
  - Número inteiro
  - Positivo

---

###  Listagem de Produtos
- Exibição dos produtos cadastrados
- Mostra:
  - Nome
  - Código
  - Preço formatado (R$)
- Botão para retornar à tela de cadastro

---

##  Armazenamento de Dados

O aplicativo utiliza o **Room Database** para armazenamento local.

## 📱 Telas do Aplicativo

### 🟢 Tela 1: Cadastro (MainActivity)
- Formulário de entrada
- Validação de dados
- Botão para salvar produto
- Botão para visualizar lista

### 🔵 Tela 2: Listagem (ReportActivity)
- RecyclerView com os produtos cadastrados
- Botão de retorno

---

## 🛠️ Tecnologias Utilizadas

- Java
- Android Studio
- Room Database
- RecyclerView
- XML (Layouts)
