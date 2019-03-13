package cxp.graduate.utils;

import java.util.ArrayList;
import java.util.List;

import cxp.graduate.pojo.Device;
import cxp.graduate.pojo.Rows;

/**
 * @ClassName：JsonUtils
 * @Description: 设备表的Json返回数据封装
 * @date: 2019-03-12 V1.1
 */
public class JsonUtils {
    private int status;
    private String message;
    private Long total; //总条数
    private Rows rows;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Rows getRows() {
		return rows;
	}
	public void setRows(Rows rows) {
		this.rows = rows;
	}


    
}
