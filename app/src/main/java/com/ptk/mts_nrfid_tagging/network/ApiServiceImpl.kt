package com.ptk.mts_nrfid_tagging.network


import io.ktor.client.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ApiServiceImpl @Inject constructor(
    private val client: HttpClient,
) : ApiService {

    /*  override suspend fun login(sapID: String): LoginResponseModel = client.post {
          url(BASE_URL + APIRoutes.login)
          contentType(ContentType.Application.Json)
          parameter("sapId", sapID)
      }

      override suspend fun getFilteredList(
          token: String,
          grNumber: String,
          storBin: String,
          material: String
      ): FilteredListResponseModel = client.get {
          url(BASE_URL + APIRoutes.getFilteredList)
          header("Authorization", "Bearer $token")
          contentType(ContentType.Application.Json)
          parameter("grNumber", grNumber)
          parameter("storBin", storBin)
          parameter("material", material)
      }

      override suspend fun getStoreBinList(
          token: String,
          material: String,
          grNumber: String
      ): BinListResponseModel = client.get {
          url(BASE_URL + APIRoutes.getStoreBinList)
          header("Authorization", "Bearer $token")
          parameter("material", material)
          parameter("grNumber", grNumber)
          contentType(ContentType.Application.Json)
      }

      override suspend fun getGRNumberList(
          token: String,
          storBin: String,
          material: String
      ): GRNumberListResponseModel = client.get {
          url(BASE_URL + APIRoutes.getGRNumberList)
          header("Authorization", "Bearer $token")
          parameter("storeBin", storBin)
          parameter("material", material)
          contentType(ContentType.Application.Json)
      }

      override suspend fun getMaterialList(
          token: String,
          storBin: String,
          grNumber: String
      ): MaterialListResponseModel = client.get {
          url(BASE_URL + APIRoutes.getMaterialList)
          header("Authorization", "Bearer $token")
          parameter("storeBin", storBin)
          parameter("grNumber", grNumber)
          contentType(ContentType.Application.Json)
      }

      override suspend fun getDetailInfo(token: String, id: Int): TaggingItemDetailInfoResponseModel =
          client.get {
              url(BASE_URL + APIRoutes.getDetailInfo)
              header("Authorization", "Bearer $token")
              contentType(ContentType.Application.Json)
              parameter("id", id)
          }

      override suspend fun saveTagList(
          token: String,
          body: SaveTagRequestModel
      ): SaveTagResponseModel =
          client.post {
              url(BASE_URL + APIRoutes.saveTagList)
              header("Authorization", "Bearer $token")
              contentType(ContentType.Application.Json)
              this.body = body
          }

      override suspend fun checkRfidExist(
          token: String,
          params: ArrayList<String>
      ): CheckRfidResponseModel? = client.get {
          url(BASE_URL + APIRoutes.checkRfidExist)
          header("Authorization", "Bearer $token")
          contentType(ContentType.Application.Json)
          params.forEach {
              parameter("RFIDTagList", it)
          }

      }

      override suspend fun healthCheck(): Boolean = client.get {
          url(BASE_URL + APIRoutes.healthCheck)
      }*/
}