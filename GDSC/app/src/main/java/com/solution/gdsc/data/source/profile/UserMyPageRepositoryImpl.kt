package com.solution.gdsc.data.source.profile

import com.solution.gdsc.domain.model.request.UpdateSavedRecordReq
import com.solution.gdsc.domain.model.request.UpdateUserInfoRequest
import com.solution.gdsc.domain.model.request.VolunteerRegistrationReq
import com.solution.gdsc.domain.model.response.DefaultResponse
import com.solution.gdsc.domain.model.response.DeleteSavedRecordResponse
import com.solution.gdsc.domain.model.response.SavedRecordResponse
import com.solution.gdsc.domain.model.response.UpdateSavedRecordResponse
import com.solution.gdsc.domain.model.response.UpdateUserInfoResponse
import com.solution.gdsc.domain.model.response.UserInfoResponse
import com.solution.gdsc.domain.model.response.UserRecordResponse
import com.solution.gdsc.domain.model.response.VolunteerRegistrationResponse
import com.solution.gdsc.domain.repository.UserMyPageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserMyPageRepositoryImpl @Inject constructor(
    private val dataSource: UserMyPageDatasource
) : UserMyPageRepository {
    override suspend fun logout(): DefaultResponse = dataSource.logout()
    override suspend fun getUserInfo(): Flow<UserInfoResponse> = dataSource.getUserInfo()
    override suspend fun updateUserInfo(updateUserInfoRequest: UpdateUserInfoRequest): UpdateUserInfoResponse = dataSource.updateUserInfo(updateUserInfoRequest)
    override suspend fun withdraw(): DefaultResponse = dataSource.withdraw()
    override suspend fun getUserRecord(): Flow<UserRecordResponse> = dataSource.getUserRecord()
    override suspend fun putVolunteerUser(volunteerRegistrationReq: VolunteerRegistrationReq): VolunteerRegistrationResponse = dataSource.putVolunteerUser(volunteerRegistrationReq)
    override suspend fun getSavedRecordInfo(recordId: Long): Flow<SavedRecordResponse> = dataSource.getRecordInfo(recordId)
    override suspend fun deleteSavedRecord(recordId: Long): Flow<DeleteSavedRecordResponse> = dataSource.deleteSavedRecord(recordId)
    override suspend fun updateSavedRecord(recordId: Long, updateSavedRecordReq: UpdateSavedRecordReq): Flow<UpdateSavedRecordResponse> = dataSource.updateSavedRecord(recordId, updateSavedRecordReq)
}
