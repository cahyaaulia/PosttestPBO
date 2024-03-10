import java.util.ArrayList;
import java.util.Scanner;

class BarangAntik {
    String nama;
    int tahunPembuatan;
    double harga;

    public BarangAntik(String nama, int tahunPembuatan, double harga) {
        this.nama = nama;
        this.tahunPembuatan = tahunPembuatan;
        this.harga = harga;
    }
}

public class BarangAntikMain {
    static ArrayList<BarangAntik> barangAntikList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n===== Menu Toko Barang Antik =====");
            System.out.println("1. Tambah Barang Antik");
            System.out.println("2. Tampilkan Semua Barang Antik");
            System.out.println("3. Update Barang Antik");
            System.out.println("4. Hapus Barang Antik");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            switch (choice) {
                case 1:
                    tambahBarangAntik();
                    break;
                case 2:
                    tampilkanBarangAntik();
                    break;
                case 3:
                    updateBarangAntik();
                    break;
                case 4:
                    hapusBarangAntik();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan program Toko Barang Antik. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    static void tambahBarangAntik() {
        System.out.print("\nMasukkan nama barang antik: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan tahun pembuatan barang antik: ");
        int tahunPembuatan = scanner.nextInt();
        System.out.print("Masukkan harga barang antik: ");
        double harga = scanner.nextDouble();

        BarangAntik barangAntik = new BarangAntik(nama, tahunPembuatan, harga);
        barangAntikList.add(barangAntik);

        System.out.println("Barang antik berhasil ditambahkan!");
    }

    static void tampilkanBarangAntik() {
        if (barangAntikList.isEmpty()) {
            System.out.println("\nTidak ada barang antik yang tersedia.");
            return;
        }

        System.out.println("\n===== Daftar Barang Antik =====");
        for (int i = 0; i < barangAntikList.size(); i++) {
            System.out.println("Barang Antik " + (i + 1) + ":");
            System.out.println("Nama: " + barangAntikList.get(i).nama);
            System.out.println("Tahun Pembuatan: " + barangAntikList.get(i).tahunPembuatan);
            System.out.println("Harga: " + barangAntikList.get(i).harga);
            System.out.println("---------------------------");
        }
    }

    static void updateBarangAntik() {
        if (barangAntikList.isEmpty()) {
            System.out.println("\nTidak ada barang antik yang tersedia untuk diperbarui.");
            return;
        }

        System.out.println("\n===== Update Barang Antik =====");
        tampilkanBarangAntik();
        System.out.print("Masukkan nomor barang antik yang ingin diperbarui: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consuming newline character
        if (index < 1 || index > barangAntikList.size()) {
            System.out.println("Nomor barang antik tidak valid.");
            return;
        }

        BarangAntik barangAntik = barangAntikList.get(index - 1);
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine();
        barangAntik.nama = namaBaru;
        System.out.print("Masukkan tahun pembuatan baru: ");
        int tahunBaru = scanner.nextInt();
        barangAntik.tahunPembuatan = tahunBaru;
        System.out.print("Masukkan harga baru: ");
        double hargaBaru = scanner.nextDouble();
        barangAntik.harga = hargaBaru;

        System.out.println("Barang antik berhasil diperbarui.");
    }

    static void hapusBarangAntik() {
        if (barangAntikList.isEmpty()) {
            System.out.println("\nTidak ada barang antik yang tersedia untuk dihapus.");
            return;
        }

        System.out.println("\n===== Hapus Barang Antik =====");
        tampilkanBarangAntik();
        System.out.print("Masukkan nomor barang antik yang ingin dihapus: ");
        int index = scanner.nextInt();
        if (index < 1 || index > barangAntikList.size()) {
            System.out.println("Nomor barang antik tidak valid.");
            return;
        }

        barangAntikList.remove(index - 1);
        System.out.println("Barang antik berhasil dihapus.");
    }
}
