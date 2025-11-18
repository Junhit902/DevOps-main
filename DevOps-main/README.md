# DevOps

Alunos:
César Almeida 222909\
Gustavo Tamezava 222226\
Thiago Honma 222628\
Vinícius Araújo 211973

## User Story escolhida para os testes e BDDs

### User Story
EU COMO Aluno
PRECISO/QUERO Ganhar desconto na mensalidade 
PARA/CASO Minha média global seja igual ou maior que o valor de corte.

### BDDs
#### BDD 1:
DADO QUE sou um aluno
E completei pelo menos 3 cursos
E minha média global é 8.0 ou maior
QUANDO solicito desconto
ENTÃO recebo 40% de desconto na mensalidade

#### BDD 2:
DADO QUE sou um aluno
E completei pelo menos 3 cursos
E minha média global está entre 7.0 e 7.9
QUANDO solicito desconto
ENTÃO recebo 20% de desconto na mensalidade

#### BDD 3:
DADO QUE sou um aluno
E completei pelo menos 3 cursos
E minha média global é menor que 7.0
QUANDO solicito desconto
ENTÃO não recebo desconto na mensalidade

#### BDD 4: 
DADO QUE sou um aluno
E completei menos de 3 cursos
QUANDO solicito desconto
ENTÃO recebo mensagem informando que preciso completar pelo menos 3 cursos para ter direito ao desconto
