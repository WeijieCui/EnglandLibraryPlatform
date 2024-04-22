import { Row, Col, Typography } from 'antd';
import { history } from 'umi';

import { SearchListItemProps } from '@/types/search';

import styles from './index.less';

const ListItemCard = (props: { data: SearchListItemProps }) => {
  const { data } = props;

  return (
    <div className={styles.listItemCard}>
      <img className={styles.img} src={data.image}  alt={data.title}/>
      <div className={styles.detail}>
        <h1>{data.title}</h1>
        <Row gutter={16}>
          <Col span={24}>{data.summary}</Col>
          <Col span={12}>Publisher: {data.publisher}</Col>
          <Col span={12}>Published: {data.publishedDate}</Col>
          <Col span={12}>ISBN: {data.isbn}</Col>
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