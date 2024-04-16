//Написать программу, которая обрабатывает введённые пользователем в консоль команды:
//exit
//help
//add <Имя> phone <Номер телефона>
//add <Имя> email <Адрес электронной почты>
//
//После выполнения команды, кроме команды exit, программа ждёт следующую команду.
import java.util.Scanner

fun menu(): Int {
    println()
    println(
        "Выберите действие:\n" +
                "1 - add <Имя> phone <Номер телефона>\n" +
                "2 - add <Имя> email <Адрес электронной почты>\n" +
                "3 - help\n" +
                "4 - exit"
    )
    val scan = Scanner(System.`in`)
    val data = scan.nextInt()
    return data
}

fun addPhone(): String {
    print("Введите имя ")
    var name = readlnOrNull() ?: return "null"
    print("Введите номер телефона в форомате +XXXXXXXXXXX: ")
    var phone = readlnOrNull() ?: return "null"
    if (phone.length < 11) {
        println("Invalid phone")
        addPhone()
    }

    val part = phone.split('+')
    if (part[1].toDoubleOrNull() == null) {
        println ("Invalid phone")
    }
    return ("Name $name phone $phone is added.")
}

fun addEmail(): String {
    print("Введите имя ")
    var name = readlnOrNull() ?: return "null"
    print("Введите email: ")
    var email = readlnOrNull() ?: return "null"
    val parts = email.split('@', '.')
    if (parts.size != 3) {
        println("Invalid email")
        addEmail()

    }
    return ("Name $name email $email is added.")
}

fun help() {
    println("Stay on the line, your call is very important to us.")
}

fun exit() {
    println("Goodbay!")
}

fun start() {
    val a: Int = menu()
    when (a) {
        1 -> println(addPhone())
        2 -> println(addEmail())
        3 -> help()
        4 -> exit()
    }
    if (a != 4){
        start()
    }
}


fun main() {
    start()
}