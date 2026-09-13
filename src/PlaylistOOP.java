/*
 * Group 3:
 * 1. HILMAN WASIANDI KHAIRURRIZAL - 2902817490
 * 2. CHRISTOFFER YOEL EVANDRI VIEBRIAN - 2902816336
 * 3. SULAIHA - 2902806442
 * 4. IRFAN SISWARA - 2902813126
 * 5. M. AKMAL ZULKARNAEN PRIADI - 2902826015
 */

import java.util.Scanner;

public class PlaylistOOP {

    // Menjalankan program dan menampilkan menu sesuai peran pengguna
    // Jika Admin bisa menambahkan lagu
    // jika user bisa melihat list lagu
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Membuat Scanner untuk membaca input dari keyboard agar bisa diketik dan interaktif
        Playlist playlist = new Playlist(5); //Membuat object Playlist dengan kapasitas awal 5 lagu
        Admin admin = new Admin("Admin Playlist"); // Membuat object Admin dengan nama "Admin Playlist"
        Member member = new Member("Pengguna Playlist");  // Membuat object Member dengan nama "Pengguna Playlist"

        int pilihan;
        do {
            System.out.println("\n========================================");
            System.out.println("       PROGRAM PLAYLIST MUSIK OOP");
            System.out.println("========================================");
            System.out.println("1. Masuk sebagai Admin");
            System.out.println("2. Masuk sebagai Member");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = bacaAngka(input);

            if (pilihan == 1) {
                menuAdmin(input, admin, playlist);
            } else if (pilihan == 2) {
                menuMember(input, member, playlist);
            } else if (pilihan != 0) { // kalo user memasukkan angka selain 0, 1, atau 2, muncul pilihan tidak tersedia
                System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);

        System.out.println("Program selesai.");
        input.close();
    }

    // Menampilkan menu Admin untuk menambah dan melihat daftar lagu.
    // Method ini menampilkan seluruh menu yang bisa digunakan Admin
    private static void menuAdmin(Scanner input, Admin admin, Playlist playlist) {
        int pilihan; // // Variabel untuk menyimpan pilihan menu Admin
        // Menu Admin akan terus diulang sampai user memilih 0
        do {
            System.out.println("\n=== MENU ADMIN ===");
            // Memanggil method dari object Admin
            // Digunakan untuk menampilkan hak akses Admin
            admin.tampilkanAkses();
            System.out.println("1. Tambah lagu");
            System.out.println("2. Lihat daftar lagu");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = bacaAngka(input);

            // Jika Admin memilih menu 1
            // admin harus input judul lagu, nama artis dan durasinya berapa menit
            if (pilihan == 1) {
                System.out.print("Judul lagu  : ");
                String judul = input.nextLine();
                System.out.print("Nama artis  : ");
                String artis = input.nextLine();
                System.out.print("Durasi (menit): ");
                // Membaca durasi menggunakan method bacaDesimal(), menggunakan double karena durasi bisa berupa angka desimal
                double durasi = bacaDesimal(input);

                // Admin menambahkan lagu baru ke dalam playlist
                admin.tambahLagu(playlist, new Lagu(judul, artis, durasi));
            } else if (pilihan == 2) {
                admin.lihatPlaylist(playlist);
            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    // Menampilkan menu Member untuk melihat, mencari, dan menghitung durasi lagu.
    // member bisa melihat playlist, mencari lagu, dan menghitung rata-rata durasi tetapi tidak untuk input lagu baru
    private static void menuMember(Scanner input, Member member, Playlist playlist) {
        int pilihan;   // Variabel untuk menyimpan pilihan menu Member
        do {
            System.out.println("\n=== MENU MEMBER ===");
            member.tampilkanAkses();
            System.out.println("1. Lihat daftar dan detail lagu");
            System.out.println("2. Cari lagu berdasarkan judul");
            System.out.println("3. Hitung rata-rata durasi");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = bacaAngka(input);

            if (pilihan == 1) {
                member.lihatPlaylist(playlist);
            } else if (pilihan == 2) {
                System.out.print("Masukkan judul yang dicari: ");
                String kataKunci = input.nextLine();
                member.cariLagu(playlist, kataKunci);
            } else if (pilihan == 3) {
                member.hitungRataRataDurasi(playlist);
            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    // Membaca bilangan bulat dan mencegah program berhenti saat input salah.
    // tujuannya supaya program tidak berhenti/error kalau user mengetik huruf
    private static int bacaAngka(Scanner input) {
        while (!input.hasNextInt()) {   // Selama input berikutnya bukan integer
            System.out.print("Input harus berupa angka. Masukkan kembali: "); // Memberi tahu user bahwa input salah
            input.nextLine();  // Membuang input yang salah misalnya si user mengetik "abc"
            
        }
        int angka = input.nextInt();
        input.nextLine();
        return angka;
    }

    // Membaca bilangan desimal positif untuk durasi lagu.
    // Dipakai saat user memasukkan durasi lagu 
    private static double bacaDesimal(Scanner input) {
        double angka;
        while (true) { // Loop berjalan terus sampai user memasukkan nilai yang valid
            if (input.hasNextDouble()) { // Mengecek apakah input berupa angka desimal
                angka = input.nextDouble(); // Membaca angka desimal
                input.nextLine();
                if (angka > 0) {
                    return angka;
                }
            } else {
                input.nextLine();
            }
            System.out.print("Durasi harus berupa angka positif. Masukkan kembali: "); // Pesan akan muncul jika input salah contohnya user salah mengetik : "abc", -5, atau 0
            
        }
    }
}
