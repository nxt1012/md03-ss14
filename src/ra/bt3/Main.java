package ra.bt3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"banana", "apple", "orange", "grape", "pear"};
        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);
        System.out.println("Mảng sau khi đã sắp xếp:");
        System.out.println(Arrays.toString(arr));

    }
    private static void bubbleSort(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    private static void selectionSort(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfMin = i;
//            Tìm ra index của số có giá trị nhỏ nhất trong mảng chưa được sắp xếp
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[indexOfMin].compareTo(arr[j]) > 0) {
                    indexOfMin = j;
                }
            }
//             Đảo vị trí của số có giá trị nhỏ nhất trong mảng chưa được sắp xếp với vị trí xuất phát i
            String temp = arr[indexOfMin];
            arr[indexOfMin] = arr[i];
            arr[i] = temp;
        }
    }

    private static void insertionSort(String[] arr) {
//        phần từ đầu tiên ở bên trái được coi là đã sắp thứ tự => chỉ duyệt mảng với các phần tử
        for (int i = 1; i < arr.length; i++) {
            String insertElement = arr[i];
            int j = i - 1; // chạy vòng lặp để kiểm tra tất các phần tử từ vị trí j đến 0, mục đích là xem insertElement có thể được nhét vào vị trí nào trong số các phần tử này là phù hợp nhất
//        trong quá trình này, nếu như xuất hiện phần tử có giá trị lớn hơn insertElement thì
            while (j >= 0 && arr[j].compareTo(insertElement) > 0) {
//                gán giá trị của phần tử trước vào phần tử sau
                arr[j + 1] = arr[j];
//                lùi lại chỉ số 1 bước
                j = j - 1;
            }
//            kết quả của quá trình này là mảng đang xét sẽ lùi ra sau 1 bước và trống ra 1 chỗ để có thể đưa insertElement vào
//            chèn insertElement vào vị trí đã để trống ra
            arr[j + 1] = insertElement;
        }
    }
}
