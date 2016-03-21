<%@page import="controller.daodiembanve"%>
<%@page import="controller.ConnectSQL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png"
	href="img/Fasticon-Happy-Bus-Bus-green.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Điểm bán vé</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="css/animate.min.css" rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link href="css/light-bootstrap-dashboard.css" rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="css/demo.css" rel="stylesheet" />
<link href="css/custom.css" rel="stylesheet">

<!--   Core JS Files   -->
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="js/demo.js"></script>



<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-color="purple"
			data-image="assets/img/sidebar-5.jpg">

			<!--

            Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
            Tip 2: you can also add an image using data-image tag

        -->

			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="http://facebook.com" class="text-center"> Fast Bus </a>
				</div>

				<ul class="nav">
					<li><a href="Home.jsp"> <i class="pe-7s-graph"></i>
							<p>Home</p>
					</a></li>
					<li><a href="TuyenBus.jsp"> <i class="pe-7s-car"></i>
							<p>Tuyến bus</p>
					</a></li>
					<li class="active"><a href="Diembanve.jsp"> <i
							class="pe-7s-home"></i>
							<p>Điểm bán vé</p>
					</a></li>
					<li><a href="Diemdung.jsp"> <i class="pe-7s-close"></i>
							<p>Điểm dừng</p>
					</a></li>
					<li><a href="maps.jsp"> <i class="pe-7s-map-marker"></i>
							<p>Maps</p>
					</a></li>
					<li><a href="Danhsachnguoidung.jsp"> <i
							class="pe-7s-add-user"></i>
							<p>Người dùng</p>
					</a></li>
					<li><a href="user.jsp"> <i class="pe-7s-user"></i>
							<p>User Profile</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default navbar-fixed">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#navigation-example-2">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Danh sách tuyến xe </a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-left">
							<li><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-dashboard"></i>
							</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-globe"></i> <b
									class="caret"></b> <span class="notification">5</span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Notification 1</a></li>
									<li><a href="#">Notification 2</a></li>
									<li><a href="#">Notification 3</a></li>
									<li><a href="#">Notification 4</a></li>
									<li><a href="#">Another notification</a></li>
								</ul></li>
							<li><a href=""> <i class="fa fa-search"></i>
							</a></li>
						</ul>

						<ul class="nav navbar-nav navbar-right">
							<li><a href=""> Account </a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> Dropdown <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul></li>
							<li><a href="#"> Log out </a></li>
						</ul>
					</div>
				</div>
			</nav>

			<button id="them" class="btn btn-primary.active"
				style="margin: 20px;">Thêm</button>

			<script type="text/javascript">
				$(document).ready(function() {
					$("#them").click(function() {
						$("#list").hide(function() {
							$("#add").show(function() {
								$("#them").hide();
							});
						});
					});
				});
			</script>

			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div id="add" class="card" style="display: none;">
								<div class="header">
									<h4>Thêm mới điểm bán vé</h4>
								</div>
								<div class="content">
								<form action="addsell" method="post">
									<div class="row">
										<div class="col-md-3" style="margin-top: 7px;">Tên điểm
											bán vé</div>
										<div class="col-md-7">
											<input type="text" name="ten" class="form-control">
										</div>
									</div>
									<div class="row">
										<div class="col-md-3" style="margin-top: 7px;">Kinh độ</div>
										<div class="col-md-7">
											<input type="text" name="kinhdo" class="form-control">
										</div>
									</div>
									<div class="row">
										<div class="col-md-3" style="margin-top: 7px;">Vĩ độ</div>
										<div class="col-md-7">
											<input type="text" name="vido" class="form-control">
										</div>
									</div>
									<div class="row">
										<div class="col-md-3" style="margin-top: 7px;">Giờ mở
											cửa</div>
										<div class="col-md-7">
											<input type="text" name="batdau" class="form-control">
										</div>
									</div>
									<div class="row">
										<div class="col-md-3" style="margin-top: 7px;">Giờ đóng
											cửa</div>
										<div class="col-md-7">
											<input type="text" name="giodong" class="form-control">
											<div class="row text-right">
												<button class="btn btn-primary.active.focus">Hủy bỏ</button>
												<input type="submit" value="Thêm"
													class="btn btn-primary.active.focus">
											</div>
										</div>
									</div>
                                </form>
								</div>
							</div>
							<div id="list" class="card">
								<div class="header">
									<h4 class="title">Danh sách điểm bán vé</h4>
								</div>

								<%
									daodiembanve diembanve = new daodiembanve();
								%>
								<pg:pager maxIndexPages="5" maxPageItems="5">
									<div class="content table-responsive table-full-width">
										<table class="table table-hover table-striped">
											<tr>
												<th>ID</th>
												<th>Tên</th>
												<th>Kinh độ</th>
												<th>Vĩ độ</th>
												<th>Giờ mở cửa</th>
												<th>Giờ đóng cửa</th>
											</tr>
											<c:forEach var="diemban" items="<%=diembanve.getSell()%>">
												<pg:item>
													<tr>
														<td>${diemban.getId()}</td>
														<td>${diemban.getName() }</td>
														<td>${diemban.getLongitude() }</td>
														<td>${diemban.getLatitude() }</td>
														<td>${diemban.getHourOpen() }</td>
														<td>${diemban.getHourClose() }</td>

													</tr>
												</pg:item>
											</c:forEach>
										</table>
									</div>
									<div class="row text-center">
										<div class="col-md-4 col-md-offset-4">
											<pg:index>
												<pg:prev>
													<a href="<%=pageUrl%>"> << </a>
												</pg:prev>
												<pg:pages>
													<c:if test="${pageNumber == pagerPageNumber }">
														<%=pageNumber%>
													</c:if>
													<a href="<%=pageUrl%>" class="btn btn-primary.active.focus"><%=pageNumber%></a>
												</pg:pages>
												<pg:next>
													<a href="<%=pageUrl%>"> >> </a>
												</pg:next>
											</pg:index>
								</pg:pager>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<footer class="footer">
			<div class="container-fluid">
				<nav class="pull-left">
					<ul>
						<li><a href="#"> Trang chủ </a></li>
						<li><a href="#"> Giới thiệu </a></li>
						<li><a href="#"> Tư vấn </a></li>
						<li><a href="#"> Quảng cáo </a></li>
					</ul>
				</nav>
				<p class="copyright pull-right">
					&copy; hienlm94@gmail.com <a
						href="http://https://www.facebook.com/hienlm94">Mạnh Hiển</a> dev
				</p>
			</div>
		</footer>


	</div>
	</div>
</body>


</html>
