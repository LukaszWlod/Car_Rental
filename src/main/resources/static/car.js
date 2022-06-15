

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
            $('#editRegistrationNumber').val(car.registrationNumber)
            $('#editVin').val(car.vin);
            $('#editYearOfProduction').val(car.yearOfProduction);
            $('#editPrice').val(car.price);
            $('#editAvailable').val(car.available);
        });




        $('#editCar').modal();
    });
//show delete modal after click
    $('.table #deleteButton').on('click',function (event) {
        event.preventDefault();
        var href = $(this).attr('href');


        $('#deleteForm').attr('action', href);
        $('#deleteCostumer').modal();
    });








});



