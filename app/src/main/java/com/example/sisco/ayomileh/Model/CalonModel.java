package com.example.sisco.ayomileh.Model;

import java.util.List;

/**
 * Created by LENOVO on 18/04/2018.
 */

public class CalonModel {

    /**
     * jumlah_dukungan : 0
     * tanggal_lahir_kepala_daerah : 28/10/1968
     * tempat_lahir_wakil : REMBANG
     * tanggal_lahir_wakil : 2/7/1983
     * pekerjaan_wakil_kepala_daerah : ANGGOTA DPRD PROVINSI JAWA TENGAH
     * pekerjaan_kepala_daerah : GUBERNUR
     * media_sosial_instagram : null
     * wilayah : PROVINSI JAWA TENGAH
     * status_petahana : YA
     * media_sosial_facebook : null
     * partai_pendukung : PDI-P, PPP, DEMOKRAT, NASDEM
     * nama_wakil_kepala_daerah : H. TAJ YASIN
     * visimisi : {"visi":"Menuju Jawa Tengah Sejahtera dan Berdikari: Mboten Korupsi, Mboten Ngapusi.","program":["Pendidikan politik dan pemberdayaan masyarakat","Reformasi Birokrasi","Peningkatan Kesejahteraan Masyarakat","Peningkatan pembangunan lnfrastruktur","Peningkatan kualitas lingkungan hidup dan energi","Pengembangan Kebudayaan"],"detail":["Menanamkan nilai-nilai spritual dan kebangsaan melalui pendidikan, pelatihan dan pendampingan masyarakat.","Mengkonsolidasikan dan menyinergikan seluruh kekuatan Satuan Kerja Perangkat Daerah melalui sistim pelayanan yang berpihak pada kepentingan publik","Terpenuhinya kebutuhan hidup dasar warga dan terciptanya relasi sosial yang aman dan tidak diskriminatif melalui kerjasama kemitraan, investasi, pemberian bantuan dan gotong royong semua pemangku kepentingan","Pengembangan infrastruktur sosial, ekonomi, politik dan kebudayaan dengan menjaga, memelihara dan meningkatkan kualitas dan kuantitas infrastruktur","Menjamin keberlangsungan hidup manusia dan sumberdaya alam yang aman dan berkelanjutan melalui pengembangan teknologi ramah lingkungan, konservasi alam dan ekosistem, pengurangan resiko bencana, mengembangkan pemanfaatan energi baru terbarukan","Mengembangkan nilai-nilai dan menguatkan identitas kebudayaan Jawa Tengah melalui pengakuan keragaman budaya dan memfasilitasi ruang-ruang ekspresi dan kreasi berbagai budaya yang hidup di masyarakat"],"misi":["Menempatkan rakyat (petani. nelayan, pelaku usaha mikro den kecil serta rakyat pekerja) sebagai subyek  dalam proses pengambilan keputusan dan penentuan arah pembangunan  serta memperkuat akses rakyat terhadap sumberdaya politik, ekonomi sosial dan budaya","Memperkuat penyelengara pemerintahan yang bersih, jujur, transparan demi terjaminnya sistem pelayanan publik untuk memenuhi kebutuhan dasar rakyat, terciptanya relasi sosial yang aman dan tidak diskrinimatif","Menyelenggarakan program-program pembangunan yang menjamin terwujudnya kesejahteraan rakyat melalui sinergitas kerja dan gotong royong para pemangku kepentingan"]}
     * tempat_lahir_kepala_daerah : KARANGANYAR
     * nama_kepala_daerah : H. GANJAR PRANOWO, S.H., M.IP
     * provinsi : JAWA TENGAH
     * gender_wakil_kepala_daerah : LAKI-LAKI
     * gender_kepala_daerah : LAKI-LAKI
     * media_sosial_twitter : null
     */

