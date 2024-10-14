package com.dinhthi2004.restaurantmanager.api

import com.dinhthi2004.restaurantmanager.model.Account
import com.dinhthi2004.restaurantmanager.model.Bill
import com.dinhthi2004.restaurantmanager.model.Ingredient
import com.dinhthi2004.restaurantmanager.model.LoginRequest
import com.dinhthi2004.restaurantmanager.model.Meal
import com.dinhthi2004.restaurantmanager.model.Table
import com.dinhthi2004.restaurantmanager.model.dish.Dish
import com.dinhthi2004.restaurantmanager.model.dish.DishResponse
import com.dinhthi2004.restaurantmanager.model.dish_type.Dish_type
import com.dinhthi2004.restaurantmanager.model.dish_type.Dish_type_response
import com.dinhthi2004.restaurantmanager.model.user.User
import com.dinhthi2004.restaurantmanager.model.user.UserRegistration
import com.dinhthi2004.restaurantmanager.model.user.UserResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    //Auth
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("register")
    suspend fun signup(@Body signupInfo: Account): Response<Account>

    //Admin

    //Dish
    @GET("dishes")
    suspend fun getAllDishes(
        @Header("Authorization") token: String
    ): Response<DishResponse>


    @GET("dishes/{id}")
    suspend fun getDishByID(
        @Header("authorization") jwtToken: String,
        @Path("id") id: String
    ): Response<Dish>

    @Multipart
    @POST("dishes")
    suspend fun addNewDish(
        @Header("Authorization") token: String,
        @Part("name") name: RequestBody,
        @Part("price") price: RequestBody,
        @Part("status") status: RequestBody,
        @Part("id_type") idType: RequestBody,
        @Part("information") information: RequestBody,
        @Part image_url: MultipartBody.Part? // Optional image part
    ): Response<Dish>


    @Multipart
    @POST("dishes/{id}")
    suspend fun updateDish(
        @Header("Authorization") token: String,
        @Path("id") dishId: String,
        @Part("name") name: RequestBody,
        @Part("price") price: RequestBody,
        @Part("status") status: RequestBody,
        @Part("id_type") idType: RequestBody,
        @Part("information") information: RequestBody,
        @Part image_url: MultipartBody.Part?
    ): Response<Dish>

    @DELETE("dishes/{id}")
    suspend fun deleteDish(
        @Header("authorization") jwtToken: String,
        @Path("id") id: String
    ): Response<Dish>

    //User
    @GET("accounts")
    suspend fun getAllUser(
        @Header("authorization") jwtToken: String
    ): Response<UserResponse>

    // https://rm-api.imtaedu.com/api/accounts/{id}
    @GET("accounts/{id}")
    suspend fun getUserById(
        @Header("authorization") jwtToken: String,
        @Path("id") id: Int
    ): Response<UserResponseData>

    @POST("accounts")
    suspend fun addNewUser(
        @Header("authorization") jwtToken: String,
        @Body userRegistration: UserRegistration
    ): Response<UserResponseData>

    @POST("accounts/{id}")
    suspend fun updateUser(
        @Header("authorization") jwtToken: String,
        @Path("id") id: String,
        @Body user: User
    ): Response<User>

    @PUT("accounts/{id}")
    suspend fun updateRole(
        @Header("authorization") jwtToken: String,
        @Path("id") id: Int,
        @Body user: User
    ): Response<UserResponseData>


    @DELETE("accounts/{id}")
    suspend fun deleteUser(
        @Header("authorization") jwtToken: String,
        @Path("id") id: Int
    ): Response<UserResponseData>



    //Dishes Type

    @GET("dish-types")
    suspend fun getAllDishType(
        @Header("authorization") jwtToken: String
    ): Response<Dish_type_response>

    @POST("dish-types")
    suspend fun addNewDishType(
        @Header("authorization") jwtToken: String,
        @Body dishType: Dish_type
    ): Response<Dish_type>

    @POST("dish-types/{id}")
    suspend fun updateDishType(
        @Header("authorization") jwtToken: String,
        @Path("id") id: String,
        @Body dishType: Dish_type
    ): Response<Dish_type>

    @DELETE("dish-types/{id}")
    suspend fun deleteDishType(
        @Header("authorization") jwtToken: String,
        @Path("id") id: String
    ): Response<Dish_type>


    //Manager

    //Waiter

    @GET("ingredient/get-list")
    suspend fun getIngredients(@Header("authorization") jwtToken: String): ApiResponse<List<Ingredient>>

    @GET("tables")
    suspend fun getTables(@Header("authorization") jwtToken: String): ApiResponse1<List<Table>>

    @GET("bill/get-list-bill")
    suspend fun getBills(@Header("authorization") jwtToken: String): ApiResponse<List<Bill>>


    @GET("meal/get-meals")
    suspend fun getMeals(
        @Header("authorization") jwtToken: String,
    ): Response<MealResponse>

    @POST("meal/add-meal")
    suspend fun addMeal(
        @Header("authorization") jwtToken: String,
        @Body meal: Meal
    ): Response<Meal>

    @DELETE("meal/delete-meal")
    suspend fun deleteMeal(
        @Header("authorization") jwtToken: String,
        @Path("mealId") mealId: String
    ): Response<MealResponse>

    @GET("users")
    suspend fun getUser(
        @Header("authorization") jwtToken: String,
    ): Response<AccountResponse>

    @GET("user")
    suspend fun getUserInformation(
        @Header("authorization") jwtToken: String,
        @Path("userId") idAccount: String
    ): Response<AccountDetailResponse>

    @GET
    suspend fun get1Meal(
        @Header("authorization") jwtToken: String,
        @Url endpoint: String
    ): Response<Meal>

    @GET
    suspend fun searchMeals(
        @Header("authorization") jwtToken: String,
        @Url endpoint: String,
        @Query("mealname") mealname: String
    ): Response<ArrayList<Meal>>

    @POST("table")
    suspend fun addTable(
        @Header("authorization") jwtToken: String,
        @Body table: Table
    ): ApiResponse2<Table>

    @POST("ingredient/add")
    suspend fun addIngredient(
        @Header("authorization") jwtToken: String,
        @Body ingredient: Ingredient
    ): ApiResponse<Ingredient>

    @PUT
    suspend fun update1Meal(
        @Header("authorization") jwtToken: String,
        @Url endpoint: String,
        @Path("id") id: String,
        @Body inputModel: Meal
    ): Response<Meal>

    @DELETE
    suspend fun delete1Meal(
        @Header("authorization") jwtToken: String,
        @Url endpoint: String,
        @Path("id") id: String
    ): Response<Meal>

    @GET("meal-type/get-meal-types")
    suspend fun getMealType(
        @Header("authorization") jwtToken: String,
    ): Response<MealTypeResponse>
}