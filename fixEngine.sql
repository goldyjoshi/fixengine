CREATE TABLE trader_details (
	trader_employee_id varchar(15) not null,  
    trader_email varchar(30) not null,
    trader_password varchar(15) not null,
    PRIMARY KEY(trader_employee_id)
    );
    
INSERT INTO trader_details VALUES("E1234", "Anna@gmail.com", "1234");

SELECT * FROM trader_details;
    
    
    