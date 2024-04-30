class BarangWarisan extends BarangAntik {
    private String warisanDari;

    public BarangWarisan(String nama, int harga, int tahunPembuatan, String warisanDari) {
        super(nama, harga, tahunPembuatan);
        this.warisanDari = warisanDari;
    }

    // Konstruktor overloading
    public BarangWarisan(String nama, int tahunPembuatan, String warisanDari) {
        super(nama, 0, tahunPembuatan); // Harga default diatur ke 0
        this.warisanDari = warisanDari;
    }

    public String getWarisanDari() {
        return warisanDari;
    }

    public void setWarisanDari(String warisanDari) {
        this.warisanDari = warisanDari;
    }

    @Override
    public String toString() {
        return super.toString() + "Warisan dari: " + warisanDari + "\n";
    }

    @Override
    public String getNamaBarang() {
        return getNama();
    }

    @Override
    public String getDeskripsi() {
        return "Warisan dari: " + warisanDari;
    }

    @Override
    public void displayInfo() {
        System.out.println(super.toString() + "Warisan dari: " + warisanDari + "\n");
    }
}

