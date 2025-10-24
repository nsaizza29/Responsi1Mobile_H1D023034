# Responsi 1 Pemograman Mobile

## Identitas
- Nama        : Nisa Izzatul Ummah
- NIM         : H1D023034
- Shift Baru  : D
- Shift Lama  : C

## Demo Aplikasi
https://github.com/user-attachments/assets/394e2bbe-82b3-42bc-a052-fc9abc447bad

## Alur Aplikasi
###  Aktivitas Utama (MainActivity)
#### Tampilan Awal:
- Aplikasi dimulai dengan MainActivity yang menampilkan antarmuka utama
- Terdapat gambar stadion sebagai header, logo klub Middlesbrough FC di bagian tengah
- Nama klub ditampilkan dengan efek teks outline untuk penekanan visual
- Deskripsi singkat klub berada dalam card view dengan latar belakang warna pink
#### Fungsi Navigasi:
- Tiga menu utama disediakan dalam bentuk card view:
  Club History → Mengarah ke HistoryActivity
  Coach Info → Mengarah ke CoachActivity
  Player Info → Mengarah ke DaftarPlayerActivity
- Setiap menu memiliki ikon dan teks penjelas
- Implementasi onClickListener menggunakan View Binding untuk akses yang aman
###  Aktivitas Sejarah Klub (HistoryActivity)
#### Konten dan Tampilan:
- Menampilkan gambar representatif sejarah klub
- Judul "Club History" sebagai header
- Konten sejarah klub dalam bentuk teks panjang yang dapat di-scroll
- Deskripsi mencakup periode dari pendirian tahun 1975 hingga perkembangan terkini
#### Karakteristik Data:
- Data bersifat statis dan terintegrasi langsung dalam layout XML
- Tidak memerlukan koneksi jaringan atau pemrosesan data eksternal
- Format teks menggunakan justifikasi untuk tampilan yang rapi
###  Aktivitas Informasi Pelatih (CoachActivity)
#### Alur Pemrosesan Data:
1. Activity melakukan inisialisasi view menggunakan View Binding
2. Memanggil method fetchCoachData() saat onCreate
3. Menggunakan coroutine lifecycleScope untuk operasi jaringan asynchronous
4. Melakukan request API melalui RetrofitInstance.api.getTeamById()
5. Parameter yang dikirim: API token dan team ID "343" (Middlesbrough FC)
#### Handling Respons:
- Jika sukses: data coach diekstrak dan ditampilkan pada TextView terkait
- Jika gagal: menampilkan Toast dengan kode error HTTP
- Jika exception: menampilkan pesan error dari exception
- Data yang ditampilkan: nama, tanggal lahir, dan kewarganegaraan pelatih
###  Aktivitas Daftar Pemain (DaftarPlayerActivity)
#### Arsitektur MVVM:
- Mengimplementasikan Model-View-ViewModel pattern
- PlayerViewModel bertanggung jawab untuk manajemen data
- Activity sebagai View yang mengobservasi perubahan data
#### Proses Pengambilan Data:
1. ViewModel menginisiasi request API melalui fetchPlayers()
2. Menggunakan viewModelScope untuk coroutine
3. Response API diproses dan data squad (daftar pemain) diekstrak
4. Data di-update ke LiveData yang diobservasi oleh Activity
#### Tampilan dan Interaksi:
- RecyclerView dengan PlayerAdapter menampilkan daftar pemain
- Setiap item pemain memiliki warna latar berbeda berdasarkan posisi:
  Kuning: Penjaga gawang (Goalkeeper)
  Biru: Pemain bertahan (Defender)
  Hijau: Gelandang (Midfielder)
  Merah: Penyerang (Forward)
  Abu-abu: Posisi lainnya
- Click listener mengaktifkan PlayerDetailFragment sebagai BottomSheet dialog
### Fragment Detail Pemain (PlayerDetailFragment)
#### Presentasi Data:
- Ditampilkan sebagai BottomSheet dialog dengan theme custom
- Menampilkan informasi detail pemain: nama, posisi, kewarganegaraan, tanggal lahir
- Menggunakan Glide untuk menampilkan gambar pemain (saat ini menggunakan placeholder)
#### Mekanisme Pembukaan:
- Data dikirim melalui Bundle arguments menggunakan pattern factory method
- Fragment dapat digunakan kembali untuk berbagai pemain
### Infrastruktur Jaringan dan Data
#### Konfigurasi Retrofit:
- Base URL: https://api.football-data.org/v4/
- HTTP logging interceptor untuk debugging
- Timeout 30 detik untuk koneksi dan pembacaan
- Gson converter untuk parsing JSON response
#### Model Data:
- SearchResponse: Struktur respons API lengkap
- Coach: Data identitas dan kontrak pelatih
- Player: Data profil dan statistik pemain
#### Keamanan:
- API token disimpan dalam constants class
- Autentikasi menggunakan header X-Auth-Token
### Alur Data Keseluruhan
- Inisialisasi → MainActivity sebagai entry point
- Navigasi → User memilih menu yang diinginkan
- Pengambilan Data → CoachActivity dan DaftarPlayerActivity melakukan API calls
- Processing → Data di-parse dan di-transform ke model
- Presentasi → Data ditampilkan di UI dengan format yang sesuai
- Interaksi → User dapat berinteraksi dengan daftar pemain
- Detail View → BottomSheet menampilkan informasi detail

