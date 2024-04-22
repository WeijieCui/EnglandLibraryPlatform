import { Space, Select, Input, Button, Form } from 'antd'
import { useModel, history } from 'umi';
import { useMemoizedFn } from 'ahooks';

import { CategoryOptions } from '@/types/search';

import styles from './index.less';

export interface SearchHeaderProps {
  allowCity?: boolean;
  allowLibrary?: boolean
}

const SearchHeader = (props: SearchHeaderProps) => {
  const { allowCity = true, allowLibrary = true } = props;
  const {
    searchForm,
    fetchers: {
      libraryFetcher,
      queryBookFetcher,
    }
  } = useModel('search');

  const handleSearch = useMemoizedFn(() => {
    queryBookFetcher.runAsync({
      current: 1,
      pageSize: 20,
    })
    history.push('/search')
  })

  return (
    <div className={styles.searchHeader}>
      <Form form={searchForm}>
        <Space>
          <Form.Item name="category">
            <Select allowClear placeholder="Category" options={CategoryOptions} />
          </Form.Item>
          {
            allowLibrary && (
              <Form.Item name="library">
                <Select
                  allowClear
                  placeholder="Library"
                  options={libraryFetcher.data}
                  loading={libraryFetcher.loading}
                />
              </Form.Item>
            )
          }
          <Form.Item name="keyword">
            <Input.Search placeholder="Search" onSearch={handleSearch} />
          </Form.Item>
          <Button>Advanced</Button>
        </Space>
      </Form>
    </div>
  )
}

export default SearchHeader;