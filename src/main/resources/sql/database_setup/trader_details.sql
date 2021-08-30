-- table to store user details on sign up so that we can authenticate on login. --
CREATE TABLE trader_details (
	trader_employee_id varchar(15) not null,
    trader_email varchar(30) not null,
    trader_password varchar(15) not null,
    login_role varchar(7),
    PRIMARY KEY(trader_employee_id)
    );


delete from trader_details;
SELECT * FROM trader_details;