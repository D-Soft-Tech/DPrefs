package com.dsofttech.dprefs.utils.exceptions

/**
 * Thrown when you the key supplied is an empty string.
 *
 * * To resolve: __Change the key to a unique set of characters (String)__
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
class DPrefsKeyCanNotBeEmptyException :
    DPrefsException("Key can not be empty exist, the key supplied is empty. Kindly use a unique set of string characters")
