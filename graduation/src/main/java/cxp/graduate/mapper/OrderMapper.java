package cxp.graduate.mapper;

import cxp.graduate.pojo.ControlOrder;

public interface OrderMapper {	
 	/**
	* @Title: compareTime
	* @Description: 获取控制指令
	* @param：String
	* @return：int 
	* @throws：
	 */
 	public ControlOrder selectFlag(int cid_did);
 	
 	/**
 	* @Title: updateOrder
 	* @Description: 更新指令
 	* @param：ControlOrder
 	* @return：void
 	* @throws：
 	 */
 	public void updateOrder(ControlOrder order);
}
