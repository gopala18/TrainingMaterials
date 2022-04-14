set serveroutput on
CREATE or REPLACE TRIGGER price_history_trigger 
BEFORE UPDATE OF unit_price 
ON product 
FOR EACH ROW 
BEGIN 
dbms_output.put_line('Price History updated');
INSERT INTO product_price_history 
VALUES 
(:old.product_id, 
 :old.product_name, 
 :old.supplier_name, 
 :old.unit_price); 
END; 
/ 