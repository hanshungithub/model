package cn.hassan.model.common.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * 分页算法封装。 分页须设置: TotalItem（总条数）,缺省为0, 应该在dao中被设置 PageSize（每页条数），应在web层被设置
 * QueryBase 缺省为20，子类可以通过覆盖 getDefaultPageSize() 修改 CurrentPage（当前页）,缺省为1，首页，
 * 应在web层被设置 分页后，可以得到：TotalPage（总页数） FristItem(当前页开始记录位置，从1开始记数)
 * PageLastItem(当前页最后记录位置)
 * 
 * 页面上，每页显示条数名字应为： lines ，当前页名字应为： page 则可使用common
 * 工程下的CommonHelper.copyPagingParameters 设置分页参数
 */
public class QueryBase implements Serializable {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 3258128059449226041L;
    //默认改为10
	private static final Integer defaultPageSize = new Integer(10);

	private static final Integer defaultFristPage = new Integer(1);

	private static final Integer defaultTotleItem = new Integer(0);

	private Integer totalItem ;
	//默认改为10
	private Integer pageSize = 10;

	private Integer currentPage;

	// for paging
	private int startRow;

	private int endRow;

	//descCount=totalItem-(currentPage-1)*pageSize, sqlserver分页时用
	private int descCount;
	
	private Integer prevId;
	
	private Integer nextId;
	
	/** #20150914 4.2.2 push 审批 **/
	private String direction;
	
	private Date prevDate;
	
	private Date nextDate;
	
	/**
	 * 是否查最后一页
	 */
	private boolean finallyPage = false;
	
	/**
	 * 20150507
	 * 查询来源类型   ID 1-安卓 2-苹果
	 */
	private Byte source_from_type;
	
	/**
	 * 20150507
	 * 查询来源版本   例如:
	 */
	private Float source_from_version;
	
	@JsonIgnore
	public int getDescCount() {
		if (this.getCurrentPage().intValue() == 0){
			descCount= this.getTotalItem().intValue();
		}
		else{
			//descCount=this.getTotalItem().intValue()-(this.getCurrentPage().intValue()-1)*this.getPageSize().intValue();
			descCount = this.getCurrentPage().intValue()*this.getPageSize().intValue();
		}		
		return descCount;
	}

	/**
	 * @return Returns the defaultPageSize.
	 */
	protected Integer getDefaultPageSize() {
		return defaultPageSize;
	}

	@JsonIgnore
	public boolean isFirstPage() {
		return this.getCurrentPage().intValue() == 1;
	}

	@JsonIgnore
	public int getPreviousPage() {
		int back = this.getCurrentPage().intValue() - 1;
		if (back <= 0) {
			back = 1;
		}
		return back;
	}

	@JsonIgnore
	public boolean isLastPage() {
		return this.getTotalPage() == this.getCurrentPage().intValue();
	}

	@JsonIgnore
	public int getNextPage() {
		int back = this.getCurrentPage().intValue() + 1;
		if (back > this.getTotalPage()) {
			back = this.getTotalPage();
		}
		return back;
	}

	/**
	 * 
	 * 当前页码
	 * @return Returns the currentPage.
	 * 
	 */
	public Integer getCurrentPage() {
		if (currentPage == null) {
			return defaultFristPage;
		}
						
		//去掉by Sam 2014-10-22 为了文件分页，不重复获取数据；
		//if (currentPage>this.getTotalPage())
		//	currentPage = this.getTotalPage();
		
		return currentPage;
	}

	public void setCurrentPageString(String pageString) {
		if (isBlankString(pageString)) {
			this.setCurrentPage(new Integer(1));
		}
		try {
			Integer integer = new Integer(pageString);
			this.setCurrentPage(integer);
		} catch (NumberFormatException ignore) {
			this.setCurrentPage(new Integer(1));
		}
	}

	/**
	 * 
	 *  设置当前页
	 * 	@param cPage
	 *  The currentPage to set.
	 *  
	 */
	public void setCurrentPage(Integer cPage) {
		if (cPage == null || cPage.intValue() <= 0) {
			this.currentPage = null;
		} else {
			this.currentPage = cPage;
		}
	}

	/**
	 * @return Returns the pageSize.
	 */
	public Integer getPageSize() {
		if (pageSize == null) {
			return getDefaultPageSize();
		}
		return pageSize;
	}

	public boolean hasSetPageSize() {
		return pageSize != null;
	}

	public void setPageSizeString(String pageSizeString) {
		if (isBlankString(pageSizeString)) {
			return;
		}
		try {
			Integer integer = new Integer(pageSizeString);
			this.setPageSize(integer);
		} catch (NumberFormatException ignore) {
		}
	}

