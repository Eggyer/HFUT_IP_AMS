/**
 * Created by Egg on 2016/4/8.
 */
jQuery(document).ready(function () {
    var table = jQuery("#grade_table");
    var trs = table.children().eq(1).children();
    for(var i =0;i<trs.length;i++)
    {
        var tr = jQuery(trs[i]);
        var tds = tr.children();
        for(var j = 2;j<tds.length-1;j++)
        {
            var td = jQuery(tds[j]);
            if(td.html()!="暂未考试"&&td.html()<60)
            {
                td.addClass("danger");
            }
        }
    }
});