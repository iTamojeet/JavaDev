SET ECHO OFF
SET VERIFY OFF

PROMPT
PROMPT specify password for HR as parameter 1:
DEFINE pass=&1

PROMPT
PROMPT specify default tablespace for HR as parameter 2:
DEFINE tbs=&2

PROMPT
PROMPT specify temporary tablespace for HR as parameter 3:
DEFINE ttbs=&3

PROMPT
PROMPT specify password for SYS as parameter 4:
DEFINE pass_sys=&4

PROMPT
PROMPT specify log path as parameter 5:
DEFINE log_path=&5

PROMPT
PROMPT specify connect string as parameter 6:
DEFINE connect_string=&6

DEFINE spool_file=&log_path.hr_main.log
SPOOL &spool_file

CONNECT sys/&pass_sys@&connect_string AS SYSDBA

DROP USER hr CASCADE;

CREATE USER hr IDENTIFIED BY &pass
DEFAULT TABLESPACE &tbs
TEMPORARY TABLESPACE &ttbs
QUOTA UNLIMITED ON &tbs;

GRANT CREATE SESSION, CREATE VIEW, ALTER SESSION, CREATE SEQUENCE TO hr;
GRANT CREATE SYNONYM, CREATE DATABASE LINK, RESOURCE, UNLIMITED TABLESPACE TO hr;
GRANT EXECUTE ON sys.dbms_stats TO hr;

CONNECT hr/&pass@&connect_string

ALTER SESSION SET NLS_LANGUAGE=American;
ALTER SESSION SET NLS_TERRITORY=America;

@hr_cre
@hr_popul
@hr_idx
@hr_code
@hr_comnt
@hr_analz

SPOOL OFF
