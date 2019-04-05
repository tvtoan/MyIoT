<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Page-header start -->
<!-- <div class="page-header"></div> -->
<!-- Page-header end -->

<!-- Page-body start -->
<div class="page-body">
    <div class="row">
        <div class="col-sm-12">
            <!-- Config. table end -->
            <!-- `New` Constructor table start -->
            <div class="card">
                <div class="card-header">
                    <h4>List farms</h4>
                </div>
                <c:if test="${not empty msg}">
                <div class="alert alert-success background-success">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <i class="icofont icofont-close-line-circled text-white"></i>
                    </button>
                    <strong>${msg}</strong>
                </div>
                </c:if>
                <div class="card-block">
                    <!-- DIFFERENT START -->
                    <div class="block-button icon-btn">
                        <!-- Modal large-->
                        <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-modal"><i class="fas fa-plus"></i></button>--%>
                        <%--<div class="modal fade" id="add-modal" tabindex="-1" role="dialog">--%>
                            <%--<div class="modal-dialog modal-lg" role="document">--%>
                                <%--<div class="modal-content">--%>
                                    <%--<div class="modal-header">--%>
                                        <%--<h4 class="modal-title">Add New Farm</h4>--%>
                                        <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                                            <%--<!-- <span aria-hidden="true">&times;</span> -->--%>
                                            <%--<i class="far fa-times"></i>--%>
                                        <%--</button>--%>
                                    <%--</div>--%>
                                    <%--<div class="modal-body">--%>
                                        <%--<form>--%>
                                            <%--<div class="form-group row">--%>
                                                <%--<label class="col-sm-3 col-form-label">Simple Input</label>--%>
                                                <%--<div class="col-sm-9">--%>
                                                    <%--<input type="text" class="form-control" placeholder="Enter">--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                        <%--</form>--%>
                                    <%--</div>--%>
                                    <%--<div class="modal-footer">--%>
                                        <%--<button type="button" class="btn btn-default waves-effect " data-dismiss="modal">Close</button>--%>
                                        <%--<button type="button" class="btn btn-primary waves-effect waves-light ">Save changes</button>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <spring:url value="/farm/add" var="addUrl" />
                        <button class="btn btn-primary" onclick="location.href='${addUrl}'"><i class="fas fa-plus"></i></button>
                    </div>
                    <!-- DIFFERENT END -->
                    <c:choose>
                        <c:when test="${empty farms}">
                            <h5>Empty</h5>
                        </c:when>
                        <c:otherwise>
                            <div class="dt-responsive table-responsive">
                                <table id="new-cons" class="table table-striped table-bordered nowrap">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Description</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="farm" items="${farms}">
                                    <tr>
                                        <td>${farm.farmId}</td>
                                        <td>${farm.description}</td>
                                        <td>
                                            <spring:url value="/farm/${farm.farmId}" var="farmUrl" />
                                            <spring:url value="/farm/${farm.farmId}/update" var="updateUrl" />
                                            <spring:url value="/farm/${farm.farmId}/delete" var="deleteUrl" />

                                            <div style="text-align: left;">
                                                <button type="button" class="btn icon-btn btn-info waves-effect waves-light" onclick="location.href='${farmUrl}'">
                                                    <i class="far fa-info"></i>
                                                </button>
                                                <button type="button" class="btn icon-btn btn-primary waves-effect waves-light" onclick="location.href='${updateUrl}'">
                                                    <i class="far fa-edit"></i>
                                                </button>
                                                <button type="button" class="btn icon-btn btn-danger waves-effect waves-light" onclick="location.href='${deleteUrl}'">
                                                    <i class="far fa-trash-alt"></i>
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- Page-body end -->