import { Spin, Skeleton, Row, Col, Table, Select, Typography, message } from 'antd';
import { useParams, useModel } from 'umi';
import { useMemoizedFn, useRequest } from 'ahooks';
import { useState } from 'react';

import { getSearchDetailById, updateDetailAddress, updateDetailLibraryName, } from '@/services/search';
import { SearchDetailTableDataItem } from '@/types/search';

import SearchHeader from '../components/SearchHeader';
import styles from './index.less';

const SearchDetailPage = () => {
  const { id: paramId } = useParams();
  const id = Number(paramId);
  const [city, setCity] = useState<string>();
  const [library, setLibrary] = useState<string>();
  const {
    fetchers: {
      cityFetcher,
      libraryFetcher,
    }
  } = useModel('search');

  const detailFetcher = useRequest(() => getSearchDetailById(id), {
    refreshDeps: [id],
    onSuccess: (res) => {
      setCity(res?.city);
      setLibrary(res?.library);
    }
  })

  const handleChangeAddress = useMemoizedFn(async (newVal) => {
    setCity(newVal);
    updateDetailAddress(id, newVal);
  })
  const handleChangeLibraryName = useMemoizedFn(async (newVal) => {
    setLibrary(newVal);
    updateDetailLibraryName(id, newVal)
  })
  const handleReserve = useMemoizedFn(async (item: SearchDetailTableDataItem) => {
    message.success('Reserve sussess');
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
              <img src={detailInfo.imgSrc} />
              <div className={styles.detail}>
                <h1>{detailInfo.name}</h1>
                <Row gutter={16}>
                  <Col span={12}>ISBN: {detailInfo.ISBN}-{detailInfo.id}</Col>
                  <Col span={12}>Published: {detailInfo.Published}</Col>
                  <Col span={24}>{detailInfo.tips}</Col>
                </Row>
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
                      value={library}
                      onChange={handleChangeLibraryName}
                      options={libraryFetcher.data}
                      loading={libraryFetcher.loading}
                      placeholder="Library"
                    />
                  </Col>
                </Row>
                <Table
                  bordered
                  pagination={false}
                  dataSource={detailInfo.tableData}
                  columns={[
                    { title: 'Order', dataIndex: 'order' },
                    { title: 'Status', dataIndex: 'status' },
                    {
                      title: 'Action',
                      dataIndex: 'order',
                      render: (_, record) => <Typography.Link onClick={() => handleReserve(record)}>Reserve</Typography.Link>
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
