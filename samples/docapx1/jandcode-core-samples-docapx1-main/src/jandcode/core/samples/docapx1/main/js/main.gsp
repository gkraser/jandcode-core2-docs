<%@ page import="jandcode.core.jsa.gsp.*; jandcode.core.web.*; jandcode.commons.*; jandcode.core.web.gsp.*" %>
<!doctype html>
<%
  BaseGsp th = this
  //
  def ctx = th.inst(JsaIndexGspContext)
  //
  ctx.title = "JandcodeCoreSamplesDocapx1"
  ctx.main = th.path("./main.js")
  ctx.env = th.path("./vendor.js")
  ctx.theme = "apx-std"
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>${ctx.title}</title>
  <link rel="icon" href="data:,">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<div id="jc-app"></div>
<% ctx.outLinkModules() %>
<script>
    Jc.cfg.set(${ctx.cfgJson})
    Jc.ready(function() {
        require('${ctx.main}').run()
    })
</script>
</body>
</html>
