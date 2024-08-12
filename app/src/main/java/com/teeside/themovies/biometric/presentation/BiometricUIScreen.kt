package com.teeside.themovies.biometric.presentation

import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.teeside.themovies.R
import com.teeside.themovies.main.presentation.main.MainViewModel
import com.teeside.themovies.main.presentation.main.Navigation

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun BiometricUIScreen() {
    val context = LocalContext.current
    val activity = context as AppCompatActivity
    val promptManager by lazy {
        BiometricPromptManager(activity)
    }
    val biometricResult by promptManager.promptResults.collectAsState(
        initial = null
    )
    val enrollLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {
            println("Activity result: $it")
        }
    )
    val mainViewModel = hiltViewModel<MainViewModel>()
    val mainUiState = mainViewModel.mainUiState.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        promptManager.showBiometricPrompt(
            title = context.getString(R.string.app_name),
            description = "Enter your biometric credential to unlock!"
        )

        LaunchedEffect(biometricResult) {
            if (biometricResult is BiometricPromptManager.BiometricResult.AuthenticationNotSet) {
                if (Build.VERSION.SDK_INT >= 30) {
                    val enrollIntent =
                        Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                            putExtra(
                                Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                                BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL
                            )
                        }
                    enrollLauncher.launch(enrollIntent)
                }
            }
        }

        biometricResult?.let { result ->

            val text = when (result) {
                is BiometricPromptManager.BiometricResult.AuthenticationError -> {
                    result.error
                }

                BiometricPromptManager.BiometricResult.AuthenticationFailed -> {
                    "Authentication failed"
                }

                BiometricPromptManager.BiometricResult.AuthenticationNotSet -> {
                    "Authentication not set"
                }

                BiometricPromptManager.BiometricResult.AuthenticationSuccess -> {
                    "Authentication success"

                    Navigation(
                        mainUiState = mainUiState,
                        onEvent = mainViewModel::onEvent
                    )

                }

                BiometricPromptManager.BiometricResult.FeatureUnavailable -> {
                    "Feature unavailable"
                }

                BiometricPromptManager.BiometricResult.HardwareUnavailable -> {
                    "Hardware unavailable"
                }
            }
        }
    }
}