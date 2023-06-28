package Exceptions
import DPrefs Instance.DPrefs

/**
 * Thrown when you try to use DPrefs Library when it has not first been initialized.
 * - To resolve: Go to your application class to initialize it by calling [InitializeDPrefs][DPrefs.initializeDPrefs]
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
class DPrefsNotInitializedException :
    DPrefsException("DPrefs Library has not been initialized, kindly go to your application class to initialize it by calling DPrefs::initializeDPrefs")
