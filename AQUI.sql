create database biblioteca;
use biblioteca; 

create table emprestimo (
aluno bigint(10) default null,
livro bigint(255) default NULL,
id bigint(255) NOT NULL AUTO_INCREMENT,
dataEmprestimo date,
dataDevolucao date,
primary key(id),
key `alunos` (`aluno`),
constraint `emprestimo_ibfk_1` foreign key (`aluno`) references `alunos`(`id`),
constraint `emprestimo_ibfk_2` foreign key (`livro`) references `livro` (`id`)
);

CREATE TABLE `livro` (
  `aluno` bigint(255) DEFAULT NULL,
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `nome` char(255) DEFAULT NULL,
  `editora` char(255) DEFAULT NULL,
  `autor` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alunos` (`aluno`),
  CONSTRAINT `equipamentos_ibfk_1` FOREIGN KEY (`aluno`) REFERENCES `alunos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `alunos` (
  `id` bigint(14) NOT NULL AUTO_INCREMENT,
  `turma` varchar(25) DEFAULT NULL,
  `nome` varchar(40) DEFAULT NULL,
  `endereco` varchar(35) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

SELECT nome, id FROM alunos;
SELECT aluno, livro FROM emprestimo;
