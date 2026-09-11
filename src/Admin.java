// Subclass khusus role Admin
public class Admin extends User {

    public Admin(String nama) {
        super(nama, "Admin");
    }

    // Tampilkan hak akses yang dimiliki admin
    @Override
    public void tampilkanAkses() {
        System.out.println("[Hak Akses Admin] " + getNama() + " dapat: Menambahkan lagu baru ke playlist & melihat seluruh daftar lagu.");
    }

    // Method untuk menambahkan objek lagu baru ke dalam playlist
    public void tambahLagu(Playlist playlist, Lagu laguBaru) {
        if (playlist == null || laguBaru == null) {
            System.out.println("Gagal menambahkan lagu: Data playlist atau lagu tidak valid.");
            return;
        }
        playlist.tambahLagu(laguBaru);
        System.out.println("Admin " + getNama() + " berhasil menambahkan lagu: '" + laguBaru.getJudul() + "' oleh " + laguBaru.getArtis());
    }

    // Menampilkan seluruh lagu yang ada di playlist
    public void lihatPlaylist(Playlist playlist) {
        if (playlist == null) {
            System.out.println("Playlist tidak ditemukan.");
            return;
        }
        System.out.println("\n=== DAFTAR LAGU (Dilihat oleh Admin: " + getNama() + ") ===");
        playlist.tampilkanDaftarLagu();
    }
}
