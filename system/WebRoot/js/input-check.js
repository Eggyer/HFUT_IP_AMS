/**
 * Created by Egg on 2016/4/3.
 */
function modify_email(){
    var email = jQuery("#inputEmail").val();
    var emailre = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
    var formgroup = jQuery("#formgroupEmail");
    if(email===undefined){
        formgroup.addClass("has-error")
        alert(1);
    }else if(email.trim()==""){
        formgroup.addClass("has-error")
        alert(2);
    }else if(emailre.test(email)){
        formgroup.addClass("has-error")
        alert(3);
    }else{
        jQuery("form").submit();
    }
}
function checkPassword(){
    var password = jQuery("#inputPassword").val();
    var pformgroup = jQuery("#inputPasswordFormgroup");
    var repassword = jQuery("#reinputPassword").val();
    var rpformgroup = jQuery("#reinputPasswordFormgroup");
    var re = /((?=.*\d)(?=.*\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$/;
    if (!re.test(password)){
        pformgroup.addClass("has-error");
    }else if (!(password==repassword)){
        rpformgroup.addClass("has-error");
    }else{
        jQuery("form").submit();
    }
}