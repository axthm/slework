/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
Ext.onReady(function(){
    var root = new Ext.tree.TreeNode({text:"我是根"});
  
    var tree = new Ext.tree.TreePanel({
        loader: new Ext.tree.TreeLoader({dataUrl:'/SSHdemo/menuAction.do?Method=loadMenu'}),
        //bbar: toolbar,
        height:400,
        rootVisible:false,
		width:200,
    });
    tree.setRootNode(root);
    tree.render('tree');
});