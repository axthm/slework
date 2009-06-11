package com.neusoft.core.page;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int defaultItemCountPerPage = 10;// page默认的记录的个数设置为10

	private int totalRecordCount;// 符合该条件的总记录数目

	private int itemCountPerPage;// 每页显示的记录数目

	private int pageNumber;// 该页的页码

	private int beginRowNum;// 起始记录的行码

	private int endRowNum;// 终止记录的行码

	private int lastPageNumber;// 最后一页的页码

	private int itemCountInPage;// 在本页中的记录数目

	private boolean hasPrevious;// 是否有上一页

	private boolean hasNext;// 是否有上一页

	private List itemsList;// 该页中对象内容
	
	private String pojoName;//所对应的pojo类的名称
	
	private String filter; //对应的过滤器 

	public Page(int totalRecordCount, int itemCountPerPage, int pageNumber) {
		// 处理构造函数的记录总数参数
		if (totalRecordCount < 0) {
			totalRecordCount = 0;
		}
		// 处理构造函数的每一页记录个数的参数
		if (itemCountPerPage <= 0) {
			itemCountPerPage = defaultItemCountPerPage;
		}
		// 处理构造函数的当前页码参数
		if (pageNumber < 0) {
			pageNumber = 0;
		}
		if (totalRecordCount == 0) {
			pageNumber = 0;
		} else {
			if (pageNumber == 0) {
				pageNumber = 1;
			} else {
				int count = totalRecordCount / itemCountPerPage
						+ (totalRecordCount % itemCountPerPage == 0 ? 0 : 1);
				pageNumber = pageNumber > count ? count : pageNumber;
			}
		}
		// 设置Page的各个成员变量
		setTotalRecordCount(totalRecordCount);
		setItemCountPerPage(itemCountPerPage);
		setPageNumber(pageNumber);
		if (totalRecordCount == 0) {
			setBeginRowNum(0);
			setEndRowNum(0);
			setLastPageNumber(0);
			setItemCountInPage(0);
			setHasPrevious(false);
			setHasNext(false);
		} else {
			setRowNums(totalRecordCount, itemCountPerPage, pageNumber);
			setLastPageNumber(totalRecordCount, itemCountPerPage);
			setItemCountInPage(totalRecordCount, itemCountPerPage, pageNumber);
			setHasNext();
			setHasPrevious();
		}
	}

	/**
	 * 设置和得到总共含有的记录条数
	 */
	private void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalRecordCount() {
		return this.totalRecordCount;
	}

	/**
	 * 设置和得到每一页有多少个元素
	 */
	public int getItemCountPerPage() {
		return itemCountPerPage;
	}

	private void setItemCountPerPage(int itemCountPerPage) {
		this.itemCountPerPage = itemCountPerPage;
	}

	/**
	 * 设置和得到当前页码数
	 */
	public int getPageNumber() {
		return this.pageNumber;
	}

	private void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * 设置和得到该页显示的数据的开始元素的rownum
	 */
	private void setBeginRowNum(int beginRowNum) {
		this.beginRowNum = beginRowNum;
	}

	public int getBeginRowNum() {
		return beginRowNum;
	}

	/**
	 * 设置和得到该页显示的数据的结束元素的rownum
	 */
	private void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	/**
	 * 设置和得到最后一页的页码数
	 */
	public int getLastPageNumber() {
		return lastPageNumber;
	}

	private void setLastPageNumber(int lastPageNumber) {
		this.lastPageNumber = lastPageNumber;
	}

	private void setLastPageNumber(int totalRecordCount, int itemCountPerPage) {
		if (totalRecordCount % itemCountPerPage == 0) {
			setLastPageNumber(totalRecordCount / itemCountPerPage);
		} else {
			setLastPageNumber(totalRecordCount / itemCountPerPage + 1);
		}
	}

	/**
	 * 设置和得到当前页面中总共有多少个元素
	 */
	private void setItemCountInPage(int itemCountInPage) {
		this.itemCountInPage = itemCountInPage;
	}

	public int getItemCountInPage() {
		return this.itemCountInPage;
	}

	private void setItemCountInPage(int totalRecordCount, int itemCountPerPage,
			int pageNumber) {
		int temp = pageNumber * itemCountPerPage;
		if (temp <= totalRecordCount) {
			setItemCountInPage(itemCountPerPage);
		} else {
			setItemCountInPage(totalRecordCount
					- ((pageNumber - 1) * itemCountPerPage));
			// 此处也可以用取模运算得到
			// setItemCountInPage(totalRecordCount%itemCountPerPage);
		}
	}

	/**
	 * 设置和得到本页是否还有上一页
	 */
	public boolean isHasPrevious() {
		return hasPrevious;
	}

	private void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	private void setHasPrevious() {
		if (pageNumber == 1) {
			setHasPrevious(false);
		} else {
			setHasPrevious(true);
		}
	}

	/**
	 * 设置和得到本页是否还有下一页
	 */
	public boolean isHasNext() {
		return hasNext;
	}

	private void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	private void setHasNext() {
		if (pageNumber < lastPageNumber) {
			setHasNext(true);
		} else {
			setHasNext(false);
		}
	}

	/**
	 * 设置和得到该页面中所含有的数据列表
	 */
	public List getItemsList() {
		return itemsList;
	}

	public void setItemsList(List itemsList) {
		this.itemsList = itemsList;
	}

	/**
	 * 设置该页面的元素的起始顺序(记录总数不为0是调用该方法)
	 */
	private void setRowNums(int totalRecordCount, int itemCountPerPage,
			int pageNumber) {
		setBeginRowNum((pageNumber - 1) * itemCountPerPage + 1);
		if (pageNumber * itemCountPerPage > totalRecordCount) {
			setEndRowNum(totalRecordCount);
		} else {
			setEndRowNum(pageNumber * itemCountPerPage);
		}
	}

	public String getPojoName() {
		return pojoName;
	}

	public void setPojoName(String pojoName) {
		this.pojoName = pojoName;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

}