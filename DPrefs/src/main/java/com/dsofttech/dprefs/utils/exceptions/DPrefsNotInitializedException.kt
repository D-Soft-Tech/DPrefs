package com.dsofttech.dprefs.utils.exceptions
import com.dsofttech.dprefs.utils.DPrefs

/**
 * Thrown when you try to use DPrefs Library when it has not first been initialized.
 * - To resolve: Go to your application class to initialize it by calling [InitializeDPrefs][DPrefs.initializeDPrefs]
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 *
 * [LinkedIn Profile](https://www.linkedin.com/in/adebayo-oloyede)
 *
 * [Github Profile](https://github.com/D-Soft-Tech)
 *
 * @see [DPrefsException]
 * */
class DPrefsNotInitializedException :
    DPrefsException("DPrefs Library has not been initialized, kindly go to your application class to initialize it by calling DPrefs::initializeDPrefs")
