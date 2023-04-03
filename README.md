# music-intervals-calculator
In music theory, [an interval](https://en.wikipedia.org/wiki/Interval_(music)) is a distance between two notes. This distance is specified using a letter and a number.

The number of an interval is the number of letter names or [staff positions](https://en.wikipedia.org/wiki/Staff_position) (lines and spaces) it contains, including the positions of both notes forming the interval. For instance, the interval C–G is a fifth (denoted P5) because the notes from C to the G above it contain five letter names (C, D, E, F, G) and occupy five consecutive staff positions, including the positions of C and G. The interval from A to A contains 8 notes (A B C D E F G A) and is called P8. We will call this number a **diatonic degree** (please note: the term 'degree' we are using here may not correspond to the actual term in music)

Music interval calculator can:
- find a second note for the chosen interval
- find an interval given two notes

Requirements:
**intervalConstruction**
- The function 'intervalConstruction' must take an array of strings as input and return a string.
- An array contains three or two elements.
- The first element in an array is an interval name, the second is a starting note, and the third indicates whether an interval is ascending or descending.
- If there is no third element in an array, the building order is ascending by default.
- The function should return a string containing a note name.
- Only the following note names are allowed in a return string: 
Cbb Cb C C# C## Dbb Db D D# D## Ebb Eb E E# E## Fbb Fb F F# F## Gbb Gb G G# G## Abb Ab A A# A## Bbb Bb B B# B## 
- If there are more or fewer elements in the input array, an exception should be thrown: "Illegal number of elements in input array"

Convention: ['a', 'b'] here means an array of strings

**intervalIdentification** <br>
- The function 'intervalIdentification' must take an array of strings as input and return a string.
- An array contains three or two elements.
- The first element is the first note in the interval, the second element is the last note in the interval, the third indicates whether an interval is ascending or descending.
- If there is no third element in an array, the interval is considered ascending by default.
- The function should return a string - name of the interval.
- Only the following intervals are allowed in a return string: 
m2 M2 m3 M3 P4 P5 m6 M6 m7 M7 P8
- If the interval does not fit a description, an exception should be thrown: "Cannot identify the interval".

Convention: ['a', 'b'] here means an array of strings
