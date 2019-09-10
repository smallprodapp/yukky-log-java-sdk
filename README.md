# Yukky Log Java SDk

Easy to use SDK to send log to Yukky Log !

For more informations visit https://log.yukkyapp.com/doc

## Installation

Download the **jar** file named **yukky-log-java-sdk.jar** and import it in your project.

You might also need the package **Gson** available here : https://search.maven.org/artifact/com.google.code.gson/gson/2.8.5/jar

**That's it !**

## Initialisation

Somewhere in your code you should add this :

```
import com.yukkyapp.*;
...
YukkyLog.init("<appkey>", "<appsecret>");
```

This will initialize the SDK.

You can add a third parameter to specify if you want the debug mode.

## Send some logs

### The Log class

To send a Log, you need to create it first.

To do that, you must create a Log object like this :

```
new Log("Java Test", new String[]{"Java", "Test"}, "Test java desc", null);
```

The first parameter is the log name, the second is an array of tags, the third is a description and the last one is some infos you want to send, it must be an object.

If you want to create your own log type (not error, warning or info), you can create a FullLog object like this :

```
new FullLog("Java Test", new String[]{"Java", "Test"}, "Test java desc", null, "my type");
```

The parameters are the same as Log but you must add another one which is the name of your custom type.

### Error

To send an error log simply add this line :

```
YukkyLog.error(new Log("Java Test", new String[]{"Java", "Test"}, "Test java desc", null));
```

### Warning

To send a warning log simply add this line :

```
YukkyLog.warning(new Log("Java Test", new String[]{"Java", "Test"}, "Test java desc", null));
```

### Info

To send an info log simply add this line :

```
YukkyLog.info(new Log("Java Test", new String[]{"Java", "Test"}, "Test java desc", null));
```

### Custom

To send a custom log simply add this line :

```
YukkyLog.custom(new FullLog("Java Test", new String[]{"Java", "Test"}, "Test java desc", null, "my type"));
```
