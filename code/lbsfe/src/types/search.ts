/** 分类选择下拉框 */
export const CategoryOptions = [
  { value: '1', label: 'Science' },
  { value: '2', label: 'Physics' },
  { value: '3', label: 'Chemistry' },
]

/** 语言选择下拉框 */
export const LanguageOptions = [
  { value: 'English', label: 'English' },
  { value: 'French', label: 'French' },
  { value: 'German', label: 'German' },
]
export interface Page {
  pageSize: number;
  current: number;
}

/** 搜索页面list接口入参类型 */
export interface SearchListRequestParams {
  page: Page;
  /** 当前页码 */
  current: number;
  /** 每页显示条数 */
  pageSize: number;
  /** 以下参数为顶部搜索表单每个字段的值 */
  categoryId?: string;
  language?: string;
  keyword?: string;
  city?: string;
  libraryId?: string;
}
/** 搜索页面list接口入参类型 */
export interface SearchBookPrintingsRequestParams {
  page: Page;
  bookId?: number;
  libraryId?: string;
}
/** Book Printing Reserve req params */
export interface BookPrintingsReserveRequestParams {
  targetLibraryId: number;
  bookPrintingId: number;
  userId: number;
  expectedPickupTime: String;
}
/**
 * 搜索列表每项定义
 * TODO: 这里的类型是我根据页面随便定义的，你根据你后端数据库的自行修改哈
 * */
export interface SearchListItemProps {
  id: string;
  title: string;
  isbn: string;
  publisher: string;
  publishedDate: string;
  summary: string;
  image: string;
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
  status: string;
  library: Library;
}
/** 搜索详情页下方表格数据item */
export interface Library {
  id: number;
  name: string;
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