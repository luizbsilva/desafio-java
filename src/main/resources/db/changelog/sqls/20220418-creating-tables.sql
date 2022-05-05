CREATE TABLE PUBLIC.SUBSCRIPTION
(
    ID                        INT8         NOT NULL,
    CODE_SUBSCRIPTION      VARCHAR(255) NULL,
    STATUS   INT8         NOT NULL,
    CREATE_DATE     TIMESTAMP    NOT NULL,
    UPDATE_DATE     TIMESTAMP,
    ACTIVE          BOOLEAN,

    CONSTRAINT SUBSCRIPTION_PKEY PRIMARY KEY (ID)
);

CREATE SEQUENCE PUBLIC.SUBSCRIPTION_ID_SEQ
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;
ALTER TABLE PUBLIC.SUBSCRIPTION_ID_SEQ OWNER TO POSTGRES;
ALTER TABLE PUBLIC.SUBSCRIPTION ALTER COLUMN ID SET DEFAULT NEXTVAL('PUBLIC.SUBSCRIPTION_ID_SEQ'::REGCLASS);

CREATE TABLE PUBLIC.EVENT_HISTORY
(
    ID              INT8         NOT NULL,
    TYPE_EVENT      VARCHAR(255) NULL,
    ID_SUBSCRIPTION INT8         NOT NULL,
    CREATE_DATE     TIMESTAMP    NOT NULL,
    UPDATE_DATE     TIMESTAMP,
    ACTIVE          BOOLEAN,

    CONSTRAINT EVENT_HISTORY_PKEY PRIMARY KEY (ID),
    CONSTRAINT FK_SUBSCRIPTION FOREIGN KEY (ID_SUBSCRIPTION)
        REFERENCES PUBLIC.SUBSCRIPTION (ID) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE PUBLIC.EVENT_HISTORY_ID_SEQ
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;
ALTER TABLE PUBLIC.EVENT_HISTORY_ID_SEQ OWNER TO POSTGRES;
ALTER TABLE PUBLIC.EVENT_HISTORY
    ALTER COLUMN ID SET DEFAULT NEXTVAL('PUBLIC.EVENT_HISTORY_ID_SEQ'::REGCLASS);