    private int jumlah_dukungan;
    private String tanggal_lahir_kepala_daerah;
    private String tempat_lahir_wakil;
    private String tanggal_lahir_wakil;
    private String pekerjaan_wakil_kepala_daerah;
    private String pekerjaan_kepala_daerah;
    private Object media_sosial_instagram;
    private String wilayah;
    private String status_petahana;
    private Object media_sosial_facebook;
    private String partai_pendukung;
    private String nama_wakil_kepala_daerah;
    private VisimisiBean visimisi;
    private String tempat_lahir_kepala_daerah;
    private String nama_kepala_daerah;
    private String provinsi;
    private String gender_wakil_kepala_daerah;
    private String gender_kepala_daerah;
    private Object media_sosial_twitter;

    public int getJumlah_dukungan() {
        return jumlah_dukungan;
    }

    public void setJumlah_dukungan(int jumlah_dukungan) {
        this.jumlah_dukungan = jumlah_dukungan;
    }

    public String getTanggal_lahir_kepala_daerah() {
        return tanggal_lahir_kepala_daerah;
    }

    public void setTanggal_lahir_kepala_daerah(String tanggal_lahir_kepala_daerah) {
        this.tanggal_lahir_kepala_daerah = tanggal_lahir_kepala_daerah;
    }

    public String getTempat_lahir_wakil() {
        return tempat_lahir_wakil;
    }

    public void setTempat_lahir_wakil(String tempat_lahir_wakil) {
        this.tempat_lahir_wakil = tempat_lahir_wakil;
    }

    public String getTanggal_lahir_wakil() {
        return tanggal_lahir_wakil;
    }

    public void setTanggal_lahir_wakil(String tanggal_lahir_wakil) {
        this.tanggal_lahir_wakil = tanggal_lahir_wakil;
    }

    public String getPekerjaan_wakil_kepala_daerah() {
        return pekerjaan_wakil_kepala_daerah;
    }

    public void setPekerjaan_wakil_kepala_daerah(String pekerjaan_wakil_kepala_daerah) {
        this.pekerjaan_wakil_kepala_daerah = pekerjaan_wakil_kepala_daerah;
    }

    public String getPekerjaan_kepala_daerah() {
        return pekerjaan_kepala_daerah;
    }

    public void setPekerjaan_kepala_daerah(String pekerjaan_kepala_daerah) {
        this.pekerjaan_kepala_daerah = pekerjaan_kepala_daerah;
    }

    public Object getMedia_sosial_instagram() {
        return media_sosial_instagram;
    }

