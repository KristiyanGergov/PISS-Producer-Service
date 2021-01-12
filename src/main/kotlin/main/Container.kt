package main

data class Container(
    val bus: Bus,
    val id: String,
    val people_expected_at_next_station: Int,
    val people_expected_to_get_off_at_next_station: Int,
    val station: Station,
    val time: String,
    val time_by_schedule: String
)