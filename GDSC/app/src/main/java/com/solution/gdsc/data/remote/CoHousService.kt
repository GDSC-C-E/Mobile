package com.solution.gdsc.data.remote

import com.solution.gdsc.domain.model.request.UpdateUserInfoRequest
import com.solution.gdsc.domain.model.request.VolunteerRegistrationReq
import com.solution.gdsc.domain.model.response.DefaultResponse
import com.solution.gdsc.domain.model.response.UpdateUserInfoResponse
import com.solution.gdsc.domain.model.response.UserInfoResponse
import com.solution.gdsc.domain.model.response.UserRecordResponse
import com.solution.gdsc.domain.model.response.VolunteerRegistrationResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part

interface CoHousService {
    // Profile
    @DELETE("/auth/logout")
    suspend fun logout(): DefaultResponse

    @GET("/my-page")
    suspend fun getUserInfo(): UserInfoResponse

    @PATCH("/my-page/info")
    suspend fun updateUserInfo(@Body updateUserInfoRequest: UpdateUserInfoRequest): UpdateUserInfoResponse

    @DELETE("my-page/withdraw")
    suspend fun withdraw(): DefaultResponse

    @GET("/my-page/records")
    suspend fun getUserRecord(): UserRecordResponse

    @PUT("/volunteers/users")
    suspend fun putVolunteerUser(@Body volunteerRegistrationReq: VolunteerRegistrationReq): VolunteerRegistrationResponse

    // Home
    @Multipart
    @POST("/records")
    suspend fun saveRecord(
        @Part image: MultipartBody.Part,
        @Part("title") title: RequestBody,
        @Part("detail") detail: RequestBody,
        @Part("grade") grade: RequestBody,
        @Part("category") category: RequestBody
    ): DefaultResponse
}