<%@ page import="jandcode.commons.*; jandcode.core.*; jandcode.core.web.*; jandcode.core.web.gsp.*;" %>
<!doctype html>
<%
  BaseGsp th = this
  def vCore = UtVersion.getVersion("jandcode.core")
  def curDate = UtDateTime.now()
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>About</title>
</head>

<body>
<h1>About</h1>

<div>
  Current date: <b>${curDate}</b>
</div>

<div>
  jandcode.core Version: <b>${vCore}</b>
</div>

<div>
  Request params: <b>${th.request.params}</b>
</div>

</body>
</html>