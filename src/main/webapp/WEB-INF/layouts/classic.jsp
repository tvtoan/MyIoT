<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:importAttribute name="cssPluginByPage"/>
<tiles:importAttribute name="cssByPage"/>
<tiles:importAttribute name="jsByPage"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Adminty - Premium Admin Template by Colorlib </title>
    <!-- HTML5 Shim and Respond.js IE10 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 10]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Meta -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="#" />
    <meta name="keywords" content="Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app" />
    <meta name="author" content="#" />
    <!-- Favicon icon -->
    <link rel="icon" href="/static/assets/images/favicon.ico" type="image/x-icon">
    <!-- Google font-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet" />
    <!-- Required Framwork -->
    <link rel="stylesheet" type="text/css" href="/static/plugins/bootstrap/bootstrap.min.css" />
    <!-- ico font -->
    <link rel="stylesheet" type="text/css" href="/static/assets/icon/icofont/css/icofont.css">
    <!-- feather Awesome -->
    <link rel="stylesheet" type="text/css" href="/static/assets/icon/feather/css/feather.css" />
    <!-- FontsAwesome -->
    <link rel="stylesheet" type="text/css" href="/static/assets/icon/fontawesome/css/all.min.css" />
    <!-- CSS Plugin by page -->
    <c:forEach var="css" items="${cssPluginByPage}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>

    <!-- Style.css -->
    <link rel="stylesheet" type="text/css" href="/static/assets/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/static/assets/css/style-addnew.css" />
    <link rel="stylesheet" type="text/css" href="/static/assets/css/jquery.mCustomScrollbar.css" />
    <!-- CSS by page -->
    <c:forEach var="css" items="${cssByPage}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
</head>

<body>
<!-- Pre-loader start -->
<div class="theme-loader">
    <div class="ball-scale">
        <div class='contain'>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
        </div>
    </div>
</div>
<!-- Pre-loader end -->
<div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">

        <!-- HEADER START -->
        <tiles:insertAttribute name="header" />
        <!-- HEADER END -->

        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">

                <!-- SIDEBAR START -->
                <tiles:insertAttribute name="sidebar" />
                <!-- SIDEBAR END -->

                <div class="pcoded-content">
                    <div class="pcoded-inner-content">
                        <div class="main-body">
                            <div class="page-wrapper">

                                <!-- BODY START -->
                                <tiles:insertAttribute name="body" />
                                <!-- BODY END -->

                            </div>

                            <!-- Handled by file ..\files\assets\js\script.min.js -->
                            <!-- <div id="styleSelector">

                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Warning Section Starts -->
<!-- Older IE warning message -->
<!--[if lt IE 10]>
<div class="ie-warning">
    <h1>Warning!!</h1>
    <p>You are using an outdated version of Internet Explorer, please upgrade <br/>to any of the following web browsers to access this website.</p>
    <div class="iew-container">
        <ul class="iew-download">
            <li>
                <a href="http://www.google.com/chrome/">
                    <img src="../files/assets/images/browser/chrome.png" alt="Chrome">
                    <div>Chrome</div>
                </a>
            </li>
            <li>
                <a href="https://www.mozilla.org/en-US/firefox/new/">
                    <img src="../files/assets/images/browser/firefox.png" alt="Firefox">
                    <div>Firefox</div>
                </a>
            </li>
            <li>
                <a href="http://www.opera.com">
                    <img src="../files/assets/images/browser/opera.png" alt="Opera">
                    <div>Opera</div>
                </a>
            </li>
            <li>
                <a href="https://www.apple.com/safari/">
                    <img src="../files/assets/images/browser/safari.png" alt="Safari">
                    <div>Safari</div>
                </a>
            </li>
            <li>
                <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">
                    <img src="../files/assets/images/browser/ie.png" alt="">
                    <div>IE (9 & above)</div>
                </a>
            </li>
        </ul>
    </div>
    <p>Sorry for the inconvenience!</p>
</div>
<![endif]-->
<!-- Warning Section Ends -->
<!-- Required Jquery -->
<script type="text/javascript" src="/static/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/static/plugins/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript" src="/static/plugins/popper.js/popper.min.js"></script>
<script type="text/javascript" src="/static/plugins/bootstrap/bootstrap.min.js"></script>
<!-- jquery slimscroll js -->
<script type="text/javascript" src="/static/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>
<!-- modernizr js -->
<script type="text/javascript" src="/static/plugins/modernizr/modernizr.js"></script>
<script type="text/javascript" src="/static/plugins/modernizr/css-scrollbars.js"></script>

<!-- JS by page -->
<c:forEach var="script" items="${jsByPage}">
    <script type="text/javascript" src="<c:url value="${script}"/>"></script>
</c:forEach>
<!-- custom js -->
<script src="/static/assets/js/pcoded.min.js"></script>
<script src="/static/assets/js/vartical-layout.min.js"></script>
<script src="/static/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script type="text/javascript" src="/static/assets/js/script.min.js"></script>
</body>

</html>
