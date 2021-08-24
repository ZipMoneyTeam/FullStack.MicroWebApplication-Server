DROP TABLE USER;

CREATE TABLE USER (
                        ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
                        FIRST_NAME VARCHAR2(255) DEFAULT NULL,
                        LAST_NAME VARCHAR2(255) DEFAULT NULL,
                        PRIMARY KEY (ID));

DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;
