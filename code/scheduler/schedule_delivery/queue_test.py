from queue import Queue


def test_queue():
    q = Queue()
    q.put(1)
    q.put(2)
    assert q.get() == 1
    assert q.get() == 2
    assert q.empty()


class MyQueue:
    def __init__(self):
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        return self.stack.pop(0)

    def peek(self) -> int:
        return self.stack[0]

    def empty(self) -> bool:
        return not self.stack


def test_myqueue():
    q = MyQueue()
    q.push(1)
    q.push(2)
    assert q.pop() == 1
    assert q.peek() == 2
    assert not q.empty()


if __name__ == '__main__':
    # test_queue()
    test_myqueue()
