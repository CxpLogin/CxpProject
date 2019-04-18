package cxp.graduate.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName：设备数
 * @Description:
 * @date:
 */
public class Devices implements Serializable{
	private static final long serialVersionUID = 1L;
	private int devices;
	private int parlour;
	private int bedroom;
	private int kitchen;
	private List parlourId;
	private List bedroomId;
	private List kitchenId;
	private List deviceId;
	public int getDevices() {
		return devices;
	}

	public void setDevices(int devices) {
		this.devices = devices;
	}

	public int getParlour() {
		return parlour;
	}

	public void setParlour(int parlour) {
		this.parlour = parlour;
	}

	public int getBedroom() {
		return bedroom;
	}

	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}

	public int getKitchen() {
		return kitchen;
	}

	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}

	public List getParlourId() {
		return parlourId;
	}

	public void setParlourId(List parlourId) {
		this.parlourId = parlourId;
	}

	public List getBedroomId() {
		return bedroomId;
	}

	public void setBedroomId(List bedroomId) {
		this.bedroomId = bedroomId;
	}

	public List getKitchenId() {
		return kitchenId;
	}

	public void setKitchenId(List kitchenId) {
		this.kitchenId = kitchenId;
	}

	public List getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(List deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "Devices [devices=" + devices + ", parlour=" + parlour + ", bedroom=" + bedroom + ", kitchen=" + kitchen
				+ ", parlourId=" + parlourId + ", bedroomId=" + bedroomId + ", kitchenId=" + kitchenId + ", deviceId="
				+ deviceId + "]";
	}
	
}
