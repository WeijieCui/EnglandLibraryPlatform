import { useRequest, usePagination } from 'ahooks';
import { Form } from 'antd'

import { getCityOptions, getLibraryOptions, getSearchList } from '@/services/search';
import {Page} from "@/types/search";

export default function useSearch() {
  const [searchForm] = Form.useForm();

  const categoryId = Form.useWatch('category', searchForm);
  const language = Form.useWatch('language', searchForm);
  const keyword = Form.useWatch('keyword', searchForm);
  const city = Form.useWatch('city', searchForm);
  const libraryId = Form.useWatch('library', searchForm);
  const page: Page= {pageSize:10,current:1};

  const cityFetcher = useRequest(getCityOptions);
  const libraryFetcher = useRequest(getLibraryOptions);

  const queryBookFetcher = usePagination(
    ({ current, pageSize }) =>
      getSearchList({
        page,
        current,
        pageSize,
        categoryId,
        language,
        keyword,
        city,
        libraryId,
      }),
    { manual: true })

  return {
    searchForm,
    searchParams: {
      category: categoryId,
      language,
      keyword,
      city,
      libraryId,
    },
    fetchers: {
      cityFetcher,
      libraryFetcher,
      queryBookFetcher,
    }
  }
}