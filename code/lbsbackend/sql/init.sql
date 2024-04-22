CREATE DATABASE LBS CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS LIBRARY
(
    ID           BIGINT PRIMARY KEY COMMENT 'ID',
    NAME         VARCHAR(64) NOT NULL COMMENT 'LIBRARY NAME',
    CREATED_BY   VARCHAR(64) COMMENT 'CREATED BY',
    CREATED_TIME TIMESTAMP COMMENT 'CREATED TIME'
)
    COMMENT 'LIBRARY TABLE';
CREATE TABLE IF NOT EXISTS USER
(
    ID           BIGINT PRIMARY KEY COMMENT 'ID',
    USER_NAME    VARCHAR(64) NOT NULL COMMENT 'USER NAME',
    CREATED_BY   VARCHAR(64) COMMENT 'CREATED BY',
    CREATED_TIME TIMESTAMP COMMENT 'CREATED TIME'
)
    COMMENT 'USER TABLE';
CREATE TABLE IF NOT EXISTS BOOK
(
    ID              BIGINT PRIMARY KEY COMMENT 'ID',
    CATEGORY_ID     BIGINT COMMENT 'CATEGORY_ID',
    TITLE           VARCHAR(256) COMMENT 'TITLE',
    SUMMARY         VARCHAR(512) COMMENT 'SUMMARY',
    IMAGE           VARCHAR(256) COMMENT 'IMAGE',
    AUTHOR          VARCHAR(256) COMMENT 'AUTHOR',
    SUBJECT         VARCHAR(64) COMMENT 'SUBJECT',
    FORMAT          VARCHAR(64) COMMENT 'FORMAT',
    PUBLISHER       VARCHAR(256) COMMENT 'PUBLISHER',
    PUBLISHED_DATE  TIMESTAMP COMMENT 'PUBLISHED DATE',
    LANGUAGE        VARCHAR(64) COMMENT 'LANGUAGE',
    COUNTRY         VARCHAR(64) COMMENT 'COUNTRY',
    ISBN            VARCHAR(64) COMMENT 'ISBN',
    CREATED_BY      VARCHAR(64) COMMENT 'CREATED BY',
    CREATED_TIME    TIMESTAMP COMMENT 'CREATED TIME'
) COMMENT 'BOOK TABLE';
CREATE TABLE IF NOT EXISTS BOOK_PRINTING
(
    ID              BIGINT PRIMARY KEY COMMENT 'ID',
    BOOK_ID         BIGINT COMMENT 'BOOK ID',
    LIBRARY_ID      BIGINT COMMENT 'LIBRARY ID',
    REAL_LIBRARY_ID BIGINT COMMENT 'REAL LIBRARY ID',
    SHELF_ID        BIGINT COMMENT 'SHELF_ID',
    REAL_SHELF_ID   BIGINT COMMENT 'REAL SHELF ID',
    STATUS          VARCHAR(16) COMMENT 'STATUS',
    EXP_AVAILABLE_DATE TIMESTAMP COMMENT 'EXPECTED AVAILABLE DATE',
    CREATED_BY      VARCHAR(64) COMMENT 'CREATED BY',
    CREATED_TIME    TIMESTAMP COMMENT 'CREATED TIME'
) COMMENT 'BOOK PRINTING TABLE';
CREATE TABLE IF NOT EXISTS CATEGORY
(
    ID           BIGINT PRIMARY KEY COMMENT 'ID',
    PARENT_ID    BIGINT COMMENT 'PARENT_ID',
    LIBRARY_ID   BIGINT COMMENT 'LIBRARY_ID',
    NAME         VARCHAR(256) COMMENT 'CATEGORY NAME',
    CREATED_BY   VARCHAR(64) COMMENT 'CREATED BY',
    CREATED_TIME TIMESTAMP COMMENT 'CREATED TIME'
) COMMENT 'CATEGORY TABLE';
CREATE TABLE IF NOT EXISTS BOOK_REQUEST
(
    ID             BIGINT PRIMARY KEY COMMENT 'ID',
    LIBRARY_ID     BIGINT COMMENT 'LIBRARY_ID',
    TITLE          VARCHAR(256) COMMENT 'TITLE',
    REASON         VARCHAR(256) COMMENT 'REASON',
    IMAGE          VARCHAR(256) COMMENT 'IMAGE',
    AUTHOR         VARCHAR(256) COMMENT 'AUTHOR',
    SUBJECT        VARCHAR(64) COMMENT 'SUBJECT',
    FORMAT         VARCHAR(64) COMMENT 'FORMAT',
    PUBLISHER      VARCHAR(256) COMMENT 'PUBLISHER',
    PUBLISHED_DATE TIMESTAMP COMMENT 'PUBLISHED DATE',
    LANGUAGE       VARCHAR(64) COMMENT 'LANGUAGE',
    COUNTRY        VARCHAR(64) COMMENT 'COUNTRY',
    ISBN           VARCHAR(64) COMMENT 'ISBN',
    STATUS         VARCHAR(16) COMMENT 'STATUS',
    CREATED_BY     VARCHAR(64) COMMENT 'CREATED BY',
    CREATED_TIME   TIMESTAMP COMMENT 'CREATED TIME',
    VALIDATED_BY   VARCHAR(64) COMMENT 'VALIDATED BY',
    VALIDATED_TIME TIMESTAMP COMMENT 'VALIDATED TIME'
) COMMENT 'BOOK REQUEST TABLE';
CREATE TABLE IF NOT EXISTS RESERVATION
(
    ID                   BIGINT PRIMARY KEY COMMENT 'ID',
    LIBRARY_ID           BIGINT COMMENT 'LIBRARY_ID',
    BOOK_ID              BIGINT COMMENT 'BOOK_ID',
    TARGET_LIBRARY_ID    BIGINT COMMENT 'TARGET_LIBRARY_ID',
    USER_ID              BIGINT COMMENT 'USER_ID',
    STATUS               VARCHAR(16) COMMENT 'STATUS',
    EXPECTED_PICKUP_TIME TIMESTAMP COMMENT 'EXPECTED PICKUP TIME',
    REAL_PICKUP_TIME     TIMESTAMP COMMENT 'REAL PICKUP TIME',
    CREATED_BY           VARCHAR(64) COMMENT 'CREATED BY',
    CREATED_TIME         TIMESTAMP COMMENT 'CREATED TIME'
) COMMENT 'BOOK RESERVATION TABLE';
CREATE INDEX CATEGORY_LIB_PARENT ON CATEGORY (LIBRARY_ID, PARENT_ID);
