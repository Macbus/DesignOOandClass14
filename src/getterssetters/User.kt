package getterssetters

import java.time.LocalDate

class User(
    email: String,
    password: String
) {
    private val dateNow = LocalDate.now()
    private val validGender = listOf('F', 'M')
    var isValid: Boolean = true
    var email: String = email
        set(value) {
            field = value.lowercase()
        }
    var password: String = password
        set(value) {
            field = if (value.length == 6) {
                value
            } else {
                isValid = false
                ""
            }
        }

    init {
        this.email = email
        this.password = password
    }

    constructor(
        email: String,
        password: String,
        birthdate: LocalDate,
        gender: Char
    ) : this(email, password) {

    }
    var birthdate : LocalDate = dateNow
        set(value) {
            // Mayor de 18 años
            var age = dateNow.year - value.year
            field = if(age >18){
                value
            }else{
                isValid = false
                dateNow
            }
        }

    var gender:Char = 'N'
        set(value) {
            field = if(validGender.contains(value)){
                value
            }else{
                isValid = false
                'N'
            }

        }

}