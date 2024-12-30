package array;

public class arrayT {
    // 1. 내부 배열 (정적 또는 동적 배열)
    private int[] array; // 배열 저장소
    private int size;    // 현재 배열에 저장된 요소 수

    public arrayT() {
        this.array =  new int[10];
        this.size = 0;

    }

    // 2. 생성자 (사용자 입력 받음)
    public arrayT(int initialCapacity) {
        // 배열 초기 크기 설정
        if(initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity must be >= 0");
        }
        this.array = new int[initialCapacity];
        this.size = 0;


    }
    public void expandArray() {
        int[] newArray = new int[array.length*2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;

    }

    // 3. 메서드
    // 1. 임의의 위치의 원소를 확인/변경
    public int get(int index) {
        /* 구현 */
        return array[index];
    }
    public void set(int index, int value) {
        /* 구현 */
        array[index] = value;

    }

    // 2. 원소를 끝에 추가
    public void append(int value) {
        /* 구현 */
        if (size == array.length) {
            expandArray();

        }
        array[size] = value;
        size++;
    }

    // 3. 마지막 원소 제거
    public void removeLast() {
        /* 구현 */
        if(size == 0 ) {
            throw new IllegalStateException("Array is empty");
        }
        array[size-1] = 0;
        size--;
    }

    // 4. 임의의 위치에 원소를 추가 (for 문 사용)
    public void insert(int index, int value) {
        /* 구현 */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if(size == array.length) {
            expandArray();
        }

        for(int i = size ; i>index ; i-- ) {
            array[i] = array[i-1];
        }
        array[index] = value;
        size++;
    }

    // 5. 임의의 위치에 원소 제거 왼쪾으로 가야해
    public void delete(int index) {
        /* 구현 */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        for(int i = index ; i<size-1 ; i++ ) {
            array[i] = array[i+1];
        }
        array[size-1] = 0;
        size--;

    }
    public int getSize() {
        return size;
    }
}


