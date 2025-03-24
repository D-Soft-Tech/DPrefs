<p align="right">
  <a href="https://github.com/D-Soft-Tech/DPrefs/releases/latest" >
   <img src="https://img.shields.io/badge/version-1.0.6-green.svg">
  </a>
</p>

# DPrefs  

## About DPrefs
DPrefs is an Android library which takes care of all your key value shared preferences needs. This library handles everything for you and also encrypts your saved preferences thereby ensuring that your preferences data are securely saved and prevents information theft.  
You can save all kinds of values such as:  
* String
* Int
* Float
* Boolean
* Long
* Double and
* Custom object

## How to setup DPrefs in your project 
* Import the Library  

Import the library to your project by adding the library into your app level build.gradle file as shown below:

``` groovy
dependencies {
  implementation "com.github.D-Soft-Tech:DPrefs:$version"
}
```

Because the library is hosted on jitpack, You also need to add ``jitpack`` to your project if you haven't added it before: 
``` groovy
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```
* Initialize the library

Initialize the library in the application class, this will make the library have an application wide scope and make the preferences you saved with it to be available throughout the application. This is the recommended way  

\- Kotlin:
```  kt
class MyApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        DPrefs.initializeDPrefs(applicationContext)
    }
}
```
\- Java:  
```  java
public class MyApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DPrefs.INSTANCE.initializeDPrefs(getApplicationContext());
    }
}
```

If for any reason you want the preferences to only have an activity scope, then instead initialize the library in the ``onCreate()`` callback function of the activity as shown below:  

\- Kotlin:

``` kt
class MyActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DPrefs.initializeDPrefs(this)
  }
}
```
\- Java:
``` java
public class MyActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DPrefs.INSTANCE.initializeDPrefs(this);
  }
}
```
That is all you need to do in other to set up the library
<!-- ::: warning
*It is recommended to initialize the library in the application class*
::: -->

## How to use
* To save a value  
To save any value of any type you have to call ``DPrefs`` which is the instance of the library exposed to you by the library itself and call the method ``put\<DataTypeOfValue\>(key, value)`` where ``key`` is a string and ``value`` is what you want to save and is of type ``'DataTypeOfValue'``  

** Hence the Nomenclature the library follows is like so: **
> DPrefs::put<DataTypeOfValue>(key, value)  
> Note: The ``key`` must always be a ``String``
  
For example:
1. to save a string of value ``'String value to save'`` using the key ``'STRING_VALUE_KEY'``  

\- Kotlin:

``` kt
  val key = "STRING_VALUE_KEY"
  val value = "String value to save"
  DPrefs.putString(key, value)
```  
   \- Java:
``` java
  String key = "STRING_VALUE_KEY";
  String value = "String value to save";
  DPrefs.INSTANCE.putString(key, value);
```
  

2. to save an int value ``12345`` using the key ``'INT_VALUE_KEY'``

\- Kotlin:
``` kt
  val key = "INT_VALUE_KEY"
  val value = 12345
  DPrefs.putInt(key, value)
```  
   \- Java:
``` java
  String key = "INT_VALUE_KEY";
  int value = 12345;
  DPrefs.INSTANCE.putInt(key, value);
```

  The above two examples show the convention that saving a preference using the ``DPrefs`` library follows. The only exception to this is putting an object and this is as shown below:  
  
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
> The ``UserInfo`` data class can be modelled from the above ``json`` payload. like so:

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
```

* <b><em>Sample Usage ``Kotlin``</em></b>
``` kt
// Instantiate an object of UserInfo
val userA = UserInfo("Adebayo", "Oloyede", 31, "Oyo state, Nigeria", 3.3456987, 7.432765, true)

// save userA as preference
val objectKey = "OBJECT_VALUE_KEY"

DPrefs.putObject(objectKey, userA)
```
 
* <b><em>Sample Usage ``Java``</em></b>
``` java
 // Instantiate an object of UserInfo
 UserInfo userA = new UserInfo("Adebayo", "Oloyede", 31, "Oyo state, Nigeria", 3.3456987, 7.432765, true);

 // save userA as preference
 String objectKey = "OBJECT_VALUE_KEY";
 DPrefs.INSTANCE.putObject(objectKey, userA);
