package com.neusoft.ui.tree.bean;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	private boolean allowChildren;
	private boolean draggable = true;
	private boolean allowDrag;
	private boolean expandable;
	private boolean expanded;
	private String href;
	private String icon;
	private String iconCls;
	private String id;
	private boolean leaf;
	private String qtip;
	private String qtipCfg;
	private String text;
	
	private List<TreeNode> children = new ArrayList<TreeNode>(0);
	
	private TreeNode parent;
	
	 TreeNode getParent() {
		return parent;
	}

	 void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public TreeNode(){
		
	}
	
	public boolean isAllowChildren() {
		return allowChildren;
	}
	public void setAllowChildren(boolean allowChildren) {
		this.allowChildren = allowChildren;
	}
	public boolean isDraggable() {
		return draggable;
	}
	public void setDraggable(boolean draggable) {
		this.draggable = draggable;
	}
	public boolean isAllowDrag() {
		return allowDrag;
	}
	public void setAllowDrag(boolean allowDrag) {
		this.allowDrag = allowDrag;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getQtip() {
		return qtip;
	}
	public void setQtip(String qtip) {
		this.qtip = qtip;
	}
	public String getQtipCfg() {
		return qtipCfg;
	}
	public void setQtipCfg(String qtipCfg) {
		this.qtipCfg = qtipCfg;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allowChildren ? 1231 : 1237);
		result = prime * result + (allowDrag ? 1231 : 1237);
		result = prime * result + (draggable ? 1231 : 1237);
		result = prime * result + (expandable ? 1231 : 1237);
		result = prime * result + (expanded ? 1231 : 1237);
		result = prime * result + ((href == null) ? 0 : href.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + ((iconCls == null) ? 0 : iconCls.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (leaf ? 1231 : 1237);
		result = prime * result + ((qtip == null) ? 0 : qtip.hashCode());
		result = prime * result + ((qtipCfg == null) ? 0 : qtipCfg.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TreeNode other = (TreeNode) obj;
		if (allowChildren != other.allowChildren)
			return false;
		if (allowDrag != other.allowDrag)
			return false;
		if (draggable != other.draggable)
			return false;
		if (expandable != other.expandable)
			return false;
		if (expanded != other.expanded)
			return false;
		if (href == null) {
			if (other.href != null)
				return false;
		} else if (!href.equals(other.href))
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (iconCls == null) {
			if (other.iconCls != null)
				return false;
		} else if (!iconCls.equals(other.iconCls))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (leaf != other.leaf)
			return false;
		if (qtip == null) {
			if (other.qtip != null)
				return false;
		} else if (!qtip.equals(other.qtip))
			return false;
		if (qtipCfg == null) {
			if (other.qtipCfg != null)
				return false;
		} else if (!qtipCfg.equals(other.qtipCfg))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	public TreeNode(boolean allowChildren, boolean draggable,
			boolean allowDrag, boolean expandable, boolean expanded,
			String href, String icon, String iconCls, String id, boolean leaf,
			String qtip, String qtipCfg, String text) {
		super();
		this.allowChildren = allowChildren;
		this.draggable = draggable;
		this.allowDrag = allowDrag;
		this.expandable = expandable;
		this.expanded = expanded;
		this.href = href;
		this.icon = icon;
		this.iconCls = iconCls;
		this.id = id;
		this.leaf = leaf;
		this.qtip = qtip;
		this.qtipCfg = qtipCfg;
		this.text = text;
	}
	@Override
	public String toString() {
		return super.toString()+this.text;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

}
