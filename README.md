# anti-cp-task-plugin
This plugin adds button to the toolbar to show AST for selected piece of code.<br>
There is an alert message shown when user pastes text into editor.<br>

## Build and Run
Following command will build and run IntelliJ IDEA with activated plugin:<br>
```./gradlew runIde```

## Usage
### AST for selected code
Select piece of code and press plugin button in the toolbar.
### AntiCopyPaster warning
Warning message will be shown automatically when user will paste into editor.

## Implementation
AST button added to the toolbar corresponds to a ```AnAction``` instance.
I used [JavaParser](https://javaparser.org/) library as it provides functionality to parse and print AST for a given text.<br>
I implemented ```CopyPastePreProcessor``` interface and added it to plugin extensions, so that warning message will be shown after every paste action.
