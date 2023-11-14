package com.example.util

import com.example.feature.applications.module.ApplicationResponse
import io.ktor.http.*
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass


@Serializable
abstract class BaseResponse<out T>

@Serializable
@SerialName("SuccessResponse")
data class SuccessResponse<out T>(
    @Serializable(with = StatusCodeSerializer::class)
    @Contextual
    val statusCode: HttpStatusCode,
    val data: T? = null
//    val message: String? = null
) : BaseResponse<T>()

@Serializable
@SerialName("UnSuccessResponse")
data class UnSuccessResponse<out T>(
    @Serializable(with = StatusCodeSerializer::class)
    @Contextual
    val statusCode: HttpStatusCode,
    val exception: T? = null
) : BaseResponse<T>()

val responseModule = SerializersModule {
    polymorphic(BaseResponse::class) {
        subclass(SuccessResponse.serializer(PolymorphicSerializer(Any::class)))
        subclass(UnSuccessResponse.serializer(PolymorphicSerializer(Any::class)))
    }
}

val applicationInfoModule = SerializersModule {
        polymorphic(Any::class) {
            subclass(ApplicationResponse::class)
        }
    }


val formatApplicationsInfo = Json {
    serializersModule = responseModule + applicationInfoModule
}


class StatusCodeSerializer : KSerializer<HttpStatusCode> {
    override fun deserialize(decoder: Decoder): HttpStatusCode {
        return HttpStatusCode(decoder.decodeInt(), "")
    }

    override fun serialize(encoder: Encoder, value: HttpStatusCode) {
        encoder.encodeInt(value.value)
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("HttpStatusCode", PrimitiveKind.INT)
}