CREATE TABLE IF NOT EXISTS app_user (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
    );

INSERT INTO app_user (username, password) VALUES ('Justin', 'Justin1301');
INSERT INTO app_user (username, password) VALUES ('user2', 'password2');
