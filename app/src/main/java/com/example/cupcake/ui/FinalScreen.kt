package com.example.cupcake.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cupcake.data.OrderUiState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.cupcake.R
import com.example.cupcake.data.AddressUIState

@Composable
fun FinalScreen(
    orderUiState: OrderUiState,
    addressUIState: AddressUIState,
    onCancelButtonClicked: () -> Unit,
    onSendButtonClicked:(String, String) ->Unit,
    modifier: Modifier = Modifier
){
    val resources = LocalContext.current.resources

    val numberOfCupcakes = resources.getQuantityString(
        R.plurals.cupcakes,
        orderUiState.quantity,
        orderUiState.quantity
    )

    val orderSummary = stringResource(
        R.string.order_details,
        numberOfCupcakes,
        orderUiState.flavor,
        orderUiState.date,
        orderUiState.quantity
    )
    val addressSummary = stringResource(
        addressUIState.address1,
        addressUIState.address2,
        addressUIState.city,
        addressUIState.state,
        addressUIState.country,
        addressUIState.zipcode,
        addressUIState.name,
        addressUIState.cardNum,
        addressUIState.expiration,
        addressUIState.secCode
    )
}
