package array;

public class arrayTTest {
    public static void main(String[] args) {
        // 1. array.arrayT 인스턴스 생성 (초기 용량 5)
        arrayT arr = new arrayT(5);

        System.out.println("[1] 초기 상태 (size=0)");
        printArray(arr);

        // 2. append() 테스트
        arr.append(10);
        arr.append(20);
        arr.append(30);
        System.out.println("[2] append(10, 20, 30) 호출 후");
        printArray(arr);

        // 3. set() 테스트
        arr.set(1, 99);  // index=1 위치의 원소를 99로 변경
        System.out.println("[3] set(1, 99) 호출 후");
        printArray(arr);

        // 4. get() 테스트
        System.out.println("[4] get(1) 결과: " + arr.get(1));  // 99인지 확인

        // 5. insert() 테스트
        arr.insert(1, 50);  // index=1 위치에 50 삽입
        System.out.println("[5] insert(1, 50) 호출 후");
        printArray(arr);

        // 6. delete() 테스트
        arr.delete(2);  // index=2 위치 원소를 삭제
        // (방금 삽입한 50 다음 원소(옛 99)가 삭제되는지 확인)
        System.out.println("[6] delete(2) 호출 후");
        printArray(arr);

        // 7. removeLast() 테스트
        arr.removeLast(); // 마지막 원소 제거
        System.out.println("[7] removeLast() 호출 후");
        printArray(arr);

        // 8. 배열 확장 테스트 (capacity=5였으니, 5개를 넘겨서 append)
        arr.append(40);
        arr.append(50);
        arr.append(60);
        arr.append(70); // 여기서 배열이 확장될 것(동적 배열)
        System.out.println("[8] append(40, 50, 60, 70) -> 배열 확장 확인");
        printArray(arr);

        // 9. 예외 상황 테스트 (IndexOutOfBoundsException)
        try {
            arr.insert(-1, 999); // 유효하지 않은 인덱스
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[9] 예외 발생 (insert(-1, 999)): " + e.getMessage());
        }

        try {
            arr.delete(100); // 유효하지 않은 인덱스
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[9] 예외 발생 (delete(100)): " + e.getMessage());
        }
    }

    private static void printArray(arrayT arr) {
        // getSize() 메서드가 있다고 가정하고 size를 받아옴
        int currentSize = arr.getSize();
        // 현재 질문에서는 getSize() 메서드가 구현되지 않았을 수도 있으니,
        // 다음과 같은 방식으로 size 필드가 있다고 가정할 수도 있습니다.
        // 만약 array.arrayT 클래스에 public int getSize()가 없다면 직접 추가해주세요!

        // ---------------------------------------------
        // 임시로 reflection 등을 쓰는 대신, 다음처럼 size 필드가 public이라고
        // 가정하고 접근할 수도 있지만, 보통 getSize() 메서드를 구현해서 쓰는 편입니다.
        // ---------------------------------------------
        try {
            java.lang.reflect.Field sizeField = arr.getClass().getDeclaredField("size");
            sizeField.setAccessible(true);
            currentSize = (int) sizeField.get(arr);
        } catch (Exception e) {
            // 리플렉션 예외는 무시 (데모 용도)
        }

        System.out.print("array.arrayT: [ ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("] (size=" + currentSize + ")");
    }



}
