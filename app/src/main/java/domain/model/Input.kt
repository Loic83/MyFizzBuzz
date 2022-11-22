package domain.model

data class Input(
    val str1 : String,
    val str2 : String,
    val limit : Int,
    val int1 : Int,
    val int2 : Int
)

class InvalidInputException(message: String): Exception(message)
