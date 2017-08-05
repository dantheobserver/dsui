# DSUI
Displays arbitrary data as a read-only, form-based UI. DSUI stands for "Data Structure User Interface".

## Status
- Serious toy project

## Motivation

1. Being tired of writing UI code.

1. Avoiding this:  
![Data in Cider](img/data_cider.png)

1. And getting this instead:  
![Data in DSUI](img/data_DSUI.png)

## Features
Displays:
- maps as forms, nested data structures a tabbed panes
- sequential data (including vectors, lists and sets) as vertical tabbed panes with (0..n) as a title
- lists containing only scalar values as JLists
- Matrices (vector of vectors) as tables
- Lists of maps, that have the same keyset and contain scalar values only, as tables
- conformed data (labeled data) returned by specs as vertical tabbed panes with the label as a title. Thus DSUI can be also used to see how things conformed when writing specs

Does not support:
- a single scalar value

Not suited for:
- graph-like data

## How it works
DSUI uses clojure.spec to "parse" an arbitrary data structure. The conformed data is used to generate the swing UI by calling a multimethod that polymorphically creates different types of UI elements.

A more detailed explanation can be found <a href="https://feierabendprojekte.wordpress.com/2016/09/11/generating-ui-for-arbitrarily-nested-data-structures/">here</a> and <a href="https://feierabendprojekte.wordpress.com/2017/06/12/conforming-conformed-data/">here</a>

## Next Steps
- Migrate to fn-fx
- Make displaying conformed data consume less space, e.g. vertical text in tab titles

## Distant Future
- Make UI editable

## License
Distributed under the Eclipse Public License, the same as Clojure.
