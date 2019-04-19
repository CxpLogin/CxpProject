package cxp.graduate.service;

import cxp.graduate.pojo.Directive;

/**
 * @ClassName：SensorService
 * @Description: 传感器的Service
 * @date:
 */

public interface OrderService {

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

	public void updataDirectiveByRelay(Directive directive);

	public void updataDirectiveByAlarm(Directive directive);	
	
}
