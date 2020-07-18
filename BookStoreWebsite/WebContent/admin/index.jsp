<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Jade & Gem Admin Panel</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body>
	<jsp:include page="topbar.jsp"></jsp:include>
	<div class="container clearfix">
		<jsp:include page="sidebar.jsp"></jsp:include>
	    <div class="main-wrap">
	        <div class="crumb-wrap">
	            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>Welcome to J&G Admin panel!</span></div>
	        </div>
	        <div class="result-wrap">
	            <div class="result-title">
	                <h1>Quick Actions</h1>
	            </div>
	            <div class="result-content">
	                <div class="short-wrap">
	                    <a href="insert.html"><i class="icon-font">&#xe001;</i>New Book</a>
	                    <a href="insert.jsp"><i class="icon-font">&#xe005;</i>New User</a>
	                    <a href="insert.html"><i class="icon-font">&#xe048;</i>New Category</a>
	                </div>
	            </div>
	        </div>
	        <div class="result-wrap">
	            <div class="result-title">
	                <h1>System Information</h1>
	            </div>
	            <div class="result-content">
	                <ul class="sys-info-list">
	                    <li>
	                        <label class="res-lab">Operating System</label><span class="res-info">WINNT</span>
	                    </li>
	                    <li>
	                        <label class="res-lab">Environment</label><span class="res-info">Apache/2.2.21 (Win64) PHP/7.3.10</span>
	                    </li>
	                    <li>
	                        <label class="res-lab">PHP Execution Method</label><span class="res-info">apache2handler</span>
	                    </li>
	                    <li>
	                        <label class="res-lab">Date & Time in PST</label><span class="res-info">2020年7月16日 21:08:24</span>
	                    </li>
	                    <li>
	                        <label class="res-lab">Domain Name/IP</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
	                    </li>
	                    <li>
	                        <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </div>
    <!--/main-->
</div>
</body>
</html>