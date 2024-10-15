package com.freelencer.market.common.response;

import lombok.Getter;
import lombok.Setter;

import java.lang.Error;


@Getter
@Setter
public class ErrorVO {

	private String message;

	public ErrorVO(Error error){
		this.message = error.getMessage();
	}
}
