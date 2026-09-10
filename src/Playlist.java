public class Playlist {
    //private access modifier: only accessible within the declared class itself
    private Lagu[] lagu;
    private int totalLagu;

    //kapasitasAwal: initial number of slots in the array
    public Playlist(int kapasitasAwal) {
        if (kapasitasAwal <= 0) {
            throw new IllegalArgumentException("Kapasitas harus lebih besar dari 0.");
        }
        lagu = new Lagu[kapasitasAwal];
        totalLagu = 0;
    }

    //laguBaru: insert new Lagu into array
    public void tambahLagu(Lagu newLagu) {
        if (newLagu == null) {
            throw new IllegalArgumentException("Lagu yang ditambahkan tidak boleh null.");
        }
        if (totalLagu == lagu.length) {
            increaseCapacity();
        }
        lagu[totalLagu] = newLagu;
        totalLagu++;
    }

    //Doubling the array capacity and copying all existing data
    private void increaseCapacity() {
        Lagu[] newArray = new Lagu[lagu.length * 2];
        for (int i = 0; i < lagu.length; i++) {
            newArray[i] = lagu[i];
        }
        lagu = newArray;
    }

    //Displays all stored lagu in sequence
    public void tampilkanDaftarLagu() {
        if (totalLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }
        for (int i = 0; i < totalLagu; i++) {
            System.out.printf("%d. ", i + 1);
            lagu[i].tampilkanInfo();
        }
    }

    //search for lagu by title (case insensitive)
    //search supports partial words
    //keyword search term in the title
    //returns an array containing the search results or empty array if not found
    public Lagu[] cariBerdasarkanJudul(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new Lagu[0];
        }
        String word = keyword.trim().toLowerCase();
        int totalResult = 0;
        //calculate the number of results to ensure the correct array size
        for (int i = 0; i < totalLagu; i++) {
            if (lagu[i].getJudul().toLowerCase().contains(word)) {
                totalResult++;
            }
        }
        //populate the search results array
        Lagu[] result = new Lagu[totalResult];
        int index = 0;
        for (int i = 0; i < totalLagu; i++) {
            if (lagu[i].getJudul().toLowerCase().contains(word)) {
                result[index] = lagu[i];
                index++;
            }
        }
        return result;
    }

    //returns the average duration in minutes, or 0 if the playlist is empty
    public double calculateAverageDuration() {
        if (totalLagu == 0) {
            return 0.0;
        }
        double totalDuration = 0.0;
        for (int i = 0; i < totalLagu; i++) {
            totalDuration += lagu[i].getDurasi();
        }
        return totalDuration / totalLagu;
    }

    //return the number of lagu currently stored
    public int getTotalLagu() {
        return totalLagu;
    }

    //return the current capacity of the playlist array
    public int getCapacity() {
        return lagu.length;
    }
}