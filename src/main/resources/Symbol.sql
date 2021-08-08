CREATE TABLE symbol (
symbol_id varchar(10) not null,
symbol_name varchar(70) not null,
UNIQUE(symbol_name),
PRIMARY KEY (symbol_id)
);

INSERT INTO symbol VALUES( "S1234_FB", "Facebook"); 
INSERT INTO symbol VALUES( "S6746_A", "Apple"); 
INSERT INTO symbol VALUES( "S1786_MS", "Microsoft"); 
INSERT INTO symbol VALUES( "S12677_SAO", "Saudi Arabian Oil Company"); 
INSERT INTO symbol VALUES( "S12656_AM", "Amazon"); 
INSERT INTO symbol VALUES( "S125_ALP", "Alphabet"); 
INSERT INTO symbol VALUES( "S1238_TS", "Tesla"); 

select symbol_name from symbol where symbol_id = "Test1234";
delete from symbol
where symbol_id = "Test1234";
drop table symbol;