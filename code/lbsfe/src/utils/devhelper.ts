/** 异步等待时间 */
export const ASYNC_SLEEP_TIME = 500

/** 异步等待，模拟接口调用 */
export const asyncSleep = () => {
  return new Promise<void>(res => {
    setTimeout(() => {
      res();
    }, ASYNC_SLEEP_TIME)
  })
}