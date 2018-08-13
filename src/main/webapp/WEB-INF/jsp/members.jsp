<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-5  toppad  pull-right col-md-offset-5 ">
            <a href="<c:url value="/home" />" >Home</a> |
            <a href="<c:url value="/profile/${username}" />" >Edit Profile</a> |
            <a href="<c:url value="/logout" />">Logout</a>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Здравствуйте, ${user.username}, вот список всех пользователей</h3>
                </div>


                <div class="row p-5">
                    <div class="col-md-12">
                        <table class="table">
                            <thead>
                            <tr>
                                <th class="border-0 text-uppercase small font-weight-bold">Username</th>
                                <th class="border-0 text-uppercase small font-weight-bold">First Name</th>
                                <th class="border-0 text-uppercase small font-weight-bold">Last Name</th>
                                <th class="border-0 text-uppercase small font-weight-bold">Gender</th>
                                <th class="border-0 text-uppercase small font-weight-bold">City</th>
                                <th class="border-0 text-uppercase small font-weight-bold">Invite</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${profiles}" var="profile">
                                <tr>
                                    <td>${profile.user.username}</td>
                                    <td>${profile.first_name}</td>
                                    <td>${profile.last_name}</td>
                                    <td>${profile.gender}</td>
                                    <td>${profile.city}</td>
                                    <td><a href="<c:url value="/friend/invite/${profile.user.username}"/>">button</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<!-- /container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>