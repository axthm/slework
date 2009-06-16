Ext.onReady(function(){

var tree = function(){
	var root = new Ext.tree.AsyncTreeNode({text:'我是根'})
    var tree = new Ext.tree.TreePanel({
        loader: new Ext.tree.TreeLoader({dataUrl:'/SSHdemo/menuAction.do?Method=loadMenu'}),
        height:400,
        rootVisible:false,
        region:'west',
		contentEI:'west-div',
		split:true,
		border:true,
		collapsible:true,
		width:200,
		minSize:120,
		maxSize:200
    });
    tree.setRootNode(root);
    tree.on("click",function(node){
    	Ext.MessageBox.alert('单击'+node,'单击'+node);
    })
   		//tree.render();
   		return tree;
	}
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
main()
]
});

})