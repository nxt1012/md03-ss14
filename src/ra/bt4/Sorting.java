package ra.bt4;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        FootballTeam[] footballTeam = new FootballTeam[3];
        for (int i = 0; i < footballTeam.length; i++) {
            footballTeam[i] = new FootballTeam();
        }
        footballTeam[0].inputData(1, "ACB Hà Nội", 20, 50);
        footballTeam[1].inputData(2, "Thể Công", 25, 40);
        footballTeam[2].inputData(3, "SL Nghệ An", 30, 30);
        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString((footballTeam)));
//        bubbleSort(footballTeam);
        selectionSort(footballTeam);
//        insertionSort(footballTeam);
        System.out.println(Arrays.toString((footballTeam)));
    }
    public static void bubbleSort(FootballTeam[] footballTeam) {
        for (int i = 0; i < footballTeam.length - 1; i++) {
            for (int j = i + 1; j < footballTeam.length; j++) {
                if (footballTeam[i].getScore() > footballTeam[j].getScore()) {
                    FootballTeam temp = footballTeam[i];
                    footballTeam[i] = footballTeam[j];
                    footballTeam[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(FootballTeam[] footballTeam) {
        for (int i = 0; i < footballTeam.length - 1; i++) {
            int indexOfMin = i;
//            Tìm ra index của số có giá trị nhỏ nhất trong mảng chưa được sắp xếp
            for (int j = i + 1; j < footballTeam.length; j++) {
                if (footballTeam[indexOfMin].getScore() > footballTeam[j].getScore()) {
                    indexOfMin = j;
                }
            }
//             Đảo vị trí của số có giá trị nhỏ nhất trong mảng chưa được sắp xếp với vị trí xuất phát i
            FootballTeam temp = footballTeam[indexOfMin];
            footballTeam[indexOfMin] = footballTeam[i];
            footballTeam[i] = temp;
        }
    }

    public static void insertionSort(FootballTeam[] footballTeam) {
//        phần từ đầu tiên ở bên trái được coi là đã sắp thứ tự => chỉ duyệt mảng với các phần tử
        for (int i = 1; i < footballTeam.length; i++) {
            FootballTeam insertElement = footballTeam[i];
            int j = i - 1; // chạy vòng lặp để kiểm tra tất các phần tử từ vị trí j đến 0, mục đích là xem insertElement có thể được nhét vào vị trí nào trong số các phần tử này là phù hợp nhất
//        trong quá trình này, nếu như xuất hiện phần tử có giá trị lớn hơn insertElement thì
            while (j >= 0 && footballTeam[j].getScore() > insertElement.getScore()) {
//                gán giá trị của phần tử trước vào phần tử sau
                footballTeam[j + 1] = footballTeam[j];
//                lùi lại chỉ số 1 bước
                j = j - 1;
            }
//            kết quả của quá trình này là mảng đang xét sẽ lùi ra sau 1 bước và trống ra 1 chỗ để có thể đưa insertElement vào
//            chèn insertElement vào vị trí đã để trống ra
            footballTeam[j + 1] = insertElement;
        }
    }
}
