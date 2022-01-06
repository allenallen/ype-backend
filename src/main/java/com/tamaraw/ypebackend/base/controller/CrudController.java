package com.tamaraw.ypebackend.base.controller;

import com.tamaraw.ypebackend.base.model.ResponseDto;
import com.tamaraw.ypebackend.base.model.ResponseDtoWithObject;
import com.tamaraw.ypebackend.base.service.CrudService;
import com.tamaraw.ypebackend.base.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public abstract class CrudController<DTO> {

    private CrudService<DTO> crudService;

    @Autowired
    private Helper helper;

    @GetMapping
    public ResponseEntity<ResponseDto> getAll() {
        try {
            List<DTO> dtos = crudService.getAll();
            return ResponseEntity.ok(new ResponseDtoWithObject(dtos, 200, ""));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto(500, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getOne(@PathVariable String id) {
        try {
            DTO dto = crudService.getOne(id);
            return ResponseEntity.ok(new ResponseDtoWithObject(dto, 200, ""));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto(500, e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<ResponseDto> create(@RequestBody DTO dto) {
        try {
            return ResponseEntity.ok(new ResponseDtoWithObject(crudService.create(dto), 200, helper.getI18Nmessage("default.create.success.message")));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto(500, e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ResponseDto> update(@RequestBody DTO dto) {
        try {
            return ResponseEntity.ok(new ResponseDtoWithObject(crudService.update(dto), 200, helper.getI18Nmessage("default.update.success.message")));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto(500, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable String id) {
        try {
            crudService.delete(id);
            return ResponseEntity.ok(new ResponseDto(200, helper.getI18Nmessage("default.delete.success.message")));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ResponseDto(500, helper.getI18Nmessage("default.delete.failed.message", id)));

        }
    }

    public void setCrudService(CrudService<DTO> crudService) {
        this.crudService = crudService;
    }
}
