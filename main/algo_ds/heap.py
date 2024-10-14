class MinHeap:
    def __init__(self):
        self.heap = []

    def parent(self, i):
        return (i - 1) // 2

    def left(self, i):
        return 2 * i + 1

    def right(self, i):
        return 2 * i + 2

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def heapify_up(self, i):
        while i != 0 and self.heap[self.parent(i)] > self.heap[i]:
            self.swap(i, self.parent(i))
            i = self.parent(i)

    def heapify_down(self, i):
        smallest = i
        left_child = self.left(i)
        right_child = self.right(i)

        if left_child < len(self.heap) and self.heap[left_child] < self.heap[smallest]:
            smallest = left_child

        if right_child < len(self.heap) and self.heap[right_child] < self.heap[smallest]:
            smallest = right_child

        if smallest != i:
            self.swap(i, smallest)
            self.heapify_down(smallest)

    def push(self, val):
        self.heap.append(val)
        self.heapify_up(len(self.heap) - 1)

    def pop(self):
        if len(self.heap) == 0:
            return None

        min_val = self.heap[0]
        last_element = self.heap.pop()

        if len(self.heap) > 0:
            self.heap[0] = last_element
            self.heapify_down(0)

        return min_val

    def peek(self):
        return self.heap[0] if self.heap else None

    def size(self):
        return len(self.heap)

    def is_empty(self):
        return len(self.heap) == 0

if __name__ == "__main__":
    # Example usage:
    heap = MinHeap()
    heap.push(3)
    heap.push(2)
    heap.push(1)
    print(heap.pop())  # Output: 1
    print(heap.peek())  # Output: 2
    print(heap.size())  # Output: 2
    print(heap.is_empty())  # Output: False
    print(heap.pop())  # Output: 2
    print(heap.pop())  # Output: 3
    print(heap.is_empty())  # Output: True
    print(heap.peek())  # Output: None
