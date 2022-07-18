const warning = $('.error_next_box');
const req = $(".int");
 
 function checkJoinVal(form){
    for(let i=0; i<req.length; i++){
        if(req.get(i).value === "")
            warning.show();
        else
            form.submit(); 
    }
}

