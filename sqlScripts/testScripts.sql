set schema 'quickqueue';
select * FROM users where username = 'kelvintrinh174' and "password" = '12345'and user_role ='CUSTOMER';

select * from carts;
select * from cart_item;
select * from orders;

insert into users  (username,"password",first_name,last_name,email,user_role)
values ('kelvintrinh174','12345','Kelvin','Trinh','kelvintrinh174@gmail.com','CUSTOMER');