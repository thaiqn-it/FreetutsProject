package com.mockproject.freetutsproject.dto;

import lombok.Data;

@Data
public class AdminDTO extends AbstractDTO<AdminDTO> {
	private String username;
	private String password;
	private String fullname;
}
