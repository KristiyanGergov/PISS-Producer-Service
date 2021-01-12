package main

import com.google.gson.Gson
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer
import java.io.UnsupportedEncodingException

class ContainerSerializer : Serializer<Container> {
    override fun serialize(topic: String, data: Container?): ByteArray? {
        return try {
            data?.let {
                return Gson().toJson(data).toByteArray()
            }
            null
        } catch (e: UnsupportedEncodingException) {
            throw SerializationException("Error when serializing string to byte[] due to unsupported encoding")
        }
    }
}