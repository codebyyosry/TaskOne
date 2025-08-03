package com.yosry.dev.taskone.data.remote

import com.yosry.dev.taskone.data.remote.dto.AreaListResponse
import com.yosry.dev.taskone.data.remote.dto.CategoriesResponse
import com.yosry.dev.taskone.data.remote.dto.CategoryListResponse
import com.yosry.dev.taskone.data.remote.dto.MealsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {

    @GET("categories.php")
    suspend fun getCategories(): Response<CategoriesResponse>

    @GET("search.php")
    suspend fun searchMealsByName(@Query("s") mealName: String): Response<MealsResponse>

    @GET("lookup.php")
    suspend fun lookupMealById(@Query("i") mealId: String): Response<MealsResponse>

    @GET("list.php")
    suspend fun listCategories(@Query("c") list: String = "list"): Response<CategoryListResponse>

    @GET("list.php")
    suspend fun listAreas(@Query("a") list: String = "list"): Response<AreaListResponse>

    @GET("filter.php")
    suspend fun filterByCategory(@Query("c") categoryName: String): Response<MealsResponse>

    @GET("filter.php")
    suspend fun filterByArea(@Query("a") areaName: String): Response<MealsResponse>
}

// The image URL (e.g., /images/media/meals/llcbn01574260722.jpg/medium)
// is typically not handled by Retrofit as an API endpoint.
// You would use an image loading library (Coil, Glide, Picasso)
// and construct the full image URL (e.g., "https://www.themealdb.com/images/media/meals/your_image.jpg")
// directly in your UI or data mapping logic.
