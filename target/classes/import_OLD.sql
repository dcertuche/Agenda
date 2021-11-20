INSERT INTO `db_spring_boot_agenda`.`contacto` (`apellidos`, `celular`, `email`, `fecha_nacimiento`, `fecha_registro`, `nombre`, `nombre_completo`) 
VALUES ('certuche', '3113333322', 'diego@gmail.com', '1984-06-09', now(), 'diego', 'diego certuche');

INSERT INTO `db_spring_boot_agenda`.`contacto` (`apellidos`, `celular`, `email`, `fecha_nacimiento`, `fecha_registro`, `nombre`, `nombre_completo`) 
VALUES ('Alegria', '3113333322', 'ana@gmail.com', '2000-04-15', now(), 'Ana', 'Ana Alegria');

INSERT INTO `db_spring_boot_agenda`.`contacto` (`apellidos`, `celular`, `email`, `fecha_nacimiento`, `fecha_registro`, `nombre`, `nombre_completo`) 
VALUES ('certuche alegria', '', 'diego@gmail.com', '2015-09-26', now(), 'salome', 'salome certuche alegria');

INSERT INTO `db_spring_boot_agenda`.`contacto` (`apellidos`, `celular`, `email`, `fecha_nacimiento`, `fecha_registro`, `nombre`, `nombre_completo`) 
VALUES ('certuche alegria', '', 'diego@gmail.com', '2017-04-21', now(), 'luciana', 'luciana certuche alegria');

INSERT INTO usuario (username, password, enabled) VALUES ('diego' ,'12345', 1);
INSERT INTO usuario (username, password, enabled) VALUES ('felipe' ,'12345', 1);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);