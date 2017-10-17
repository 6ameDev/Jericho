> They say that the best weapon is the one that you never have to fire.   
> I respectfully disagree. I prefer the weapon you only have to fire…once!
> **_-Tony Stark_**

# Jericho

Inspired from the Jericho Missile in the movie Iron Man (2008), Jericho sends events to all the integrated analytics tools.
Jericho makes adding(removing) new analytics tools to your existing projects a lot easier.

![alt text](https://github.com/6ameDev/resources/raw/master/Jericho/the_jericho.gif "The Jericho")

## Install
```
compile ''
```

## Usage
```java
Map<String, Object> attributesMap;
Map<String, Object> userPropertiesMap;

// tracking event
jericho.track("event name", attributesMap);

// tracking event with location
jericho.track("event name", attributesMap, location);

// setting a single user property
jericho.setUserProperty("name", "John");

// setting user properties
jericho.setUserProperties(userPropertiesMap);
```
Check out the sample app in [`sample/`] to see it in action.   
Find the different missiles you can arm Jericho with, [here].

[here]: https://github.com/6ameDev/Jericho#usage 
[`sample/`]: https://github.com/6ameDev/Jericho/tree/master/sample

## License

    Copyright (C) 2017 Sumit Das

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
