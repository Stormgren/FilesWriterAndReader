Path is an interface

Path is not a file!

File is a class from Java 1 that models files

Path is an interface from Java 7

A File is independent from the file system

It is created on a String

Where a path is attached to a file system

It is created from a FileSystem

Path is used to access a file or a directory on a specific system

A Path gives information on a path:

- its elements

- if is a symbolic link or not

The factory methods from files give you more informations

There are two patterns to create a path:

- from the Paths factory class (Java 7)

- from the Path.of() factory methods (since Java 11)

From the Paths factory class, there are two get methods:

- that takes a path as a String, or a vararg of paths
  `Path p1 = Paths.get("c:/tmp/debug.log");
  Path p2 = Paths.get("c:", "tmp", "debug.log");`

- a URI as a String
  `URI uri = URI.create("file://c:/tmp/debug.log");
  Path p3 = Paths.get(uri);`

- Since Java 11: Path.of is direclty avaiable
  `Path p4 = Path.of("c:/tmp/debug.log")`

The Files factory class has the methods to check:

- if it exists or not

- if it is hidden

- if the path is a file or a directory

- if it is readable or writeable 

- if it is executable

`Path path = Paths.get("c:/tmp/debug.log");`

`boolean exists = Files.exists(path);`

These methods may take a further argument: NOFOLLOW_LINKS meaning that the API can check if a path contains symbolic links 

`boolean exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);`

You can check if two paths actially locate the same file

`boolean sameFile = Files.isSameFile(path1, path2);`

//////// 

Binary files are about storing bytes

Your app makes sense of them

Text files are about storing characters

And there are many ways to encode them



For text files

`Reader Writer`

for binary files

`InputStream` to read the binary files

`OutputStream` to write the binary files



Read text from file

One simple pattern:

- get a BufferedReader

- use it to read your file line by line

`Path path = Paths.get("c:/tmp/sonnet.txt");`

 `BufferedReader reader = Files.newBufferedReader(path);`

`String line = reader.readLine();`

read a content of that file line by line, returns null if there is none



Write text to file

- Get a BufferedWriter

- use it to write to your file

`Path path = Paths.get("c:/tmp/sonnet.txt");`

`BufferedWriter writer = Files.newBufferedWriter(path);`

`writer.write("Hwllo world!");`

issues:

- file may already be there

- flush the buffer before closing it -flushing and closing,  if you dont do that you will have missing content on your file





All the resources you need to use need to be open in try block as part of the try with resources pattern

in 




