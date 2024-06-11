INSERT INTO role (name) VALUES ('USER');
INSERT INTO role (name) VALUES ('ORGANIZER');

INSERT INTO permissions (name) VALUES ('READ');
INSERT INTO permissions (name) VALUES ('EDIT_EVENT');
INSERT INTO permissions (name) VALUES ('DELETE_EVENT');
INSERT INTO permissions (name) VALUES ('CREATE_EVENT');
INSERT INTO permissions (name) VALUES ('COMMENT_EVENT');

INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 1);
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 5);
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 1);
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 2);
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 3);
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 4);
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 5);