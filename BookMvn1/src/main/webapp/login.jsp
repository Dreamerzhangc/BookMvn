<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!--  1.告诉浏览器不要缩放-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bs/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.container-fluid {
	width: 40%;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -295px;
	margin-top: -110px;
}
</style>
</head>
<body>
	<div class="container-fluid ">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" role="form" method="post"
					action="login" id="loginFrm">
					<div class="form-group">
						<%
							if (request.getAttribute("msg") != null) {
						%>
						<div class="alert alert-warning" role="alert"><%=request.getAttribute("msg")%></div>
						<%
							}
						%>
						<label for="inputName" class="col-sm-2 control-label"> 用户名
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputName"
								name="name"
								value="<%=request.getAttribute("name") == null ? "" : request.getAttribute("name")%>" />
						</div>
					</div>
					<div class="form-group">

						<label for="inputPwd" class="col-sm-2 control-label"> 密码 </label>
						<div class="col-sm-10">
							<input class="form-control" id="inputPwd" type="password"
								name="pwd" />
						</div>
					</div>
					<div class="form-group">

						<label for="inputVcode" class="col-sm-2 control-label">
							验证码</label>
						<div class="col-sm-7">
							<input class="form-control" id="inputVcode" type="text"
								name="vcode" maxlength="4" />

						</div>
						<div class="col-sm-3">
							<img alt="" src="vcode.png" id="vcodeImg" title="点击换图片">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">

							<button type="submit" class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="bs/js/jquery.min.js"></script>
	<script type="text/javascript" src="bs/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
	<script type="text/javascript"
		src="bower_components/jquery-validation-bootstrap-tooltip/jquery-validate.bootstrap-tooltip.js">
	</script>
	<script type="text/javascript">
		$(function() {
			$("#vcodeImg").click(function(evt) {
				//不加不会变图片，因为直接调用缓存，加一个参数就好了
				this.src = "vcode.png?t=" + Math.random();
			});
			$("#loginFrm").validate({
				rules : {
					name : {
						required : true
					},
					pwd : {
						required : true
					}
				},
				messages : {
					name : "必须填写",
					pwd : "必须填写"
				},
				tooltip_options : {
					name : {
						placement : "bottom"
					},
					pwd : {
						placement : " right"
					}
				}
			});
		});
	</script>
</body>
</html>