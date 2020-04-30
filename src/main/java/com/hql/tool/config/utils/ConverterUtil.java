package com.hql.tool.config.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhijie
 * 2020/4/30 10:43
 */
@Data
@Slf4j
public class ConverterUtil<DTO,VO> {
    /**
     * 对象转换
     * @param dto
     * @param clazz
     * @return
     */
    public static <DTO,VO> VO convert(DTO dto, Class<VO> clazz) {
        if (dto == null) {
            return null;
        }
        VO vo = null;
        try {
            vo = clazz.newInstance();
        } catch (Exception e) {
            log.error("初始化{}对象失败!", clazz, e);
        }
        BeanUtils.copyProperties(dto, vo);
        return vo;
    }

    /**
     * 批量对象转换
     * @param dtoList
     * @param clazz
     * @return
     */
    public static <DTO,VO> List<VO> convert(List<DTO> dtoList, Class<VO> clazz) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return null;
        }
        List<VO> voList = new ArrayList<VO>();
        for (DTO dto : dtoList) {
            voList.add(convert(dto, clazz));
        }
        return voList;
    }
}
