DROP TABLE IF EXISTS public.orders;

CREATE TABLE public.orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(20),
    numProducts BIGINT,
    amount DECFLOAT(2)
);