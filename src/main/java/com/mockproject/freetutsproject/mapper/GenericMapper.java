package com.mockproject.freetutsproject.mapper;

import com.mockproject.freetutsproject.dto.AbstractDTO;
import com.mockproject.freetutsproject.entity.BaseEntity;

public interface GenericMapper <Entity extends BaseEntity, DTO extends AbstractDTO<DTO>>{
	DTO toDTO(Entity entity);
	Entity toEntity(DTO dto);
}
