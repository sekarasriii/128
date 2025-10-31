package com.example.a128

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

@Composable
fun FormulirPendaftaran() {
    //variabel untuk input pengguna
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember {mutableStateOf("")}
    var textJK by remember {mutableStateOf("")}
    var textStatus by remember {mutableStateOf("")}

    //variabel hasil submit
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    //data pilihan gender dan statuskawin
    val gender = listOf(
        stringResource(id = R.string.laki_laki),
        stringResource(id = R.string.perempuan)
    )
}