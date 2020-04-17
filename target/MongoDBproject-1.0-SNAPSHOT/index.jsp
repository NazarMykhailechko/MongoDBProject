<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <title>Currency rates</title>
  <style>
    .blue-button{
      background: #25A6E1;
      padding:3px 5px;
      color:#fff;
      font-family:'Helvetica Neue',sans-serif;
      font-size:12px;
      border-radius:2px;
      -moz-border-radius:2px;
      -webkit-border-radius:4px;
      border:1px solid #1A87B9
    }
    table {
      font-family: "Helvetica Neue", Helvetica, sans-serif;
      width: 1300px;
    }
    th {
      background: dimgrey;
      color: white;
    }
    td,th{
      border: 1px solid gray;
      text-align: left;
      padding: 5px 10px;
    }
  </style>

</head>
<body>

<br />


  <h3>Курси валют:</h3>
<c:if test="${!empty currRateList}">
  <table class="tg" style="background: black">
    <tr>
      <th>r030</th>
      <th>txt</th>
      <th>rate</th>
      <th>cc</th>
      <th>exchangedate</th>
    </tr>

    <c:forEach items="${currRateList}" var="currRate">
      <tr>
        <td style="color:yellow;width:300px">${currRate.r030}</td>
        <td style="color:limegreen">${currRate.txt}</td>
        <td style="color:magenta">${currRate.rate}</td>
        <td style="color:white">${currRate.cc}</td>
        <td style="color:magenta">${currRate.exchangedate}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>

</html>