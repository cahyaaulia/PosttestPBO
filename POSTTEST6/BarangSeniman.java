class BarangSeniman extends BarangAntik  {
    private String jenisSeni;

    public BarangSeniman(String nama, int harga, int tahunPembuatan, String jenisSeni) {
        super(nama, harga, tahunPembuatan);
        this.jenisSeni = jenisSeni;
    }

    // Konstruktor overloading
    public BarangSeniman(String nama, int tahunPembuatan, String jenisSeni) {
        super(nama, 0, tahunPembuatan); // Harga default diatur ke 0
        this.jenisSeni = jenisSeni;
    }

    public String getJenisSeni() {
        return jenisSeni;
    }

    public void setJenisSeni(String jenisSeni) {
        this.jenisSeni = jenisSeni;
    }

    @Override
    public String toString() {
        return super.toString() + "Jenis Seni: " + jenisSeni + "\n";
    }

    @Override
    public String getNamaBarang() {
        return getNama();
    }

    @Override
    public String getDeskripsi() {
        return "Jenis Seni: " + jenisSeni;
    }

    @Override
    public void displayInfo() {
        System.out.println(super.toString() + "Jenis Seni: " + jenisSeni + "\n");
    }
}

