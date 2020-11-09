--------------------------------------------------------
--  파일이 생성됨 - 월요일-11월-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USERDB
--------------------------------------------------------

  CREATE TABLE "SCOTT"."USERDB" 
   (	"USEREMAIL" VARCHAR2(70 BYTE), 
	"USERPASSWORD" VARCHAR2(30 BYTE), 
	"USERTEL" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into SCOTT.USERDB
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0011230
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SYS_C0011230" ON "SCOTT"."USERDB" ("USEREMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table USERDB
--------------------------------------------------------

  ALTER TABLE "SCOTT"."USERDB" ADD PRIMARY KEY ("USEREMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
