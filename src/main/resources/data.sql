INSERT INTO users (user_name, user_password, version, user_active, created_on) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', 1, 1, CONVERT(datetime, '28/04/2018 00:00:00', 103));
INSERT INTO roles (role_name,version, created_on) VALUES ( 'ROLE_USER',1, CONVERT(datetime, '28/04/2018 00:00:00', 103));
INSERT INTO roles (role_name, version, created_on) VALUES ( 'ROLE_ADMIN',1,CONVERT(datetime, '28/04/2018 00:00:00', 103));
INSERT INTO user_role (user_id, role_id) VALUES (1, 6);
INSERT INTO user_role (user_id, role_id) VALUES (1, 5);


-- INSERT INTO users (user_name, user_password, version, user_active, created_on)
-- VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.', 1, 1, "2018-01-01 00:00:00");
-- INSERT INTO roles (role_name,version, created_on) VALUES ( 'ROLE_USER',1, "2018-01-01 00:00:00");
-- INSERT INTO roles (role_name, version, created_on) VALUES ( 'ROLE_ADMIN',1, "2018-01-01 00:00:00");
-- INSERT INTO user_role (user_id, role_id) VALUES (1, 6);
-- INSERT INTO user_role (user_id, role_id) VALUES (1, 5);
