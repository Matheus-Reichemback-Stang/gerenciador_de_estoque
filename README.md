# Gerenciador de Estoque

## Sobre o projeto:
Este projeto consiste em um **Sistema de Gerenciamento de Estoque**, desenvolvido com foco no setor de alimentos. A ferramenta oferece diversas funcionalidades projetadas para proporcionar 
uma experiência de gerenciamento prática, intuitiva e eficiente.

Ao iniciar o software, o usuário é recebido com uma tela de boas-vindas. Em seguida, ele pode navegar livremente pelas opções disponíveis para manipular o estoque. Todas as informações são armazenadas em um banco de dados, 
garantindo persistência e evitando a perda de dados durante o uso.

O sistema é estruturado com base no modelo CRUD (Create, Read, Update, Delete). Cada operação principal possui uma página dedicada, sendo elas:

 * Página para **Cadastrar** produtos
 * Página para **Pesquisar** produtos
 * Página para **Atualizar** informações
 * Página para **Deletar** produtos

Além dessas funcionalidades, o sistema conta com uma página de **Dashboard**, onde são apresentados gráficos gerados a partir dos dados armazenados no banco. 
Isso permite ao usuário visualizar informações importantes e realizar análises mais completas sobre seu estoque.

---

## Como Rodar o Projeto
 1. Faça o `git clone` deste repositório.
 2. Abra a pasta do projeto na sua IDE.
 3. Encontre a classe **MainApplication** seguindo `src/java/projeto/gerenciadordeestoque/MainApplication.class`.
 4. Execute a classe `MainApplication.class` e instale as dependências que forem requisitas.

---
### Dependências para Rodar
* Ter alguma IDE que seja possível programar em java.
* Ter o banco de dados PostgreSQL instalado.
* Ter o JavaFX instalado (Geralmente a própria IDE já instala ele).

---
 ## Tecnologias usadas:
 * Java - JDK (24.0.2)
 * JavaFX SDK (21.0.6)
 * CSS
 * Scene Builder
 * PostgreSQL (18.1)
---

### Sobre as Tecnologias:

#### Java
O projeto foi desenvolvido em Java, uma linguagem robusta, orientada a objetos e amplamente utilizada no mercado. Java oferece alta portabilidade através da JVM (Java Virtual Machine), além de possuir excelente desempenho e uma vasta comunidade.
Foi escolhida para este projeto por sua segurança, estabilidade e pela facilidade em estruturar sistemas que exigem organização, escalabilidade e manutenção eficiente — características essenciais para um gerenciador de estoque.

#### JavaFX
A interface gráfica do sistema foi construída utilizando JavaFX, uma biblioteca poderosa para desenvolvimento de aplicações desktop modernas.
O JavaFX foi adotado devido à sua capacidade de criar interfaces responsivas, limpas e altamente customizáveis, além de oferecer componentes visuais 
robustos e integração simples com CSS. Ele permite uma melhor experiência ao usuário, tornando o sistema mais intuitivo e visualmente agradável.

#### Scene Builder
O Scene Builder foi utilizado para projetar e montar as telas do sistema por meio de uma interface gráfica, sem a necessidade de escrever código manualmente para os layouts.
Ele agilizou o desenvolvimento da UI, permitindo que a estrutura visual fosse criada de forma rápida e organizada. Além disso, facilita o ajuste de componentes, tornando todo o processo mais produtivo e reduzindo erros visuais no projeto.

#### CSS
O CSS foi utilizado para estilizar as telas construídas em JavaFX, permitindo personalizar cores, fontes, espaçamento e aparência geral dos componentes.
O uso do CSS trouxe um design mais profissional ao sistema, deixando a interface mais atrativa e coerente visualmente. Além disso, separar o estilo do código 
facilita a manutenção e permite alterar a identidade visual rapidamente sem modificar a lógica da aplicação.

#### PostgreSQL
Os dados do projeto são armazenados em um banco PostgreSQL, um dos mais confiáveis e completos sistemas de gerenciamento de banco de dados relacionais disponíveis.
Ele foi escolhido por sua estabilidade, segurança, excelente desempenho e suporte a consultas complexas. O PostgreSQL garante a persistência das informações do estoque, 
evitando perda de dados e oferecendo organização adequada para operações como cadastro, pesquisa, atualização e exclusão.
