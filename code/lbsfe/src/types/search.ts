/** 分类选择下拉框 */
export const CategoryOptions = [
  { value: 'Fiction', label: 'Fiction' },
  { value: 'Science', label: 'Science' },
  { value: 'History', label: 'History' },
]

/** 语言选择下拉框 */
export const LanguageOptions = [
  { value: 'English', label: 'English' },
  { value: 'Franch', label: 'Franch' },
  { value: 'Geman', label: 'Geman' },
]

/** 搜索页面list接口入参类型 */
export interface SearchListRequestParams {
  /** 当前页码 */
  current: number;
  /** 每页显示条数 */
  pageSize: number;
  /** 以下参数为顶部搜索表单每个字段的值 */
  category?: string;
  language?: string;
  keywords?: string;
  city?: string;
  library?: string;
}
/**
 * 搜索列表每项定义
 * TODO: 这里的类型是我根据页面随便定义的，你根据你后端数据库的自行修改哈
 * */
export interface SearchListItemProps {
  id: number;
  name: string;
  ISBN: string;
  Published: string;
  tips: string;
  imgSrc: string;
  /**
   * TODO: 下列字段是详情页的下拉框和表格用到
   * 暂定 city library tableData */
  city?: string;
  library?: string;
  tableData?: SearchDetailTableDataItem[]
}
/** 搜索详情页下方表格数据item */
export interface SearchDetailTableDataItem {
  id: number;
  order: number;
  status: string;
}
/** 搜索页面list接口返回类型 */
export interface SearchListResponseProps {
  /** 总数 */
  total: number;
  /** 当前页码 */
  current: number;
  /** 每页显示条数 */
  pageSize: number;
  /** 页面数据 */
  list: SearchListItemProps[]
}