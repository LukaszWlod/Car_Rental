

$('document').ready(function () {
    //show edit modal after click
    $('.table .edit').on('click', function (event) {
        event.preventDefault();

     var href= $(this).attr('href');



    $.get(href, function(client, status){
        $('#editId').val(client.id);
        $('#editName').val(client.name);
        $('#editLastName').val(client.lastName);
        $('#editEmail').val(client.email);
        $('#editAddress').val(client.address);
        $('#editPhone').val(client.phoneNumber);

    });


    $('#editClient').modal();
});
//show delete modal after click
   $('.table #deleteButton').on('click',function (event) {
       event.preventDefault();
       var href = $(this).attr('href');


      $('#deleteForm').attr('action', href);
       $('#deleteCostumer').modal();
   });

});