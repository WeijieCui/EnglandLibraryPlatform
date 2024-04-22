import { Spin, Skeleton, Row, Col, Table, Select, Typography, message } from 'antd';
import { useParams, useModel } from 'umi';
import {useMemoizedFn, useMount, usePagination, useRequest} from 'ahooks';
import { useState } from 'react';

import { getSearchDetailById, updateDetailAddress, updateDetailLibraryName, } from '@/services/search';
import {Page, SearchDetailTableDataItem} from '@/types/search';

import SearchHeader from '../components/SearchHeader';
import styles from './index.less';

const SearchDetailPage = () => {
  const { id: paramId } = useParams();
  const bookId = Number(paramId);
  const [city, setCity] = useState<string>();
  const [libraryId, setLibrary] = useState<string>();
  const page: Page= {pageSize:100,current:1};
  const [selectedRowKeys, setSelectedRowKeys] = useState<any>([]);
  const {
    fetchers: {
      cityFetcher,
      libraryFetcher,
    }
  } = useModel('search');

  const detailFetcher = usePagination(({current, pageSize}) =>
      getSearchDetailById({page, bookId, libraryId}), {
        onSuccess: (res) => {
          console.log('fetch details success,', res.data);
          setSelectedRowKeys(res.data);
        }
      }
  )

  const handleChangeAddress = useMemoizedFn(async (newVal) => {
    setCity(newVal);
    updateDetailAddress(bookId, newVal);
  })
  const handleChangeLibraryName = useMemoizedFn(async (newVal) => {
    setLibrary(newVal);
    updateDetailLibraryName(bookId, newVal)
  })
  const handleReserve = useMemoizedFn(async (item: SearchDetailTableDataItem) => {
    message.success('Reserve success,'+ item.library.name);
  })

  const detailInfo = detailFetcher.data;

  return (
    <div className={styles.searchDetail}>
      <SearchHeader allowCity={false} allowLibrary={false} />
      <Spin spinning={detailFetcher.loading}>
        {
          !detailInfo? (
            <Skeleton />
          ) : (
            <div className={styles.conta}>
              {/*<img src={detailInfo.image} alt={detailInfo.title} className={styles.img} />*/}
              <div className={styles.detail}>
                <Row gutter={16} style={{ padding: '16px 0' }}>
                  <Col span={12}>
                    <Select
                      value={city}
                      onChange={handleChangeAddress}
                      options={cityFetcher.data}
                      placeholder="City"
                    />
                  </Col>
                  <Col span={12}>
                    <Select
                      value={libraryId}
                      onChange={handleChangeLibraryName}
                      options={libraryFetcher.data}
                      loading={libraryFetcher.loading}
                      placeholder="Library"
                    />
                  </Col>
                </Row>
                <div>length:{selectedRowKeys.length}</div>
                <Table
                  bordered
                  pagination={false}
                  rowKey="id"
                  dataSource={selectedRowKeys}
                  columns={[
                    { title: 'Original Library', dataIndex: ['realLibrary','name']},
                    { title: 'Current Library', dataIndex: ['realLibrary','name']},
                    { title: 'Status', dataIndex: 'status' },
                    {
                      title: 'Action',
                      dataIndex: 'id',
                      render: (_, record:SearchDetailTableDataItem) => <Typography.Link onClick={() => handleReserve(record)}>Reserve</Typography.Link>
                    },
                  ]}
                />
              </div>
            </div>
          )
        }
      </Spin>
    </div>
  );
};

export default SearchDetailPage;
