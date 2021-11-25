<%@ page import="jandcode.commons.datetime.*; jandcode.commons.*; jandcode.commons.groovy.*" %>
<%
  def d = XDateTime.create("2011-11-23")
  def func1 = { p1 ->
    out("P1=${p1}")
  }
%>
<div>
  Hello! Date: ${d}
</div>

<% for (i in 1..5) { %>
item: ${i}
<% } %>

<jc:tag1 arg1="1" arg2="${d}">
  body1
  <% func1("one") %>
</jc:tag1>

End
