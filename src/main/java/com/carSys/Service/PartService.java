package com.carSys.Service;

import com.carSys.Entity.Part;
import com.carSys.Mapper.PartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PartService {

    @Autowired
    private PartMapper partMapper;

    /**
     * 添加新零件（校验名称唯一性）
     */
    public boolean addPart(Part part) {
        // 校验零件名称是否已存在
        Part existingPart = partMapper.selectPartByName(part.getPart_name());
        if (existingPart != null) {
            return false; // 名称重复，添加失败
        }
        return partMapper.insertPart(part) > 0;
    }

    /**
     * 根据 ID 查询零件详情
     */
    public Part getPartById(long partId) {
        return partMapper.selectPartById(partId);
    }

    /**
     * 查询所有零件（支持模糊搜索）
     */
    public List<Part> listParts(String keyword) {
        return partMapper.selectAllParts(StringUtils.hasText(keyword) ? keyword : null);
    }

    /**
     * 更新零件信息（校验名称唯一性）
     */
    public boolean updatePart(Part part) {
        // 检查是否存在其他零件使用相同名称（排除当前零件自身）
        Part existingPart = partMapper.selectPartByName(part.getPart_name());
        if (existingPart != null && existingPart.getPart_id() != part.getPart_id()) {
            return false; // 名称重复，更新失败
        }
        return partMapper.updatePart(part) > 0;
    }

    /**
     * 根据 ID 删除零件
     */
    public boolean deletePart(long partId) {
        return partMapper.deletePart(partId) > 0;
    }
}