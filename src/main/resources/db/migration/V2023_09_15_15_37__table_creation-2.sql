create table if not exists customer(
id BIGSERIAL NOT NULL PRIMARY KEY,
name varchar,
mail varchar,
phone_number varchar,
address varchar
);

create table if not exists host(
id BIGSERIAL NOT NULL PRIMARY KEY,
name varchar,
mail varchar,
phone_number varchar,
address varchar
);

create table if not exists listing (
     id BIGSERIAL NOT NULL PRIMARY KEY,
     listing_name varchar,
     host_id bigint,
     location varchar,
     dimension varchar,
     format varchar,
     listing_type varchar,
     status varchar,
     description varchar,
     constraint fk_listing_host_id foreign key(host_id) references host(id)
);


create table if not exists payment(
id BIGSERIAL NOT NULL PRIMARY KEY,
host_id bigint,
customer_id bigint,
listing_id bigint,
amount numeric,
status varchar,
platform_fee varchar,
constraint fk_payment_listing_id foreign key(listing_id) references listing(id),
constraint fk_payment_host_id foreign key(host_id) references host(id),
constraint fk_payment_customer_id foreign key(customer_id) references customer(id)
);

create table if not exists booking(
id BIGSERIAL NOT NULL PRIMARY KEY,
listing_id bigint,
host_id bigint,
rate numeric,
status varchar,
customer_id bigint,
asset varchar,
start_time timestamptz,
end_time timestamptz,
payment_id bigint,
constraint fk_booking_listing_id foreign key(listing_id) references listing(id),
constraint fk_booking_host_id foreign key(host_id) references host(id),
constraint fk_booking_customer_id foreign key(customer_id) references customer(id),
constraint fk_booking_payment_id foreign key(payment_id) references payment(id)
);

