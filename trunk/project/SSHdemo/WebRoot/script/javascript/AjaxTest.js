/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
Ext.onReady(function(){
    //var root = new Ext.tree.TreeNode({text:"我是根"});
    var root = new Ext.tree.AsyncTreeNode({text:'我是根'})
    var tree = new Ext.tree.TreePanel({
        el:'tree',
        loader: new Ext.tree.TreeLoader({dataUrl:'/SSHdemo/menuAction.do?Method=loadMenu'}),
        height:400,
        rootVisible:false
    });
    tree.setRootNode(root);
    tree.render();
});