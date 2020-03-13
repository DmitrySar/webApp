# Servlets & JSP

## Знакомство
### HTTP запрос:
![HTTP request](https://javarush.ru/images/article/1aa51155-aeff-4f5b-bb23-828b81965e04/1024.webp)

### Web server Tomcat:
![Tomcat](https://javarush.ru/images/article/1774872d-ba75-49d0-8ae2-4b1de2212ece/1080.webp)

# Введение в JSP
[Введение в JSP](http://www.codenet.ru/webmast/java/jsp.php)

|Элемент JSP|	Синтаксис|	Описание|	Примечание|
|---|---|---|---|
|Выражение JSP|<%= выражение %>|Выражение обрабатывается и направляется на вывод|Эквивалент на XML: <jsp:expression> expression </jsp:expression>. Заранее определенные переменные: request, response, out, session, application, config и pageContext (также доступны в скриплетах).|
|Скриплет JSP|<% код %>|Код добавляется в метод service.|Эквивалент на XML: <jsp:scriptlet> код </jsp:scriptlet>.|
|Объявление JSP|<%! код %>|Код добавляется в тело класса сервлета, вне метода service.|Эквивалент на XML: <jsp:declaration> код </jsp:declaration>.|
|Директива JSP page|<%@ page att="значение" %>|Директивы для движка сервлета с информацией об основных настройках.|Эквивалент на XML: <jsp:directive.page att="val"\>. Допустимые атрибуты (жирным выделены значения, принимаемые по умолчанию): import="пакет.class" contentType="MIME-Type" isThreadSafe="true/false " session="true/false" buffer="размерkb/none" autoflush="true/false" extends="пакет.class" info="сообщение" errorPage="url" isErrorPage="true/false" language="java"|
|Директива JSP include|<%@ include file="url" %>|Файл в локальной системе, подключаемый при трансляции JSP в сервлет.|Эквивалент на XML: <jsp:directive.include file="url"\>. URL должен быть относительным . Для подключения файла в процессе запроса а не в ходе трансляции используйте действие jsp:include.|
|Комментарий JSP|<%-- комментарий --%>|Комментарий; игнорируется при трансляции JSP страницы в сервлет.|Если вы хотите чтобы комментарий сохранился в конечном HTML, используйте обычный синтаксис HTML для описания комментариев: <-- комментарий -->.|
|Действие jsp:include|<jsp:include page="относительный URL" flush="true"/>|Подключает файл при запросе страницы.|Если вы хотите чтобы файл подключался в процессе трансляции страницы, используйте директиву page совместно с атрибутом include. Внимание: некоторые сервера требуют чтобы подключаемые файлы были в формате HTML или JSP, в зависимости от настроек сервера (обычно данное ограничение базируется на указании расширений файлов).|
|Действие jsp:useBean|<jsp:useBean att=значение*/> or <jsp:useBean att=значение*> ... </jsp:useBean>|Найти или создать Java Bean.|Возможные атрибуты: id="имя" scope="page/request/session/application" class="пакет.class" type="пакет.class" beanName="пакет.class"|
|Действие jsp:setProperty|<jsp:setProperty att=значение*/>|Устанавливает свойства bean, или явно, или указанием на соответствующее значение параметра, передаваемое при запросе.|Допустимые атрибуты: name="имяBean" property="имяСвойства/*" param="имяПараметра" value="значение"|
|Действие jsp:getProperty|<jsp:getProperty name="ИмяСвойства" value="значение"/>|Получение и вывод свойств  bean.||
|Действие jsp:forward|<jsp:forward page="относительный URL"/>|Передает запрос другой странице.||
|Действие jsp:plugin|<jsp:plugin attribute="значение"*> ... </jsp:plugin>|Генерирует тэги  OBJECT или EMBED, в зависимости от типа броузера, в котором будет выполнятся апплет использующий  Java Plugin.||


* [JavaRush Tomcat](https://javarush.ru/groups/posts/tomcat-v-java)
* [JavaRush Создание веб-приложения](https://javarush.ru/groups/posts/328-sozdanie-prostogo-veb-prilozhenija-na-servletakh-i-jsp-chastjh-1)
* [JavaRush Создание веб-проекта в IntelliJ Idea Enterprise](https://javarush.ru/groups/posts/305-sozdanie-prosteyshego-web-proekta-v-intellij-idea-enterprise-edition-poshagovo-s-kartinkami)
* [JavaRush web application IntelliJ](https://javarush.ru/quests/lectures/questcollections.level09.lecture02)
___

### Кодировка JSP
```HTML
	<head><title>Title</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<%@ page language="java" contentType="text/html;charset=UTF-8"%>
		<%@ page pageEncoding="Utf-8"%>

		<%
			//String value = new String(request.getParameter(field).getBytes("ISO-8859-1"),"UTF-8").replace(' ', '_');
		%>
	</body>
```
---
### Кодировка Servlet:
```
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
	//...
    }

```

---
[Руководство по Java EE/Jakarta EE](https://metanit.com/java/javaee/)
---
## Задания:
* Установить Tomcat
	* [Tomcat](http://tomcat.apache.org/)
* Создать WebApp
	* [JAVARUSH](https://javarush.ru/quests/lectures/questcollections.level09.lecture02)
* Изучить JSP
* Изучить Servlets
* Изучить Java Beans
