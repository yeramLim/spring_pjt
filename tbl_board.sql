--------------------------------------------------------
--  파일이 생성됨 - 월요일-11월-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TBL_BOARD
--------------------------------------------------------

  CREATE TABLE "SCOTT"."TBL_BOARD" 
   (	"BNO" NUMBER(10,0), 
	"TITLE" VARCHAR2(200 BYTE), 
	"CONTENT" VARCHAR2(2000 BYTE), 
	"WRITER" VARCHAR2(50 BYTE), 
	"REGDATE" DATE DEFAULT sysdate
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into SCOTT.TBL_BOARD
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_BOARD
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."PK_BOARD" ON "SCOTT"."TBL_BOARD" ("BNO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table TBL_BOARD
--------------------------------------------------------

  ALTER TABLE "SCOTT"."TBL_BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY ("BNO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "SCOTT"."TBL_BOARD" MODIFY ("TITLE" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."TBL_BOARD" MODIFY ("CONTENT" NOT NULL ENABLE);
 
  ALTER TABLE "SCOTT"."TBL_BOARD" MODIFY ("WRITER" NOT NULL ENABLE);
