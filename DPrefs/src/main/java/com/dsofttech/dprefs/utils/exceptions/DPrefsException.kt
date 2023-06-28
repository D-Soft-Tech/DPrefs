package Exceptions

/**
 * Defines the exceptions that can be thrown by the library.<br />
 * Subclasses include: [DPrefsNotInitializedException] and [DPrefsKeyAlreadyExistsException]
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 *
 * [Github](https://github.com/D-Soft-Tech/DPrefs)
 *
 * [LinkedIn](https://www.linkedin.com/in/adebayo-oloyede/ "Adebayo Oloyede, Android Engineer")
 *
 * @param [message] The cause of the exception and how to resolve it
 * @see [DPrefsNotInitializedException]
 * @see [DPrefsKeyAlreadyExistsException]
 * */
open class DPrefsException(message: String) : Exception(message)
