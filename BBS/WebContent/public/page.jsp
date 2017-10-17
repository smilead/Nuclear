<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  <nav>
    <ul class="pagination">
      <li>
        <a href="<c:url value="${requestScope.page.servlet}?search=${requestScope.page.search }&currentPage=${requestScope.page.currentPage>1 ? requestScope.page.currentPage-1 : requestScope.page.totalPage}&pageSize=${requestScope.page.pageSize }"/>" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <c:forEach var="index" begin="${requestScope.page.currentPage>5 ? (requestScope.page.totalPage<11 ? 1 : requestScope.page.currentPage-5) : 1 }" end="${requestScope.page.totalPage>11 ? (requestScope.page.currentPage>5 ? (requestScope.page.currentPage<=requestScope.page.totalPage-5 ? requestScope.page.currentPage+5 : requestScope.page.totalPage) : 11) : requestScope.page.totalPage}" step="1">
      	<c:if test="${requestScope.page.currentPage==index}">
      		<li ><a style="background-color: #CCCCCC;" href="<c:url value="${requestScope.page.servlet}?search=${requestScope.page.search }&currentPage=${index}&pageSize=${requestScope.page.pageSize }"/>">${index}</a></li>
      	</c:if> 
     <c:if test="${requestScope.page.currentPage!=index }">
     		<li><a href="<c:url value="${requestScope.page.servlet}?search=${requestScope.page.search }&currentPage=${index}&pageSize=${requestScope.page.pageSize }"/>">${index}</a></li>
       	</c:if>
      </c:forEach>
      <li>
        <a href="<c:url value="${requestScope.page.servlet}?search=${requestScope.page.search }&currentPage=${requestScope.page.currentPage<requestScope.page.totalPage ? requestScope.page.currentPage+1 : 1}&pageSize=${requestScope.page.pageSize }"/>" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
</div>
