package com.dsofttech.dprefs.utils.exceptions

/**
 * Defines the exceptions that can be thrown by the library. <br />
 * Subclasses include: [DPrefsNotInitializedException] and [DPrefsKeyAlreadyExistsException]
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 *
 * @param [message] The cause of the exception and how to resolve it
 * @see [DPrefsNotInitializedException]
 * @see [DPrefsKeyAlreadyExistsException]
 * @see [https://www.linkedin.com/in/adebayo-oloyede]
 * @see [https://github.com/D-Soft-Tech] for more about the author.
 * */
open class DPrefsException(message: String) : Exception(message)
