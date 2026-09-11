// Subclass untuk pengguna biasa (Member)
public class Member extends User {

    public Member(String nama) {
        super(nama, "Member");
    }

    // Tampilkan hak akses yang dimiliki member
    @Override
    public void tampilkanAkses() {
        System.out.println("[Hak Akses Member] " + getNama() + " dapat: Melihat playlist, mencari lagu berdasarkan judul, dan menghitung rata-rata durasi lagu.");
    }

    // Menampilkan daftar lagu yang tersedia di playlist
    public void lihatPlaylist(Playlist playlist) {
        if (playlist == null) {
            System.out.println("Playlist tidak ditemukan.");
            return;
        }
        System.out.println("\n=== DAFTAR LAGU PLAYLIST (Dilihat oleh Member: " + getNama() + ") ===");
        playlist.tampilkanDaftarLagu();
    }

    // Cari lagu di playlist berdasarkan kata kunci judul
    public void cariLagu(Playlist playlist, String kataKunci) {
        if (playlist == null) {
            System.out.println("Playlist tidak ditemukan.");
            return;
        }
        System.out.println("\n--- Hasil Pencarian Lagu dengan Kata Kunci: '" + kataKunci + "' (Oleh: " + getNama() + ") ---");
        Lagu[] hasil = playlist.cariBerdasarkanJudul(kataKunci);
        if (hasil.length == 0) {
            System.out.println("Lagu dengan judul mengandung '" + kataKunci + "' tidak ditemukan.");
        } else {
            System.out.println("Ditemukan " + hasil.length + " lagu:");
            for (int i = 0; i < hasil.length; i++) {
                System.out.printf("%d. ", i + 1);
                hasil[i].tampilkanInfo();
            }
        }
    }

    // Hitung rata-rata durasi seluruh lagu yang ada di playlist
    public void hitungRataRataDurasi(Playlist playlist) {
        if (playlist == null) {
            System.out.println("Playlist tidak ditemukan.");
            return;
        }
        if (playlist.getTotalLagu() == 0) {
            System.out.println("[Info Playlist] Playlist masih kosong, belum ada lagu untuk dihitung rata-rata durasinya.");
            return;
        }
        double rataRata = playlist.calculateAverageDuration();
        System.out.printf("\n[Info Playlist] Rata-rata durasi lagu dalam playlist: %.2f menit (Dihitung oleh: %s)\n", rataRata, getNama());
    }
}
