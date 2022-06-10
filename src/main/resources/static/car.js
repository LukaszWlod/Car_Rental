

$('document').ready(function () {
    //show edit modal after click
    $('.table .edit').on('click', function (event) {
        event.preventDefault();

        var href= $(this).attr('href');

        console.log(href);

        $.get(href, function(car, status){
            $('#editId').val(car.id);
            $('#editBrand').val(car.brand);
            $('#editModel').val(car.model);
            $('#editYearOfProduction').val(car.yearOfProduction);
            $('#editPrice').val(car.price);
            $('#editAvailable').val(car.available);

        });


        $('#editClient').modal();
    });
//show delete modal after click
    $('.table #deleteButton').on('click',function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        console.log(href);

        $('#deleteForm').attr('action', href);
        $('#deleteCostumer').modal();
    });

});