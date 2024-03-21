package com.apiserver.controller;

import com.apiserver.dto.CategoryDTO;
import com.apiserver.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryMapper categoryMapper;

    @GetMapping("/parent_category")
    public List<CategoryDTO> select_parent_category() {
        return categoryMapper.select_parent_category(0);
    }

    @GetMapping("/children_category")
    public List<CategoryDTO> select_children_category(@RequestParam("no") String no) {
        if (Integer.parseInt(no) == 0) {
            return null;
        }
        return categoryMapper.select_parent_category(Integer.parseInt(no));
    }
}
