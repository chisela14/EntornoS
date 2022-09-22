<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p id="screen"></p>
<form action=calculator2.jsp method="post">
	<p><button type="button" name="7" value="7" onclick="getElementById('screen').innerHTML=value">7</button>
	<button type="button" name="8" value="8" onclick="getElementById('screen').innerHTML=value">8</button>
	<button type="button" name="9" value="9" onclick="getElementById('screen').innerHTML=value">9</button>
	<button type="button" name="operator" value="/" onclick="getElementById('screen').innerHTML=value">/</button>
	</p>
	<p><button type="button" name="4" value="4" onclick="getElementById('screen').innerHTML=value">4</button>
	<button type="button" name="5" value="5" onclick="getElementById('screen').innerHTML=value">5</button>
	<button type="button" name="6" value="6" onclick="getElementById('screen').innerHTML=value">6</button>
	<button type="button" name="operator" value="*" onclick="getElementById('screen').innerHTML=value">x</button>
	</p>
	<p><button type="button" name="1" value="1" onclick="getElementById('screen').innerHTML=value">1</button>
	<button type="button" name="2" value="2" onclick="getElementById('screen').innerHTML=value">2</button>
	<button type="button" name="3" value="3" onclick="getElementById('screen').innerHTML=value">3</button>
	<button type="button" name="operator" value="-" onclick="getElementById('screen').innerHTML=value">-</button>
	</p>
	<p><button type="button" name="7" value="0" onclick="getElementById('screen').innerHTML=value">0</button>
	<button type="button" name="," onclick="getElementById('screen').innerHTML=value">,</button>
	<button type="submit" name="=" onclick="getElementById('screen').innerHTML=value">=</button>
	<button type="button" name="operator" value="+" onclick="getElementById('screen').innerHTML=value">+</button>
	</p>
</form>
</body>
</html>