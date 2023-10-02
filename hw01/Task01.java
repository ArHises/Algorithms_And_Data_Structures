package hw01;

public class Task01 {
    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализация наибольшего элемента как корня
        int leftChild = 2 * i + 1; // Левый потомок
        int rightChild = 2 * i + 2; // Правый потомок

        // Если левый потомок больше корня
        if (leftChild < n && arr[leftChild] > arr[largest])
            largest = leftChild;

        // Если правый потомок больше, чем наибольший элемент на данный момент
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;

        // Если наибольший элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно обрабатываем поддерево
            heapify(arr, n, largest);
        }
    }

    // Функция для вывода массива
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        System.out.println("Исходный массив:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Отсортированный массив:");
        printArray(arr);
    }
}
