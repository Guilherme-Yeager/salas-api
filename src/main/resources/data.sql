INSERT INTO sala (nome, capacidade, status)
    VALUES
        ('Sala de Situação', 20, 'DISPONIVEL'),
        ('Sala de Reunião', 40, 'DISPONIVEL'),
        ('Sala de Espera', 15, 'DISPONIVEL');

INSERT INTO reserva(hora_inicio, hora_fim, data_reserva, id_sala)
    VALUES
        ('08:00', '10:00', '2026-01-07', 1),
        ('05:00', '08:30', '2026-02-15', 2);