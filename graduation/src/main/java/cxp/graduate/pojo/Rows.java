package cxp.graduate.pojo;

import java.util.List;

public class Rows {
	/**
	 * @ClassName：
	 * @Description:
	 * @date:
	 */
	private List<Device> item;
	private List<Sensor> sensor;
	

	public List<Sensor> getSensor() {
		return sensor;
	}

	public void setSensor(List<Sensor> sensor) {
		this.sensor = sensor;
	}

	public List<Device> getItem() {
		return item;
	}

	public void setItem(List<Device> item) {
		this.item = item;
	}


}
