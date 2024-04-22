import {List, Pagination, PaginationProps} from 'antd'
import { useModel } from 'umi';
import { useMount } from 'ahooks';

import SearchHeader from './components/SearchHeader';
import ListItemCard from './components/ListItemCard';
import styles from './index.less';
const onShowSizeChange: PaginationProps['onShowSizeChange'] = (current, pageSize) => {
    console.log(current, pageSize);
};
const SearchPage = () => {

  const {
    fetchers: {
      queryBookFetcher
    }
  } = useModel('search');

  useMount(() => {
    queryBookFetcher.runAsync({
      current: 1,
      pageSize: 10
    })
  })

  return (
    <div className={styles.search}>
      <SearchHeader />
      <div className={styles.list}>
        <List
          dataSource={queryBookFetcher?.data ?? []}
          loading={queryBookFetcher.loading}
          footer={(
            <div className={styles.pagination}>
              <Pagination
                showTotal={total => `Total ${total} items`}
                onShowSizeChange={onShowSizeChange}
                {...queryBookFetcher.pagination}
                />
            </div>
          )}
          renderItem={item => <ListItemCard data={item} />}
        />
      </div>
    </div>
  );
};

export default SearchPage;
