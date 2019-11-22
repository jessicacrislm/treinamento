INSERT INTO tb_estado (id_estado, ds_sigla) values (1, 'MG');
INSERT INTO tb_estado (id_estado, ds_sigla) values (2, 'SP');
INSERT INTO tb_estado (id_estado, ds_sigla) values (3, 'RJ');

INSERT INTO tb_cidade (id_cidade, id_estado, ds_nome) values (1, 1, 'Belo Horizonte');
INSERT INTO tb_cidade (id_cidade, id_estado, ds_nome) values (2, 1, 'Lagoa Santa');
INSERT INTO tb_cidade (id_cidade, id_estado, ds_nome) values (3, 2, 'Niterói');
INSERT INTO tb_cidade (id_cidade, id_estado, ds_nome) values (4, 2, 'Petrópolis');
INSERT INTO tb_cidade (id_cidade, id_estado, ds_nome) values (5, 3, 'Santos');
INSERT INTO tb_cidade (id_cidade, id_estado, ds_nome) values (6, 3, 'Diadema');

INSERT INTO tb_bairro (id_bairro, id_cidade, ds_nome) values (1, 1, 'Centro');
INSERT INTO tb_bairro (id_bairro, id_cidade, ds_nome) values (2, 1, 'Funcionários');
INSERT INTO tb_bairro (id_bairro, id_cidade, ds_nome) values (3, 2, 'Visão');
INSERT INTO tb_bairro (id_bairro, id_cidade, ds_nome) values (4, 3, 'Ingá');
INSERT INTO tb_bairro (id_bairro, id_cidade, ds_nome) values (5, 4, 'Retiro');
INSERT INTO tb_bairro (id_bairro, id_cidade, ds_nome) values (6, 5, 'Estuário');
INSERT INTO tb_bairro (id_bairro, id_cidade, ds_nome) values (7, 6, 'Centro');

INSERT INTO tb_endereco (id_endereco, en_tipo_local, ds_logradouro) values (1, 'Avenida', 'Afonso Pena'); --bh
INSERT INTO tb_endereco (id_endereco, en_tipo_local, ds_logradouro) values (2, 'Rua', 'Tupis'); --tupis
INSERT INTO tb_endereco (id_endereco, en_tipo_local, ds_logradouro) values (3, 'Alameda', 'dos Cedros'); --ls
INSERT INTO tb_endereco (id_endereco, en_tipo_local, ds_logradouro) values (4, 'Rua', 'Tiradentes'); --niteroi
INSERT INTO tb_endereco (id_endereco, en_tipo_local, ds_logradouro) values (5, 'Estrada', 'Fernandes Vieira'); -- pe
INSERT INTO tb_endereco (id_endereco, en_tipo_local, ds_logradouro) values (6, 'Praça', 'da Igreja'); -- sa
INSERT INTO tb_endereco (id_endereco, en_tipo_local, ds_logradouro) values (7, 'Rua', 'Avaré'); --di

INSERT INTO tb_complemento (id_complemento, id_endereco, ds_descricao, nm_numero) values (1, 1, 'Edifício Sulacap', 981);
INSERT INTO tb_complemento (id_complemento, id_endereco, ds_descricao, nm_numero) values (2, 1, 'Residencial', 1556);
INSERT INTO tb_complemento (id_complemento, id_endereco, ds_descricao, nm_numero) values (3, 2, 'Casa', 58);
INSERT INTO tb_complemento (id_complemento, id_endereco, ds_descricao, nm_numero) values (4, 3, 'Casa dos fundos', 445);
INSERT INTO tb_complemento (id_complemento, id_endereco, ds_descricao, nm_numero) values (5, 4, 'Apto 303', 138);
INSERT INTO tb_complemento (id_complemento, id_endereco, ds_descricao, nm_numero) values (6, 5, '7o andar', 390);
INSERT INTO tb_complemento (id_complemento, id_endereco, ds_descricao, nm_numero) values (7, 6, '14o andar', 0);
INSERT INTO tb_complemento (id_complemento, id_endereco, ds_descricao, nm_numero) values (8, 7, 'Sala 3', 78);

INSERT INTO tb_cep (id_cep, id_endereco, nm_numero) values (1, 1, 30130002);
INSERT INTO tb_cep (id_cep, id_endereco, nm_numero) values (2, 1, 30130008);
INSERT INTO tb_cep (id_cep, id_endereco, nm_numero) values (3, 2, 30190060);
INSERT INTO tb_cep (id_cep, id_endereco, nm_numero) values (4, 3, 33400000);
INSERT INTO tb_cep (id_cep, id_endereco, nm_numero) values (5, 4, 24210510);
INSERT INTO tb_cep (id_cep, id_endereco, nm_numero) values (6, 5, 25680388);
INSERT INTO tb_cep (id_cep, id_endereco, nm_numero) values (7, 6, 11015300);
INSERT INTO tb_cep (id_cep, id_endereco, nm_numero) values (8, 7, 09920350);

INSERT INTO tb_endereco_bairro (id_endereco, id_bairro) values (1, 1); 
INSERT INTO tb_endereco_bairro (id_endereco, id_bairro) values (2, 2); 
INSERT INTO tb_endereco_bairro (id_endereco, id_bairro) values (3, 3); 
INSERT INTO tb_endereco_bairro (id_endereco, id_bairro) values (4, 4); 
INSERT INTO tb_endereco_bairro (id_endereco, id_bairro) values (5, 5); 
INSERT INTO tb_endereco_bairro (id_endereco, id_bairro) values (6, 6); 
INSERT INTO tb_endereco_bairro (id_endereco, id_bairro) values (7, 7); 