# Module DPrefs
## Description
This Library enables you to save key value preferences in a secure fashion.
The data you save using this library are all encrypted.
You can save information such as:
+ Strings
+ Float
+ Int
+ Boolean
+ Long
+ Double
+ Object
# Package com.dsofttech.dPrefs.domain
This package contains two classes: 
1. DPrefsManagerContract
    This interface contains the possible operations that can be performed by this library.
2. DPrefsManager
    This is the implementation class for the above interface, DPrefsManagerContract
# Package Default Values
This package contains 1 enum class, DPrefsDefaultValue which is the default values that can be returned by this library.
# Package com.desofttech.dprefs.utils
This package contains a package, exceptions, and 2 objects com.dsofttech.dprefs.utils.DPrefsConstants and DPrefs
DPrefs: This is the public object which also implements DPrefsManagerContract but delegates to an instance of DPrefsManager.
 This is the instance of the library that you interact with.
com.dsofttech.dprefs.utils.DPrefsConstants: This contains the file name that the generated file will have.
# Package Exceptions
This package contains all the exceptions that can be thrown by the library
