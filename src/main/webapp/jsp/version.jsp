<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mil.dtic.common.utility.AppVersionInfo"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<title>Hello DTIC Version Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="PRAGMA" content="NO-CACHE" />
</head>

<body>
    <table border="0">
    <tr>
        <td/>
        <td>
            <a href=".."><img style="max-width:50px;max-height:25px;" src="../img/backButton.jpeg" alt="back to home page"></a><br>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <img style="max-width:400px;max-height:380px;" src="../img/version.png">
        </td>
        <td>
            <div id="content">
                <div class="instructionText">
                    <hr>
                    <p>
                    <strong>Version Info:</strong>
                    <p>
                    <%=AppVersionInfo.getVersionInfo().replace(",", "<br>").replace("{", "").replace("}", "")%>
                </div>
            </div>
        </td>
    </tr>
	</table>
</body>
</html>
