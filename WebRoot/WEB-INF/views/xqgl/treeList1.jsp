<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>需求浏览</title>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<link href="${path}/script/easyUI/themes/default/easyui.css"
	rel="stylesheet" />
<link href="${path}/script/easyUI/themes/icon.css" rel="stylesheet" />
<link href="${path}/script/easyUI/themes/color.css" rel="stylesheet" />
<script src="${path}/script/easyUI/jquery.min.js"></script>
<script src="${path}/script/easyUI/jquery.easyui.min.js"></script>
<script src="${path}/script/easyUI/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function getChecked() {
		console.info($('#t1').tree('getChecked'));
	}
	$(function() {
		$('#t1').tree({
			//发送异步ajax请求, 还会携带一个id的参数 DemandAction-*tree-getNodes
			url : 'DemandAction-getXuekeNodes',
			dnd : true,
			checkbox : false,
			lines : true,
			cascadeCheck : true,
			iconCls:"icon-save",  
			onClick : function(node) {
				var trehh = node.id;
				trehh = trehh.toString();
				var pars = {
						tecName : node.text,
						cls:trehh.length
					};
				loadData(pars);
			},
			onDrop : function(target, source, point) {
				var tar = $('#t1').tree('getNode', target);
				$.ajax({
					type : 'post',
					url : 'DemandAction-getXuekeNodes',
					data : {
						targetId : tar.id,
						sourceId : source.id,
						point : point
					},
					dataType : 'json',
					cache : false,
					success : function(result) {
						$.messager.show({
							title : '提示信息',
							msg : '操作成功!'
						});
					}
				});
			}
		});

	});
	function loadData(pars) {
		$('#date')
				.datagrid(
						{
							//url: '../listDate/listdata2.jsp',
							url : 'DemandAction-getTreeList1',
							//width: 1000,
							//height: 400,
							width : ($(window).width() * 0.90) - 130,
							height : ($(window).height() * 0.99) - 100,
							//fit:true,
							fitColumns : true, //列自适应
							nowrap : false,
							idField : 'demandId',//主键列的列名
							loadMsg : '正在加载信息...',
							pagination : true,//是否有分页
							//singleSelect: false,//是否单行选择
							pageSize : 10,//每页多少条数据
							pageNumber : 1,//默认的页
							pageList : [ 10, 20, 30 ],
							queryParams : pars,//往后台传递参数
							columns : [ [
									{
										field : 'demandId',
										title : '',
										checkbox : true
									},
									{
										field : 'demandName',
										title : '需求名称',
										align : 'center',
										width : 100
									},
									{
										field : 'unit.unitNumber.unitName',
										title : '机构名称',
										align : 'center',
										width : 100,
										formatter : function(value, row, index) {
											return row.unit.unitNumber.unitName;
										}
									},
									{
										field : 'demandStart',
										title : '需求有效起始时间',
										align : 'center',
										width : 100
									},
									{
										field : 'demandEnd',
										title : '需求有效截止时间',
										align : 'center',
										width : 100
									},
									{
										field : 'demandKeyWord1',
										title : '关键字',
										align : 'center',
										width : 100
									},

									{
										field : 'unit.unitDepartment',
										title : '归属部门',
										align : 'center',
										width : 100,
										formatter : function(value, row, index) {
											return row.unit.unitDepartment;
										}
									},
									{
										field : 'operation',
										title : '操作',
										align : 'center',
										width : 100,
										formatter : function(value, row, index) {
											var str = "";
											str += "<a href='DemandAction-show?demandId="
													+ row.demandId+
													"' class='easyui-linkbutton c1' style='width:70px'>查看</a>";
											return str;
										}
									} ] ],
						});
	}
</script>
<style>
body {
	font-size: 12px;
	overflow-y: hidden;
}

input {
	width: 100px;
}

select {
	width: 104px;
}

#sec { /*border:1px solid #0094ff;*/
	width: 900px;
}

#sec td {
	width: 100px;
	height: 20px;
	text-align: right
}
</style>
</head>
<body class="easyui-layout">

	<div data-options="region:'west',title:'学科检索',split:true"
		style="width:200px;">
		<ul id="t1"></ul>
	</div>
	<div data-options="region:'center',title:'需求列表'"
		style="padding:5px;background:#eee;">
		<div></div>
		<table id="date">
		</table>
	</div>
</body>
</html>
