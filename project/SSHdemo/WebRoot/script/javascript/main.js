Ext.onReady(function(){


var tree = function(){
	var root = new Ext.tree.AsyncTreeNode({text:'我是根'})

    	var toolbar = new Ext.Toolbar(
		[{
			icon: "imgs/arrow_up.png",
			cls: "x-btn-text-icon",
			text: "上",
			tooltip: "向上选择一个节点",
			tooltipType: "qtip",
			handler: function(){
				var model = tree.getSelectionModel();//获取选择模型
				model.selectPrevious();
			}
		},{
			icon: "imgs/arrow_down.png",
			cls: "x-btn-text-icon",
			text: "下",
			tooltip: "向下选择一个节点",
			tooltipType: "qtip",
			handler: function(){
				var model = tree.getSelectionModel();//获取选择模型
				model.selectNext();
			}
		},{
			icon: "imgs/asterisk_yellow.png",
			cls: "x-btn-text-icon",
			text: "值",
			tooltip: "获取被选择的节点的显示文本",
			tooltipType: "qtip",
			handler: function(){
				var model = tree.getSelectionModel();//获取选择模型
				var selectedNode = model.getSelectedNode();//获取选择的节点
				if(selectedNode){
					Ext.MessageBox.alert("", selectedNode.text);
				}
			}
		},{
			icon: "imgs/shape_handles.png",
			cls: "x-btn-text-icon",
			text: "选",
			tooltip: "自定义选择任何节点",
			tooltipType: "qtip",
			handler: function(){
				Ext.Msg.prompt("路径", "请输入要选择的节点路径（从根节点开始，如“/根节点/一级_1”）", function(btn, txt){
					if(btn == "ok"){
						tree.selectPath(txt, "text");
					}
				});
			}
		},{
			icon: "imgs/page_white_freehand.png",
			cls: "x-btn-text-icon",
			text: "ID",
			tooltip: "根据ID进行选择",
			tooltipType: "qtip",
			handler: function(){
				Ext.Msg.prompt("路径", "请输入要选择的节点的ID", function(btn, txt){
					if(btn == "ok"){
						var model = tree.getSelectionModel();//获取选择模型
						var selNode = tree.getNodeById(txt);
						model.select(selNode);
					}
				});
			}
		}]);
	
    var tree = new Ext.tree.TreePanel({
        loader: new Ext.tree.TreeLoader({dataUrl:'/SSHdemo/menuAction.do?Method=loadMenu'}),
        bbar: toolbar,
        height:400,
        rootVisible:false,
        region:'west',
		contentEI:'west-div',
					split:true,
	border:true,
	collapsible:true,
		width:240,
		minSize:120,
		maxSize:200
    });
    tree.setRootNode(root);
    tree.on("click",function(node){
    	//Ext.MessageBox.alert('单击'+node,'单击'+node);
    	
    	//Ext.MessageBox.alert(temp);
    	if(node.leaf){
    		
    		var test = tabPanel.findById(node.id);
    	
    		if (test == null){
    			Ext.MessageBox.alert(node.id,node.attributes.model);
    			eval('tabPanel.add( '+node.attributes.model+')');
    			eval('tabPanel.setActiveTab('+node.attributes.model+')');
    		}
    	}
    	
    })
   		//tree.render();
   		return tree;
	}
	
	var tabPanel  = new Ext.TabPanel({
		el:'center-div',
		region:'center',
		split:true,
		border:true,
		collapsible:true,
		enableTabScroll: true,
	      deferredRender : false,
           activeTab : 0,
           resizeTabs : true,
		//width: 500,
		//height: 300
	});
	var panel2 = new Ext.Panel({
		title: "标签2",
		html: "美利坚合众国",
		bodyStyle: "padding: 10px",
		 closable : true
	});
    	tabPanel.add(panel2)
    	tabPanel.setActiveTab(panel2);
	
	
var viewport = new Ext.Viewport({
layout:'border',
items:[
{
	title:'north',
	region:'north',
	contentEI:'north-div',
	split:true,
	border:true,
	collapsible:true,
	height:100,
	minSize:120,
	maxSize:200
},
tree(),
tabPanel
]
});

})