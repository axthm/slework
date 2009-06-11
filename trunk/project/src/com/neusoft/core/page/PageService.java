package com.neusoft.core.page;

public class PageService {
	
	private static PageService pageService;	
	
	public static PageService getInstance(){ 
		if (pageService == null) {
			pageService = new PageService();
		}
		return pageService;
	}
	/**
	 * 得到第i页
	 * @param page 现有的页
	 * @param i 另外一页的页数
	 * @return
	 */
	public Page getPage(Page page ,int i){
		return null;
	}
	/**
	 * 得到第一页
	 * @param page 现有的页
	 * @return
	 */
	public Page getFirstPage(Page page){
		return null;
	}
	/**
	 * 得到上一页
	 * @param page 现有的页
	 * @return
	 */
	public Page getNextPage(Page page) {
		return null;
	}
	/**
	 * 得到下一页
	 * @param page 现有的页
	 * @return
	 */
	public Page getPreviousPage(Page page) {
		return null;
	}
	/**
	 * 得到最后一页
	 * @param page 现有的页
	 * @return
	 */
	public Page getLastPage(Page page) {
		return null ;
	}
}
