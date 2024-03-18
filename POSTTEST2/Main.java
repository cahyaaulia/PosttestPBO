import java.util.ArrayList;
import java.util.Scanner;

class BarangAntik {
    private int harga;
    private String nama;
    private int tahunPembuatan;

    public BarangAntik(int harga, String nama, int tahunPembuatan) {
        this.harga = harga;
        this.nama = nama;
        this.tahunPembuatan = tahunPembuatan;
    }

    public int getHarga() {
        return harga;
    }

    public String getNama() {
        return nama;
    }

    public int getTahunPembuatan() {
        return tahunPembuatan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTahunPembuatan(int tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }

    @Override
    public String toString() {
        return "Harga: " + harga + ", Nama: " + nama + ", Tahun Pembuatan: " + tahunPembuatan;
    }
}

public class Main {
    private static ArrayList<BarangAntik> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan = -1;

        while (pilihan != 5) {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine(); // untuk mengonsumsi newline

            switch (pilihan) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    tampilkanSemuaBarang();
                    break;
                case 3:
                    updateBarang();
                    break;
                case 4:
                    hapusBarang();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
                    break;
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("=== Sistem Pendataan Barang Antik ===");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Tampilkan Semua Barang");
        System.out.println("3. Update Barang");
        System.out.println("4. Hapus Barang");
        System.out.println("5. Exit");
        System.out.print("Pilih menu: ");
    }

    private static void tambahBarang() {
        System.out.print("Masukkan harga barang: ");
        int harga = scanner.nextInt();
        scanner.nextLine(); // untuk mengonsumsi newline

        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan tahun pembuatan barang: ");
        int tahunPembuatan = scanner.nextInt();
        scanner.nextLine(); // untuk mengonsumsi newline

        BarangAntik barang = new BarangAntik(harga, nama, tahunPembuatan);
        daftarBarang.add(barang);
        System.out.println("Barang berhasil ditambahkan.");
    }

    private static void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang yang didata.");
        } else {
            System.out.println("Daftar Barang:");
            for (BarangAntik barang : daftarBarang) {
                System.out.println(barang);
            }
        }
    }

    private static void updateBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang yang didata.");
            return;
        }

        System.out.print("Masukkan harga barang yang ingin diupdate: ");
        int harga = scanner.nextInt();
        scanner.nextLine(); // untuk mengonsumsi newline

        BarangAntik barangToUpdate = null;
        for (BarangAntik barang : daftarBarang) {
            if (barang.getHarga() == harga) {
                barangToUpdate = barang;
                break;
            }
        }

        if (barangToUpdate == null) {
            System.out.println("Barang dengan harga tersebut tidak ditemukan.");
        } else {
            System.out.print("Masukkan nama baru: ");
            String namaBaru = scanner.nextLine();
            barangToUpdate.setNama(namaBaru);

            System.out.print("Masukkan tahun pembuatan baru: ");
            int tahunPembuatanBaru = scanner.nextInt();
            scanner.nextLine(); // untuk mengonsumsi newline
            barangToUpdate.setTahunPembuatan(tahunPembuatanBaru);

            System.out.println("Barang berhasil diupdate.");
        }
    }

    private static void hapusBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang yang didata.");
            return;
        }

        System.out.print("Masukkan harga barang yang ingin dihapus: ");
        int harga = scanner.nextInt();
        scanner.nextLine(); // untuk mengonsumsi newline

        BarangAntik barangToDelete = null;
        for (BarangAntik barang : daftarBarang) {
            if (barang.getHarga() == harga) {
                barangToDelete = barang;
                break;
            }
        }

        if (barangToDelete == null) {
            System.out.println("Barang dengan harga tersebut tidak ditemukan.");
        } else {
            daftarBarang.remove(barangToDelete);
            System.out.println("Barang berhasil dihapus.");
        }
    }
}
