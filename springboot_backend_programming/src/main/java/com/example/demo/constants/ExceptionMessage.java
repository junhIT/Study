package com.example.demo.constants;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
	NAVER_API_UNAUTHORIZED("���̹� ���� API ��� �� ���� ������ �߻��Ͽ����ϴ�."),
	NAVER_API_BAD_REQUEST("�߸��� ��û ����, �Ǵ� �������� ���� ��û�Դϴ�."),
	NAVER_API_ERROR("���̹� ���� API ��� �� �� �� ���� ������ �߻��Ͽ����ϴ�."),
	NO_CONTENT("�����Ͱ� �����ϴ�.");
	
	private String message;
	
	ExceptionMessage(String message) {
		this.message = message;
	}
	
}
