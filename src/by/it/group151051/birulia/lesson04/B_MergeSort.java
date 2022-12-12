package by.it.group151051.birulia.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Реализуйте сортировку слиянием для одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо отсортировать полученный массив.

Sample Input:
5
2 3 9 2 9
Sample Output:
2 2 3 9 9
*/
public class B_MergeSort {

    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер массива
        int n = scanner.nextInt();
        //сам массив
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            System.out.println(a[i]);
        }

        // тут ваше решение (реализуйте сортировку слиянием)
        // https://ru.wikipedia.org/wiki/Сортировка_слиянием


        class MergeSort {
            static int[] mergeSort(int[] src, int n) {
                if (n < 2) return src;

                int mid = n / 2;
                int[] left = new int[mid];
                int[] right = new int[n - mid];

                System.arraycopy(src, 0, left, 0, mid);
                System.arraycopy(src, mid, right, 0, n - mid);

                mergeSort(left, mid);
                mergeSort(right, n - mid);

                return merge(src, left, right, mid, n - mid);
            }

            static int[] merge(int[] src, int[] left, int[] right, int leftLength, int rightLength) {
                int k = 0, i = 0, j = 0;

                while (i < leftLength && j < rightLength) {
                    if (left[i] <= right[j]) src[k++] = left[i++];
                    else src[k++] = right[j++];
                }

                while (i < leftLength) {
                    src[k++] = left[i++];
                }

                while (j < rightLength) {
                    src[k++] = right[j++];
                }

                return src;
            }
        }

        MergeSort.mergeSort(a, n);







        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return a;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }


}
