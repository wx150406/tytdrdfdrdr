package org.jeecg.modules.demo.wangxing.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 方案库--方案主表
 * @Author: jeecg-boot
 * @Date:   2023-03-07
 * @Version: V1.0
 */
@Data
@TableName("fak_doc")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fak_doc对象", description="方案库--方案主表")
public class FakDoc implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**创建人名称*/
	@Excel(name = "创建人名称", width = 15)
    @ApiModelProperty(value = "创建人名称")
    private java.lang.String createUser;
	/**方案分类id*/
	@Excel(name = "方案分类id", width = 15)
    @ApiModelProperty(value = "方案分类id")
    private java.lang.String categoryId;
	/**方案名称*/
	@Excel(name = "方案名称", width = 15)
    @ApiModelProperty(value = "方案名称")
    private java.lang.String name;
	/**关键字*/
	@Excel(name = "关键字", width = 15)
    @ApiModelProperty(value = "关键字")
    private java.lang.String keywords;
	/**删除标记*/
	@Excel(name = "删除标记", width = 15)
    @ApiModelProperty(value = "删除标记")
    private java.lang.Integer delFlag;
	/**审核状态*/
	@Excel(name = "审核状态", width = 15)
    @ApiModelProperty(value = "审核状态")
    private java.lang.Integer status;
	/**0自营1合作2第三方*/
	@Excel(name = "0自营1合作2第三方", width = 15)
    @ApiModelProperty(value = "0自营1合作2第三方")
    private java.lang.Integer sourceFlag;
	/**转换状态：0等待转换1转换成功1转换失败*/
	@Excel(name = "转换状态：0等待转换1转换成功1转换失败", width = 15)
    @ApiModelProperty(value = "转换状态：0等待转换1转换成功1转换失败")
    private java.lang.Integer convertFlag;
	/**转换说明*/
	@Excel(name = "转换说明", width = 15)
    @ApiModelProperty(value = "转换说明")
    private java.lang.String processMsg;
	/**是否公开；0公开，1加密*/
	@Excel(name = "是否公开；0公开，1加密", width = 15)
    @ApiModelProperty(value = "是否公开；0公开，1加密")
    private java.lang.Integer publicFlag;
	/**下载次数*/
	@Excel(name = "下载次数", width = 15)
    @ApiModelProperty(value = "下载次数")
    private java.lang.Double downloads;
	/**观看次数*/
	@Excel(name = "观看次数", width = 15)
    @ApiModelProperty(value = "观看次数")
    private java.lang.Double views;
	/**源文件地址*/
	@Excel(name = "源文件地址", width = 15)
    @ApiModelProperty(value = "源文件地址")
    private java.lang.String url;
	/**源文件地址PDF*/
	@Excel(name = "源文件地址PDF", width = 15)
    @ApiModelProperty(value = "源文件地址PDF")
    private java.lang.String urlPdf;
	/**源文件地址PDF水印*/
	@Excel(name = "源文件地址PDF水印", width = 15)
    @ApiModelProperty(value = "源文件地址PDF水印")
    private java.lang.String urlPdfMarker;
	/**后缀名*/
	@Excel(name = "后缀名", width = 15)
    @ApiModelProperty(value = "后缀名")
    private java.lang.String extension;
	/**源文件名称*/
	@Excel(name = "源文件名称", width = 15)
    @ApiModelProperty(value = "源文件名称")
    private java.lang.String originalName;
	/**方案星级*/
	@Excel(name = "方案星级", width = 15)
    @ApiModelProperty(value = "方案星级")
    private java.lang.Integer star;
	/**文件id*/
	@Excel(name = "文件id", width = 15)
    @ApiModelProperty(value = "文件id")
    private java.lang.Integer fileId;
	/**文件大小*/
	@Excel(name = "文件大小", width = 15)
    @ApiModelProperty(value = "文件大小")
    private java.lang.String fileSize;
	/**试用区域；0区县级1市级2省级*/
	@Excel(name = "试用区域；0区县级1市级2省级", width = 15)
    @ApiModelProperty(value = "试用区域；0区县级1市级2省级")
    private java.lang.Integer areaType;
}
