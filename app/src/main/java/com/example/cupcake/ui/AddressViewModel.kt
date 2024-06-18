package com.example.cupcake.ui

import androidx.lifecycle.ViewModel
import com.example.cupcake.data.AddressUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class AddressViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(AddressUIState())
    val uiState: StateFlow<AddressUIState> = _uiState.asStateFlow()

    fun setAdd1(newAdd1: String){
        _uiState.update{
            currentState ->
            currentState.copy(
                address1 = newAdd1
            )
        }
    }
    fun setAdd2(newAdd2: String){
        _uiState.update{
                currentState ->
            currentState.copy(
                address2 = newAdd2
            )
        }
    }
    fun setCity(newCity: String){
        _uiState.update{
                currentState ->
            currentState.copy(
               city = newCity
            )
        }
    }
    fun setState(newState: String){
        _uiState.update{
                currentState ->
            currentState.copy(
                state = newState
            )
        }
    }
    fun setCountry(newCountry: String){
        _uiState.update{
                currentState ->
            currentState.copy(
                country = newCountry
            )
        }
    }
    fun setZip(newZip: String){
        _uiState.update{
                currentState ->
            currentState.copy(
                zipcode = newZip
            )
        }
    }
    fun setName(newName:String){
        _uiState.update{
                currentState ->
            currentState.copy(
                name = newName
            )
        }
    }
    fun setcardNum(newNum:String){
        _uiState.update{
                currentState ->
            currentState.copy(
                cardNum = newNum
            )
        }
    }
    fun setExpir(newExpir: String){
        _uiState.update{
                currentState ->
            currentState.copy(
                expiration = newExpir
            )
        }
    }
    fun setSecCode(newCode: String){
        _uiState.update{
                currentState ->
            currentState.copy(
                secCode = newCode
            )
        }
    }

}