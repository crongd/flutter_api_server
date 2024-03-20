package com.apiserver.controller;

import com.apiserver.dto.CategoryDTO;
import com.apiserver.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryMapper categoryMapper;

    @GetMapping("/parent_category")
    public List<CategoryDTO> select_parent_category() {
        return categoryMapper.select_parent_category();
    }
}
