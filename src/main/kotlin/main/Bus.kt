package main

import com.google.gson.Gson
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer
import java.io.UnsupportedEncodingException

data class Bus(
    val averagePeopleCount: Int,
    val currentStation: String,
    val nextStation: String,
    val expectedMaxCapacity: Int,
    val id: String,
    val number: Int,
    val peopleCapacity: Int,
    val peopleCount: Int,
    val peopleExpectedAtNextStation: Int,
    val peopleExpectedToGetOffAtNextStation: Int,
    val time: String
)

class BusSerializer : Serializer<Bus> {
    override fun serialize(topic: String, data: Bus?): ByteArray? {
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

fun main() {
}
