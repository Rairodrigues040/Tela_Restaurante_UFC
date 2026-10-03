package com.rai.telarestauranteufcrussas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.telarestauranteufcrussas.ui.theme.TelaRestauranteUFCRussasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TelaRestauranteUFCRussasTheme {
                Restaurante()
            }
        }
    }
}

@Composable
fun Restaurante() {

    var preco by remember {
        mutableDoubleStateOf(12.50)
    }

    var quantidade by remember {
        mutableIntStateOf(1)
    }

    var soma by remember {
        mutableDoubleStateOf(12.50)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "SABOR DO SERTÃO",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Comida Regional",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Avaliação: 4.7"
        )

        Text(
            text = "Tempo: 20 - 35 min"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Prato do dia",
            fontSize = 18.sp
        )

        Text(
            text = "Baião de dois",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "R$ %.2f".format(soma),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {
                    if (quantidade > 1) {
                        quantidade--
                        soma -= preco
                    }
                }
            ) {
                Text("-")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "$quantidade",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    quantidade++
                    soma += preco
                }
            ) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {}
        ) {
            Text("FAZER PEDIDO")
        }
    }
}