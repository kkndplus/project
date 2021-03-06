CREATE TABLE "MENU_TB" (
  "ID" NUMBER NOT NULL ENABLE, 
	"MENU_CD" CHAR(4 BYTE), 
	"MENU_NAME" VARCHAR2(50 BYTE), 
	"DISPLAY_SEQ" NUMBER(3,0), 
	"URL" VARCHAR2(500 BYTE), 
	 CONSTRAINT "MENU_TB_PK" PRIMARY KEY ("ID")
);


CREATE SEQUENCE  "MENU_TB_SEQ" 
  MINVALUE 1 
  INCREMENT BY 1 
  START WITH 1
  NOCACHE  
  NOORDER  
  NOCYCLE ;
