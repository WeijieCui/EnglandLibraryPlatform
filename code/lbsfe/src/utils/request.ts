import axios from "axios";

const request = axios.create({
    baseURL: '/api',
    timeout: 10000,
})
request.interceptors.request.use(config => {
    return config;
})
request.interceptors.response.use(response => {
    return response;
}, err=>{
    console.log("request error: ", err)
})
export default request