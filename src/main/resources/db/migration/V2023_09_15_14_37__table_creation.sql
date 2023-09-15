create table if not exists listing (
     id BIGSERIAL NOT NULL PRIMARY KEY,
     listing_name varchar,
     location varchar,
     dimension varchar,
     format varchar,
     listing_type varchar,
     status varchar,
     description varchar
);
