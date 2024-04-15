import { useRequest, usePagination } from 'ahooks';
import { Form } from 'antd'

import { getCityOptions, getLibraryOptions, getSearchList } from '@/services/search';

export default function useSearch() {
  const [searchForm] = Form.useForm();

  const category = Form.useWatch('category', searchForm);
  const language = Form.useWatch('language', searchForm);
  const keywords = Form.useWatch('keywords', searchForm);
  const city = Form.useWatch('city', searchForm);
  const library = Form.useWatch('library', searchForm);

  const cityFetcher = useRequest(getCityOptions);
  const libraryFetcher = useRequest(getLibraryOptions);

  const searchListFetcher = usePagination(
    ({ current, pageSize }) =>
      getSearchList({
        current,
        pageSize,
        category,
        language,
        keywords,
        city,
        library,
      }),
    { manual: true })

  return {
    searchForm,
    searchParams: {
      category,
      language,
      keywords,
      city,
      library,
    },
    fetchers: {
      cityFetcher,
      libraryFetcher,
      searchListFetcher,
    }
  }
}