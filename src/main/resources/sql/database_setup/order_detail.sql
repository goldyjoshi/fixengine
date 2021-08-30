-- table to store order details in the system --
CREATE TABLE order_detail (
order_id varchar(80) not null,
quantity double not null,
symbol varchar(100) not null,
client_account_Id varchar(15) not null,
order_date timestamp not null,
order_status varchar(30) not null,
side char(4) not null,
quantity_executed double not null,
PRIMARY KEY(order_id)
);

select * from order_detail;


