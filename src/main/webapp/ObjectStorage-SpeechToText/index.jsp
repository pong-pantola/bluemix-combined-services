<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>Object Storage & Speech To Text</title>
    </head>
    <body>
        <form action="convert.jsp" method="post" enctype="multipart/form-data">
            Enter a WAV file to convert to text: <input type="file" name="file" /><br>
            <input type="submit" value="Convert" />
        </form>


        <br><br>
        Go back to  <a href= "../index.jsp">main menu</a>.
    </body>
</html>