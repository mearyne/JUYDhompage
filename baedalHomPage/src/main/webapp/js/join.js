const warning = $('.error_next_box');
const req = $(".int");
const click =  $('input[name="shopX"]');
const onlyclick = $('name="shopX"');
 
 function checkJoinVal(form){
	event.defaultPrevented;
	console.log('click : ',click);
	console.log('click.value : ',click.value);
	console.log('click.val() : ',click.val());
	console.log('click.val() : ',onlyclick.val());
    for(let i=0; i<req.length; i++){
        if(req.get(i).value === "")
            warning.show();
        else
            form.submit(); 
    }
}

