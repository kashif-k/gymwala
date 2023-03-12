--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
    id integer NOT NULL,
    username character varying(16) NOT NULL,
    password character varying(128) NOT NULL
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- Name: admin_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.admin_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.admin_id_seq OWNER TO postgres;

--
-- Name: admin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.admin_id_seq OWNED BY public.admin.id;


--
-- Name: balance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.balance (
    id integer NOT NULL,
    member_id integer NOT NULL,
    balance numeric(8,2) NOT NULL
);


ALTER TABLE public.balance OWNER TO postgres;

--
-- Name: balance_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.balance_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.balance_id_seq OWNER TO postgres;

--
-- Name: balance_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.balance_id_seq OWNED BY public.balance.id;


--
-- Name: balance_member_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.balance_member_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.balance_member_id_seq OWNER TO postgres;

--
-- Name: balance_member_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.balance_member_id_seq OWNED BY public.balance.member_id;


--
-- Name: costing; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.costing (
    id integer NOT NULL,
    title character varying(128) NOT NULL,
    amount numeric(10,2) NOT NULL,
    date date NOT NULL
);


ALTER TABLE public.costing OWNER TO postgres;

--
-- Name: costing_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.costing_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.costing_id_seq OWNER TO postgres;

--
-- Name: costing_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.costing_id_seq OWNED BY public.costing.id;


