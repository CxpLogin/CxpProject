package cxp.graduate.service;

import cxp.graduate.pojo.ControlOrder;
import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Sensor;

/**
 * @ClassName：SensorService
 * @Description: 传感器的Service
 * @date:
 */

public interface OrderService {
	
	/**
	* @Title: selectFlag
	* @Description: 查询指令库
	* @param：int
	* @return：ControlOrder
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
