# Kotlin Platform Collections

A set of Kotlin collections for use as implementation details inside other types.
These collections try and map to the most efficient representation on each platform.
They do not conform to Kotlin's standard collection interfaces by default.

|             | [`PlatformList<E>`][1] | [`PlatformSet<E>`][2]     | [`PlatformMap<K, V>`][3]   |
|------------:|------------------------|---------------------------|----------------------------|
|          JS | [`Array`][4]           | [`Set`][5]                | [`Map`][6]                 |
|      Darwin | [`NSMutableArray`][7]  | [`NSMutableSet`][8]       | [`NSMutableDictionary`][9] |
| JVM/Android | [`j.u.ArrayList`][10]  | [`j.u.LinkedHashSet`][11] | [`j.u.LinkedHashMap`][12]  |
|      Others | [`k.c.ArrayList`][13]  | [`k.c.LinkedHashSet`][14] | [`k.c.LinkedHashMap`][15]  |

 [1]: https://jakewharton.github.io/platform-collections/docs/latest/platform-collections/com.jakewharton.platformcollections/-platform-list/index.html
 [2]: https://jakewharton.github.io/platform-collections/docs/latest/platform-collections/com.jakewharton.platformcollections/-platform-set/index.html
 [3]: https://jakewharton.github.io/platform-collections/docs/latest/platform-collections/com.jakewharton.platformcollections/-platform-map/index.html
 [4]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array
 [5]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set
 [6]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map
 [7]: https://developer.apple.com/documentation/foundation/nsmutablearray
 [8]: https://developer.apple.com/documentation/foundation/nsmutableset
 [9]: https://developer.apple.com/documentation/foundation/nsmutabledictionary
 [10]: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 [11]: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashSet.html
 [12]: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
 [13]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/
 [14]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-linked-hash-set/
 [15]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-linked-hash-map/

Experimental, and all that...


# License

    Copyright 2023 Jake Wharton

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
