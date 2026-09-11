// Parent class untuk menyimpan data dasar pengguna
public abstract class User {
    private String nama;
    private String peran;

    public User(String nama, String peran) {
        this.nama = nama;
        this.peran = peran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = peran;
    }

    // Tampilkan informasi singkat user
    public void tampilkanInfoUser() {
        System.out.println("Nama: " + nama + " | Peran: " + peran);
    }

    // Method abstract untuk dioverride oleh subclass sesuai hak akses masing-masing
    public abstract void tampilkanAkses();
}
