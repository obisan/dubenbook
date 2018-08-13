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

    <title>Log in with your account</title>

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
        <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
            <a href="<c:url value="/home" />" >Home</a> |

            <a href="<c:url value="/profile/edit/${profile.user.username}" />" >Edit Profile</a> |

            <a href="<c:url value="/logout" />">Logout</a>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Profile, ${profile.user.username}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="https://pp.userapi.com/TULJM8K-AasI3c9YSZYTLZbqQeEAzJkXwxZ6Hg/fMDANc9ivhI.jpg?ava=1" class="img-circle img-responsive"> </div>


                        <div class="col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                    <tr>
                                        <td>

                                            <form class="form" action="/profile/edit" method="post" id="registrationForm" modelAttribute="profile">
                                                <div class="form-group" hidden="hidden">

                                                    <div class="col-xs-6">
                                                        <input type="text" class="form-control" name="user.username" id="username" value="${profile.user.username}">
                                                    </div>
                                                </div>
                                                <div class="form-group">

                                                    <div class="col-xs-6">
                                                        <label for="first_name"><h4>First name</h4></label>
                                                        <input type="text" class="form-control" name="first_name" id="first_name" value="${profile.first_name}" title="enter your first name if any.">
                                                    </div>
                                                </div>
                                                <div class="form-group">

                                                    <div class="col-xs-6">
                                                        <label for="last_name"><h4>Last name</h4></label>
                                                        <input type="text" class="form-control" name="last_name" id="last_name" value="${profile.last_name}" title="enter your last name if any.">
                                                    </div>
                                                </div>

                                                <div class="form-group">

                                                    <div class="col-xs-6">
                                                        <label for="gender"><h4>Gender</h4></label>
                                                        <input type="text" class="form-control" name="gender" id="gender" value="${profile.gender}" title="enter your phone number if any.">
                                                    </div>
                                                </div>

                                                <div class="col-xs-6">
                                                    <label for="email"><h4>Email</h4></label>
                                                    <input type="email" class="form-control" name="user.email" id="email" value="${profile.user.email}" title="enter your email.">
                                                </div>

                                                <div class="form-group">

                                                    <div class="col-xs-6">
                                                        <label for="city"><h4>City</h4></label>
                                                        <input type="text" class="form-control" name="city" id="city" value="${profile.city}" title="enter a location">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-xs-12">
                                                        <br>
                                                        <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i>Save</button>
                                                    </div>
                                                </div>
                                            </form>

                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>



                    </div>
                </div>
                <div class="panel-footer">
                    <span class="pull-right">
                            <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                        </span>
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