<%--
 Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.

  Number Guess Game
  Written by Jason Hunter, CTO, K&A Software
  http://www.servlets.com
--%>

<%@ page import = "mil.dtic.example.num.NumberGuessBean" %>

<jsp:useBean id="numguess" class="mil.dtic.example.num.NumberGuessBean" scope="session"/>
<jsp:setProperty name="numguess" property="*"/>
<html>
<head>
<script language="JavaScript">
function validate() {
    var valid= false;
    var guess=document.myform.guess.value;
    var low=document.myform.low.value;
    var high=document.myform.high.value;
    if (isNaN(guess)) {
        document.getElementById("msg").innerHTML="Enter Numeric value only";
    }
    else if (guess < low) {
        document.getElementById("msg").innerHTML="Enter equal to or higher than " + low;
    }
    else if (guess > high) {
        document.getElementById("msg").innerHTML="Enter equal to or lower than " + high;
    }
    else {
        valid = true;
    }
    alert ("valid [" + valid + "], guess [" + guess + "], low [" + low + "], high [" + high + "], ");
    return valid;
}
</script>
<title>Number Guess</title>
</head>
<body bgcolor="white">
<a href=".."><img style="max-width:50px;max-height:25px;" src="../img/backButton.jpeg" alt="back to home page"></a><br>
<br><img src="../img/guessNumber.png"><br>
<br>
<font size=4>

<% if (numguess.getSuccess()) { %>

  Congratulations!  You got it.
  And after just <%= numguess.getNumGuesses() %> tries.<p>

  <% numguess.reset(); %>

  Care to <a href="guessNumber.jsp">try again</a>?

<% } else if (numguess.getNumGuesses() == 0) { %>

  Welcome to the 'Guess the Number' game.<p>

  I'm thinking of a number between <%=numguess.getLowNum() %> and <%=numguess.getHighNum() %>.<p>

<% } else { %>

  Good guess, but not good enough.  Try <b><%= numguess.getHint() %></b>.

  You have made <%= numguess.getNumGuesses() %> guesses.<p>

  I'm thinking of a number between <%= numguess.getLowNum() %> and <%= numguess.getHighNum() %>.<p>

<% } %>
  <div id="msg"></div><p>
  <form name="myform" method=get>
  <input type="hidden" name="low" id="low" value="<%=numguess.getLowNum() %>">
  <input type="hidden" name="high" id="high" value="<%=numguess.getHighNum() %>">
  <input type="hidden" name="Answer" value="<%= numguess.getAnswer() %>">
  <input type="hidden" name="Hint" value="<%= numguess.getHint() %>">
  <input type="hidden" name="Success" value="<%= numguess.getSuccess() %>">
  What's your guess? <input type=text name=guess autofocus>
  <input type=submit name="submit" value="submit" onsubmit="javascript:validate();">
  </form>

</font>
  <p>
</body>
</html>