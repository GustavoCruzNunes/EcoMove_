package com.example.pi5_ecomove

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    // Modificar a interface da API
    @GET("login.php")
    fun login(
        @Query("usuario") usuario: String,
        @Query("senha") senha: String
    ): Call<LoginResponse> // Retorna um único objeto


    // Método para Registro
    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("nome") nome: String,
        @Field("email") email: String,
        @Field("telefone") telefone: String,
        @Field("senha") senha: String
    ): Call<RegisterResponse>

        @FormUrlEncoded
        @POST("viagens.php") // Nome do arquivo PHP no servidor
        fun requestTrip(
            @Field("usuario_id") usuarioId: Int,
            @Field("endereco_origem") enderecoOrigem: String,
            @Field("endereco_destino") enderecoDestino: String,
            @Field("data_horario_partida") dataHorarioPartida: String,
            @Field("lugares") lugares: Int,
            @Field("aceita_pet") aceitaPet: Int,
            @Field("preco") preco: Double
        ): Call<ApiResponse>

    @POST("sua-rota-backend")
    fun criarViagem(
        @Field("tipo") tipo: String,
        @Field("origem") origem: String,
        @Field("dataPartida") dataPartida: String,
        @Field("preco") preco: Double
    ): Call<Void>

    @FormUrlEncoded
    @POST("viagens.php")
    fun offerTrip(
        @Field("tipo") tipo: String,
        @Field("usuario_id") userId: String,
        @Field("endereco_origem") boarding: String,
        @Field("endereco_destino") disembark: String,
        @Field("data_horario_partida") dateTime: String,
        @Field("lugares") seats: Int,
        @Field("aceita_pet") acceptPet: Double,
        @Field("preco") price: Double
    ): Call<ApiResponse>

    @FormUrlEncoded
    @POST("forgot_password.php")
    fun forgotPassword(
        @Field("email") email: String
    ): Call<ApiResponse>

    @FormUrlEncoded
    @POST("validate_email.php") // Endpoint para validar e-mail
    fun validateEmail(
        @Field("email") email: String
    ): Call<ApiResponse>

    @FormUrlEncoded
    @POST("update_password.php")
    fun updatePassword(
        @Field("email") email: String,
        @Field("nova_senha") novaSenha: String
    ): Call<ApiResponse>

    @GET("get_trips.php")
    fun getTrips(): Call<List<TripModel>>

    @GET("get_trip_details.php")
    fun getTripDetails(@Query("tripId") tripId: Int): Call<TripModel>

    @FormUrlEncoded
    @POST("update_trip.php")
    fun updateTrip(
        @Field("id") id: Int, // Alterado de tripId para id
        @Field("endereco_origem") origin: String,
        @Field("endereco_destino") destination: String,
        @Field("data_horario_partida") dateTime: String
    ): Call<ApiResponse>

}

data class LoginResponse(
    val idlogin: Int?,
    val username: String?,
    val nome_completo: String?,
    val erro: String? // Adicionado o campo "erro" para capturar mensagens de erro do servidor
)


// Classe para tratar a resposta do Registro
data class RegisterResponse(
    val status: String,
    val message: String


)
