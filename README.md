# Projeto-teste-escola-Backend
Sistema onde liga o projeto de pessoas, escolas(que contem um sistema de alunos juntos) e o projeto de professores, eles se entrelaçam pelo feing client.


Requisições:

  Pessoas: ("http://localhost:8011/pessoas/pessoas")
  {
    "nome" : "Nome",
    "idade" : 0,
    "cpf" : "000.000.000-00",
    "cargo" : "Cargo",
    "trabalho" : "Trabalho"
  }
  
  Escolas: ("http://localhost:8011/schools/escolas")
  {
    "nome" : "Nome",
    "endereco" : "Endereço",
    "diretor" : "Diretor(a)",
    "secretaria" : "Secretaria(o)",
    "coordenador" : "Coordenador(a)"
  }
  
  Salas: ("http://localhost:8011/schools/escolas/{IdDeUmaEscolaCriada}/salas")
  {
    "name":"3001"
  }

  Alunos: ("http://localhost:8011/schools/escolas/{escolaID}/alunos")
  {
    "id" : "0f0f0f0f0f0f0f0f0f0f0f", //Id da pessoa do projeto de pessoas
    "name" : "Nome",
    "idade" : 0,
    "responsavelId" : "0r0r0r0r0r0r0r0r0r", //Id de uma pessoa do projeto de pessoas
    "endereco" : "Endereço",
    "telefone" : "000000000",
    "salaId" : "640673608d9ecb0711b21725", //Id de uma sala ja criada
    "numeroDeFaltas" : 0,
    "dependencias" : ["Portugues", "Matemática"],
    "notas" : [9.3,8.9,10]
  }

  Professores: ("http://localhost:8011/professores/professores")
  {
    "id":"0p0p0p0p0p0p0p0p0p", //Id de uma pessoa ja criada
    "materia":"Português",
    "escolaId":"0e0e0e0e0e0e0e0e0e" //Id de uma escola ja criada
  }