--
-- Name: equipment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipment (
    id integer NOT NULL,
    name character varying NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.equipment OWNER TO postgres;

--
-- Name: equipment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.equipment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipment_id_seq OWNER TO postgres;

--
-- Name: equipment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipment_id_seq OWNED BY public.equipment.id;


--
-- Name: equipment_quantity_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.equipment_quantity_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipment_quantity_seq OWNER TO postgres;

--
-- Name: equipment_quantity_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipment_quantity_seq OWNED BY public.equipment.quantity;


--
-- Name: member; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.member (
    id integer NOT NULL,
    name character varying(48) NOT NULL,
    address character varying(128),
    photo character varying(128),
    dob date NOT NULL,
    weight character varying(5),
    height character varying(5),
    aadhaar bigint NOT NULL,
    doj date NOT NULL,
    phone bigint NOT NULL
);


ALTER TABLE public.member OWNER TO postgres;

--
-- Name: membalance; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.membalance AS
 SELECT balance.id,
    member.name,
    member.phone,
    balance.balance
   FROM (public.balance
     JOIN public.member ON ((balance.member_id = member.id)));


ALTER TABLE public.membalance OWNER TO postgres;

--
-- Name: member_aadhaar_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.member_aadhaar_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.member_aadhaar_seq OWNER TO postgres;

--
-- Name: member_aadhaar_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.member_aadhaar_seq OWNED BY public.member.aadhaar;


--
-- Name: member_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.member_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.member_id_seq OWNER TO postgres;

--
-- Name: member_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.member_id_seq OWNED BY public.member.id;


--
-- Name: member_phone_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.member_phone_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.member_phone_seq OWNER TO postgres;

--
-- Name: member_phone_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.member_phone_seq OWNED BY public.member.phone;


--
-- Name: membership; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.membership (
    id integer NOT NULL,
    member_id integer NOT NULL,
    package_id integer NOT NULL,
    start_date date NOT NULL,
    payment_id integer NOT NULL
);


ALTER TABLE public.membership OWNER TO postgres;

--
-- Name: membership_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.membership_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.membership_id_seq OWNER TO postgres;

--
-- Name: membership_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.membership_id_seq OWNED BY public.membership.id;


--
-- Name: membership_member_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.membership_member_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.membership_member_id_seq OWNER TO postgres;

--
-- Name: membership_member_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.membership_member_id_seq OWNED BY public.membership.member_id;


--
-- Name: membership_package_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.membership_package_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.membership_package_id_seq OWNER TO postgres;

--
-- Name: membership_package_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.membership_package_id_seq OWNED BY public.membership.package_id;


--
-- Name: membership_payment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.membership_payment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.membership_payment_id_seq OWNER TO postgres;

--
-- Name: membership_payment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.membership_payment_id_seq OWNED BY public.membership.payment_id;


--
-- Name: package; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.package (
    id integer NOT NULL,
    type character varying(16) NOT NULL,
    amount numeric(8,2) NOT NULL,
    duration integer NOT NULL
);


ALTER TABLE public.package OWNER TO postgres;

--
-- Name: traineeship; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.traineeship (
    id integer NOT NULL,
    member_id integer NOT NULL,
    trainer_id integer NOT NULL,
    month integer NOT NULL,
    start_date date NOT NULL
);


ALTER TABLE public.traineeship OWNER TO postgres;

--
-- Name: trainer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trainer (
    id integer NOT NULL,
    name character varying(48) NOT NULL,
    address character varying(128),
    photo character varying(128),
    phone bigint NOT NULL,
    aadhaar bigint NOT NULL
);


ALTER TABLE public.trainer OWNER TO postgres;

--
-- Name: memdetail; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.memdetail AS
 SELECT member.id,
    member.name,
    member.phone,
    package.type AS package_type,
    package.duration AS month,
    membership.start_date AS mdate,
    trainer.name AS tname,
    traineeship.start_date AS tdate,
    balance.balance AS bal
   FROM (((((public.member
     JOIN public.membership ON ((membership.member_id = member.id)))
     JOIN public.traineeship ON ((traineeship.member_id = member.id)))
     JOIN public.trainer ON ((traineeship.trainer_id = trainer.id)))
     JOIN public.balance ON ((balance.member_id = member.id)))
     JOIN public.package ON ((membership.package_id = package.id)));


ALTER TABLE public.memdetail OWNER TO postgres;

--
-- Name: payment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment (
    id integer NOT NULL,
    member_id integer NOT NULL,
    amount numeric(8,2) NOT NULL,
    date date NOT NULL
);


ALTER TABLE public.payment OWNER TO postgres;

--
-- Name: mempay; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.mempay AS
 SELECT pay.id,
    member.name,
    member.phone,
    pay.amount,
    pay.date AS pdate
   FROM (public.member
     JOIN public.payment pay ON ((member.id = pay.member_id)));


ALTER TABLE public.mempay OWNER TO postgres;

--
-- Name: memsubscription; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.memsubscription AS
 SELECT membership.id,
    member.name,
    member.phone,
    package.type AS subscription,
    package.duration AS months,
    membership.start_date AS sdate
   FROM ((public.membership
     JOIN public.member ON ((membership.member_id = member.id)))
     JOIN public.package ON ((membership.package_id = package.id)));


ALTER TABLE public.memsubscription OWNER TO postgres;

--
-- Name: memtrainee; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.memtrainee AS
 SELECT member.id,
    member.name,
    trainer.name AS tname,
    traineeship.month,
    traineeship.start_date AS sdate
   FROM ((public.traineeship
     JOIN public.member ON ((traineeship.member_id = member.id)))
     JOIN public.trainer ON ((traineeship.trainer_id = trainer.id)));


ALTER TABLE public.memtrainee OWNER TO postgres;

--
-- Name: package_duration_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.package_duration_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.package_duration_seq OWNER TO postgres;

--
-- Name: package_duration_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.package_duration_seq OWNED BY public.package.duration;


--
-- Name: package_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.package_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.package_id_seq OWNER TO postgres;

--
-- Name: package_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.package_id_seq OWNED BY public.package.id;


--
-- Name: payment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.payment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.payment_id_seq OWNER TO postgres;

--
-- Name: payment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.payment_id_seq OWNED BY public.payment.id;


--
-- Name: payment_member_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.payment_member_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.payment_member_id_seq OWNER TO postgres;

--
-- Name: payment_member_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.payment_member_id_seq OWNED BY public.payment.member_id;


--
-- Name: traineeship_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.traineeship_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.traineeship_id_seq OWNER TO postgres;

--
-- Name: traineeship_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.traineeship_id_seq OWNED BY public.traineeship.id;


--
-- Name: traineeship_member_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.traineeship_member_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.traineeship_member_id_seq OWNER TO postgres;

--
-- Name: traineeship_member_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.traineeship_member_id_seq OWNED BY public.traineeship.member_id;


--
-- Name: traineeship_month_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.traineeship_month_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.traineeship_month_seq OWNER TO postgres;

--
-- Name: traineeship_month_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.traineeship_month_seq OWNED BY public.traineeship.month;


--
-- Name: traineeship_trainer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.traineeship_trainer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.traineeship_trainer_id_seq OWNER TO postgres;

--
-- Name: traineeship_trainer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.traineeship_trainer_id_seq OWNED BY public.traineeship.trainer_id;


--
-- Name: trainer_aadhaar_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trainer_aadhaar_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.trainer_aadhaar_seq OWNER TO postgres;

--
-- Name: trainer_aadhaar_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.trainer_aadhaar_seq OWNED BY public.trainer.aadhaar;


--
-- Name: trainer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trainer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.trainer_id_seq OWNER TO postgres;

--
-- Name: trainer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.trainer_id_seq OWNED BY public.trainer.id;


--
-- Name: trainer_phone_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trainer_phone_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.trainer_phone_seq OWNER TO postgres;

--
-- Name: trainer_phone_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.trainer_phone_seq OWNED BY public.trainer.phone;


--
-- Name: admin id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin ALTER COLUMN id SET DEFAULT nextval('public.admin_id_seq'::regclass);


--
-- Name: balance id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.balance ALTER COLUMN id SET DEFAULT nextval('public.balance_id_seq'::regclass);


--
-- Name: balance member_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.balance ALTER COLUMN member_id SET DEFAULT nextval('public.balance_member_id_seq'::regclass);


--
-- Name: costing id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.costing ALTER COLUMN id SET DEFAULT nextval('public.costing_id_seq'::regclass);


--
-- Name: equipment id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment ALTER COLUMN id SET DEFAULT nextval('public.equipment_id_seq'::regclass);


--
-- Name: equipment quantity; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment ALTER COLUMN quantity SET DEFAULT nextval('public.equipment_quantity_seq'::regclass);


--
-- Name: member id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member ALTER COLUMN id SET DEFAULT nextval('public.member_id_seq'::regclass);


--
-- Name: member aadhaar; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member ALTER COLUMN aadhaar SET DEFAULT nextval('public.member_aadhaar_seq'::regclass);


--
-- Name: member phone; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member ALTER COLUMN phone SET DEFAULT nextval('public.member_phone_seq'::regclass);


--
-- Name: membership id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership ALTER COLUMN id SET DEFAULT nextval('public.membership_id_seq'::regclass);


--
-- Name: membership member_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership ALTER COLUMN member_id SET DEFAULT nextval('public.membership_member_id_seq'::regclass);


--
-- Name: membership package_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership ALTER COLUMN package_id SET DEFAULT nextval('public.membership_package_id_seq'::regclass);


--
-- Name: membership payment_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership ALTER COLUMN payment_id SET DEFAULT nextval('public.membership_payment_id_seq'::regclass);


--
-- Name: package id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.package ALTER COLUMN id SET DEFAULT nextval('public.package_id_seq'::regclass);


--
-- Name: package duration; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.package ALTER COLUMN duration SET DEFAULT nextval('public.package_duration_seq'::regclass);


--
-- Name: payment id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment ALTER COLUMN id SET DEFAULT nextval('public.payment_id_seq'::regclass);


--
-- Name: payment member_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment ALTER COLUMN member_id SET DEFAULT nextval('public.payment_member_id_seq'::regclass);


--
-- Name: traineeship id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traineeship ALTER COLUMN id SET DEFAULT nextval('public.traineeship_id_seq'::regclass);


--
-- Name: traineeship member_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traineeship ALTER COLUMN member_id SET DEFAULT nextval('public.traineeship_member_id_seq'::regclass);


--
-- Name: traineeship trainer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traineeship ALTER COLUMN trainer_id SET DEFAULT nextval('public.traineeship_trainer_id_seq'::regclass);


--
-- Name: traineeship month; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traineeship ALTER COLUMN month SET DEFAULT nextval('public.traineeship_month_seq'::regclass);


--
-- Name: trainer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trainer ALTER COLUMN id SET DEFAULT nextval('public.trainer_id_seq'::regclass);


--
-- Name: trainer phone; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trainer ALTER COLUMN phone SET DEFAULT nextval('public.trainer_phone_seq'::regclass);


--
-- Name: trainer aadhaar; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trainer ALTER COLUMN aadhaar SET DEFAULT nextval('public.trainer_aadhaar_seq'::regclass);


--
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin (id, username, password) FROM stdin;
1	kashif	pass
\.


--
-- Data for Name: balance; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.balance (id, member_id, balance) FROM stdin;
\.


--
-- Data for Name: costing; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.costing (id, title, amount, date) FROM stdin;
2	Electricity	10000.00	2023-02-25
3	Housekeeping	4000.00	2023-02-25
4	Greasing	2000.00	2023-02-25
5	AC maintenance	1500.00	2023-02-25
6	tea/coffee	300.00	2023-02-25
\.


--
-- Data for Name: equipment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipment (id, name, quantity) FROM stdin;
2	Plate 10kg	8
3	Dumbell 5Kg	6
5	Plate 15Kg	6
6	Plate 20Kg	8
7	Plate 5Kg	10
4	Dumbell 7.5Kg	4
\.


--
-- Data for Name: member; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.member (id, name, address, photo, dob, weight, height, aadhaar, doj, phone) FROM stdin;
3	kashif	kurla	dp3.jpg	1998-05-11	80Kg	5'11	123456789012	2022-09-01	9999999999
4	Moiz	kurla	default.png	2007-12-26	100kg	0	123456789012	2023-02-25	9999999999
\.


--
-- Data for Name: membership; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.membership (id, member_id, package_id, start_date, payment_id) FROM stdin;
1	3	1	2023-02-26	8
2	4	6	2023-02-26	9
\.


--
-- Data for Name: package; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.package (id, type, amount, duration) FROM stdin;
1	GYM	1300.00	1
2	GYM	3500.00	3
3	GYM	6500.00	6
4	GYM	10000.00	12
5	GYM_CARDIO	12000.00	12
6	GYM_CARDIO	9000.00	6
7	GYM_CARDIO	5000.00	3
8	GYM_CARDIO	1700.00	1
\.


--
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.payment (id, member_id, amount, date) FROM stdin;
1	3	1300.00	2023-02-25
2	4	5000.00	2023-02-25
3	3	5000.00	2023-02-25
4	3	1300.00	2023-02-26
5	3	1300.00	2023-02-26
6	3	1300.00	2023-02-26
7	3	1300.00	2023-02-26
8	3	1300.00	2023-02-26
9	4	1300.00	2023-02-26
\.


--
-- Data for Name: traineeship; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.traineeship (id, member_id, trainer_id, month, start_date) FROM stdin;
1	3	3	2	2023-02-26
2	4	2	1	2023-02-26
\.


--
-- Data for Name: trainer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.trainer (id, name, address, photo, phone, aadhaar) FROM stdin;
2	Kashif	kurla	default.png	9999999999	123456789012
3	Nilesh	mumbai	default.png	9999999999	987654321234
\.


--
-- Name: admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.admin_id_seq', 1, false);


--
-- Name: balance_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.balance_id_seq', 1, false);


--
-- Name: balance_member_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.balance_member_id_seq', 1, false);


--
-- Name: costing_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.costing_id_seq', 6, true);


--
-- Name: equipment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.equipment_id_seq', 7, true);


--
-- Name: equipment_quantity_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.equipment_quantity_seq', 1, false);


--
-- Name: member_aadhaar_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.member_aadhaar_seq', 1, false);


--
-- Name: member_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.member_id_seq', 4, true);


--
-- Name: member_phone_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.member_phone_seq', 1, false);


--
-- Name: membership_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.membership_id_seq', 2, true);


--
-- Name: membership_member_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.membership_member_id_seq', 1, false);


--
-- Name: membership_package_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.membership_package_id_seq', 1, false);


--
-- Name: membership_payment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.membership_payment_id_seq', 1, false);


--
-- Name: package_duration_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.package_duration_seq', 1, false);


--
-- Name: package_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.package_id_seq', 8, true);


--
-- Name: payment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.payment_id_seq', 9, true);


--
-- Name: payment_member_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.payment_member_id_seq', 1, false);


--
-- Name: traineeship_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.traineeship_id_seq', 2, true);


--
-- Name: traineeship_member_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.traineeship_member_id_seq', 1, false);


--
-- Name: traineeship_month_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.traineeship_month_seq', 1, false);


--
-- Name: traineeship_trainer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.traineeship_trainer_id_seq', 1, false);


--
-- Name: trainer_aadhaar_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trainer_aadhaar_seq', 1, false);


--
-- Name: trainer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trainer_id_seq', 3, true);


--
-- Name: trainer_phone_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trainer_phone_seq', 1, false);


--
-- Name: admin admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);


