import {  Layout as AntdLayout, Tabs } from 'antd';
import { Link, Outlet, useRouteProps } from 'umi';
import { useTitle } from 'ahooks'

const { Header } = AntdLayout;

export default function Layout() {
  const currentRouteProps = useRouteProps();
  useTitle(currentRouteProps.title);
  
  return (
    <AntdLayout>
      <Header style={{ display: 'flex', alignItems: 'center', color: '#fff' }} >
        England Libraries
      </Header>
      <Tabs
        centered
        activeKey={currentRouteProps.rootPath}
        items={[
          {
            key: '/',
            label: <Link to="/">Home</Link>
          },
          {
            key: '/search',
            label: <Link to="/search">Search</Link>
          },
          {
            key: '/e-library',
            label: <Link to="/e-library">E-Library</Link>
          },
          {
            key: '/furture',
            label: <Link to="/furture">Furture</Link>
          },
        ]}
      />
      <Outlet />
    </AntdLayout>
  );
}
