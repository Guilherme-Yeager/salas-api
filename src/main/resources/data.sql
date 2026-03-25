INSERT INTO sala (nome, capacidade, status)
    VALUES
        ('Sala de Situação', 20, 'DISPONIVEL'),
        ('Sala de Reunião', 40, 'DISPONIVEL'),
        ('Sala de Espera', 15, 'DISPONIVEL');

INSERT INTO reserva(hora_inicio, hora_fim, data_reserva, id_sala)
    VALUES
        ('08:00', '10:00', '2026-01-07', 1),
        ('05:00', '08:30', '2026-02-15', 2);

INSERT INTO usuario (nome, email, senha, role)
    VALUES
        ('Guilherme Lima Santos', 'guilh2rm2lima@gmail.com', '$2a$12$js14gvHLTDqRRz8y/87fcu.vYPujt2tTDimDSK7kkvTl2ySMu/Scm', 'GESTOR'),
        ('José Gilson Santos', 'jose.gilson60@gmail.com', '$2a$12$js14gvHLTDqRRz8y/87fcu.vYPujt2tTDimDSK7kkvTl2ySMu/Scm', 'PARTICIPANTE');