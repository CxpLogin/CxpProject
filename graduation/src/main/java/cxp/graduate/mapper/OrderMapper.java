package cxp.graduate.mapper;

import cxp.graduate.pojo.Directive;

public interface OrderMapper {
	/**
	* @return 
	 * @Title: findDirectiveFlag
	* @Description: 查询指令库标志位是否发生变化
	* @param：int
	* @return：ControlOrder
	* @throws：
	 */
	public Directive findDirectiveFlag(int d_id);

	/**
 	* @Title: updateDirectiveFlag
 	* @Description: 更新指令
 	* @param：Directive
 	* @return：void
 	* @throws：
 	 */
	public void updateDirectiveFlag(Directive directive);

	/**
 	* @Title: updateDirectiveFlag
 	* @Description: 更新指令
 	* @param：Directive
 	* @return：void
 	* @throws：
 	 */
	public void updataDirective(Directive directive);

	/**
	* @Title: insertDirective
	* @Description: 根据设备id插入指令库
	* @param：int d_id
	* @return：insertDirective
	* @throws：
	 */
	public void insertDirective(Directive directive);

	public void updataDirectiveByRelay(Directive directive);

	public void updataDirectiveByAlarm(Directive directive);	
 	
}
