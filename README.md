# avaj-launcher
Implementation of a simple Java program (aircraft simulation) based on a given UML class diagram

![image](https://github.com/dishults/avaj-launcher/blob/master/avaj_uml.png)

# UML
————>           inheritance (extends) "is-a"

\- - - - - -▶️   realization (impliments)

————<>          aggregation "part of"

————◀️▶️          comosition "has-a"

### Visibility

|  | Class | Package | Subclass (same pkg) | Subclass (diff pkg) | World  |
| --------- | ----- | ------- | -------- | -------- | ------ |
| + public                  | + | + | + | + | + |
| # protected               | + | + | + | + |  | 
| ~ package (no modifier)   | + | + | + |  |  |
| - private                 | + |  |  |  |  |

<ins>underlined</ins> -> static

### Multiplicity

`*` or `0..*`    0 or more

# Java
### Install JDK on Linux

    sudo apt update
    sudo apt install default-jdk-headless

### Uninstall

    sudo apt autoremove --purge packagename


### Compile

    find -name *.java > sources.txt
    javac -sourcepath @sources.txt

    Thought, normally, it should be:
      javac -sourcepath . @sources.txt
    or:
      javac -sourcepath fr @sources.txt

### Run

    java fr.school42.avaj.simulator.Simulator scenario.txt
  

### Compile for Older Platform Versions (Beginning with JDK 9)

    javac --release 7 -sourcepath . @sources.txt

### final
defines an entity that can only be assigned once.
Once a final variable has been assigned, it always contains the same value.

### static
belongs to the class, rather than a specific instance.
This means that only one instance of a static member exists, even if you create multiple objects of the class, or if you don’t create any. It will be shared by all objects.
>Can be accessed directly without creating an instance.

