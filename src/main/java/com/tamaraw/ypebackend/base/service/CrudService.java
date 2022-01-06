package com.tamaraw.ypebackend.base.service;

import java.util.List;

public interface CrudService<DTO> {
    DTO create(DTO dto);
    DTO update(DTO dto);
    boolean delete(String id);
    List<DTO> getAll();
    DTO getOne(String id);
}
