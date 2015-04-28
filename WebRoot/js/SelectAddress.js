/**
 * 加载市
 * 
 */
function loadCity() {
    var provinceId = $("#provinceSelect option:selected").val();
    if(provinceId == null || provinceId == ""){
        //alert("找不到省");
    }else{
        $.post(rootPath+"/loadCity", {
            "q" : provinceId
        }, function(data, result) {
            if(data == "noId"){
                alert("请求错误");
            }else if(data == "null"){
                alert("系统找不到属于该省的市");
            }else{
                data = eval("{" + data + "}");
                var citySelect = $("#citySelect");
                var myCity = $("#myCity").val();
                citySelect.html("");
                for ( var i = 0; i < data.length; i++) {
                    if(myCity != null && myCity != "" && myCity > 0 && myCity == data[i].id){
                        citySelect.append("<option selected='selected' value='" + data[i].id + "'>"
                                + data[i].name + "</option>");
                    }else{
                        citySelect.append("<option value='" + data[i].id + "'>"
                                + data[i].name + "</option>");
                    }
                }
                loadRegion();
            }
        });
    }
};

/**
 * 加载区
 * 
 */
function loadRegion() {
    var cityId = $("#citySelect option:selected").val();
    if(cityId == null || cityId == "" || cityId < 1){
        alert("找不到市");
    }else{
        $.post(rootPath+"/loadRegion", {
            "q" : cityId
        }, function(data, result) {
            if(data == "noId"){
                alert("请求错误");
            }else if(data == "null"){
                alert("系统找不到属于该市的区");
            }else{
                data = eval("{" + data + "}");
                var regionSelect = $("#regionSelect");
                var myRegion = $("#myRegion").val();
                regionSelect.html("");
                for ( var i = 0; i < data.length; i++) {
                    if(myRegion != null && myRegion != "" && myRegion > 0 && myRegion == data[i].id){
                        regionSelect.append("<option selected='selected' value='" + data[i].id + "'>"
                                + data[i].name + "</option>");
                    }else{
                        regionSelect.append("<option value='" + data[i].id + "'>"
                                + data[i].name + "</option>");
                    }
                }
            }
        });
    }
};

/**
 * 省改变事件
 * 
 */
$("#provinceSelect").change(loadCity);

/**
 * 市改变事件
 *
 */
$("#citySelect").change(loadRegion);


$(function() {
    loadCity();
});


/*
<table>
 <tr style="margin-top: 25px;">
	<td class="tr pr10 ">
	所在地:
	 </td>
	 <td class="tl">
		 <input type="hidden" id="myProvince" value="${user.provinceId}"/>
		 <input type="hidden" id="myCity" value="${user.cityId}"/>
		 <input type="hidden" id="myRegion" value="${user.regionId}"/>
		 <select id="provinceSelect" name="user.provinceId">
		 <c:forEach items="${xzqhs}" var="xzqh">
		 <option value="${xzqh.provinceId}" ${user.regionId eq xzqh.provinceId?"selected='selected'":""}>${xzqh.province}</option>
	     </c:forEach>
	     	<option>四川</option>  
			<option>广州</option>  
			<option>胡建</option> 
	     </select>
      <select id="citySelect" name="user.cityId">
      	<option>成都</option>  
      	<option>南充</option> 
			<option>新都</option>  
      </select>
      <select id="regionSelect" name="user.regionId">
      	<option>金牛区</option>  
			<option>武侯区</option>  
			<option>锦江区</option> 
			<option>青羊区</option> 
			<option>高新区</option> 
     </select>
 </td>
   <td class="gray"></td>
</tr>    	
</table>
*/