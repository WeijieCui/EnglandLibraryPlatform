package com.example.lbsbackend.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ClassConverter {
    public static <S, T> List<T> classConvert(List<S> sourceList, List<T> targetList) {
        List<T> resultList = new ArrayList<>();
        if (!(sourceList == null || sourceList.isEmpty())) {
            sourceList.forEach(s -> {
                Object t = new Object();
                BeanUtils.copyProperties(s, t);
            });
        }
        return resultList;
    }
}
