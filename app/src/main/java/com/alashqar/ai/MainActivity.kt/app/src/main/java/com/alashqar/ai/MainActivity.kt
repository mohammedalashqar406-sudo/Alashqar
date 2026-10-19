
package com.alashqar.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF101321)
private val Panel = Color(0xFF1C2235)
private val Accent = Color(0xFF9298FF)
private val MainText = Color(0xFFF5F6FF)
private val Muted = Color(0xFFADB5CC)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AlashqarApp()
            }
        }
    }
}

@Composable
fun AlashqarApp() {
    var message by remember { mutableStateOf("") }
    var notice by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    color = Panel,
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "A",
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 10.dp
                        ),
                        color = Accent,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Black
                    )
                }

                Column {
                    Text(
                        "Alashqar.AI",
                        color = MainText,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "YOUR PERSONAL AI",
                        color = Muted,
                        fontSize = 10.sp,
                        letterSpacing = 2.sp
                    )
                }
            }

            Spacer(Modifier.height(48.dp))

            Text(
                "Hello, Mohamed.",
                color = Accent,
                fontSize = 15.sp
            )

            Spacer(Modifier.height(10.dp))

            Text(
                "How can I help you today?",
                color = MainText,
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 36.sp
            )

            Spacer(Modifier.height(12.dp))

            Text(
                "Your ideas deserve intelligent answers.",
                color = Muted,
                fontSize = 14.sp
            )

            Spacer(Modifier.height(28.dp))

            listOf(
                "Ask anything" to "Get help, explanations and answers",
                "Code & create" to "Build ideas and solve problems",
                "Think smarter" to "Explore new possibilities"
            ).forEach { (title, subtitle) ->
                Surface(
                    color = Panel,
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {
                    Column(Modifier.padding(17.dp)) {
                        Text(
                            title,
                            color = MainText,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Spacer(Modifier.height(5.dp))
                        Text(
                            subtitle,
                            color = Muted,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Spacer(Modifier.weight(1f))

            if (notice.isNotBlank()) {
                Text(
                    notice,
                    color = Muted,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }

            Surface(
                color = Panel,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(12.dp)) {
                    BasicTextField(
                        value = message,
                        onValueChange = { message = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        textStyle = androidx.compose.ui.text.TextStyle(
                            color = MainText,
                            fontSize = 15.sp
                        ),
                        cursorBrush = androidx.compose.ui.graphics.SolidColor(
                            Accent
                        ),
                        decorationBox = { innerTextField ->
                            Box {
                                if (message.isEmpty()) {
                                    Text(
                                        "Message Alashqar.AI...",
                                        color = Muted,
                                        fontSize = 14.sp
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )

                    Spacer(Modifier.height(12.dp))

                    Button(
                        onClick = {
                            notice = if (message.isBlank()) {
                                "Write a message first."
                            } else {
                                "AI connection will be added in the next stage."
                            }
                        },
                        modifier = Modifier.align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Accent,
                            contentColor = Background
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            "Send  ↑",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            Text(
                "ALASHQAR.AI  •  VERSION 1.0",
                color = Muted,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
