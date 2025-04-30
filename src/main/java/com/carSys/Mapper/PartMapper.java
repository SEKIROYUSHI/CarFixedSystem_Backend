package com.carSys.Mapper;

import com.carSys.Entity.Part;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PartMapper {
    /**
     * 插入新零件（测试/初始化时录入）
     */
    int insertPart(Part part);

    /**
     * 根据零件 ID 查询详情
     */
    Part selectPartById(long part_id);

    /**
     * 查询所有零件（支持模糊搜索零件名称）
     * @param keyword 可选：零件名称关键词（如 "刹车"）
     */
    List<Part> selectAllParts(@Param("keyword") String keyword);

    /**
     * 根据零件名称精确查询（用于校验唯一性）
     */
    Part selectPartByName(String part_name);

    /**
     * 更新零件信息（如修改单价或分类）
     */
    int updatePart(Part part);

    /**
     * 根据 ID 删除零件（逻辑删除或物理删除，需根据业务决定）
     */
    int deletePart(long part_id);
}