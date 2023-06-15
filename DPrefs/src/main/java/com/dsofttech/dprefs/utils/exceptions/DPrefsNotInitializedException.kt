package com.dsofttech.dprefs.utils.exceptions

/**
 * Thrown when DPrefs Library has not been initialized.
 * How to resolve - kindly go to your application class to initialize it.
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 * @see [DPrefs.initializeDPrefs] for more.
 *
 * @see [https://www.linkedin.com/in/adebayo-oloyede]
 * @see [https://github.com/D-Soft-Tech]
 * */
internal class DPrefsNotInitializedException :
    DPrefsException("DPrefs Library has not been initialized, kindly go to your application class to initialize it by calling DPrefs::initializeDPrefs")
