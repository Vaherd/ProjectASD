import java.io.*;
import java.util.Scanner;

public class SortingApp {

    // Metode Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Tukar arr[j] dan arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Metode Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Tukar elemen arr[i] dan arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Metode untuk menampilkan array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Metode untuk menulis hasil ke file
    public static void writeFile(int[] arr, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < arr.length; i++) {
                writer.write(arr[i] + " ");
            }
            writer.newLine();
            System.out.println("Hasil sorting telah disimpan di file: " + filename);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis ke file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;
        
        while (true) {
            // Menu utama
            System.out.println("=== Aplikasi Sorting ===");
            System.out.println("1. Masukkan data");
            System.out.println("2. Pilih metode sorting");
            System.out.println("3. Tampilkan hasil");
            System.out.println("4. Simpan hasil ke file");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Input data
                    System.out.print("Masukkan jumlah elemen: ");
                    int n = scanner.nextInt();
                    arr = new int[n];
                    System.out.println("Masukkan " + n + " angka:");
                    for (int i = 0; i < n; i++) {
                        arr[i] = scanner.nextInt();
                    }
                    break;
                    
                case 2:
                    // Pilih metode sorting
                    if (arr == null) {
                        System.out.println("Data belum dimasukkan!");
                        break;
                    }
                    System.out.println("Pilih metode sorting:");
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Selection Sort");
                    System.out.print("Pilih metode (1/2): ");
                    int method = scanner.nextInt();
                    
                    if (method == 1) {
                        bubbleSort(arr.clone());
                        System.out.println("Bubble Sort selesai.");
                    } else if (method == 2) {
                        selectionSort(arr.clone());
                        System.out.println("Selection Sort selesai.");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;
                    
                case 3:
                    // Tampilkan hasil
                    if (arr != null) {
                        System.out.println("Array yang telah diurutkan:");
                        printArray(arr);
                    } else {
                        System.out.println("Data belum dimasukkan!");
                    }
                    break;
                    
                case 4:
                    // Simpan hasil ke file
                    if (arr == null) {
                        System.out.println("Data belum dimasukkan!");
                    } else {
                        System.out.print("Masukkan nama file untuk menyimpan hasil: ");
                        String filename = scanner.next();
                        writeFile(arr, filename);
                    }
                    break;
                    
                case 5:
                    // Keluar dari aplikasi
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}
