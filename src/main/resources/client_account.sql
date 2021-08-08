CREATE TABLE client_account (
clinet_account_id varchar(15) not null,
trader_employee_id varchar(15), 
PRIMARY KEY(clinet_account_id)
);

INSERT INTO client_account VALUES("A765839", "T75");
INSERT INTO client_account VALUES("A765844", "T71");
INSERT INTO client_account VALUES("A765845", "T71");
INSERT INTO client_account VALUES("A765846", "T71");
INSERT INTO client_account VALUES("A765847", "T71");
INSERT INTO client_account VALUES("A765840", "T70");
INSERT INTO client_account VALUES("A765841", "T70");
INSERT INTO client_account VALUES("A765842", "T70");
INSERT INTO client_account VALUES("A765848", null);
INSERT INTO client_account VALUES("A765849", null);

select * from client_account;
