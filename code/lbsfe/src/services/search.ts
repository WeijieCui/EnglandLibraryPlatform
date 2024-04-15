import request from '@/utils/request'

import {
  SearchListRequestParams,
  SearchListResponseProps,
  SearchListItemProps,
} from '@/types/search'

import { asyncSleep } from '@/utils/devhelper';

import mockSearchData from './mockSearchData';

/** 获取城市列表 */
export async function getCityOptions() {
  // TODO: 调用接口，返回类型为 ArrayList<{ value: string; label: string }>
  // const { data: { data } } = await request.get('/api/search/getCityOptions');
  // return data ?? [];
  return [
    { value: 'Beijing', label: 'Beijing' },
    { value: 'London', label: 'London' }
  ]
}

/** 获取图书馆列表 */
export async function getLibraryOptions() {
  // TODO: 调用接口，返回类型为 ArrayList<{ value: string; label: string }>
  // const { data: { data } } = await request.get('/api/search/getLibraryOptions');
  // return data ?? [];
  return [
    { value: 'Beijing Centre Library', label: 'Beijing Centre Library' },
    { value: 'London Centre Library', label: 'London Centre Library' }
  ]
}

/** 获取搜索页面下拉列表 */
export async function getSearchList(params: SearchListRequestParams) {
  // TODO: 调用接口，返回类型为 SearchListResponseProps
  // const { data: { data } } = await request.post('/api/search/getSearchList', params);
  // return data;

  /** TODO: 以下为 mock 代码 */
  console.log(params);
  await asyncSleep();
  const mockResponseData = mockSearchData.slice((params.current - 1) * params.pageSize, params.current * params.pageSize)
  return {
    current: 1,
    pageSize: 20,
    total: mockSearchData.length,
    list: mockResponseData
  } as SearchListResponseProps
}
/** 根据 ID 获取详情 */
export async function getSearchDetailById(id: number) {
  // TODO: 调用接口，返回类型为 SearchListItemProps
  // const { data: { data } } = await request.get('/api/search/getSearchDetailById', {
  //   params: {
  //     id
  //   }
  // });
  // return data;

  /** TODO: 以下为 mock 代码 */
  await asyncSleep();
  return mockSearchData.find(s => s.id === id);
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