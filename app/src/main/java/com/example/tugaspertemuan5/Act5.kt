package com.example.tugaspertemuan5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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

@Composable
fun BiodataScreen() {
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
            )
        }
    }
}