package com.dsofttech.dprefs.utils.exceptions

/**
 * Thrown when the key supplied already exists.
 * How to resolve - kindly change the key to a new unique set of characters (String).
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 *
 * @see [https://www.linkedin.com/in/adebayo-oloyede]
 * @see [https://github.com/D-Soft-Tech]
 * */
internal class DPrefsKeyAlreadyExistsException :
    DPrefsException("Key already exist, kindly change the key to a new unique set of character string")
