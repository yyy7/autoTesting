/**
 * Created by 11456 on 2016/11/7.
 *
 * encoding gbk
 */

//选中全选按钮，下面的checkbox全部选中
var selAll = document.getElementById("selAll");
function selectAll()
{
    var obj = document.getElementsByName("checkAll");
    if(document.getElementById("selAll").checked == false)
    {
        for(var i=0; i<obj.length; i++)
        {
            obj[i].checked=false;
        }
    }else
    {
        for(var i=0; i<obj.length; i++)
        {
            obj[i].checked=true;
        }
    }

}

//当选中所有的时候，全选按钮会勾上
function setSelectAll()
{
    var obj=document.getElementsByName("checkAll");
    var count = obj.length;
    var selectCount = 0;

    for(var i = 0; i < count; i++)
    {
        if(obj[i].checked == true)
        {
            selectCount++;
        }
    }
    if(count == selectCount)
    {
        document.all.selAll.checked = true;
    }
    else
    {
        document.all.selAll.checked = false;
    }
}

//反选按钮
function inverse() {
    var checkboxs=document.getElementsByName("checkAll");
    for (var i=0;i<checkboxs.length;i++) {
        var e=checkboxs[i];
        e.checked=!e.checked;
        setSelectAll();
    }
}

