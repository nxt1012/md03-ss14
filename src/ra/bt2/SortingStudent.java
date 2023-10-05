package ra.bt2;

import java.util.Arrays;

public class SortingStudent {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }

        students[0].inputData(1, "Nguyễn Xuân Thành", 8.0);
        students[1].inputData(2, "Trịnh Xuân Thanh", 7.0);
        students[2].inputData(3, "Hoàng Xuân Hiển", 6.0);

        System.out.println(Arrays.toString(students));

//        bubbleSort(students);
//        selectionSort(students);
        insertionSort(students);
        System.out.println(Arrays.toString(students));
    }

    public static void bubbleSort(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getScore() > students[j].getScore()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            int indexOfMin = i;
//            Tìm ra index của số có giá trị nhỏ nhất trong mảng chưa được sắp xếp
            for (int j = i + 1; j < students.length; j++) {
                if (students[indexOfMin].getScore() > students[j].getScore()) {
                    indexOfMin = j;
                }
            }
//             Đảo vị trí của số có giá trị nhỏ nhất trong mảng chưa được sắp xếp với vị trí xuất phát i
            Student temp = students[indexOfMin];
            students[indexOfMin] = students[i];
            students[i] = temp;
        }
    }

    public static void insertionSort(Student[] students) {
//        phần từ đầu tiên ở bên trái được coi là đã sắp thứ tự => chỉ duyệt mảng với các phần tử
        for (int i = 1; i < students.length; i++) {
            Student insertElement = students[i];
            int j = i - 1; // chạy vòng lặp để kiểm tra tất các phần tử từ vị trí j đến 0, mục đích là xem insertElement có thể được nhét vào vị trí nào trong số các phần tử này là phù hợp nhất
//        trong quá trình này, nếu như xuất hiện phần tử có giá trị lớn hơn insertElement thì
            while (j >= 0 && students[j].getScore() > insertElement.getScore()) {
//                gán giá trị của phần tử trước vào phần tử sau
                students[j + 1] = students[j];
//                lùi lại chỉ số 1 bước
                j = j - 1;
            }
//            kết quả của quá trình này là mảng đang xét sẽ lùi ra sau 1 bước và trống ra 1 chỗ để có thể đưa insertElement vào
//            chèn insertElement vào vị trí đã để trống ra
            students[j + 1] = insertElement;
        }
    }
}
