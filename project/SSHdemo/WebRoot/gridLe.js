/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
Ext.onReady(function(){
    var tree = new Ext.tree.TreePanel();
    var test = new Array();
	function chfont(value,metadata,record,rowIndex,colIndex){
	if(colIndex ==2){
		record.data['descn'] = value + record.data['id'];
		return record.data['descn']
	}else{
		return '<span style="color:blue;font-weight:bold;font-size:12px">' + value + '</span>';
	}
	}

	function chfognt(value){
		return '<span style="color:red;font-weight:bold;font-size:12px">' + value + '</span>';
	}

    // NOTE: This is an example showing simple state management. During development,
    // it is generally best to disable state management as dynamically-generated ids
    // can change across page loads, leading to unpredictable results.  The developer
    // should ensure that stable state ids are set for stateful components in real apps.
    Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
		var cm = new Ext.grid.ColumnModel(
			[
				new Ext.grid.RowNumberer([{sortable:true}]),
				{id:'id',header:'编号',sortable: true,renderer:chfont,dataIndex:'id'},
				{id:'name',header:'名称',renderer:chfont,dataIndex:'name',editor:new Ext.grid.GridEditor(
					new Ext.form.TextField({
						allowBlank:false
					})
				)},
				{id:'descn',header:'描述',renderer:chfont,dataIndex:'descn'},
				{id:'sal',header:'工资',renderer:chfont,dataIndex:'sal',editor:new Ext.grid.GridEditor(
                new Ext.form.NumberField({
                    allowBlank:false,
                    allowNegative:false,
                    minvalue:2000
                })
            )}
			]
			);
			var data = [
				['1','胡锦涛','国家主席',45647],
				['2','温家宝','国家总理',12345],
				['3','江泽民','原国家主席',32456],
				['4','邓小平','原国家老大',21332],
				['5','邓小平','原国家老大',21332],
				['6','邓小平','原国家老大',21332],
				['7','邓小平','原国家老大',21332],
				['8','邓小平','原国家老大',21332],
				['9','邓小平','原国家老大',21332],
			];
			var ds = new Ext.data.Store(
				{
					proxy: new Ext.data.PagingMemoryProxy(data),
					reader: new Ext.data.ArrayReader({},[
						{name:'id'},
						{name:'name'},
						{name:'descn'},
						{name:'sal',type:'float'}

					])
				}
			);
				var paging = new Ext.PagingToolbar({
				pageSize:3,
				store:ds,
				displayInfo:true,
				displayMsg:'显示第{0}条记录,一共{2}条',
				emptyMsg:'没有记录'
			});

			var tb = new Ext.Toolbar(['-',
				{
					text:'添加一行',
					handler:function(){
						var initval = {id:'',name:'',descn:'',sal:''};
						var record = new Ext.data.Record(initval);
						grid.stopEditing();
						ds.insert(0,record);
						grid.startEditing(0,0);
						record.dirty = true;
						record.modified = initval;
						if(ds.modified.indexOf(record) == -1){
							ds.modified.push(record)
						}
					}
				},'-',
				{
					text:'删除一行',
					handler:function(){
						var initval = {id:'',name:'',descn:'',sal:''};
						var record = new Ext.data.Record(initval);
						grid.stopEditing();
						ds.insert(0,record);
						grid.startEditing(0,0);
						record.dirty = true;
						record.modified = initval;
						if(ds.modified.indexOf(record) == -1){
							ds.modified.push(record)
						}
					}
				}
			]);
			var grid = new Ext.grid.EditorGridPanel(
				{
					title:'<span style="font-size:12px>学习</span>',
					el:'test',
					store:ds,
					cm:cm,
					autoExpandColumn: 'id',
					width:420,
					height:200,
					tbar:tb,
					bbar:paging,
					footer :true,
					header:true
				}
			);
			//ds.load();
			ds.load({params:{start:0,limit:3}});
			//var gridFoot = grid.getView.getFooterPanel(true);

			grid.render();
    //grid.getSelectionModel().selectFirstRow();
	new Ext.Button({text:'删除',id:'text',renderTo:'button'});
	new Ext.Button({
        text: 'Get File Path',
        renderTo: 'fi-basic-btn',
        handler: function(){
            var v = fibasic.getValue();
            msg('Selected File', v && v != '' ? v : 'None');
        }
    });
	Ext.get('text').on('click',function(){
		ds.remove(ds.getAt(1));
		grid.view.refresh();
	});
});

