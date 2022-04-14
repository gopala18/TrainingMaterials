set serveroutput on
DECLARE
cursor nameslist is select firstname,lastname from names;
fullname varchar2(40);
c number;

BEGIN

c:=0;
FOR i in nameslist LOOP
c:=c+1;
fullname := i.firstname||'.'||i.lastname||'@csscorp.com';
dbms_output.put_line(fullname);
insert into employee values(c,fullname);
END LOOP;
END;
/