# DPrefs  

### About DPrefs
DPrefs is an Android library which takes care of all your key value shared preferences needs. This library handles everything for you and also encrypts your saved preferences thereby ensuring that your preferences data are securely saved and prevents information theft.  
You can save all kinds of values such as:  
* String
* Int
* Float
* Boolean
* Long
* Double and even
* Custom object

### How to setup DPrefs in your project
* Import the Library  

Import the library to your project by adding the library into your app level build.gradle file as shown below:

```
dependencies {
  implementation 'com.github.D-Soft-Tech:DPrefs:$version'
}
```

Because the library is hosted on jitpack, You also need to add ``jitpack`` to your project if you haven't added it before: 
```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```
* Initialize the library

Initialize the library in the application class, this will make the library have an application wide scope and make the preferences you saved with it to be available throughout the application. This is the recommended way

```  kt
class MyApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        DPrefs.initializeDPrefs(applicationContext)
    }
}
```

If for any reason you want the preferences to only have an activity scope, then instead initialize the library in the ``onCreate()`` callback function of the activity as shown below:
``` kt
class MyActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DPrefs.initializeDPrefs(this)
  }
}
```
That is all you need to do in other to set up the library
<!-- ::: warning
*It is recommended to initialize the library in the application class*
::: -->

### How to use
* To save a value  
To save any value of any type you have to call ``DPrefs`` which is the instance of the library exposed to you by the library itself and call the method ``putDataTypeOfValue(key, value)`` where ``key`` is a string and ``value`` is what you want to save and is of type ``'DataTypeOfValue'``  

**Hence the Nomenclature the libray follows is like so: **
> DPrefs::put<DataTypeOfValue>(key, value)  
> Note: The ``key`` must always be a ``String``
  
For example:
1. to save a string of value ``'String value to save'`` using the key ``'STRING_VALUE_KEY'`` 
``` kt
  val key = "STRING_VALUE_KEY"
  val value = "String value to save"
  DPrefs.putString(key, value)
```
  
2. to save an int value ``12345`` using the key ``'INT_VALUE_KEY'`` 
``` kt
  val key = "INT_VALUE_KEY"
  val value = 12345
  DPrefs.putInt(key, value)
```
  The above two examples show the convention that saving a preference using the ``DPrefs`` library follows. The only exception to this is puting an object and this is as shown below: 
3. to save an object of type UserInfo shown in the json payload below:

``` json
{
 "firstName": "Adebayo",
 "lastName": "Oloyede",
 "age": 31,
 "address": "Oyo state, Nigeria",
 "latitude": 3.3456987,
 "longitude": 7.432765,
 "isLoggedIn": true
}
```

The ``UserInfo`` data class can be modelled from the above ``json`` payload. like so:
``` kt
// UserInfo Model
data class UserInfo(
  val firstName: String,
  val lastName: String,
  val age: Int,
  val address: String,
  val latitude: Double,
  val longitude: Double,
  val isLoggedIn: Boolean
)

// Instantiate an object of UserInfo
val userA = UserInfo("Adebayo", "Oloyede", 31, "Oyo state, Nigeria", 3.3456987, 7.432765, true)

// save userA as preference
val objectKey = "OBJECT_VALUE_KEY"

DPrefs.putObject(objectKey, userA)
```
