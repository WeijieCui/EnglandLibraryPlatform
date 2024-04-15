import { Row, Col, Typography } from 'antd';
import { history } from 'umi';

import { SearchListItemProps } from '@/types/search';

import styles from './index.less';

const ListItemCard = (props: { data: SearchListItemProps }) => {
  const { data } = props;

  return (
    <div className={styles.listItemCard}>
      <img src={data.imgSrc} />
      <div className={styles.detail}>
        <h1>{data.name}</h1>
        <Row gutter={16}>
          <Col span={12}>ISBN: {data.ISBN}-{data.id}</Col>
          <Col span={12}>Published: {data.Published}</Col>
          <Col span={24}>{data.tips}</Col>
        </Row>
        <Typography.Link
          className={styles.detailLink}
          onClick={() => history.push(`/search/detail/${data.id}`)}
        >
          details
        </Typography.Link>
      </div>
    </div>
  )
}
export default ListItemCard;