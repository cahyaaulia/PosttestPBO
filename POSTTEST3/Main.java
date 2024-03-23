import java.util.ArrayList;
import java.util.Scanner;

class BarangAntik {
    private static int count = 0;
    private int id;
    private String nama;
    private int harga;
    private int tahunPembuatan;

    public BarangAntik(String nama, int harga, int tahunPembuatan) {
        this.id = ++count;
        this.nama = nama;
        this.harga = harga;
        this.tahunPembuatan = tahunPembuatan;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getTahunPembuatan() {
        return tahunPembuatan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setTahunPembuatan(int tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }
}

class BarangWarisan extends BarangAntik {
    private String warisanDari;

    public BarangWarisan(String nama, int harga, int tahunPembuatan, String warisanDari) {
        super(nama, harga, tahunPembuatan);
        this.warisanDari = warisanDari;
    }

    public String getWarisanDari() {
        return warisanDari;
    }

    public void setWarisanDari(String warisanDari) {
        this.warisanDari = warisanDari;
    }
}

class BarangSeniman extends BarangAntik {
    private String jenisSeni;

    public BarangSeniman(String nama, int harga, int tahunPembuatan, String jenisSeni) {
        super(nama, harga, tahunPembuatan);
        this.jenisSeni = jenisSeni;
    }

    public String getJenisSeni() {
        return jenisSeni;
    }

    public void setJenisSeni(String jenisSeni) {
        this.jenisSeni = jenisSeni;
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
            scanner.nextLine();

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
        System.out.println("=================================");
        System.out.println("| Sistem Pendataan Barang Antik |");
        System.out.println("=================================");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Tampilkan Semua Barang");
        System.out.println("3. Update Barang");
        System.out.println("4. Hapus Barang");
        System.out.println("5. Exit");
        System.out.println("=================================");
        System.out.print("Pilih menu: ");
    }

    private static void tambahBarang() {
        System.out.println("===============================================");
        System.out.println("| Pilih jenis barang yang ingin ditambahkan : |");
        System.out.println("===============================================");
        System.out.println("1. Barang Warisan");
        System.out.println("2. Barang Seniman");
        System.out.println("===============================================");
        System.out.print("Pilihan : ");
        int jenisBarang = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nama barang : ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan harga barang : ");
        int harga = scanner.nextInt();

        System.out.print("Masukkan tahun pembuatan barang : ");
        int tahunPembuatan = scanner.nextInt();
        scanner.nextLine();

        if (jenisBarang == 1) {
            System.out.print("Masukkan informasi warisan : ");
            String warisan = scanner.nextLine();
            BarangWarisan barang = new BarangWarisan(nama, harga, tahunPembuatan, warisan);
            daftarBarang.add(barang);
        } else if (jenisBarang == 2) {
            System.out.print("Masukkan informasi seniman : ");
            String seniman = scanner.nextLine();
            BarangSeniman barang = new BarangSeniman(nama, harga, tahunPembuatan, seniman);
            daftarBarang.add(barang);
        } else {
            System.out.println("---Jenis barang tidak valid---");
        }
        System.out.println("--- Barang berhasil ditambahkan ---\n");

    }

    private static void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("--- Belum ada barang yang didata ---\n");
        } else {
            System.out.println("--- Daftar Barang ---");
            for (BarangAntik barang : daftarBarang) {
                System.out.println(barang);
            }
        }
    }

    private static void updateBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("--- Belum ada barang yang didata ---\n");
            return;
        }

        System.out.print("Masukkan ID barang yang ingin diupdate : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // untuk mengonsumsi newline

        BarangAntik barangToUpdate = null;
        for (BarangAntik barang : daftarBarang) {
            if (barang.getId() == id) {
                barangToUpdate = barang;
                break;
            }
        }

        if (barangToUpdate == null) {
            System.out.println("--- Barang dengan ID tersebut tidak ditemukan ---\n");
        } else {
            System.out.print("Masukkan nama baru : ");
            String namaBaru = scanner.nextLine();
            barangToUpdate.setNama(namaBaru);

            System.out.print("Masukkan harga baru : ");
            int hargaBaru = scanner.nextInt();
            scanner.nextLine();
            barangToUpdate.setHarga(hargaBaru);
            
            System.out.print("Masukkan tahun pembuatan baru : ");
            int tahunPembuatanBaru = scanner.nextInt();
            scanner.nextLine();
            barangToUpdate.setTahunPembuatan(tahunPembuatanBaru);

            System.out.println("--- Barang berhasil diupdate ---\n");
        }
    }

    private static void hapusBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("--- Belum ada barang yang didata ---\n");
            return;
        }

        System.out.print("Masukkan ID barang yang ingin dihapus : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        BarangAntik barangToDelete = null;
        for (BarangAntik barang : daftarBarang) {
            if (barang.getId() == id) {
                barangToDelete = barang;
                break;
            }
        }

        if (barangToDelete == null) {
            System.out.println("--- Barang dengan ID tersebut tidak ditemukan ---\n");
        } else {
            daftarBarang.remove(barangToDelete);
            System.out.println("--- Barang berhasil dihapus ---\n");
        }
    }
}