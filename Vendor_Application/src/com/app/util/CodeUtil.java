package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
	private String getCommonStr(int len) {

		return UUID.randomUUID().toString().replaceAll("", "").substring(0, len);

	}

	public String genPwd() {
		return getCommonStr(6);

	}

	public String genTocken() {
		return getCommonStr(8);

	}

}
