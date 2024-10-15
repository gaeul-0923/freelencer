package com.freelencer.market.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVO {

	private String result;
	private Object data;
	private Object error;

	public ResponseVO(ResponseCode result, Object object) {
		this.result = result.getCode();
		if ("SUCCESS".equals(result.getCode())) {
			this.data = object;
			this.error = null;
		} else {
			this.data = null;
			this.error = object;
		}
	}

}
