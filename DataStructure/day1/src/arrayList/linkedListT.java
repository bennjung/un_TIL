package arrayList;

public class linkedListT {
    // Node 클래스 (linkedList의 구성 요소)
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList의 첫 번째 노드
    private Node head;
    private int size;

    // 생성자
    public linkedListT() {
        this.head = null;
        this.size = 0;
    }

    // 1. 리스트의 크기를 반환
    public int size() {
        return size;
    }

    // 2. 리스트가 비어 있는지 확인
    public boolean isEmpty() {
        return head == null;
    }

    // 3. 리스트의 마지막에 데이터 추가
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // 빈 리스트 처리
            /* 빈칸 */
        } else {
            // 마지막 노드 찾기
            Node current = head;
            while (/* 빈칸 */) {
                current = current.next;
            }
            /* 빈칸 */
        }
        size++;
    }

    // 4. 리스트의 처음에 데이터 추가
    public void addFirst(int data) {
        Node newNode = new Node(data);
        /* 빈칸 */
        size++;
    }

    // 5. 특정 위치에 데이터 삽입
    public void add(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (index == 0) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                /* 빈칸 */
            }
            /* 빈칸 */
            size++;
        }
    }

    // 6. 특정 위치의 데이터 삭제
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (index == 0) {
            head = /* 빈칸 */;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                /* 빈칸 */
            }
            current.next = /* 빈칸 */;
        }
        size--;
    }

    // 7. 리스트의 모든 요소 출력
    public void printList() {
        Node current = head;
        while (/* 빈칸 */) {
            System.out.print(current.data + " ");
            current = /* 빈칸 */;
        }
        System.out.println();
    }
}
