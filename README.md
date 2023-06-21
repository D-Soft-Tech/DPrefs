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
:::  info
 It is recommended to initialize the library in the application class
:::

