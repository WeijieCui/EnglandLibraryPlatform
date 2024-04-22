import request from '@/utils/request'

import {
  SearchListRequestParams,
  SearchListResponseProps,
  SearchListItemProps, SearchBookPrintingsRequestParams,
} from '@/types/search'

import { asyncSleep } from '@/utils/devhelper';

import mockSearchData from './mockSearchData';

/** 获取城市列表 */
export async function getCityOptions() {
  // TODO: 调用接口，返回类型为 ArrayList<{ value: string; label: string }>
  // const { data: { data } } = await request.get('/api/search/getCityOptions');
  // return data ?? [];
  return [
    { value: '1', label: 'London' },
    { value: '2', label: 'Oxford' },
    { value: '3', label: 'Cambridge' },
    { value: '4', label: 'Reading' },
  ]
}

/** 获取图书馆列表 */
export async function getLibraryOptions() {
  // TODO: 调用接口，返回类型为 ArrayList<{ value: string; label: string }>
  // const { data: { data } } = await request.get('/api/search/getLibraryOptions');
  // return data ?? [];

  return [
    { value: '1', label: 'London Centre Library' },
    { value: '2', label: 'Oxford Centre Library' },
    { value: '3', label: 'Cambridge Centre Library' },
    { value: '4', label: 'Reading Centre Library' },
  ]
}

/** 获取搜索页面下拉列表 */
export async function getSearchList(params: SearchListRequestParams) {
  // TODO: 调用接口，返回类型为 SearchListResponseProps
  const { data: { data: {data} } } = await request.post('/book/query', params);
  console.log('data:', data);
  return data;
}
/** 根据 ID 获取详情 */
export async function getSearchDetailById(params: SearchBookPrintingsRequestParams) {
  // TODO: 调用接口，返回类型为 SearchListItemProps
  console.log('params:',params, ',bookId:', params.bookId);
  const { data: { data } } = await request.post(`/bookPrinting/query`, params);
  return data;
}

/** 更新详情 city 数据 */
export async function updateDetailAddress(id: number, city: string) {
  // TODO: 调用接口，这里不用返回值
  // await request.post('/api/search/updateDetailAddress', {
  //   id,
  //   city,
  // });
  
  /** TODO: 以下为 mock 代码 */
  mockSearchData.forEach(s => {
    if (s.id === id) {
      s.city = city
    }
  })
}
/** 更新详情 library */
export async function updateDetailLibraryName(id: number, library: string) {
  // TODO: 调用接口，这里不用返回值
  // await request.post('/api/search/updateDetailLibraryName', {
  //   id,
  //   library
  // });
  
  /** TODO: 以下为 mock 代码 */
  mockSearchData.forEach(s => {
    if (s.id === id) {
      s.library = library
    }
  })
}