```

* Fetching a preference value
To get a particular preference value from the library, you only need to supply the ``key`` with which you saved the preference value and a ``default value``. This will return the saved value or the ``default value`` provided. In the event that the no value exists for the ``key`` provided and no ``default value`` is supplied, a ``default value`` provided by the library is returned.

For example:
1. To get a ``String``

   \- Kotlin:
   ``` kt
   val key = "STRING_VALUE_KEY"
   val defaultValue = "NO_VALUE"
   val savedString = DPrefs.getString(key, defaultValue)
   ```
   
   \- Java:
   ``` java
   String key = "STRING_VALUE_KEY";
   String defaultValue = "NO_VALUE";
   String savedString = DPrefs.INSTANCE.getString(key, defaultValue);
   ```


2. To get a ``Int``

   \- Kotlin:
   ``` kt
   val key = "INT_VALUE_KEY"
   val defaultValue = 10
   val savedInt = DPrefs.getInt(key, defaultValue)
   ```

   \- Java:
   ``` java
   String key = "INT_VALUE_KEY";
   int defaultValue = 10;
   int savedInt = DPrefs.INSTANCE.getInt(key, defaultValue);
   ```
  The above two examples show the convention for getting a preference using the ``DPrefs`` library. The next item shows how to fetch an object:    
  

3. to get an object of type ``UserInfo`` saved above

   \- Kotlin:
   ``` kt
   val key = "OBJECT_VALUE_KEY"
   val savedObject = DPrefs.getObject(key, UserInfo::class)
   ```

   \- Java:
   ``` java
   String key = "OBJECT_VALUE_KEY";
   UserInfo savedObject = DPrefs.INSTANCE.getObject(key, UserInfo.class);
   ```

> Kindly check the ``DPrefsDefaultValue`` section for the full list of the default value that can be returned by the library.


* Removing a preference value
To remove a saved preference value, you only need to pass the key. The example below how to remove a string value that was saved using the ``key`` ``'STRING_VALUE_KEY'``. The same approach can be followed for int, boolean, object etc.

Sample code:

\- Kotlin:
``` kt
val key = "STRING_VALUE_KEY"
DPrefs.removePref(key)
```

\- Java:
``` java
String key = "STRING_VALUE_KEY";
DPrefs.INSTANCE.removePref(key);
```

* To check whether a ``key`` already exist
Call ``doesKeyExists`` and pass it the ``key``. This will return a ``Boolean`` that tells whether the ``key`` exist or not. See example below:

\- Kotlin:
``` kt
val key = "STRING_VALUE_KEY"
val keyExist = DPrefs.doesKeyExists(key)

if(keyExist) println("True") else println("False")
```

\- Java:
``` java
String key = "STRING_VALUE_KEY";
boolean keyExist = DPrefs.INSTANCE.doesKeyExists(key);

if(keyExist) {
   System.out.println("True");
} else {
   System.out.println("False");
}
```

* Clearing all the Preferences
To remove all the preference that has been saved all at once, call ``clearAllPrefs`` on the instance of the library as shown in the sample code below:

Sample code for clearing the preferences:

\- Kotlin:
``` kt
DPrefs.clearAllPrefs()
```

\- Java:
``` java
DPrefs.INSTANCE.clearAllPrefs();
```

## IMPORTANT
When using DPrefs in a release build, add the following to your proguard-rules.pro file
```
-keep class com.google.crypto.tink.proto.** { *; }
-keep class com.google.crypto.tink.shaded.protobuf.** { *; }
-keep class androidx.security.** { *; }
-keepclassmembers class androidx.security.** { *; }
```

## Exceptions
There are two exceptions that can be thrown by the library which are:  
1. ``DPrefsNotInitializedException``  

This is thrown when you try to use the library without first initializing it, to resolve this, go to your application class to initialize the library as shown above.  

2. ``DPrefsKeyAlreadyExistsException``  

This is thrown when you try save a preference value with a key that already exist. To resolve this, just use another set of character strings.

## DPrefsDefaultValue
This is an enum which represent the default value that the library returns in the case that no value is found and no ``defaultValue`` is set. There are various instances of it as shown in the list below:
1. * DPrefsDefaultValue.DEFAULT_VALUE_STRING
     
   This is a default ``String`` that can be returned by the library and it's value is an empty string ``""``
2. * DPrefsDefaultValue.DEFAULT_VALUE_INT
     
   This is a default ``Int`` that can be returned by the library and it's value is ``-1111111``
3. * DPrefsDefaultValue.DEFAULT_VALUE_BOOLEAN
     
   This is a default ``Boolean`` that can be returned by the library and it's value is ``false``
4. * DPrefsDefaultValue.DEFAULT_VALUE_FLOAT
     
   This is a default ``float`` that can be returned by the library and it's value is ``-0.1000001F``
5. * DPrefsDefaultValue.DEFAULT_VALUE_LONG
     
   This is a default ``Long`` that can be returned by the library and it's value is ``-1111111L``
6. * DPrefsDefaultValue.DEFAULT_VALUE_DOUBLE
     
   This is a default ``Double`` that can be returned by the library and it's value is ``-0.1000001``



   
