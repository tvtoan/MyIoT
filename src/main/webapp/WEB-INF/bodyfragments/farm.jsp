<!-- Page-header start -->
<!-- <div class="page-header"></div> -->
<!-- Page-header end -->

<!-- Page-body start -->
<div class="page-body">
    <div class="row">
        <div class="col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h4>Farm detail</h4>
                </div>
                <%--<div class="alert alert-success background-success">--%>
                    <%--<button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
                        <%--<i class="icofont icofont-close-line-circled text-white"></i>--%>
                    <%--</button>--%>
                    <%--<strong>Success!</strong> Add Class <code> background-success</code>--%>
                <%--</div>--%>
                <div class="card-block">
                    <div class="row">
                        <label class="col-sm-2 col-form-label">Id</label>
                        <div class="col-sm-10">
                            <p>${farm.farmId}</p>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-sm-2 col-form-label">Description</label>
                        <div class="col-sm-10">
                            <p>${farm.description}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Page-body end -->