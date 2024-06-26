import { defineConfig } from 'umi';

export default defineConfig({
  plugins: [
    '@umijs/plugins/dist/model'
  ],
  model: {},
  proxy: {
    "/api": {
      "target": "http://localhost:8080/lbs_backend",
      "changeOrigin": true,
      "pathRewrite": {},
    },
    "/image": {
      "target": "http://localhost:8080/lbs_backend",
      "changeOrigin": true,
      "pathRewrite": {},
    },
  },
  routes: [
    {
      path: '/',
      component: 'Home',
      rootPath: '/',
      title: 'Home',
    },
    {
      path: '/search',
      routes: [
        {
          path: '/search',
          component: 'Search',
          rootPath: '/search',
          title: 'Search',
        },
        {
          path: '/search/detail/:id',
          component: 'Search/Detail',
          rootPath: '/search',
          title: 'SearchDetail',
        }
      ]
    },
    {
      path: '/e-library',
      component: 'E-Library',
      rootPath: '/e-library',
      title: 'E-Library',
    },
    {
      path: '/furture',
      component: 'Furture',
      rootPath: '/furture',
      title: 'Furture',
    },
  ],
  npmClient: 'yarn',
});
