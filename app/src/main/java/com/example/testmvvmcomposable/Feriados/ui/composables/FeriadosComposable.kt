package com.example.testmvvmcomposable.Feriados.ui.composables


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testmvvmcomposable.Feriados.model.data.Data
import com.example.testmvvmcomposable.Feriados.viewmodel.FeriadosViewModel

@Composable
fun FeriadosComposable(viewModel: FeriadosViewModel) {

    // Observar los cambios en el LiveData
    val feriados by viewModel.feriados.observeAsState()

    // Cargar los feriados al iniciar la actividad
    LaunchedEffect(Unit) {
        viewModel.fetchFeriados()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HeaderSection(title = "Lista de Feriados")
        ContentSection(feriados?.data.orEmpty())
    }
}

//HEADER SECTION

@Composable
fun HeaderSection(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.align(Alignment.CenterStart)
        )
    }
}

//CONTENT SECTION

@Composable
fun ContentSection(feriados: List<Data>) {
    if (feriados.isEmpty()) {
        LoadingSection()
    } else {
        FeriadosList(feriados)
    }
}

//CARGANDO

@Composable
fun LoadingSection() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(
                modifier = Modifier.size(60.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Cargando feriados...",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 16.sp
                )
            )
        }
    }
}

//LISTA DE ITEMS

@Composable
fun FeriadosList(feriados: List<Data>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(feriados, key = { it.title }) { feriado ->
            FeriadoCard(feriado)
        }
    }
}

//CARD DESING

@Composable
fun FeriadoCard(feriado: Data) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = feriado.title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Fecha: ${feriado.date}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
            Text(
                text = "Tipo: ${feriado.type}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
            if (feriado.extra.isNotEmpty()) {
                Text(
                    text = "Extra: ${feriado.extra}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }
        }
    }
}