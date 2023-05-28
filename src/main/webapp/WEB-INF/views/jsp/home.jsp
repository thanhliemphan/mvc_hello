<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <html>
        <style>
          <%@include file="/resources/css/main.css" %>
        </style>
        <jsp:include page="header.jsp" />

        <body>
          <div class="contain pt-10">
            <!-- Input group -->
            <form:form action="search" method="get">
              <div class="d-flex ">
                <div class="input-group w-auto">
                  <input name="searchInput" type="text" class="form-control" placeholder="Search input" aria-label="Search input"/>
                  <button class="btn btn-primary" type="submit"  data-mdb-ripple-color="dark">Search
                  </button>
                </div>
              </div>
            </form:form>

            <div class="mt-10">
              <p>
                <c:out value="${msg}" />
              </p>
              <c:if test="${empty bookList}">
                <p>No data</p>
              </c:if>
              <c:if test="${not empty bookList}">
                <table class="table">
                  <thead class="thead-dark">
                    <tr>
                      <th scope="col">Id</th>
                      <th scope="col">Name</th>
                      <th scope="col">Author</th>
                      <th scope="col">ISBN</th>
                      <th scope="col">Price</th>
                      <th scope="col">Number Of Page</th>
                      <th scope="col">Publish Date</th>
                      <th scope="col">Category</th>
                      <th scope="col"></th>
                      <th scope="col"></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="book" items="${bookList}" varStatus="e">
                      <tr>
                        <td>${book.id}</td>
                        <td>${book.name}</td>
                        <td>${book.author}</td>
                        <td>${book.bookDetails.isbn}</td>
                        <td>${book.bookDetails.price}</td>
                        <td>${book.bookDetails.numberOfPage}</td>
                        <td>${book.bookDetails.publishDate}</td>
                        <td>${book.category.name}</td>
                        <td><button class="btn btn-sm btn-primary"
                            onclick="location.href='edit/${book.id}'">Edit</button></td>
                        <td><button class="btn btn-sm btn-danger"
                            onclick="location.href='delete/${book.id}'">Delete</button></td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </c:if>

              <div>
              </div>
        </body>

        </html>