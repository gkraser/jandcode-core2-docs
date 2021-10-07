<%@ page import="jandcode.commons.*; jandcode.core.*; jandcode.core.web.*; jandcode.core.web.gsp.*;" %>
<!doctype html>
<%
  BaseGsp th = this
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>

<body>
<h1>App</h1>
<jc:link path="public/main.bundle.js"/>
<script>
  MainApp.run()
</script>
</body>
</html>