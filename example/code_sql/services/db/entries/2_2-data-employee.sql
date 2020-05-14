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
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (id, person_id, username, hiring_date, title, manager_id) FROM stdin;
1	1	Espenscheid	2017-05-27	manager	\N
2	2	Rosensteel	1993-04-23	manager	\N
3	3	Mantyla	2016-02-13	analyst	20
4	4	Loury	2015-06-18	teller	2
5	5	Pecourt	2018-04-16	adviser	1
6	6	Adjei	2000-05-12	manager	\N
7	7	Pebbles	2005-06-28	adviser	2
8	8	Cathie	1999-03-13	teller	14
9	9	Madelaine	1997-04-06	teller	2
10	10	Tondeur	2017-04-25	officer	6
11	11	Lucksinger	1987-02-04	analyst	6
12	12	Gandon	2003-03-11	teller	2
13	13	Swims	2012-09-11	officer	20
14	14	Moine	2018-10-25	manager	\N
15	15	Teekasingh	2012-11-12	teller	20
16	16	Gousse	2018-12-03	adviser	2
17	17	Reierson	2011-01-25	officer	14
18	18	Potet	2013-02-11	analyst	20
19	19	Killeen	2009-09-14	adviser	6
20	20	Jamison	1986-11-01	manager	\N
\.


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--

