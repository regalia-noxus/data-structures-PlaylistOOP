public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("     PROGRAM PLAYLIST MUSIK OOP");
        System.out.println("========================================");

        // Membuat playlist dengan kapasitas awal 2 lagu
        Playlist playlist = new Playlist(2);

        // Membuat objek Admin dan Member
        Admin admin = new Admin("Joe");
        Member member = new Member("Jane");

        // Menampilkan informasi user (inheritance dan polymorphism)
        System.out.println("\n=== INFORMASI USER ===");
        User[] daftarUser = {admin, member};
        for (User user : daftarUser) {
            user.tampilkanInfoUser();
            user.tampilkanAkses();
            System.out.println();
        }

        // Membuat objek Lagu
        Lagu lagu1 = new Lagu("We Don't Talk Anymore (feat. Selena Gomez)", "Charlie Puth", 3.62);
        Lagu lagu2 = new Lagu("A Thousand Years", "Christina Perri", 4.75);
        Lagu lagu3 = new Lagu("Payphone", "Maroon 5", 3.17);
        Lagu lagu4 = new Lagu("Maps", "Maroon 5", 3.57);

        // Admin menambahkan lagu ke playlist
        System.out.println("=== ADMIN MENAMBAHKAN LAGU ===");
        admin.tambahLagu(playlist, lagu1);
        admin.tambahLagu(playlist, lagu2);
        admin.tambahLagu(playlist, lagu3);
        admin.tambahLagu(playlist, lagu4);

        // Admin melihat seluruh playlist
        admin.lihatPlaylist(playlist);

        // Skenario Member: melihat playlist
        member.lihatPlaylist(playlist);

        // Member mencari lagu berdasarkan judul
        member.cariLagu(playlist, "we don't");

        // Member menghitung rata-rata durasi
        member.hitungRataRataDurasi(playlist);
    }
}