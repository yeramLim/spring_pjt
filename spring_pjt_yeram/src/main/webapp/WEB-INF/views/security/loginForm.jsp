<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>로그인 / 회원가입</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/login/style.css">
    </head>
    <body>
        <div class="wrap">
            <div class="form-wrap">
                <div class="button-wrap">
                    <div id="btn"></div>
                    <button type="button" class="togglebtn" onclick="login()">LOG IN</button>
                    <button type="button" class="togglebtn" onclick="register()">REGISTER</button>
                </div>
<%--                 <div class="social-icons">
                    <img src="${pageContext.request.contextPath}/resources/login/img/fb.png" alt="facebook">
                    <img src="${pageContext.request.contextPath}/resources/login/img/tw.png" alt="twitter">
                    <img src="${pageContext.request.contextPath}/resources/login/img/gl.png" alt="google">
                </div> --%>
                
                <c:url value="j_spring_security_check" var="loginUrl"/>
                <form method="post" action="${loginUrl}" id="login" class="input-group"  >
                	<!-- 로그인 실패 -->
                	<c:if test="${param.ng != null }">
                		<p>
                			Login NG!<br>
                			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != NULL }">
                				message : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message }"/>
                			</c:if>
                		</p>
                	</c:if>
                	
                    <input type="text" class="input-field" name="j_username" placeholder="Email" required>
                    <input type="password" class="input-field" name="j_password" placeholder="Enter Password" required>
                    <input type="checkbox" class="checkbox"><span>Remember Password</span>
                    <button class="submit">Login</button>
                </form>
                <form method="post" id="register" action="${pageContext.request.contextPath}/member/resist_ok" class="input-group">
                    <input type="text" class="input-field" name="userEmail" placeholder="Email" required>
                    <input type="tel" class="input-field" name="userTel" placeholder="TEL" required>
                    <input type="password" class="input-field" name="userPassword" placeholder="Enter Password" required>
                    <input type="checkbox" class="checkbox"><span>개인정보 수집 동의</span>
                    <button class="submit">REGISTER</button>
                </form>
            </div>
        </div>
        <script>
            var x = document.getElementById("login");
            var y = document.getElementById("register");
            var z = document.getElementById("btn");
            
            
            function login(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }

            function register(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
            }
        </script>
    </body>
</html>