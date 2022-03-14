<html>
<head>
    <title>PageStatic</title>
</head>
<body>
主题：${myTitle}<br/>
<#assign text="{'auth':'cicada','date':'2020-07-16'}" />
<#assign data=text?eval />
作者：${data.auth} 日期：${data.date}<br/>
<table class="table table-striped table-hover table-bordered" id="editable-sample">
    <thead>
    <tr>
        <th>规格描述</th>
        <th>产品详情</th>
    </tr>
    </thead>
    <tbody>
             <#list tableList as info>
             <tr class="">
                 <td>${info.desc}</td>
                 <td><img src="${info.imgUrl}" height="80" width="80"></td>
             </tr>
             </#list>
    </tbody>
</table><br/>
<#list imgList as imgIF>
    <img src="${imgIF}" height="300" width="500">
</#list>
</body>
</html>