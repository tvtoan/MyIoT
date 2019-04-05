<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page body start -->
<div class="page-body">
    <div class="row">
        <div class="col-sm-12">
            <!-- Basic Form Inputs card start -->
            <div class="card">
                <div class="card-header">
                    <c:choose>
                        <c:when test="${farmForm.farmId == null}">
                            <h4>Add Farm</h4>
                        </c:when>
                        <c:otherwise>
                            <h4>Update Farm</h4>
                        </c:otherwise>
                    </c:choose>
                    <%--<h4>Add new farm</h4>--%>
                    <div class="card-header-right">
                    </div>
                </div>
                <div class="card-block">
                    <!-- <h4 class="sub-title">Basic Inputs</h4> -->
                    <spring:url value="/farm" var="farmActionUrl" />

                    <form:form modelAttribute="farmForm" method="post" action="${farmActionUrl}">
                        <form:hidden path="farmId" />
                        <%--<input name="farmId" type="hidden" value="${farm.farmId}"/>--%>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Description</label>
                            <div class="col-sm-10">
                                <form:textarea path="description" rows="5" cols="5" class="form-control" placeholder="description"/>
                                <form:errors path="description" />
                                <%--<textarea rows="5" cols="5" class="form-control" placeholder="description"></textarea>--%>
                            </div>
                        </div>
                        <%--<div class="form-group row">--%>
                            <%--<label class="col-sm-2 col-form-label">Street</label>--%>
                            <%--<div class="col-sm-10">--%>
                                <%--<input type="text" class="form-control" placeholder="street">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="form-group row">--%>
                            <%--<label class="col-sm-2 col-form-label">City</label>--%>
                            <%--<div class="col-sm-10">--%>
                                <%--<input type="text" class="form-control" placeholder="city">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="row button-right">
                            <!-- <button class="btn btn-default">Primary Button</button> -->
                            <%--<button type="submit" class="btn btn-primary">Add</button>--%>
                            <c:choose>
                            <c:when test="${farmForm.farmId == null}">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </c:when>
                            <c:otherwise>
                                <button type="submit" class="btn btn-primary">Update</button>
                            </c:otherwise>
                            </c:choose>
                        </div>
                    </form:form>
                </div>
            </div>
            <!-- Basic Form Inputs card end -->
        </div>
    </div>
</div>
<!-- Page body end -->