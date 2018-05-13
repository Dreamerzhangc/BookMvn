<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加书籍</title>
<!--  1.告诉浏览器不要缩放-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bs/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<style type="text/css">
</style>
</head>
<body>
	<div class="container-fluid ">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" role="form" method="post"
					action="bookadd" id="loginFrm" enctype="multipart/form-data">
					<div class="form-group">

						<label for="inputName" class="col-sm-2 control-label"> 书名:
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputName"
								name="name"
								value="<%=request.getAttribute("name") == null ? "" : request.getAttribute("name")%>" />
						</div>
					</div>
					<div class="form-group">

						<label for="textAreaDecri" class="col-sm-2 control-label">
							描述： </label>
						<div class="col-sm-10">
							<textarea name="descri" class="form-control" id="textAreaDecri"></textarea>
						</div>
					</div>
					<div class="form-group">

						<label for="inputPhoto" class="col-sm-2 control-label">
							照片： </label>
						<div class="col-sm-10">
							<input class="form-control" id="inputPhoto" type="file"
								name="photo" />

						</div>
					</div>
					<div class="form-group">

						<label for="inputPrice" class="col-sm-2 control-label">
							价格： </label>
						<div class="col-sm-10">
							<input class="form-control" id="inputPrice" type="text"
								name="price" />

						</div>
					</div>
					<div class="form-group">

						<label for="inputPubdate" class="col-sm-2 control-label">
							出版时间： </label>
						<div class="col-sm-10">
							<input class="form-control" id="inputPubdate" type="text"
								name="pubdate" />

						</div>
					</div>
					<div class="form-group">

						<label for="inputAuthor" class="col-sm-2 control-label">
							作者： </label>
						<div class="col-sm-10">
							<input class="form-control" id="inputAuthor" type="text"
								name="author" />

						</div>
					</div>
					<div class="form-group">

						<label for="selectTid" class="col-sm-2 control-label"> 类型：
						</label>
						<div class="col-sm-10">
							<select name="tid" class="form-control" id="selectTid">
								<option value="1">电子书</option>
								<option value="2">软件编程</option>
								<option value="3">生物化学</option>
							</select>

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

							<button type="submit" class="btn btn-default">提交</button>
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
		src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js">
		
	</script>
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
			$("#inputPubdate").datepicker({
				format : "yyyy-mm-dd",
				language: "zh-CN",
				autoclose:true
			});
		});
	</script>
</body>
</html>