package com.cxy.bms.manage.api;

import com.cxy.bms.manage.data.entity.Declare;
import com.cxy.bms.manage.service.IDeclareService;
import com.cxy.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenxy
 * @date 2020/4/22 17:31
 * @desc this is description
 */
@Api(value = "DeclareApi")
@RestController
@RequestMapping("/declare")
public class DeclareApi {


    @Autowired
    private IDeclareService declareService;

    @PostMapping()
    @ApiOperation(value = "新增Declare",notes = "新增Declare数据")
    @ApiImplicitParam(name = "declare",value = "Declare实体",required = true, dataType = "Declare")
    public Response add(@RequestBody Declare declare){

        declareService.save(declare);

        return new Response();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询Declare",notes = "根据id查询Declare数据")
    @ApiImplicitParam(name = "id",value = "DeclareID",required = true, dataType = "Long",paramType = "path")
    public Response query(@PathVariable("id") Long id){

        Declare declare = declareService.getById(id);

        return new Response(declare);
    }
}
