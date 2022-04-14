drop table if exists mobile;
create table mobile(iemi integer, model varchar(20), brand varchar(20), cost float8);

select * from mobile;

drop function if exists insertmobile(integer, varchar, varchar, float8);

CREATE OR REPLACE FUNCTION insertmobile(iemi integer,model varchar(20),brand varchar(20),
cost float8)

RETURNS integer AS $insertFlag$
DECLARE 
	flag integer := 0;
 BEGIN	
	INSERT INTO mobile VALUES(iemi, model, brand, cost);
	flag := 1;
        RETURN flag;
END;
$insertFlag$  LANGUAGE plpgsql;

---------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION insertmobile1(iemi_no integer,model varchar(20),brand varchar(20),
cost float8)

RETURNS integer AS $insertFlag$
DECLARE 
	flag integer := 0;
	counter integer:=0;
 BEGIN	
	select count(*) into counter from mobile where iemi=iemi_no;
	if counter!=1 then
		INSERT INTO mobile VALUES(iemi_no, model, brand, cost);
		flag := 1;
		RETURN flag;
	else
		raise 'Duplicate IEMI code violates Primary key';
	end if;
END;
$insertFlag$  LANGUAGE plpgsql;







select insertmobile(12346,'k5','lenovo',15000.00);


==================================================================
--drop function DELETEMOBILE(INT)

CREATE OR REPLACE FUNCTION DELETEMOBILE(IEMI_No int)
RETURNS BOOLEAN AS $deleteFlag$
DECLARE 
	flag BOOLEAN;
BEGIN
	flag:=false;
	DELETE FROM Mobile WHERE IEMI=IEMI_no;
	flag:=true;
        RETURN flag;
END;
$deleteFlag$  LANGUAGE plpgsql


select * from mobile
SELECT DELETEMOBILE(12345);

==================================================================



CREATE OR REPLACE FUNCTION UPDATEMOBILE(IEMI_No int,updatedModel varchar(20),updatedBrand varchar(20),updatedCost float8)
RETURNS BOOLEAN AS $updateFlag$
DECLARE 
	flag BOOLEAN;
BEGIN
	flag:=false;
	UPDATE Mobile SET model=updatedModel,brand=updatedBrand,cost=updatedCost WHERE IEMI=IEMI_No;
	flag:=true;
        RETURN flag;
END;
$updateFlag$  LANGUAGE plpgsql;

select * from mobile
select updatemobile(12345,'k6','Lenovo',18000.00)