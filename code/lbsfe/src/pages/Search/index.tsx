import { List, Pagination } from 'antd'
import { useModel } from 'umi';
import { useMount } from 'ahooks';

import SearchHeader from './components/SearchHeader';
import ListItemCard from './components/ListItemCard';
import styles from './index.less';

const SearchPage = () => {

  const {
    fetchers: {
      searchListFetcher
    }
  } = useModel('search');

  useMount(() => {
    searchListFetcher.runAsync({
      current: 1,
      pageSize: 20
    })
  })

  return (
    <div className={styles.search}>
      <SearchHeader />
      <div className={styles.list}>
        <List
          dataSource={searchListFetcher.data?.list ?? []}
          loading={searchListFetcher.loading}
          footer={(
            <div className={styles.pagination}>
              <Pagination
                showTotal={total => `Total ${total} items`}
                {...searchListFetcher.pagination}
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
