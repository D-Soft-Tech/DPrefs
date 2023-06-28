package com.dsofttech.dprefs.utils.exceptions

/**
 * Thrown when try to put a preference value with a key that already exists.
 *
 * * To resolve: __Change the key to a new unique set of characters (String)__
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 *
 * [Github](https://github.com/D-Soft-Tech/DPrefs)
 *
 * [LinkedIn](https://www.linkedin.com/in/adebayo-oloyede/ "Adebayo Oloyede, Android Engineer")
 *
 * @see [DPrefsException]
 * */
class DPrefsKeyAlreadyExistsException :
    DPrefsException("Key already exist, kindly change the key to a new unique set of character string")
