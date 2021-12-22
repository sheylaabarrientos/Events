package com.example.events.ui.model

sealed class ViewState {
    object MovieNotFound : ViewState()
    object GeneralError : ViewState()
}
