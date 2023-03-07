import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '创建人名称',
    align:"center",
    dataIndex: 'createUser'
   },
   {
    title: '方案分类id',
    align:"center",
    dataIndex: 'categoryId'
   },
   {
    title: '方案名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '关键字',
    align:"center",
    dataIndex: 'keywords'
   },
   {
    title: '删除标记',
    align:"center",
    dataIndex: 'delFlag'
   },
   {
    title: '审核状态',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '0自营1合作2第三方',
    align:"center",
    dataIndex: 'sourceFlag'
   },
   {
    title: '转换状态：0等待转换1转换成功1转换失败',
    align:"center",
    dataIndex: 'convertFlag'
   },
   {
    title: '转换说明',
    align:"center",
    dataIndex: 'processMsg'
   },
   {
    title: '是否公开；0公开，1加密',
    align:"center",
    dataIndex: 'publicFlag'
   },
   {
    title: '下载次数',
    align:"center",
    dataIndex: 'downloads'
   },
   {
    title: '观看次数',
    align:"center",
    dataIndex: 'views'
   },
   {
    title: '源文件地址',
    align:"center",
    dataIndex: 'url'
   },
   {
    title: '源文件地址PDF',
    align:"center",
    dataIndex: 'urlPdf'
   },
   {
    title: '源文件地址PDF水印',
    align:"center",
    dataIndex: 'urlPdfMarker'
   },
   {
    title: '后缀名',
    align:"center",
    dataIndex: 'extension'
   },
   {
    title: '源文件名称',
    align:"center",
    dataIndex: 'originalName'
   },
   {
    title: '方案星级',
    align:"center",
    dataIndex: 'star'
   },
   {
    title: '文件id',
    align:"center",
    dataIndex: 'fileId'
   },
   {
    title: '文件大小',
    align:"center",
    dataIndex: 'fileSize'
   },
   {
    title: '试用区域；0区县级1市级2省级',
    align:"center",
    dataIndex: 'areaType'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '创建人名称',
    field: 'createUser',
    component: 'Input',
  },
  {
    label: '方案分类id',
    field: 'categoryId',
    component: 'Input',
  },
  {
    label: '方案名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '关键字',
    field: 'keywords',
    component: 'Input',
  },
  {
    label: '删除标记',
    field: 'delFlag',
    component: 'InputNumber',
  },
  {
    label: '审核状态',
    field: 'status',
    component: 'InputNumber',
  },
  {
    label: '0自营1合作2第三方',
    field: 'sourceFlag',
    component: 'InputNumber',
  },
  {
    label: '转换状态：0等待转换1转换成功1转换失败',
    field: 'convertFlag',
    component: 'InputNumber',
  },
  {
    label: '转换说明',
    field: 'processMsg',
    component: 'Input',
  },
  {
    label: '是否公开；0公开，1加密',
    field: 'publicFlag',
    component: 'InputNumber',
  },
  {
    label: '下载次数',
    field: 'downloads',
    component: 'InputNumber',
  },
  {
    label: '观看次数',
    field: 'views',
    component: 'InputNumber',
  },
  {
    label: '源文件地址',
    field: 'url',
    component: 'Input',
  },
  {
    label: '源文件地址PDF',
    field: 'urlPdf',
    component: 'Input',
  },
  {
    label: '源文件地址PDF水印',
    field: 'urlPdfMarker',
    component: 'Input',
  },
  {
    label: '后缀名',
    field: 'extension',
    component: 'Input',
  },
  {
    label: '源文件名称',
    field: 'originalName',
    component: 'Input',
  },
  {
    label: '方案星级',
    field: 'star',
    component: 'InputNumber',
  },
  {
    label: '文件id',
    field: 'fileId',
    component: 'InputNumber',
  },
  {
    label: '文件大小',
    field: 'fileSize',
    component: 'Input',
  },
  {
    label: '试用区域；0区县级1市级2省级',
    field: 'areaType',
    component: 'InputNumber',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];



/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}