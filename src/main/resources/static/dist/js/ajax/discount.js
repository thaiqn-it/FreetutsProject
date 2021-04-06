$(document).ready(function () {
    $("#form-create").submit(function (e) { 
        // Prevent page load when form submit
        e.preventDefault();

        $.ajax({
            type: "POST",
            url: $(this).attr("action"),
            data: $(this).serialize(),
            statusCode: {
                400: function() {;
                    alertify.notify('Duplicate discount code!', 'custom-error', 5);
                },
                200: function(data) {
                    console.log(data['id']);
                    populateToTable(data);
                }           
            }
        });
    });

    // $("#editDiscountForm").submit(function (e) {
    //     // Prevent page load when form submit
    //     e.preventDefault();
    //
    //     $.ajax({
    //         type: "PUT",
    //         url: $(this).attr("action"),
    //         data: $(this).serialize(),
    //         statusCode: {
    //             400: function() {;
    //                 alertify.notify('Duplicate discount code!', 'custom-error', 5);
    //             },
    //             200: function(data) {
    //                 let row = getRowByDiscountId(data['id']);
    //                 row[1].innerHTML = data['discountCode'];
    //                 row[2].innerHTML = data['discountPercent'];
    //                 row[3].innerHTML = data['discountWebsite'];
    //                 row[4].innerHTML = data['provider'];
    //             }
    //         }
    //     });
    // });
});

function populateToTable(data){
    let table = $("#multi_col_order").DataTable();
    let updateButton = '<p class="d-none">true</p>\n' +
        '                <a\n' +
        '                   class="btn btn-success"\n' +
        '                   href="#"\n' +
        '                   data-toggle="modal"\n' +
        '                   data-target="#modalStatus"\n' +
        '                   onclick="updateStatus(this.id, this.name, true, \'discount\')"\n' +
        '                   id="' + data['id'] + '" name="' + data['discountCode'] + '"\n' +
        '                   style="width: 40px; height: 40px;">\n' +
        '                    <i class="fas fa-check"></i>\n' +
        '                </a>';
    let editButton = '<a class="btn-edit btn btn-primary"\n' +
        '                   href="javascript:void(0)"\n' +
        '                   style="width: 40px; height: 40px;"\n' +
        '                   data-toggle="modal"\n' +
        '                   data-target=#modalEdit>\n' +
        '                    <i class="far fa-edit"></i>\n' +
        '                </a>';
    var newRow = table.row.add([
                    data['id'],
                    data['discountCode'],
                    data['discountPercent'],
                    data['discountWebsite'],
                    data['provider'],
                    updateButton,
                    editButton
                ]).draw().node();

    // Re-style 2 buttons
    $(newRow).find('td:nth-child(6)').css('text-align', 'center');
    $(newRow).find('td:nth-child(7)').css('text-align', 'center');
}
function getRowByDiscountId(discountID) {
    var table = $('#multi_col_order').DataTable(),
        data = table.rows().data(),
        row, i, l = data.length;

    for ( i = 0; i < l; i++ ) {
        row = data[i];


        if (row[0] == discountID) {
            return row;
        }
    }
    return null;
}