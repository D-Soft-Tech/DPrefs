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

### How to Use
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
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

