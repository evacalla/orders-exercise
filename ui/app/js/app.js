(function ($) {
    'use strict';

    $(document).ready(() => {
        initError()
    });
    $("#button-save").click(() => {	
        let isValid = validate();
        if(isValid) {
            initError();
            let saveable = {};
            saveable.name = $("#name").val();
            saveable.amount = parseInt($("#amount").val());
            if($("#discount").val()) {
                saveable.discount = parseInt($("#discount").val());
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
                },
                error: function(jqXhr, textStatus, errorThrown ){
                    console.log(errorThrown);
                }
            });
        };
    });

    function initError(){
        $("#error-name-incomplete").hide();
        $("#error-name-length").hide();
        $("#error-amount-incomplete").hide();
        $("#error-discount-incomplete").hide();
    }

    function validate(){

        let isValid = true;
        let saveable = {};
        saveable.description = $("#name").val();
        saveable.amount = $("#amount").val();
        

        if(!saveable.description){
            $("#error-name-incomplete").show();
            $("#input-name").addClass("errors-field");
            isValid = false;
        } else if(saveable.description.length > 100){
            $("#error-name-length").show();
            $("#input-name").addClass("errors-field");
            isValid = false;
        } else {
            $("#error-name-incomplete").hide();
            $("#error-name-length").hide();
            $("#input-name").removeClass("errors-field");

        }

        if(!saveable.amount) {
            $("#error-amount-incomplete").show();
            $("#input-amount").addClass("errors-field");
            isValid = false;
        } else if(typeof parseInt(saveable.amount) !== 'number') {
            $("#amouinput-amountnt").addClass("errors-field");
            isValid = false;
        } else {
            $("#error-amount-incomplete").hide();
            $("#input-amount").removeClass("errors-field");
        }

        return isValid;

    }
    
})(jQuery);