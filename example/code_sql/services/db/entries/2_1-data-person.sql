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
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.person (id, first_name, last_name, gender, birth_date, email, phone_number, country, city) FROM stdin;
1	Aysha	Espenscheid	female	1989-03-16	aysha.espenscheid@yahoo.com	314-142-6815	US	Detroit
2	Mia	Rosensteel	female	1969-06-28	mia.rosensteel@outlook.com	653-046-1690	OT	Paris
3	Alistair	Mantyla	male	1995-04-02	alistair.mantyla@aol.com	130-548-9665	OT	Dubaï
4	Jon	Loury	male	1988-06-30	jon.loury@aol.com	573-702-1085	OT	Berlin
5	Lacey	Pecourt	female	1970-07-03	lacey.pecourt@yahoo.com	161-090-4057	US	Honolulu
6	Christelle	Adjei	female	1959-01-08	christelle.adjei@yahoo.com	214-053-2891	US	Detroit
7	Malak	Pebbles	female	1956-08-05	malak.pebbles@aol.com	724-247-1938	OT	Berlin
8	Maggie	Cathie	female	1957-07-14	maggie.cathie@yahoo.com	223-011-2392	US	Miami
9	Ryder	Madelaine	male	1972-04-14	ryder.madelaine@orange.fr	603-704-0238	US	Denver
10	Ilina	Tondeur	female	1991-11-01	ilina.tondeur@outlook.com	453-228-7371	US	Denver
11	Isra	Lucksinger	female	1969-08-12	isra.lucksinger@aol.com	550-365-1379	CA	Vancouver
12	Colin	Gandon	male	1976-04-25	colin.gandon@outlook.com	356-334-4531	OT	Paris
13	Cecile	Swims	female	1987-08-25	cecile.swims@orange.fr	466-342-7587	US	Las Vegas
14	Lamar	Moine	male	1997-06-09	lamar.moine@gmail.com	177-462-4534	CA	Montreal
15	Dominick	Teekasingh	male	1975-01-10	dominick.teekasingh@yahoo.com	660-708-9178	OT	Madrid
16	Buddy	Gousse	male	1995-10-20	buddy.gousse@gmail.com	353-519-9446	US	Las Vegas
17	Taryn	Reierson	female	1991-01-09	taryn.reierson@yahoo.com	347-176-0824	US	Denver
18	Avril	Potet	female	1984-10-31	avril.potet@aol.com	666-501-8618	US	Las Vegas
19	Don	Killeen	male	1960-08-06	don.killeen@yahoo.com	263-085-0871	OT	Dubaï
20	Zahra	Jamison	female	1961-04-20	zahra.jamison@orange.fr	314-369-9324	OT	Dubaï
21	Timéo	Boullet	male	1962-02-12	timeo.boullet@aol.com	660-689-6491	OT	Paris
22	Anne-Sophie	Greenlief	female	2000-05-19	anne-sophie.greenlief@gmail.com	301-155-1631	CA	Vancouver
23	Emi	Caudrelier	female	1981-04-05	emi.caudrelier@outlook.com	231-707-8666	OT	Dubaï
24	Blaise	Brossier	male	2001-01-31	blaise.brossier@yahoo.com	106-283-9290	CA	Montreal
25	Douglas	Duigou	male	1928-11-22	douglas.duigou@outlook.com	774-279-2479	OT	Paris
26	Gerard	Chauvot	male	1954-06-03	gerard.chauvot@gmail.com	255-310-9669	CA	Vancouver
27	Mattie	Mayeux	female	1958-04-26	mattie.mayeux@yahoo.com	423-359-0328	OT	Paris
28	Karine	Mebarki	female	1948-03-10	karine.mebarki@orange.fr	460-736-7310	OT	Rome
29	Baya	Quilindrino	female	1984-10-22	baya.quilindrino@gmail.com	342-446-5870	CA	Ottawa
30	Nahil	Le falher	male	1985-01-05	nahil.le-falher@orange.fr	616-197-6326	US	Honolulu
31	Léonard	Gerdes	male	1989-10-21	leonard.gerdes@aol.com	737-305-2874	US	Denver
32	Nelda	Dif	female	1997-05-27	nelda.dif@orange.fr	400-160-7026	US	Miami
33	Shirel	Delamar	female	1990-10-20	shirel.delamar@aol.com	461-694-6718	US	Las Vegas
34	Natacha	Bats	female	1971-02-10	natacha.bats@orange.fr	670-128-0648	CA	Vancouver
35	Angelina	Revault	female	1954-04-14	angelina.revault@outlook.com	227-415-4465	US	Denver
36	Alicia	Mariotti	female	1985-01-08	alicia.mariotti@outlook.com	232-731-6332	CA	Montreal
37	Aliénor	Eylicio	female	1994-09-10	alienor.eylicio@outlook.com	634-721-8037	OT	Madrid
38	Leo-Paul	Sainz	male	1994-09-15	leo-paul.sainz@gmail.com	217-735-1927	OT	Rome
39	Lamine	Lunz	male	1973-08-08	lamine.lunz@outlook.com	753-247-8906	CA	Ottawa
40	Jewel	Seiner	female	1958-09-09	jewel.seiner@orange.fr	267-573-8828	CA	Vancouver
41	Eyal	Berot	male	1982-08-16	eyal.berot@orange.fr	465-459-9961	CA	Vancouver
42	Avery	Walcott	female	1927-09-16	avery.walcott@yahoo.com	456-486-4802	OT	Madrid
43	Geneva	Le faou	female	1996-09-29	geneva.le-faou@aol.com	125-418-2900	US	Los Angeles
44	Sébastien	Delerue	male	1944-10-06	sebastien.delerue@yahoo.com	454-577-2324	US	Detroit
45	Arthus	Bachelier	male	1945-11-09	arthus.bachelier@gmail.com	111-660-4472	CA	Ottawa
46	Odélia	Secreto	female	2000-02-16	odelia.secreto@orange.fr	137-456-1658	US	Honolulu
47	Kermit	Bullivant	male	1987-02-20	kermit.bullivant@orange.fr	264-717-9467	OT	Berlin
48	Shana	Mess	female	2001-07-28	shana.mess@outlook.com	675-666-1512	OT	Madrid
49	Ladji	Kermarrec	male	1980-02-03	ladji.kermarrec@orange.fr	400-112-1207	OT	Paris
50	Eduardo	Fremy	male	1961-12-02	eduardo.fremy@outlook.com	507-677-2448	OT	Dubaï
51	Jeanine	Chouquet	female	2003-03-07	jeanine.chouquet@outlook.com	553-237-0506	US	Las Vegas
52	Liliana	Jehanno	female	1994-06-28	liliana.jehanno@gmail.com	242-088-3085	CA	Vancouver
53	Michaela	Matas	female	1958-08-17	michaela.matas@outlook.com	262-465-3417	US	Austin
54	Emilio	Rattler	male	1962-10-11	emilio.rattler@orange.fr	220-213-3779	OT	Dubaï
55	Norma	Levillain	female	1948-01-17	norma.levillain@outlook.com	212-411-0444	CA	Vancouver
56	Amaya	Couderc	female	1990-05-18	amaya.couderc@yahoo.com	711-191-1065	CA	Vancouver
57	Margot	Ballandras	female	1963-10-31	margot.ballandras@orange.fr	556-738-1808	US	Miami
58	Loane	Buetow	female	1925-01-04	loane.buetow@gmail.com	604-227-5522	US	Austin
59	Titouan	Houlle	male	1970-12-01	titouan.houlle@orange.fr	643-714-4059	OT	Berlin
60	Aurelie	Romanoff	female	1925-06-23	aurelie.romanoff@aol.com	502-598-2352	US	New York
61	Homer	Cobell	male	2001-05-11	homer.cobell@outlook.com	616-624-6209	CA	Vancouver
62	Nadine	Bricout	female	1948-06-26	nadine.bricout@outlook.com	705-684-3659	CA	Vancouver
63	Mayar	Kauk	female	2003-10-21	mayar.kauk@gmail.com	241-648-9944	OT	Paris
64	Rosetta	Crouzet	female	1959-12-22	rosetta.crouzet@gmail.com	517-094-5344	US	New York
65	Tina	Confer	female	2001-12-24	tina.confer@yahoo.com	425-397-1179	CA	Ottawa
66	Chasity	Richer	female	1968-04-25	chasity.richer@gmail.com	347-035-6669	US	Las Vegas
67	Adélaïde	Estrade	female	1985-07-24	adelaide.estrade@aol.com	516-139-9243	OT	Dubaï
68	Nola	Giroux	female	1942-03-01	nola.giroux@gmail.com	634-573-4801	US	Las Vegas
69	Massinissa	Tosado	male	2005-04-04	massinissa.tosado@gmail.com	405-130-4697	CA	Montreal
70	Krista	Larrieu	female	1997-05-10	krista.larrieu@aol.com	112-008-1696	CA	Montreal
\.


--
-- Name: person_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.person_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--