--
-- Name: balance balance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.balance
    ADD CONSTRAINT balance_pkey PRIMARY KEY (id);


--
-- Name: costing costing_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.costing
    ADD CONSTRAINT costing_pkey PRIMARY KEY (id);


--
-- Name: equipment equipment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT equipment_pkey PRIMARY KEY (id);


--
-- Name: member member_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member
    ADD CONSTRAINT member_pkey PRIMARY KEY (id);


--
-- Name: membership membership_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT membership_pkey PRIMARY KEY (id);


--
-- Name: package package_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.package
    ADD CONSTRAINT package_pkey PRIMARY KEY (id);


--
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id);


--
-- Name: traineeship traineeship_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traineeship
    ADD CONSTRAINT traineeship_pkey PRIMARY KEY (id);


--
-- Name: trainer trainer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trainer
    ADD CONSTRAINT trainer_pkey PRIMARY KEY (id);


--
-- Name: balance balance; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.balance
    ADD CONSTRAINT balance FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- Name: payment member_pay; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT member_pay FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- Name: membership members; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT members FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- Name: traineeship members; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traineeship
    ADD CONSTRAINT members FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- Name: membership package; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT package FOREIGN KEY (package_id) REFERENCES public.package(id);


--
-- Name: membership payments; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT payments FOREIGN KEY (payment_id) REFERENCES public.payment(id);


--
-- Name: traineeship trainer; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traineeship
    ADD CONSTRAINT trainer FOREIGN KEY (trainer_id) REFERENCES public.trainer(id);


--
-- PostgreSQL database dump complete
--

