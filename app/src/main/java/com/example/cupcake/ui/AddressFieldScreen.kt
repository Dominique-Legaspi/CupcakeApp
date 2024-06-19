package com.example.cupcake.ui

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.data.AddressUIState
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun AddressFieldScreen(
    addressViewModel: AddressViewModel,
    onNextButtonClicked: () -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("")}
    var cardNum by remember{ mutableStateOf("")}
    var expir by remember { mutableStateOf("")}
    var secCode by remember{mutableStateOf("")}
    var add1 by remember { mutableStateOf("") }
    var add2 by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var zipcode by remember { mutableStateOf("") }


    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Row(){
                OutlinedTextField(value = name, label = {Text("Name on Card")}, onValueChange = {name = it},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
            }
            Row(){
                OutlinedTextField(value = cardNum,label = {Text("Card Number")}, onValueChange = { if(it.length <= 16)cardNum = it},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ))
            }
            Row() {
                OutlinedTextField(value = expir,
                    label = { Text("Expiration ") },
                    onValueChange = { expir = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
                OutlinedTextField(value = secCode,label = {Text("Security Code")}, onValueChange = { if(it.length <= 3)secCode = it},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ))
            }

            Row() {
                OutlinedTextField(value = add1, label = {Text("Address 1")}, onValueChange = {add1 = it},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ))
            }
            Row(){
                OutlinedTextField(value = add2, label = {Text("Address 2")}, onValueChange = {add2 = it},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ))
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween){
                OutlinedTextField(value = city,label = {Text("City")}, onValueChange =  {city = it},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ))
                OutlinedTextField(value = state, label = {Text("State")}, onValueChange = { if(it.length <= 2) state = it},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ))
                OutlinedTextField(value = country, label = {Text("Country")}, onValueChange = {country = it},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ))
                OutlinedTextField(value = zipcode,label = {Text("Zipcode")}, onValueChange = { if(it.length <= 5)zipcode = it},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Go
                    ))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ) {
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }
                Button(
                    modifier = Modifier.weight(1f),
                    //add check to see all values are filled in
                    //use enabled = {}
                    enabled= check(add1, city,state,country,zipcode,name, cardNum, expir, secCode),
                    onClick = {
                        addressViewModel.setAdd1(add1)
                        addressViewModel.setAdd2(add2)
                        addressViewModel.setCity(city)
                        addressViewModel.setState(state)
                        addressViewModel.setCountry(country)
                        addressViewModel.setZip(zipcode)
                        addressViewModel.setName(name)
                        addressViewModel.setcardNum(cardNum)
                        addressViewModel.setExpir(expir)
                        addressViewModel.setSecCode(secCode)
                        onNextButtonClicked()}
                ) {
                    Text(stringResource(R.string.next))
                }
            }
        }
    }
}
fun check(add1: String, city: String, state:String, country:String, zipcode:String, name:String, cardNum:String, expir: String, sec:String ): Boolean{
    return (add1.isNotEmpty() && city.isNotEmpty() && state.isNotEmpty() && country.isNotEmpty()
            && zipcode.isNotEmpty() && name.isNotEmpty() && cardNum.isNotEmpty() && expir.isNotEmpty() && sec.isNotEmpty())
}
@Preview
@Composable
fun AddressPreview(){
    CupcakeTheme {
        AddressFieldScreen(addressViewModel = AddressViewModel())
    }
}