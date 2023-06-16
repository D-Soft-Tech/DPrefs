package com.dsofttech.dprefs.utils.exceptions

/**
 * Thrown when you try to use DPrefs Library when it has not first been initialized.
 * - To resolve: Go to your application class to initialize it.
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 * @see [DPrefsException]
 *
 * @see [https://www.linkedin.com/in/adebayo-oloyede]
 * @see [https://github.com/D-Soft-Tech]
 * */
class DPrefsNotInitializedException :
    DPrefsException("DPrefs Library has not been initialized, kindly go to your application class to initialize it by calling DPrefs::initializeDPrefs")
