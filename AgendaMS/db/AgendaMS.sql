/* AgendaMS - 2018 - 2020 ***************** 
 * Autor: Marcos Willian de Souza
 * Github: www.github.com/marcosws
 * E-Mail: marcosws@ymail.com     
 * Banco de Dados SQLite    */
 
PRAGMA foreign_keys=OFF;

DROP TABLE IF EXISTS Conta;
DROP TABLE IF EXISTS Contato;
DROP TABLE IF EXISTS Usuario;

PRAGMA foreign_keys=ON;

CREATE TABLE Usuario(
	IdUsuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	IdConta INTEGER NOT NULL,
	Nome VARCHAR(100) NOT NULL,
	Login VARCHAR(40) UNIQUE,
	Senha VARCHAR(512) NOT NULL,
	FOREIGN KEY(IdConta) 
	REFERENCES Conta(IdConta)
);

CREATE TABLE Contato(
	IdContato INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
	IdUsuario INTEGER NOT NULL,
	Nome VARCHAR(100) NOT NULL,
	Cpf VARCHAR(11) NOT NULL,
	Telefone VARCHAR(10) NOT NULL,
	Celular VARCHAR(11) NOT NULL,
	Email VARCHAR(100) NOT NULL,
	Site VARCHAR(100) NOT NULL,
	CONSTRAINT fk_usuario 
	FOREIGN KEY(IdUsuario) 
	REFERENCES Usuario(IdUsuario) 
	ON DELETE CASCADE
);

CREATE TABLE Conta(
	IdConta INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	TipoConta VARCHAR(20) NOT NULL
);

INSERT INTO Conta(TipoConta) VALUES('Normal');
INSERT INTO Conta(TipoConta) VALUES('Administrativa');



