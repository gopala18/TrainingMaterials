set serveroutput on
DECLARE
CURSOR prod_cur is
SELECT supplier_name FROM product;
/*type c_listis varray(6) of customers.name%type;
name_listc_list:= c_list();*/
counter integer :=0;
BEGIN
FOR n IN prod_cur LOOP 
IF n.supplier_name='suppl1'
THEN
counter:=counter+1;
END IF;
END LOOP;
dbms_output.put_line('Total ' ||counter||' products from suppl1' );
END; 
/