package com.niranjan.khatri.time.android.ui

import androidx.compose.runtime.Composable

typealias OneAddType = (List<String>) -> Unit
typealias onDismissType = () -> Unit
typealias composeFun = @Composable () -> Unit
typealias topBarFun = @Composable (Int) -> Unit

@Composable
fun EmptyComposable(){

}