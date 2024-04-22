package com.example.lbsbackend.mapper;

import com.example.lbsbackend.entity.Library;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LibraryMapper {
    Library queryById(Long id);
}
