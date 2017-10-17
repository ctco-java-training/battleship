<%--@elvariable id="playerManager" type="lv.ctco.battleship.model.PlayerManager"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Battleship</title>
</head>
<body>
<h1>Sorry, <c:out value="${playerManager.player.name}"/>!</h1>
<h2>Your opponent cancelled the game!</h2>
</body>
</html>