package cxp.graduate.pojo;
/**
 * @ClassName：MapBean
 * @Description:传感器的Bean
 * @date:
 */
public class MapBean {
	private String gpsaddr;
	private String setaddr;
	public String getGpsaddr() {
		return gpsaddr;
	}
	public void setGpsaddr(String gpsaddr) {
		this.gpsaddr = gpsaddr;
	}
	public String getSetaddr() {
		return setaddr;
	}
	public void setSetaddr(String setaddr) {
		this.setaddr = setaddr;
	}
	@Override
	public String toString() {
		return "MapBean [gpsaddr=" + gpsaddr + ", setaddr=" + setaddr + "]";
	}
	
}
