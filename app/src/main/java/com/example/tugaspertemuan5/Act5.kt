package com.example.tugaspertemuan5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BiodataScreen() {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }

    val bentukKartu = RoundedCornerShape(
        topStart = dimensionResource(id = R.dimen.radius_kartu),
        topEnd = dimensionResource(id = R.dimen.radius_kartu)
    )

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.mobil),
                contentDescription = stringResource(id = R.string.deskripsi_gambar_header),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.tinggi_gambar))
            )

            Row(
                modifier = Modifier
                    .padding(top = innerPadding.calculateTopPadding())
                    .padding(dimensionResource(id = R.dimen.padding_layar)),
                horizontalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.jarak_indikator)
                )
            ) {
                repeat(integerResource(id = R.integer.jumlah_indikator)) { index ->
                    Box(
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.ukuran_indikator))
                            .clip(CircleShape)
                            .background(
                                colorResource(
                                    id = if (index == 0) R.color.biru_indikator_aktif
                                    else R.color.abu_indikator
                                )
                            )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = innerPadding.calculateBottomPadding())
                    .padding(
                        top = dimensionResource(id = R.dimen.tinggi_gambar) -
                                dimensionResource(id = R.dimen.tumpang_tindih_kartu)
                    )
                    .fillMaxSize()
                    .shadow(
                        elevation = dimensionResource(id = R.dimen.elevasi_kartu),
                        shape = bentukKartu
                    )
                    .background(
                        color = colorResource(id = R.color.putih_kartu),
                        shape = bentukKartu
                    )
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(id = R.dimen.padding_layar)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        dimensionResource(id = R.dimen.jarak_komponen)
                    )
                ) {
                    FormHeader()

                    FieldNama(
                        namaDepan = namaDepan,
                        onNamaDepanChange = { namaDepan = it },
                        namaBelakang = namaBelakang,
                        onNamaBelakangChange = { namaBelakang = it }
                    )
                }
            }
        }
    }
}

@Composable
fun FormHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.jarak_judul))
    ) {
        Text(
            text = stringResource(id = R.string.judul_form),
            color = colorResource(id = R.color.ungu_utama),
            fontSize = dimensionResource(id = R.dimen.ukuran_judul).value.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.subjudul_form),
            color = colorResource(id = R.color.abu_teks),
            fontSize = dimensionResource(id = R.dimen.ukuran_subjudul).value.sp
        )
    }
}

@Composable
fun bentukField() = RoundedCornerShape(dimensionResource(id = R.dimen.radius_field))

@Composable
fun FieldNama(
    namaDepan: String,
    onNamaDepanChange: (String) -> Unit,
    namaBelakang: String,
    onNamaBelakangChange: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.jarak_field))
    ) {
        OutlinedTextField(
            value = namaDepan,
            onValueChange = onNamaDepanChange,
            singleLine = true,
            shape = bentukField(),
            label = { Text(text = stringResource(id = R.string.label_nama_depan)) },
            modifier = Modifier.weight(1f)
        )
        OutlinedTextField(
            value = namaBelakang,
            onValueChange = onNamaBelakangChange,
            singleLine = true,
            shape = bentukField(),
            label = { Text(text = stringResource(id = R.string.label_nama_belakang)) },
            modifier = Modifier.weight(1f)
        )
    }
}