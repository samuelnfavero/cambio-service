CREATE TABLE "cambio" (
                           "id" bigserial NOT NULL,
                           "from_currency" VARCHAR(3) NOT NULL,
                           "to_currency" VARCHAR(3) NOT NULL,
                           "conversion_factor" decimal(65,2) NOT NULL,
                           primary key (id)
 );