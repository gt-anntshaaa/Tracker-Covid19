package com.example.covid_19tracker.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class CovidResponse(
    @SerializedName("current_data")
    val currentData: Double,
    @SerializedName("last_date")
    val lastDate: String,
    @SerializedName("list_data")
    val listData: List<Data>,
    @SerializedName("missing_data")
    val missingData: Double,
    @SerializedName("tanpa_provinsi")
    val tanpaProvinsi: Int
) {
    data class Data(
        @SerializedName("doc_count")
        val docCount: Double,
        @SerializedName("jenis_kelamin")
        val jenisKelamin: List<JenisKelamin>,
        @SerializedName("jumlah_dirawat")
        val jumlahDirawat: Int,
        @SerializedName("jumlah_kasus")
        val jumlahKasus: Int,
        @SerializedName("jumlah_meninggal")
        val jumlahMeninggal: Int,
        @SerializedName("jumlah_sembuh")
        val jumlahSembuh: Int,
        @SerializedName("kelompok_umur")
        val kelompokUmur: List<KelompokUmur>,
        @SerializedName("key")
        val key: String,
        @SerializedName("lokasi")
        val lokasi: Lokasi,
        @SerializedName("penambahan")
        val penambahan: Penambahan
    ) {
        data class JenisKelamin(
            @SerializedName("doc_count")
            val docCount: Int,
            @SerializedName("key")
            val key: String
        )

        data class KelompokUmur(
            @SerializedName("doc_count")
            val docCount: Int,
            @SerializedName("key")
            val key: String,
            @SerializedName("usia")
            val usia: Usia
        ) {
            data class Usia(
                @SerializedName("value")
                val value: Double
            )
        }

        data class Lokasi(
            @SerializedName("lat")
            val lat: Double,
            @SerializedName("lon")
            val lon: Double
        )

        data class Penambahan(
            @SerializedName("meninggal")
            val meninggal: Int,
            @SerializedName("positif")
            val positif: Int,
            @SerializedName("sembuh")
            val sembuh: Int
        )
    }
}