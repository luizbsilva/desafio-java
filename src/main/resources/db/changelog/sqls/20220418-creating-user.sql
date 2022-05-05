CREATE TABLE public.user_data (
    id            int8 not null,
    email         varchar(255) null,
    name          varchar(255) not null,
    password      varchar(255) not null,
    profile       int4 null,
    create_date     timestamp not null,
    update_date     timestamp,
    active        boolean,
    constraint user_data_pkey primary key (id)
);

CREATE SEQUENCE public.user_data_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;
ALTER TABLE public.user_data_id_seq OWNER TO postgres;
ALTER TABLE public.user_data ALTER COLUMN id SET DEFAULT nextval('public.user_data_id_seq'::regclass);

INSERT INTO public.user_data (email, name, password, profile, create_date, active) VALUES('desafio@email.com', 'Desafio Globo', '$2a$10$yZoDLqlwtOYlOi092SAGU.cQ1oEbJ11cGQTpiv3asq1ZhLqNv4MR2', 1, '2021-01-18 19:54:11.000000', true);
