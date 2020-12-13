package com.example.paywithbitcoin.network

object Coinbase {
    const val API_KEY ="8ArtrGv2UyiF2HV7"
    const val API_SECRET = "h02MdBNKNnhTe9PBwvBbb8ONoLuyHqBN"

    const val CLIENT_ID="f076e003171105c8e0cd409eef46d6fc5fd1ffeee0bf9dc60e92d89f4844516a"
    const val CLIENT_SECRET="1d0c3c95574b3cca9d1eca4a3b00bdafbc0e12a9b5298f2b1e2a2749b065d37e"
    const val REDIRECT_URI = "coinbase-android-example://coinbase-oauth"

    const val CALLBACK_URL="https://modebank/callback"
    const val SAMPLE_AUTHORIZE_URL ="https://www.coinbase.com/oauth/authorize?client_id=f076e003171105c8e0cd409eef46d6fc5fd1ffeee0bf9dc60e92d89f4844516a&redirect_uri=https%3A%2F%2Fmodebank%2Fcallback&response_type=code&scope=wallet%3Auser%3Aread"
    const val DEV_ACCESS_TOKEN="d5051007587815072e62016b8bdc42e0a4077cde599bbd6b6aa8369f4832bd72"
    const val DEV_API_CALL="https://api.coinbase.com/v2/user"
    const val AUTHORIZE_URL="https://www.coinbase.com/oauth/authorize"
    const val ACCESS_TOKEN_URL="http://www.coinbase.com/oauth/token"

    const val WEBSITE_URI="https://public.sandbox.pro.coinbase.com"
    const val REST_API="https://api-public.sandbox.pro.coinbase.com"
    const val WEBSOCKET_FEED="wss://ws-feed-public.sandbox.pro.coinbase.com"
    const val FIX_API="tcp+ssl://fix-public.sandbox.pro.coinbase.com:4198"
}