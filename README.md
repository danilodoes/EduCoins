# Aplicação desktop em Java: "EduCoins"
"EduCoins" foi desenvolvido durante um semestre para compor nota de avaliação semestral das matérias de Modelagem de Software e Programação de Soluções Computacionais, na Universidade São Judas Tadeu.
<br>

## Nesta aplicação foi empregado
<div align = "center">
  
- [x] Java
- [x] JavaFX
- [x] SceneBuilder
- [x] Apache NetBeans 17
- [x] MySQL
- [x] StarUML 
</div>

#### IMPORTANTE! 
1- Para que a aplicação funcione, você precisa fazer o clonde desse repositório e mover todos os arquivos para uma nova pasta chamada de "EduCoinsFx". Muitas funções na aplicação são chamadas através do diretório. </br></br>
2- O banco de dados foi construído de forma local e nativa (sem script), então para testar a aplicação, você deverá criar um banco de teste com essas mesmas infos (ou alterar o código conforme sua necessidade): </br>

    private String usuario = "root";
    private String senha = "root";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "educoins"; 
Para mais detalher, observe a classe "ConnectionFactory". Localizada no diretório " src/dao " na aplicação ou <a href="https://github.com/danilodoes/EduCoins/blob/main/src/main/java/dao/ConnectionFactory.java">clica aqui ;)</a> </br>
Para acessar a modelagem do banco e conferir a estrutura das tabelas <a href="https://drive.google.com/file/d/1Chfdy1J5YPfvENZuVAQvYHjfn8ewJ6GF/view?usp=sharing"> é só clicar aqui</a>.


## Objetivo
O aplicativo EduCoins, veio para atacar diretamente a evasão escolar no ensino público brasileiro.
Contando com a ajuda dos parceiros conveniados, essa solução simples, simula a vida pós acadêmica onde precisamos trabalhar para sermos recompensados com salários.
Aqui o estudante será "pago" ou "descontado" com cripto moedas, que chamamos de "EduCoins" (moedas de educação).
Existem diferentes maneiras do estudante adquirir "EduCoins", essas podem ser: ações sociais e comunitárias, 
atividades extracurriculares, trabalho e/ou pesquisa em casa, 
frequência em aula, testes, provas e muitos outros(seguindo instruções dos professores/educadores).
Essas moedas podem ser usadas para compra de diversos itens doados pelos parceiros ao final do ano letivo. 

#### Processo de desenvolvimento
  <a href ="https://padlet.com/danilosantos6362/a3-modelagem-de-software-jx9l7rj1ci9qe92k">Bastidores</a>
#### Projeto Destaque
<a href="https://drive.google.com/file/d/19SR5ZxnNTX8AS1LwoOUvISbCx_axoy0K/view?usp=sharing" target="_blank">Confira</a>

## Fluxo da Aplicação
Aqui você poderá entender o fluxo da aplicação através de suas telas, caso logado como: </br>
<a href="https://drive.google.com/drive/u/0/folders/14xSR6ACtYCNg9SuMNJjCfFnREcvXMm_g" targe="_blank">Aluno</a></br>
<a href="https://drive.google.com/drive/u/0/folders/1qdhpbTFf-KQWw3q9oK0-olK363v2VKsQ" targe="_blank">Educador</a></br>
<a href="https://drive.google.com/drive/u/0/folders/1-EOxoyiyROfj6WUw1_PT8YCUlaI_wGUX" targe="_blank">Administrador</a></br>
<a href="https://drive.google.com/file/d/136XHeo1_XzRzZT_CZzZX0bTKBCFHyx4o/view?usp=sharing" targe="_blank">Comum a todos os usuários</a>.


## Desenvolvido por
<ol>
<li>Gustavo Henrique da Silva</li>
<li>Danilo do Espirito Santo dos Santos</li>
<li>Marcio Aprigio Nascimento Souza</li>
<li>Ricardo Lucas Nascimento de Freitas</li>
<li>Felipe Saraiva dos Santos</li>
<li>Willian Antônio Padilha Junior</li>
<li>Caio Furlan Ramos</li>
<li>Lucius de Lima Chu</li>
</ol>


