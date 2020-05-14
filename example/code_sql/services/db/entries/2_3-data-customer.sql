--
-- PostgreSQL database dump
--

-- Dumped from database version 10.8
-- Dumped by pg_dump version 10.8

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

--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (id, person_id, subscribe_date, adviser_id) FROM stdin;
1	21	1989-06-04	7
2	22	2015-08-13	5
3	23	2012-10-22	7
4	24	2016-06-13	5
5	25	1985-07-21	5
6	26	1975-02-26	19
7	27	1982-02-27	19
8	28	1961-11-06	7
9	29	2001-07-04	19
10	30	2017-09-29	19
11	31	2004-12-05	16
12	32	2017-10-23	7
13	33	2017-09-28	16
14	34	2003-10-30	5
15	35	2017-03-20	16
16	36	2007-09-02	7
17	37	2004-08-31	16
18	38	2004-08-07	7
19	39	2014-09-21	5
20	40	2002-12-08	19
21	41	2002-07-10	7
22	42	1951-04-08	16
23	43	2005-10-21	5
24	44	1969-05-26	7
25	45	2012-01-25	5
26	46	2012-01-07	19
27	47	2013-02-17	7
28	48	2010-06-26	19
29	49	2018-03-10	19
30	50	2010-12-04	7
31	51	2013-04-08	7
32	52	2013-02-10	19
33	53	2006-02-03	5
34	54	1986-12-27	7
35	55	1968-02-11	5
36	56	2016-01-18	16
37	57	1982-08-17	5
38	58	1954-07-04	5
39	59	1984-03-19	16
40	60	1984-02-01	16
41	61	2010-11-06	5
42	62	1977-06-08	19
43	63	2014-07-26	19
44	64	1975-05-12	7
45	65	2015-01-13	16
46	66	1983-02-23	7
47	67	2005-09-05	5
48	68	1985-04-26	19
49	69	2014-11-24	16
50	70	2007-11-03	5
51	11	2004-07-24	7
52	6	1993-03-08	16
53	5	2006-11-21	19
54	12	1986-04-06	5
55	19	1983-03-22	7
56	14	2007-02-21	16
57	4	2003-02-22	19
58	15	1997-06-03	16
59	8	2013-03-02	7
60	10	2008-04-13	19
\.


--
-- Name: customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--