    public void setMedia_sosial_instagram(Object media_sosial_instagram) {
        this.media_sosial_instagram = media_sosial_instagram;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    public String getStatus_petahana() {
        return status_petahana;
    }

    public void setStatus_petahana(String status_petahana) {
        this.status_petahana = status_petahana;
    }

    public Object getMedia_sosial_facebook() {
        return media_sosial_facebook;
    }

    public void setMedia_sosial_facebook(Object media_sosial_facebook) {
        this.media_sosial_facebook = media_sosial_facebook;
    }

    public String getPartai_pendukung() {
        return partai_pendukung;
    }

    public void setPartai_pendukung(String partai_pendukung) {
        this.partai_pendukung = partai_pendukung;
    }

    public String getNama_wakil_kepala_daerah() {
        return nama_wakil_kepala_daerah;
    }

    public void setNama_wakil_kepala_daerah(String nama_wakil_kepala_daerah) {
        this.nama_wakil_kepala_daerah = nama_wakil_kepala_daerah;
    }

    public VisimisiBean getVisimisi() {
        return visimisi;
    }

    public void setVisimisi(VisimisiBean visimisi) {
        this.visimisi = visimisi;
    }

    public String getTempat_lahir_kepala_daerah() {
        return tempat_lahir_kepala_daerah;
    }

    public void setTempat_lahir_kepala_daerah(String tempat_lahir_kepala_daerah) {
        this.tempat_lahir_kepala_daerah = tempat_lahir_kepala_daerah;
    }

    public String getNama_kepala_daerah() {
        return nama_kepala_daerah;
    }

    public void setNama_kepala_daerah(String nama_kepala_daerah) {
        this.nama_kepala_daerah = nama_kepala_daerah;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getGender_wakil_kepala_daerah() {
        return gender_wakil_kepala_daerah;
    }

    public void setGender_wakil_kepala_daerah(String gender_wakil_kepala_daerah) {
        this.gender_wakil_kepala_daerah = gender_wakil_kepala_daerah;
    }

    public String getGender_kepala_daerah() {
        return gender_kepala_daerah;
    }

    public void setGender_kepala_daerah(String gender_kepala_daerah) {
        this.gender_kepala_daerah = gender_kepala_daerah;
    }

    public Object getMedia_sosial_twitter() {
        return media_sosial_twitter;
    }

    public void setMedia_sosial_twitter(Object media_sosial_twitter) {
        this.media_sosial_twitter = media_sosial_twitter;
    }

    public static class VisimisiBean {
        /**
         * visi : Menuju Jawa Tengah Sejahtera dan Berdikari: Mboten Korupsi, Mboten Ngapusi.
         * program : ["Pendidikan politik dan pemberdayaan masyarakat","Reformasi Birokrasi","Peningkatan Kesejahteraan Masyarakat","Peningkatan pembangunan lnfrastruktur","Peningkatan kualitas lingkungan hidup dan energi","Pengembangan Kebudayaan"]
         * detail : ["Menanamkan nilai-nilai spritual dan kebangsaan melalui pendidikan, pelatihan dan pendampingan masyarakat.","Mengkonsolidasikan dan menyinergikan seluruh kekuatan Satuan Kerja Perangkat Daerah melalui sistim pelayanan yang berpihak pada kepentingan publik","Terpenuhinya kebutuhan hidup dasar warga dan terciptanya relasi sosial yang aman dan tidak diskriminatif melalui kerjasama kemitraan, investasi, pemberian bantuan dan gotong royong semua pemangku kepentingan","Pengembangan infrastruktur sosial, ekonomi, politik dan kebudayaan dengan menjaga, memelihara dan meningkatkan kualitas dan kuantitas infrastruktur","Menjamin keberlangsungan hidup manusia dan sumberdaya alam yang aman dan berkelanjutan melalui pengembangan teknologi ramah lingkungan, konservasi alam dan ekosistem, pengurangan resiko bencana, mengembangkan pemanfaatan energi baru terbarukan","Mengembangkan nilai-nilai dan menguatkan identitas kebudayaan Jawa Tengah melalui pengakuan keragaman budaya dan memfasilitasi ruang-ruang ekspresi dan kreasi berbagai budaya yang hidup di masyarakat"]
         * misi : ["Menempatkan rakyat (petani. nelayan, pelaku usaha mikro den kecil serta rakyat pekerja) sebagai subyek  dalam proses pengambilan keputusan dan penentuan arah pembangunan  serta memperkuat akses rakyat terhadap sumberdaya politik, ekonomi sosial dan budaya","Memperkuat penyelengara pemerintahan yang bersih, jujur, transparan demi terjaminnya sistem pelayanan publik untuk memenuhi kebutuhan dasar rakyat, terciptanya relasi sosial yang aman dan tidak diskrinimatif","Menyelenggarakan program-program pembangunan yang menjamin terwujudnya kesejahteraan rakyat melalui sinergitas kerja dan gotong royong para pemangku kepentingan"]
         */

        private String visi;
        private List<String> program;
        private List<String> detail;
        private List<String> misi;

        public String getVisi() {
            return visi;
        }

        public void setVisi(String visi) {
            this.visi = visi;
        }

        public List<String> getProgram() {
            return program;
        }

        public void setProgram(List<String> program) {
            this.program = program;
        }

        public List<String> getDetail() {
            return detail;
        }

        public void setDetail(List<String> detail) {
            this.detail = detail;
        }

        public List<String> getMisi() {
            return misi;
        }

        public void setMisi(List<String> misi) {
            this.misi = misi;
        }
    }
}
