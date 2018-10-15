package com.ruoyi.project.tool.swagger;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.mongo.entity.Mainbody;
import com.ruoyi.project.mongo.entity.MongoUser;
import com.ruoyi.project.mongo.repository.MainbodyRepository;
import com.ruoyi.project.mongo.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("mongo接口测试")
@RestController
@RequestMapping("/mongo")
public class MongoController extends BaseController{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MainbodyRepository mainbodyRepository;

    /**
     * 级联插入
     * @param user
     * @return
     */
    @ApiOperation("新增用户")
    @PostMapping("save")
    public AjaxResult save(MongoUser user)
    {
        try {
            Mainbody mainbody = mainbodyRepository.findByCode("001");
            user.setMainbody(mainbody);
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success();
    }

    @ApiOperation("查询单个用户")
    @PostMapping("findUserById")
    @ResponseBody
    public Object findUserById(@RequestParam(value = "id") Long id)
    {
        return userRepository.findById(id.intValue());
    }

    @ApiOperation("删除单个用户")
    @PostMapping("remove")
    public AjaxResult remove(@RequestParam(value = "id") Long id)
    {
        try {
            userRepository.deleteById(id.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toAjax(1);
    }

    @ApiOperation("查询所有用户")
    @PostMapping("findAll")
    @ResponseBody
    public Object findAll ()
    {
        try {
            List<MongoUser> list = userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRepository.findAll();
    }
}
