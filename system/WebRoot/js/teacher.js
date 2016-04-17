/**
 * Created by Egg on 2016/4/4.
 */
function getGrade(){
    var trs = jQuery("#grade_table tr");

    var or = jQuery("#orid").val();
    for(var i = 1 ; i<trs.length;i++ )
    {
        var tds = $(trs[i]).children();

        var score1 = $(tds[5]).children().first().val();
        var score2 = $(tds[6]).children().first().val();
        var grade = score1*or + score2*(1-or) ;
        var label = $(tds[7]).children().first();
        $(tds[7]).children().first().text(grade);
    }
    count_bad();
}

function count_bad () {
    var grade_table = jQuery("#grade_table");
    var trs = grade_table.children().eq(0).children();
    var count = 0;
    for(var i = 1;i<trs.length-1;i++)
    {
        if(trs.eq(i).children().last().children().first().html()<60)
        {
            trs.eq(i).addClass("danger");
            count ++;
        }else{
            trs.eq(i).removeClass("danger");
        }
    }
    jQuery("#orhelp").html("当前挂科人数："+count);
}