<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%
      // request, response 는 import없이 그냥 사용 가능
      MemberRepository memberRepository = MemberRepository.getInstance();

      System.out.println("MemberSaveServlet.service");
      String username = request.getParameter("username");
      int age =Integer.parseInt( request.getParameter("age"));

       Member member = new Member(username, age);
       memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>id=<%=member.getUsername()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>