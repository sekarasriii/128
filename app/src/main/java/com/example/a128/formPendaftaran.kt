package com.example.a128

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Brush
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment

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
    val statusKawin = listOf(
        stringResource(id = R.string.janda),
        stringResource(id = R.string.lajang),
        stringResource(id = R.string.duda)
    )

    //background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.ungu_muda),
                        colorResource(id = R.color.ungu_tua)
                    )
                )
            )
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            //Header
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White,
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(id = R.color.ungu_muda),
                                colorResource(id = R.color.ungu_dalam)
                            )
                        )
                    )
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

            //input nama lengkap
            OutlinedTextField(
                value = textNama,
                onValueChange =  {textNama = it},
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                label = {Text(stringResource(id = R.string.nama_lengkap))},
                modifier = Modifier.width(300.dp)
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

            //jenis kelamin
            Text(
                text = stringResource(id = R.string.jenis_kelamin),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
            gender.forEach{item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = textJK == item,
                            onClick = { textJK == item}
                        )
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = textJK == item, onClick = {textJK = item})
                    Text(text = item)
                }
            }
        }
    }
}