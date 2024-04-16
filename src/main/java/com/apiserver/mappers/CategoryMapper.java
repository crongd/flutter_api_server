package com.apiserver.mappers;

import com.apiserver.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<CategoryDTO> select_all_category();

}
