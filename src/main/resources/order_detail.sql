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

drop table order_detail;

delete from order_detail;
select * from order_detail;
update order_detail
set

select * from order_detail where order_status != "completed";

update order_detail
set order_status = "Sent for Execution",
 quantity_executed = 12.0
where order_id = '03a2b8a8-e868-4280-8aad-0ba999095b78';