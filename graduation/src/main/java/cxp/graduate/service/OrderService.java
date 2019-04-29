package cxp.graduate.service;

import cxp.graduate.pojo.Directive;

/**
 * @ClassName：SensorService
 * @Description: 传感器的Service
 * @date:
 */

public interface OrderService {

	public Directive findDirectiveFlag(int d_id);

	public void updateDirectiveFlag(Directive directive);
	
	public void updataDirective(Directive directive);

	public void updataDirectiveByRelay(Directive directive);

	public void updataDirectiveByAlarm(Directive directive);	
	
}
