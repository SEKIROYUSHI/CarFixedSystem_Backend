package com.carSys.Controller;

import com.carSys.Entity.Part;
import com.carSys.Service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carsys/part")
public class PartController {

    @Autowired
    private PartService partService;

    /**
     * 创建新零件
     * @param part 零件信息（需包含 part_name, unit_price, category）
     * @return 添加成功返回 true，名称重复返回 false
     */
    @PostMapping("/create")
    public boolean createPart(@RequestBody Part part) {
        return partService.addPart(part);
    }

    /**
     * 根据 ID 查询零件详情
     */
    @GetMapping("/{partId}")
    public Part getPartById(@PathVariable long partId) {
        return partService.getPartById(partId);
    }

    /**
     * 查询所有零件（支持模糊搜索）
     * @param keyword 可选：零件名称关键词（如 "刹车"）
     */
    @GetMapping("/list")
    public List<Part> listParts(@RequestParam(required = false) String keyword) {
        return partService.listParts(keyword);
    }

    /**
     * 更新零件信息
     * @param part 需包含 part_id（主键）及要更新的字段
     * @return 更新成功返回 true，名称重复返回 false
     */
    @PutMapping("/update")
    public boolean updatePart(@RequestBody Part part) {
        return partService.updatePart(part);
    }

    /**
     * 根据 ID 删除零件
     */
    @DeleteMapping("/{partId}")
    public boolean deletePart(@PathVariable long partId) {
        return partService.deletePart(partId);
    }
}