	/**
	 * @param pageSizeString
	 * @return
	 */
	private boolean isBlankString(String pageSizeString) {
		if (pageSizeString == null) {
			return true;
		}
		if (pageSizeString.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @param pSize
	 *            The pageSize to set.
	 */
	public void setPageSize(Integer pSize) {
		if (pSize == null || pSize.intValue() <= 0) {
			this.pageSize = null;
		} else {
			this.pageSize = pSize;
		}

	}

	/**
	 * @return Returns the totalItem.
	 */
	public Integer getTotalItem() {
		if (totalItem == null) {
			// throw new IllegalStateException("Please set the TotalItem
			// frist.");
			return defaultTotleItem;
		}
		return totalItem;
	}

	/**
	 * @param tItem
	 *            The totalItem to set.
	 */
	public void setTotalItem(Integer tItem) {
		if (tItem == null) {
			throw new IllegalArgumentException("TotalItem can't be null.");
		}
		this.totalItem = tItem;
		int current = this.getCurrentPage().intValue();
		int lastPage = this.getTotalPage();
		
		//sam modify by 2013-04-22  为了手机端查询用
/*		if (current > lastPage) {
			this.setCurrentPage(new Integer(lastPage));
		}*/
		
	}

	/**
	 * 
	 * @Description 总页数
	 * @return  
	 *
	 */
	public int getTotalPage() {
		int pgSize = this.getPageSize().intValue();
		int total = this.getTotalItem().intValue();
		int result = total / pgSize;
		if ((total == 0) || (total % pgSize != 0)) {
			result++;
		}
		return result;
	}

	@JsonIgnore
	public int getPageFristItem() {
		int cPage = this.getCurrentPage().intValue();
		if (cPage == 1)
			return 1;// 第一页开始当然是第 1 条记录
		cPage--;
		int pgSize = this.getPageSize().intValue();
		return pgSize * cPage + 1;
	}

	@JsonIgnore
	public int getPageLastItem() {
		int cPage = this.getCurrentPage().intValue();
		int pgSize = this.getPageSize().intValue();
		int assumeLast = pgSize * cPage;
		int totalItem = getTotalItem().intValue();
		if (assumeLast > totalItem) {
			return totalItem;
		} else {
			return assumeLast;
		}
	}

	/**
	 * @return Returns the endRow.  mysql中该值为，每页的条数，    limit 10,pagesize() :为偏移量
	 */
	@JsonIgnore
	public Integer getEndRow() {
		//sam add by 2013:04:01
		if (this.endRow>0 && this.startRow!=0){
			return endRow-startRow+1;			
		}else if(this.endRow>0 && this.startRow==0){
			return endRow-startRow;
		}
		
		//#pageSize:INTEGER#*#currentPage:INTEGER#
		return this.getPageSize();
	}

	/**
	 * @param endRow
	 *            The endRow to set.
	 */
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	/**
	 * @return Returns the startRow.
	 */
	@JsonIgnore
	public Integer getStartRow() {
		
		//sam add by 2013:04:01
		if (this.startRow>0){
			return startRow-1;
		}
		
		//#pageSize:INTEGER#*(#currentPage:INTEGER#-1)+1
		return this.getPageSize() *(this.getCurrentPage()-1);
	}

	/**
	 * @param startRow
	 *            The startRow to set.
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	protected String getSQLBlurValue(String value) {
		if (value == null)
			return null;
		return value + '%';
	}

	protected String formatDate(String datestring) {
		if (datestring == null || datestring.equals("")) {
			return null;
		} else
			return (datestring + " 00:00:00");
	}

	/**
	 * 时间查询时,结束时间的 23:59:59
	 */
	protected String addDateEndPostfix(String datestring) {
		if (datestring == null || datestring.equals("")) {
			return null;
		}
		return datestring + " 23:59:59";
	}

	/**
	 * 时间查询时，开始时间的 00:00:00
	 */
	protected String addDateStartPostfix(String datestring) {
		if (datestring == null || datestring.equals("")) {
			return null;
		}
		return datestring + " 00:00:00";
	}

	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	public Integer getPrevId() {
		return prevId;
	}

	public void setPrevId(Integer prevId) {
		this.prevId = prevId;
		this.startRow = 0;
	}
	
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	public Date getPrevDate() {
		return prevDate;
	}

	public void setPrevDate(Date prevDate) {
		this.prevDate = prevDate;
		this.startRow = 0;
	}

	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	public Integer getNextId() {
		return nextId;
	}

	public void setNextId(Integer nextId) {
		this.nextId = nextId;
		this.startRow = 0;
	}
	@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
	public Date getNextDate() {
		return nextDate;
	}

	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
		this.startRow = 0;
	}

	@JsonIgnore
	public String getDirection(){
		/** #20150914 4.2.2 push 审批 **/
		if(null != direction)
		    return direction;
		if(null != prevId || prevDate!=null)
			return "prev";
		return "next";
	}

	public boolean isFinallyPage() {
		
		return finallyPage;
	}

	public void setFinallyPage(boolean finallyPage) {
		this.finallyPage = finallyPage;
	}

	public Byte getSource_from_type() {
		return source_from_type;
	}

	public void setSource_from_type(Byte source_from_type) {
		this.source_from_type = source_from_type;
	}

	public Float getSource_from_version() {
		return source_from_version;
	}

	public void setSource_from_version(Float source_from_version) {
		this.source_from_version = source_from_version;
	}

	/** #20150914 4.2.2 push 审批 **/
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}