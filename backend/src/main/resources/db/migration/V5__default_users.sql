INSERT INTO user_data (name, lastname, username, email) VALUES ('Juan', 'Perez', 'juancito', 'user01@user.com');
INSERT INTO user_credentials (
    user_email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, role_id)
    VALUES ('user01@user.com', '$2a$10$.EUPvOFWU9HitYkH2q0eZeci8W9g9kCz8skMXmUVwCCexGgHkqdYu', 't', 't', 't', 't', 1
    );

INSERT INTO user_data (name, lastname, username, email) VALUES ('Roberto', 'Gomez', 'robertito', 'user02@user.com');
INSERT INTO user_credentials (
    user_email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, role_id)
    VALUES ('user02@user.com', '$2a$10$.EUPvOFWU9HitYkH2q0eZeci8W9g9kCz8skMXmUVwCCexGgHkqdYu', 't', 't', 't', 't', 1
    );

INSERT INTO user_data (name, lastname, username, email) VALUES ('Federico', 'Gonzalez', 'fede', 'user03@user.com');
INSERT INTO user_credentials (
    user_email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, role_id)
    VALUES ('user03@user.com', '$2a$10$.EUPvOFWU9HitYkH2q0eZeci8W9g9kCz8skMXmUVwCCexGgHkqdYu', 't', 't', 't', 't', 1
    );

INSERT INTO user_data (username, email) VALUES ('solousername', 'user04@user.com');
INSERT INTO user_credentials (
    user_email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, role_id)
    VALUES ('user04@user.com', '$2a$10$.EUPvOFWU9HitYkH2q0eZeci8W9g9kCz8skMXmUVwCCexGgHkqdYu', 't', 't', 't', 't', 1
    );