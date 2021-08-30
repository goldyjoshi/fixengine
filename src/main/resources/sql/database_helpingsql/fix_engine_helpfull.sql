

select * from client_account where client_account_id = "TestAccount";
delete from client_account where client_account_id = "TestAccount";


delete symbol_name from symbol where symbol_name = "test";

delete from order_detail where order_id = 'TestOrderId';

update order_detail
set order_status = "Completed"
where order_id = 'TestOrderId';