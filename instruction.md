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

