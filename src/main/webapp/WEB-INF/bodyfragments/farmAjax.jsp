<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                    <h4>Farm</h4>
                </div>
                <%--<div class="alert alert-success background-success">--%>
                    <%--<button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
                        <%--<i class="icofont icofont-close-line-circled text-white"></i>--%>
                    <%--</button>--%>
                    <%--<strong>Success!</strong> Add Class <code> background-success</code>--%>
                <%--</div>--%>
                <div class="card-block">
                    <!-- DIFFERENT START -->
                    <div class="block-button icon-btn">
                        <!-- Modal large-->
                        <button id="btn-modal" type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-modal"><i class="fas fa-plus"></i></button>
                        <div class="modal fade" id="add-modal" tabindex="-1" role="dialog">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Add New Farm</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <!-- <span aria-hidden="true">&times;</span> -->
                                            <i class="far fa-times"></i>
                                        </button>
                                    </div>
                                    <%-- FORM START--%>
                                    <form id="farm-form">
                                    <div class="modal-body">
                                        <input type="hidden" name="farmId" id="farmId" value="">
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Description</label>
                                            <div class="col-sm-10">
                                                <textarea rows="5" cols="5" class="form-control" name="description" id="description" placeholder="description"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button id="btn-close-modal" type="button" class="btn btn-default waves-effect " data-dismiss="modal">Close</button>
                                        <button id="btn-submit" type="submit" class="btn btn-primary waves-effect waves-light ">Save</button>
                                    </div>
                                    </form>
                                    <%-- FORM END--%>
                                </div>
                            </div>
                        </div>
                        <button id="refresh-table" class="btn btn-success"><i class="fas fa-sync-alt"></i></button>
                    </div>
                    <!-- DIFFERENT END -->
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
                            <%--<tr>--%>
                                <%--<td></td>--%>
                                <%--<td></td>--%>
                                <%--<td>--%>
                                    <%--<div style="text-align: left;">--%>
                                        <%--<button type="button" class="btn icon-btn btn-info waves-effect waves-light" onclick="location.href=''">--%>
                                            <%--<i class="far fa-edit"></i>--%>
                                        <%--</button>--%>
                                        <%--<button type="button" class="btn icon-btn btn-primary waves-effect waves-light" onclick="location.href=''">--%>
                                            <%--<i class="far fa-trash-alt"></i>--%>
                                        <%--</button>--%>
                                        <%--<button type="button" class="btn icon-btn btn-danger waves-effect waves-light" onclick="location.href=''">--%>
                                            <%--<i class="far fa-trash-alt"></i>--%>
                                        <%--</button>--%>
                                    <%--</div>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="block-absolute notification">
    <div class="alert icons-alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <i class="icofont icofont-close-line-circled"></i>
        </button>
        <p><strong>Success!</strong> Add Class <code>alert-success icons-alert</code></p>
    </div>
</div>