# Create Web Application

## JDK
[Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
## Servlets container
[Tomcat](https://tomcat.apache.org/download-90.cgi)
## DataBase
[H2](https://www.h2database.com/html/main.html)
## IDE
[Intellij IDEA](https://portapps.io/app/intellij-idea-ultimate-portable/#download)

* Распаковать JDK в D:\JDK
* Распаковать Tomcat в D:\tomcat
* Распаковать H2 в D:\h2
* Скопировать ** h2-1.4.200.jar ** из d:\h2\bin в d:\tomcat\lib
* Открыть в редакторе d:\tomcat\bin\catalina.bat
  * заменить:
  ``` bat
      :emptyClasspath
      set "CLASSPATH=%CLASSPATH%%CATALINA_HOME%\bin\bootstrap.jar"
  ```
  * на: 
  ``` bat
      :emptyClasspath
      set "CLASSPATH=%CLASSPATH%%CATALINA_HOME%\bin\bootstrap.jar"
      set "CLASSPATH=%CLASSPATH%;%CATALINA_HOME%\lib\h2-1.4.200.jar
  ```
   * содержимое файла d:\h2\bin\h2.bat:
     ``` bat
     set path=%path%;d:\jdk\bin
     @java -cp "h2-1.4.200.jar;%H2DRIVERS%;%CLASSPATH%" org.h2.tools.Console %*
     @if errorlevel 1 pause
     ```

# SQL Example:
``` SQL
DROP TABLE IF EXISTS STUDENTS;
DROP TABLE IF EXISTS SECTIONS;
DROP TABLE IF EXISTS INTEREST;

CREATE TABLE STUDENTS(ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255), AGE INT, GROUP_NUMBER INT);
CREATE TABLE SECTIONS(ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255));
CREATE TABLE INTEREST(ID INT PRIMARY KEY AUTO_INCREMENT, SECTIONS_ID INT NOT NULL , STUDENTS_ID INT NOT NULL );

INSERT INTO STUDENTS(NAME, AGE, GROUP_NUMBER) VALUES('ИВАНОВ ИВАН ИВАНОВИЧ', 18, 303);
INSERT INTO STUDENTS(NAME, AGE, GROUP_NUMBER) VALUES('Петров Петр Петрович', 19, 302);
INSERT INTO STUDENTS(NAME, AGE, GROUP_NUMBER) VALUES('Сидоров Иван Петрович', 18, 303);
//SELECT * FROM STUDENTS ORDER BY ID;

INSERT INTO SECTIONS(NAME) VALUES ( 'KARATE' );
INSERT INTO SECTIONS(NAME) VALUES ( 'SAMBO' );

INSERT INTO INTEREST(SECTIONS_ID, STUDENTS_ID) VALUES ( 1, 1 );
INSERT INTO INTEREST(SECTIONS_ID, STUDENTS_ID) VALUES ( 1, 2 );
INSERT INTO INTEREST(SECTIONS_ID, STUDENTS_ID) VALUES ( 2, 3 );

SELECT STUDENTS.NAME, SECTIONS.NAME FROM STUDENTS, SECTIONS, INTEREST
WHERE STUDENTS.ID=INTEREST.STUDENTS_ID AND SECTIONS_ID=SECTIONS.ID;
```
# RESULT:
## TABLE STUDENTS:
|ID|NAME|AGE|GRUOP_NUMBER|
|---|---|---|---|
|1	|ИВАНОВ ИВАН ИВАНОВИЧ	|18	|303|
|2	|Петров Петр Петрович	|19	|302|
|3	|Сидоров Иван Петрович	|18	|303|

## TABLE SECTIONS:
|ID|NAME|
|---|---|
|1	|KARATE|
|2	|SAMBO|
## TABLE INTEREST:
|ID |SECTIONS_ID |STUDENTS_ID|
|---|---|---|
|1	|1	|1|
|2	|1	|2|
|3	|2	|3|
## SQL:
``` SQL
SELECT STUDENTS.NAME, SECTIONS.NAME FROM STUDENTS, SECTIONS, INTEREST
WHERE STUDENTS.ID=INTEREST.STUDENTS_ID AND SECTIONS_ID=SECTIONS.ID;
``` 
## RESULT:
|STUDENTS.NAME |SECTIONS.NAME|
|---|---|
|ИВАНОВ ИВАН ИВАНОВИЧ	|KARATE|
|Петров Петр Петрович	|KARATE|
|Сидоров Иван Петрович	|SAMBO|


