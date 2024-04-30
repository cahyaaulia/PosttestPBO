abstract class BarangAntik implements Barang  {
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

    @Override
    public String toString() {
        return "ID: " + id + "\n"
                + "Nama: " + nama + "\n"
                + "Harga: " + harga + "\n"
                + "Tahun Pembuatan: " + tahunPembuatan + "\n";
    }

    @Override
    public abstract String getNamaBarang();

    @Override
    public abstract String getDeskripsi();
    
    public abstract void displayInfo();
}
