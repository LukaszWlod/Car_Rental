

$('document').ready(function () {
    //show edit modal after click
    $('.table .edit').on('click', function (event) {
        event.preventDefault();

        var href= $(this).attr('href');

        console.log(href);

        $.get(href, function(car, status){

            let carName = car.brand + ' ' + car.model;
            $('#car').val(carName);
            $('#editId').val(car.id);
            $('#editBrand').val(car.brand);
            $('#editModel').val(car.model);
            $('#editYearOfProduction').val(car.yearOfProduction);
            $('#editPrice').val(car.price);
            $('#editAvailable').val(car.available);

            console.log(carName);


        });




        $('#editCar').modal();
    });



});



