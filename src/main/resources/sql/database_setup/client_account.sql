-- table to store account details for clients --
CREATE TABLE client_account (
client_account_id varchar(15) not null,
trader_employee_id varchar(15),
PRIMARY KEY(client_account_id)
);


INSERT INTO client_account VALUES("765839", "T75");
INSERT INTO client_account VALUES("765844", "T71");
INSERT INTO client_account VALUES("765845", "T71");
INSERT INTO client_account VALUES("755846", "T71");
INSERT INTO client_account VALUES("753847", "T71");
INSERT INTO client_account VALUES("775840", "T70");
INSERT INTO client_account VALUES("775841", "T70");
INSERT INTO client_account VALUES("775942", "T70");
INSERT INTO client_account VALUES("785848", null);
INSERT INTO client_account VALUES("785869", null);

select * from client_account;
