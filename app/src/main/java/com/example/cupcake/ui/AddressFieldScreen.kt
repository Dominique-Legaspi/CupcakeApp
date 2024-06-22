package com.example.cupcake.ui

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.data.AddressUIState
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun AddressFieldScreen(
    addressViewModel: AddressViewModel,
    onNextButtonClicked: () -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    var cardNumber by remember { mutableStateOf("") }
    var exp by remember { mutableStateOf("") }
    var secCode by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
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
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Text("Enter credit card information:".uppercase())
            TextField(
                value = cardNumber,
                onValueChange = { newCardNumber -> cardNumber = newCardNumber },
                label = { Text(text = "Card Number") },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            )
            TextField(
                value = name,
                onValueChange = { newName -> name = newName },
                label = { Text(text = "Name of Card Holder") },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            )
            Row {
                TextField(
                    value = exp,
                    onValueChange = { newExp -> exp = newExp },
                    label = { Text(text = "Expiration") },
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                )
                TextField(
                    value = secCode,
                    onValueChange = { newSecCode -> if(newSecCode.length <= 3) secCode = newSecCode },
                    label = { Text(text = "CCV") },
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                )
            }
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
            Text("Enter shipping address:".uppercase())

            TextField(
                value = add1,
                onValueChange = { newAdd -> add1 = newAdd },
                label = { Text(text = "Address 1") },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            )
            TextField(
                value = add2,
                onValueChange = { newAdd -> add2 = newAdd },
                label = { Text(text = "Address 2") },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            )
            Row {
                TextField(
                    value = city,
                    onValueChange = { newCity -> city = newCity },
                    label = { Text(text = "City") },
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(2f)
                        .padding(2.dp)
                )
                TextField(
                    value = state,
                    onValueChange = { newState -> if(newState.length <=2) state = newState },
                    label = { Text(text = "State") },
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                )
            }
            Row {
                TextField(
                    value = zipcode,
                    onValueChange = { newZip -> zipcode = newZip },
                    label = { Text(text = "Zipcode") },
                    shape = RoundedCornerShape(4.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(2f)
                        .padding(2.dp)
                )
                TextField(
                    value = country,
                    onValueChange = { newCountry -> country= newCountry},
                    label = { Text(text = "Country") },
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                )
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
                    enabled= check(add1, city,state,country,zipcode,name, cardNumber, exp, secCode),
                    onClick = {
                        addressViewModel.setAdd1(add1)
                        addressViewModel.setAdd2(add2)
                        addressViewModel.setCity(city)
                        addressViewModel.setState(state)
                        addressViewModel.setCountry(country)
                        addressViewModel.setZip(zipcode)
                        addressViewModel.setName(name)
                        addressViewModel.setcardNum(cardNumber)
                        addressViewModel.setExpir(exp)
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
