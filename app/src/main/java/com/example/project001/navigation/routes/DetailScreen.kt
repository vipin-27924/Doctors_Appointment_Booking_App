package com.example.project001.navigation.routes

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.project001.core.model.doctorModel
import com.example.project001.feature.detail.DetailScreen

fun NavGraphBuilder.detailScreen(
    nav: NavHostController,
    onBack: () -> Unit
) {
    composable(Screen.Detail.route) { backStackEntry: NavBackStackEntry ->
        val context = LocalContext.current
        val prevEntry = remember(key1 = nav) { nav.previousBackStackEntry }
        val doctor = remember(key1 = prevEntry) {
            prevEntry?.savedStateHandle?.get<doctorModel>("doctor")
        }
        LaunchedEffect(key1 = prevEntry, key2 = doctor) {
            if (doctor == null) {
                onBack()
            } else {
                prevEntry?.savedStateHandle?.remove<doctorModel>(key = "doctor")
            }
        }
        if (doctor != null) {
            DetailScreen(
                item = doctor,
                onBack = onBack,
                onOpenWebsite = { url ->
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                },
                // ERROR FIXED: Changed the lambda to accept only one argument ('mobile')
                // to match the expected Function1<String, Unit> type.
                onSendSms = { mobile ->
                    // The SMS body must be defined here, as it's no longer passed in.
                    // You can leave it empty or provide a default message.
                    val defaultSmsBody = "Regarding our appointment..."
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("sms:$mobile"))
                        .apply { putExtra("sms_body", defaultSmsBody) } // Use the correct "sms_body" key
                    )
                },
                onDial = { mobile ->
                    context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$mobile")))
                },
                onDirection = { loc ->
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(loc)))
                },
                onShare = { subject, text ->
                    context.startActivity(
                        Intent.createChooser(
                            Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_SUBJECT, subject)
                                putExtra(Intent.EXTRA_TEXT, text)
                            },
                            "Choose one"
                        )
                    )
                }
            ) // Fixed the missing closing parenthesis from the previous review
        } else {
            Spacer(modifier = Modifier.height(1.dp))
        }
    }
}
