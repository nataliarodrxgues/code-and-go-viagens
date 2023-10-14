CREATE DATABASE codeandgo;
USE codeandgo;

CREATE TABLE Clientes (
id_Cliente VARCHAR(10) PRIMARY KEY,
CPFCliente VARCHAR(15),
NomeCliente VARCHAR(255),
TelefoneCliente VARCHAR(20),
EmailCliente VARCHAR(255) NOT NULL,
SenhaCliente VARCHAR(255) NOT NULL,
EnderecoCliente VARCHAR(255)
);

CREATE TABLE Pedidos (
id_pedido VARCHAR(10) PRIMARY KEY,
id_Cliente INT,
NomeDestino VARCHAR(255),
NomePromocao VARCHAR(255),
StatusPedido VARCHAR(20),
ValorCompra DECIMAL(10, 2)
);

CREATE TABLE Destinos (
id_destino VARCHAR(10) PRIMARY KEY,
NomeDestino VARCHAR (255),
CodigoDestino VARCHAR(10),
CodigoReserva VARCHAR(10)
);

CREATE TABLE Promocoes (
id_promo VARCHAR(10) PRIMARY KEY,
PromoViagens VARCHAR(255),
PromoPacotes VARCHAR(255),
CodigoPacotes VARCHAR(10),
CodigoViagens VARCHAR(10),
CodigoReserva VARCHAR(10)
);

CREATE TABLE Contatos (
id_Contato VARCHAR(10) PRIMARY KEY,
NomeContato VARCHAR(255),
EmailContato VARCHAR(255),
AssuntoContato VARCHAR(255),
MensagemContato TEXT
);
