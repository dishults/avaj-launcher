/*

This file is necessary so that the following command would work:
    javac -sourcepath @sources.txt

Because normally there should be a dot, like so:
    javac -sourcepath . @sources.txt
Or:
    javac -sourcepath avaj @sources.txt

Because "@file" just expands the file for java compiler 
and lists all the entries. 
So the first entry from the file will be taken by sourcepath
which will use it as a reference for the path of where to look for sources. 
As a result the first file from sources.txt won't be compiled
and you will have lots of errors popping up.

So in order to successfully compile the project with the given command, 
this file is absolutely necessary.

After running:
    find * -name "*.java" > sources.txt
This file must always be at the top in sources.txt.

*/