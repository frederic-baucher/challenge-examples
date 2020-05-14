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
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account (id, customer_id, type, amount) FROM stdin;
1	1	current	8497.69
2	2	current	2451.30
3	2	saving	3862.91
4	3	current	7242.86
5	4	current	5413.26
6	5	current	6933.57
7	5	saving	9336.86
8	6	current	4959.47
9	6	saving	5612.34
10	7	current	5771.39
11	7	saving	9299.97
12	8	current	9836.58
13	9	current	8840.24
14	9	saving	2991.57
15	10	current	9407.02
16	11	current	6441.60
17	12	current	2245.75
18	13	current	4919.19
19	14	current	9791.92
20	15	current	8709.31
21	16	current	3619.14
22	17	current	5304.50
23	17	saving	6081.08
24	18	current	5641.62
25	18	saving	7381.06
26	19	current	4080.83
27	20	current	3119.04
28	21	current	8090.76
29	22	current	6549.37
30	23	current	8998.80
31	24	current	2064.96
32	24	saving	8054.94
33	25	current	4926.30
34	26	current	5640.09
35	27	current	9581.56
36	28	current	4784.11
37	28	saving	2029.71
38	29	current	6772.49
39	30	current	3087.40
40	30	saving	7450.73
41	31	current	4749.95
42	32	current	4409.91
43	33	current	3146.20
44	33	saving	8619.15
45	34	current	7359.72
46	35	current	8179.83
47	36	current	5660.53
48	37	current	3807.08
49	37	saving	6532.39
50	38	current	8671.86
51	39	current	9338.99
52	40	current	2475.22
53	40	saving	9140.83
54	41	current	2056.05
55	42	current	6925.82
56	43	current	3377.67
57	44	current	9130.15
58	45	current	8394.26
59	46	current	4860.44
60	47	current	7266.58
61	48	current	2528.78
62	49	current	5298.38
63	50	current	3056.01
64	51	current	6422.82
65	52	current	8812.64
66	52	saving	8499.00
67	53	current	3628.79
68	53	saving	3736.67
69	54	current	7060.04
70	55	current	7923.14
71	55	saving	7150.93
72	56	current	2394.48
73	57	current	2069.22
74	58	current	6841.13
75	59	current	4406.70
76	59	saving	5983.24
77	60	current	2810.85
\.


--
-- Name: account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--

