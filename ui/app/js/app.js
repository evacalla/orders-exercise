(function ($) {
    'use strict';

    $(document).ready(() => {
        $("#error-description-incomplete").hide();
        $("#error-description-length").hide();
        $("#error-amount-incomplete").hide();
        $("#error-discount-incomplete").hide();
    });

    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://www.example.org/ajax.php", true);
    xhr.setRequestHeader("X-My-Custom-Header", "some value");

    $("#button-save").click(() => {	
        let isValid = validate();
        if(isValid) {

            let saveable = {};
            saveable.description = $("#description").val();
            saveable.amount = parseInt($("#amount").val());
            if($("#discount").val()) {
                saveable.discount = parseFloat($("#discount").val());
            }
            $.ajax({
                url: 'http://localhost:8080/order',
                dataType: 'json',
                headers: {  'Access-Control-Allow-Origin': 'http://localhost:8080' },
                crossDomain: true,
                type: 'post',
                data:  JSON.stringify(saveable),
                contentType: 'application/json',
                success: function(textStatus, jQxhr){
                    //$('#response pre').html( data );
                },
                error: function(jqXhr, textStatus, errorThrown ){
                    console.log(errorThrown);
                }
            });
        };
    });

    function validate(){

        let isValid = true;
        let saveable = {};
        saveable.description = $("#description").val();
        saveable.amount = $("#amount").val();
        

        if(!saveable.description){
            $("#error-description-incomplete").show();
            $("#description").addClass("errors-field");
            isValid = false;
        } else if(saveable.description.length > 100){
            $("#error-description-length").show();
            $("#description").addClass("errors-field");
            isValid = false;
        } else {
            $("#error-description-incomplete").hide();
            $("#error-description-length").hide();
            $("#description").removeClass("errors-field");
        }

        if(!saveable.amount) {
            $("#error-amount-incomplete").show();
            $("#amount").addClass("errors-field");
            isValid = false;
        } else if(typeof parseInt(saveable.amount) !== 'number') {
            $("#amount").addClass("errors-field");
            console.log("field incomplete amount not number");
            isValid = false;
        } else {
            $("#error-amount-incomplete").hide();
            $("#amount").removeClass("errors-field");
        }



        return isValid;

    }
    

})(jQuery);