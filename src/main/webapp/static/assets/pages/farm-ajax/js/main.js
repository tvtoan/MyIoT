$(document).ready(function () {
    load_data();
});

$('#btn-modal').click(function () {
    $("#farm-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        handle_add_form();
    });
});

$('#refresh-table').click(function() {
    load_data();
});

function load_data() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/farmajax",
        dataType: 'json',
        success: function (data) {
            // var jsonObject = JSON.parse(data);
            console.log(data['data'].length);
            // $('#new-cons tr').html(json);
            if (data['data'].length !== 0) {
                $('#new-cons tbody tr:first-child').css('display', 'none');
            }
            var htmlFarm = "";
            data['data'].forEach(function (farm) {
            htmlFarm += "<tr>\n" +
                "    <td>"+ farm.farmId +"</td>\n" +
                "    <td>"+ farm.description +"</td>\n" +
                "    <td>\n" +
                "        <div style=\"text-align: left;\">\n" +
                "            <button id=\"btn-detail\" type=\"button\" class=\"btn icon-btn btn-info waves-effect waves-light\" onclick=\"+ handle_detail("+ farm.farmId + ")\">\n" +
                "                <i class=\"far fa-info\"></i>\n" +
                "            </button>\n" +
                "            <button id=\"btn-edit\" type=\"button\" class=\"btn icon-btn btn-primary waves-effect waves-light\" onclick=\"+ handle_edit(" + farm.farmId + ")\">\n" +
                "                <i class=\"far fa-edit\"></i>\n" +
                "            </button>\n" +
                "            <button id=\"btn-delete\" type=\"button\" class=\"btn icon-btn btn-danger waves-effect waves-light\" onclick=\"handle_delete(" + farm.farmId + ")\">\n" +
                "                <i class=\"far fa-trash-alt\"></i>\n" +
                "            </button>\n" +
                "        </div>\n" +
                "    </td>\n" +
                "</tr>";
            });

            $('#new-cons tbody').html(htmlFarm);

        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}

function handle_add_form() {
    var requestBody = {};
    requestBody['farmId'] = $("#farmId").val();
    console.log($("#farmId").val());
    requestBody['description'] = $("#description").val();
    $('#btn-submit').prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/farmajax",
        data: JSON.stringify(requestBody),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("SUCCESS : ", data);
            $('#btn-submit').prop("disabled", false);
            $('.block-absolute.notification > div').addClass('alert-success');
            $('.block-absolute.notification').css('display', 'block');
            $('.block-absolute.notification div p').html(data.msg);
            load_data();
        },
        error: function (e) {
            console.log("ERROR : ", e);
            var jsonError = JSON.parse(e.responseText);
            $('#btn-submit').prop("disabled", false);
            $('.block-absolute.notification').addClass('error');
            $('.block-absolute.notification > div').addClass('alert-warning');
            $('.block-absolute.notification div p').html(jsonError.msg[0].arguments[0].defaultMessage + ": " + jsonError.msg[0].defaultMessage);
            $('.block-absolute.notification').css('display', 'block');
        }
    });
}

function handle_detail(id) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/farmajax/" + id,
        dataType: 'json',
        success: function (data) {
            console.log("SUCCESS : ", data);
            if (data.isFound) {
                $("#farmId").val(data['data'].farmId);
                $("#description").val(data['data'].description);
                $('#add-modal').modal('show');
                $('#description').prop("disabled", true);
                $('#btn-submit').prop("disabled", true);
                $('#btn-submit').css('display', 'none');
                $('#add-modal .modal-title').html('Detail FarmId ' + data['data'].farmId);
            }
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}

function handle_edit(id) {
    $('#add-modal .modal-title').html('Update FarmId ' + id);

    $('#add-modal').modal('show');

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/farmajax/" + id,
        dataType: 'json',
        success: function (data) {
            $("#description").val(data['data'].description)
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

    $("#farm-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();

        var requestBody = {};
        requestBody['farmId'] = id;
        requestBody['description'] = $("#description").val();
        $('#btn-submit').prop("disabled", true);

        $.ajax({
            type: "PUT",
            contentType: "application/json",
            url: "/farmajax/" + id,
            data: JSON.stringify(requestBody),
            dataType: 'json',
            success: function (data) {
                console.log("SUCCESS : ", data);
                $('#btn-submit').prop("disabled", true);
                $('.block-absolute.notification > div').addClass('alert-success');
                $('.block-absolute.notification').css('display', 'block');
                $('#btn-close-modal').click();
                $('.block-absolute.notification div p').html(data.msg);
                load_data();
            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });
    });
}

function handle_delete(id) {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/farmajax/" + id,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("SUCCESS : ", data);
            $('.block-absolute.notification > div').addClass('alert-err');
            $('.block-absolute.notification').css('display', 'block');
            $('.block-absolute.notification div p').html(data.msg);
            load_data();
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}