SELECT p.first_name, p.last_name, p.gender, p.birth_date, p.email, p.phone_number, p.country, p.city, c.subscribe_date, a.type, a.amount
FROM public.person AS p
INNER JOIN public.customer AS c ON p.id = c.person_id
INNER JOIN public.account AS a ON c.id = a.customer_id;
