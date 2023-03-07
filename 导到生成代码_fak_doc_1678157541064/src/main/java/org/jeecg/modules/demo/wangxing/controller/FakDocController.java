package org.jeecg.modules.demo.wangxing.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.wangxing.entity.FakDoc;
import org.jeecg.modules.demo.wangxing.service.IFakDocService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 方案库--方案主表
 * @Author: jeecg-boot
 * @Date:   2023-03-07
 * @Version: V1.0
 */
@Api(tags="方案库--方案主表")
@RestController
@RequestMapping("/wangxing/fakDoc")
@Slf4j
public class FakDocController extends JeecgController<FakDoc, IFakDocService> {
	@Autowired
	private IFakDocService fakDocService;
	
	/**
	 * 分页列表查询
	 *
	 * @param fakDoc
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "方案库--方案主表-分页列表查询")
	@ApiOperation(value="方案库--方案主表-分页列表查询", notes="方案库--方案主表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<FakDoc>> queryPageList(FakDoc fakDoc,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<FakDoc> queryWrapper = QueryGenerator.initQueryWrapper(fakDoc, req.getParameterMap());
		Page<FakDoc> page = new Page<FakDoc>(pageNo, pageSize);
		IPage<FakDoc> pageList = fakDocService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param fakDoc
	 * @return
	 */
	@AutoLog(value = "方案库--方案主表-添加")
	@ApiOperation(value="方案库--方案主表-添加", notes="方案库--方案主表-添加")
	//@RequiresPermissions("org.jeecg.modules.demo:fak_doc:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody FakDoc fakDoc) {
		fakDocService.save(fakDoc);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param fakDoc
	 * @return
	 */
	@AutoLog(value = "方案库--方案主表-编辑")
	@ApiOperation(value="方案库--方案主表-编辑", notes="方案库--方案主表-编辑")
	//@RequiresPermissions("org.jeecg.modules.demo:fak_doc:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody FakDoc fakDoc) {
		fakDocService.updateById(fakDoc);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "方案库--方案主表-通过id删除")
	@ApiOperation(value="方案库--方案主表-通过id删除", notes="方案库--方案主表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.demo:fak_doc:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		fakDocService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "方案库--方案主表-批量删除")
	@ApiOperation(value="方案库--方案主表-批量删除", notes="方案库--方案主表-批量删除")
	//@RequiresPermissions("org.jeecg.modules.demo:fak_doc:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.fakDocService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "方案库--方案主表-通过id查询")
	@ApiOperation(value="方案库--方案主表-通过id查询", notes="方案库--方案主表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<FakDoc> queryById(@RequestParam(name="id",required=true) String id) {
		FakDoc fakDoc = fakDocService.getById(id);
		if(fakDoc==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(fakDoc);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param fakDoc
    */
    //@RequiresPermissions("org.jeecg.modules.demo:fak_doc:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, FakDoc fakDoc) {
        return super.exportXls(request, fakDoc, FakDoc.class, "方案库--方案主表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("fak_doc:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, FakDoc.class);
    }

}
